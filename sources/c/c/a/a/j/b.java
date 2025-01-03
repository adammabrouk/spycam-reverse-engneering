package c.c.a.a.j;

import c.c.a.a.j.k;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    public final l f3560a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3561b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.c<?> f3562c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.e<?, byte[]> f3563d;

    /* renamed from: e, reason: collision with root package name */
    public final c.c.a.a.b f3564e;

    @Override // c.c.a.a.j.k
    public c.c.a.a.b a() {
        return this.f3564e;
    }

    @Override // c.c.a.a.j.k
    public c.c.a.a.c<?> b() {
        return this.f3562c;
    }

    @Override // c.c.a.a.j.k
    public c.c.a.a.e<?, byte[]> d() {
        return this.f3563d;
    }

    @Override // c.c.a.a.j.k
    public l e() {
        return this.f3560a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3560a.equals(kVar.e()) && this.f3561b.equals(kVar.f()) && this.f3562c.equals(kVar.b()) && this.f3563d.equals(kVar.d()) && this.f3564e.equals(kVar.a());
    }

    @Override // c.c.a.a.j.k
    public String f() {
        return this.f3561b;
    }

    public int hashCode() {
        return ((((((((this.f3560a.hashCode() ^ 1000003) * 1000003) ^ this.f3561b.hashCode()) * 1000003) ^ this.f3562c.hashCode()) * 1000003) ^ this.f3563d.hashCode()) * 1000003) ^ this.f3564e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f3560a + ", transportName=" + this.f3561b + ", event=" + this.f3562c + ", transformer=" + this.f3563d + ", encoding=" + this.f3564e + "}";
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    /* renamed from: c.c.a.a.j.b$b, reason: collision with other inner class name */
    public static final class C0079b extends k.a {

        /* renamed from: a, reason: collision with root package name */
        public l f3565a;

        /* renamed from: b, reason: collision with root package name */
        public String f3566b;

        /* renamed from: c, reason: collision with root package name */
        public c.c.a.a.c<?> f3567c;

        /* renamed from: d, reason: collision with root package name */
        public c.c.a.a.e<?, byte[]> f3568d;

        /* renamed from: e, reason: collision with root package name */
        public c.c.a.a.b f3569e;

        @Override // c.c.a.a.j.k.a
        public k.a a(l lVar) {
            if (lVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f3565a = lVar;
            return this;
        }

        @Override // c.c.a.a.j.k.a
        public k.a a(String str) {
            if (str != null) {
                this.f3566b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // c.c.a.a.j.k.a
        public k.a a(c.c.a.a.c<?> cVar) {
            if (cVar != null) {
                this.f3567c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        @Override // c.c.a.a.j.k.a
        public k.a a(c.c.a.a.e<?, byte[]> eVar) {
            if (eVar != null) {
                this.f3568d = eVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        @Override // c.c.a.a.j.k.a
        public k.a a(c.c.a.a.b bVar) {
            if (bVar != null) {
                this.f3569e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        @Override // c.c.a.a.j.k.a
        public k a() {
            String str = "";
            if (this.f3565a == null) {
                str = " transportContext";
            }
            if (this.f3566b == null) {
                str = str + " transportName";
            }
            if (this.f3567c == null) {
                str = str + " event";
            }
            if (this.f3568d == null) {
                str = str + " transformer";
            }
            if (this.f3569e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.f3565a, this.f3566b, this.f3567c, this.f3568d, this.f3569e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public b(l lVar, String str, c.c.a.a.c<?> cVar, c.c.a.a.e<?, byte[]> eVar, c.c.a.a.b bVar) {
        this.f3560a = lVar;
        this.f3561b = str;
        this.f3562c = cVar;
        this.f3563d = eVar;
        this.f3564e = bVar;
    }
}
