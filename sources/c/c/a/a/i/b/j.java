package c.c.a.a.i.b;

import c.c.a.a.i.b.u;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class j extends u {

    /* renamed from: a, reason: collision with root package name */
    public final u.c f3528a;

    /* renamed from: b, reason: collision with root package name */
    public final u.b f3529b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b extends u.a {

        /* renamed from: a, reason: collision with root package name */
        public u.c f3530a;

        /* renamed from: b, reason: collision with root package name */
        public u.b f3531b;

        @Override // c.c.a.a.i.b.u.a
        public u.a a(u.c cVar) {
            this.f3530a = cVar;
            return this;
        }

        @Override // c.c.a.a.i.b.u.a
        public u.a a(u.b bVar) {
            this.f3531b = bVar;
            return this;
        }

        @Override // c.c.a.a.i.b.u.a
        public u a() {
            return new j(this.f3530a, this.f3531b, null);
        }
    }

    public /* synthetic */ j(u.c cVar, u.b bVar, a aVar) {
        this.f3528a = cVar;
        this.f3529b = bVar;
    }

    public u.b b() {
        return this.f3529b;
    }

    public u.c c() {
        return this.f3528a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u.c cVar = this.f3528a;
        if (cVar != null ? cVar.equals(((j) obj).f3528a) : ((j) obj).f3528a == null) {
            u.b bVar = this.f3529b;
            if (bVar == null) {
                if (((j) obj).f3529b == null) {
                    return true;
                }
            } else if (bVar.equals(((j) obj).f3529b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        u.c cVar = this.f3528a;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        u.b bVar = this.f3529b;
        return hashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f3528a + ", mobileSubtype=" + this.f3529b + "}";
    }
}
