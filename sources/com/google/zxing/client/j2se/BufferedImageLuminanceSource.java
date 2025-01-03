package com.google.zxing.client.j2se;

import com.google.zxing.LuminanceSource;
import com.google.zxing.view.ViewfinderView;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;

/* loaded from: classes.dex */
public final class BufferedImageLuminanceSource extends LuminanceSource {
    public static final double MINUS_45_IN_RADIANS = -0.7853981633974483d;
    public final BufferedImage image;
    public final int left;
    public final int top;

    public BufferedImageLuminanceSource(BufferedImage bufferedImage) {
        this(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        return new BufferedImageLuminanceSource(this.image, this.left + i2, this.top + i3, i4, i5);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        byte[] bArr = new byte[width * height];
        this.image.getRaster().getDataElements(this.left, this.top, width, height, bArr);
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
        this.image.getRaster().getDataElements(this.left, this.top + i2, width, 1, bArr);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isRotateSupported() {
        return true;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        AffineTransform affineTransform = new AffineTransform(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, width);
        BufferedImage bufferedImage = new BufferedImage(height, width, 10);
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.drawImage(this.image, affineTransform, (ImageObserver) null);
        createGraphics.dispose();
        int width2 = getWidth();
        return new BufferedImageLuminanceSource(bufferedImage, this.top, width - (this.left + width2), getHeight(), width2);
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        int width = getWidth();
        int height = getHeight();
        int i2 = this.left + (width / 2);
        int i3 = this.top + (height / 2);
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(-0.7853981633974483d, i2, i3);
        int max = Math.max(this.image.getWidth(), this.image.getHeight());
        BufferedImage bufferedImage = new BufferedImage(max, max, 10);
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.drawImage(this.image, rotateInstance, (ImageObserver) null);
        createGraphics.dispose();
        int max2 = Math.max(width, height) / 2;
        int max3 = Math.max(0, i2 - max2);
        int max4 = Math.max(0, i3 - max2);
        int i4 = max - 1;
        return new BufferedImageLuminanceSource(bufferedImage, max3, max4, Math.min(i4, i2 + max2) - max3, Math.min(i4, i3 + max2) - max4);
    }

    public BufferedImageLuminanceSource(BufferedImage bufferedImage, int i2, int i3, int i4, int i5) {
        super(i4, i5);
        int i6;
        if (bufferedImage.getType() == 10) {
            this.image = bufferedImage;
        } else {
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if (i2 + i4 > width || (i6 = i3 + i5) > height) {
                throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
            }
            BufferedImage bufferedImage2 = new BufferedImage(width, height, 10);
            this.image = bufferedImage2;
            WritableRaster raster = bufferedImage2.getRaster();
            int[] iArr = new int[i4];
            int i7 = i3;
            while (i7 < i6) {
                int i8 = i7;
                int[] iArr2 = iArr;
                bufferedImage.getRGB(i2, i7, i4, 1, iArr, 0, width);
                for (int i9 = 0; i9 < i4; i9++) {
                    int i10 = iArr2[i9];
                    if (((-16777216) & i10) == 0) {
                        i10 = -1;
                    }
                    iArr2[i9] = ((((((i10 >> 16) & ViewfinderView.OPAQUE) * 306) + (((i10 >> 8) & ViewfinderView.OPAQUE) * 601)) + ((i10 & ViewfinderView.OPAQUE) * 117)) + 512) >> 10;
                }
                raster.setPixels(i2, i8, i4, 1, iArr2);
                i7 = i8 + 1;
                iArr = iArr2;
            }
        }
        this.left = i2;
        this.top = i3;
    }
}
