package c.c.a.a.i.b;

import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class e extends k {

    /* renamed from: a, reason: collision with root package name */
    public final List<r> f3494a;

    public e(List<r> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f3494a = list;
    }

    @Override // c.c.a.a.i.b.k
    public List<r> a() {
        return this.f3494a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return this.f3494a.equals(((k) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f3494a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3494a + "}";
    }
}
