package com.google.zxing.camera;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;
import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    public final int dataHeight;
    public final int dataWidth;
    public final int left;
    public final int top;
    public final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 > i2 || i7 + i5 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = bArr;
        this.dataWidth = i2;
        this.dataHeight = i3;
        this.left = i4;
        this.top = i5;
    }

    public int getDataHeight() {
        return this.dataHeight;
    }

    public int getDataWidth() {
        return this.dataWidth;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.dataWidth && height == this.dataHeight) {
            return this.yuvData;
        }
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        int i3 = this.top;
        int i4 = this.dataWidth;
        int i5 = (i3 * i4) + this.left;
        if (width == i4) {
            System.arraycopy(this.yuvData, i5, bArr, 0, i2);
            return bArr;
        }
        byte[] bArr2 = this.yuvData;
        for (int i6 = 0; i6 < height; i6++) {
            System.arraycopy(bArr2, i5, bArr, i6 * width, width);
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
        System.arraycopy(this.yuvData, ((i2 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public Bitmap renderCroppedGreyscaleBitmap() {
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[width * height];
        byte[] bArr = this.yuvData;
        int i2 = (this.top * this.dataWidth) + this.left;
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = ((bArr[i2 + i5] & ThreadUtils.TYPE_SINGLE) * 65793) | (-16777216);
            }
            i2 += this.dataWidth;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }
}
