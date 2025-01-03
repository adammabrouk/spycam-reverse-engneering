package c.k.c.a;

import android.content.Context;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6815a = false;

    public static void a(Context context) {
        a a2 = t0.a(context).a(s0.ASSEMBLE_PUSH_HUAWEI);
        if (a2 != null) {
            a2.b();
        }
    }

    public static boolean a() {
        return f6815a;
    }

    public static synchronized void b(Context context) {
        synchronized (e.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized boolean c(Context context) {
        boolean z;
        synchronized (e.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
        }
        return z;
    }
}
