package com.alibaba.sdk.android.oss.internal;

import android.util.Log;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.model.GetObjectMetaRequest;
import com.alibaba.sdk.android.oss.model.GetObjectMetaResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Range;
import com.alibaba.sdk.android.oss.model.ResumableDownloadRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ResumableDownloadTask<Requst extends ResumableDownloadRequest, Result extends ResumableDownloadResult> implements Callable<Result> {
    public static final String TEMP_SUFFIX = ".temp";
    public final int CPU_SIZE;
    public final int KEEP_ALIVE_TIME;
    public final int MAX_CORE_POOL_SIZE;
    public final int MAX_IMUM_POOL_SIZE;
    public final int MAX_QUEUE_SIZE;
    public final int PART_SIZE_ALIGN_NUM;
    public String checkpointPath;
    public long completedPartSize;
    public long downloadPartSize;
    public CheckPoint mCheckPoint;
    public OSSCompletedCallback mCompletedCallback;
    public ExecutionContext mContext;
    public Exception mDownloadException;
    public Object mLock;
    public InternalRequestOperation mOperation;
    public long mPartExceptionCount;
    public ThreadPoolExecutor mPoolExecutor;
    public OSSProgressCallback mProgressCallback;
    public ResumableDownloadRequest mRequest;

    public static class CheckPoint implements Serializable {
        public static final long serialVersionUID = -8470273912385636504L;
        public String bucketName;
        public String downloadFile;
        public long downloadLength;
        public FileStat fileStat;
        public int md5;
        public String objectKey;
        public ArrayList<DownloadPart> parts;

        private void assign(CheckPoint checkPoint) {
            this.md5 = checkPoint.md5;
            this.downloadFile = checkPoint.downloadFile;
            this.bucketName = checkPoint.bucketName;
            this.objectKey = checkPoint.objectKey;
            this.fileStat = checkPoint.fileStat;
            this.parts = checkPoint.parts;
            this.downloadLength = checkPoint.downloadLength;
        }

        public synchronized void dump(String str) throws IOException {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            this.md5 = hashCode();
            File file = new File(str + ResumableDownloadTask.TEMP_SUFFIX);
            ObjectOutputStream objectOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    objectOutputStream.writeObject(this);
                    file.renameTo(new File(str));
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }

        public int hashCode() {
            String str = this.bucketName;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.downloadFile;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.objectKey;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            FileStat fileStat = this.fileStat;
            int hashCode4 = (hashCode3 + (fileStat == null ? 0 : fileStat.hashCode())) * 31;
            ArrayList<DownloadPart> arrayList = this.parts;
            int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
            long j = this.downloadLength;
            return hashCode5 + ((int) (j ^ (j >>> 32)));
        }

        public synchronized boolean isValid(InternalRequestOperation internalRequestOperation) throws ClientException, ServiceException {
            if (this.md5 != hashCode()) {
                return false;
            }
            FileStat fileStat = FileStat.getFileStat(internalRequestOperation, this.bucketName, this.objectKey);
            if (this.fileStat.lastModified == null) {
                if (this.fileStat.fileLength != fileStat.fileLength || !this.fileStat.etag.equals(fileStat.etag)) {
                    return false;
                }
            } else if (this.fileStat.fileLength != fileStat.fileLength || !this.fileStat.lastModified.equals(fileStat.lastModified) || !this.fileStat.etag.equals(fileStat.etag)) {
                return false;
            }
            return true;
        }

        public synchronized void load(String str) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream;
            Throwable th;
            ObjectInputStream objectInputStream;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream = null;
                    }
                    try {
                        assign((CheckPoint) objectInputStream.readObject());
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    fileInputStream = null;
                    th = th4;
                    objectInputStream = null;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }

        public synchronized void update(int i2, boolean z) throws IOException {
            this.parts.get(i2).isCompleted = z;
            this.downloadLength += this.parts.get(i2).length;
        }
    }

    public class DownloadFileResult extends OSSResult {
        public ObjectMetadata metadata;
        public ArrayList<DownloadPartResult> partResults;

        public DownloadFileResult() {
        }
    }

    public static class DownloadPart implements Serializable {
        public static final long serialVersionUID = -3506020776131733942L;
        public long crc;
        public long end;
        public long fileStart;
        public boolean isCompleted;
        public long length;
        public int partNumber;
        public long start;

        public int hashCode() {
            int i2 = (((this.partNumber + 31) * 31) + (this.isCompleted ? 1231 : 1237)) * 31;
            long j = this.end;
            int i3 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.start;
            long j3 = this.crc;
            return ((i3 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    public static class DownloadPartResult {
        public Long clientCRC;
        public long length;
        public int partNumber;
        public String requestId;
    }

    public static class FileStat implements Serializable {
        public static final long serialVersionUID = 3896323364904643963L;
        public String etag;
        public long fileLength;
        public Date lastModified;
        public String md5;
        public String requestId;
        public Long serverCRC;

        public static FileStat getFileStat(InternalRequestOperation internalRequestOperation, String str, String str2) throws ClientException, ServiceException {
            GetObjectMetaResult result = internalRequestOperation.getObjectMeta(new GetObjectMetaRequest(str, str2), null).getResult();
            FileStat fileStat = new FileStat();
            fileStat.fileLength = result.getMetadata().getContentLength();
            fileStat.etag = result.getMetadata().getETag();
            fileStat.lastModified = result.getMetadata().getLastModified();
            fileStat.serverCRC = result.getServerCRC();
            fileStat.requestId = result.getRequestId();
            return fileStat;
        }

        public int hashCode() {
            String str = this.etag;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Date date = this.lastModified;
            int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
            long j = this.fileLength;
            return hashCode2 + ((int) (j ^ (j >>> 32)));
        }
    }

    public ResumableDownloadTask(InternalRequestOperation internalRequestOperation, ResumableDownloadRequest resumableDownloadRequest, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        this.MAX_CORE_POOL_SIZE = availableProcessors >= 5 ? 5 : availableProcessors;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = AddCameraActivity.SEARCH_TIME;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.MAX_QUEUE_SIZE = LogThreadPoolManager.TIME_KEEP_ALIVE;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, NetworkUtils.SCAN_PERIOD_MILLIS, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(LogThreadPoolManager.TIME_KEEP_ALIVE), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mLock = new Object();
        this.mRequest = resumableDownloadRequest;
        this.mOperation = internalRequestOperation;
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mProgressCallback = resumableDownloadRequest.getProgressListener();
    }

    public static Long calcObjectCRCFromParts(List<DownloadPartResult> list) {
        long j = 0;
        for (DownloadPartResult downloadPartResult : list) {
            Long l = downloadPartResult.clientCRC;
            if (l == null || downloadPartResult.length <= 0) {
                return null;
            }
            j = CRC64.combine(j, l.longValue(), downloadPartResult.length);
        }
        return new Long(j);
    }

    private long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    private void checkPartSize(long j, int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + j);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j2 = j / partSize;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 != 1) {
            if (j2 > LogThreadPoolManager.TIME_KEEP_ALIVE) {
                partSize = ceilPartSize(j / 4999);
                j2 = (j / partSize) + (j % partSize == 0 ? 0L : 1L);
            }
            j = partSize;
        }
        int i2 = (int) j;
        iArr[0] = i2;
        iArr[1] = (int) j2;
        OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private Range correctRange(Range range, long j) {
        if (range != null) {
            r0 = range.getBegin() != -1 ? range.getBegin() : 0L;
            j = range.getEnd() == -1 ? j - r0 : range.getEnd() - range.getBegin();
        }
        return new Range(r0, j + r0);
    }

    private void createFile(String str, long j) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "rw");
        } catch (Throwable th2) {
            randomAccessFile = null;
            th = th2;
        }
        try {
            randomAccessFile.setLength(j);
            randomAccessFile.close();
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018b A[Catch: IOException -> 0x0187, TRY_LEAVE, TryCatch #1 {IOException -> 0x0187, blocks: (B:73:0x0183, B:66:0x018b), top: B:72:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask<Requst, Result>.DownloadFileResult r13, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart r14) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPart):void");
    }

    private void initCheckPoint() throws ClientException, ServiceException, IOException {
        FileStat fileStat = FileStat.getFileStat(this.mOperation, this.mRequest.getBucketName(), this.mRequest.getObjectKey());
        Range correctRange = correctRange(this.mRequest.getRange(), fileStat.fileLength);
        createFile(this.mRequest.getTempFilePath(), correctRange.getEnd() - correctRange.getBegin());
        this.mCheckPoint.bucketName = this.mRequest.getBucketName();
        this.mCheckPoint.objectKey = this.mRequest.getObjectKey();
        CheckPoint checkPoint = this.mCheckPoint;
        checkPoint.fileStat = fileStat;
        checkPoint.parts = splitFile(correctRange, fileStat.fileLength, this.mRequest.getPartSize());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void moveFile(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r5.renameTo(r6)
            if (r0 != 0) goto L62
            java.lang.String r0 = "moveFile"
            java.lang.String r1 = "rename"
            android.util.Log.i(r0, r1)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50 java.io.FileNotFoundException -> L53
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L50 java.io.FileNotFoundException -> L53
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4c
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L48 java.io.FileNotFoundException -> L4c
            r4.copyFile(r1, r2)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            boolean r6 = r5.delete()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            if (r6 == 0) goto L28
            r1.close()
            r2.close()
            goto L62
        L28:
            java.io.IOException r6 = new java.io.IOException     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r0.<init>()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r3 = "Failed to delete original file '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r0.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r5 = "'"
            r0.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
            throw r6     // Catch: java.lang.Throwable -> L44 java.io.FileNotFoundException -> L46
        L44:
            r5 = move-exception
            goto L4a
        L46:
            r5 = move-exception
            goto L4e
        L48:
            r5 = move-exception
            r2 = r0
        L4a:
            r0 = r1
            goto L57
        L4c:
            r5 = move-exception
            r2 = r0
        L4e:
            r0 = r1
            goto L55
        L50:
            r5 = move-exception
            r2 = r0
            goto L57
        L53:
            r5 = move-exception
            r2 = r0
        L55:
            throw r5     // Catch: java.lang.Throwable -> L56
        L56:
            r5 = move-exception
        L57:
            if (r0 == 0) goto L5c
            r0.close()
        L5c:
            if (r2 == 0) goto L61
            r2.close()
        L61:
            throw r5
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.moveFile(java.io.File, java.io.File):void");
    }

    private ArrayList<DownloadPart> splitFile(Range range, long j, long j2) {
        long j3;
        int i2 = 0;
        if (j <= 0) {
            DownloadPart downloadPart = new DownloadPart();
            downloadPart.start = 0L;
            downloadPart.end = -1L;
            downloadPart.length = 0L;
            downloadPart.partNumber = 0;
            ArrayList<DownloadPart> arrayList = new ArrayList<>();
            arrayList.add(downloadPart);
            return arrayList;
        }
        long begin = range.getBegin();
        long end = range.getEnd() - range.getBegin();
        int[] iArr = new int[2];
        checkPartSize(end, iArr);
        long j4 = iArr[0];
        long j5 = iArr[1];
        ArrayList<DownloadPart> arrayList2 = new ArrayList<>();
        while (true) {
            long j6 = i2;
            if (j6 >= j5) {
                return arrayList2;
            }
            DownloadPart downloadPart2 = new DownloadPart();
            long j7 = j6 * j4;
            long j8 = begin + j7;
            downloadPart2.start = j8;
            int i3 = i2 + 1;
            long j9 = j5;
            long j10 = ((i3 * j4) + begin) - 1;
            downloadPart2.end = j10;
            long j11 = j4;
            downloadPart2.length = (j10 - j8) + 1;
            long j12 = begin + end;
            if (j10 >= j12) {
                j3 = -1;
                downloadPart2.end = -1L;
                downloadPart2.length = j12 - j8;
            } else {
                j3 = -1;
            }
            downloadPart2.partNumber = i2;
            downloadPart2.fileStart = j7;
            arrayList2.add(downloadPart2);
            i2 = i3;
            j4 = j11;
            j5 = j9;
        }
    }

    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("Resumable download cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mDownloadException != null) {
            releasePool();
            Exception exc = this.mDownloadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(this.mDownloadException.getMessage(), this.mDownloadException);
            }
            throw ((ClientException) exc);
        }
    }

    public void checkInitData() throws ClientException, ServiceException, IOException {
        if (this.mRequest.getRange() != null && !this.mRequest.getRange().checkIsValid()) {
            throw new ClientException("Range is invalid");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRequest.getBucketName());
        sb.append(this.mRequest.getObjectKey());
        sb.append(String.valueOf(this.mRequest.getPartSize()));
        sb.append(this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES ? "-crc64" : "");
        this.checkpointPath = this.mRequest.getCheckPointFilePath() + File.separator + BinaryUtil.calculateMd5Str(sb.toString().getBytes());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.checkpointPath);
        sb2.append(TEMP_SUFFIX);
        String sb3 = sb2.toString();
        this.mCheckPoint = new CheckPoint();
        if (!this.mRequest.getEnableCheckPoint().booleanValue()) {
            initCheckPoint();
            return;
        }
        try {
            this.mCheckPoint.load(this.checkpointPath);
        } catch (Exception unused) {
            removeFile(this.checkpointPath);
            removeFile(sb3);
            removeFile(this.mRequest.getTempFilePath());
        }
        if (this.mCheckPoint.isValid(this.mOperation)) {
            return;
        }
        removeFile(this.checkpointPath);
        removeFile(sb3);
        removeFile(this.mRequest.getTempFilePath());
        initCheckPoint();
    }

    public boolean checkWaitCondition(int i2) {
        return this.completedPartSize != ((long) i2);
    }

    public ResumableDownloadResult doMultipartDownload() throws ClientException, ServiceException, IOException, InterruptedException {
        String str = this.checkpointPath + TEMP_SUFFIX;
        checkCancel();
        ResumableDownloadResult resumableDownloadResult = new ResumableDownloadResult();
        final DownloadFileResult downloadFileResult = new DownloadFileResult();
        downloadFileResult.partResults = new ArrayList<>();
        Iterator<DownloadPart> it = this.mCheckPoint.parts.iterator();
        while (it.hasNext()) {
            final DownloadPart next = it.next();
            checkException();
            ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
            if (threadPoolExecutor == null || next.isCompleted) {
                DownloadPartResult downloadPartResult = new DownloadPartResult();
                downloadPartResult.partNumber = next.partNumber;
                downloadPartResult.requestId = this.mCheckPoint.fileStat.requestId;
                downloadPartResult.length = next.length;
                if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES) {
                    downloadPartResult.clientCRC = Long.valueOf(next.crc);
                }
                downloadFileResult.partResults.add(downloadPartResult);
                this.downloadPartSize++;
                this.completedPartSize++;
            } else {
                threadPoolExecutor.execute(new Runnable() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ResumableDownloadTask.this.downloadPart(downloadFileResult, next);
                        Log.i("partResults", "start: " + next.start + ", end: " + next.end);
                    }
                });
            }
        }
        if (checkWaitCondition(this.mCheckPoint.parts.size())) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        Collections.sort(downloadFileResult.partResults, new Comparator<DownloadPartResult>() { // from class: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.3
            @Override // java.util.Comparator
            public int compare(DownloadPartResult downloadPartResult2, DownloadPartResult downloadPartResult3) {
                return downloadPartResult2.partNumber - downloadPartResult3.partNumber;
            }
        });
        if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES && this.mRequest.getRange() == null) {
            Long calcObjectCRCFromParts = calcObjectCRCFromParts(downloadFileResult.partResults);
            resumableDownloadResult.setClientCRC(calcObjectCRCFromParts);
            try {
                OSSUtils.checkChecksum(calcObjectCRCFromParts, this.mCheckPoint.fileStat.serverCRC, downloadFileResult.partResults.get(0).requestId);
            } catch (InconsistentException e2) {
                removeFile(this.checkpointPath);
                removeFile(str);
                removeFile(this.mRequest.getTempFilePath());
                throw e2;
            }
        }
        removeFile(this.checkpointPath);
        removeFile(str);
        moveFile(new File(this.mRequest.getTempFilePath()), new File(this.mRequest.getDownloadToFilePath()));
        resumableDownloadResult.setServerCRC(this.mCheckPoint.fileStat.serverCRC);
        resumableDownloadResult.setMetadata(downloadFileResult.metadata);
        resumableDownloadResult.setRequestId(downloadFileResult.partResults.get(0).requestId);
        resumableDownloadResult.setStatusCode(200);
        return resumableDownloadResult;
    }

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0L;
    }

    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mDownloadException == null) {
                this.mDownloadException = exc;
                this.mLock.notify();
            }
        }
    }

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    public boolean removeFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            Result result = (Result) doMultipartDownload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e2) {
            OSSCompletedCallback oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(this.mRequest, null, e2);
            }
            throw e2;
        } catch (Exception e3) {
            ClientException clientException = e3 instanceof ClientException ? (ClientException) e3 : new ClientException(e3.toString(), e3);
            OSSCompletedCallback oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }
}
