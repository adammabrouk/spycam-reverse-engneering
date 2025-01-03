package c.k.d;

/* loaded from: classes.dex */
public final class l3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7337a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7339c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7341e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7343g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7345i;
    public boolean k;
    public boolean m;
    public boolean o;
    public boolean q;
    public boolean s;

    /* renamed from: b, reason: collision with root package name */
    public int f7338b = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f7340d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f7342f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f7344h = "";
    public int j = 0;
    public String l = "";
    public String n = "";
    public String p = "";
    public i3 r = null;
    public int t = 0;
    public int u = -1;

    @Override // c.k.d.s2
    public int a() {
        if (this.u < 0) {
            b();
        }
        return this.u;
    }

    /* renamed from: a, reason: collision with other method in class */
    public i3 m272a() {
        return this.r;
    }

    public l3 a(int i2) {
        this.f7337a = true;
        this.f7338b = i2;
        return this;
    }

    @Override // c.k.d.s2
    public l3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            switch (m78a) {
                case 0:
                    return this;
                case 8:
                    a(b0Var.c());
                    break;
                case 18:
                    a(b0Var.m81a());
                    break;
                case 26:
                    b(b0Var.m81a());
                    break;
                case 34:
                    c(b0Var.m81a());
                    break;
                case 40:
                    b(b0Var.b());
                    break;
                case 50:
                    d(b0Var.m81a());
                    break;
                case 58:
                    e(b0Var.m81a());
                    break;
                case 66:
                    f(b0Var.m81a());
                    break;
                case 74:
                    i3 i3Var = new i3();
                    b0Var.a(i3Var);
                    a(i3Var);
                    break;
                case 80:
                    c(b0Var.b());
                    break;
                default:
                    if (!a(b0Var, m78a)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public l3 a(i3 i3Var) {
        if (i3Var == null) {
            throw null;
        }
        this.q = true;
        this.r = i3Var;
        return this;
    }

    public l3 a(String str) {
        this.f7339c = true;
        this.f7340d = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m273a() {
        return this.f7340d;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m274a()) {
            c1Var.m113b(1, c());
        }
        if (m276b()) {
            c1Var.m104a(2, m273a());
        }
        if (m278c()) {
            c1Var.m104a(3, m275b());
        }
        if (m280d()) {
            c1Var.m104a(4, m277c());
        }
        if (m282e()) {
            c1Var.m100a(5, d());
        }
        if (m283f()) {
            c1Var.m104a(6, m279d());
        }
        if (g()) {
            c1Var.m104a(7, m281e());
        }
        if (h()) {
            c1Var.m104a(8, f());
        }
        if (i()) {
            c1Var.m103a(9, (s2) m272a());
        }
        if (j()) {
            c1Var.m100a(10, e());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m274a() {
        return this.f7337a;
    }

    @Override // c.k.d.s2
    public int b() {
        int b2 = m274a() ? 0 + c1.b(1, c()) : 0;
        if (m276b()) {
            b2 += c1.a(2, m273a());
        }
        if (m278c()) {
            b2 += c1.a(3, m275b());
        }
        if (m280d()) {
            b2 += c1.a(4, m277c());
        }
        if (m282e()) {
            b2 += c1.a(5, d());
        }
        if (m283f()) {
            b2 += c1.a(6, m279d());
        }
        if (g()) {
            b2 += c1.a(7, m281e());
        }
        if (h()) {
            b2 += c1.a(8, f());
        }
        if (i()) {
            b2 += c1.a(9, (s2) m272a());
        }
        if (j()) {
            b2 += c1.a(10, e());
        }
        this.u = b2;
        return b2;
    }

    public l3 b(int i2) {
        this.f7345i = true;
        this.j = i2;
        return this;
    }

    public l3 b(String str) {
        this.f7341e = true;
        this.f7342f = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m275b() {
        return this.f7342f;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m276b() {
        return this.f7339c;
    }

    public int c() {
        return this.f7338b;
    }

    public l3 c(int i2) {
        this.s = true;
        this.t = i2;
        return this;
    }

    public l3 c(String str) {
        this.f7343g = true;
        this.f7344h = str;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m277c() {
        return this.f7344h;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m278c() {
        return this.f7341e;
    }

    public int d() {
        return this.j;
    }

    public l3 d(String str) {
        this.k = true;
        this.l = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public String m279d() {
        return this.l;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m280d() {
        return this.f7343g;
    }

    public int e() {
        return this.t;
    }

    public l3 e(String str) {
        this.m = true;
        this.n = str;
        return this;
    }

    /* renamed from: e, reason: collision with other method in class */
    public String m281e() {
        return this.n;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m282e() {
        return this.f7345i;
    }

    public l3 f(String str) {
        this.o = true;
        this.p = str;
        return this;
    }

    public String f() {
        return this.p;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m283f() {
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
}
