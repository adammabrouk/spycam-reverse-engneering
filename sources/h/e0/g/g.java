package h.e0.g;

import h.a0;
import h.p;
import h.t;
import h.y;
import java.io.IOException;
import java.util.List;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes.dex */
public final class g implements t.a {

    /* renamed from: a, reason: collision with root package name */
    public final List<t> f11462a;

    /* renamed from: b, reason: collision with root package name */
    public final h.e0.f.g f11463b;

    /* renamed from: c, reason: collision with root package name */
    public final c f11464c;

    /* renamed from: d, reason: collision with root package name */
    public final h.e0.f.c f11465d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11466e;

    /* renamed from: f, reason: collision with root package name */
    public final y f11467f;

    /* renamed from: g, reason: collision with root package name */
    public final h.e f11468g;

    /* renamed from: h, reason: collision with root package name */
    public final p f11469h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11470i;
    public final int j;
    public final int k;
    public int l;

    public g(List<t> list, h.e0.f.g gVar, c cVar, h.e0.f.c cVar2, int i2, y yVar, h.e eVar, p pVar, int i3, int i4, int i5) {
        this.f11462a = list;
        this.f11465d = cVar2;
        this.f11463b = gVar;
        this.f11464c = cVar;
        this.f11466e = i2;
        this.f11467f = yVar;
        this.f11468g = eVar;
        this.f11469h = pVar;
        this.f11470i = i3;
        this.j = i4;
        this.k = i5;
    }

    @Override // h.t.a
    public y a() {
        return this.f11467f;
    }

    @Override // h.t.a
    public int b() {
        return this.f11470i;
    }

    @Override // h.t.a
    public int c() {
        return this.j;
    }

    @Override // h.t.a
    public int d() {
        return this.k;
    }

    public h.e e() {
        return this.f11468g;
    }

    public h.i f() {
        return this.f11465d;
    }

    public p g() {
        return this.f11469h;
    }

    public c h() {
        return this.f11464c;
    }

    public h.e0.f.g i() {
        return this.f11463b;
    }

    @Override // h.t.a
    public a0 a(y yVar) throws IOException {
        return a(yVar, this.f11463b, this.f11464c, this.f11465d);
    }

    public a0 a(y yVar, h.e0.f.g gVar, c cVar, h.e0.f.c cVar2) throws IOException {
        if (this.f11466e < this.f11462a.size()) {
            this.l++;
            if (this.f11464c != null && !this.f11465d.a(yVar.g())) {
                throw new IllegalStateException("network interceptor " + this.f11462a.get(this.f11466e - 1) + " must retain the same host and port");
            }
            if (this.f11464c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f11462a.get(this.f11466e - 1) + " must call proceed() exactly once");
            }
            g gVar2 = new g(this.f11462a, gVar, cVar, cVar2, this.f11466e + 1, yVar, this.f11468g, this.f11469h, this.f11470i, this.j, this.k);
            t tVar = this.f11462a.get(this.f11466e);
            a0 intercept = tVar.intercept(gVar2);
            if (cVar != null && this.f11466e + 1 < this.f11462a.size() && gVar2.l != 1) {
                throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
            }
            if (intercept != null) {
                if (intercept.a() != null) {
                    return intercept;
                }
                throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + tVar + " returned null");
        }
        throw new AssertionError();
    }
}
