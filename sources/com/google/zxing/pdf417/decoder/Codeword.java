package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
public final class Codeword {
    public static final int BARCODE_ROW_UNKNOWN = -1;
    public final int bucket;
    public final int endX;
    public int rowNumber = -1;
    public final int startX;
    public final int value;

    public Codeword(int i2, int i3, int i4, int i5) {
        this.startX = i2;
        this.endX = i3;
        this.bucket = i4;
        this.value = i5;
    }

    public int getBucket() {
        return this.bucket;
    }

    public int getEndX() {
        return this.endX;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    public int getStartX() {
        return this.startX;
    }

    public int getValue() {
        return this.value;
    }

    public int getWidth() {
        return this.endX - this.startX;
    }

    public boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    public boolean isValidRowNumber(int i2) {
        return i2 != -1 && this.bucket == (i2 % 3) * 3;
    }

    public void setRowNumber(int i2) {
        this.rowNumber = i2;
    }

    public void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    public String toString() {
        return String.valueOf(this.rowNumber) + "|" + this.value;
    }
}
