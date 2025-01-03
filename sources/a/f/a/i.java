package a.f.a;

import java.util.Arrays;

/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class i {
    public static int k = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f757a;

    /* renamed from: e, reason: collision with root package name */
    public float f761e;

    /* renamed from: g, reason: collision with root package name */
    public a f763g;

    /* renamed from: b, reason: collision with root package name */
    public int f758b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f759c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f760d = 0;

    /* renamed from: f, reason: collision with root package name */
    public float[] f762f = new float[7];

    /* renamed from: h, reason: collision with root package name */
    public b[] f764h = new b[8];

    /* renamed from: i, reason: collision with root package name */
    public int f765i = 0;
    public int j = 0;

    /* compiled from: SolverVariable.java */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f763g = aVar;
    }

    public static void b() {
        k++;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f765i;
            if (i2 >= i3) {
                b[] bVarArr = this.f764h;
                if (i3 >= bVarArr.length) {
                    this.f764h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f764h;
                int i4 = this.f765i;
                bVarArr2[i4] = bVar;
                this.f765i = i4 + 1;
                return;
            }
            if (this.f764h[i2] == bVar) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.f765i;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.f764h;
            bVarArr[i3].f732d.a(bVarArr[i3], bVar, false);
        }
        this.f765i = 0;
    }

    public String toString() {
        return "" + this.f757a;
    }

    public final void b(b bVar) {
        int i2 = this.f765i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f764h[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.f764h;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.f765i--;
                return;
            }
        }
    }

    public void a() {
        this.f757a = null;
        this.f763g = a.UNKNOWN;
        this.f760d = 0;
        this.f758b = -1;
        this.f759c = -1;
        this.f761e = 0.0f;
        this.f765i = 0;
        this.j = 0;
    }

    public void a(a aVar, String str) {
        this.f763g = aVar;
    }
}
