package c.c.a.a.j.w.k;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class a0 implements d.a.b<z> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3724a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3725b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<d> f3726c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a.a<e0> f3727d;

    public a0(e.a.a<c.c.a.a.j.y.a> aVar, e.a.a<c.c.a.a.j.y.a> aVar2, e.a.a<d> aVar3, e.a.a<e0> aVar4) {
        this.f3724a = aVar;
        this.f3725b = aVar2;
        this.f3726c = aVar3;
        this.f3727d = aVar4;
    }

    public static a0 a(e.a.a<c.c.a.a.j.y.a> aVar, e.a.a<c.c.a.a.j.y.a> aVar2, e.a.a<d> aVar3, e.a.a<e0> aVar4) {
        return new a0(aVar, aVar2, aVar3, aVar4);
    }

    @Override // e.a.a
    public z get() {
        return new z(this.f3724a.get(), this.f3725b.get(), this.f3726c.get(), this.f3727d.get());
    }
}
