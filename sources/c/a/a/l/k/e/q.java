package c.a.a.l.k.e;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class q {
    public static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i2 && bitmap2.getHeight() == i3) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (bitmap2.getWidth() * i3 > bitmap2.getHeight() * i2) {
            width = i3 / bitmap2.getHeight();
            f2 = (i2 - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap2.getWidth();
            height = (i3 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i2, i3, a(bitmap2));
        }
        a(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, c.a.a.l.i.m.c cVar, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config a2 = a(bitmap);
        Bitmap a3 = cVar.a(width, height, a2);
        if (a3 == null) {
            a3 = Bitmap.createBitmap(width, height, a2);
        }
        a(bitmap, a3);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i2 + "x" + i3);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + a3.getWidth() + "x" + a3.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Canvas canvas = new Canvas(a3);
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return a3;
    }

    @TargetApi(12)
    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT < 12 || bitmap2 == null) {
            return;
        }
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(Bitmap bitmap, c.a.a.l.i.m.c cVar, int i2) {
        Matrix matrix = new Matrix();
        a(i2, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap.Config a2 = a(bitmap);
        Bitmap a3 = cVar.a(round, round2, a2);
        if (a3 == null) {
            a3 = Bitmap.createBitmap(round, round2, a2);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(a3).drawBitmap(bitmap, matrix, new Paint(6));
        return a3;
    }

    public static Bitmap.Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void a(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
