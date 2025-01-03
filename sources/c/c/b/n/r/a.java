package c.c.b.n.r;

import c.c.b.n.r.d;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6080a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6081b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6082c;

    /* renamed from: d, reason: collision with root package name */
    public final e f6083d;

    /* renamed from: e, reason: collision with root package name */
    public final d.b f6084e;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f6085a;

        /* renamed from: b, reason: collision with root package name */
        public String f6086b;

        /* renamed from: c, reason: collision with root package name */
        public String f6087c;

        /* renamed from: d, reason: collision with root package name */
        public e f6088d;

        /* renamed from: e, reason: collision with root package name */
        public d.b f6089e;

        @Override // c.c.b.n.r.d.a
        public d.a a(String str) {
            this.f6086b = str;
            return this;
        }

        @Override // c.c.b.n.r.d.a
        public d.a b(String str) {
            this.f6087c = str;
            return this;
        }

        @Override // c.c.b.n.r.d.a
        public d.a c(String str) {
            this.f6085a = str;
            return this;
        }

        @Override // c.c.b.n.r.d.a
        public d.a a(e eVar) {
            this.f6088d = eVar;
            return this;
        }

        @Override // c.c.b.n.r.d.a
        public d.a a(d.b bVar) {
            this.f6089e = bVar;
            return this;
        }

        @Override // c.c.b.n.r.d.a
        public d a() {
            return new a(this.f6085a, this.f6086b, this.f6087c, this.f6088d, this.f6089e);
        }
    }

    @Override // c.c.b.n.r.d
    public e a() {
        return this.f6083d;
    }

    @Override // c.c.b.n.r.d
    public String b() {
        return this.f6081b;
    }

    @Override // c.c.b.n.r.d
    public String c() {
        return this.f6082c;
    }

    @Override // c.c.b.n.r.d
    public d.b d() {
        return this.f6084e;
    }

    @Override // c.c.b.n.r.d
    public String e() {
        return this.f6080a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f6080a;
        if (str != null ? str.equals(dVar.e()) : dVar.e() == null) {
            String str2 = this.f6081b;
            if (str2 != null ? str2.equals(dVar.b()) : dVar.b() == null) {
                String str3 = this.f6082c;
                if (str3 != null ? str3.equals(dVar.c()) : dVar.c() == null) {
                    e eVar = this.f6083d;
                    if (eVar != null ? eVar.equals(dVar.a()) : dVar.a() == null) {
                        d.b bVar = this.f6084e;
                        if (bVar == null) {
                            if (dVar.d() == null) {
                                return true;
                            }
                        } else if (bVar.equals(dVar.d())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f6080a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f6081b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f6082c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        e eVar = this.f6083d;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        d.b bVar = this.f6084e;
        return hashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f6080a + ", fid=" + this.f6081b + ", refreshToken=" + this.f6082c + ", authToken=" + this.f6083d + ", responseCode=" + this.f6084e + "}";
    }

    public a(String str, String str2, String str3, e eVar, d.b bVar) {
        this.f6080a = str;
        this.f6081b = str2;
        this.f6082c = str3;
        this.f6083d = eVar;
        this.f6084e = bVar;
    }
}
