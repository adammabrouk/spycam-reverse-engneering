package com.google.zxing.encoding;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;
import java.util.Hashtable;

/* loaded from: classes.dex */
public final class EncodingHandler {
    public static final int BLACK = -16777216;

    public static Bitmap addLogo(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f2 = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f2, f2, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (Exception e2) {
            e2.getStackTrace();
            return null;
        }
    }

    public static Bitmap createQRCode(String str, int i2) throws WriterException {
        new Hashtable().put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i2, i2);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[width * height];
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                if (encode.get(i4, i3)) {
                    iArr[(i3 * width) + i4] = -16777216;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public static Bitmap createQRCode(String str, int i2, int i3, Bitmap bitmap) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
                    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                    BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i2, i3, hashMap);
                    int[] iArr = new int[i2 * i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        for (int i5 = 0; i5 < i2; i5++) {
                            if (encode.get(i5, i4)) {
                                iArr[(i4 * i2) + i5] = -16777216;
                            } else {
                                iArr[(i4 * i2) + i5] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                    return bitmap != null ? addLogo(createBitmap, bitmap) : createBitmap;
                }
            } catch (WriterException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
