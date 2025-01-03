package a.t;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
public class p0 extends o0 {
    public static boolean j = true;

    @Override // a.t.s0
    @SuppressLint({"NewApi"})
    public void a(View view, int i2, int i3, int i4, int i5) {
        if (j) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
    }
}
