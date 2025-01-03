package c.c.b.n.q;

import c.c.b.n.q.c;
import c.c.b.n.q.d;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6060a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f6061b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6062c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6063d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6064e;

    /* renamed from: f, reason: collision with root package name */
    public final long f6065f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6066g;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f6067a;

        /* renamed from: b, reason: collision with root package name */
        public c.a f6068b;

        /* renamed from: c, reason: collision with root package name */
        public String f6069c;

        /* renamed from: d, reason: collision with root package name */
        public String f6070d;

        /* renamed from: e, reason: collision with root package name */
        public Long f6071e;

        /* renamed from: f, reason: collision with root package name */
        public Long f6072f;

        /* renamed from: g, reason: collision with root package name */
        public String f6073g;

        @Override // c.c.b.n.q.d.a
        public d.a a(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f6068b = aVar;
            return this;
        }

        @Override // c.c.b.n.q.d.a
        public d.a b(String str) {
            this.f6067a = str;
            return this;
        }

        @Override // c.c.b.n.q.d.a
        public d.a c(String str) {
            this.f6073g = str;
            return this;
        }

        @Override // c.c.b.n.q.d.a
        public d.a d(String str) {
            this.f6070d = str;
            return this;
        }

        public b() {
        }

        @Override // c.c.b.n.q.d.a
        public d.a b(long j) {
            this.f6072f = Long.valueOf(j);
            return this;
        }

        public b(d dVar) {
            this.f6067a = dVar.c();
            this.f6068b = dVar.f();
            this.f6069c = dVar.a();
            this.f6070d = dVar.e();
            this.f6071e = Long.valueOf(dVar.b());
            this.f6072f = Long.valueOf(dVar.g());
            this.f6073g = dVar.d();
        }

        @Override // c.c.b.n.q.d.a
        public d.a a(String str) {
            this.f6069c = str;
            return this;
        }

        @Override // c.c.b.n.q.d.a
        public d.a a(long j) {
            this.f6071e = Long.valueOf(j);
            return this;
        }

        @Override // c.c.b.n.q.d.a
        public d a() {
            String str = "";
            if (this.f6068b == null) {
                str = " registrationStatus";
            }
            if (this.f6071e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f6072f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f6067a, this.f6068b, this.f6069c, this.f6070d, this.f6071e.longValue(), this.f6072f.longValue(), this.f6073g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // c.c.b.n.q.d
    public String a() {
        return this.f6062c;
    }

    @Override // c.c.b.n.q.d
    public long b() {
        return this.f6064e;
    }

    @Override // c.c.b.n.q.d
    public String c() {
        return this.f6060a;
    }

    @Override // c.c.b.n.q.d
    public String d() {
        return this.f6066g;
    }

    @Override // c.c.b.n.q.d
    public String e() {
        return this.f6063d;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f6060a;
        if (str3 != null ? str3.equals(dVar.c()) : dVar.c() == null) {
            if (this.f6061b.equals(dVar.f()) && ((str = this.f6062c) != null ? str.equals(dVar.a()) : dVar.a() == null) && ((str2 = this.f6063d) != null ? str2.equals(dVar.e()) : dVar.e() == null) && this.f6064e == dVar.b() && this.f6065f == dVar.g()) {
                String str4 = this.f6066g;
                if (str4 == null) {
                    if (dVar.d() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // c.c.b.n.q.d
    public c.a f() {
        return this.f6061b;
    }

    @Override // c.c.b.n.q.d
    public long g() {
        return this.f6065f;
    }

    public int hashCode() {
        String str = this.f6060a;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f6061b.hashCode()) * 1000003;
        String str2 = this.f6062c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f6063d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f6064e;
        int i2 = (hashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f6065f;
        int i3 = (i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f6066g;
        return i3 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // c.c.b.n.q.d
    public d.a m() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f6060a + ", registrationStatus=" + this.f6061b + ", authToken=" + this.f6062c + ", refreshToken=" + this.f6063d + ", expiresInSecs=" + this.f6064e + ", tokenCreationEpochInSecs=" + this.f6065f + ", fisError=" + this.f6066g + "}";
    }

    public a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.f6060a = str;
        this.f6061b = aVar;
        this.f6062c = str2;
        this.f6063d = str3;
        this.f6064e = j;
        this.f6065f = j2;
        this.f6066g = str4;
    }
}
