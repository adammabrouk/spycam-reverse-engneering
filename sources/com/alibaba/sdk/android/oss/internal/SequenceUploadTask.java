package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    public List<Integer> mAlreadyUploadIndex;
    public File mCRC64RecordFile;
    public long mFirstPartSize;
    public File mRecordFile;
    public OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap hashMap = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        hashMap.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            this.mCRC64RecordFile = file2;
                            if (!file2.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                            try {
                                objectOutputStream2.writeObject(hashMap);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                super.checkException();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0180 A[Catch: ClientException -> 0x01eb, ServiceException -> 0x01ed, TryCatch #6 {ClientException -> 0x01eb, ServiceException -> 0x01ed, blocks: (B:34:0x0167, B:35:0x017a, B:37:0x0180, B:39:0x019c, B:41:0x01a2, B:43:0x01b0, B:44:0x01c5, B:46:0x01e2), top: B:33:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023b  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0163 A[Catch: all -> 0x01ba, TryCatch #17 {all -> 0x01ba, blocks: (B:16:0x007b, B:18:0x0093, B:20:0x00c3, B:21:0x00ce, B:23:0x00e7, B:32:0x0102, B:33:0x0116, B:36:0x015b, B:38:0x0163, B:47:0x0167, B:49:0x0181, B:50:0x019f), top: B:15:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ac A[Catch: IOException -> 0x0143, TRY_ENTER, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b1 A[Catch: IOException -> 0x0143, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b6 A[Catch: IOException -> 0x0143, TRY_LEAVE, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0167 A[Catch: all -> 0x01ba, TryCatch #17 {all -> 0x01ba, blocks: (B:16:0x007b, B:18:0x0093, B:20:0x00c3, B:21:0x00ce, B:23:0x00e7, B:32:0x0102, B:33:0x0116, B:36:0x015b, B:38:0x0163, B:47:0x0167, B:49:0x0181, B:50:0x019f), top: B:15:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013f A[Catch: IOException -> 0x0143, TRY_ENTER, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147 A[Catch: IOException -> 0x0143, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014c A[Catch: IOException -> 0x0143, TRY_LEAVE, TryCatch #14 {IOException -> 0x0143, blocks: (B:25:0x00f3, B:27:0x00f8, B:29:0x00fd, B:58:0x013f, B:60:0x0147, B:62:0x014c, B:40:0x01ac, B:42:0x01b1, B:44:0x01b6), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c7 A[Catch: IOException -> 0x01c3, TryCatch #13 {IOException -> 0x01c3, blocks: (B:81:0x01bf, B:70:0x01c7, B:72:0x01cc), top: B:80:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cc A[Catch: IOException -> 0x01c3, TRY_LEAVE, TryCatch #13 {IOException -> 0x01c3, blocks: (B:81:0x01bf, B:70:0x01c7, B:72:0x01cc), top: B:80:0x01bf }] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long j2 = this.mUploadedLength;
            if (j2 > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i2) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j3 = j2;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i4 + 1))) {
                if (i4 == i3 - 1) {
                    i2 = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i2);
                j += (long) i2;
                uploadPart(i4, i2, i3);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }
}
