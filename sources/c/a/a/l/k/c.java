package c.a.a.l.k;

import c.a.a.l.i.k;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class c<T> implements k<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f3224a;

    public c(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f3224a = t;
    }

    @Override // c.a.a.l.i.k
    public void a() {
    }

    @Override // c.a.a.l.i.k
    public final int b() {
        return 1;
    }

    @Override // c.a.a.l.i.k
    public final T get() {
        return this.f3224a;
    }
}
