package d.a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public final class a<T> implements e.a.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f11310c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile e.a.a<T> f11311a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f11312b = f11310c;

    public a(e.a.a<T> aVar) {
        this.f11311a = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f11310c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // e.a.a
    public T get() {
        T t = (T) this.f11312b;
        if (t == f11310c) {
            synchronized (this) {
                t = (T) this.f11312b;
                if (t == f11310c) {
                    t = this.f11311a.get();
                    a(this.f11312b, t);
                    this.f11312b = t;
                    this.f11311a = null;
                }
            }
        }
        return t;
    }

    public static <P extends e.a.a<T>, T> e.a.a<T> a(P p) {
        d.a(p);
        return p instanceof a ? p : new a(p);
    }
}
