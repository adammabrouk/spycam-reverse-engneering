package c.c.a.a.i.b;

import c.c.a.a.i.b.m;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class f extends m {

    /* renamed from: a, reason: collision with root package name */
    public final m.b f3495a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.i.b.a f3496b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b extends m.a {

        /* renamed from: a, reason: collision with root package name */
        public m.b f3497a;

        /* renamed from: b, reason: collision with root package name */
        public c.c.a.a.i.b.a f3498b;

        @Override // c.c.a.a.i.b.m.a
        public m.a a(m.b bVar) {
            this.f3497a = bVar;
            return this;
        }

        @Override // c.c.a.a.i.b.m.a
        public m.a a(c.c.a.a.i.b.a aVar) {
            this.f3498b = aVar;
            return this;
        }

        @Override // c.c.a.a.i.b.m.a
        public m a() {
            return new f(this.f3497a, this.f3498b, null);
        }
    }

    public /* synthetic */ f(m.b bVar, c.c.a.a.i.b.a aVar, a aVar2) {
        this.f3495a = bVar;
        this.f3496b = aVar;
    }

    public c.c.a.a.i.b.a b() {
        return this.f3496b;
    }

    public m.b c() {
        return this.f3495a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m.b bVar = this.f3495a;
        if (bVar != null ? bVar.equals(((f) obj).f3495a) : ((f) obj).f3495a == null) {
            c.c.a.a.i.b.a aVar = this.f3496b;
            if (aVar == null) {
                if (((f) obj).f3496b == null) {
                    return true;
                }
            } else if (aVar.equals(((f) obj).f3496b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        m.b bVar = this.f3495a;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        c.c.a.a.i.b.a aVar = this.f3496b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f3495a + ", androidClientInfo=" + this.f3496b + "}";
    }
}
