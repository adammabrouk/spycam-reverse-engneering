package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class DataMatrixReader implements Reader {
    public static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    public final Decoder decoder = new Decoder();

    public static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i2 = topLeftOnBit[1];
        int i3 = bottomRightOnBit[1];
        int i4 = topLeftOnBit[0];
        int i5 = ((bottomRightOnBit[0] - i4) + 1) / moduleSize;
        int i6 = ((i3 - i2) + 1) / moduleSize;
        if (i5 <= 0 || i6 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = moduleSize / 2;
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        BitMatrix bitMatrix2 = new BitMatrix(i5, i6);
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i10 * moduleSize) + i8;
            for (int i12 = 0; i12 < i5; i12++) {
                if (bitMatrix.get((i12 * moduleSize) + i9, i11)) {
                    bitMatrix2.set(i12, i10);
                }
            }
        }
        return bitMatrix2;
    }

    public static int moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int width = bitMatrix.getWidth();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < width && bitMatrix.get(i2, i3)) {
            i2++;
        }
        if (i2 == width) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i4 = i2 - iArr[0];
        if (i4 != 0) {
            return i4;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPoint[] points;
        DecoderResult decoderResult;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect();
            DecoderResult decode = this.decoder.decode(detect.getBits());
            points = detect.getPoints();
            decoderResult = decode;
        } else {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            points = NO_POINTS;
        }
        Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), points, BarcodeFormat.DATA_MATRIX);
        List<byte[]> byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
