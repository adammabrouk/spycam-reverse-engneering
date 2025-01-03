package c.c.b.g;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f5864a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5865b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5866c;

    public n(Class<?> cls, int i2, int i3) {
        u.a(cls, "Null dependency anInterface.");
        this.f5864a = cls;
        this.f5865b = i2;
        this.f5866c = i3;
    }

    public static n a(Class<?> cls) {
        return new n(cls, 0, 0);
    }

    public static n b(Class<?> cls) {
        return new n(cls, 1, 0);
    }

    public static n c(Class<?> cls) {
        return new n(cls, 2, 0);
    }

    public boolean d() {
        return this.f5865b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f5864a == nVar.f5864a && this.f5865b == nVar.f5865b && this.f5866c == nVar.f5866c;
    }

    public int hashCode() {
        return ((((this.f5864a.hashCode() ^ 1000003) * 1000003) ^ this.f5865b) * 1000003) ^ this.f5866c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f5864a);
        sb.append(", type=");
        int i2 = this.f5865b;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f5866c == 0);
        sb.append("}");
        return sb.toString();
    }

    public Class<?> a() {
        return this.f5864a;
    }

    public boolean b() {
        return this.f5866c == 0;
    }

    public boolean c() {
        return this.f5865b == 1;
    }
}
