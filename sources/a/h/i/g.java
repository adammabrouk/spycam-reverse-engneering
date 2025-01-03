package a.h.i;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    public final Object f1108c;

    public g(int i2) {
        super(i2);
        this.f1108c = new Object();
    }

    @Override // a.h.i.f, a.h.i.e
    public T a() {
        T t;
        synchronized (this.f1108c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // a.h.i.f, a.h.i.e
    public boolean a(T t) {
        boolean a2;
        synchronized (this.f1108c) {
            a2 = super.a(t);
        }
        return a2;
    }
}
