package c.c.a.a.j.t;

import c.c.a.a.j.t.g;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    public final g.a f3612a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3613b;

    public b(g.a aVar, long j) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f3612a = aVar;
        this.f3613b = j;
    }

    @Override // c.c.a.a.j.t.g
    public long a() {
        return this.f3613b;
    }

    @Override // c.c.a.a.j.t.g
    public g.a b() {
        return this.f3612a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3612a.equals(gVar.b()) && this.f3613b == gVar.a();
    }

    public int hashCode() {
        int hashCode = (this.f3612a.hashCode() ^ 1000003) * 1000003;
        long j = this.f3613b;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f3612a + ", nextRequestWaitMillis=" + this.f3613b + "}";
    }
}
