package c.a.a.r;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public Class<?> f3460a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f3461b;

    public g() {
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.f3460a = cls;
        this.f3461b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3460a.equals(gVar.f3460a) && this.f3461b.equals(gVar.f3461b);
    }

    public int hashCode() {
        return (this.f3460a.hashCode() * 31) + this.f3461b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f3460a + ", second=" + this.f3461b + '}';
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }
}
