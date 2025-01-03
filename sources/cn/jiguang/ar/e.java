package cn.jiguang.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f8341a = "cn.jiguang.joperate.jcore_config";

    /* renamed from: b, reason: collision with root package name */
    public static SharedPreferences f8342b;

    public static int a(Context context, int i2) {
        return a(context, "notification_state", i2);
    }

    public static int a(Context context, String str, int i2) {
        return l(context).getInt(str, i2);
    }

    public static long a(Context context) {
        return a(context, "user_version", 0L);
    }

    public static long a(Context context, String str, long j) {
        return l(context).getLong(str, j);
    }

    public static String a(Context context, String str, String str2) {
        return l(context).getString(str, str2);
    }

    public static void a(Context context, long j) {
        b(context, "user_version", j);
    }

    public static void a(Context context, String str) {
        b(context, "c_uid", str);
    }

    public static void a(Context context, boolean z) {
        b(context, "install_first_start_app", z);
    }

    public static boolean a(Context context, String str, boolean z) {
        return l(context).getBoolean(str, z);
    }

    public static long b(Context context) {
        return a(context, "event_version", 0L);
    }

    public static void b(Context context, int i2) {
        b(context, "notification_state", i2);
    }

    public static void b(Context context, long j) {
        b(context, "event_version", j);
    }

    @Deprecated
    public static void b(Context context, String str) {
        b(context, "reserved_events", str);
    }

    public static void b(Context context, String str, int i2) {
        SharedPreferences.Editor edit = l(context).edit();
        SharedPreferences.Editor putInt = edit.putInt(str, i2);
        if (Build.VERSION.SDK_INT >= 9) {
            putInt.apply();
        }
        edit.commit();
    }

    public static void b(Context context, String str, long j) {
        SharedPreferences.Editor edit = l(context).edit();
        SharedPreferences.Editor putLong = edit.putLong(str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            putLong.apply();
        }
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = l(context).edit();
        SharedPreferences.Editor putString = edit.putString(str, str2);
        if (Build.VERSION.SDK_INT >= 9) {
            putString.apply();
        }
        edit.commit();
    }

    public static void b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = l(context).edit();
        SharedPreferences.Editor putBoolean = edit.putBoolean(str, z);
        if (Build.VERSION.SDK_INT >= 9) {
            putBoolean.apply();
        }
        edit.commit();
    }

    public static String c(Context context) {
        return a(context, "c_uid", (String) null);
    }

    @Deprecated
    public static void c(Context context, String str) {
        b(context, "user_properties", str);
    }

    @Deprecated
    public static String d(Context context) {
        return a(context, "reserved_events", (String) null);
    }

    public static void d(Context context, String str) {
        b(context, "old_app_active", str);
    }

    @Deprecated
    public static String e(Context context) {
        return a(context, "user_properties", (String) null);
    }

    public static void e(Context context, String str) {
        b(context, "old_app_cuid", str);
    }

    public static long f(Context context) {
        return a(context, "report_last_time", 0L);
    }

    public static void g(Context context) {
        b(context, "report_last_time", System.currentTimeMillis());
    }

    public static boolean h(Context context) {
        return a(context, "install_first_start_app", true);
    }

    public static String i(Context context) {
        return a(context, "old_app_active", (String) null);
    }

    public static String j(Context context) {
        return a(context, "old_app_cuid", (String) null);
    }

    public static boolean k(Context context) {
        return a(context, "jopetate_off", false);
    }

    public static SharedPreferences l(Context context) {
        if (f8342b == null) {
            f8342b = context.getSharedPreferences(f8341a, 0);
        }
        return f8342b;
    }
}
