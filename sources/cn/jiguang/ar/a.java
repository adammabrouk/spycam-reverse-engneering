package cn.jiguang.ar;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8337a;

    /* renamed from: b, reason: collision with root package name */
    public static String f8338b;

    public static Object a(Class cls, String str) {
        return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]);
    }

    public static String a() {
        try {
            return String.valueOf(a(Class.forName("ohos.system.version.SystemVersion"), "getMajorVersion"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        if (f8337a == null) {
            c(context);
        }
        String str = f8337a;
        return str == null ? "" : str;
    }

    public static String b(Context context) {
        if (f8338b == null) {
            c(context);
        }
        String str = f8338b;
        return str == null ? "" : str;
    }

    public static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            f8338b = context.getResources().getString(packageInfo.applicationInfo.labelRes);
            if (str.length() > 30) {
                str = str.substring(0, 30);
            }
            f8337a = str;
        } catch (Throwable unused) {
            f.b("AndoridUtils", "NO versionName defined in manifest.");
        }
    }
}
