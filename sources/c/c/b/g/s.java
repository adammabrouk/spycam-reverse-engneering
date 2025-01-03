package c.c.b.g;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class s<T> implements c.c.b.m.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5872c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f5873a = f5872c;

    /* renamed from: b, reason: collision with root package name */
    public volatile c.c.b.m.a<T> f5874b;

    public s(c.c.b.m.a<T> aVar) {
        this.f5874b = aVar;
    }

    @Override // c.c.b.m.a
    public T get() {
        T t = (T) this.f5873a;
        if (t == f5872c) {
            synchronized (this) {
                t = (T) this.f5873a;
                if (t == f5872c) {
                    t = this.f5874b.get();
                    this.f5873a = t;
                    this.f5874b = null;
                }
            }
        }
        return t;
    }
}
