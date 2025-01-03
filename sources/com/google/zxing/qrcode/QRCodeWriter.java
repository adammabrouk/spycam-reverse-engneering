package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* loaded from: classes.dex */
public final class QRCodeWriter implements Writer {
    public static final int QUIET_ZONE_SIZE = 4;

    public static BitMatrix renderResult(QRCode qRCode, int i2, int i3, int i4) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i5 = i4 * 2;
        int i6 = width + i5;
        int i7 = i5 + height;
        int max = Math.max(i2, i6);
        int max2 = Math.max(i3, i7);
        int min = Math.min(max / i6, max2 / i7);
        int i8 = (max - (width * min)) / 2;
        int i9 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i10 = 0;
        while (i10 < height) {
            int i11 = i8;
            int i12 = 0;
            while (i12 < width) {
                if (matrix.get(i12, i10) == 1) {
                    bitMatrix.setRegion(i11, i9, min, min);
                }
                i12++;
                i11 += min;
            }
            i10++;
            i9 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return encode(str, barcodeFormat, i2, i3, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int i4 = 4;
        if (map != null) {
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i4 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
        }
        return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i2, i3, i4);
    }
}
