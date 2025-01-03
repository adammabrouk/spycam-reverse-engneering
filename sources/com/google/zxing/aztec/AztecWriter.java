package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes.dex */
public final class AztecWriter implements Writer {
    public static BitMatrix renderResult(AztecCode aztecCode, int i2, int i3) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int max = Math.max(i2, width);
        int max2 = Math.max(i3, height);
        int min = Math.min(max / width, max2 / height);
        int i4 = (max - (width * min)) / 2;
        int i5 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i6 = 0;
        while (i6 < height) {
            int i7 = i4;
            int i8 = 0;
            while (i8 < width) {
                if (matrix.get(i8, i6)) {
                    bitMatrix.setRegion(i7, i5, min, min);
                }
                i8++;
                i7 += min;
            }
            i6++;
            i5 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return encode(str, barcodeFormat, i2, i3, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            int parseInt = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 33;
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                charset = charset2;
                i4 = parseInt;
                i5 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                return encode(str, barcodeFormat, i2, i3, charset, i4, i5);
            }
            charset = charset2;
            i4 = parseInt;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i5 = 0;
        return encode(str, barcodeFormat, i2, i3, charset, i4, i5);
    }

    public static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Charset charset, int i4, int i5) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }
}
