package com.shix.shixipc.utils;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Bytes {
    public byte[] mBytes;
    public int mCap;

    public Bytes(int i2) {
        this.mCap = 0;
        this.mBytes = new byte[i2];
        this.mCap = i2;
    }

    public void cat(int i2, byte[] bArr, int i3, int i4) {
        byte[] bArr2 = this.mBytes;
        int i5 = i2 + i4;
        this.mCap = i5;
        this.mBytes = new byte[i5];
        for (int i6 = 0; i6 < i2; i6++) {
            this.mBytes[i6] = bArr2[i6];
        }
        for (int i7 = 0; i7 < i4; i7++) {
            this.mBytes[i7 + i2] = bArr[i7 + i3];
        }
    }

    public int length() {
        return this.mCap;
    }

    public int readInt16BE(int i2) {
        byte[] bArr = this.mBytes;
        if (bArr == null || this.mCap - i2 < 2) {
            return 0;
        }
        return (bArr[i2] << 8) + bArr[i2 + 1];
    }

    public int readInt16LE(int i2) {
        byte[] bArr = this.mBytes;
        if (bArr == null || this.mCap - i2 < 2) {
            return 0;
        }
        return (bArr[i2 + 1] << 8) + bArr[i2];
    }

    public long readInt32BE(int i2) {
        if (this.mBytes == null || this.mCap - i2 < 4) {
            return 0L;
        }
        return (r0[i2] << 24) + (r0[i2 + 1] << 16) + (r0[i2 + 2] << 8) + r0[i2 + 3];
    }

    public long readInt32LE(int i2) {
        if (this.mBytes == null || this.mCap - i2 < 4) {
            return 0L;
        }
        return (r0[i2 + 3] << 24) + (r0[i2 + 2] << 16) + (r0[i2 + 1] << 8) + r0[i2];
    }

    public int readUInt16BE(int i2) {
        byte[] bArr = this.mBytes;
        if (bArr == null || this.mCap - i2 < 2) {
            return 0;
        }
        return ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 8) + (bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE);
    }

    public int readUInt16LE(int i2) {
        byte[] bArr = this.mBytes;
        if (bArr == null || this.mCap - i2 < 2) {
            return 0;
        }
        return ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) << 8) + (bArr[i2] & ThreadUtils.TYPE_SINGLE);
    }

    public long readUInt32BE(int i2) {
        if (this.mBytes == null || this.mCap - i2 < 4) {
            return 0L;
        }
        return ((r0[i2] & 255) << 24) + ((255 & r0[i2 + 1]) << 16) + ((r0[i2 + 2] & 597) << 8) + (r0[i2 + 3] & 597);
    }

    public long readUInt32LE(int i2) {
        if (this.mBytes == null || this.mCap - i2 < 4) {
            return 0L;
        }
        return ((r0[i2 + 3] & 255) << 24) + ((255 & r0[i2 + 2]) << 16) + ((r0[i2 + 1] & 597) << 8) + (r0[i2] & 597);
    }

    public byte[] toBytes() {
        return this.mBytes;
    }

    public String toHexString(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.mCap; i2++) {
            stringBuffer.append(String.format("%s%02x%s", str, Byte.valueOf(this.mBytes[i2]), str2));
        }
        return stringBuffer.substring(0, stringBuffer.length() - str2.length());
    }

    public String toString() {
        return "Bytes{length=" + this.mCap + ", data=" + Arrays.toString(this.mBytes) + '}';
    }

    public int readInt16BE() {
        return readInt16BE(0);
    }

    public int readInt16LE() {
        return readInt16LE(0);
    }

    public long readInt32BE() {
        return readInt32BE(0);
    }

    public long readInt32LE() {
        return readInt32LE(0);
    }

    public int readUInt16BE() {
        return readUInt16BE(0);
    }

    public int readUInt16LE() {
        return readUInt16LE(0);
    }

    public long readUInt32BE() {
        return readUInt32BE(0);
    }

    public long readUInt32LE() {
        return readUInt32LE(0);
    }

    public Bytes() {
        this.mCap = 0;
        this.mBytes = new byte[4];
        this.mCap = 4;
    }

    public String toHexString(String str) {
        return toHexString("", str);
    }

    public void cat(byte[] bArr, int i2, int i3) {
        cat(this.mCap, bArr, i2, i3);
    }

    public String toHexString() {
        return toHexString("");
    }

    public void cat(byte[] bArr, int i2) {
        cat(bArr, i2, bArr.length - i2);
    }

    public void cat(byte[] bArr) {
        cat(bArr, 0);
    }

    public Bytes(byte[] bArr) {
        this.mCap = 0;
        this.mBytes = bArr;
        this.mCap = bArr.length;
    }

    public Bytes(int[] iArr) {
        this.mCap = 0;
        int length = iArr.length;
        this.mCap = length;
        this.mBytes = new byte[length];
        for (int i2 = 0; i2 < this.mCap; i2++) {
            if (iArr[i2] > 255) {
                this.mBytes[i2] = -1;
            } else {
                this.mBytes[i2] = (byte) (255 & iArr[i2]);
            }
        }
    }
}
