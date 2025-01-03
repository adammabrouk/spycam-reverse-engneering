package a.t;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
public class n0 extends s0 {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f1854f = true;

    @Override // a.t.s0
    public void a(View view) {
    }

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void a(View view, float f2) {
        if (f1854f) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f1854f = false;
            }
        }
        view.setAlpha(f2);
    }

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (f1854f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1854f = false;
            }
        }
        return view.getAlpha();
    }

    @Override // a.t.s0
    public void c(View view) {
    }
}
