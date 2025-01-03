package c.f.a;

import android.view.View;

/* compiled from: ViewHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: ViewHelper.java */
    /* renamed from: c.f.a.a$a, reason: collision with other inner class name */
    public static final class C0125a {
        public static void a(View view, float f2) {
            view.setPivotX(f2);
        }

        public static void b(View view, float f2) {
            view.setPivotY(f2);
        }
    }

    public static void a(View view, float f2) {
        if (c.f.a.b.a.q) {
            c.f.a.b.a.a(view).a(f2);
        } else {
            C0125a.a(view, f2);
        }
    }

    public static void b(View view, float f2) {
        if (c.f.a.b.a.q) {
            c.f.a.b.a.a(view).b(f2);
        } else {
            C0125a.b(view, f2);
        }
    }
}
