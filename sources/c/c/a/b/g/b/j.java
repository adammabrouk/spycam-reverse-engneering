package c.c.a.b.g.b;

import android.os.Handler;
import c.c.a.b.f.e.kb;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: d, reason: collision with root package name */
    public static volatile Handler f4817d;

    /* renamed from: a, reason: collision with root package name */
    public final y5 f4818a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f4819b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f4820c;

    public j(y5 y5Var) {
        c.c.a.b.c.o.r.a(y5Var);
        this.f4818a = y5Var;
        this.f4819b = new i(this, y5Var);
    }

    public abstract void a();

    public final void a(long j) {
        c();
        if (j >= 0) {
            this.f4820c = this.f4818a.b().a();
            if (d().postDelayed(this.f4819b, j)) {
                return;
            }
            this.f4818a.c().t().a("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean b() {
        return this.f4820c != 0;
    }

    public final void c() {
        this.f4820c = 0L;
        d().removeCallbacks(this.f4819b);
    }

    public final Handler d() {
        Handler handler;
        if (f4817d != null) {
            return f4817d;
        }
        synchronized (j.class) {
            if (f4817d == null) {
                f4817d = new kb(this.f4818a.d().getMainLooper());
            }
            handler = f4817d;
        }
        return handler;
    }

    public static /* synthetic */ long a(j jVar, long j) {
        jVar.f4820c = 0L;
        return 0L;
    }
}
