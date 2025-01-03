package c.c.a.b.f.e;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class b4 extends l3 {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f4082b = Logger.getLogger(b4.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f4083c = q7.a();

    /* renamed from: a, reason: collision with root package name */
    public d4 f4084a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.b4.a.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class b extends b4 {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f4085d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4086e;

        /* renamed from: f, reason: collision with root package name */
        public int f4087f;

        public b(byte[] bArr, int i2, int i3) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i4 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i4)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
            }
            this.f4085d = bArr;
            this.f4087f = 0;
            this.f4086e = i4;
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void d(int i2) throws IOException {
            try {
                byte[] bArr = this.f4085d;
                int i3 = this.f4087f;
                int i4 = i3 + 1;
                this.f4087f = i4;
                bArr[i3] = (byte) i2;
                byte[] bArr2 = this.f4085d;
                int i5 = i4 + 1;
                this.f4087f = i5;
                bArr2[i4] = (byte) (i2 >> 8);
                byte[] bArr3 = this.f4085d;
                int i6 = i5 + 1;
                this.f4087f = i6;
                bArr3[i5] = (byte) (i2 >> 16);
                byte[] bArr4 = this.f4085d;
                this.f4087f = i6 + 1;
                bArr4[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), 1), e2);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, long j) throws IOException {
            a(i2, 0);
            a(j);
        }

        @Override // c.c.a.b.f.e.b4
        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            b(i3);
            c(bArr, 0, i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void c(int i2, long j) throws IOException {
            a(i2, 1);
            c(j);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // c.c.a.b.f.e.b4
        public final void b(int i2, k3 k3Var) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, k3Var);
            a(1, 4);
        }

        @Override // c.c.a.b.f.e.b4
        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f4085d;
                int i2 = this.f4087f;
                int i3 = i2 + 1;
                this.f4087f = i3;
                bArr[i2] = (byte) j;
                byte[] bArr2 = this.f4085d;
                int i4 = i3 + 1;
                this.f4087f = i4;
                bArr2[i3] = (byte) (j >> 8);
                byte[] bArr3 = this.f4085d;
                int i5 = i4 + 1;
                this.f4087f = i5;
                bArr3[i4] = (byte) (j >> 16);
                byte[] bArr4 = this.f4085d;
                int i6 = i5 + 1;
                this.f4087f = i6;
                bArr4[i5] = (byte) (j >> 24);
                byte[] bArr5 = this.f4085d;
                int i7 = i6 + 1;
                this.f4087f = i7;
                bArr5[i6] = (byte) (j >> 32);
                byte[] bArr6 = this.f4085d;
                int i8 = i7 + 1;
                this.f4087f = i8;
                bArr6[i7] = (byte) (j >> 40);
                byte[] bArr7 = this.f4085d;
                int i9 = i8 + 1;
                this.f4087f = i9;
                bArr7[i8] = (byte) (j >> 48);
                byte[] bArr8 = this.f4085d;
                this.f4087f = i9 + 1;
                bArr8[i9] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), 1), e2);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            a(str);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, k3 k3Var) throws IOException {
            a(i2, 2);
            a(k3Var);
        }

        @Override // c.c.a.b.f.e.b4
        public final void b(int i2) throws IOException {
            if (!b4.f4083c || h3.a() || a() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f4085d;
                        int i3 = this.f4087f;
                        this.f4087f = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | RecyclerView.c0.FLAG_IGNORE);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), 1), e2);
                    }
                }
                byte[] bArr2 = this.f4085d;
                int i4 = this.f4087f;
                this.f4087f = i4 + 1;
                bArr2[i4] = (byte) i2;
                return;
            }
            if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.f4085d;
                int i5 = this.f4087f;
                this.f4087f = i5 + 1;
                q7.a(bArr3, i5, (byte) i2);
                return;
            }
            byte[] bArr4 = this.f4085d;
            int i6 = this.f4087f;
            this.f4087f = i6 + 1;
            q7.a(bArr4, i6, (byte) (i2 | RecyclerView.c0.FLAG_IGNORE));
            int i7 = i2 >>> 7;
            if ((i7 & (-128)) == 0) {
                byte[] bArr5 = this.f4085d;
                int i8 = this.f4087f;
                this.f4087f = i8 + 1;
                q7.a(bArr5, i8, (byte) i7);
                return;
            }
            byte[] bArr6 = this.f4085d;
            int i9 = this.f4087f;
            this.f4087f = i9 + 1;
            q7.a(bArr6, i9, (byte) (i7 | RecyclerView.c0.FLAG_IGNORE));
            int i10 = i7 >>> 7;
            if ((i10 & (-128)) == 0) {
                byte[] bArr7 = this.f4085d;
                int i11 = this.f4087f;
                this.f4087f = i11 + 1;
                q7.a(bArr7, i11, (byte) i10);
                return;
            }
            byte[] bArr8 = this.f4085d;
            int i12 = this.f4087f;
            this.f4087f = i12 + 1;
            q7.a(bArr8, i12, (byte) (i10 | RecyclerView.c0.FLAG_IGNORE));
            int i13 = i10 >>> 7;
            if ((i13 & (-128)) == 0) {
                byte[] bArr9 = this.f4085d;
                int i14 = this.f4087f;
                this.f4087f = i14 + 1;
                q7.a(bArr9, i14, (byte) i13);
                return;
            }
            byte[] bArr10 = this.f4085d;
            int i15 = this.f4087f;
            this.f4087f = i15 + 1;
            q7.a(bArr10, i15, (byte) (i13 | RecyclerView.c0.FLAG_IGNORE));
            byte[] bArr11 = this.f4085d;
            int i16 = this.f4087f;
            this.f4087f = i16 + 1;
            q7.a(bArr11, i16, (byte) (i13 >>> 7));
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(k3 k3Var) throws IOException {
            b(k3Var.zza());
            k3Var.zza(this);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, d6 d6Var, t6 t6Var) throws IOException {
            a(i2, 2);
            b3 b3Var = (b3) d6Var;
            int h2 = b3Var.h();
            if (h2 == -1) {
                h2 = t6Var.d(b3Var);
                b3Var.a(h2);
            }
            b(h2);
            t6Var.a((t6) d6Var, (h8) this.f4084a);
        }

        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f4085d, this.f4087f, i3);
                this.f4087f += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), Integer.valueOf(i3)), e2);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2, d6 d6Var) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, 2);
            a(d6Var);
            a(1, 4);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(d6 d6Var) throws IOException {
            b(d6Var.e());
            d6Var.a(this);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f4085d;
                int i2 = this.f4087f;
                this.f4087f = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), 1), e2);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a(i2);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(long j) throws IOException {
            if (b4.f4083c && a() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f4085d;
                    int i2 = this.f4087f;
                    this.f4087f = i2 + 1;
                    q7.a(bArr, i2, (byte) ((((int) j) & 127) | RecyclerView.c0.FLAG_IGNORE));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f4085d;
                int i3 = this.f4087f;
                this.f4087f = i3 + 1;
                q7.a(bArr2, i3, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f4085d;
                    int i4 = this.f4087f;
                    this.f4087f = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j) & 127) | RecyclerView.c0.FLAG_IGNORE);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f4087f), Integer.valueOf(this.f4086e), 1), e2);
                }
            }
            byte[] bArr4 = this.f4085d;
            int i5 = this.f4087f;
            this.f4087f = i5 + 1;
            bArr4[i5] = (byte) j;
        }

        @Override // c.c.a.b.f.e.l3
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // c.c.a.b.f.e.b4
        public final void a(String str) throws IOException {
            int i2 = this.f4087f;
            try {
                int g2 = b4.g(str.length() * 3);
                int g3 = b4.g(str.length());
                if (g3 == g2) {
                    int i3 = i2 + g3;
                    this.f4087f = i3;
                    int a2 = t7.a(str, this.f4085d, i3, a());
                    this.f4087f = i2;
                    b((a2 - i2) - g3);
                    this.f4087f = a2;
                    return;
                }
                b(t7.a(str));
                this.f4087f = t7.a(str, this.f4085d, this.f4087f, a());
            } catch (w7 e2) {
                this.f4087f = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new a(e3);
            }
        }

        @Override // c.c.a.b.f.e.b4
        public final int a() {
            return this.f4086e - this.f4087f;
        }
    }

    public b4() {
    }

    public static b4 a(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    public static int b(double d2) {
        return 8;
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int e(int i2, long j) {
        return e(i2) + e(j);
    }

    public static int e(long j) {
        int i2;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i2 = 6;
            j >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j) != 0) {
            i2 += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int f(int i2, int i3) {
        return e(i2) + f(i3);
    }

    public static int g(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int g(int i2, int i3) {
        return e(i2) + g(i3);
    }

    public static int g(long j) {
        return 8;
    }

    public static int h(int i2, int i3) {
        return e(i2) + g(m(i3));
    }

    public static int h(long j) {
        return 8;
    }

    public static int i(int i2) {
        return 4;
    }

    public static int i(int i2, int i3) {
        return e(i2) + 4;
    }

    public static long i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int j(int i2) {
        return 4;
    }

    public static int j(int i2, int i3) {
        return e(i2) + 4;
    }

    public static int k(int i2, int i3) {
        return e(i2) + f(i3);
    }

    @Deprecated
    public static int l(int i2) {
        return g(i2);
    }

    public static int m(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract int a();

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j) throws IOException;

    public abstract void a(int i2, d6 d6Var) throws IOException;

    public abstract void a(int i2, d6 d6Var, t6 t6Var) throws IOException;

    public abstract void a(int i2, k3 k3Var) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(d6 d6Var) throws IOException;

    public abstract void a(k3 k3Var) throws IOException;

    public abstract void a(String str) throws IOException;

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public final void b(int i2, long j) throws IOException {
        a(i2, i(j));
    }

    public abstract void b(int i2, k3 k3Var) throws IOException;

    public abstract void b(byte[] bArr, int i2, int i3) throws IOException;

    public final void c(int i2) throws IOException {
        b(m(i2));
    }

    public abstract void c(int i2, int i3) throws IOException;

    public abstract void c(int i2, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i2) throws IOException;

    public final void d(int i2, int i3) throws IOException {
        c(i2, m(i3));
    }

    public abstract void e(int i2, int i3) throws IOException;

    public static int c(int i2, k3 k3Var) {
        int e2 = e(i2);
        int zza = k3Var.zza();
        return e2 + g(zza) + zza;
    }

    public static int d(int i2, long j) {
        return e(i2) + e(j);
    }

    public static int e(int i2) {
        return g(i2 << 3);
    }

    public static int f(int i2, long j) {
        return e(i2) + e(i(j));
    }

    public static int g(int i2, long j) {
        return e(i2) + 8;
    }

    public final void b(long j) throws IOException {
        a(i(j));
    }

    public static int b(int i2, float f2) {
        return e(i2) + 4;
    }

    public static int h(int i2, long j) {
        return e(i2) + 8;
    }

    public static int k(int i2) {
        return f(i2);
    }

    public final void a(int i2, float f2) throws IOException {
        e(i2, Float.floatToRawIntBits(f2));
    }

    public static int b(int i2, double d2) {
        return e(i2) + 8;
    }

    public static int d(int i2, k3 k3Var) {
        return (e(1) << 1) + g(2, i2) + c(3, k3Var);
    }

    public static int f(int i2) {
        if (i2 >= 0) {
            return g(i2);
        }
        return 10;
    }

    public static int h(int i2) {
        return g(m(i2));
    }

    public final void a(int i2, double d2) throws IOException {
        c(i2, Double.doubleToRawLongBits(d2));
    }

    public static int b(int i2, boolean z) {
        return e(i2) + 1;
    }

    @Deprecated
    public static int c(int i2, d6 d6Var, t6 t6Var) {
        int e2 = e(i2) << 1;
        b3 b3Var = (b3) d6Var;
        int h2 = b3Var.h();
        if (h2 == -1) {
            h2 = t6Var.d(b3Var);
            b3Var.a(h2);
        }
        return e2 + h2;
    }

    public static int f(long j) {
        return e(i(j));
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    public static int b(int i2, String str) {
        return e(i2) + b(str);
    }

    public final void a(double d2) throws IOException {
        c(Double.doubleToRawLongBits(d2));
    }

    public static int b(int i2, d6 d6Var, t6 t6Var) {
        return e(i2) + a(d6Var, t6Var);
    }

    public static int d(long j) {
        return e(j);
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : (byte) 0);
    }

    public static int a(int i2, h5 h5Var) {
        int e2 = e(i2);
        int a2 = h5Var.a();
        return e2 + g(a2) + a2;
    }

    public static int b(int i2, d6 d6Var) {
        return (e(1) << 1) + g(2, i2) + e(3) + b(d6Var);
    }

    @Deprecated
    public static int c(d6 d6Var) {
        return d6Var.e();
    }

    public static int a(h5 h5Var) {
        int a2 = h5Var.a();
        return g(a2) + a2;
    }

    public static int b(int i2, h5 h5Var) {
        return (e(1) << 1) + g(2, i2) + a(3, h5Var);
    }

    public static int a(d6 d6Var, t6 t6Var) {
        b3 b3Var = (b3) d6Var;
        int h2 = b3Var.h();
        if (h2 == -1) {
            h2 = t6Var.d(b3Var);
            b3Var.a(h2);
        }
        return g(h2) + h2;
    }

    public static int b(String str) {
        int length;
        try {
            length = t7.a(str);
        } catch (w7 unused) {
            length = str.getBytes(u4.f4458a).length;
        }
        return g(length) + length;
    }

    public static int b(k3 k3Var) {
        int zza = k3Var.zza();
        return g(zza) + zza;
    }

    public final void a(String str, w7 w7Var) throws IOException {
        f4082b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) w7Var);
        byte[] bytes = str.getBytes(u4.f4458a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (a e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new a(e3);
        }
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return g(length) + length;
    }

    public static int b(d6 d6Var) {
        int e2 = d6Var.e();
        return g(e2) + e2;
    }

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
