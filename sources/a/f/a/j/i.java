package a.f.a.j;

import a.f.a.j.e;
import a.f.a.j.f;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class i extends f {
    public float k0 = -1.0f;
    public int l0 = -1;
    public int m0 = -1;
    public e n0 = this.t;
    public int o0 = 0;
    public boolean p0 = false;

    /* compiled from: Guideline.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f810a;

        static {
            int[] iArr = new int[e.d.values().length];
            f810a = iArr;
            try {
                iArr[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f810a[e.d.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f810a[e.d.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f810a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f810a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f810a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f810a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f810a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f810a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public i() {
        new l();
        this.B.clear();
        this.B.add(this.n0);
        int length = this.A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.A[i2] = this.n0;
        }
    }

    public int K() {
        return this.o0;
    }

    @Override // a.f.a.j.f
    public e a(e.d dVar) {
        switch (a.f810a[dVar.ordinal()]) {
            case 1:
            case 2:
                if (this.o0 == 1) {
                    return this.n0;
                }
                break;
            case 3:
            case 4:
                if (this.o0 == 0) {
                    return this.n0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(dVar.name());
    }

    @Override // a.f.a.j.f
    public boolean b() {
        return true;
    }

    @Override // a.f.a.j.f
    public ArrayList<e> c() {
        return this.B;
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.k0 = f2;
            this.l0 = -1;
            this.m0 = -1;
        }
    }

    public void u(int i2) {
        if (i2 > -1) {
            this.k0 = -1.0f;
            this.l0 = i2;
            this.m0 = -1;
        }
    }

    public void v(int i2) {
        if (i2 > -1) {
            this.k0 = -1.0f;
            this.l0 = -1;
            this.m0 = i2;
        }
    }

    public void w(int i2) {
        if (this.o0 == i2) {
            return;
        }
        this.o0 = i2;
        this.B.clear();
        if (this.o0 == 1) {
            this.n0 = this.s;
        } else {
            this.n0 = this.t;
        }
        this.B.add(this.n0);
        int length = this.A.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.A[i3] = this.n0;
        }
    }

    @Override // a.f.a.j.f
    public void c(a.f.a.e eVar) {
        if (l() == null) {
            return;
        }
        int b2 = eVar.b(this.n0);
        if (this.o0 == 1) {
            s(b2);
            t(0);
            h(l().j());
            p(0);
            return;
        }
        s(0);
        t(b2);
        p(l().t());
        h(0);
    }

    @Override // a.f.a.j.f
    public void a(int i2) {
        f l = l();
        if (l == null) {
            return;
        }
        if (K() == 1) {
            this.t.d().a(1, l.t.d(), 0);
            this.v.d().a(1, l.t.d(), 0);
            if (this.l0 != -1) {
                this.s.d().a(1, l.s.d(), this.l0);
                this.u.d().a(1, l.s.d(), this.l0);
                return;
            } else if (this.m0 != -1) {
                this.s.d().a(1, l.u.d(), -this.m0);
                this.u.d().a(1, l.u.d(), -this.m0);
                return;
            } else {
                if (this.k0 == -1.0f || l.k() != f.b.FIXED) {
                    return;
                }
                int i3 = (int) (l.E * this.k0);
                this.s.d().a(1, l.s.d(), i3);
                this.u.d().a(1, l.s.d(), i3);
                return;
            }
        }
        this.s.d().a(1, l.s.d(), 0);
        this.u.d().a(1, l.s.d(), 0);
        if (this.l0 != -1) {
            this.t.d().a(1, l.t.d(), this.l0);
            this.v.d().a(1, l.t.d(), this.l0);
        } else if (this.m0 != -1) {
            this.t.d().a(1, l.v.d(), -this.m0);
            this.v.d().a(1, l.v.d(), -this.m0);
        } else {
            if (this.k0 == -1.0f || l.r() != f.b.FIXED) {
                return;
            }
            int i4 = (int) (l.F * this.k0);
            this.t.d().a(1, l.t.d(), i4);
            this.v.d().a(1, l.t.d(), i4);
        }
    }

    @Override // a.f.a.j.f
    public void a(a.f.a.e eVar) {
        g gVar = (g) l();
        if (gVar == null) {
            return;
        }
        e a2 = gVar.a(e.d.LEFT);
        e a3 = gVar.a(e.d.RIGHT);
        f fVar = this.D;
        boolean z = fVar != null && fVar.C[0] == f.b.WRAP_CONTENT;
        if (this.o0 == 0) {
            a2 = gVar.a(e.d.TOP);
            a3 = gVar.a(e.d.BOTTOM);
            f fVar2 = this.D;
            z = fVar2 != null && fVar2.C[1] == f.b.WRAP_CONTENT;
        }
        if (this.l0 != -1) {
            a.f.a.i a4 = eVar.a(this.n0);
            eVar.a(a4, eVar.a(a2), this.l0, 6);
            if (z) {
                eVar.b(eVar.a(a3), a4, 0, 5);
                return;
            }
            return;
        }
        if (this.m0 == -1) {
            if (this.k0 != -1.0f) {
                eVar.a(a.f.a.e.a(eVar, eVar.a(this.n0), eVar.a(a2), eVar.a(a3), this.k0, this.p0));
                return;
            }
            return;
        }
        a.f.a.i a5 = eVar.a(this.n0);
        a.f.a.i a6 = eVar.a(a3);
        eVar.a(a5, a6, -this.m0, 6);
        if (z) {
            eVar.b(a5, eVar.a(a2), 0, 5);
            eVar.b(a6, a5, 0, 5);
        }
    }
}
