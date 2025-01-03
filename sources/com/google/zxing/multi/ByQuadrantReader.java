package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* loaded from: classes.dex */
public final class ByQuadrantReader implements Reader {
    public final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    public static void makeAbsolute(ResultPoint[] resultPointArr, int i2, int i3) {
        if (resultPointArr != null) {
            for (int i4 = 0; i4 < resultPointArr.length; i4++) {
                ResultPoint resultPoint = resultPointArr[i4];
                resultPointArr[i4] = new ResultPoint(resultPoint.getX() + i2, resultPoint.getY() + i3);
            }
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            try {
                try {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                    } catch (NotFoundException unused) {
                        Result decode = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                        makeAbsolute(decode.getResultPoints(), width, 0);
                        return decode;
                    }
                } catch (NotFoundException unused2) {
                    Result decode2 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                    makeAbsolute(decode2.getResultPoints(), 0, height);
                    return decode2;
                }
            } catch (NotFoundException unused3) {
                Result decode3 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                makeAbsolute(decode3.getResultPoints(), width, height);
                return decode3;
            }
        } catch (NotFoundException unused4) {
            int i2 = width / 2;
            int i3 = height / 2;
            Result decode4 = this.delegate.decode(binaryBitmap.crop(i2, i3, width, height), map);
            makeAbsolute(decode4.getResultPoints(), i2, i3);
            return decode4;
        }
    }
}
