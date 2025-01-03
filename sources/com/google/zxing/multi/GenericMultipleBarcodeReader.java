package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    public static final int MAX_DEPTH = 4;
    public static final int MIN_DIMENSION_TO_RECUR = 100;
    public final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        float f3;
        int i5;
        int i6;
        float x;
        if (i4 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getText().equals(decode.getText())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                list.add(translateResultPoints(decode, i2, i3));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f4 = width;
            int length = resultPoints.length;
            float f5 = height;
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i7 = 0;
            while (i7 < length) {
                int i8 = height;
                int i9 = width;
                int i10 = i7;
                float f8 = f5;
                float f9 = f6;
                ResultPoint resultPoint = resultPoints[i10];
                if (resultPoint == null) {
                    x = f9;
                } else {
                    x = resultPoint.getX();
                    float y = resultPoint.getY();
                    if (x < f4) {
                        f4 = x;
                    }
                    if (y < f8) {
                        f8 = y;
                    }
                    if (x <= f9) {
                        x = f9;
                    }
                    if (y > f7) {
                        f5 = f8;
                        f7 = y;
                        i7 = i10 + 1;
                        height = i8;
                        width = i9;
                        f6 = x;
                    }
                }
                f5 = f8;
                i7 = i10 + 1;
                height = i8;
                width = i9;
                f6 = x;
            }
            if (f4 > 100.0f) {
                f2 = f6;
                f3 = f5;
                i5 = height;
                i6 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f4, height), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f6;
                f3 = f5;
                i5 = height;
                i6 = width;
            }
            if (f3 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, i6, (int) f3), map, list, i2, i3, i4 + 1);
            }
            float f10 = f2;
            if (f10 < i6 - 100) {
                int i11 = (int) f10;
                doDecodeMultiple(binaryBitmap.crop(i11, 0, i6 - i11, i5), map, list, i2 + i11, i3, i4 + 1);
            }
            if (f7 < i5 - 100) {
                int i12 = (int) f7;
                doDecodeMultiple(binaryBitmap.crop(0, i12, i6, i5 - i12), map, list, i2, i3 + i12, 1 + i4);
            }
        } catch (ReaderException unused) {
        }
    }

    public static Result translateResultPoints(Result result, int i2, int i3) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i4 = 0; i4 < resultPoints.length; i4++) {
            ResultPoint resultPoint = resultPoints[i4];
            if (resultPoint != null) {
                resultPointArr[i4] = new ResultPoint(resultPoint.getX() + i2, resultPoint.getY() + i3);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }
}
