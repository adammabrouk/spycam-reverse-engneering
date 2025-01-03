package c.c.a.a.i.b;

import c.c.a.a.i.b.a;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class d extends c.c.a.a.i.b.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3478a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3479b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3480c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3481d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3482e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3483f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3484g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3485h;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b extends a.AbstractC0077a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f3486a;

        /* renamed from: b, reason: collision with root package name */
        public String f3487b;

        /* renamed from: c, reason: collision with root package name */
        public String f3488c;

        /* renamed from: d, reason: collision with root package name */
        public String f3489d;

        /* renamed from: e, reason: collision with root package name */
        public String f3490e;

        /* renamed from: f, reason: collision with root package name */
        public String f3491f;

        /* renamed from: g, reason: collision with root package name */
        public String f3492g;

        /* renamed from: h, reason: collision with root package name */
        public String f3493h;

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a a(int i2) {
            this.f3486a = Integer.valueOf(i2);
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a b(String str) {
            this.f3493h = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a c(String str) {
            this.f3488c = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a d(String str) {
            this.f3492g = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a e(String str) {
            this.f3487b = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a f(String str) {
            this.f3491f = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a g(String str) {
            this.f3490e = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public a.AbstractC0077a a(String str) {
            this.f3489d = str;
            return this;
        }

        @Override // c.c.a.a.i.b.a.AbstractC0077a
        public c.c.a.a.i.b.a a() {
            String str = "";
            if (this.f3486a == null) {
                str = " sdkVersion";
            }
            if (str.isEmpty()) {
                return new d(this.f3486a.intValue(), this.f3487b, this.f3488c, this.f3489d, this.f3490e, this.f3491f, this.f3492g, this.f3493h, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public /* synthetic */ d(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
        this.f3478a = i2;
        this.f3479b = str;
        this.f3480c = str2;
        this.f3481d = str3;
        this.f3482e = str4;
        this.f3483f = str5;
        this.f3484g = str6;
        this.f3485h = str7;
    }

    public String b() {
        return this.f3481d;
    }

    public String c() {
        return this.f3485h;
    }

    public String d() {
        return this.f3480c;
    }

    public String e() {
        return this.f3484g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c.c.a.a.i.b.a)) {
            return false;
        }
        d dVar = (d) ((c.c.a.a.i.b.a) obj);
        if (this.f3478a == dVar.f3478a && ((str = this.f3479b) != null ? str.equals(dVar.f3479b) : dVar.f3479b == null) && ((str2 = this.f3480c) != null ? str2.equals(dVar.f3480c) : dVar.f3480c == null) && ((str3 = this.f3481d) != null ? str3.equals(dVar.f3481d) : dVar.f3481d == null) && ((str4 = this.f3482e) != null ? str4.equals(dVar.f3482e) : dVar.f3482e == null) && ((str5 = this.f3483f) != null ? str5.equals(dVar.f3483f) : dVar.f3483f == null) && ((str6 = this.f3484g) != null ? str6.equals(dVar.f3484g) : dVar.f3484g == null)) {
            String str7 = this.f3485h;
            if (str7 == null) {
                if (dVar.f3485h == null) {
                    return true;
                }
            } else if (str7.equals(dVar.f3485h)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f3479b;
    }

    public String g() {
        return this.f3483f;
    }

    public String h() {
        return this.f3482e;
    }

    public int hashCode() {
        int i2 = (this.f3478a ^ 1000003) * 1000003;
        String str = this.f3479b;
        int hashCode = (i2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f3480c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3481d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f3482e;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f3483f;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f3484g;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f3485h;
        return hashCode6 ^ (str7 != null ? str7.hashCode() : 0);
    }

    public int i() {
        return this.f3478a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f3478a + ", model=" + this.f3479b + ", hardware=" + this.f3480c + ", device=" + this.f3481d + ", product=" + this.f3482e + ", osBuild=" + this.f3483f + ", manufacturer=" + this.f3484g + ", fingerprint=" + this.f3485h + "}";
    }
}
