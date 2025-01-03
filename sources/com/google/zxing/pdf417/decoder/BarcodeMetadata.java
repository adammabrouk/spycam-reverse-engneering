package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
public final class BarcodeMetadata {
    public final int columnCount;
    public final int errorCorrectionLevel;
    public final int rowCount;
    public final int rowCountLowerPart;
    public final int rowCountUpperPart;

    public BarcodeMetadata(int i2, int i3, int i4, int i5) {
        this.columnCount = i2;
        this.errorCorrectionLevel = i5;
        this.rowCountUpperPart = i3;
        this.rowCountLowerPart = i4;
        this.rowCount = i3 + i4;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }

    public int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
