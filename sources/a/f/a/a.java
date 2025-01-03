package a.f.a;

import a.f.a.i;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public final b f721b;

    /* renamed from: c, reason: collision with root package name */
    public final c f722c;

    /* renamed from: a, reason: collision with root package name */
    public int f720a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f723d = 8;

    /* renamed from: e, reason: collision with root package name */
    public i f724e = null;

    /* renamed from: f, reason: collision with root package name */
    public int[] f725f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public int[] f726g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    public float[] f727h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    public int f728i = -1;
    public int j = -1;
    public boolean k = false;

    public a(b bVar, c cVar) {
        this.f721b = bVar;
        this.f722c = cVar;
    }

    public final void a(i iVar, float f2) {
        if (f2 == 0.0f) {
            a(iVar, true);
            return;
        }
        int i2 = this.f728i;
        if (i2 == -1) {
            this.f728i = 0;
            this.f727h[0] = f2;
            this.f725f[0] = iVar.f758b;
            this.f726g[0] = -1;
            iVar.j++;
            iVar.a(this.f721b);
            this.f720a++;
            if (this.k) {
                return;
            }
            int i3 = this.j + 1;
            this.j = i3;
            int[] iArr = this.f725f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f720a; i5++) {
            int[] iArr2 = this.f725f;
            int i6 = iArr2[i2];
            int i7 = iVar.f758b;
            if (i6 == i7) {
                this.f727h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f726g[i2];
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f725f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f725f;
        if (i8 >= iArr4.length && this.f720a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f725f;
                if (i10 >= iArr5.length) {
                    break;
                }
                if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr6 = this.f725f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f723d * 2;
            this.f723d = i11;
            this.k = false;
            this.j = i8 - 1;
            this.f727h = Arrays.copyOf(this.f727h, i11);
            this.f725f = Arrays.copyOf(this.f725f, this.f723d);
            this.f726g = Arrays.copyOf(this.f726g, this.f723d);
        }
        this.f725f[i8] = iVar.f758b;
        this.f727h[i8] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f726g;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.f726g[i8] = this.f728i;
            this.f728i = i8;
        }
        iVar.j++;
        iVar.a(this.f721b);
        this.f720a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f720a >= this.f725f.length) {
            this.k = true;
        }
        int i12 = this.j;
        int[] iArr8 = this.f725f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public void b() {
        int i2 = this.f728i;
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            float[] fArr = this.f727h;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f726g[i2];
        }
    }

    public String toString() {
        int i2 = this.f728i;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            str = ((str + " -> ") + this.f727h[i2] + " : ") + this.f722c.f736c[this.f725f[i2]];
            i2 = this.f726g[i2];
        }
        return str;
    }

    public final float b(int i2) {
        int i3 = this.f728i;
        for (int i4 = 0; i3 != -1 && i4 < this.f720a; i4++) {
            if (i4 == i2) {
                return this.f727h[i3];
            }
            i3 = this.f726g[i3];
        }
        return 0.0f;
    }

    public final float b(i iVar) {
        int i2 = this.f728i;
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            if (this.f725f[i2] == iVar.f758b) {
                return this.f727h[i2];
            }
            i2 = this.f726g[i2];
        }
        return 0.0f;
    }

    public final void a(i iVar, float f2, boolean z) {
        if (f2 == 0.0f) {
            return;
        }
        int i2 = this.f728i;
        if (i2 == -1) {
            this.f728i = 0;
            this.f727h[0] = f2;
            this.f725f[0] = iVar.f758b;
            this.f726g[0] = -1;
            iVar.j++;
            iVar.a(this.f721b);
            this.f720a++;
            if (this.k) {
                return;
            }
            int i3 = this.j + 1;
            this.j = i3;
            int[] iArr = this.f725f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f720a; i5++) {
            int[] iArr2 = this.f725f;
            int i6 = iArr2[i2];
            int i7 = iVar.f758b;
            if (i6 == i7) {
                float[] fArr = this.f727h;
                fArr[i2] = fArr[i2] + f2;
                if (fArr[i2] == 0.0f) {
                    if (i2 == this.f728i) {
                        this.f728i = this.f726g[i2];
                    } else {
                        int[] iArr3 = this.f726g;
                        iArr3[i4] = iArr3[i2];
                    }
                    if (z) {
                        iVar.b(this.f721b);
                    }
                    if (this.k) {
                        this.j = i2;
                    }
                    iVar.j--;
                    this.f720a--;
                    return;
                }
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f726g[i2];
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr4 = this.f725f;
            if (iArr4[i8] != -1) {
                i8 = iArr4.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr5 = this.f725f;
        if (i8 >= iArr5.length && this.f720a < iArr5.length) {
            int i10 = 0;
            while (true) {
                int[] iArr6 = this.f725f;
                if (i10 >= iArr6.length) {
                    break;
                }
                if (iArr6[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr7 = this.f725f;
        if (i8 >= iArr7.length) {
            i8 = iArr7.length;
            int i11 = this.f723d * 2;
            this.f723d = i11;
            this.k = false;
            this.j = i8 - 1;
            this.f727h = Arrays.copyOf(this.f727h, i11);
            this.f725f = Arrays.copyOf(this.f725f, this.f723d);
            this.f726g = Arrays.copyOf(this.f726g, this.f723d);
        }
        this.f725f[i8] = iVar.f758b;
        this.f727h[i8] = f2;
        if (i4 != -1) {
            int[] iArr8 = this.f726g;
            iArr8[i8] = iArr8[i4];
            iArr8[i4] = i8;
        } else {
            this.f726g[i8] = this.f728i;
            this.f728i = i8;
        }
        iVar.j++;
        iVar.a(this.f721b);
        this.f720a++;
        if (!this.k) {
            this.j++;
        }
        int i12 = this.j;
        int[] iArr9 = this.f725f;
        if (i12 >= iArr9.length) {
            this.k = true;
            this.j = iArr9.length - 1;
        }
    }

    public final float a(i iVar, boolean z) {
        if (this.f724e == iVar) {
            this.f724e = null;
        }
        int i2 = this.f728i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f720a) {
            if (this.f725f[i2] == iVar.f758b) {
                if (i2 == this.f728i) {
                    this.f728i = this.f726g[i2];
                } else {
                    int[] iArr = this.f726g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.b(this.f721b);
                }
                iVar.j--;
                this.f720a--;
                this.f725f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.f727h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f726g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.f728i;
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            i iVar = this.f722c.f736c[this.f725f[i2]];
            if (iVar != null) {
                iVar.b(this.f721b);
            }
            i2 = this.f726g[i2];
        }
        this.f728i = -1;
        this.j = -1;
        this.k = false;
        this.f720a = 0;
    }

    public final boolean a(i iVar) {
        int i2 = this.f728i;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            if (this.f725f[i2] == iVar.f758b) {
                return true;
            }
            i2 = this.f726g[i2];
        }
        return false;
    }

    public void a(float f2) {
        int i2 = this.f728i;
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            float[] fArr = this.f727h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f726g[i2];
        }
    }

    public final boolean a(i iVar, e eVar) {
        return iVar.j <= 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a.f.a.i a(a.f.a.e r15) {
        /*
            r14 = this;
            int r0 = r14.f728i
            r1 = 0
            r2 = 0
            r3 = 0
            r2 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        Lb:
            r9 = -1
            if (r0 == r9) goto L98
            int r9 = r14.f720a
            if (r4 >= r9) goto L98
            float[] r9 = r14.f727h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            a.f.a.c r12 = r14.f722c
            a.f.a.i[] r12 = r12.f736c
            int[] r13 = r14.f725f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L36
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L42
            r9[r0] = r3
            a.f.a.b r9 = r14.f721b
            r12.b(r9)
            goto L41
        L36:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L42
            r9[r0] = r3
            a.f.a.b r9 = r14.f721b
            r12.b(r9)
        L41:
            r10 = 0
        L42:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L90
            a.f.a.i$a r11 = r12.f763g
            a.f.a.i$a r13 = a.f.a.i.a.UNRESTRICTED
            if (r11 != r13) goto L6c
            if (r2 != 0) goto L57
            boolean r2 = r14.a(r12, r15)
        L53:
            r5 = r2
            r7 = r10
            r2 = r12
            goto L90
        L57:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L60
            boolean r2 = r14.a(r12, r15)
            goto L53
        L60:
            if (r5 != 0) goto L90
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L90
            r7 = r10
            r2 = r12
            r5 = 1
            goto L90
        L6c:
            if (r2 != 0) goto L90
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L90
            if (r1 != 0) goto L7c
            boolean r1 = r14.a(r12, r15)
        L78:
            r6 = r1
            r8 = r10
            r1 = r12
            goto L90
        L7c:
            int r11 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r11 <= 0) goto L85
            boolean r1 = r14.a(r12, r15)
            goto L78
        L85:
            if (r6 != 0) goto L90
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L90
            r8 = r10
            r1 = r12
            r6 = 1
        L90:
            int[] r9 = r14.f726g
            r0 = r9[r0]
            int r4 = r4 + 1
            goto Lb
        L98:
            if (r2 == 0) goto L9b
            return r2
        L9b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.a.a(a.f.a.e):a.f.a.i");
    }

    public final void a(b bVar, b bVar2, boolean z) {
        int i2 = this.f728i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
                int i4 = this.f725f[i2];
                i iVar = bVar2.f729a;
                if (i4 == iVar.f758b) {
                    float f2 = this.f727h[i2];
                    a(iVar, z);
                    a aVar = bVar2.f732d;
                    int i5 = aVar.f728i;
                    for (int i6 = 0; i5 != -1 && i6 < aVar.f720a; i6++) {
                        a(this.f722c.f736c[aVar.f725f[i5]], aVar.f727h[i5] * f2, z);
                        i5 = aVar.f726g[i5];
                    }
                    bVar.f730b += bVar2.f730b * f2;
                    if (z) {
                        bVar2.f729a.b(bVar);
                    }
                    i2 = this.f728i;
                } else {
                    i2 = this.f726g[i2];
                }
            }
            return;
        }
    }

    public void a(b bVar, b[] bVarArr) {
        int i2 = this.f728i;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
                i iVar = this.f722c.f736c[this.f725f[i2]];
                if (iVar.f759c != -1) {
                    float f2 = this.f727h[i2];
                    a(iVar, true);
                    b bVar2 = bVarArr[iVar.f759c];
                    if (!bVar2.f733e) {
                        a aVar = bVar2.f732d;
                        int i4 = aVar.f728i;
                        for (int i5 = 0; i4 != -1 && i5 < aVar.f720a; i5++) {
                            a(this.f722c.f736c[aVar.f725f[i4]], aVar.f727h[i4] * f2, true);
                            i4 = aVar.f726g[i4];
                        }
                    }
                    bVar.f730b += bVar2.f730b * f2;
                    bVar2.f729a.b(bVar);
                    i2 = this.f728i;
                } else {
                    i2 = this.f726g[i2];
                }
            }
            return;
        }
    }

    public i a(boolean[] zArr, i iVar) {
        i.a aVar;
        int i2 = this.f728i;
        i iVar2 = null;
        float f2 = 0.0f;
        for (int i3 = 0; i2 != -1 && i3 < this.f720a; i3++) {
            if (this.f727h[i2] < 0.0f) {
                i iVar3 = this.f722c.f736c[this.f725f[i2]];
                if ((zArr == null || !zArr[iVar3.f758b]) && iVar3 != iVar && ((aVar = iVar3.f763g) == i.a.SLACK || aVar == i.a.ERROR)) {
                    float f3 = this.f727h[i2];
                    if (f3 < f2) {
                        iVar2 = iVar3;
                        f2 = f3;
                    }
                }
            }
            i2 = this.f726g[i2];
        }
        return iVar2;
    }

    public final i a(int i2) {
        int i3 = this.f728i;
        for (int i4 = 0; i3 != -1 && i4 < this.f720a; i4++) {
            if (i4 == i2) {
                return this.f722c.f736c[this.f725f[i3]];
            }
            i3 = this.f726g[i3];
        }
        return null;
    }
}
