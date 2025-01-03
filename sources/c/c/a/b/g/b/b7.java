package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f4609b;

    public b7(h6 h6Var, long j) {
        this.f4609b = h6Var;
        this.f4608a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4609b.k().p.a(this.f4608a);
        this.f4609b.c().A().a("Minimum session duration set", Long.valueOf(this.f4608a));
    }
}
