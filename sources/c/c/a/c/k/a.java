package c.c.a.c.k;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import c.c.a.c.t.b;

/* compiled from: MaterialColors.java */
/* loaded from: classes.dex */
public class a {
    public static int a(View view, int i2) {
        return b.a(view, i2);
    }

    public static int a(Context context, int i2, String str) {
        return b.a(context, i2, str);
    }

    public static int a(View view, int i2, int i3) {
        return a(view.getContext(), i2, i3);
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue a2 = b.a(context, i2);
        return a2 != null ? a2.data : i3;
    }

    public static int a(View view, int i2, int i3, float f2) {
        return a(a(view, i2), a(view, i3), f2);
    }

    public static int a(int i2, int i3, float f2) {
        return a(i2, a.h.c.a.c(i3, Math.round(Color.alpha(i3) * f2)));
    }

    public static int a(int i2, int i3) {
        return a.h.c.a.b(i3, i2);
    }
}
