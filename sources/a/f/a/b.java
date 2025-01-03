package a.f.a;

import a.f.a.e;
import a.f.a.i;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f731c;

    /* renamed from: d, reason: collision with root package name */
    public final a f732d;

    /* renamed from: a, reason: collision with root package name */
    public i f729a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f730b = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public boolean f733e = false;

    public b(c cVar) {
        this.f732d = new a(this, cVar);
    }

    public b a(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f730b = i2;
        }
        if (z) {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
        } else {
            this.f732d.a(iVar, -1.0f);
            this.f732d.a(iVar2, 1.0f);
        }
        return this;
    }

    public boolean b() {
        i iVar = this.f729a;
        return iVar != null && (iVar.f763g == i.a.UNRESTRICTED || this.f730b >= 0.0f);
    }

    public b c(i iVar, int i2) {
        if (i2 < 0) {
            this.f730b = i2 * (-1);
            this.f732d.a(iVar, 1.0f);
        } else {
            this.f730b = i2;
            this.f732d.a(iVar, -1.0f);
        }
        return this;
    }

    @Override // a.f.a.e.a
    public void clear() {
        this.f732d.a();
        this.f729a = null;
        this.f730b = 0.0f;
    }

    public void d() {
        this.f729a = null;
        this.f732d.a();
        this.f730b = 0.0f;
        this.f733e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String e() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.b.e():java.lang.String");
    }

    @Override // a.f.a.e.a
    public i getKey() {
        return this.f729a;
    }

    public String toString() {
        return e();
    }

    public boolean b(i iVar) {
        return this.f732d.a(iVar);
    }

    public b b(i iVar, int i2) {
        this.f729a = iVar;
        float f2 = i2;
        iVar.f761e = f2;
        this.f730b = f2;
        this.f733e = true;
        return this;
    }

    public i c(i iVar) {
        return this.f732d.a((boolean[]) null, iVar);
    }

    public void d(i iVar) {
        i iVar2 = this.f729a;
        if (iVar2 != null) {
            this.f732d.a(iVar2, -1.0f);
            this.f729a = null;
        }
        float a2 = this.f732d.a(iVar, true) * (-1.0f);
        this.f729a = iVar;
        if (a2 == 1.0f) {
            return;
        }
        this.f730b /= a2;
        this.f732d.a(a2);
    }

    public b a(i iVar, int i2) {
        this.f732d.a(iVar, i2);
        return this;
    }

    public boolean c() {
        return this.f729a == null && this.f730b == 0.0f && this.f732d.f720a == 0;
    }

    public b a(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f730b = i2;
        }
        if (!z) {
            this.f732d.a(iVar, -1.0f);
            this.f732d.a(iVar2, 1.0f);
            this.f732d.a(iVar3, 1.0f);
        } else {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
            this.f732d.a(iVar3, -1.0f);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f730b = i2;
        }
        if (!z) {
            this.f732d.a(iVar, -1.0f);
            this.f732d.a(iVar2, 1.0f);
            this.f732d.a(iVar3, -1.0f);
        } else {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
            this.f732d.a(iVar3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f730b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
            this.f732d.a(iVar4, 1.0f);
            this.f732d.a(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f732d.a(iVar3, 1.0f);
            this.f732d.a(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
            this.f732d.a(iVar4, f5);
            this.f732d.a(iVar3, -f5);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f732d.a(iVar3, 0.5f);
        this.f732d.a(iVar4, 0.5f);
        this.f732d.a(iVar, -0.5f);
        this.f732d.a(iVar2, -0.5f);
        this.f730b = -f2;
        return this;
    }

    public b a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar4, 1.0f);
            this.f732d.a(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f732d.a(iVar, 1.0f);
            this.f732d.a(iVar2, -1.0f);
            this.f732d.a(iVar3, -1.0f);
            this.f732d.a(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f730b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.f732d.a(iVar, -1.0f);
            this.f732d.a(iVar2, 1.0f);
            this.f730b = i2;
        } else if (f2 >= 1.0f) {
            this.f732d.a(iVar3, -1.0f);
            this.f732d.a(iVar4, 1.0f);
            this.f730b = i3;
        } else {
            float f3 = 1.0f - f2;
            this.f732d.a(iVar, f3 * 1.0f);
            this.f732d.a(iVar2, f3 * (-1.0f));
            this.f732d.a(iVar3, (-1.0f) * f2);
            this.f732d.a(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f730b = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i2) {
        this.f732d.a(eVar.a(i2, "ep"), 1.0f);
        this.f732d.a(eVar.a(i2, "em"), -1.0f);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, float f2) {
        this.f732d.a(iVar, -1.0f);
        this.f732d.a(iVar2, 1.0f - f2);
        this.f732d.a(iVar3, f2);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f732d.a(iVar, -1.0f);
        this.f732d.a(iVar2, 1.0f);
        this.f732d.a(iVar3, f2);
        this.f732d.a(iVar4, -f2);
        return this;
    }

    public void a() {
        float f2 = this.f730b;
        if (f2 < 0.0f) {
            this.f730b = f2 * (-1.0f);
            this.f732d.b();
        }
    }

    public boolean a(e eVar) {
        boolean z;
        i a2 = this.f732d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.f732d.f720a == 0) {
            this.f733e = true;
        }
        return z;
    }

    @Override // a.f.a.e.a
    public i a(e eVar, boolean[] zArr) {
        return this.f732d.a(zArr, (i) null);
    }

    @Override // a.f.a.e.a
    public void a(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f729a = null;
        this.f732d.a();
        int i2 = 0;
        while (true) {
            a aVar2 = bVar.f732d;
            if (i2 >= aVar2.f720a) {
                return;
            }
            this.f732d.a(aVar2.a(i2), bVar.f732d.b(i2), true);
            i2++;
        }
    }

    @Override // a.f.a.e.a
    public void a(i iVar) {
        int i2 = iVar.f760d;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f732d.a(iVar, f2);
    }
}
