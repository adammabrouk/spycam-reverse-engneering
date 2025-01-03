package c.k.d;

/* loaded from: classes.dex */
public final class o3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7450a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7452c;

    /* renamed from: b, reason: collision with root package name */
    public int f7451b = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f7453d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f7454e = -1;

    public static o3 a(byte[] bArr) {
        o3 o3Var = new o3();
        o3Var.a(bArr);
        return o3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7454e < 0) {
            b();
        }
        return this.f7454e;
    }

    public o3 a(int i2) {
        this.f7450a = true;
        this.f7451b = i2;
        return this;
    }

    @Override // c.k.d.s2
    public o3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 8) {
                a(b0Var.b());
            } else if (m78a == 18) {
                a(b0Var.m81a());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public o3 a(String str) {
        this.f7452c = true;
        this.f7453d = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m319a() {
        return this.f7453d;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m320a()) {
            c1Var.m100a(1, c());
        }
        if (m321b()) {
            c1Var.m104a(2, m319a());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m320a() {
        return this.f7450a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m320a() ? 0 + c1.a(1, c()) : 0;
        if (m321b()) {
            a2 += c1.a(2, m319a());
        }
        this.f7454e = a2;
        return a2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m321b() {
        return this.f7452c;
    }

    public int c() {
        return this.f7451b;
    }
}
