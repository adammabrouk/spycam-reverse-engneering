package c.k.d;

/* loaded from: classes.dex */
public final class p3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7487a;

    /* renamed from: b, reason: collision with root package name */
    public a f7488b = a.f6944c;

    /* renamed from: c, reason: collision with root package name */
    public int f7489c = -1;

    public static p3 a(byte[] bArr) {
        p3 p3Var = new p3();
        p3Var.a(bArr);
        return p3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7489c < 0) {
            b();
        }
        return this.f7489c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m331a() {
        return this.f7488b;
    }

    public p3 a(a aVar) {
        this.f7487a = true;
        this.f7488b = aVar;
        return this;
    }

    @Override // c.k.d.s2
    public p3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 10) {
                a(b0Var.m80a());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m332a()) {
            c1Var.m102a(1, m331a());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m332a() {
        return this.f7487a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m332a() ? 0 + c1.a(1, m331a()) : 0;
        this.f7489c = a2;
        return a2;
    }
}
