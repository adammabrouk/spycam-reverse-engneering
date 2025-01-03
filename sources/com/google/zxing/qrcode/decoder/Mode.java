package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public enum Mode {
    TERMINATOR(new int[3], 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[3], 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[3], 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[3], 5),
    FNC1_SECOND_POSITION(new int[3], 9),
    HANZI(new int[]{8, 10, 12}, 13);

    public final int bits;
    public final int[] characterCountBitsForVersions;

    Mode(int[] iArr, int i2) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i2;
    }

    public static Mode forBits(int i2) {
        if (i2 == 0) {
            return TERMINATOR;
        }
        if (i2 == 1) {
            return NUMERIC;
        }
        if (i2 == 2) {
            return ALPHANUMERIC;
        }
        if (i2 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i2 == 4) {
            return BYTE;
        }
        if (i2 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i2 == 7) {
            return ECI;
        }
        if (i2 == 8) {
            return KANJI;
        }
        if (i2 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i2 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static Mode[] valuesCustom() {
        Mode[] valuesCustom = values();
        int length = valuesCustom.length;
        Mode[] modeArr = new Mode[length];
        System.arraycopy(valuesCustom, 0, modeArr, 0, length);
        return modeArr;
    }

    public int getBits() {
        return this.bits;
    }

    public int getCharacterCountBits(Version version) {
        int versionNumber = version.getVersionNumber();
        return this.characterCountBitsForVersions[versionNumber <= 9 ? (char) 0 : versionNumber <= 26 ? (char) 1 : (char) 2];
    }
}
