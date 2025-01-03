package c.c.a.a.j;

import android.content.Context;
import c.c.a.a.j.r;
import c.c.a.a.j.w.k.a0;
import c.c.a.a.j.w.k.f0;
import c.c.a.a.j.w.k.z;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class d extends r {

    /* renamed from: a, reason: collision with root package name */
    public e.a.a<Executor> f3576a;

    /* renamed from: b, reason: collision with root package name */
    public e.a.a<Context> f3577b;

    /* renamed from: c, reason: collision with root package name */
    public e.a.a f3578c;

    /* renamed from: d, reason: collision with root package name */
    public e.a.a f3579d;

    /* renamed from: e, reason: collision with root package name */
    public e.a.a f3580e;

    /* renamed from: f, reason: collision with root package name */
    public e.a.a<z> f3581f;

    /* renamed from: g, reason: collision with root package name */
    public e.a.a<c.c.a.a.j.w.j.g> f3582g;

    /* renamed from: h, reason: collision with root package name */
    public e.a.a<c.c.a.a.j.w.j.s> f3583h;

    /* renamed from: i, reason: collision with root package name */
    public e.a.a<c.c.a.a.j.w.c> f3584i;
    public e.a.a<c.c.a.a.j.w.j.m> j;
    public e.a.a<c.c.a.a.j.w.j.q> k;
    public e.a.a<q> l;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b implements r.a {

        /* renamed from: a, reason: collision with root package name */
        public Context f3585a;

        public b() {
        }

        @Override // c.c.a.a.j.r.a
        public /* bridge */ /* synthetic */ r.a a(Context context) {
            a(context);
            return this;
        }

        @Override // c.c.a.a.j.r.a
        public b a(Context context) {
            d.a.d.a(context);
            this.f3585a = context;
            return this;
        }

        @Override // c.c.a.a.j.r.a
        public r a() {
            d.a.d.a(this.f3585a, (Class<Context>) Context.class);
            return new d(this.f3585a);
        }
    }

    public static r.a c() {
        return new b();
    }

    public final void a(Context context) {
        this.f3576a = d.a.a.a(j.a());
        d.a.b a2 = d.a.c.a(context);
        this.f3577b = a2;
        c.c.a.a.j.t.j a3 = c.c.a.a.j.t.j.a(a2, c.c.a.a.j.y.c.a(), c.c.a.a.j.y.d.a());
        this.f3578c = a3;
        this.f3579d = d.a.a.a(c.c.a.a.j.t.l.a(this.f3577b, a3));
        this.f3580e = f0.a(this.f3577b, c.c.a.a.j.w.k.f.a());
        this.f3581f = d.a.a.a(a0.a(c.c.a.a.j.y.c.a(), c.c.a.a.j.y.d.a(), c.c.a.a.j.w.k.g.a(), this.f3580e));
        c.c.a.a.j.w.g a4 = c.c.a.a.j.w.g.a(c.c.a.a.j.y.c.a());
        this.f3582g = a4;
        c.c.a.a.j.w.i a5 = c.c.a.a.j.w.i.a(this.f3577b, this.f3581f, a4, c.c.a.a.j.y.d.a());
        this.f3583h = a5;
        e.a.a<Executor> aVar = this.f3576a;
        e.a.a aVar2 = this.f3579d;
        e.a.a<z> aVar3 = this.f3581f;
        this.f3584i = c.c.a.a.j.w.d.a(aVar, aVar2, a5, aVar3, aVar3);
        e.a.a<Context> aVar4 = this.f3577b;
        e.a.a aVar5 = this.f3579d;
        e.a.a<z> aVar6 = this.f3581f;
        this.j = c.c.a.a.j.w.j.n.a(aVar4, aVar5, aVar6, this.f3583h, this.f3576a, aVar6, c.c.a.a.j.y.c.a());
        e.a.a<Executor> aVar7 = this.f3576a;
        e.a.a<z> aVar8 = this.f3581f;
        this.k = c.c.a.a.j.w.j.r.a(aVar7, aVar8, this.f3583h, aVar8);
        this.l = d.a.a.a(s.a(c.c.a.a.j.y.c.a(), c.c.a.a.j.y.d.a(), this.f3584i, this.j, this.k));
    }

    @Override // c.c.a.a.j.r
    public q b() {
        return this.l.get();
    }

    public d(Context context) {
        a(context);
    }

    @Override // c.c.a.a.j.r
    public c.c.a.a.j.w.k.c a() {
        return this.f3581f.get();
    }
}
