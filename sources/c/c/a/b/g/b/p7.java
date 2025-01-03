package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class p7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m7 f5005a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f5006b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l7 f5007c;

    public p7(l7 l7Var, m7 m7Var, long j) {
        this.f5007c = l7Var;
        this.f5005a = m7Var;
        this.f5006b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5007c.a(this.f5005a, false, this.f5006b);
        l7 l7Var = this.f5007c;
        l7Var.f4894e = null;
        l7Var.q().a((m7) null);
    }
}
