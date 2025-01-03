package a.f.a.j;

import a.f.a.j.e;

/* compiled from: ResolutionAnchor.java */
/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: c, reason: collision with root package name */
    public e f812c;

    /* renamed from: d, reason: collision with root package name */
    public m f813d;

    /* renamed from: e, reason: collision with root package name */
    public float f814e;

    /* renamed from: f, reason: collision with root package name */
    public m f815f;

    /* renamed from: g, reason: collision with root package name */
    public float f816g;

    /* renamed from: i, reason: collision with root package name */
    public m f818i;

    /* renamed from: h, reason: collision with root package name */
    public int f817h = 0;
    public n j = null;
    public int k = 1;
    public n l = null;
    public int m = 1;

    public m(e eVar) {
        this.f812c = eVar;
    }

    public String a(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(m mVar, float f2) {
        if (this.f821b == 0 || !(this.f815f == mVar || this.f816g == f2)) {
            this.f815f = mVar;
            this.f816g = f2;
            if (this.f821b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i2) {
        this.f817h = i2;
    }

    @Override // a.f.a.j.o
    public void d() {
        super.d();
        this.f813d = null;
        this.f814e = 0.0f;
        this.j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f815f = null;
        this.f816g = 0.0f;
        this.f818i = null;
        this.f817h = 0;
    }

    @Override // a.f.a.j.o
    public void e() {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float f2;
        float f3;
        float t;
        float f4;
        m mVar7;
        boolean z = true;
        if (this.f821b == 1 || this.f817h == 4) {
            return;
        }
        n nVar = this.j;
        if (nVar != null) {
            if (nVar.f821b != 1) {
                return;
            } else {
                this.f814e = this.k * nVar.f819c;
            }
        }
        n nVar2 = this.l;
        if (nVar2 != null) {
            if (nVar2.f821b != 1) {
                return;
            } else {
                float f5 = nVar2.f819c;
            }
        }
        if (this.f817h == 1 && ((mVar7 = this.f813d) == null || mVar7.f821b == 1)) {
            m mVar8 = this.f813d;
            if (mVar8 == null) {
                this.f815f = this;
                this.f816g = this.f814e;
            } else {
                this.f815f = mVar8.f815f;
                this.f816g = mVar8.f816g + this.f814e;
            }
            a();
            return;
        }
        if (this.f817h != 2 || (mVar4 = this.f813d) == null || mVar4.f821b != 1 || (mVar5 = this.f818i) == null || (mVar6 = mVar5.f813d) == null || mVar6.f821b != 1) {
            if (this.f817h != 3 || (mVar = this.f813d) == null || mVar.f821b != 1 || (mVar2 = this.f818i) == null || (mVar3 = mVar2.f813d) == null || mVar3.f821b != 1) {
                if (this.f817h == 5) {
                    this.f812c.f777b.H();
                    return;
                }
                return;
            }
            if (a.f.a.e.j() != null) {
                a.f.a.e.j().w++;
            }
            m mVar9 = this.f813d;
            this.f815f = mVar9.f815f;
            m mVar10 = this.f818i;
            m mVar11 = mVar10.f813d;
            mVar10.f815f = mVar11.f815f;
            this.f816g = mVar9.f816g + this.f814e;
            mVar10.f816g = mVar11.f816g + mVar10.f814e;
            a();
            this.f818i.a();
            return;
        }
        if (a.f.a.e.j() != null) {
            a.f.a.e.j().v++;
        }
        this.f815f = this.f813d.f815f;
        m mVar12 = this.f818i;
        mVar12.f815f = mVar12.f813d.f815f;
        e.d dVar = this.f812c.f778c;
        int i2 = 0;
        if (dVar != e.d.RIGHT && dVar != e.d.BOTTOM) {
            z = false;
        }
        if (z) {
            f2 = this.f813d.f816g;
            f3 = this.f818i.f813d.f816g;
        } else {
            f2 = this.f818i.f813d.f816g;
            f3 = this.f813d.f816g;
        }
        float f6 = f2 - f3;
        e.d dVar2 = this.f812c.f778c;
        if (dVar2 == e.d.LEFT || dVar2 == e.d.RIGHT) {
            t = f6 - this.f812c.f777b.t();
            f4 = this.f812c.f777b.V;
        } else {
            t = f6 - r2.f777b.j();
            f4 = this.f812c.f777b.W;
        }
        int b2 = this.f812c.b();
        int b3 = this.f818i.f812c.b();
        if (this.f812c.g() == this.f818i.f812c.g()) {
            f4 = 0.5f;
            b3 = 0;
        } else {
            i2 = b2;
        }
        float f7 = i2;
        float f8 = b3;
        float f9 = (t - f7) - f8;
        if (z) {
            m mVar13 = this.f818i;
            mVar13.f816g = mVar13.f813d.f816g + f8 + (f9 * f4);
            this.f816g = (this.f813d.f816g - f7) - (f9 * (1.0f - f4));
        } else {
            this.f816g = this.f813d.f816g + f7 + (f9 * f4);
            m mVar14 = this.f818i;
            mVar14.f816g = (mVar14.f813d.f816g - f8) - (f9 * (1.0f - f4));
        }
        a();
        this.f818i.a();
    }

    public float f() {
        return this.f816g;
    }

    public void g() {
        e g2 = this.f812c.g();
        if (g2 == null) {
            return;
        }
        if (g2.g() == this.f812c) {
            this.f817h = 4;
            g2.d().f817h = 4;
        }
        int b2 = this.f812c.b();
        e.d dVar = this.f812c.f778c;
        if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
            b2 = -b2;
        }
        a(g2.d(), b2);
    }

    public String toString() {
        if (this.f821b != 1) {
            return "{ " + this.f812c + " UNRESOLVED} type: " + a(this.f817h);
        }
        if (this.f815f == this) {
            return "[" + this.f812c + ", RESOLVED: " + this.f816g + "]  type: " + a(this.f817h);
        }
        return "[" + this.f812c + ", RESOLVED: " + this.f815f + ":" + this.f816g + "] type: " + a(this.f817h);
    }

    public void b(m mVar, float f2) {
        this.f818i = mVar;
    }

    public void b(m mVar, int i2, n nVar) {
        this.f818i = mVar;
        this.l = nVar;
        this.m = i2;
    }

    public void a(int i2, m mVar, int i3) {
        this.f817h = i2;
        this.f813d = mVar;
        this.f814e = i3;
        mVar.a(this);
    }

    public void a(m mVar, int i2) {
        this.f813d = mVar;
        this.f814e = i2;
        mVar.a(this);
    }

    public void a(m mVar, int i2, n nVar) {
        this.f813d = mVar;
        mVar.a(this);
        this.j = nVar;
        this.k = i2;
        nVar.a(this);
    }

    public void a(a.f.a.e eVar) {
        a.f.a.i e2 = this.f812c.e();
        m mVar = this.f815f;
        if (mVar == null) {
            eVar.a(e2, (int) (this.f816g + 0.5f));
        } else {
            eVar.a(e2, eVar.a(mVar.f812c), (int) (this.f816g + 0.5f), 6);
        }
    }
}
