package c.c.a.a.j.w.j;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class n implements d.a.b<m> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a.a<Context> f3699a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.t.e> f3700b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.w.k.c> f3701c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a.a<s> f3702d;

    /* renamed from: e, reason: collision with root package name */
    public final e.a.a<Executor> f3703e;

    /* renamed from: f, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.x.b> f3704f;

    /* renamed from: g, reason: collision with root package name */
    public final e.a.a<c.c.a.a.j.y.a> f3705g;

    public n(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.t.e> aVar2, e.a.a<c.c.a.a.j.w.k.c> aVar3, e.a.a<s> aVar4, e.a.a<Executor> aVar5, e.a.a<c.c.a.a.j.x.b> aVar6, e.a.a<c.c.a.a.j.y.a> aVar7) {
        this.f3699a = aVar;
        this.f3700b = aVar2;
        this.f3701c = aVar3;
        this.f3702d = aVar4;
        this.f3703e = aVar5;
        this.f3704f = aVar6;
        this.f3705g = aVar7;
    }

    public static n a(e.a.a<Context> aVar, e.a.a<c.c.a.a.j.t.e> aVar2, e.a.a<c.c.a.a.j.w.k.c> aVar3, e.a.a<s> aVar4, e.a.a<Executor> aVar5, e.a.a<c.c.a.a.j.x.b> aVar6, e.a.a<c.c.a.a.j.y.a> aVar7) {
        return new n(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    @Override // e.a.a
    public m get() {
        return new m(this.f3699a.get(), this.f3700b.get(), this.f3701c.get(), this.f3702d.get(), this.f3703e.get(), this.f3704f.get(), this.f3705g.get());
    }
}
