package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    public static final int BLOCK_SIZE = 8;
    public static final int BLOCK_SIZE_MASK = 7;
    public static final int BLOCK_SIZE_POWER = 3;
    public static final int MINIMUM_DIMENSION = 40;
    public static final int MIN_DYNAMIC_RANGE = 24;
    public BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public static int[][] calculateBlackPoints(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = i9 << 3;
            if (i10 > i7) {
                i10 = i7;
            }
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                if (i12 > i8) {
                    i12 = i8;
                }
                int i13 = (i10 * i4) + i12;
                int i14 = ViewfinderView.OPAQUE;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    int i18 = 24;
                    if (i15 >= i6) {
                        break;
                    }
                    int i19 = i17;
                    int i20 = 0;
                    while (i20 < i6) {
                        int i21 = bArr[i13 + i20] & ThreadUtils.TYPE_SINGLE;
                        i16 += i21;
                        if (i21 < i14) {
                            i14 = i21;
                        }
                        if (i21 > i19) {
                            i19 = i21;
                        }
                        i20++;
                        i6 = 8;
                        i18 = 24;
                    }
                    if (i19 - i14 > i18) {
                        int i22 = i13 + i4;
                        int i23 = i15 + 1;
                        while (i23 < i6) {
                            int i24 = 0;
                            while (i24 < i6) {
                                i16 += bArr[i22 + i24] & ThreadUtils.TYPE_SINGLE;
                                i24++;
                                i6 = 8;
                            }
                            i23++;
                            i22 += i4;
                        }
                        i13 = i22;
                        i15 = i23;
                    }
                    i15++;
                    i13 += i4;
                    i17 = i19;
                    i6 = 8;
                }
                int i25 = i16 >> 6;
                if (i17 - i14 <= 24) {
                    i25 = i14 / 2;
                    if (i9 > 0 && i11 > 0) {
                        int i26 = i9 - 1;
                        int i27 = i11 - 1;
                        int i28 = ((iArr[i26][i11] + (iArr[i9][i27] * 2)) + iArr[i26][i27]) / 4;
                        if (i14 < i28) {
                            i25 = i28;
                        }
                    }
                }
                iArr[i9][i11] = i25;
            }
        }
        return iArr;
    }

    public static void calculateThresholdForBlock(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, BitMatrix bitMatrix) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int cap = cap(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int cap2 = cap(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[cap + i15];
                    i14 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i13, i10, i14 / 25, i4, bitMatrix);
            }
        }
    }

    public static int cap(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void thresholdBlock(byte[] bArr, int i2, int i3, int i4, int i5, BitMatrix bitMatrix) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & ViewfinderView.OPAQUE) <= i4) {
                    bitMatrix.set(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i2 = width >> 3;
            if ((width & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = height >> 3;
            if ((height & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i3, i5, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i3, i5, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
