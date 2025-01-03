package c.c.a.b.c.s;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class h implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final h f4009a = new h();

    public static e d() {
        return f4009a;
    }

    @Override // c.c.a.b.c.s.e
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // c.c.a.b.c.s.e
    public long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // c.c.a.b.c.s.e
    public long c() {
        return System.nanoTime();
    }
}
