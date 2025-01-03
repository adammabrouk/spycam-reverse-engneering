package com.alibaba.sdk.android.oss.common.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.lang.reflect.Array;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public class CRC64 implements Checksum {
    public static final int GF2_DIM = 64;
    public static final long POLY = -3932672073523589310L;
    public static final long[][] table = (long[][]) Array.newInstance((Class<?>) long.class, 8, RecyclerView.c0.FLAG_TMP_DETACHED);
    public long value = 0;

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            long j = i2;
            for (int i3 = 0; i3 < 8; i3++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ POLY : j >>> 1;
            }
            table[0][i2] = j;
        }
        for (int i4 = 0; i4 < 256; i4++) {
            long j2 = table[0][i4];
            for (int i5 = 1; i5 < 8; i5++) {
                long[][] jArr = table;
                j2 = (j2 >>> 8) ^ jArr[0][(int) (255 & j2)];
                jArr[i5][i4] = j2;
            }
        }
    }

    public static long combine(long j, long j2, long j3) {
        if (j3 == 0) {
            return j;
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j4 = 1;
        for (int i2 = 1; i2 < 64; i2++) {
            jArr2[i2] = j4;
            j4 <<= 1;
        }
        gf2MatrixSquare(jArr, jArr2);
        gf2MatrixSquare(jArr2, jArr);
        long j5 = j;
        long j6 = j3;
        do {
            gf2MatrixSquare(jArr, jArr2);
            if ((j6 & 1) == 1) {
                j5 = gf2MatrixTimes(jArr, j5);
            }
            long j7 = j6 >>> 1;
            if (j7 == 0) {
                break;
            }
            gf2MatrixSquare(jArr2, jArr);
            if ((j7 & 1) == 1) {
                j5 = gf2MatrixTimes(jArr2, j5);
            }
            j6 = j7 >>> 1;
        } while (j6 != 0);
        return j5 ^ j2;
    }

    public static void gf2MatrixSquare(long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < 64; i2++) {
            jArr[i2] = gf2MatrixTimes(jArr2, jArr2[i2]);
        }
    }

    public static long gf2MatrixTimes(long[] jArr, long j) {
        int i2 = 0;
        long j2 = 0;
        while (j != 0) {
            if ((j & 1) == 1) {
                j2 ^= jArr[i2];
            }
            j >>>= 1;
            i2++;
        }
        return j2;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.value;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.value = 0L;
    }

    @Override // java.util.zip.Checksum
    public void update(int i2) {
        update(new byte[]{(byte) (i2 & ViewfinderView.OPAQUE)}, 1);
    }

    public void update(byte[] bArr, int i2) {
        update(bArr, 0, i2);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i2, int i3) {
        this.value ^= -1;
        int i4 = i2;
        int i5 = i3;
        while (i5 >= 8) {
            long[][] jArr = table;
            long[] jArr2 = jArr[7];
            long j = this.value;
            this.value = ((((((jArr2[(int) ((bArr[i4] & ThreadUtils.TYPE_SINGLE) ^ (j & 255))] ^ jArr[6][(int) ((bArr[i4 + 1] & ThreadUtils.TYPE_SINGLE) ^ ((j >>> 8) & 255))]) ^ jArr[5][(int) (((j >>> 16) & 255) ^ (bArr[i4 + 2] & ThreadUtils.TYPE_SINGLE))]) ^ jArr[4][(int) (((j >>> 24) & 255) ^ (bArr[i4 + 3] & ThreadUtils.TYPE_SINGLE))]) ^ jArr[3][(int) (((j >>> 32) & 255) ^ (bArr[i4 + 4] & ThreadUtils.TYPE_SINGLE))]) ^ jArr[2][(int) (((j >>> 40) & 255) ^ (bArr[i4 + 5] & ThreadUtils.TYPE_SINGLE))]) ^ jArr[1][(int) (((j >>> 48) & 255) ^ (bArr[i4 + 6] & ThreadUtils.TYPE_SINGLE))]) ^ jArr[0][(int) ((j >>> 56) ^ (bArr[i4 + 7] & ThreadUtils.TYPE_SINGLE))];
            i4 += 8;
            i5 -= 8;
        }
        while (i5 > 0) {
            long[] jArr3 = table[0];
            long j2 = this.value;
            this.value = (j2 >>> 8) ^ jArr3[(int) ((bArr[i4] ^ j2) & 255)];
            i4++;
            i5--;
        }
        this.value ^= -1;
    }
}
