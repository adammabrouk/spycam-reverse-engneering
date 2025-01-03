package c.k.c.a;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f6807a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f6808b;

    public static void a(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a()) {
            long j = f6808b;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f6808b = elapsedRealtime;
                b(context);
            }
        }
    }

    public static boolean a() {
        return f6807a;
    }

    public static void b(Context context) {
        a a2 = t0.a(context).a(s0.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            c.k.a.a.a.c.m6a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.b();
        }
    }
}
