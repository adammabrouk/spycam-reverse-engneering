package c.g.a.f;

/* compiled from: RequestChain.kt */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public k f6405a;

    /* renamed from: b, reason: collision with root package name */
    public k f6406b;

    public final void a(k kVar) {
        f.j.b.f.c(kVar, "task");
        if (this.f6405a == null) {
            this.f6405a = kVar;
        }
        k kVar2 = this.f6406b;
        if (kVar2 != null) {
            kVar2.f6382b = kVar;
        }
        this.f6406b = kVar;
    }

    public final void a() {
        k kVar = this.f6405a;
        if (kVar == null) {
            return;
        }
        kVar.a();
    }
}
