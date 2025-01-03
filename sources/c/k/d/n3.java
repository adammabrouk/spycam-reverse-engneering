package c.k.d;

/* loaded from: classes.dex */
public final class n3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7408a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7410c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7412e;

    /* renamed from: b, reason: collision with root package name */
    public String f7409b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f7411d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f7413f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f7414g = -1;

    public static n3 a(byte[] bArr) {
        n3 n3Var = new n3();
        n3Var.a(bArr);
        return n3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7414g < 0) {
            b();
        }
        return this.f7414g;
    }

    @Override // c.k.d.s2
    public n3 a(b0 b0Var) {
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
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public n3 a(String str) {
        this.f7408a = true;
        this.f7409b = str;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m302a() {
        return this.f7409b;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m303a()) {
            c1Var.m104a(1, m302a());
        }
        if (m305b()) {
            c1Var.m104a(2, m304b());
        }
        if (m306c()) {
            c1Var.m104a(3, c());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m303a() {
        return this.f7408a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m303a() ? 0 + c1.a(1, m302a()) : 0;
        if (m305b()) {
            a2 += c1.a(2, m304b());
        }
        if (m306c()) {
            a2 += c1.a(3, c());
        }
        this.f7414g = a2;
        return a2;
    }

    public n3 b(String str) {
        this.f7410c = true;
        this.f7411d = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m304b() {
        return this.f7411d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m305b() {
        return this.f7410c;
    }

    public n3 c(String str) {
        this.f7412e = true;
        this.f7413f = str;
        return this;
    }

    public String c() {
        return this.f7413f;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m306c() {
        return this.f7412e;
    }
}
