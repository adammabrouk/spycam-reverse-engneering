package com.google.zxing.client.j2se;

/* loaded from: classes.dex */
public final class MatrixToImageConfig {
    public static final int BLACK = -16777216;
    public static final int WHITE = -1;
    public final int offColor;
    public final int onColor;

    public MatrixToImageConfig() {
        this(-16777216, -1);
    }

    public static boolean hasTransparency(int i2) {
        return (i2 & (-16777216)) != -16777216;
    }

    public int getBufferedImageColorModel() {
        if (this.onColor == -16777216 && this.offColor == -1) {
            return 12;
        }
        return (hasTransparency(this.onColor) || hasTransparency(this.offColor)) ? 2 : 1;
    }

    public int getPixelOffColor() {
        return this.offColor;
    }

    public int getPixelOnColor() {
        return this.onColor;
    }

    public MatrixToImageConfig(int i2, int i3) {
        this.onColor = i2;
        this.offColor = i3;
    }
}
