package c.k.d;

/* loaded from: classes.dex */
public final class r3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7791a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7793c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7795e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7797g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7799i;
    public boolean k;

    /* renamed from: b, reason: collision with root package name */
    public String f7792b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f7794d = "";

    /* renamed from: f, reason: collision with root package name */
    public long f7796f = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f7798h = 0;
    public boolean j = false;
    public int l = 0;
    public int m = -1;

    public static r3 a(byte[] bArr) {
        r3 r3Var = new r3();
        r3Var.a(bArr);
        return r3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.m < 0) {
            b();
        }
        return this.m;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m440a() {
        return this.f7796f;
    }

    public r3 a(int i2) {
        this.k = true;
        this.l = i2;
        return this;
    }

    public r3 a(long j) {
        this.f7795e = true;
        this.f7796f = j;
        return this;
    }

    @Override // c.k.d.s2
    public r3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 10) {
                a(b0Var.m81a());
            } else if (m78a == 18) {
                b(b0Var.m81a());
            } else if (m78a == 24) {
                a(b0Var.m79a());
            } else if (m78a == 32) {
                b(b0Var.m79a());
            } else if (m78a == 40) {
                a(b0Var.m84a());
            } else if (m78a == 48) {
                a(b0Var.b());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public r3 a(String str) {
        this.f7791a = true;
        this.f7792b = str;
        return this;
    }

    public r3 a(boolean z) {
        this.f7799i = true;
        this.j = z;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m441a() {
        return this.f7792b;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m442a()) {
            c1Var.m104a(1, m441a());
        }
        if (m445b()) {
            c1Var.m104a(2, m444b());
        }
        if (m446c()) {
            c1Var.m101a(3, m440a());
        }
        if (d()) {
            c1Var.m101a(4, m443b());
        }
        if (f()) {
            c1Var.m105a(5, e());
        }
        if (g()) {
            c1Var.m100a(6, c());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m442a() {
        return this.f7791a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m442a() ? 0 + c1.a(1, m441a()) : 0;
        if (m445b()) {
            a2 += c1.a(2, m444b());
        }
        if (m446c()) {
            a2 += c1.a(3, m440a());
        }
        if (d()) {
            a2 += c1.a(4, m443b());
        }
        if (f()) {
            a2 += c1.a(5, e());
        }
        if (g()) {
            a2 += c1.a(6, c());
        }
        this.m = a2;
        return a2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m443b() {
        return this.f7798h;
    }

    public r3 b(long j) {
        this.f7797g = true;
        this.f7798h = j;
        return this;
    }

    public r3 b(String str) {
        this.f7793c = true;
        this.f7794d = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m444b() {
        return this.f7794d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m445b() {
        return this.f7793c;
    }

    public int c() {
        return this.l;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m446c() {
        return this.f7795e;
    }

    public boolean d() {
        return this.f7797g;
    }

    public boolean e() {
        return this.j;
    }

    public boolean f() {
        return this.f7799i;
    }

    public boolean g() {
        return this.k;
    }
}
