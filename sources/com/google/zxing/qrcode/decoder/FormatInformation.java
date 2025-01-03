package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public final class FormatInformation {
    public static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    public static final int FORMAT_INFO_MASK_QR = 21522;
    public final byte dataMask;
    public final ErrorCorrectionLevel errorCorrectionLevel;

    public FormatInformation(int i2) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i2 >> 3) & 3);
        this.dataMask = (byte) (i2 & 7);
    }

    public static FormatInformation decodeFormatInformation(int i2, int i3) {
        FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i2, i3);
        return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i2 ^ 21522, i3 ^ 21522);
    }

    public static FormatInformation doDecodeFormatInformation(int i2, int i3) {
        int numBitsDiffering;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : FORMAT_INFO_DECODE_LOOKUP) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new FormatInformation(iArr[1]);
            }
            int numBitsDiffering2 = numBitsDiffering(i2, i6);
            if (numBitsDiffering2 < i4) {
                i5 = iArr[1];
                i4 = numBitsDiffering2;
            }
            if (i2 != i3 && (numBitsDiffering = numBitsDiffering(i3, i6)) < i4) {
                i5 = iArr[1];
                i4 = numBitsDiffering;
            }
        }
        if (i4 <= 3) {
            return new FormatInformation(i5);
        }
        return null;
    }

    public static int numBitsDiffering(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) obj;
        return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
    }

    public byte getDataMask() {
        return this.dataMask;
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }
}
