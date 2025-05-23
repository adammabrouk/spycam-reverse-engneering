package com.google.zxing.common;

import com.google.zxing.ResultPoint;

/* loaded from: classes.dex */
public class DetectorResult {
    public final BitMatrix bits;
    public final ResultPoint[] points;

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this.bits = bitMatrix;
        this.points = resultPointArr;
    }

    public final BitMatrix getBits() {
        return this.bits;
    }

    public final ResultPoint[] getPoints() {
        return this.points;
    }
}
