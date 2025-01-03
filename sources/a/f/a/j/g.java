package a.f.a.j;

import a.f.a.j.e;
import a.f.a.j.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class g extends q {
    public p n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public boolean l0 = false;
    public a.f.a.e m0 = new a.f.a.e();
    public int s0 = 0;
    public int t0 = 0;
    public d[] u0 = new d[4];
    public d[] v0 = new d[4];
    public List<h> w0 = new ArrayList();
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean z0 = false;
    public int A0 = 0;
    public int B0 = 0;
    public int C0 = 7;
    public boolean D0 = false;
    public boolean E0 = false;
    public boolean F0 = false;

    @Override // a.f.a.j.q, a.f.a.j.f
    public void E() {
        this.m0.i();
        this.o0 = 0;
        this.q0 = 0;
        this.p0 = 0;
        this.r0 = 0;
        this.w0.clear();
        this.D0 = false;
        super.E();
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0292  */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // a.f.a.j.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void L() {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.j.g.L():void");
    }

    public int N() {
        return this.C0;
    }

    public boolean O() {
        return false;
    }

    public boolean P() {
        return this.F0;
    }

    public boolean Q() {
        return this.l0;
    }

    public boolean R() {
        return this.E0;
    }

    public void S() {
        if (!u(8)) {
            a(this.C0);
        }
        W();
    }

    public void T() {
        int size = this.k0.size();
        G();
        for (int i2 = 0; i2 < size; i2++) {
            this.k0.get(i2).G();
        }
    }

    public void U() {
        T();
        a(this.C0);
    }

    public final void V() {
        this.s0 = 0;
        this.t0 = 0;
    }

    public void W() {
        m d2 = a(e.d.LEFT).d();
        m d3 = a(e.d.TOP).d();
        d2.a((m) null, 0.0f);
        d3.a((m) null, 0.0f);
    }

    public void a(a.f.a.e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.k0.get(i2);
            fVar.c(eVar);
            if (fVar.C[0] == f.b.MATCH_CONSTRAINT && fVar.t() < fVar.v()) {
                zArr[2] = true;
            }
            if (fVar.C[1] == f.b.MATCH_CONSTRAINT && fVar.j() < fVar.u()) {
                zArr[2] = true;
            }
        }
    }

    public void c(boolean z) {
        this.l0 = z;
    }

    public boolean d(a.f.a.e eVar) {
        a(eVar);
        int size = this.k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.k0.get(i2);
            if (fVar instanceof g) {
                f.b[] bVarArr = fVar.C;
                f.b bVar = bVarArr[0];
                f.b bVar2 = bVarArr[1];
                if (bVar == f.b.WRAP_CONTENT) {
                    fVar.a(f.b.FIXED);
                }
                if (bVar2 == f.b.WRAP_CONTENT) {
                    fVar.b(f.b.FIXED);
                }
                fVar.a(eVar);
                if (bVar == f.b.WRAP_CONTENT) {
                    fVar.a(bVar);
                }
                if (bVar2 == f.b.WRAP_CONTENT) {
                    fVar.b(bVar2);
                }
            } else {
                k.a(this, eVar, fVar);
                fVar.a(eVar);
            }
        }
        if (this.s0 > 0) {
            c.a(this, eVar, 0);
        }
        if (this.t0 > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public final void e(f fVar) {
        int i2 = this.t0 + 1;
        d[] dVarArr = this.u0;
        if (i2 >= dVarArr.length) {
            this.u0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.u0[this.t0] = new d(fVar, 1, Q());
        this.t0++;
    }

    public void f(int i2, int i3) {
        n nVar;
        n nVar2;
        if (this.C[0] != f.b.WRAP_CONTENT && (nVar2 = this.f791c) != null) {
            nVar2.a(i2);
        }
        if (this.C[1] == f.b.WRAP_CONTENT || (nVar = this.f792d) == null) {
            return;
        }
        nVar.a(i3);
    }

    public boolean u(int i2) {
        return (this.C0 & i2) == i2;
    }

    public void v(int i2) {
        this.C0 = i2;
    }

    @Override // a.f.a.j.f
    public void a(int i2) {
        super.a(i2);
        int size = this.k0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.k0.get(i3).a(i2);
        }
    }

    public void a(f fVar, int i2) {
        if (i2 == 0) {
            d(fVar);
        } else if (i2 == 1) {
            e(fVar);
        }
    }

    public final void d(f fVar) {
        int i2 = this.s0 + 1;
        d[] dVarArr = this.v0;
        if (i2 >= dVarArr.length) {
            this.v0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.v0[this.s0] = new d(fVar, 0, Q());
        this.s0++;
    }
}
