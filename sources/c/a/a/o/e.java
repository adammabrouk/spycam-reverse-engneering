package c.a.a.o;

import c.a.a.l.j.l;
import java.io.File;

/* compiled from: FixedLoadProvider.java */
/* loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {

    /* renamed from: a, reason: collision with root package name */
    public final l<A, T> f3399a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.k.j.c<Z, R> f3400b;

    /* renamed from: c, reason: collision with root package name */
    public final b<T, Z> f3401c;

    public e(l<A, T> lVar, c.a.a.l.k.j.c<Z, R> cVar, b<T, Z> bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f3399a = lVar;
        if (cVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f3400b = cVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f3401c = bVar;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<File, Z> a() {
        return this.f3401c.a();
    }

    @Override // c.a.a.o.b
    public c.a.a.l.b<T> b() {
        return this.f3401c.b();
    }

    @Override // c.a.a.o.f
    public c.a.a.l.k.j.c<Z, R> c() {
        return this.f3400b;
    }

    @Override // c.a.a.o.f
    public l<A, T> d() {
        return this.f3399a;
    }

    @Override // c.a.a.o.b
    public c.a.a.l.f<Z> e() {
        return this.f3401c.e();
    }

    @Override // c.a.a.o.b
    public c.a.a.l.e<T, Z> f() {
        return this.f3401c.f();
    }
}
