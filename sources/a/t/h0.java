package a.t;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1810a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Method f1811b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1812c;

    public static g0 a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new f0(viewGroup) : e0.a(viewGroup);
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i2 >= 18) {
            a(viewGroup, z);
        } else {
            i0.a(viewGroup, z);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(ViewGroup viewGroup, boolean z) {
        if (f1810a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f1810a = false;
            }
        }
    }

    public static int a(ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i2);
        }
        if (!f1812c) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                f1811b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f1812c = true;
        }
        Method method = f1811b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i2;
    }
}
