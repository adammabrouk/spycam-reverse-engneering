package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
public final class BarcodeRow {
    public int currentLocation = 0;
    public final byte[] row;

    public BarcodeRow(int i2) {
        this.row = new byte[i2];
    }

    public void addBar(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.currentLocation;
            this.currentLocation = i4 + 1;
            set(i4, z);
        }
    }

    public byte[] getScaledRow(int i2) {
        int length = this.row.length * i2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = this.row[i3 / i2];
        }
        return bArr;
    }

    public void set(int i2, byte b2) {
        this.row[i2] = b2;
    }

    private void set(int i2, boolean z) {
        this.row[i2] = z ? (byte) 1 : (byte) 0;
    }
}
