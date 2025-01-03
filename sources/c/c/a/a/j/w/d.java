package c.c.a.a.j.w;

import c.c.a.a.j.w.j.s;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class d implements d.a.b<c> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Executor> f3645a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.t.e> f3646b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<s> f3647c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.w.k.c> f3648d;

    /* renamed from: e, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.x.b> f3649e;

    public d(e.a.a<Executor> aVar, e.a.a<c.c.a.a.j.t.e> aVar2, e.a.a<s> aVar3, e.a.a<c.c.a.a.j.w.k.c> aVar4, e.a.a<c.c.a.a.j.x.b> aVar5) {
        this.f3645a = aVar;
        this.f3646b = aVar2;
        this.f3647c = aVar3;
        this.f3648d = aVar4;
        this.f3649e = aVar5;
    }

    public static d a(e.a.a<Executor> aVar, e.a.a<c.c.a.a.j.t.e> aVar2, e.a.a<s> aVar3, e.a.a<c.c.a.a.j.w.k.c> aVar4, e.a.a<c.c.a.a.j.x.b> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    @Override // e.a.a
    public c get() {
        return new c(this.f3645a.get(), this.f3646b.get(), this.f3647c.get(), this.f3648d.get(), this.f3649e.get());
    }
}
