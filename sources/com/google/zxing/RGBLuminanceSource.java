package com.google.zxing;

import com.google.zxing.view.ViewfinderView;

/* loaded from: classes.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    public final int dataHeight;
    public final int dataWidth;
    public final int left;
    public final byte[] luminances;
    public final int top;

    public RGBLuminanceSource(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.dataWidth = i2;
        this.dataHeight = i3;
        this.left = 0;
        this.top = 0;
        int i4 = i2 * i3;
        this.luminances = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            int i7 = (i6 >> 16) & ViewfinderView.OPAQUE;
            int i8 = (i6 >> 7) & 510;
            this.luminances[i5] = (byte) (((i7 + i8) + (i6 & ViewfinderView.OPAQUE)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i2, this.top + i3, i4, i5);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.dataWidth && height == this.dataHeight) {
            return this.luminances;
        }
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        int i3 = this.top;
        int i4 = this.dataWidth;
        int i5 = (i3 * i4) + this.left;
        if (width == i4) {
            System.arraycopy(this.luminances, i5, bArr, 0, i2);
            return bArr;
        }
        for (int i6 = 0; i6 < height; i6++) {
            System.arraycopy(this.luminances, i5, bArr, i6 * width, width);
            i5 += this.dataWidth;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((i2 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public RGBLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.luminances = bArr;
            this.dataWidth = i2;
            this.dataHeight = i3;
            this.left = i4;
            this.top = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
