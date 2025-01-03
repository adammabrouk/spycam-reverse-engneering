package com.google.zxing.common.detector;

/* loaded from: classes.dex */
public final class MathUtils {
    public static float distance(float f2, float f3, float f4, float f5) {
        double d2 = f2 - f4;
        double d3 = f3 - f5;
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        return (float) Math.sqrt((d2 * d2) + (d3 * d3));
    }

    public static int round(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    public static int sum(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static float distance(int i2, int i3, int i4, int i5) {
        double d2 = i2 - i4;
        double d3 = i3 - i5;
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        return (float) Math.sqrt((d2 * d2) + (d3 * d3));
    }
}
