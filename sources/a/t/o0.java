package a.t;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
public class o0 extends n0 {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f1858g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f1859h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f1860i = true;

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void a(View view, Matrix matrix) {
        if (f1858g) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f1858g = false;
            }
        }
    }

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void b(View view, Matrix matrix) {
        if (f1859h) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1859h = false;
            }
        }
    }

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void c(View view, Matrix matrix) {
        if (f1860i) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1860i = false;
            }
        }
    }
}
