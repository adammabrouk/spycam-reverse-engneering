package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public class CheckCRC64DownloadInputStream extends CheckedInputStream {
    public long mClientCRC64;
    public String mRequestId;
    public long mServerCRC64;
    public long mTotalBytesRead;
    public long mTotalLength;

    public CheckCRC64DownloadInputStream(InputStream inputStream, Checksum checksum, long j, long j2, String str) {
        super(inputStream, checksum);
        this.mTotalLength = j;
        this.mServerCRC64 = j2;
        this.mRequestId = str;
    }

    private void checkCRC64(int i2) throws IOException {
        long j = this.mTotalBytesRead + i2;
        this.mTotalBytesRead = j;
        if (j >= this.mTotalLength) {
            long value = getChecksum().getValue();
            this.mClientCRC64 = value;
            OSSUtils.checkChecksum(Long.valueOf(value), Long.valueOf(this.mServerCRC64), this.mRequestId);
        }
    }

    public long getClientCRC64() {
        return this.mClientCRC64;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        checkCRC64(read);
        return read;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        checkCRC64(read);
        return read;
    }
}
