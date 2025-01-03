package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

/* loaded from: classes.dex */
public final class FinderPattern {
    public final ResultPoint[] resultPoints;
    public final int[] startEnd;
    public final int value;

    public FinderPattern(int i2, int[] iArr, int i3, int i4, int i5) {
        this.value = i2;
        this.startEnd = iArr;
        float f2 = i5;
        this.resultPoints = new ResultPoint[]{new ResultPoint(i3, f2), new ResultPoint(i4, f2)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
