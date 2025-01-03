package a.t;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: GhostViewPlatform.java */
/* loaded from: classes.dex */
public class l implements j {

    /* renamed from: b, reason: collision with root package name */
    public static Class<?> f1838b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1839c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f1840d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1841e;

    /* renamed from: f, reason: collision with root package name */
    public static Method f1842f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f1843g;

    /* renamed from: a, reason: collision with root package name */
    public final View f1844a;

    public l(View view) {
        this.f1844a = view;
    }

    public static j a(View view, ViewGroup viewGroup, Matrix matrix) {
        a();
        Method method = f1840d;
        if (method != null) {
            try {
                return new l((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    public static void b() {
        if (f1839c) {
            return;
        }
        try {
            f1838b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f1839c = true;
    }

    public static void c() {
        if (f1843g) {
            return;
        }
        try {
            b();
            Method declaredMethod = f1838b.getDeclaredMethod("removeGhost", View.class);
            f1842f = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f1843g = true;
    }

    @Override // a.t.j
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // a.t.j
    public void setVisibility(int i2) {
        this.f1844a.setVisibility(i2);
    }

    public static void a(View view) {
        c();
        Method method = f1842f;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public static void a() {
        if (f1841e) {
            return;
        }
        try {
            b();
            Method declaredMethod = f1838b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f1840d = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        f1841e = true;
    }
}
