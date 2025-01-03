package c.c.a.b.g.b;

import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f5220a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4 f5221b;

    public z4(x4 x4Var, String str) {
        this.f5221b = x4Var;
        c.c.a.b.c.o.r.a(str);
        this.f5220a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f5221b.c().t().a(this.f5220a, th);
    }
}
