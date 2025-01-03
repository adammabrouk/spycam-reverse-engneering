package a.t;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: GhostViewUtils.java */
/* loaded from: classes.dex */
public class n {
    public static j a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? l.a(view, viewGroup, matrix) : m.a(view, viewGroup, matrix);
    }

    public static void a(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            l.a(view);
        } else {
            m.b(view);
        }
    }
}
