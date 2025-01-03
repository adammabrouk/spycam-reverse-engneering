package c.k.c.a;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static long f6811a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f6812b = false;

    public static void a(Context context) {
        a a2 = t0.a(context).a(s0.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            c.k.a.a.a.c.m6a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.b();
        }
    }

    public static boolean a() {
        return f6812b;
    }

    public static void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a()) {
            long j = f6811a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f6811a = elapsedRealtime;
                a(context);
            }
        }
    }
}
