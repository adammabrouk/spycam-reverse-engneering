package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    public final int CPU_SIZE;
    public final int KEEP_ALIVE_TIME;
    public final int MAX_CORE_POOL_SIZE;
    public final int MAX_IMUM_POOL_SIZE;
    public final int MAX_QUEUE_SIZE;
    public final int PART_SIZE_ALIGN_NUM;
    public InternalRequestOperation mApiOperation;
    public boolean mCheckCRC64;
    public OSSCompletedCallback<Request, Result> mCompletedCallback;
    public ExecutionContext mContext;
    public long mFileLength;
    public boolean mIsCancel;
    public long mLastPartSize;
    public Object mLock;
    public int[] mPartAttr;
    public List<PartETag> mPartETags;
    public int mPartExceptionCount;
    public ThreadPoolExecutor mPoolExecutor;
    public OSSProgressCallback<Request> mProgressCallback;
    public Request mRequest;
    public int mRunPartTaskCount;
    public Exception mUploadException;
    public File mUploadFile;
    public String mUploadFilePath;
    public String mUploadId;
    public Uri mUploadUri;
    public long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        this.MAX_CORE_POOL_SIZE = availableProcessors >= 5 ? 5 : availableProcessors;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = AddCameraActivity.SEARCH_TIME;
        this.MAX_QUEUE_SIZE = LogThreadPoolManager.TIME_KEEP_ALIVE;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, NetworkUtils.SCAN_PERIOD_MILLIS, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(LogThreadPoolManager.TIME_KEEP_ALIVE), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES;
    }

    public abstract void abortThisUpload();

    public long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
            throw ((ClientException) exc);
        }
    }

    public void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0L;
            File file = new File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                try {
                    parcelFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                    this.mFileLength = parcelFileDescriptor.getStatSize();
                } catch (IOException e2) {
                    throw new ClientException(e2.getMessage(), e2, true);
                }
            } finally {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
            }
        }
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i2 = this.mPartAttr[1];
        OSSLog.logDebug("[checkInitData] - partNumber : " + i2);
        OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i2 > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        long j2 = j / partSize;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 == 1) {
            partSize = this.mFileLength;
        } else if (j2 > LogThreadPoolManager.TIME_KEEP_ALIVE) {
            partSize = ceilPartSize(this.mFileLength / 4999);
            long j3 = this.mFileLength;
            j2 = (j3 / partSize) + (j3 % partSize == 0 ? 0L : 1L);
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = (int) j2;
        this.mRequest.setPartSize(i2);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
        long j4 = this.mFileLength % partSize;
        if (j4 != 0) {
            partSize = j4;
        }
        this.mLastPartSize = partSize;
    }

    public boolean checkWaitCondition(int i2) {
        return this.mPartETags.size() != i2;
    }

    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.2
                @Override // java.util.Comparator
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                for (String str : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!str.equals(OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(str, this.mRequest.getMetadata().getRawMetadata().get(str));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResult;
    }

    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }

    public void preUploadPart(int i2, int i3, int i4) throws Exception {
    }

    public abstract void processException(Exception exc);

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0153 A[Catch: IOException -> 0x0157, TRY_ENTER, TryCatch #0 {IOException -> 0x0157, blocks: (B:35:0x0120, B:37:0x0125, B:39:0x012a, B:57:0x0153, B:59:0x015b, B:61:0x0160), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015b A[Catch: IOException -> 0x0157, TryCatch #0 {IOException -> 0x0157, blocks: (B:35:0x0120, B:37:0x0125, B:39:0x012a, B:57:0x0153, B:59:0x015b, B:61:0x0160), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0160 A[Catch: IOException -> 0x0157, TRY_LEAVE, TryCatch #0 {IOException -> 0x0157, blocks: (B:35:0x0120, B:37:0x0125, B:39:0x012a, B:57:0x0153, B:59:0x015b, B:61:0x0160), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0174 A[Catch: IOException -> 0x0170, TryCatch #5 {IOException -> 0x0170, blocks: (B:80:0x016c, B:69:0x0174, B:71:0x0179), top: B:79:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0179 A[Catch: IOException -> 0x0170, TRY_LEAVE, TryCatch #5 {IOException -> 0x0170, blocks: (B:80:0x016c, B:69:0x0174, B:71:0x0179), top: B:79:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r15, int r16, int r17) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e2) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(this.mRequest, null, e2);
            }
            throw e2;
        } catch (Exception e3) {
            ClientException clientException = e3 instanceof ClientException ? (ClientException) e3 : new ClientException(e3.toString(), e3);
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }
}
