package androidx.activity;

import a.m.f;
import a.m.g;
import a.m.i;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements g {

    /* renamed from: b, reason: collision with root package name */
    public static int f2030b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f2031c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f2032d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f2033e;

    /* renamed from: a, reason: collision with root package name */
    public Activity f2034a;

    public ImmLeaksCleaner(Activity activity) {
        this.f2034a = activity;
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        if (bVar != f.b.ON_DESTROY) {
            return;
        }
        if (f2030b == 0) {
            a();
        }
        if (f2030b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2034a.getSystemService("input_method");
            try {
                Object obj = f2031c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f2032d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f2033e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    public static void a() {
        try {
            f2030b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f2032d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f2033e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f2031c = declaredField3;
            declaredField3.setAccessible(true);
            f2030b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
