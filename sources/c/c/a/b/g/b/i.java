package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y5 f4789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f4790b;

    public i(j jVar, y5 y5Var) {
        this.f4790b = jVar;
        this.f4789a = y5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4789a.F();
        if (fa.a()) {
            this.f4789a.a().a(this);
            return;
        }
        boolean b2 = this.f4790b.b();
        j.a(this.f4790b, 0L);
        if (b2) {
            this.f4790b.a();
        }
    }
}
