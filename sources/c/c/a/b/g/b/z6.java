package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5226a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f5227b;

    public z6(h6 h6Var, boolean z) {
        this.f5227b = h6Var;
        this.f5226a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean g2 = this.f5227b.f5160a.g();
        boolean f2 = this.f5227b.f5160a.f();
        this.f5227b.f5160a.a(this.f5226a);
        if (f2 == this.f5226a) {
            this.f5227b.f5160a.c().B().a("Default data collection state already set to", Boolean.valueOf(this.f5226a));
        }
        if (this.f5227b.f5160a.g() == g2 || this.f5227b.f5160a.g() != this.f5227b.f5160a.f()) {
            this.f5227b.f5160a.c().y().a("Default data collection is different than actual status", Boolean.valueOf(this.f5226a), Boolean.valueOf(g2));
        }
        this.f5227b.M();
    }
}
