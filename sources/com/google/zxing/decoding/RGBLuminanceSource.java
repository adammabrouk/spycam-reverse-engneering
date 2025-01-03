package com.google.zxing.decoding;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.zxing.LuminanceSource;
import com.google.zxing.view.ViewfinderView;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    public final byte[] luminances;

    public RGBLuminanceSource(String str) throws FileNotFoundException {
        this(loadBitmap(str));
    }

    public static Bitmap loadBitmap(String str) throws FileNotFoundException {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        throw new FileNotFoundException("Couldn't open " + str);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        return this.luminances;
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
        System.arraycopy(this.luminances, i2 * width, bArr, 0, width);
        return bArr;
    }

    public RGBLuminanceSource(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.luminances = new byte[i2];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                int i6 = i4 + i5;
                int i7 = iArr[i6];
                int i8 = (i7 >> 16) & ViewfinderView.OPAQUE;
                int i9 = (i7 >> 8) & ViewfinderView.OPAQUE;
                int i10 = i7 & ViewfinderView.OPAQUE;
                if (i8 == i9 && i9 == i10) {
                    this.luminances[i6] = (byte) i8;
                } else {
                    this.luminances[i6] = (byte) ((((i8 + i9) + i9) + i10) >> 2);
                }
            }
        }
    }
}
