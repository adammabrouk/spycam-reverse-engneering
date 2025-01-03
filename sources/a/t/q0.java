package a.t;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23.java */
/* loaded from: classes.dex */
public class q0 extends p0 {
    public static boolean k = true;

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void a(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i2);
        } else if (k) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }
}
