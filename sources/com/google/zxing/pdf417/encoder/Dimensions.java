package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
public final class Dimensions {
    public final int maxCols;
    public final int maxRows;
    public final int minCols;
    public final int minRows;

    public Dimensions(int i2, int i3, int i4, int i5) {
        this.minCols = i2;
        this.maxCols = i3;
        this.minRows = i4;
        this.maxRows = i5;
    }

    public int getMaxCols() {
        return this.maxCols;
    }

    public int getMaxRows() {
        return this.maxRows;
    }

    public int getMinCols() {
        return this.minCols;
    }

    public int getMinRows() {
        return this.minRows;
    }
}
