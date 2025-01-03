package a.f.a.j;

import a.f.a.j.f;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public f f767a;

    /* renamed from: b, reason: collision with root package name */
    public f f768b;

    /* renamed from: c, reason: collision with root package name */
    public f f769c;

    /* renamed from: d, reason: collision with root package name */
    public f f770d;

    /* renamed from: e, reason: collision with root package name */
    public f f771e;

    /* renamed from: f, reason: collision with root package name */
    public f f772f;

    /* renamed from: g, reason: collision with root package name */
    public f f773g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<f> f774h;

    /* renamed from: i, reason: collision with root package name */
    public int f775i;
    public int j;
    public float k = 0.0f;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    public d(f fVar, int i2, boolean z) {
        this.m = false;
        this.f767a = fVar;
        this.l = i2;
        this.m = z;
    }

    public static boolean a(f fVar, int i2) {
        if (fVar.s() != 8 && fVar.C[i2] == f.b.MATCH_CONSTRAINT) {
            int[] iArr = fVar.f795g;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        int i2 = this.l * 2;
        f fVar = this.f767a;
        boolean z = false;
        f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.f775i++;
            f[] fVarArr = fVar.i0;
            int i3 = this.l;
            f fVar3 = null;
            fVarArr[i3] = null;
            fVar.h0[i3] = null;
            if (fVar.s() != 8) {
                if (this.f768b == null) {
                    this.f768b = fVar;
                }
                this.f770d = fVar;
                f.b[] bVarArr = fVar.C;
                int i4 = this.l;
                if (bVarArr[i4] == f.b.MATCH_CONSTRAINT) {
                    int[] iArr = fVar.f795g;
                    if (iArr[i4] == 0 || iArr[i4] == 3 || iArr[i4] == 2) {
                        this.j++;
                        float[] fArr = fVar.g0;
                        int i5 = this.l;
                        float f2 = fArr[i5];
                        if (f2 > 0.0f) {
                            this.k += fArr[i5];
                        }
                        if (a(fVar, this.l)) {
                            if (f2 < 0.0f) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.f774h == null) {
                                this.f774h = new ArrayList<>();
                            }
                            this.f774h.add(fVar);
                        }
                        if (this.f772f == null) {
                            this.f772f = fVar;
                        }
                        f fVar4 = this.f773g;
                        if (fVar4 != null) {
                            fVar4.h0[this.l] = fVar;
                        }
                        this.f773g = fVar;
                    }
                }
            }
            if (fVar2 != fVar) {
                fVar2.i0[this.l] = fVar;
            }
            e eVar = fVar.A[i2 + 1].f779d;
            if (eVar != null) {
                f fVar5 = eVar.f777b;
                e[] eVarArr = fVar5.A;
                if (eVarArr[i2].f779d != null && eVarArr[i2].f779d.f777b == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f769c = fVar;
        if (this.l == 0 && this.m) {
            this.f771e = fVar;
        } else {
            this.f771e = this.f767a;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
