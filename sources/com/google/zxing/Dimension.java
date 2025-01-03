package com.google.zxing;

/* loaded from: classes.dex */
public final class Dimension {
    public final int height;
    public final int width;

    public Dimension(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.width = i2;
        this.height = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public String toString() {
        return String.valueOf(this.width) + "x" + this.height;
    }
}
