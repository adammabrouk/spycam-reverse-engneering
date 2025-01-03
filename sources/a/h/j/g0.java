package a.h.j;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f1142b;

    /* renamed from: a, reason: collision with root package name */
    public final l f1143a;

    /* compiled from: WindowInsetsCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Field f1144a;

        /* renamed from: b, reason: collision with root package name */
        public static Field f1145b;

        /* renamed from: c, reason: collision with root package name */
        public static Field f1146c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f1147d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f1144a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f1145b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f1146c = declaredField3;
                declaredField3.setAccessible(true);
                f1147d = true;
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        public static g0 a(View view) {
            if (f1147d && view.isAttachedToWindow()) {
                try {
                    Object obj = f1144a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f1145b.get(obj);
                        Rect rect2 = (Rect) f1146c.get(obj);
                        if (rect != null && rect2 != null) {
                            b bVar = new b();
                            bVar.a(a.h.c.b.a(rect));
                            bVar.b(a.h.c.b.a(rect2));
                            g0 a2 = bVar.a();
                            a2.a(a2);
                            a2.a(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f1148a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f1148a = new e();
                return;
            }
            if (i2 >= 29) {
                this.f1148a = new d();
            } else if (i2 >= 20) {
                this.f1148a = new c();
            } else {
                this.f1148a = new f();
            }
        }

        @Deprecated
        public b a(a.h.c.b bVar) {
            this.f1148a.b(bVar);
            return this;
        }

        @Deprecated
        public b b(a.h.c.b bVar) {
            this.f1148a.d(bVar);
            return this;
        }

        public g0 a() {
            return this.f1148a.b();
        }

        public b(g0 g0Var) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f1148a = new e(g0Var);
                return;
            }
            if (i2 >= 29) {
                this.f1148a = new d(g0Var);
            } else if (i2 >= 20) {
                this.f1148a = new c(g0Var);
            } else {
                this.f1148a = new f(g0Var);
            }
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public static Field f1149e = null;

        /* renamed from: f, reason: collision with root package name */
        public static boolean f1150f = false;

        /* renamed from: g, reason: collision with root package name */
        public static Constructor<WindowInsets> f1151g = null;

        /* renamed from: h, reason: collision with root package name */
        public static boolean f1152h = false;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsets f1153c;

        /* renamed from: d, reason: collision with root package name */
        public a.h.c.b f1154d;

        public c() {
            this.f1153c = c();
        }

        public static WindowInsets c() {
            if (!f1150f) {
                try {
                    f1149e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1150f = true;
            }
            Field field = f1149e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f1152h) {
                try {
                    f1151g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1152h = true;
            }
            Constructor<WindowInsets> constructor = f1151g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // a.h.j.g0.f
        public void b(a.h.c.b bVar) {
            this.f1154d = bVar;
        }

        @Override // a.h.j.g0.f
        public void d(a.h.c.b bVar) {
            WindowInsets windowInsets = this.f1153c;
            if (windowInsets != null) {
                this.f1153c = windowInsets.replaceSystemWindowInsets(bVar.f975a, bVar.f976b, bVar.f977c, bVar.f978d);
            }
        }

        @Override // a.h.j.g0.f
        public g0 b() {
            a();
            g0 a2 = g0.a(this.f1153c);
            a2.a(this.f1157b);
            a2.b(this.f1154d);
            return a2;
        }

        public c(g0 g0Var) {
            this.f1153c = g0Var.k();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f1155c;

        public d() {
            this.f1155c = new WindowInsets.Builder();
        }

        @Override // a.h.j.g0.f
        public void a(a.h.c.b bVar) {
            this.f1155c.setMandatorySystemGestureInsets(bVar.a());
        }

        @Override // a.h.j.g0.f
        public void b(a.h.c.b bVar) {
            this.f1155c.setStableInsets(bVar.a());
        }

        @Override // a.h.j.g0.f
        public void c(a.h.c.b bVar) {
            this.f1155c.setSystemGestureInsets(bVar.a());
        }

        @Override // a.h.j.g0.f
        public void d(a.h.c.b bVar) {
            this.f1155c.setSystemWindowInsets(bVar.a());
        }

        @Override // a.h.j.g0.f
        public void e(a.h.c.b bVar) {
            this.f1155c.setTappableElementInsets(bVar.a());
        }

        @Override // a.h.j.g0.f
        public g0 b() {
            a();
            g0 a2 = g0.a(this.f1155c.build());
            a2.a(this.f1157b);
            return a2;
        }

        public d(g0 g0Var) {
            WindowInsets.Builder builder;
            WindowInsets k = g0Var.k();
            if (k != null) {
                builder = new WindowInsets.Builder(k);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f1155c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class e extends d {
        public e() {
        }

        public e(g0 g0Var) {
            super(g0Var);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final g0 f1156a;

        /* renamed from: b, reason: collision with root package name */
        public a.h.c.b[] f1157b;

        public f() {
            this(new g0((g0) null));
        }

        public final void a() {
            a.h.c.b[] bVarArr = this.f1157b;
            if (bVarArr != null) {
                a.h.c.b bVar = bVarArr[m.a(1)];
                a.h.c.b bVar2 = this.f1157b[m.a(2)];
                if (bVar != null && bVar2 != null) {
                    d(a.h.c.b.a(bVar, bVar2));
                } else if (bVar != null) {
                    d(bVar);
                } else if (bVar2 != null) {
                    d(bVar2);
                }
                a.h.c.b bVar3 = this.f1157b[m.a(16)];
                if (bVar3 != null) {
                    c(bVar3);
                }
                a.h.c.b bVar4 = this.f1157b[m.a(32)];
                if (bVar4 != null) {
                    a(bVar4);
                }
                a.h.c.b bVar5 = this.f1157b[m.a(64)];
                if (bVar5 != null) {
                    e(bVar5);
                }
            }
        }

        public void a(a.h.c.b bVar) {
        }

        public g0 b() {
            a();
            return this.f1156a;
        }

        public void b(a.h.c.b bVar) {
        }

        public void c(a.h.c.b bVar) {
        }

        public void d(a.h.c.b bVar) {
        }

        public void e(a.h.c.b bVar) {
        }

        public f(g0 g0Var) {
            this.f1156a = g0Var;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class g extends l {

        /* renamed from: g, reason: collision with root package name */
        public static boolean f1158g = false;

        /* renamed from: h, reason: collision with root package name */
        public static Method f1159h;

        /* renamed from: i, reason: collision with root package name */
        public static Class<?> f1160i;
        public static Class<?> j;
        public static Field k;
        public static Field l;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f1161c;

        /* renamed from: d, reason: collision with root package name */
        public a.h.c.b f1162d;

        /* renamed from: e, reason: collision with root package name */
        public g0 f1163e;

        /* renamed from: f, reason: collision with root package name */
        public a.h.c.b f1164f;

        public g(g0 g0Var, WindowInsets windowInsets) {
            super(g0Var);
            this.f1162d = null;
            this.f1161c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        public static void j() {
            try {
                f1159h = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f1160i = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = f1160i.getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f1158g = true;
        }

        @Override // a.h.j.g0.l
        public g0 a(int i2, int i3, int i4, int i5) {
            b bVar = new b(g0.a(this.f1161c));
            bVar.b(g0.a(g(), i2, i3, i4, i5));
            bVar.a(g0.a(f(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // a.h.j.g0.l
        public void a(a.h.c.b[] bVarArr) {
        }

        @Override // a.h.j.g0.l
        public void b(g0 g0Var) {
            this.f1163e = g0Var;
        }

        @Override // a.h.j.g0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f1164f, ((g) obj).f1164f);
            }
            return false;
        }

        @Override // a.h.j.g0.l
        public final a.h.c.b g() {
            if (this.f1162d == null) {
                this.f1162d = a.h.c.b.a(this.f1161c.getSystemWindowInsetLeft(), this.f1161c.getSystemWindowInsetTop(), this.f1161c.getSystemWindowInsetRight(), this.f1161c.getSystemWindowInsetBottom());
            }
            return this.f1162d;
        }

        @Override // a.h.j.g0.l
        public boolean i() {
            return this.f1161c.isRound();
        }

        public final a.h.c.b b(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f1158g) {
                j();
            }
            Method method = f1159h;
            if (method != null && j != null && k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) k.get(l.get(invoke));
                    if (rect != null) {
                        return a.h.c.b.a(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e2) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                }
            }
            return null;
        }

        public g(g0 g0Var, g gVar) {
            this(g0Var, new WindowInsets(gVar.f1161c));
        }

        @Override // a.h.j.g0.l
        public void a(g0 g0Var) {
            g0Var.a(this.f1163e);
            g0Var.a(this.f1164f);
        }

        @Override // a.h.j.g0.l
        public void a(a.h.c.b bVar) {
            this.f1164f = bVar;
        }

        @Override // a.h.j.g0.l
        public void a(View view) {
            a.h.c.b b2 = b(view);
            if (b2 == null) {
                b2 = a.h.c.b.f974e;
            }
            a(b2);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class h extends g {
        public a.h.c.b m;

        public h(g0 g0Var, WindowInsets windowInsets) {
            super(g0Var, windowInsets);
            this.m = null;
        }

        @Override // a.h.j.g0.l
        public g0 b() {
            return g0.a(this.f1161c.consumeStableInsets());
        }

        @Override // a.h.j.g0.l
        public g0 c() {
            return g0.a(this.f1161c.consumeSystemWindowInsets());
        }

        @Override // a.h.j.g0.l
        public final a.h.c.b f() {
            if (this.m == null) {
                this.m = a.h.c.b.a(this.f1161c.getStableInsetLeft(), this.f1161c.getStableInsetTop(), this.f1161c.getStableInsetRight(), this.f1161c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // a.h.j.g0.l
        public boolean h() {
            return this.f1161c.isConsumed();
        }

        @Override // a.h.j.g0.l
        public void b(a.h.c.b bVar) {
            this.m = bVar;
        }

        public h(g0 g0Var, h hVar) {
            super(g0Var, hVar);
            this.m = null;
            this.m = hVar.m;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class i extends h {
        public i(g0 g0Var, WindowInsets windowInsets) {
            super(g0Var, windowInsets);
        }

        @Override // a.h.j.g0.l
        public g0 a() {
            return g0.a(this.f1161c.consumeDisplayCutout());
        }

        @Override // a.h.j.g0.l
        public a.h.j.d d() {
            return a.h.j.d.a(this.f1161c.getDisplayCutout());
        }

        @Override // a.h.j.g0.g, a.h.j.g0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f1161c, iVar.f1161c) && Objects.equals(this.f1164f, iVar.f1164f);
        }

        @Override // a.h.j.g0.l
        public int hashCode() {
            return this.f1161c.hashCode();
        }

        public i(g0 g0Var, i iVar) {
            super(g0Var, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class k extends j {
        public static final g0 o = g0.a(WindowInsets.CONSUMED);

        public k(g0 g0Var, WindowInsets windowInsets) {
            super(g0Var, windowInsets);
        }

        @Override // a.h.j.g0.g, a.h.j.g0.l
        public final void a(View view) {
        }

        public k(g0 g0Var, k kVar) {
            super(g0Var, kVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        public static final g0 f1165b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        public final g0 f1166a;

        public l(g0 g0Var) {
            this.f1166a = g0Var;
        }

        public g0 a() {
            return this.f1166a;
        }

        public void a(a.h.c.b bVar) {
        }

        public void a(g0 g0Var) {
        }

        public void a(View view) {
        }

        public void a(a.h.c.b[] bVarArr) {
        }

        public g0 b() {
            return this.f1166a;
        }

        public void b(a.h.c.b bVar) {
        }

        public void b(g0 g0Var) {
        }

        public g0 c() {
            return this.f1166a;
        }

        public a.h.j.d d() {
            return null;
        }

        public a.h.c.b e() {
            return g();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return i() == lVar.i() && h() == lVar.h() && a.h.i.c.a(g(), lVar.g()) && a.h.i.c.a(f(), lVar.f()) && a.h.i.c.a(d(), lVar.d());
        }

        public a.h.c.b f() {
            return a.h.c.b.f974e;
        }

        public a.h.c.b g() {
            return a.h.c.b.f974e;
        }

        public boolean h() {
            return false;
        }

        public int hashCode() {
            return a.h.i.c.a(Boolean.valueOf(i()), Boolean.valueOf(h()), g(), f(), d());
        }

        public boolean i() {
            return false;
        }

        public g0 a(int i2, int i3, int i4, int i5) {
            return f1165b;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static final class m {
        public static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f1142b = k.o;
        } else {
            f1142b = l.f1165b;
        }
    }

    public g0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f1143a = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f1143a = new j(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.f1143a = new i(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.f1143a = new h(this, windowInsets);
        } else if (i2 >= 20) {
            this.f1143a = new g(this, windowInsets);
        } else {
            this.f1143a = new l(this);
        }
    }

    public static g0 a(WindowInsets windowInsets) {
        return a(windowInsets, null);
    }

    @Deprecated
    public g0 b(int i2, int i3, int i4, int i5) {
        b bVar = new b(this);
        bVar.b(a.h.c.b.a(i2, i3, i4, i5));
        return bVar.a();
    }

    @Deprecated
    public g0 c() {
        return this.f1143a.c();
    }

    @Deprecated
    public a.h.c.b d() {
        return this.f1143a.e();
    }

    @Deprecated
    public int e() {
        return this.f1143a.g().f978d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g0) {
            return a.h.i.c.a(this.f1143a, ((g0) obj).f1143a);
        }
        return false;
    }

    @Deprecated
    public int f() {
        return this.f1143a.g().f975a;
    }

    @Deprecated
    public int g() {
        return this.f1143a.g().f977c;
    }

    @Deprecated
    public int h() {
        return this.f1143a.g().f976b;
    }

    public int hashCode() {
        l lVar = this.f1143a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public boolean i() {
        return !this.f1143a.g().equals(a.h.c.b.f974e);
    }

    public boolean j() {
        return this.f1143a.h();
    }

    public WindowInsets k() {
        l lVar = this.f1143a;
        if (lVar instanceof g) {
            return ((g) lVar).f1161c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class j extends i {
        public a.h.c.b n;

        public j(g0 g0Var, WindowInsets windowInsets) {
            super(g0Var, windowInsets);
            this.n = null;
        }

        @Override // a.h.j.g0.g, a.h.j.g0.l
        public g0 a(int i2, int i3, int i4, int i5) {
            return g0.a(this.f1161c.inset(i2, i3, i4, i5));
        }

        @Override // a.h.j.g0.h, a.h.j.g0.l
        public void b(a.h.c.b bVar) {
        }

        @Override // a.h.j.g0.l
        public a.h.c.b e() {
            if (this.n == null) {
                this.n = a.h.c.b.a(this.f1161c.getMandatorySystemGestureInsets());
            }
            return this.n;
        }

        public j(g0 g0Var, j jVar) {
            super(g0Var, jVar);
            this.n = null;
        }
    }

    public static g0 a(WindowInsets windowInsets, View view) {
        a.h.i.h.a(windowInsets);
        g0 g0Var = new g0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            g0Var.a(y.y(view));
            g0Var.a(view.getRootView());
        }
        return g0Var;
    }

    @Deprecated
    public g0 b() {
        return this.f1143a.b();
    }

    public void b(a.h.c.b bVar) {
        this.f1143a.b(bVar);
    }

    @Deprecated
    public g0 a() {
        return this.f1143a.a();
    }

    public g0 a(int i2, int i3, int i4, int i5) {
        return this.f1143a.a(i2, i3, i4, i5);
    }

    public static a.h.c.b a(a.h.c.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f975a - i2);
        int max2 = Math.max(0, bVar.f976b - i3);
        int max3 = Math.max(0, bVar.f977c - i4);
        int max4 = Math.max(0, bVar.f978d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : a.h.c.b.a(max, max2, max3, max4);
    }

    public g0(g0 g0Var) {
        if (g0Var != null) {
            l lVar = g0Var.f1143a;
            if (Build.VERSION.SDK_INT >= 30 && (lVar instanceof k)) {
                this.f1143a = new k(this, (k) lVar);
            } else if (Build.VERSION.SDK_INT >= 29 && (lVar instanceof j)) {
                this.f1143a = new j(this, (j) lVar);
            } else if (Build.VERSION.SDK_INT >= 28 && (lVar instanceof i)) {
                this.f1143a = new i(this, (i) lVar);
            } else if (Build.VERSION.SDK_INT >= 21 && (lVar instanceof h)) {
                this.f1143a = new h(this, (h) lVar);
            } else if (Build.VERSION.SDK_INT >= 20 && (lVar instanceof g)) {
                this.f1143a = new g(this, (g) lVar);
            } else {
                this.f1143a = new l(this);
            }
            lVar.a(this);
            return;
        }
        this.f1143a = new l(this);
    }

    public void a(a.h.c.b[] bVarArr) {
        this.f1143a.a(bVarArr);
    }

    public void a(g0 g0Var) {
        this.f1143a.b(g0Var);
    }

    public void a(a.h.c.b bVar) {
        this.f1143a.a(bVar);
    }

    public void a(View view) {
        this.f1143a.a(view);
    }
}
