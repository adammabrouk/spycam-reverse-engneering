package c.c.a.a.j.w.k;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: a, reason: collision with root package name */
    public final long f3728a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.l f3729b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.h f3730c;

    public b(long j, c.c.a.a.j.l lVar, c.c.a.a.j.h hVar) {
        this.f3728a = j;
        if (lVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f3729b = lVar;
        if (hVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f3730c = hVar;
    }

    @Override // c.c.a.a.j.w.k.h
    public c.c.a.a.j.h a() {
        return this.f3730c;
    }

    @Override // c.c.a.a.j.w.k.h
    public long b() {
        return this.f3728a;
    }

    @Override // c.c.a.a.j.w.k.h
    public c.c.a.a.j.l c() {
        return this.f3729b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f3728a == hVar.b() && this.f3729b.equals(hVar.c()) && this.f3730c.equals(hVar.a());
    }

    public int hashCode() {
        long j = this.f3728a;
        return this.f3730c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f3729b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f3728a + ", transportContext=" + this.f3729b + ", event=" + this.f3730c + "}";
    }
}
