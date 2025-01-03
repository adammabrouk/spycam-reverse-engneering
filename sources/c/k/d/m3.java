package c.k.d;

/* loaded from: classes.dex */
public final class m3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7374a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7376c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7378e;

    /* renamed from: b, reason: collision with root package name */
    public String f7375b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f7377d = "";

    /* renamed from: f, reason: collision with root package name */
    public i3 f7379f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f7380g = -1;

    public static m3 a(byte[] bArr) {
        m3 m3Var = new m3();
        m3Var.a(bArr);
        return m3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7380g < 0) {
            b();
        }
        return this.f7380g;
    }

    /* renamed from: a, reason: collision with other method in class */
    public i3 m294a() {
        return this.f7379f;
    }

    @Override // c.k.d.s2
    public m3 a(b0 b0Var) {
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
                i3 i3Var = new i3();
                b0Var.a(i3Var);
                a(i3Var);
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public m3 a(i3 i3Var) {
        if (i3Var == null) {
            throw null;
        }
        this.f7378e = true;
        this.f7379f = i3Var;
        return this;
    }

    public m3 a(String str) {
        this.f7374a = true;
        this.f7375b = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m295a() {
        return this.f7375b;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m296a()) {
            c1Var.m104a(1, m295a());
        }
        if (m298b()) {
            c1Var.m104a(2, m297b());
        }
        if (c()) {
            c1Var.m103a(3, (s2) m294a());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m296a() {
        return this.f7374a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m296a() ? 0 + c1.a(1, m295a()) : 0;
        if (m298b()) {
            a2 += c1.a(2, m297b());
        }
        if (c()) {
            a2 += c1.a(3, (s2) m294a());
        }
        this.f7380g = a2;
        return a2;
    }

    public m3 b(String str) {
        this.f7376c = true;
        this.f7377d = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m297b() {
        return this.f7377d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m298b() {
        return this.f7376c;
    }

    public boolean c() {
        return this.f7378e;
    }
}
