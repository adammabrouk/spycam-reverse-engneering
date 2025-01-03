package c.c.a.a.j;

import c.c.a.a.j.k;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class o<T> implements c.c.a.a.f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final l f3593a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3594b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.b f3595c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.e<T, byte[]> f3596d;

    /* renamed from: e, reason: collision with root package name */
    public final p f3597e;

    public o(l lVar, String str, c.c.a.a.b bVar, c.c.a.a.e<T, byte[]> eVar, p pVar) {
        this.f3593a = lVar;
        this.f3594b = str;
        this.f3595c = bVar;
        this.f3596d = eVar;
        this.f3597e = pVar;
    }

    public static /* synthetic */ void a(Exception exc) {
    }

    @Override // c.c.a.a.f
    public void a(c.c.a.a.c<T> cVar) {
        a(cVar, n.a());
    }

    public void a(c.c.a.a.c<T> cVar, c.c.a.a.h hVar) {
        p pVar = this.f3597e;
        k.a g2 = k.g();
        g2.a(this.f3593a);
        g2.a((c.c.a.a.c<?>) cVar);
        g2.a(this.f3594b);
        g2.a((c.c.a.a.e<?, byte[]>) this.f3596d);
        g2.a(this.f3595c);
        pVar.a(g2.a(), hVar);
    }
}
