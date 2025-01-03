package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f4891b;

    public l6(h6 h6Var, long j) {
        this.f4891b = h6Var;
        this.f4890a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4891b.k().q.a(this.f4890a);
        this.f4891b.c().A().a("Session timeout duration set", Long.valueOf(this.f4890a));
    }
}
