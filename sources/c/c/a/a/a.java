package c.c.a.a;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* loaded from: classes.dex */
public final class a<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f3465a;

    /* renamed from: b, reason: collision with root package name */
    public final T f3466b;

    /* renamed from: c, reason: collision with root package name */
    public final d f3467c;

    public a(Integer num, T t, d dVar) {
        this.f3465a = num;
        if (t == null) {
            throw new NullPointerException("Null payload");
        }
        this.f3466b = t;
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f3467c = dVar;
    }

    @Override // c.c.a.a.c
    public Integer a() {
        return this.f3465a;
    }

    @Override // c.c.a.a.c
    public T b() {
        return this.f3466b;
    }

    @Override // c.c.a.a.c
    public d c() {
        return this.f3467c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f3465a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f3466b.equals(cVar.b()) && this.f3467c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f3465a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f3466b.hashCode()) * 1000003) ^ this.f3467c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f3465a + ", payload=" + this.f3466b + ", priority=" + this.f3467c + "}";
    }
}
