package c.j.a.z;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: BitmapUtil.java */
/* loaded from: classes.dex */
public final class i {
    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = i2 / width;
        float f3 = i3 / height;
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f3);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception unused) {
            return bitmap;
        }
    }
}
