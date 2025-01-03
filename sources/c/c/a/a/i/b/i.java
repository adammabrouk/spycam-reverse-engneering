package c.c.a.a.i.b;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class i extends t {

    /* renamed from: a, reason: collision with root package name */
    public final long f3527a;

    public i(long j) {
        this.f3527a = j;
    }

    @Override // c.c.a.a.i.b.t
    public long a() {
        return this.f3527a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof t) && this.f3527a == ((t) obj).a();
    }

    public int hashCode() {
        long j = this.f3527a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f3527a + "}";
    }
}
