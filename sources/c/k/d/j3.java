package c.k.d;

/* loaded from: classes.dex */
public final class j3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7277a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7279c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7281e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7283g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7285i;
    public boolean k;

    /* renamed from: b, reason: collision with root package name */
    public String f7278b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f7280d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f7282f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f7284h = "";
    public String j = "";
    public String l = "";
    public int m = -1;

    @Override // c.k.d.s2
    public int a() {
        if (this.m < 0) {
            b();
        }
        return this.m;
    }

    @Override // c.k.d.s2
    public j3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 10) {
                a(b0Var.m81a());
            } else if (m78a == 18) {
                b(b0Var.m81a());
            } else if (m78a == 26) {
                c(b0Var.m81a());
            } else if (m78a == 34) {
                d(b0Var.m81a());
            } else if (m78a == 42) {
                e(b0Var.m81a());
            } else if (m78a == 50) {
                f(b0Var.m81a());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public j3 a(String str) {
        this.f7277a = true;
        this.f7278b = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m236a() {
        return this.f7278b;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m237a()) {
            c1Var.m104a(1, m236a());
        }
        if (m239b()) {
            c1Var.m104a(2, m238b());
        }
        if (m240c()) {
            c1Var.m104a(3, c());
        }
        if (m241d()) {
            c1Var.m104a(4, d());
        }
        if (m242e()) {
            c1Var.m104a(5, e());
        }
        if (m243f()) {
            c1Var.m104a(6, f());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m237a() {
        return this.f7277a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m237a() ? 0 + c1.a(1, m236a()) : 0;
        if (m239b()) {
            a2 += c1.a(2, m238b());
        }
        if (m240c()) {
            a2 += c1.a(3, c());
        }
        if (m241d()) {
            a2 += c1.a(4, d());
        }
        if (m242e()) {
            a2 += c1.a(5, e());
        }
        if (m243f()) {
            a2 += c1.a(6, f());
        }
        this.m = a2;
        return a2;
    }

    public j3 b(String str) {
        this.f7279c = true;
        this.f7280d = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m238b() {
        return this.f7280d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m239b() {
        return this.f7279c;
    }

    public j3 c(String str) {
        this.f7281e = true;
        this.f7282f = str;
        return this;
    }

    public String c() {
        return this.f7282f;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m240c() {
        return this.f7281e;
    }

    public j3 d(String str) {
        this.f7283g = true;
        this.f7284h = str;
        return this;
    }

    public String d() {
        return this.f7284h;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m241d() {
        return this.f7283g;
    }

    public j3 e(String str) {
        this.f7285i = true;
        this.j = str;
        return this;
    }

    public String e() {
        return this.j;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m242e() {
        return this.f7285i;
    }

    public j3 f(String str) {
        this.k = true;
        this.l = str;
        return this;
    }

    public String f() {
        return this.l;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m243f() {
        return this.k;
    }
}
