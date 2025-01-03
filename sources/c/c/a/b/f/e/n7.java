package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class n7 {

    /* renamed from: f, reason: collision with root package name */
    public static final n7 f4323f = new n7(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f4324a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4325b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f4326c;

    /* renamed from: d, reason: collision with root package name */
    public int f4327d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4328e;

    public n7() {
        this(0, new int[8], new Object[8], true);
    }

    public static n7 a(n7 n7Var, n7 n7Var2) {
        int i2 = n7Var.f4324a + n7Var2.f4324a;
        int[] copyOf = Arrays.copyOf(n7Var.f4325b, i2);
        System.arraycopy(n7Var2.f4325b, 0, copyOf, n7Var.f4324a, n7Var2.f4324a);
        Object[] copyOf2 = Arrays.copyOf(n7Var.f4326c, i2);
        System.arraycopy(n7Var2.f4326c, 0, copyOf2, n7Var.f4324a, n7Var2.f4324a);
        return new n7(i2, copyOf, copyOf2, true);
    }

    public static n7 d() {
        return f4323f;
    }

    public static n7 e() {
        return new n7();
    }

    public final void b(h8 h8Var) throws IOException {
        if (this.f4324a == 0) {
            return;
        }
        if (h8Var.zza() == s4.e.k) {
            for (int i2 = 0; i2 < this.f4324a; i2++) {
                a(this.f4325b[i2], this.f4326c[i2], h8Var);
            }
            return;
        }
        for (int i3 = this.f4324a - 1; i3 >= 0; i3--) {
            a(this.f4325b[i3], this.f4326c[i3], h8Var);
        }
    }

    public final int c() {
        int e2;
        int i2 = this.f4327d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4324a; i4++) {
            int i5 = this.f4325b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                e2 = b4.e(i6, ((Long) this.f4326c[i4]).longValue());
            } else if (i7 == 1) {
                e2 = b4.g(i6, ((Long) this.f4326c[i4]).longValue());
            } else if (i7 == 2) {
                e2 = b4.c(i6, (k3) this.f4326c[i4]);
            } else if (i7 == 3) {
                e2 = (b4.e(i6) << 1) + ((n7) this.f4326c[i4]).c();
            } else {
                if (i7 != 5) {
                    throw new IllegalStateException(c5.zzf());
                }
                e2 = b4.i(i6, ((Integer) this.f4326c[i4]).intValue());
            }
            i3 += e2;
        }
        this.f4327d = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof n7)) {
            return false;
        }
        n7 n7Var = (n7) obj;
        int i2 = this.f4324a;
        if (i2 == n7Var.f4324a) {
            int[] iArr = this.f4325b;
            int[] iArr2 = n7Var.f4325b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                }
                if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                Object[] objArr = this.f4326c;
                Object[] objArr2 = n7Var.f4326c;
                int i4 = this.f4324a;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    }
                    i5++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f4324a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f4325b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f4326c;
        int i8 = this.f4324a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public n7(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f4327d = -1;
        this.f4324a = i2;
        this.f4325b = iArr;
        this.f4326c = objArr;
        this.f4328e = z;
    }

    public final void a() {
        this.f4328e = false;
    }

    public final int b() {
        int i2 = this.f4327d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4324a; i4++) {
            i3 += b4.d(this.f4325b[i4] >>> 3, (k3) this.f4326c[i4]);
        }
        this.f4327d = i3;
        return i3;
    }

    public final void a(h8 h8Var) throws IOException {
        if (h8Var.zza() == s4.e.l) {
            for (int i2 = this.f4324a - 1; i2 >= 0; i2--) {
                h8Var.a(this.f4325b[i2] >>> 3, this.f4326c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f4324a; i3++) {
            h8Var.a(this.f4325b[i3] >>> 3, this.f4326c[i3]);
        }
    }

    public static void a(int i2, Object obj, h8 h8Var) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            h8Var.e(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            h8Var.c(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            h8Var.a(i3, (k3) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                h8Var.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(c5.zzf());
        }
        if (h8Var.zza() == s4.e.k) {
            h8Var.zza(i3);
            ((n7) obj).b(h8Var);
            h8Var.zzb(i3);
        } else {
            h8Var.zzb(i3);
            ((n7) obj).b(h8Var);
            h8Var.zza(i3);
        }
    }

    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f4324a; i3++) {
            e6.a(sb, i2, String.valueOf(this.f4325b[i3] >>> 3), this.f4326c[i3]);
        }
    }

    public final void a(int i2, Object obj) {
        if (this.f4328e) {
            int i3 = this.f4324a;
            if (i3 == this.f4325b.length) {
                int i4 = this.f4324a + (i3 < 4 ? 8 : i3 >> 1);
                this.f4325b = Arrays.copyOf(this.f4325b, i4);
                this.f4326c = Arrays.copyOf(this.f4326c, i4);
            }
            int[] iArr = this.f4325b;
            int i5 = this.f4324a;
            iArr[i5] = i2;
            this.f4326c[i5] = obj;
            this.f4324a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
