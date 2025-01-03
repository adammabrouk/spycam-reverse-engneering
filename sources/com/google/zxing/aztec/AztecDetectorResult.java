package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

/* loaded from: classes.dex */
public final class AztecDetectorResult extends DetectorResult {
    public final boolean compact;
    public final int nbDatablocks;
    public final int nbLayers;

    public AztecDetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z, int i2, int i3) {
        super(bitMatrix, resultPointArr);
        this.compact = z;
        this.nbDatablocks = i2;
        this.nbLayers = i3;
    }

    public int getNbDatablocks() {
        return this.nbDatablocks;
    }

    public int getNbLayers() {
        return this.nbLayers;
    }

    public boolean isCompact() {
        return this.compact;
    }
}
