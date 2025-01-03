package c.k.d;

/* loaded from: classes.dex */
public final class q3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7760a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7762c;

    /* renamed from: b, reason: collision with root package name */
    public a f7761b = a.f6944c;

    /* renamed from: d, reason: collision with root package name */
    public i3 f7763d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f7764e = -1;

    public static q3 a(byte[] bArr) {
        q3 q3Var = new q3();
        q3Var.a(bArr);
        return q3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.f7764e < 0) {
            b();
        }
        return this.f7764e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m421a() {
        return this.f7761b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public i3 m422a() {
        return this.f7763d;
    }

    public q3 a(a aVar) {
        this.f7760a = true;
        this.f7761b = aVar;
        return this;
    }

    @Override // c.k.d.s2
    public q3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 10) {
                a(b0Var.m80a());
            } else if (m78a == 18) {
                i3 i3Var = new i3();
                b0Var.a(i3Var);
                a(i3Var);
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public q3 a(i3 i3Var) {
        if (i3Var == null) {
            throw null;
        }
        this.f7762c = true;
        this.f7763d = i3Var;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m423a()) {
            c1Var.m102a(1, m421a());
        }
        if (m424b()) {
            c1Var.m103a(2, (s2) m422a());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m423a() {
        return this.f7760a;
    }

    @Override // c.k.d.s2
    public int b() {
        int a2 = m423a() ? 0 + c1.a(1, m421a()) : 0;
        if (m424b()) {
            a2 += c1.a(2, (s2) m422a());
        }
        this.f7764e = a2;
        return a2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m424b() {
        return this.f7762c;
    }
}
