package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    public static final byte[] EMPTY = new byte[0];
    public static final int LUMINANCE_BITS = 5;
    public static final int LUMINANCE_BUCKETS = 32;
    public static final int LUMINANCE_SHIFT = 3;
    public final int[] buckets;
    public byte[] luminances;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    public static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i6) {
                i7 = i8;
                i6 = i10;
            }
        }
        if (i4 <= i7) {
            int i11 = i4;
            i4 = i7;
            i7 = i11;
        }
        if (i4 - i7 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i4 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i7) {
            int i15 = i12 - i7;
            int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }

    private void initArrays(int i2) {
        if (this.luminances.length < i2) {
            this.luminances = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.buckets[i3] = 0;
        }
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] row = luminanceSource.getRow((height * i2) / 5, this.luminances);
            int i3 = (width * 4) / 5;
            for (int i4 = width / 5; i4 < i3; i4++) {
                int i5 = (row[i4] & ThreadUtils.TYPE_SINGLE) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                if ((matrix[i7 + i8] & ThreadUtils.TYPE_SINGLE) < estimateBlackPoint) {
                    bitMatrix.set(i8, i6);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Binarizer
    public BitArray getBlackRow(int i2, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i2, this.luminances);
        int[] iArr = this.buckets;
        for (int i3 = 0; i3 < width; i3++) {
            int i4 = (row[i3] & ThreadUtils.TYPE_SINGLE) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i5 = 0; i5 < width; i5++) {
                if ((row[i5] & ThreadUtils.TYPE_SINGLE) < estimateBlackPoint) {
                    bitArray.set(i5);
                }
            }
        } else {
            int i6 = 1;
            int i7 = row[0] & ThreadUtils.TYPE_SINGLE;
            int i8 = row[1] & ThreadUtils.TYPE_SINGLE;
            while (i6 < width - 1) {
                int i9 = i6 + 1;
                int i10 = row[i9] & ThreadUtils.TYPE_SINGLE;
                if ((((i8 * 4) - i7) - i10) / 2 < estimateBlackPoint) {
                    bitArray.set(i6);
                }
                i7 = i8;
                i6 = i9;
                i8 = i10;
            }
        }
        return bitArray;
    }
}
