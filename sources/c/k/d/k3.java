package c.k.d;

/* loaded from: classes.dex */
public final class k3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7311a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7313c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7315e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7317g;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7312b = false;

    /* renamed from: d, reason: collision with root package name */
    public String f7314d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f7316f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f7318h = "";

    /* renamed from: i, reason: collision with root package name */
    public int f7319i = -1;

    public static k3 a(byte[] bArr) {
        k3 k3Var = new k3();
        k3Var.a(bArr);
        return k3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7319i < 0) {
            b();
        }
        return this.f7319i;
    }

    @Override // c.k.d.s2
    public k3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 8) {
                a(b0Var.m84a());
            } else if (m78a == 18) {
                a(b0Var.m81a());
            } else if (m78a == 26) {
                b(b0Var.m81a());
            } else if (m78a == 34) {
                c(b0Var.m81a());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public k3 a(String str) {
        this.f7313c = true;
        this.f7314d = str;
        return this;
    }

    public k3 a(boolean z) {
        this.f7311a = true;
        this.f7312b = z;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m262a() {
        return this.f7314d;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m265b()) {
            c1Var.m105a(1, m263a());
        }
        if (m266c()) {
            c1Var.m104a(2, m262a());
        }
        if (d()) {
            c1Var.m104a(3, m264b());
        }
        if (e()) {
            c1Var.m104a(4, c());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m263a() {
        return this.f7312b;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m265b() ? 0 + c1.a(1, m263a()) : 0;
        if (m266c()) {
            a2 += c1.a(2, m262a());
        }
        if (d()) {
            a2 += c1.a(3, m264b());
        }
        if (e()) {
            a2 += c1.a(4, c());
        }
        this.f7319i = a2;
        return a2;
    }

    public k3 b(String str) {
        this.f7315e = true;
        this.f7316f = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m264b() {
        return this.f7316f;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m265b() {
        return this.f7311a;
    }

    public k3 c(String str) {
        this.f7317g = true;
        this.f7318h = str;
        return this;
    }

    public String c() {
        return this.f7318h;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m266c() {
        return this.f7313c;
    }

    public boolean d() {
        return this.f7315e;
    }

    public boolean e() {
        return this.f7317g;
    }
}
