package c.c.b.n;

import c.c.b.n.m;

/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: a, reason: collision with root package name */
    public final String f6027a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6028b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6029c;

    @Override // c.c.b.n.m
    public String a() {
        return this.f6027a;
    }

    @Override // c.c.b.n.m
    public long b() {
        return this.f6029c;
    }

    @Override // c.c.b.n.m
    public long c() {
        return this.f6028b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f6027a.equals(mVar.a()) && this.f6028b == mVar.c() && this.f6029c == mVar.b();
    }

    public int hashCode() {
        int hashCode = (this.f6027a.hashCode() ^ 1000003) * 1000003;
        long j = this.f6028b;
        long j2 = this.f6029c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f6027a + ", tokenExpirationTimestamp=" + this.f6028b + ", tokenCreationTimestamp=" + this.f6029c + "}";
    }

    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    public static final class b extends m.a {

        /* renamed from: a, reason: collision with root package name */
        public String f6030a;

        /* renamed from: b, reason: collision with root package name */
        public Long f6031b;

        /* renamed from: c, reason: collision with root package name */
        public Long f6032c;

        @Override // c.c.b.n.m.a
        public m.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f6030a = str;
            return this;
        }

        @Override // c.c.b.n.m.a
        public m.a b(long j) {
            this.f6031b = Long.valueOf(j);
            return this;
        }

        @Override // c.c.b.n.m.a
        public m.a a(long j) {
            this.f6032c = Long.valueOf(j);
            return this;
        }

        @Override // c.c.b.n.m.a
        public m a() {
            String str = "";
            if (this.f6030a == null) {
                str = " token";
            }
            if (this.f6031b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f6032c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f6030a, this.f6031b.longValue(), this.f6032c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public a(String str, long j, long j2) {
        this.f6027a = str;
        this.f6028b = j;
        this.f6029c = j2;
    }
}
