package c.k.d;

/* loaded from: classes.dex */
public final class i3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7238a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7240c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7242e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7244g;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7239b = false;

    /* renamed from: d, reason: collision with root package name */
    public int f7241d = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f7243f = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f7245h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f7246i = -1;

    public static i3 a(byte[] bArr) {
        i3 i3Var = new i3();
        i3Var.a(bArr);
        return i3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7246i < 0) {
            b();
        }
        return this.f7246i;
    }

    public i3 a(int i2) {
        this.f7240c = true;
        this.f7241d = i2;
        return this;
    }

    @Override // c.k.d.s2
    public i3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 8) {
                a(b0Var.m84a());
            } else if (m78a == 24) {
                a(b0Var.b());
            } else if (m78a == 32) {
                b(b0Var.b());
            } else if (m78a == 40) {
                c(b0Var.b());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public i3 a(boolean z) {
        this.f7238a = true;
        this.f7239b = z;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m216b()) {
            c1Var.m105a(1, m215a());
        }
        if (m217c()) {
            c1Var.m100a(3, c());
        }
        if (m218d()) {
            c1Var.m100a(4, d());
        }
        if (m219e()) {
            c1Var.m100a(5, e());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m215a() {
        return this.f7239b;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m216b() ? 0 + c1.a(1, m215a()) : 0;
        if (m217c()) {
            a2 += c1.a(3, c());
        }
        if (m218d()) {
            a2 += c1.a(4, d());
        }
        if (m219e()) {
            a2 += c1.a(5, e());
        }
        this.f7246i = a2;
        return a2;
    }

    public i3 b(int i2) {
        this.f7242e = true;
        this.f7243f = i2;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m216b() {
        return this.f7238a;
    }

    public int c() {
        return this.f7241d;
    }

    public i3 c(int i2) {
        this.f7244g = true;
        this.f7245h = i2;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m217c() {
        return this.f7240c;
    }

    public int d() {
        return this.f7243f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m218d() {
        return this.f7242e;
    }

    public int e() {
        return this.f7245h;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m219e() {
        return this.f7244g;
    }
}
