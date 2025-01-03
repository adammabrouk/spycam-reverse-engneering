package d.a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* compiled from: InstanceFactory.java */
/* loaded from: classes.dex */
public final class c<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f11313a;

    static {
        new c(null);
    }

    public c(T t) {
        this.f11313a = t;
    }

    public static <T> b<T> a(T t) {
        d.a(t, "instance cannot be null");
        return new c(t);
    }

    @Override // e.a.a
    public T get() {
        return this.f11313a;
    }
}
