package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: classes.dex */
public final class PDF417ScanningDecoder {
    public static final int CODEWORD_SKEW_SIZE = 2;
    public static final int MAX_EC_CODEWORDS = 512;
    public static final int MAX_ERRORS = 3;
    public static final ErrorCorrection errorCorrection = new ErrorCorrection();

    public static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : rowHeights) {
            i3 += max - i4;
            if (i4 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i5 = i3;
        for (int i6 = 0; i5 > 0 && codewords[i6] == null; i6++) {
            i5--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i2 += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i2 > 0 && codewords[length2] == null; length2--) {
            i2--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i5, i2, detectionResultRowIndicatorColumn.isLeft());
    }

    public static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValue.setValue(barcodeColumnCount);
            }
        } else {
            if (barcodeColumnCount < 1 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int adjustCodewordStartColumn(com.google.zxing.common.BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 < r3) goto Lb
            return r2
        Lb:
            if (r8 == 0) goto L10
            if (r2 < r6) goto L24
            goto L12
        L10:
            if (r2 >= r7) goto L24
        L12:
            boolean r4 = r5.get(r2, r10)
            if (r8 == r4) goto L19
            goto L24
        L19:
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L22
            return r9
        L22:
            int r2 = r2 + r0
            goto Lb
        L24:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustCodewordStartColumn(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int");
    }

    public static boolean checkCodewordSkew(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    public static int correctErrors(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return errorCorrection.decode(iArr, i2, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i2 = 0; i2 < barcodeValueArr.length; i2++) {
            for (int i3 = 0; i3 < barcodeValueArr[i2].length; i3++) {
                barcodeValueArr[i2][i3] = new BarcodeValue();
            }
        }
        DetectionResultColumn[] detectionResultColumns = detectionResult.getDetectionResultColumns();
        int i4 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResultColumns) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i4].setValue(codeword.getValue());
                    }
                }
            }
            i4++;
        }
        return barcodeValueArr;
    }

    public static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < detectionResult.getBarcodeRowCount(); i2++) {
            int i3 = 0;
            while (i3 < detectionResult.getBarcodeColumnCount()) {
                int i4 = i3 + 1;
                int[] value = createBarcodeMatrix[i2][i4].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i3;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    public static DecoderResult createDecoderResultFromAmbiguousValues(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i5 = 0; i5 < length; i5++) {
                iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
            }
            try {
                return decodeCodewords(iArr, i2, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        }
                        iArr5[i6] = 0;
                        if (i6 == length - 1) {
                            throw ChecksumException.getChecksumInstance();
                        }
                        i6++;
                    }
                }
                i3 = i4;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        r3 = r27;
        r6 = r28;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r7 <= r5) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r0 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        if (r4.getDetectionResultColumn(r8) == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        if (r8 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0089, code lost:
    
        if (r8 != r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        r9 = new com.google.zxing.pdf417.decoder.DetectionResultColumn(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
    
        r4.setDetectionResultColumn(r8, r9);
        r15 = -1;
        r14 = r10.getMinY();
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
    
        if (r14 <= r10.getMaxY()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
    
        r11 = getStartColumn(r4, r8, r14, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
    
        if (r11 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r11 <= r10.getMaxX()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bc, code lost:
    
        r19 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c9, code lost:
    
        r20 = r13;
        r23 = r14;
        r11 = detectCodeword(r22, r10.getMinX(), r10.getMaxX(), r0, r19, r23, r3, r6);
        r12 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ea, code lost:
    
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ec, code lost:
    
        r9.setCodeword(r12, r11);
        r3 = java.lang.Math.min(r3, r11.getWidth());
        r6 = java.lang.Math.max(r6, r11.getWidth());
        r13 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0104, code lost:
    
        r14 = r12 + 1;
        r15 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0102, code lost:
    
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
    
        if (r13 != r15) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        r20 = r13;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c7, code lost:
    
        r19 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        if (r8 != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        r9 = new com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn(r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007e, code lost:
    
        r8 = r5 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0079, code lost:
    
        return createDecoderResult(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006d, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix r22, com.google.zxing.ResultPoint r23, com.google.zxing.ResultPoint r24, com.google.zxing.ResultPoint r25, com.google.zxing.ResultPoint r26, int r27, int r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.decode(com.google.zxing.common.BitMatrix, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, int, int):com.google.zxing.common.DecoderResult");
    }

    public static DecoderResult decodeCodewords(int[] iArr, int i2, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i3 = 1 << (i2 + 1);
        int correctErrors = correctErrors(iArr, iArr2, i3);
        verifyCodewordCount(iArr, i3);
        DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i2));
        decode.setErrorsCorrected(Integer.valueOf(correctErrors));
        decode.setErasures(Integer.valueOf(iArr2.length));
        return decode;
    }

    public static Codeword detectCodeword(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int decodedValue;
        int codeword;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i2, i3, z, i4, i5);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i2, i3, z, adjustCodewordStartColumn, i5);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z) {
            i8 = adjustCodewordStartColumn + sum;
        } else {
            for (int i9 = 0; i9 < moduleBitCount.length / 2; i9++) {
                int i10 = moduleBitCount[i9];
                moduleBitCount[i9] = moduleBitCount[(moduleBitCount.length - 1) - i9];
                moduleBitCount[(moduleBitCount.length - 1) - i9] = i10;
            }
            adjustCodewordStartColumn -= sum;
            i8 = adjustCodewordStartColumn;
        }
        if (checkCodewordSkew(sum, i6, i7) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(adjustCodewordStartColumn, i8, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    public static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        }
        return null;
    }

    public static int[] getBitCountForCodeword(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    public static int getCodewordBucketNumber(int i2) {
        return getCodewordBucketNumber(getBitCountForCodeword(i2));
    }

    public static int getMax(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[EDGE_INSN: B:17:0x0028->B:18:0x0028 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getModuleBitCount(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L28
            goto L13
        L11:
            if (r11 < r8) goto L28
        L13:
            if (r4 < r0) goto L16
            goto L28
        L16:
            boolean r6 = r7.get(r11, r12)
            if (r6 != r5) goto L23
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L23:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L28:
            if (r4 == r0) goto L35
            if (r10 == 0) goto L2d
            r8 = r9
        L2d:
            if (r11 != r8) goto L33
            r7 = 7
            if (r4 != r7) goto L33
            goto L35
        L33:
            r7 = 0
            return r7
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    public static int getNumberOfECCodeWords(int i2) {
        return 2 << i2;
    }

    public static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i2, int i3) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i5) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i2, i3);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    x = z ? detectCodeword.getStartX() : detectCodeword.getEndX();
                }
            }
            i4++;
        }
        return detectionResultRowIndicatorColumn;
    }

    public static int getStartColumn(DetectionResult detectionResult, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i5) ? detectionResult.getDetectionResultColumn(i5).getCodeword(i3) : null;
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i2).getCodewordNearby(i3);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i5)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i5).getCodewordNearby(i3);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (!isValidBarcodeColumn(detectionResult, i2)) {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
            for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i2).getCodewords()) {
                if (codeword2 != null) {
                    return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i4 * i6 * (codeword2.getEndX() - codeword2.getStartX()));
                }
            }
            i6++;
        }
    }

    public static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i2) {
        return i2 >= 0 && i2 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    public static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        try {
            Formatter formatter = new Formatter();
            for (int i2 = 0; i2 < barcodeValueArr.length; i2++) {
                try {
                    formatter.format("Row %2d: ", Integer.valueOf(i2));
                    for (int i3 = 0; i3 < barcodeValueArr[i2].length; i3++) {
                        BarcodeValue barcodeValue = barcodeValueArr[i2][i3];
                        if (barcodeValue.getValue().length == 0) {
                            formatter.format("        ", null);
                        } else {
                            formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                        }
                    }
                    formatter.format("%n", new Object[0]);
                } catch (Throwable th) {
                    formatter.close();
                    throw th;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } finally {
        }
    }

    public static void verifyCodewordCount(int[] iArr, int i2) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i3 = iArr[0];
        if (i3 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i3 == 0) {
            if (i2 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i2;
        }
    }

    public static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
