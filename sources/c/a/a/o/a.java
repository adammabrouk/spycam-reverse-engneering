package c.a.a.o;

import c.a.a.l.j.l;
import java.io.File;

/* compiled from: ChildLoadProvider.java */
/* loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final f<A, T, Z, R> f3390a;

    /* renamed from: b, reason: collision with root package name */
    public c.a.a.l.e<File, Z> f3391b;

    /* renamed from: c, reason: collision with root package name */
    public c.a.a.l.e<T, Z> f3392c;

    /* renamed from: d, reason: collision with root package name */
    public c.a.a.l.f<Z> f3393d;

    /* renamed from: e, reason: collision with root package name */
    public c.a.a.l.k.j.c<Z, R> f3394e;

    /* renamed from: f, reason: collision with root package name */
    public c.a.a.l.b<T> f3395f;

    public a(f<A, T, Z, R> fVar) {
        this.f3390a = fVar;
    }

    public void a(c.a.a.l.e<T, Z> eVar) {
        this.f3392c = eVar;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<T> b() {
        c.a.a.l.b<T> bVar = this.f3395f;
        return bVar != null ? bVar : this.f3390a.b();
    }

    @Override // c.a.a.o.f
    public c.a.a.l.k.j.c<Z, R> c() {
        c.a.a.l.k.j.c<Z, R> cVar = this.f3394e;
        return cVar != null ? cVar : this.f3390a.c();
    }

    @Override // c.a.a.o.f
    public l<A, T> d() {
        return this.f3390a.d();
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<Z> e() {
        c.a.a.l.f<Z> fVar = this.f3393d;
        return fVar != null ? fVar : this.f3390a.e();
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<T, Z> f() {
        c.a.a.l.e<T, Z> eVar = this.f3392c;
        return eVar != null ? eVar : this.f3390a.f();
    }

    public void a(c.a.a.l.b<T> bVar) {
        this.f3395f = bVar;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a<A, T, Z, R> m5clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, Z> a() {
        c.a.a.l.e<File, Z> eVar = this.f3391b;
        return eVar != null ? eVar : this.f3390a.a();
    }
}
