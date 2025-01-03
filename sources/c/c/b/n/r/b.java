package c.c.b.n.r;

import c.c.b.n.r.e;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final String f6090a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6091b;

    /* renamed from: c, reason: collision with root package name */
    public final e.b f6092c;

    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    /* renamed from: c.c.b.n.r.b$b, reason: collision with other inner class name */
    public static final class C0116b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        public String f6093a;

        /* renamed from: b, reason: collision with root package name */
        public Long f6094b;

        /* renamed from: c, reason: collision with root package name */
        public e.b f6095c;

        @Override // c.c.b.n.r.e.a
        public e.a a(String str) {
            this.f6093a = str;
            return this;
        }

        @Override // c.c.b.n.r.e.a
        public e.a a(long j) {
            this.f6094b = Long.valueOf(j);
            return this;
        }

        @Override // c.c.b.n.r.e.a
        public e.a a(e.b bVar) {
            this.f6095c = bVar;
            return this;
        }

        @Override // c.c.b.n.r.e.a
        public e a() {
            String str = "";
            if (this.f6094b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f6093a, this.f6094b.longValue(), this.f6095c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // c.c.b.n.r.e
    public e.b a() {
        return this.f6092c;
    }

    @Override // c.c.b.n.r.e
    public String b() {
        return this.f6090a;
    }

    @Override // c.c.b.n.r.e
    public long c() {
        return this.f6091b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f6090a;
        if (str != null ? str.equals(eVar.b()) : eVar.b() == null) {
            if (this.f6091b == eVar.c()) {
                e.b bVar = this.f6092c;
                if (bVar == null) {
                    if (eVar.a() == null) {
                        return true;
                    }
                } else if (bVar.equals(eVar.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f6090a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f6091b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        e.b bVar = this.f6092c;
        return i2 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f6090a + ", tokenExpirationTimestamp=" + this.f6091b + ", responseCode=" + this.f6092c + "}";
    }

    public b(String str, long j, e.b bVar) {
        this.f6090a = str;
        this.f6091b = j;
        this.f6092c = bVar;
    }
}
