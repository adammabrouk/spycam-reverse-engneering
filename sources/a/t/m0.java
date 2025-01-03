package a.t;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final s0 f1852a;

    /* renamed from: b, reason: collision with root package name */
    public static final Property<View, Float> f1853b;

    /* compiled from: ViewUtils.java */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(m0.c(view));
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            m0.a(view, f2.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return a.h.j.y.j(view);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            a.h.j.y.a(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f1852a = new r0();
        } else if (i2 >= 23) {
            f1852a = new q0();
        } else if (i2 >= 22) {
            f1852a = new p0();
        } else if (i2 >= 21) {
            f1852a = new o0();
        } else if (i2 >= 19) {
            f1852a = new n0();
        } else {
            f1852a = new s0();
        }
        f1853b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    public static void a(View view, float f2) {
        f1852a.a(view, f2);
    }

    public static l0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new k0(view) : j0.c(view);
    }

    public static float c(View view) {
        return f1852a.b(view);
    }

    public static w0 d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new v0(view) : new u0(view.getWindowToken());
    }

    public static void e(View view) {
        f1852a.c(view);
    }

    public static void a(View view) {
        f1852a.a(view);
    }

    public static void c(View view, Matrix matrix) {
        f1852a.c(view, matrix);
    }

    public static void a(View view, int i2) {
        f1852a.a(view, i2);
    }

    public static void a(View view, Matrix matrix) {
        f1852a.a(view, matrix);
    }

    public static void b(View view, Matrix matrix) {
        f1852a.b(view, matrix);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f1852a.a(view, i2, i3, i4, i5);
    }
}
