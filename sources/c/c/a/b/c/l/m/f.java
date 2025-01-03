package c.c.a.b.c.l.m;

/* loaded from: classes.dex */
public final class f<L> {

    /* renamed from: a, reason: collision with root package name */
    public final L f3878a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3879b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f3878a == fVar.f3878a && this.f3879b.equals(fVar.f3879b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f3878a) * 31) + this.f3879b.hashCode();
    }
}
