package a.f.a;

import a.f.a.i;
import a.f.a.j.e;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class e {
    public static int p = 1000;
    public static f q;

    /* renamed from: c, reason: collision with root package name */
    public a f739c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f742f;
    public final c l;
    public final a o;

    /* renamed from: a, reason: collision with root package name */
    public int f737a = 0;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, i> f738b = null;

    /* renamed from: d, reason: collision with root package name */
    public int f740d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f741e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f743g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f744h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f745i = 1;
    public int j = 0;
    public int k = 32;
    public i[] m = new i[p];
    public int n = 0;

    /* compiled from: LinearSystem.java */
    public interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        this.f742f = null;
        this.f742f = new b[32];
        h();
        c cVar = new c();
        this.l = cVar;
        this.f739c = new d(cVar);
        this.o = new b(this.l);
    }

    public static f j() {
        return q;
    }

    public i a(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f745i + 1 >= this.f741e) {
            f();
        }
        if (obj instanceof a.f.a.j.e) {
            a.f.a.j.e eVar = (a.f.a.j.e) obj;
            iVar = eVar.e();
            if (iVar == null) {
                eVar.a(this.l);
                iVar = eVar.e();
            }
            int i2 = iVar.f758b;
            if (i2 == -1 || i2 > this.f737a || this.l.f736c[i2] == null) {
                if (iVar.f758b != -1) {
                    iVar.a();
                }
                int i3 = this.f737a + 1;
                this.f737a = i3;
                this.f745i++;
                iVar.f758b = i3;
                iVar.f763g = i.a.UNRESTRICTED;
                this.l.f736c[i3] = iVar;
            }
        }
        return iVar;
    }

    public i b() {
        f fVar = q;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.f745i + 1 >= this.f741e) {
            f();
        }
        i a2 = a(i.a.SLACK, (String) null);
        int i2 = this.f737a + 1;
        this.f737a = i2;
        this.f745i++;
        a2.f758b = i2;
        this.l.f736c[i2] = a2;
        return a2;
    }

    public b c() {
        b a2 = this.l.f734a.a();
        if (a2 == null) {
            a2 = new b(this.l);
        } else {
            a2.d();
        }
        i.b();
        return a2;
    }

    public i d() {
        f fVar = q;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.f745i + 1 >= this.f741e) {
            f();
        }
        i a2 = a(i.a.SLACK, (String) null);
        int i2 = this.f737a + 1;
        this.f737a = i2;
        this.f745i++;
        a2.f758b = i2;
        this.l.f736c[i2] = a2;
        return a2;
    }

    public c e() {
        return this.l;
    }

    public final void f() {
        int i2 = this.f740d * 2;
        this.f740d = i2;
        this.f742f = (b[]) Arrays.copyOf(this.f742f, i2);
        c cVar = this.l;
        cVar.f736c = (i[]) Arrays.copyOf(cVar.f736c, this.f740d);
        int i3 = this.f740d;
        this.f744h = new boolean[i3];
        this.f741e = i3;
        this.k = i3;
        f fVar = q;
        if (fVar != null) {
            fVar.f749d++;
            fVar.o = Math.max(fVar.o, i3);
            f fVar2 = q;
            fVar2.A = fVar2.o;
        }
    }

    public void g() throws Exception {
        f fVar = q;
        if (fVar != null) {
            fVar.f750e++;
        }
        if (!this.f743g) {
            b(this.f739c);
            return;
        }
        f fVar2 = q;
        if (fVar2 != null) {
            fVar2.q++;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.j) {
                z = true;
                break;
            } else if (!this.f742f[i2].f733e) {
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            b(this.f739c);
            return;
        }
        f fVar3 = q;
        if (fVar3 != null) {
            fVar3.p++;
        }
        a();
    }

    public final void h() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f742f;
            if (i2 >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i2];
            if (bVar != null) {
                this.l.f734a.a(bVar);
            }
            this.f742f[i2] = null;
            i2++;
        }
    }

    public void i() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.l;
            i[] iVarArr = cVar.f736c;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.a();
            }
            i2++;
        }
        cVar.f735b.a(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.l.f736c, (Object) null);
        HashMap<String, i> hashMap = this.f738b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f737a = 0;
        this.f739c.clear();
        this.f745i = 1;
        for (int i3 = 0; i3 < this.j; i3++) {
            this.f742f[i3].f731c = false;
        }
        h();
        this.j = 0;
    }

    public final void c(b bVar) {
        b[] bVarArr = this.f742f;
        int i2 = this.j;
        if (bVarArr[i2] != null) {
            this.l.f734a.a(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f742f;
        int i3 = this.j;
        bVarArr2[i3] = bVar;
        i iVar = bVar.f729a;
        iVar.f759c = i3;
        this.j = i3 + 1;
        iVar.c(bVar);
    }

    public final void b(b bVar) {
        bVar.a(this, 0);
    }

    public final void d(b bVar) {
        if (this.j > 0) {
            bVar.f732d.a(bVar, this.f742f);
            if (bVar.f732d.f720a == 0) {
                bVar.f733e = true;
            }
        }
    }

    public int b(Object obj) {
        i e2 = ((a.f.a.j.e) obj).e();
        if (e2 != null) {
            return (int) (e2.f761e + 0.5f);
        }
        return 0;
    }

    public void c(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        i d2 = d();
        d2.f760d = 0;
        c2.b(iVar, iVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f732d.b(d2) * (-1.0f)), i3);
        }
        a(c2);
    }

    public void b(a aVar) throws Exception {
        f fVar = q;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.f745i);
            f fVar2 = q;
            fVar2.u = Math.max(fVar2.u, this.j);
        }
        d((b) aVar);
        a(aVar);
        a(aVar, false);
        a();
    }

    public void a(b bVar, int i2, int i3) {
        bVar.a(a(i3, (String) null), i2);
    }

    public i a(int i2, String str) {
        f fVar = q;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.f745i + 1 >= this.f741e) {
            f();
        }
        i a2 = a(i.a.ERROR, str);
        int i3 = this.f737a + 1;
        this.f737a = i3;
        this.f745i++;
        a2.f758b = i3;
        a2.f760d = i2;
        this.l.f736c[i3] = a2;
        this.f739c.a(a2);
        return a2;
    }

    public void b(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        i d2 = d();
        d2.f760d = 0;
        c2.a(iVar, iVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f732d.b(d2) * (-1.0f)), i3);
        }
        a(c2);
    }

    public final i a(i.a aVar, String str) {
        i a2 = this.l.f735b.a();
        if (a2 == null) {
            a2 = new i(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.a();
            a2.a(aVar, str);
        }
        int i2 = this.n;
        int i3 = p;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            p = i4;
            this.m = (i[]) Arrays.copyOf(this.m, i4);
        }
        i[] iVarArr = this.m;
        int i5 = this.n;
        this.n = i5 + 1;
        iVarArr[i5] = a2;
        return a2;
    }

    public void b(i iVar, i iVar2, boolean z) {
        b c2 = c();
        i d2 = d();
        d2.f760d = 0;
        c2.b(iVar, iVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f732d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void a(b bVar) {
        i c2;
        if (bVar == null) {
            return;
        }
        f fVar = q;
        if (fVar != null) {
            fVar.f751f++;
            if (bVar.f733e) {
                fVar.f752g++;
            }
        }
        boolean z = true;
        if (this.j + 1 >= this.k || this.f745i + 1 >= this.f741e) {
            f();
        }
        boolean z2 = false;
        if (!bVar.f733e) {
            d(bVar);
            if (bVar.c()) {
                return;
            }
            bVar.a();
            if (bVar.a(this)) {
                i b2 = b();
                bVar.f729a = b2;
                c(bVar);
                this.o.a(bVar);
                a(this.o, true);
                if (b2.f759c == -1) {
                    if (bVar.f729a == b2 && (c2 = bVar.c(b2)) != null) {
                        f fVar2 = q;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.d(c2);
                    }
                    if (!bVar.f733e) {
                        bVar.f729a.c(bVar);
                    }
                    this.j--;
                }
            } else {
                z = false;
            }
            if (!bVar.b()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        c(bVar);
    }

    public final int a(a aVar, boolean z) {
        f fVar = q;
        if (fVar != null) {
            fVar.f753h++;
        }
        for (int i2 = 0; i2 < this.f745i; i2++) {
            this.f744h[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.f754i++;
            }
            i3++;
            if (i3 >= this.f745i * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f744h[aVar.getKey().f758b] = true;
            }
            i a2 = aVar.a(this, this.f744h);
            if (a2 != null) {
                boolean[] zArr = this.f744h;
                int i4 = a2.f758b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.j; i6++) {
                    b bVar = this.f742f[i6];
                    if (bVar.f729a.f763g != i.a.UNRESTRICTED && !bVar.f733e && bVar.b(a2)) {
                        float b2 = bVar.f732d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f730b) / b2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f742f[i5];
                    bVar2.f729a.f759c = -1;
                    f fVar3 = q;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(a2);
                    i iVar = bVar2.f729a;
                    iVar.f759c = i5;
                    iVar.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public final int a(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f742f;
            if (bVarArr[i2].f729a.f763g != i.a.UNRESTRICTED && bVarArr[i2].f730b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar = q;
            if (fVar != null) {
                fVar.k++;
            }
            i3++;
            float f3 = Float.MAX_VALUE;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            while (i4 < this.j) {
                b bVar = this.f742f[i4];
                if (bVar.f729a.f763g != i.a.UNRESTRICTED && !bVar.f733e && bVar.f730b < f2) {
                    int i8 = 1;
                    while (i8 < this.f745i) {
                        i iVar = this.l.f736c[i8];
                        float b2 = bVar.f732d.b(iVar);
                        if (b2 > f2) {
                            for (int i9 = 0; i9 < 7; i9++) {
                                float f4 = iVar.f762f[i9] / b2;
                                if ((f4 < f3 && i9 == i7) || i9 > i7) {
                                    i6 = i8;
                                    i7 = i9;
                                    f3 = f4;
                                    i5 = i4;
                                }
                            }
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                b bVar2 = this.f742f[i5];
                bVar2.f729a.f759c = -1;
                f fVar2 = q;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.d(this.l.f736c[i6]);
                i iVar2 = bVar2.f729a;
                iVar2.f759c = i5;
                iVar2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.f745i / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    public final void a() {
        for (int i2 = 0; i2 < this.j; i2++) {
            b bVar = this.f742f[i2];
            bVar.f729a.f761e = bVar.f730b;
        }
    }

    public void a(i iVar, i iVar2, boolean z) {
        b c2 = c();
        i d2 = d();
        d2.f760d = 0;
        c2.a(iVar, iVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f732d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        b c2 = c();
        c2.a(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 6) {
            c2.a(this, i4);
        }
        a(c2);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        b c2 = c();
        c2.a(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 6) {
            c2.a(this, i2);
        }
        a(c2);
    }

    public b a(i iVar, i iVar2, int i2, int i3) {
        b c2 = c();
        c2.a(iVar, iVar2, i2);
        if (i3 != 6) {
            c2.a(this, i3);
        }
        a(c2);
        return c2;
    }

    public void a(i iVar, int i2) {
        int i3 = iVar.f759c;
        if (i3 != -1) {
            b bVar = this.f742f[i3];
            if (bVar.f733e) {
                bVar.f730b = i2;
                return;
            }
            if (bVar.f732d.f720a == 0) {
                bVar.f733e = true;
                bVar.f730b = i2;
                return;
            } else {
                b c2 = c();
                c2.c(iVar, i2);
                a(c2);
                return;
            }
        }
        b c3 = c();
        c3.b(iVar, i2);
        a(c3);
    }

    public static b a(e eVar, i iVar, i iVar2, i iVar3, float f2, boolean z) {
        b c2 = eVar.c();
        if (z) {
            eVar.b(c2);
        }
        c2.a(iVar, iVar2, iVar3, f2);
        return c2;
    }

    public void a(a.f.a.j.f fVar, a.f.a.j.f fVar2, float f2, int i2) {
        i a2 = a(fVar.a(e.d.LEFT));
        i a3 = a(fVar.a(e.d.TOP));
        i a4 = a(fVar.a(e.d.RIGHT));
        i a5 = a(fVar.a(e.d.BOTTOM));
        i a6 = a(fVar2.a(e.d.LEFT));
        i a7 = a(fVar2.a(e.d.TOP));
        i a8 = a(fVar2.a(e.d.RIGHT));
        i a9 = a(fVar2.a(e.d.BOTTOM));
        b c2 = c();
        double d2 = f2;
        double sin = Math.sin(d2);
        double d3 = i2;
        Double.isNaN(d3);
        c2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(c2);
        b c3 = c();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        c3.b(a2, a4, a6, a8, (float) (cos * d3));
        a(c3);
    }
}
