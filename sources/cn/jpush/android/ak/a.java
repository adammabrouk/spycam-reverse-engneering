package cn.jpush.android.ak;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f9128a;

    public static long a(Context context) {
        return c(context).getLong("last_ad_load_time", 0L);
    }

    public static void a(Context context, long j) {
        c(context).edit().putLong("last_ad_load_time", j).commit();
    }

    public static long b(Context context) {
        return c(context).getLong("svr_time_interval", 5L);
    }

    public static void b(Context context, long j) {
        c(context).edit().putLong("svr_time_interval", j).commit();
    }

    public static SharedPreferences c(Context context) {
        if (f9128a == null) {
            f9128a = context.getApplicationContext().getSharedPreferences("cn.jiguang.union.ads.native.prefs", 0);
        }
        return f9128a;
    }
}
