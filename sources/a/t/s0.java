package a.t;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.transition.R$id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsBase.java */
/* loaded from: classes.dex */
public class s0 {

    /* renamed from: b, reason: collision with root package name */
    public static Method f1868b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1869c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f1870d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1871e;

    /* renamed from: a, reason: collision with root package name */
    public float[] f1872a;

    public void a(View view, float f2) {
        Float f3 = (Float) view.getTag(R$id.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public float b(View view) {
        Float f2 = (Float) view.getTag(R$id.save_non_transition_alpha);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public void c(View view) {
        if (view.getTag(R$id.save_non_transition_alpha) == null) {
            view.setTag(R$id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void c(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            c((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R$id.save_non_transition_alpha, null);
        }
    }

    public void b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            b((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void a(View view, Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArr = this.f1872a;
            if (fArr == null) {
                fArr = new float[9];
                this.f1872a = fArr;
            }
            matrix.getValues(fArr);
            float f2 = fArr[3];
            float sqrt = ((float) Math.sqrt(1.0f - (f2 * f2))) * (fArr[0] < 0.0f ? -1 : 1);
            float degrees = (float) Math.toDegrees(Math.atan2(f2, sqrt));
            float f3 = fArr[0] / sqrt;
            float f4 = fArr[4] / sqrt;
            float f5 = fArr[2];
            float f6 = fArr[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f5);
            view.setTranslationY(f6);
            view.setRotation(degrees);
            view.setScaleX(f3);
            view.setScaleY(f4);
            return;
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        a();
        Method method = f1868b;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void a(View view, int i2) {
        if (!f1871e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f1870d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f1871e = true;
        }
        Field field = f1870d;
        if (field != null) {
            try {
                f1870d.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void a() {
        if (f1869c) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f1868b = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e2);
        }
        f1869c = true;
    }
}
