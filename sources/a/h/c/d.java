package a.h.c;

import a.h.b.d.c;
import a.h.b.d.f;
import a.h.g.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f983a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.e.e<String, Typeface> f984b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f983a = new i();
        } else if (i2 >= 28) {
            f983a = new h();
        } else if (i2 >= 26) {
            f983a = new g();
        } else if (i2 >= 24 && f.a()) {
            f983a = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f983a = new e();
        } else {
            f983a = new j();
        }
        f984b = new a.e.e<>(16);
    }

    public static String a(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface b(Resources resources, int i2, int i3) {
        return f984b.b(a(resources, i2, i3));
    }

    /* compiled from: TypefaceCompat.java */
    public static class a extends f.c {

        /* renamed from: a, reason: collision with root package name */
        public f.a f985a;

        public a(f.a aVar) {
            this.f985a = aVar;
        }

        @Override // a.h.g.f.c
        public void a(Typeface typeface) {
            f.a aVar = this.f985a;
            if (aVar != null) {
                aVar.a(typeface);
            }
        }

        @Override // a.h.g.f.c
        public void a(int i2) {
            f.a aVar = this.f985a;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
    }

    public static Typeface a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }

    public static Typeface b(Context context, Typeface typeface, int i2) {
        c.b a2 = f983a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f983a.a(context, a2, context.getResources(), i2);
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            Typeface a3 = a(dVar.c());
            if (a3 != null) {
                if (aVar2 != null) {
                    aVar2.a(a3, handler);
                }
                return a3;
            }
            a2 = a.h.g.f.a(context, dVar.b(), i3, !z ? aVar2 != null : dVar.a() != 0, z ? dVar.d() : -1, f.a.a(handler), new a(aVar2));
        } else {
            a2 = f983a.a(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            f984b.a(a(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f983a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f984b.a(a(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        return f983a.a(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        Typeface b2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (b2 = b(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : b2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
