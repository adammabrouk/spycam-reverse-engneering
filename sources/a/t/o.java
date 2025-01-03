package a.t;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* compiled from: ImageViewUtils.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1855a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Field f1856b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1857c;

    public static void a(ImageView imageView, Matrix matrix) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
                return;
            }
            return;
        }
        if (i2 >= 21) {
            b(imageView, matrix);
            return;
        }
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            Matrix matrix2 = null;
            a();
            Field field = f1856b;
            if (field != null) {
                try {
                    Matrix matrix3 = (Matrix) field.get(imageView);
                    if (matrix3 == null) {
                        try {
                            matrix2 = new Matrix();
                            f1856b.set(imageView, matrix2);
                        } catch (IllegalAccessException unused) {
                        }
                    }
                    matrix2 = matrix3;
                } catch (IllegalAccessException unused2) {
                }
            }
            if (matrix2 != null) {
                matrix2.set(matrix);
            }
            imageView.invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(ImageView imageView, Matrix matrix) {
        if (f1855a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f1855a = false;
            }
        }
    }

    public static void a() {
        if (f1857c) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            f1856b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f1857c = true;
    }
}
