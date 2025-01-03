package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class OneDReader implements Reader {
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i2;
        Map<DecodeHintType, ?> map2;
        int i3;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        char c2 = 0;
        int i4 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z ? 8 : 5));
        int i5 = z ? height : 15;
        int i6 = height / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * max) + i6;
            if (i10 < 0 || i10 >= height) {
                break;
            }
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i10, bitArray);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        blackRow.reverse();
                        if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        Result decodeRow = decodeRow(i10, blackRow, map3);
                        if (i11 == i4) {
                            decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                            ResultPoint[] resultPoints = decodeRow.getResultPoints();
                            if (resultPoints != null) {
                                map2 = map3;
                                float f2 = width;
                                try {
                                    i3 = width;
                                } catch (ReaderException unused) {
                                    i3 = width;
                                    i11++;
                                    map3 = map2;
                                    width = i3;
                                    c2 = 0;
                                    i4 = 1;
                                }
                                try {
                                    resultPoints[0] = new ResultPoint((f2 - resultPoints[c2].getX()) - 1.0f, resultPoints[c2].getY());
                                } catch (ReaderException unused2) {
                                    i11++;
                                    map3 = map2;
                                    width = i3;
                                    c2 = 0;
                                    i4 = 1;
                                }
                                try {
                                    resultPoints[1] = new ResultPoint((f2 - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                } catch (ReaderException unused3) {
                                    continue;
                                    i11++;
                                    map3 = map2;
                                    width = i3;
                                    c2 = 0;
                                    i4 = 1;
                                }
                            }
                        }
                        return decodeRow;
                    } catch (ReaderException unused4) {
                        map2 = map3;
                    }
                }
                i2 = width;
                bitArray = blackRow;
            } catch (NotFoundException unused5) {
                i2 = width;
            }
            i7 = i8;
            width = i2;
            c2 = 0;
            i4 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    public static void recordPattern(BitArray bitArray, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i2 >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(i2);
        while (i2 < size) {
            if (bitArray.get(i2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z = !z;
            }
            i2++;
        }
        if (i3 != length) {
            if (i3 != length - 1 || i2 != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void recordPatternInReverse(BitArray bitArray, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (bitArray.get(i2) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i2 + 1, iArr);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    public abstract Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e2) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.isRotateSupported()) {
                throw e2;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(rotateCounterClockwise, map);
            Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
            int i2 = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                i2 = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % CameraManager.MAX_FRAME_HEIGHT;
            }
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i2));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            if (resultPoints != null) {
                int height = rotateCounterClockwise.getHeight();
                for (int i3 = 0; i3 < resultPoints.length; i3++) {
                    resultPoints[i3] = new ResultPoint((height - resultPoints[i3].getY()) - 1.0f, resultPoints[i3].getX());
                }
            }
            return doDecode;
        }
    }
}
