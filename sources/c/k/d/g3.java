package c.k.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g3 extends s2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7147a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7149c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7151e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7153g;

    /* renamed from: b, reason: collision with root package name */
    public int f7148b = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7150d = false;

    /* renamed from: f, reason: collision with root package name */
    public int f7152f = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7154h = false;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f7155i = Collections.emptyList();
    public int j = -1;

    public static g3 a(byte[] bArr) {
        g3 g3Var = new g3();
        g3Var.a(bArr);
        return g3Var;
    }

    public static g3 b(b0 b0Var) {
        g3 g3Var = new g3();
        g3Var.a(b0Var);
        return g3Var;
    }

    @Override // c.k.d.s2
    public int a() {
        if (this.j < 0) {
            b();
        }
        return this.j;
    }

    public g3 a(int i2) {
        this.f7147a = true;
        this.f7148b = i2;
        return this;
    }

    @Override // c.k.d.s2
    public g3 a(b0 b0Var) {
        while (true) {
            int m78a = b0Var.m78a();
            if (m78a == 0) {
                return this;
            }
            if (m78a == 8) {
                a(b0Var.c());
            } else if (m78a == 16) {
                a(b0Var.m84a());
            } else if (m78a == 24) {
                b(b0Var.b());
            } else if (m78a == 32) {
                b(b0Var.m84a());
            } else if (m78a == 42) {
                a(b0Var.m81a());
            } else if (!a(b0Var, m78a)) {
                return this;
            }
        }
    }

    public g3 a(String str) {
        if (str == null) {
            throw null;
        }
        if (this.f7155i.isEmpty()) {
            this.f7155i = new ArrayList();
        }
        this.f7155i.add(str);
        return this;
    }

    public g3 a(boolean z) {
        this.f7149c = true;
        this.f7150d = z;
        return this;
    }

    @Override // c.k.d.s2
    public /* bridge */ /* synthetic */ s2 a(b0 b0Var) {
        a(b0Var);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m167a() {
        return this.f7155i;
    }

    @Override // c.k.d.s2
    public void a(c1 c1Var) {
        if (m168a()) {
            c1Var.m113b(1, c());
        }
        if (m170c()) {
            c1Var.m105a(2, m169b());
        }
        if (m171d()) {
            c1Var.m100a(3, d());
        }
        if (f()) {
            c1Var.m105a(4, m172e());
        }
        Iterator<String> it = m167a().iterator();
        while (it.hasNext()) {
            c1Var.m104a(5, it.next());
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m168a() {
        return this.f7147a;
    }

    @Override // c.k.d.s2
    public int b() {
        int i2 = 0;
        int b2 = m168a() ? c1.b(1, c()) + 0 : 0;
        if (m170c()) {
            b2 += c1.a(2, m169b());
        }
        if (m171d()) {
            b2 += c1.a(3, d());
        }
        if (f()) {
            b2 += c1.a(4, m172e());
        }
        Iterator<String> it = m167a().iterator();
        while (it.hasNext()) {
            i2 += c1.a(it.next());
        }
        int size = b2 + i2 + (m167a().size() * 1);
        this.j = size;
        return size;
    }

    public g3 b(int i2) {
        this.f7151e = true;
        this.f7152f = i2;
        return this;
    }

    public g3 b(boolean z) {
        this.f7153g = true;
        this.f7154h = z;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m169b() {
        return this.f7150d;
    }

    public int c() {
        return this.f7148b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m170c() {
        return this.f7149c;
    }

    public int d() {
        return this.f7152f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m171d() {
        return this.f7151e;
    }

    public int e() {
        return this.f7155i.size();
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m172e() {
        return this.f7154h;
    }

    public boolean f() {
        return this.f7153g;
    }
}
