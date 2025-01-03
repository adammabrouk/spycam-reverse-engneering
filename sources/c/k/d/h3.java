package c.k.d;

/* loaded from: classes.dex */
public final class h3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7217a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7219c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7221e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7223g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7225i;
    public boolean k;
    public boolean m;
    public boolean o;
    public boolean q;
    public boolean s;
    public boolean u;

    /* renamed from: b, reason: collision with root package name */
    public int f7218b = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f7220d = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f7222f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f7224h = "";
    public String j = "";
    public String l = "";
    public String n = "";
    public int p = 1;
    public int r = 0;
    public int t = 0;
    public String v = "";
    public int w = -1;

    @Override // c.k.d.s2
    public int a() {
        if (this.w < 0) {
            b();
        }
        return this.w;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m192a() {
        return this.f7220d;
    }

    /* renamed from: a, reason: collision with other method in class */
    public h3 m193a() {
        this.k = false;
        this.l = "";
        return this;
    }

    public h3 a(int i2) {
        this.f7217a = true;
        this.f7218b = i2;
        return this;
    }

    public h3 a(long j) {
        this.f7219c = true;
        this.f7220d = j;
        return this;
    }

    @Override // c.k.d.s2
    public h3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            switch (m78a) {
                case 0:
                    return this;
                case 8:
                    a(b0Var.b());
                    break;
                case 16:
                    a(b0Var.m87b());
                    break;
                case 26:
                    a(b0Var.m81a());
                    break;
                case 34:
                    b(b0Var.m81a());
                    break;
                case 42:
                    c(b0Var.m81a());
                    break;
                case 50:
                    d(b0Var.m81a());
                    break;
                case 58:
                    e(b0Var.m81a());
                    break;
                case 64:
                    b(b0Var.b());
                    break;
                case 72:
                    c(b0Var.b());
                    break;
                case 80:
                    d(b0Var.b());
                    break;
                case 90:
                    f(b0Var.m81a());
                    break;
                default:
                    if (!a(b0Var, m78a)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public h3 a(String str) {
        this.f7221e = true;
        this.f7222f = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m194a() {
        return this.f7222f;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m195a()) {
            c1Var.m100a(1, c());
        }
        if (m197b()) {
            c1Var.m114b(2, m192a());
        }
        if (m199c()) {
            c1Var.m104a(3, m194a());
        }
        if (m201d()) {
            c1Var.m104a(4, m196b());
        }
        if (m203e()) {
            c1Var.m104a(5, m198c());
        }
        if (m205f()) {
            c1Var.m104a(6, m200d());
        }
        if (g()) {
            c1Var.m104a(7, m202e());
        }
        if (h()) {
            c1Var.m100a(8, d());
        }
        if (i()) {
            c1Var.m100a(9, e());
        }
        if (j()) {
            c1Var.m100a(10, f());
        }
        if (k()) {
            c1Var.m104a(11, m204f());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m195a() {
        return this.f7217a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m195a() ? 0 + c1.a(1, c()) : 0;
        if (m197b()) {
            a2 += c1.b(2, m192a());
        }
        if (m199c()) {
            a2 += c1.a(3, m194a());
        }
        if (m201d()) {
            a2 += c1.a(4, m196b());
        }
        if (m203e()) {
            a2 += c1.a(5, m198c());
        }
        if (m205f()) {
            a2 += c1.a(6, m200d());
        }
        if (g()) {
            a2 += c1.a(7, m202e());
        }
        if (h()) {
            a2 += c1.a(8, d());
        }
        if (i()) {
            a2 += c1.a(9, e());
        }
        if (j()) {
            a2 += c1.a(10, f());
        }
        if (k()) {
            a2 += c1.a(11, m204f());
        }
        this.w = a2;
        return a2;
    }

    public h3 b(int i2) {
        this.o = true;
        this.p = i2;
        return this;
    }

    public h3 b(String str) {
        this.f7223g = true;
        this.f7224h = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m196b() {
        return this.f7224h;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m197b() {
        return this.f7219c;
    }

    public int c() {
        return this.f7218b;
    }

    public h3 c(int i2) {
        this.q = true;
        this.r = i2;
        return this;
    }

    public h3 c(String str) {
        this.f7225i = true;
        this.j = str;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m198c() {
        return this.j;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m199c() {
        return this.f7221e;
    }

    public int d() {
        return this.p;
    }

    public h3 d(int i2) {
        this.s = true;
        this.t = i2;
        return this;
    }

    public h3 d(String str) {
        this.k = true;
        this.l = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public String m200d() {
        return this.l;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m201d() {
        return this.f7223g;
    }

    public int e() {
        return this.r;
    }

    public h3 e(String str) {
        this.m = true;
        this.n = str;
        return this;
    }

    /* renamed from: e, reason: collision with other method in class */
    public String m202e() {
        return this.n;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m203e() {
        return this.f7225i;
    }

    public int f() {
        return this.t;
    }

    public h3 f(String str) {
        this.u = true;
        this.v = str;
        return this;
    }

    /* renamed from: f, reason: collision with other method in class */
    public String m204f() {
        return this.v;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m205f() {
        return this.k;
    }

    public boolean g() {
        return this.m;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        return this.q;
    }

    public boolean j() {
        return this.s;
    }

    public boolean k() {
        return this.u;
    }
}
