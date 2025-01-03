package com.google.zxing.qrcode.encoder;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public final class MatrixUtil {
    public static final int[][] POSITION_ADJUSTMENT_PATTERN;
    public static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
    public static final int[][] POSITION_DETECTION_PATTERN;
    public static final int[][] TYPE_INFO_COORDINATES;
    public static final int TYPE_INFO_MASK_PATTERN = 21522;
    public static final int TYPE_INFO_POLY = 1335;
    public static final int VERSION_INFO_POLY = 7973;

    static {
        int[] iArr = new int[7];
        iArr[0] = 1;
        iArr[6] = 1;
        int[] iArr2 = new int[7];
        iArr2[0] = 1;
        iArr2[6] = 1;
        POSITION_DETECTION_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, iArr, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, iArr2, new int[]{1, 1, 1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, RecyclerView.c0.FLAG_IGNORE, 154}, new int[]{6, 28, 54, 80, 106, ContentCommon.CMD_PTZ_RESET, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        TYPE_INFO_COORDINATES = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i2, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i2, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i2, byteMatrix);
    }

    public static int calculateBCHCode(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int findMSBSet = findMSBSet(i3);
        int i4 = i2 << (findMSBSet - 1);
        while (findMSBSet(i4) >= findMSBSet) {
            i4 ^= i3 << (findMSBSet(i4) - findMSBSet);
        }
        return i4;
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    public static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    public static void embedDataBits(BitArray bitArray, int i2, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i3 = 0;
        int i4 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = width - i5;
                    if (isEmpty(byteMatrix.get(i6, height))) {
                        if (i3 < bitArray.getSize()) {
                            z = bitArray.get(i3);
                            i3++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && MaskUtil.getDataMaskBit(i2, i6, height)) {
                            z = !z;
                        }
                        byteMatrix.set(i6, height, z);
                    }
                }
                height += i4;
            }
            i4 = -i4;
            height += i4;
            width -= 2;
        }
        if (i3 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + bitArray.getSize());
    }

    public static void embedHorizontalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!isEmpty(byteMatrix.get(i5, i3))) {
                throw new WriterException();
            }
            byteMatrix.set(i5, i3, 0);
        }
    }

    public static void embedPositionAdjustmentPattern(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                byteMatrix.set(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    public static void embedPositionDetectionPattern(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = POSITION_DETECTION_PATTERN[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                byteMatrix.set(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    public static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    public static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i2 = 8;
        while (i2 < byteMatrix.getWidth() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (isEmpty(byteMatrix.get(i2, 6))) {
                byteMatrix.set(i2, 6, i4);
            }
            if (isEmpty(byteMatrix.get(6, i2))) {
                byteMatrix.set(6, i2, i4);
            }
            i2 = i3;
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i2, bitArray);
        for (int i3 = 0; i3 < bitArray.getSize(); i3++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i3);
            int[] iArr = TYPE_INFO_COORDINATES[i3];
            byteMatrix.set(iArr[0], iArr[1], z);
            if (i3 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i3) - 1, 8, z);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i3 - 8), z);
            }
        }
    }

    public static void embedVerticalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!isEmpty(byteMatrix.get(i2, i5))) {
                throw new WriterException();
            }
            byteMatrix.set(i2, i5, 0);
        }
    }

    public static int findMSBSet(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    public static boolean isEmpty(int i2) {
        return i2 == -1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(i2)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i2;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(21522, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && isEmpty(byteMatrix.get(i3, i2))) {
                        embedPositionAdjustmentPattern(i3 - 2, i2 - 2, byteMatrix);
                    }
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean z = bitArray.get(i2);
                i2--;
                byteMatrix.set(i3, (byteMatrix.getHeight() - 11) + i4, z);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i4, i3, z);
            }
        }
    }
}
