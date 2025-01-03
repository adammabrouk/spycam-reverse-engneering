package c.j.a.z;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: ContextDelegate.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Method f6677a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Method f6678b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f6679c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f6680d = false;

    /* renamed from: e, reason: collision with root package name */
    public static Context f6681e;

    public static Context a(Context context) {
        try {
            if (f6678b == null) {
                f6678b = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
            }
            return (Context) f6678b.invoke(context, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return context;
        }
    }

    public static Context b(Context context) {
        try {
            if (f6677a == null) {
                f6677a = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
            }
            return (Context) f6677a.invoke(context, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return context;
        }
    }

    public static Context c(Context context) {
        if (!a() || context == null) {
            return context;
        }
        Context context2 = f6681e;
        if (context2 != null) {
            return context2;
        }
        d(context);
        return f6681e;
    }

    public static void d(Context context) {
        if (f6680d) {
            f6681e = b(context);
        } else {
            f6681e = a(context);
        }
    }

    public static boolean a() {
        if (f6679c == null) {
            try {
                f6679c = Boolean.valueOf("file".equals(p.a("ro.crypto.type", "unknow")));
                v.b("ContextDelegate", "mIsFbeProject = " + f6679c.toString());
            } catch (Exception e2) {
                v.a("ContextDelegate", "mIsFbeProject = " + e2.getMessage());
            }
        }
        Boolean bool = f6679c;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
