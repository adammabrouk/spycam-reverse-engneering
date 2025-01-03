package c.k.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.shix.shixipc.system.Rom;

/* loaded from: classes.dex */
public class q9 {

    /* renamed from: a, reason: collision with root package name */
    public static Context f7787a;

    /* renamed from: b, reason: collision with root package name */
    public static String f7788b;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Context m432a() {
        return f7787a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            c.k.a.a.a.c.m6a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m433a() {
        synchronized (q9.class) {
            if (f7788b != null) {
                return f7788b;
            }
            String str = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String b2 = b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = c();
                    if (TextUtils.isEmpty(b2)) {
                        b2 = d();
                        if (TextUtils.isEmpty(b2)) {
                            str = String.valueOf(o9.a("ro.product.brand", "Android") + "_" + str);
                        }
                    }
                }
                str = b2;
            }
            f7788b = str;
            return str;
        }
    }

    public static String a(Context context) {
        if (g9.m184b()) {
            return "";
        }
        String str = (String) f0.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m434a(Context context) {
        f7787a = context.getApplicationContext();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m435a() {
        return TextUtils.equals((String) f0.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m436a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }

    public static String b() {
        String a2 = o9.a("ro.build.version.emui", "");
        f7788b = a2;
        return a2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m437b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            c.k.a.a.a.c.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }

    public static String c() {
        String a2 = o9.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f7788b = "ColorOS_" + a2;
        }
        return f7788b;
    }

    public static String d() {
        String a2 = o9.a(Rom.KEY_VERSION_VIVO, "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f7788b = "FuntouchOS_" + a2;
        }
        return f7788b;
    }
}
