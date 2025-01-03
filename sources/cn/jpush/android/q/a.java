package cn.jpush.android.q;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jpush.android.ad.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f9838a;

    public static SharedPreferences a(Context context) {
        if (f9838a == null) {
            f9838a = context.getApplicationContext().getSharedPreferences("cn.jiguang.union.ads.core.common.prefs", 0);
        }
        return f9838a;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long c2 = c(context, str);
        long b2 = b.a().b(str);
        boolean z = currentTimeMillis - c2 > b2;
        cn.jpush.android.r.b.d("JUnionAdSpCache", "is " + str + " businessTime:" + z + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + c2 + ",businessInterval:" + b2);
        return z;
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long d2 = d(context, str);
        long a2 = b.a().a(str);
        boolean z = currentTimeMillis - d2 > a2;
        cn.jpush.android.r.b.d("JUnionAdSpCache", "is " + str + " reportTime:" + z + ",curTime:" + currentTimeMillis + ",lastReportTime:" + d2 + ",reportInterval:" + a2);
        return z;
    }

    public static long c(Context context, String str) {
        return a(context).getLong(a(str, "_blt"), 0L);
    }

    public static long d(Context context, String str) {
        return a(context).getLong(a(str, "_rlt"), 0L);
    }

    public static void e(Context context, String str) {
        cn.jpush.android.r.b.d("JUnionAdSpCache", "update " + str + " lastBusinessTime");
        a(context).edit().putLong(a(str, "_blt"), System.currentTimeMillis()).apply();
    }

    public static void f(Context context, String str) {
        cn.jpush.android.r.b.d("JUnionAdSpCache", "update " + str + " lastReportTime");
        a(context).edit().putLong(a(str, "_rlt"), System.currentTimeMillis()).apply();
    }
}
