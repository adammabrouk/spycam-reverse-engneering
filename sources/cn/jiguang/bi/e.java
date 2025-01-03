package cn.jiguang.bi;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f8807a;

    public static long a(long j) {
        return (j + (j % 2 == 0 ? 1L : 2L)) % 32767;
    }

    public static long a(Context context, long j) {
        long j2 = c(context).getLong("next_rid", j);
        if (j2 == j) {
            return j2;
        }
        long a2 = a(j2);
        c(context).edit().putLong("next_rid", a2).apply();
        return a2;
    }

    public static void a(Context context) {
        f8807a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }

    public static synchronized long b(Context context) {
        long a2;
        synchronized (e.class) {
            a2 = a(context, -1L);
            if (a2 == -1) {
                a2 = a(Math.abs(new Random().nextInt(32767)));
                c(context).edit().putLong("next_rid", a2).apply();
            }
        }
        return a2;
    }

    public static SharedPreferences c(Context context) {
        if (f8807a == null) {
            a(context);
        }
        return f8807a;
    }
}
