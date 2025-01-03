package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    public static final ErrorCorrectionLevel[] FOR_BITS;
    public final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = H;
        ErrorCorrectionLevel errorCorrectionLevel2 = L;
        FOR_BITS = new ErrorCorrectionLevel[]{M, errorCorrectionLevel2, errorCorrectionLevel, Q};
    }

    ErrorCorrectionLevel(int i2) {
        this.bits = i2;
    }

    public static ErrorCorrectionLevel forBits(int i2) {
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i2 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ErrorCorrectionLevel[] valuesCustom() {
        ErrorCorrectionLevel[] valuesCustom = values();
        int length = valuesCustom.length;
        ErrorCorrectionLevel[] errorCorrectionLevelArr = new ErrorCorrectionLevel[length];
        System.arraycopy(valuesCustom, 0, errorCorrectionLevelArr, 0, length);
        return errorCorrectionLevelArr;
    }

    public int getBits() {
        return this.bits;
    }
}
