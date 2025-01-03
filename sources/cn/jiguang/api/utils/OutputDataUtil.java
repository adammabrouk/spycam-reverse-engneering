package cn.jiguang.api.utils;

import cn.jiguang.bi.d;
import com.google.zxing.view.ViewfinderView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class OutputDataUtil {
    public static final String TAG = "OutputDataUtil";
    public static final BigInteger TWO_64 = BigInteger.ONE.shiftLeft(64);
    public byte[] array;
    public int pos;
    public int saved_pos;

    public OutputDataUtil() {
        this(32);
    }

    public OutputDataUtil(int i2) {
        this.array = new byte[i2];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void check(long j, int i2) {
        long j2 = 1 << i2;
        if (j < 0 || j > j2) {
            d.c(TAG, j + " out of range for " + i2 + " bit value max:" + j2);
        }
    }

    public static int encodeZigZag32(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private void need(int i2) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i3 = this.pos;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(this.array, 0, bArr2, 0, this.pos);
        this.array = bArr2;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i2) {
        if (i2 > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i2;
    }

    public void restore() {
        int i2 = this.saved_pos;
        if (i2 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i2;
        this.saved_pos = -1;
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i2 = this.pos;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.array, 0, bArr, 0, i2);
        return bArr;
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeByteArray(byte[] bArr, int i2, int i3) {
        need(i3);
        System.arraycopy(bArr, i2, this.array, this.pos, i3);
        this.pos += i3;
    }

    public void writeByteArrayincludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i2 = this.pos;
        this.pos = i2 + 1;
        bArr2[i2] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeRawLittleEndian16(int i2) {
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
        this.pos = i4 + 1;
        bArr[i4] = (byte) ((i2 >> 8) & ViewfinderView.OPAQUE);
    }

    public void writeRawLittleEndian32(int i2) {
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
        int i5 = i4 + 1;
        this.pos = i5;
        bArr[i4] = (byte) ((i2 >> 8) & ViewfinderView.OPAQUE);
        int i6 = i5 + 1;
        this.pos = i6;
        bArr[i5] = (byte) ((i2 >> 16) & ViewfinderView.OPAQUE);
        this.pos = i6 + 1;
        bArr[i6] = (byte) ((i2 >> 24) & ViewfinderView.OPAQUE);
    }

    public void writeRawLittleEndian64(long j) {
        byte[] bArr = this.array;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) (((int) j) & ViewfinderView.OPAQUE);
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) (((int) (j >> 8)) & ViewfinderView.OPAQUE);
        int i5 = i4 + 1;
        this.pos = i5;
        bArr[i4] = (byte) (((int) (j >> 16)) & ViewfinderView.OPAQUE);
        int i6 = i5 + 1;
        this.pos = i6;
        bArr[i5] = (byte) (((int) (j >> 24)) & ViewfinderView.OPAQUE);
        int i7 = i6 + 1;
        this.pos = i7;
        bArr[i6] = (byte) (((int) (j >> 32)) & ViewfinderView.OPAQUE);
        int i8 = i7 + 1;
        this.pos = i8;
        bArr[i7] = (byte) (((int) (j >> 40)) & ViewfinderView.OPAQUE);
        int i9 = i8 + 1;
        this.pos = i9;
        bArr[i8] = (byte) (((int) (j >> 48)) & ViewfinderView.OPAQUE);
        this.pos = i9 + 1;
        bArr[i9] = (byte) (((int) (j >> 56)) & ViewfinderView.OPAQUE);
    }

    public void writeU16(int i2) {
        check(i2, 16);
        need(2);
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        this.pos = i4 + 1;
        bArr[i4] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void writeU16At(int i2, int i3) {
        check(i2, 16);
        if (i3 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i3] = (byte) ((i2 >>> 8) & ViewfinderView.OPAQUE);
        bArr[i3 + 1] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void writeU32(long j) {
        check(j, 32);
        need(4);
        byte[] bArr = this.array;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) ((j >>> 24) & 255);
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        int i5 = i4 + 1;
        this.pos = i5;
        bArr[i4] = (byte) ((j >>> 8) & 255);
        this.pos = i5 + 1;
        bArr[i5] = (byte) (j & 255);
    }

    public void writeU32At(long j, int i2) {
        check(j, 32);
        if (i2 > this.pos - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        bArr[i4] = (byte) ((j >>> 8) & 255);
        bArr[i4 + 1] = (byte) (j & 255);
    }

    public void writeU64(long j) {
        need(8);
        byte[] bArr = this.array;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        this.pos = i5;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        this.pos = i6;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        this.pos = i7;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        this.pos = i8;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        this.pos = i9;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        this.pos = i9 + 1;
        bArr[i9] = (byte) (j & 255);
    }

    public void writeU64At(long j, int i2) {
        byte[] bArr = this.array;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        bArr[i8] = (byte) ((j >>> 8) & 255);
        bArr[i8 + 1] = (byte) (j & 255);
    }

    public void writeU8(int i2) {
        check(i2, 8);
        need(1);
        byte[] bArr = this.array;
        int i3 = this.pos;
        this.pos = i3 + 1;
        bArr[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }

    public void writeU8At(int i2, int i3) {
        check(i2, 8);
        if (i3 > this.pos - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.array[i3] = (byte) (i2 & ViewfinderView.OPAQUE);
    }
}
