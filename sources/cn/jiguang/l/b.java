package cn.jiguang.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.e.f;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f8944a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, Long> f8945b;

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static void a() {
        HashMap<String, Long> hashMap = new HashMap<>();
        f8945b = hashMap;
        hashMap.put(a("JDataConfigManager", "_bi"), Long.valueOf(JConstants.DAY));
        f8945b.put(a("JWakeReport", "_ri"), Long.valueOf(JConstants.HOUR));
    }

    public static void a(Context context) {
        String l = l(context);
        k(context).edit().putInt(l, k(context).getInt(l, 0) + 1).apply();
    }

    public static void a(Context context, String str, int i2) {
        k(context).edit().putInt(a("JType", "ktsv_" + str), i2).apply();
    }

    public static void a(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        if (!str.contains("JLocation") || j <= h(context, "JLocationv2")) {
            String a2 = a(str, "_bi");
            cn.jiguang.ai.a.c("JCommonConfig", "update " + str + " businessInterval:" + j);
            k(context).edit().putLong(a2, j).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        k(context).edit().putString(a("JType", str), str2).apply();
    }

    public static void a(Context context, String str, boolean z) {
        k(context).edit().putBoolean(a(str, "_ace"), z).apply();
    }

    public static void a(Context context, boolean z) {
        k(context).edit().putBoolean(a("user_wake", "_aue"), z).apply();
    }

    public static boolean a(int i2) {
        boolean z = !d.e() && cn.jiguang.h.a.a().c(i2) == 0;
        cn.jiguang.ai.a.c("JCommonConfig", "configId : " + i2 + ", isBackgroundBusiness : " + z);
        return z;
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long e2 = e(context, str);
        long b2 = cn.jiguang.h.a.a().b(str);
        boolean z = currentTimeMillis - e2 > b2;
        cn.jiguang.ai.a.c("JCommonConfig", "is " + str + " businessTime:" + z + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + e2 + ",businessInterval:" + b2);
        return z;
    }

    public static long b(String str, String str2) {
        try {
            return f8945b.get(a(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    public static void b(Context context, String str, long j) {
        if (j < 0) {
            return;
        }
        String a2 = a(str, "_ri");
        cn.jiguang.ai.a.c("JCommonConfig", "update " + str + " reportInterval:" + j);
        k(context).edit().putLong(a2, j).apply();
    }

    public static void b(Context context, String str, boolean z) {
        k(context).edit().putBoolean(a(str, "_aue"), z).apply();
    }

    public static void b(Context context, boolean z) {
        k(context).edit().putBoolean("JArponceEnable", z).apply();
    }

    public static boolean b(Context context) {
        return k(context).getBoolean(a("user_wake", "_aue"), true);
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long g2 = g(context, str);
        long c2 = cn.jiguang.h.a.a().c(str);
        boolean z = currentTimeMillis - g2 > c2;
        cn.jiguang.ai.a.c("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + g2 + ",reportInterval:" + c2);
        return z;
    }

    public static String c(Context context) {
        return k(context).getString("JWakeLocalState", "");
    }

    public static boolean c(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long g2 = g(context, str);
        long h2 = h(context, str);
        boolean z = currentTimeMillis - g2 > h2;
        cn.jiguang.ai.a.c("JCommonConfig", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + g2 + ",reportInterval:" + h2);
        return z;
    }

    public static void d(Context context, String str) {
        String a2 = a(str, "_blt");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.ai.a.c("JCommonConfig", "update " + str + " lastBusinessTime");
        k(context).edit().putLong(a2, currentTimeMillis).apply();
    }

    public static boolean d(Context context) {
        return k(context).getBoolean("JArponceEnable", false);
    }

    public static long e(Context context, String str) {
        return k(context).getLong(a(str, "_blt"), 0L);
    }

    public static String e(Context context) {
        return k(context).getString(a("JLocation", "info"), "");
    }

    public static String f(Context context) {
        return k(context).getString(a("JLocation", "wifiSSID"), "");
    }

    public static void f(Context context, String str) {
        cn.jiguang.ai.a.c("JCommonConfig", "update " + str + " lastReportTime");
        k(context).edit().putLong(a(str, "_rlt"), System.currentTimeMillis()).apply();
    }

    public static long g(Context context, String str) {
        return k(context).getLong(a(str, "_rlt"), 0L);
    }

    public static String g(Context context) {
        return k(context).getString("JNotificationState", "");
    }

    public static long h(Context context, String str) {
        return k(context).getLong(a(str, "_ri"), b(str, "_ri"));
    }

    public static String h(Context context) {
        return k(context).getString("JDevicesession", "");
    }

    public static String i(Context context) {
        return k(context).getString("JDeviceIds", "");
    }

    public static boolean i(Context context, String str) {
        return k(context).getBoolean(a(str, "_ace"), !str.equals("JArp"));
    }

    public static void j(Context context) {
        f8944a = context.getSharedPreferences("cn.jiguang.common", 0);
        a();
    }

    public static boolean j(Context context, String str) {
        return k(context).getBoolean(a(str, "_aue"), true);
    }

    public static SharedPreferences k(Context context) {
        if (f8944a == null) {
            j(context);
        }
        return f8944a;
    }

    public static void k(Context context, String str) {
        if (f.a(str)) {
            return;
        }
        String l = l(context);
        if (l != null && !l.equals(str)) {
            k(context).edit().remove(l).apply();
        }
        k(context).edit().putString("current_time_key", str).apply();
    }

    public static int l(Context context, String str) {
        if (f.a(str)) {
            return Integer.MAX_VALUE;
        }
        return k(context).getInt(str, 0);
    }

    public static String l(Context context) {
        return k(context).getString("current_time_key", null);
    }

    public static void m(Context context, String str) {
        k(context).edit().putString("JWakeLocalState", str).apply();
    }

    public static String n(Context context, String str) {
        return k(context).getString(a("JType", str), "-1,-1");
    }

    public static int o(Context context, String str) {
        return k(context).getInt(a("JType", "ktsv_" + str), 0);
    }

    public static void p(Context context, String str) {
        k(context).edit().putBoolean(a("JArp", str), true).apply();
    }

    public static boolean q(Context context, String str) {
        return k(context).getBoolean(a("JArp", str), false);
    }

    public static void r(Context context, String str) {
        k(context).edit().putString(a("JLocation", "info"), str).apply();
    }

    public static void s(Context context, String str) {
        k(context).edit().putString(a("JLocation", "wifiSSID"), str).apply();
    }

    public static void t(Context context, String str) {
        k(context).edit().putString("JNotificationState", str).apply();
    }

    public static void u(Context context, String str) {
        cn.jiguang.ai.a.c("JCommonConfig", "update deviceSession");
        k(context).edit().putString("JDevicesession", str).apply();
    }

    public static void v(Context context, String str) {
        k(context).edit().putString("JDeviceIds", str).apply();
    }
}
