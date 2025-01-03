package c.c.a.a.j.w.j;

import c.c.a.a.j.w.j.g;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class d extends g.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f3663a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3664b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<g.c> f3665c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b extends g.b.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f3666a;

        /* renamed from: b, reason: collision with root package name */
        public Long f3667b;

        /* renamed from: c, reason: collision with root package name */
        public Set<g.c> f3668c;

        @Override // c.c.a.a.j.w.j.g.b.a
        public g.b.a a(long j) {
            this.f3666a = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.w.j.g.b.a
        public g.b.a b(long j) {
            this.f3667b = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.w.j.g.b.a
        public g.b.a a(Set<g.c> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f3668c = set;
            return this;
        }

        @Override // c.c.a.a.j.w.j.g.b.a
        public g.b a() {
            String str = "";
            if (this.f3666a == null) {
                str = " delta";
            }
            if (this.f3667b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f3668c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new d(this.f3666a.longValue(), this.f3667b.longValue(), this.f3668c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // c.c.a.a.j.w.j.g.b
    public long a() {
        return this.f3663a;
    }

    @Override // c.c.a.a.j.w.j.g.b
    public Set<g.c> b() {
        return this.f3665c;
    }

    @Override // c.c.a.a.j.w.j.g.b
    public long c() {
        return this.f3664b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g.b)) {
            return false;
        }
        g.b bVar = (g.b) obj;
        return this.f3663a == bVar.a() && this.f3664b == bVar.c() && this.f3665c.equals(bVar.b());
    }

    public int hashCode() {
        long j = this.f3663a;
        int i2 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f3664b;
        return this.f3665c.hashCode() ^ ((i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f3663a + ", maxAllowedDelay=" + this.f3664b + ", flags=" + this.f3665c + "}";
    }

    public d(long j, long j2, Set<g.c> set) {
        this.f3663a = j;
        this.f3664b = j2;
        this.f3665c = set;
    }
}
