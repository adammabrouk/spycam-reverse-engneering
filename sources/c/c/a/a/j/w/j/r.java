package c.c.a.a.j.w.j;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class r implements d.a.b<q> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Executor> f3712a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.w.k.c> f3713b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<s> f3714c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.x.b> f3715d;

    public r(e.a.a<Executor> aVar, e.a.a<c.c.a.a.j.w.k.c> aVar2, e.a.a<s> aVar3, e.a.a<c.c.a.a.j.x.b> aVar4) {
        this.f3712a = aVar;
        this.f3713b = aVar2;
        this.f3714c = aVar3;
        this.f3715d = aVar4;
    }

    public static r a(e.a.a<Executor> aVar, e.a.a<c.c.a.a.j.w.k.c> aVar2, e.a.a<s> aVar3, e.a.a<c.c.a.a.j.x.b> aVar4) {
        return new r(aVar, aVar2, aVar3, aVar4);
    }

    @Override // e.a.a
    public q get() {
        return new q(this.f3712a.get(), this.f3713b.get(), this.f3714c.get(), this.f3715d.get());
    }
}
