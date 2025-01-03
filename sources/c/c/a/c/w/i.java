package c.c.a.c.w;

import android.graphics.drawable.Drawable;
import android.view.View;
import c.c.a.c.r.r;

/* compiled from: MaterialShapeUtils.java */
/* loaded from: classes.dex */
public class i {
    public static d a(int i2) {
        return i2 != 0 ? i2 != 1 ? a() : new e() : new l();
    }

    public static f b() {
        return new f();
    }

    public static d a() {
        return new l();
    }

    public static void a(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            ((h) background).b(f2);
        }
    }

    public static void a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            a(view, (h) background);
        }
    }

    public static void a(View view, h hVar) {
        if (hVar.y()) {
            hVar.d(r.d(view));
        }
    }
}
