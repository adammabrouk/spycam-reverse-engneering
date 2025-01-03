package c.c.a.b.f.e;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class h6<T> implements t6<T> {
    public static final int[] q = new int[0];
    public static final Unsafe r = q7.c();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4205a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f4206b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4207c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4208d;

    /* renamed from: e, reason: collision with root package name */
    public final d6 f4209e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4210f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4211g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4212h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f4213i;
    public final int j;
    public final int k;
    public final m6 l;
    public final n5 m;
    public final k7<?, ?> n;
    public final g4<?> o;
    public final w5 p;

    public h6(int[] iArr, Object[] objArr, int i2, int i3, d6 d6Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, m6 m6Var, n5 n5Var, k7<?, ?> k7Var, g4<?> g4Var, w5 w5Var) {
        this.f4205a = iArr;
        this.f4206b = objArr;
        this.f4207c = i2;
        this.f4208d = i3;
        boolean z3 = d6Var instanceof s4;
        this.f4211g = z;
        this.f4210f = g4Var != null && g4Var.a(d6Var);
        this.f4212h = false;
        this.f4213i = iArr2;
        this.j = i4;
        this.k = i5;
        this.l = m6Var;
        this.m = n5Var;
        this.n = k7Var;
        this.o = g4Var;
        this.f4209e = d6Var;
        this.p = w5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> c.c.a.b.f.e.h6<T> a(java.lang.Class<T> r33, c.c.a.b.f.e.b6 r34, c.c.a.b.f.e.m6 r35, c.c.a.b.f.e.n5 r36, c.c.a.b.f.e.k7<?, ?> r37, c.c.a.b.f.e.g4<?> r38, c.c.a.b.f.e.w5 r39) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.a(java.lang.Class, c.c.a.b.f.e.b6, c.c.a.b.f.e.m6, c.c.a.b.f.e.n5, c.c.a.b.f.e.k7, c.c.a.b.f.e.g4, c.c.a.b.f.e.w5):c.c.a.b.f.e.h6");
    }

    public static n7 e(Object obj) {
        s4 s4Var = (s4) obj;
        n7 n7Var = s4Var.zzb;
        if (n7Var != n7.d()) {
            return n7Var;
        }
        n7 e2 = n7.e();
        s4Var.zzb = e2;
        return e2;
    }

    public static <T> boolean f(T t, long j) {
        return ((Boolean) q7.f(t, j)).booleanValue();
    }

    @Override // c.c.a.b.f.e.t6
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw null;
        }
        for (int i2 = 0; i2 < this.f4205a.length; i2 += 3) {
            int d2 = d(i2);
            long j = 1048575 & d2;
            int i3 = this.f4205a[i2];
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    if (a((h6<T>) t2, i2)) {
                        q7.a(t, j, q7.e(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.d(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.b(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.b(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.b(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((h6<T>) t2, i2)) {
                        q7.a(t, j, q7.c(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((h6<T>) t2, i2)) {
                        q7.a(t, j, q7.f(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i2);
                    break;
                case 10:
                    if (a((h6<T>) t2, i2)) {
                        q7.a(t, j, q7.f(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.b(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.a(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((h6<T>) t2, i2)) {
                        q7.a((Object) t, j, q7.b(t2, j));
                        b((h6<T>) t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    a(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.m.a(t, t2, j);
                    break;
                case 50:
                    u6.a(this.p, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (a((h6<T>) t2, i3, i2)) {
                        q7.a(t, j, q7.f(t2, j));
                        b((h6<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    b(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (a((h6<T>) t2, i3, i2)) {
                        q7.a(t, j, q7.f(t2, j));
                        b((h6<T>) t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i2);
                    break;
            }
        }
        u6.a(this.n, t, t2);
        if (this.f4210f) {
            u6.a(this.o, t, t2);
        }
    }

    public final y4 c(int i2) {
        return (y4) this.f4206b[((i2 / 3) << 1) + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.c.a.b.f.e.t6
    public final int d(T t) {
        int i2;
        int i3;
        long j;
        int d2;
        int b2;
        int j2;
        int i4;
        int e2;
        int g2;
        int b3;
        int i5;
        int e3;
        int g3;
        int i6 = 267386880;
        if (this.f4211g) {
            Unsafe unsafe = r;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.f4205a.length) {
                int d3 = d(i7);
                int i9 = (d3 & i6) >>> 20;
                int i10 = this.f4205a[i7];
                long j3 = d3 & 1048575;
                int i11 = (i9 < m4.DOUBLE_LIST_PACKED.zza() || i9 > m4.SINT64_LIST_PACKED.zza()) ? 0 : this.f4205a[i7 + 2] & 1048575;
                switch (i9) {
                    case 0:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.b(i10, 0.0d);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.b(i10, 0.0f);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.d(i10, q7.b(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.e(i10, q7.b(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.f(i10, q7.a(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.g(i10, 0L);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.i(i10, 0);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.b(i10, true);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((h6<T>) t, i7)) {
                            Object f2 = q7.f(t, j3);
                            b3 = f2 instanceof k3 ? b4.c(i10, (k3) f2) : b4.b(i10, (String) f2);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (a((h6<T>) t, i7)) {
                            b3 = u6.a(i10, q7.f(t, j3), a(i7));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.c(i10, (k3) q7.f(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.g(i10, q7.a(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.k(i10, q7.a(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.j(i10, 0);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.h(i10, 0L);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.h(i10, q7.a(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.f(i10, q7.b(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((h6<T>) t, i7)) {
                            b3 = b4.c(i10, (d6) q7.f(t, j3), a(i7));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        b3 = u6.i(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 19:
                        b3 = u6.h(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 20:
                        b3 = u6.a(i10, (List<Long>) a(t, j3), false);
                        i8 += b3;
                        break;
                    case 21:
                        b3 = u6.b(i10, (List<Long>) a(t, j3), false);
                        i8 += b3;
                        break;
                    case 22:
                        b3 = u6.e(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 23:
                        b3 = u6.i(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 24:
                        b3 = u6.h(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 25:
                        b3 = u6.j(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 26:
                        b3 = u6.a(i10, a(t, j3));
                        i8 += b3;
                        break;
                    case 27:
                        b3 = u6.a(i10, a(t, j3), a(i7));
                        i8 += b3;
                        break;
                    case 28:
                        b3 = u6.b(i10, a(t, j3));
                        i8 += b3;
                        break;
                    case 29:
                        b3 = u6.f(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 30:
                        b3 = u6.d(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 31:
                        b3 = u6.h(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 32:
                        b3 = u6.i(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 33:
                        b3 = u6.g(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 34:
                        b3 = u6.c(i10, a(t, j3), false);
                        i8 += b3;
                        break;
                    case 35:
                        i5 = u6.i((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 36:
                        i5 = u6.h((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 37:
                        i5 = u6.a((List<Long>) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 38:
                        i5 = u6.b((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 39:
                        i5 = u6.e((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 40:
                        i5 = u6.i((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 41:
                        i5 = u6.h((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 42:
                        i5 = u6.j((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 43:
                        i5 = u6.f((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 44:
                        i5 = u6.d((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 45:
                        i5 = u6.h((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 46:
                        i5 = u6.i((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 47:
                        i5 = u6.g((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 48:
                        i5 = u6.c((List) unsafe.getObject(t, j3));
                        if (i5 <= 0) {
                            break;
                        } else {
                            if (this.f4212h) {
                                unsafe.putInt(t, i11, i5);
                            }
                            e3 = b4.e(i10);
                            g3 = b4.g(i5);
                            b3 = e3 + g3 + i5;
                            i8 += b3;
                            break;
                        }
                    case 49:
                        b3 = u6.b(i10, (List<d6>) a(t, j3), a(i7));
                        i8 += b3;
                        break;
                    case 50:
                        b3 = this.p.a(i10, q7.f(t, j3), b(i7));
                        i8 += b3;
                        break;
                    case 51:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.b(i10, 0.0d);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.b(i10, 0.0f);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.d(i10, e(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.e(i10, e(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.f(i10, d(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.g(i10, 0L);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.i(i10, 0);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.b(i10, true);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((h6<T>) t, i10, i7)) {
                            Object f3 = q7.f(t, j3);
                            b3 = f3 instanceof k3 ? b4.c(i10, (k3) f3) : b4.b(i10, (String) f3);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = u6.a(i10, q7.f(t, j3), a(i7));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.c(i10, (k3) q7.f(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.g(i10, d(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.k(i10, d(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.j(i10, 0);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.h(i10, 0L);
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.h(i10, d(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.f(i10, e(t, j3));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((h6<T>) t, i10, i7)) {
                            b3 = b4.c(i10, (d6) q7.f(t, j3), a(i7));
                            i8 += b3;
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
                i6 = 267386880;
            }
            return i8 + a((k7) this.n, (Object) t);
        }
        Unsafe unsafe2 = r;
        int i12 = 0;
        int i13 = 1048575;
        int i14 = 0;
        for (int i15 = 0; i15 < this.f4205a.length; i15 += 3) {
            int d4 = d(i15);
            int[] iArr = this.f4205a;
            int i16 = iArr[i15];
            int i17 = (d4 & 267386880) >>> 20;
            if (i17 <= 17) {
                int i18 = iArr[i15 + 2];
                int i19 = i18 & 1048575;
                i3 = 1 << (i18 >>> 20);
                if (i19 != i13) {
                    i14 = unsafe2.getInt(t, i19);
                    i13 = i19;
                }
                i2 = i18;
            } else {
                i2 = (!this.f4212h || i17 < m4.DOUBLE_LIST_PACKED.zza() || i17 > m4.SINT64_LIST_PACKED.zza()) ? 0 : this.f4205a[i15 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = d4 & 1048575;
            switch (i17) {
                case 0:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        i12 += b4.b(i16, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        i12 += b4.b(i16, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        d2 = b4.d(i16, unsafe2.getLong(t, j4));
                        i12 += d2;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        d2 = b4.e(i16, unsafe2.getLong(t, j4));
                        i12 += d2;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        d2 = b4.f(i16, unsafe2.getInt(t, j4));
                        i12 += d2;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i14 & i3) != 0) {
                        d2 = b4.g(i16, 0L);
                        i12 += d2;
                    }
                    break;
                case 6:
                    if ((i14 & i3) != 0) {
                        i12 += b4.i(i16, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i14 & i3) != 0) {
                        b2 = b4.b(i16, true);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i14 & i3) != 0) {
                        Object object2 = unsafe2.getObject(t, j4);
                        b2 = object2 instanceof k3 ? b4.c(i16, (k3) object2) : b4.b(i16, (String) object2);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i14 & i3) != 0) {
                        b2 = u6.a(i16, unsafe2.getObject(t, j4), a(i15));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i14 & i3) != 0) {
                        b2 = b4.c(i16, (k3) unsafe2.getObject(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i14 & i3) != 0) {
                        b2 = b4.g(i16, unsafe2.getInt(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i14 & i3) != 0) {
                        b2 = b4.k(i16, unsafe2.getInt(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i14 & i3) != 0) {
                        j2 = b4.j(i16, 0);
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i14 & i3) != 0) {
                        b2 = b4.h(i16, 0L);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i14 & i3) != 0) {
                        b2 = b4.h(i16, unsafe2.getInt(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i14 & i3) != 0) {
                        b2 = b4.f(i16, unsafe2.getLong(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i14 & i3) != 0) {
                        b2 = b4.c(i16, (d6) unsafe2.getObject(t, j4), a(i15));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 18:
                    b2 = u6.i(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 19:
                    b2 = u6.h(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 20:
                    b2 = u6.a(i16, (List<Long>) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 21:
                    b2 = u6.b(i16, (List<Long>) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 22:
                    b2 = u6.e(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 23:
                    b2 = u6.i(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 24:
                    b2 = u6.h(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 25:
                    b2 = u6.j(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 26:
                    b2 = u6.a(i16, (List<?>) unsafe2.getObject(t, j4));
                    i12 += b2;
                    j = 0;
                    break;
                case 27:
                    b2 = u6.a(i16, (List<?>) unsafe2.getObject(t, j4), a(i15));
                    i12 += b2;
                    j = 0;
                    break;
                case 28:
                    b2 = u6.b(i16, (List) unsafe2.getObject(t, j4));
                    i12 += b2;
                    j = 0;
                    break;
                case 29:
                    b2 = u6.f(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 30:
                    b2 = u6.d(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 31:
                    b2 = u6.h(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 32:
                    b2 = u6.i(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 33:
                    b2 = u6.g(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 34:
                    b2 = u6.c(i16, (List) unsafe2.getObject(t, j4), false);
                    i12 += b2;
                    j = 0;
                    break;
                case 35:
                    i4 = u6.i((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 36:
                    i4 = u6.h((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 37:
                    i4 = u6.a((List<Long>) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 38:
                    i4 = u6.b((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 39:
                    i4 = u6.e((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 40:
                    i4 = u6.i((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 41:
                    i4 = u6.h((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 42:
                    i4 = u6.j((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 43:
                    i4 = u6.f((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 44:
                    i4 = u6.d((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 45:
                    i4 = u6.h((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 46:
                    i4 = u6.i((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 47:
                    i4 = u6.g((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 48:
                    i4 = u6.c((List) unsafe2.getObject(t, j4));
                    if (i4 > 0) {
                        if (this.f4212h) {
                            unsafe2.putInt(t, i2, i4);
                        }
                        e2 = b4.e(i16);
                        g2 = b4.g(i4);
                        j2 = e2 + g2 + i4;
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 49:
                    b2 = u6.b(i16, (List<d6>) unsafe2.getObject(t, j4), a(i15));
                    i12 += b2;
                    j = 0;
                    break;
                case 50:
                    b2 = this.p.a(i16, unsafe2.getObject(t, j4), b(i15));
                    i12 += b2;
                    j = 0;
                    break;
                case 51:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.b(i16, 0.0d);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 52:
                    if (a((h6<T>) t, i16, i15)) {
                        j2 = b4.b(i16, 0.0f);
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 53:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.d(i16, e(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 54:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.e(i16, e(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 55:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.f(i16, d(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 56:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.g(i16, 0L);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 57:
                    if (a((h6<T>) t, i16, i15)) {
                        j2 = b4.i(i16, 0);
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 58:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.b(i16, true);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 59:
                    if (a((h6<T>) t, i16, i15)) {
                        Object object3 = unsafe2.getObject(t, j4);
                        b2 = object3 instanceof k3 ? b4.c(i16, (k3) object3) : b4.b(i16, (String) object3);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 60:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = u6.a(i16, unsafe2.getObject(t, j4), a(i15));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 61:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.c(i16, (k3) unsafe2.getObject(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 62:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.g(i16, d(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 63:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.k(i16, d(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 64:
                    if (a((h6<T>) t, i16, i15)) {
                        j2 = b4.j(i16, 0);
                        i12 += j2;
                    }
                    j = 0;
                    break;
                case 65:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.h(i16, 0L);
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 66:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.h(i16, d(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 67:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.f(i16, e(t, j4));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                case 68:
                    if (a((h6<T>) t, i16, i15)) {
                        b2 = b4.c(i16, (d6) unsafe2.getObject(t, j4), a(i15));
                        i12 += b2;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int i20 = 0;
        int a2 = i12 + a((k7) this.n, (Object) t);
        if (!this.f4210f) {
            return a2;
        }
        l4<?> a3 = this.o.a(t);
        for (int i21 = 0; i21 < a3.f4277a.c(); i21++) {
            Map.Entry<?, Object> a4 = a3.f4277a.a(i21);
            i20 += l4.b((n4<?>) a4.getKey(), a4.getValue());
        }
        for (Map.Entry<?, Object> entry : a3.f4277a.d()) {
            i20 += l4.b((n4<?>) entry.getKey(), entry.getValue());
        }
        return a2 + i20;
    }

    @Override // c.c.a.b.f.e.t6
    public final T zza() {
        return (T) this.l.a(this.f4209e);
    }

    @Override // c.c.a.b.f.e.t6
    public final void c(T t) {
        int i2;
        int i3 = this.j;
        while (true) {
            i2 = this.k;
            if (i3 >= i2) {
                break;
            }
            long d2 = d(this.f4213i[i3]) & 1048575;
            Object f2 = q7.f(t, d2);
            if (f2 != null) {
                q7.a(t, d2, this.p.b(f2));
            }
            i3++;
        }
        int length = this.f4213i.length;
        while (i2 < length) {
            this.m.a(t, this.f4213i[i2]);
            i2++;
        }
        this.n.b(t);
        if (this.f4210f) {
            this.o.c(t);
        }
    }

    public final int f(int i2) {
        if (i2 < this.f4207c || i2 > this.f4208d) {
            return -1;
        }
        return b(i2, 0);
    }

    public final int e(int i2) {
        return this.f4205a[i2 + 2];
    }

    public static <T> long e(T t, long j) {
        return ((Long) q7.f(t, j)).longValue();
    }

    public static <T> float c(T t, long j) {
        return ((Float) q7.f(t, j)).floatValue();
    }

    public final boolean c(T t, T t2, int i2) {
        return a((h6<T>) t, i2) == a((h6<T>) t2, i2);
    }

    public final void b(T t, T t2, int i2) {
        int d2 = d(i2);
        int i3 = this.f4205a[i2];
        long j = d2 & 1048575;
        if (a((h6<T>) t2, i3, i2)) {
            Object f2 = q7.f(t, j);
            Object f3 = q7.f(t2, j);
            if (f2 != null && f3 != null) {
                q7.a(t, j, u4.a(f2, f3));
                b((h6<T>) t, i3, i2);
            } else if (f3 != null) {
                q7.a(t, j, f3);
                b((h6<T>) t, i3, i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(T r17, c.c.a.b.f.e.h8 r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.b(java.lang.Object, c.c.a.b.f.e.h8):void");
    }

    public static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (c.c.a.b.f.e.u6.a(c.c.a.b.f.e.q7.f(r10, r6), c.c.a.b.f.e.q7.f(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (c.c.a.b.f.e.q7.b(r10, r6) == c.c.a.b.f.e.q7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (c.c.a.b.f.e.q7.b(r10, r6) == c.c.a.b.f.e.q7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (c.c.a.b.f.e.u6.a(c.c.a.b.f.e.q7.f(r10, r6), c.c.a.b.f.e.q7.f(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (c.c.a.b.f.e.u6.a(c.c.a.b.f.e.q7.f(r10, r6), c.c.a.b.f.e.q7.f(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (c.c.a.b.f.e.u6.a(c.c.a.b.f.e.q7.f(r10, r6), c.c.a.b.f.e.q7.f(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (c.c.a.b.f.e.q7.c(r10, r6) == c.c.a.b.f.e.q7.c(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (c.c.a.b.f.e.q7.b(r10, r6) == c.c.a.b.f.e.q7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (c.c.a.b.f.e.q7.a(r10, r6) == c.c.a.b.f.e.q7.a(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (c.c.a.b.f.e.q7.b(r10, r6) == c.c.a.b.f.e.q7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (c.c.a.b.f.e.q7.b(r10, r6) == c.c.a.b.f.e.q7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(c.c.a.b.f.e.q7.d(r10, r6)) == java.lang.Float.floatToIntBits(c.c.a.b.f.e.q7.d(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(c.c.a.b.f.e.q7.e(r10, r6)) == java.lang.Double.doubleToLongBits(c.c.a.b.f.e.q7.e(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (c.c.a.b.f.e.u6.a(c.c.a.b.f.e.q7.f(r10, r6), c.c.a.b.f.e.q7.f(r11, r6)) != false) goto L105;
     */
    @Override // c.c.a.b.f.e.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // c.c.a.b.f.e.t6
    public final int a(T t) {
        int i2;
        int a2;
        int length = this.f4205a.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int d2 = d(i4);
            int i5 = this.f4205a[i4];
            long j = 1048575 & d2;
            int i6 = 37;
            switch ((d2 & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    a2 = u4.a(Double.doubleToLongBits(q7.e(t, j)));
                    i3 = i2 + a2;
                    break;
                case 1:
                    i2 = i3 * 53;
                    a2 = Float.floatToIntBits(q7.d(t, j));
                    i3 = i2 + a2;
                    break;
                case 2:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.b(t, j));
                    i3 = i2 + a2;
                    break;
                case 3:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.b(t, j));
                    i3 = i2 + a2;
                    break;
                case 4:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 5:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.b(t, j));
                    i3 = i2 + a2;
                    break;
                case 6:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 7:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.c(t, j));
                    i3 = i2 + a2;
                    break;
                case 8:
                    i2 = i3 * 53;
                    a2 = ((String) q7.f(t, j)).hashCode();
                    i3 = i2 + a2;
                    break;
                case 9:
                    Object f2 = q7.f(t, j);
                    if (f2 != null) {
                        i6 = f2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    a2 = q7.f(t, j).hashCode();
                    i3 = i2 + a2;
                    break;
                case 11:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 14:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.b(t, j));
                    i3 = i2 + a2;
                    break;
                case 15:
                    i2 = i3 * 53;
                    a2 = q7.a(t, j);
                    i3 = i2 + a2;
                    break;
                case 16:
                    i2 = i3 * 53;
                    a2 = u4.a(q7.b(t, j));
                    i3 = i2 + a2;
                    break;
                case 17:
                    Object f3 = q7.f(t, j);
                    if (f3 != null) {
                        i6 = f3.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    a2 = q7.f(t, j).hashCode();
                    i3 = i2 + a2;
                    break;
                case 50:
                    i2 = i3 * 53;
                    a2 = q7.f(t, j).hashCode();
                    i3 = i2 + a2;
                    break;
                case 51:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(Double.doubleToLongBits(b(t, j)));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = Float.floatToIntBits(c(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(e(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(e(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(e(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(f(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = ((String) q7.f(t, j)).hashCode();
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = q7.f(t, j).hashCode();
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = q7.f(t, j).hashCode();
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(e(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = d(t, j);
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = u4.a(e(t, j));
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((h6<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        a2 = q7.f(t, j).hashCode();
                        i3 = i2 + a2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.n.a(t).hashCode();
        return this.f4210f ? (hashCode * 53) + this.o.a(t).hashCode() : hashCode;
    }

    public final void a(T t, T t2, int i2) {
        long d2 = d(i2) & 1048575;
        if (a((h6<T>) t2, i2)) {
            Object f2 = q7.f(t, d2);
            Object f3 = q7.f(t2, d2);
            if (f2 != null && f3 != null) {
                q7.a(t, d2, u4.a(f2, f3));
                b((h6<T>) t, i2);
            } else if (f3 != null) {
                q7.a(t, d2, f3);
                b((h6<T>) t, i2);
            }
        }
    }

    public static <UT, UB> int a(k7<UT, UB> k7Var, T t) {
        return k7Var.d(k7Var.a(t));
    }

    public static List<?> a(Object obj, long j) {
        return (List) q7.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x096d  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0973  */
    @Override // c.c.a.b.f.e.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r13, c.c.a.b.f.e.h8 r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.a(java.lang.Object, c.c.a.b.f.e.h8):void");
    }

    public final Object b(int i2) {
        return this.f4206b[(i2 / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [c.c.a.b.f.e.t6] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [c.c.a.b.f.e.t6] */
    @Override // c.c.a.b.f.e.t6
    public final boolean b(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.j) {
                return !this.f4210f || this.o.a(t).e();
            }
            int i7 = this.f4213i[i6];
            int i8 = this.f4205a[i7];
            int d2 = d(i7);
            int i9 = this.f4205a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = r.getInt(t, i10);
                }
                i3 = i5;
                i2 = i10;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (((268435456 & d2) != 0) && !a((h6<T>) t, i7, i2, i3, i11)) {
                return false;
            }
            int i12 = (267386880 & d2) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (a((h6<T>) t, i8, i7) && !a(t, d2, a(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 != 50) {
                            continue;
                        } else {
                            Map<?, ?> d3 = this.p.d(q7.f(t, d2 & 1048575));
                            if (!d3.isEmpty()) {
                                if (this.p.e(b(i7)).f4462c.zza() == e8.MESSAGE) {
                                    ?? r1 = 0;
                                    Iterator<?> it = d3.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        r1 = r1;
                                        if (r1 == 0) {
                                            r1 = p6.a().a((Class) next.getClass());
                                        }
                                        if (!r1.b(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) q7.f(t, d2 & 1048575);
                if (!list.isEmpty()) {
                    ?? a2 = a(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        }
                        if (!a2.b(list.get(i13))) {
                            z = false;
                            break;
                        }
                        i13++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a((h6<T>) t, i7, i2, i3, i11) && !a(t, d2, a(i7))) {
                return false;
            }
            i6++;
            i4 = i2;
            i5 = i3;
        }
    }

    public static <T> double b(T t, long j) {
        return ((Double) q7.f(t, j)).doubleValue();
    }

    public final void b(T t, int i2) {
        int e2 = e(i2);
        long j = 1048575 & e2;
        if (j == 1048575) {
            return;
        }
        q7.a((Object) t, j, (1 << (e2 >>> 20)) | q7.a(t, j));
    }

    public final void b(T t, int i2, int i3) {
        q7.a((Object) t, e(i3) & 1048575, i2);
    }

    public final int b(int i2, int i3) {
        int length = (this.f4205a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f4205a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public final int d(int i2) {
        return this.f4205a[i2 + 1];
    }

    public static <T> int d(T t, long j) {
        return ((Integer) q7.f(t, j)).intValue();
    }

    public final <K, V> void a(h8 h8Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            h8Var.a(i2, this.p.e(b(i3)), this.p.d(obj));
        }
    }

    public static <UT, UB> void a(k7<UT, UB> k7Var, T t, h8 h8Var) throws IOException {
        k7Var.a((k7<UT, UB>) k7Var.a(t), h8Var);
    }

    public static int a(byte[] bArr, int i2, int i3, b8 b8Var, Class<?> cls, j3 j3Var) throws IOException {
        switch (g6.f4187a[b8Var.ordinal()]) {
            case 1:
                int b2 = g3.b(bArr, i2, j3Var);
                j3Var.f4240c = Boolean.valueOf(j3Var.f4239b != 0);
                return b2;
            case 2:
                return g3.e(bArr, i2, j3Var);
            case 3:
                j3Var.f4240c = Double.valueOf(g3.c(bArr, i2));
                return i2 + 8;
            case 4:
            case 5:
                j3Var.f4240c = Integer.valueOf(g3.a(bArr, i2));
                return i2 + 4;
            case 6:
            case 7:
                j3Var.f4240c = Long.valueOf(g3.b(bArr, i2));
                return i2 + 8;
            case 8:
                j3Var.f4240c = Float.valueOf(g3.d(bArr, i2));
                return i2 + 4;
            case 9:
            case 10:
            case 11:
                int a2 = g3.a(bArr, i2, j3Var);
                j3Var.f4240c = Integer.valueOf(j3Var.f4238a);
                return a2;
            case 12:
            case 13:
                int b3 = g3.b(bArr, i2, j3Var);
                j3Var.f4240c = Long.valueOf(j3Var.f4239b);
                return b3;
            case 14:
                return g3.a(p6.a().a((Class) cls), bArr, i2, i3, j3Var);
            case 15:
                int a3 = g3.a(bArr, i2, j3Var);
                j3Var.f4240c = Integer.valueOf(w3.a(j3Var.f4238a));
                return a3;
            case 16:
                int b4 = g3.b(bArr, i2, j3Var);
                j3Var.f4240c = Long.valueOf(w3.a(j3Var.f4239b));
                return b4;
            case 17:
                return g3.d(bArr, i2, j3Var);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public final int a(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, long j2, j3 j3Var) throws IOException {
        int a2;
        int i9 = i2;
        z4 z4Var = (z4) r.getObject(t, j2);
        if (!z4Var.zza()) {
            int size = z4Var.size();
            z4Var = z4Var.zza(size == 0 ? 10 : size << 1);
            r.putObject(t, j2, z4Var);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    c4 c4Var = (c4) z4Var;
                    int a3 = g3.a(bArr, i9, j3Var);
                    int i10 = j3Var.f4238a + a3;
                    while (a3 < i10) {
                        c4Var.a(g3.c(bArr, a3));
                        a3 += 8;
                    }
                    if (a3 == i10) {
                        return a3;
                    }
                    throw c5.zza();
                }
                if (i6 == 1) {
                    c4 c4Var2 = (c4) z4Var;
                    c4Var2.a(g3.c(bArr, i2));
                    while (true) {
                        int i11 = i9 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i9 = g3.a(bArr, i11, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return i11;
                        }
                        c4Var2.a(g3.c(bArr, i9));
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i6 == 2) {
                    r4 r4Var = (r4) z4Var;
                    int a4 = g3.a(bArr, i9, j3Var);
                    int i12 = j3Var.f4238a + a4;
                    while (a4 < i12) {
                        r4Var.a(g3.d(bArr, a4));
                        a4 += 4;
                    }
                    if (a4 == i12) {
                        return a4;
                    }
                    throw c5.zza();
                }
                if (i6 == 5) {
                    r4 r4Var2 = (r4) z4Var;
                    r4Var2.a(g3.d(bArr, i2));
                    while (true) {
                        int i13 = i9 + 4;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i9 = g3.a(bArr, i13, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return i13;
                        }
                        r4Var2.a(g3.d(bArr, i9));
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    r5 r5Var = (r5) z4Var;
                    int a5 = g3.a(bArr, i9, j3Var);
                    int i14 = j3Var.f4238a + a5;
                    while (a5 < i14) {
                        a5 = g3.b(bArr, a5, j3Var);
                        r5Var.a(j3Var.f4239b);
                    }
                    if (a5 == i14) {
                        return a5;
                    }
                    throw c5.zza();
                }
                if (i6 == 0) {
                    r5 r5Var2 = (r5) z4Var;
                    int b2 = g3.b(bArr, i9, j3Var);
                    r5Var2.a(j3Var.f4239b);
                    while (b2 < i3) {
                        int a6 = g3.a(bArr, b2, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return b2;
                        }
                        b2 = g3.b(bArr, a6, j3Var);
                        r5Var2.a(j3Var.f4239b);
                    }
                    return b2;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return g3.a(bArr, i9, (z4<?>) z4Var, j3Var);
                }
                if (i6 == 0) {
                    return g3.a(i4, bArr, i2, i3, (z4<?>) z4Var, j3Var);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    r5 r5Var3 = (r5) z4Var;
                    int a7 = g3.a(bArr, i9, j3Var);
                    int i15 = j3Var.f4238a + a7;
                    while (a7 < i15) {
                        r5Var3.a(g3.b(bArr, a7));
                        a7 += 8;
                    }
                    if (a7 == i15) {
                        return a7;
                    }
                    throw c5.zza();
                }
                if (i6 == 1) {
                    r5 r5Var4 = (r5) z4Var;
                    r5Var4.a(g3.b(bArr, i2));
                    while (true) {
                        int i16 = i9 + 8;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i9 = g3.a(bArr, i16, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return i16;
                        }
                        r5Var4.a(g3.b(bArr, i9));
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    v4 v4Var = (v4) z4Var;
                    int a8 = g3.a(bArr, i9, j3Var);
                    int i17 = j3Var.f4238a + a8;
                    while (a8 < i17) {
                        v4Var.a(g3.a(bArr, a8));
                        a8 += 4;
                    }
                    if (a8 == i17) {
                        return a8;
                    }
                    throw c5.zza();
                }
                if (i6 == 5) {
                    v4 v4Var2 = (v4) z4Var;
                    v4Var2.a(g3.a(bArr, i2));
                    while (true) {
                        int i18 = i9 + 4;
                        if (i18 >= i3) {
                            return i18;
                        }
                        i9 = g3.a(bArr, i18, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return i18;
                        }
                        v4Var2.a(g3.a(bArr, i9));
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i6 == 2) {
                    i3 i3Var = (i3) z4Var;
                    a2 = g3.a(bArr, i9, j3Var);
                    int i19 = j3Var.f4238a + a2;
                    while (a2 < i19) {
                        a2 = g3.b(bArr, a2, j3Var);
                        i3Var.a(j3Var.f4239b != 0);
                    }
                    if (a2 != i19) {
                        throw c5.zza();
                    }
                    return a2;
                }
                if (i6 == 0) {
                    i3 i3Var2 = (i3) z4Var;
                    i9 = g3.b(bArr, i9, j3Var);
                    i3Var2.a(j3Var.f4239b != 0);
                    while (i9 < i3) {
                        int a9 = g3.a(bArr, i9, j3Var);
                        if (i4 == j3Var.f4238a) {
                            i9 = g3.b(bArr, a9, j3Var);
                            i3Var2.a(j3Var.f4239b != 0);
                        }
                    }
                }
                return i9;
            case 26:
                if (i6 == 2) {
                    if ((j & 536870912) == 0) {
                        i9 = g3.a(bArr, i9, j3Var);
                        int i20 = j3Var.f4238a;
                        if (i20 < 0) {
                            throw c5.zzb();
                        }
                        if (i20 == 0) {
                            z4Var.add("");
                        } else {
                            z4Var.add(new String(bArr, i9, i20, u4.f4458a));
                            i9 += i20;
                        }
                        while (i9 < i3) {
                            int a10 = g3.a(bArr, i9, j3Var);
                            if (i4 == j3Var.f4238a) {
                                i9 = g3.a(bArr, a10, j3Var);
                                int i21 = j3Var.f4238a;
                                if (i21 < 0) {
                                    throw c5.zzb();
                                }
                                if (i21 == 0) {
                                    z4Var.add("");
                                } else {
                                    z4Var.add(new String(bArr, i9, i21, u4.f4458a));
                                    i9 += i21;
                                }
                            }
                        }
                    } else {
                        i9 = g3.a(bArr, i9, j3Var);
                        int i22 = j3Var.f4238a;
                        if (i22 < 0) {
                            throw c5.zzb();
                        }
                        if (i22 == 0) {
                            z4Var.add("");
                        } else {
                            int i23 = i9 + i22;
                            if (t7.a(bArr, i9, i23)) {
                                z4Var.add(new String(bArr, i9, i22, u4.f4458a));
                                i9 = i23;
                            } else {
                                throw c5.zzh();
                            }
                        }
                        while (i9 < i3) {
                            int a11 = g3.a(bArr, i9, j3Var);
                            if (i4 == j3Var.f4238a) {
                                i9 = g3.a(bArr, a11, j3Var);
                                int i24 = j3Var.f4238a;
                                if (i24 < 0) {
                                    throw c5.zzb();
                                }
                                if (i24 == 0) {
                                    z4Var.add("");
                                } else {
                                    int i25 = i9 + i24;
                                    if (t7.a(bArr, i9, i25)) {
                                        z4Var.add(new String(bArr, i9, i24, u4.f4458a));
                                        i9 = i25;
                                    } else {
                                        throw c5.zzh();
                                    }
                                }
                            }
                        }
                    }
                }
                return i9;
            case 27:
                if (i6 == 2) {
                    return g3.a(a(i7), i4, bArr, i2, i3, z4Var, j3Var);
                }
                return i9;
            case 28:
                if (i6 == 2) {
                    int a12 = g3.a(bArr, i9, j3Var);
                    int i26 = j3Var.f4238a;
                    if (i26 >= 0) {
                        if (i26 > bArr.length - a12) {
                            throw c5.zza();
                        }
                        if (i26 == 0) {
                            z4Var.add(k3.zza);
                        } else {
                            z4Var.add(k3.zza(bArr, a12, i26));
                            a12 += i26;
                        }
                        while (a12 < i3) {
                            int a13 = g3.a(bArr, a12, j3Var);
                            if (i4 != j3Var.f4238a) {
                                return a12;
                            }
                            a12 = g3.a(bArr, a13, j3Var);
                            int i27 = j3Var.f4238a;
                            if (i27 >= 0) {
                                if (i27 > bArr.length - a12) {
                                    throw c5.zza();
                                }
                                if (i27 == 0) {
                                    z4Var.add(k3.zza);
                                } else {
                                    z4Var.add(k3.zza(bArr, a12, i27));
                                    a12 += i27;
                                }
                            } else {
                                throw c5.zzb();
                            }
                        }
                        return a12;
                    }
                    throw c5.zzb();
                }
                return i9;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        a2 = g3.a(i4, bArr, i2, i3, (z4<?>) z4Var, j3Var);
                    }
                    return i9;
                }
                a2 = g3.a(bArr, i9, (z4<?>) z4Var, j3Var);
                s4 s4Var = (s4) t;
                n7 n7Var = s4Var.zzb;
                if (n7Var == n7.d()) {
                    n7Var = null;
                }
                n7 n7Var2 = (n7) u6.a(i5, z4Var, c(i7), n7Var, this.n);
                if (n7Var2 != null) {
                    s4Var.zzb = n7Var2;
                }
                return a2;
            case 33:
            case 47:
                if (i6 == 2) {
                    v4 v4Var3 = (v4) z4Var;
                    int a14 = g3.a(bArr, i9, j3Var);
                    int i28 = j3Var.f4238a + a14;
                    while (a14 < i28) {
                        a14 = g3.a(bArr, a14, j3Var);
                        v4Var3.a(w3.a(j3Var.f4238a));
                    }
                    if (a14 == i28) {
                        return a14;
                    }
                    throw c5.zza();
                }
                if (i6 == 0) {
                    v4 v4Var4 = (v4) z4Var;
                    int a15 = g3.a(bArr, i9, j3Var);
                    v4Var4.a(w3.a(j3Var.f4238a));
                    while (a15 < i3) {
                        int a16 = g3.a(bArr, a15, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return a15;
                        }
                        a15 = g3.a(bArr, a16, j3Var);
                        v4Var4.a(w3.a(j3Var.f4238a));
                    }
                    return a15;
                }
                return i9;
            case 34:
            case 48:
                if (i6 == 2) {
                    r5 r5Var5 = (r5) z4Var;
                    int a17 = g3.a(bArr, i9, j3Var);
                    int i29 = j3Var.f4238a + a17;
                    while (a17 < i29) {
                        a17 = g3.b(bArr, a17, j3Var);
                        r5Var5.a(w3.a(j3Var.f4239b));
                    }
                    if (a17 == i29) {
                        return a17;
                    }
                    throw c5.zza();
                }
                if (i6 == 0) {
                    r5 r5Var6 = (r5) z4Var;
                    int b3 = g3.b(bArr, i9, j3Var);
                    r5Var6.a(w3.a(j3Var.f4239b));
                    while (b3 < i3) {
                        int a18 = g3.a(bArr, b3, j3Var);
                        if (i4 != j3Var.f4238a) {
                            return b3;
                        }
                        b3 = g3.b(bArr, a18, j3Var);
                        r5Var6.a(w3.a(j3Var.f4239b));
                    }
                    return b3;
                }
                return i9;
            case 49:
                if (i6 == 3) {
                    t6 a19 = a(i7);
                    int i30 = (i4 & (-8)) | 4;
                    i9 = g3.a(a19, bArr, i2, i3, i30, j3Var);
                    z4Var.add(j3Var.f4240c);
                    while (i9 < i3) {
                        int a20 = g3.a(bArr, i9, j3Var);
                        if (i4 == j3Var.f4238a) {
                            i9 = g3.a(a19, bArr, a20, i3, i30, j3Var);
                            z4Var.add(j3Var.f4240c);
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    public final <K, V> int a(T t, byte[] bArr, int i2, int i3, int i4, long j, j3 j3Var) throws IOException {
        Unsafe unsafe = r;
        Object b2 = b(i4);
        Object object2 = unsafe.getObject(t, j);
        if (this.p.c(object2)) {
            Object f2 = this.p.f(b2);
            this.p.a(f2, object2);
            unsafe.putObject(t, j, f2);
            object2 = f2;
        }
        u5<?, ?> e2 = this.p.e(b2);
        Map<?, ?> a2 = this.p.a(object2);
        int a3 = g3.a(bArr, i2, j3Var);
        int i5 = j3Var.f4238a;
        if (i5 >= 0 && i5 <= i3 - a3) {
            int i6 = i5 + a3;
            K k = e2.f4461b;
            V v = e2.f4463d;
            while (a3 < i6) {
                int i7 = a3 + 1;
                int i8 = bArr[a3];
                if (i8 < 0) {
                    i7 = g3.a(i8, bArr, i7, j3Var);
                    i8 = j3Var.f4238a;
                }
                int i9 = i7;
                int i10 = i8 >>> 3;
                int i11 = i8 & 7;
                if (i10 != 1) {
                    if (i10 == 2 && i11 == e2.f4462c.zzb()) {
                        a3 = a(bArr, i9, i3, e2.f4462c, e2.f4463d.getClass(), j3Var);
                        v = j3Var.f4240c;
                    }
                    a3 = g3.a(i8, bArr, i9, i3, j3Var);
                } else if (i11 == e2.f4460a.zzb()) {
                    a3 = a(bArr, i9, i3, e2.f4460a, (Class<?>) null, j3Var);
                    k = (K) j3Var.f4240c;
                } else {
                    a3 = g3.a(i8, bArr, i9, i3, j3Var);
                }
            }
            if (a3 == i6) {
                a2.put(k, v);
                return i6;
            }
            throw c5.zzg();
        }
        throw c5.zza();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int a(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, int i9, j3 j3Var) throws IOException {
        int b2;
        Unsafe unsafe = r;
        long j2 = this.f4205a[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(g3.c(bArr, i2)));
                    b2 = i2 + 8;
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(g3.d(bArr, i2)));
                    b2 = i2 + 4;
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    b2 = g3.b(bArr, i2, j3Var);
                    unsafe.putObject(t, j, Long.valueOf(j3Var.f4239b));
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    b2 = g3.a(bArr, i2, j3Var);
                    unsafe.putObject(t, j, Integer.valueOf(j3Var.f4238a));
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(g3.b(bArr, i2)));
                    b2 = i2 + 8;
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(g3.a(bArr, i2)));
                    b2 = i2 + 4;
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    b2 = g3.b(bArr, i2, j3Var);
                    unsafe.putObject(t, j, Boolean.valueOf(j3Var.f4239b != 0));
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int a2 = g3.a(bArr, i2, j3Var);
                    int i10 = j3Var.f4238a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i7 & 536870912) != 0 && !t7.a(bArr, a2, a2 + i10)) {
                            throw c5.zzh();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i10, u4.f4458a));
                        a2 += i10;
                    }
                    unsafe.putInt(t, j2, i5);
                    return a2;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int a3 = g3.a(a(i9), bArr, i2, i3, j3Var);
                    Object object2 = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, j3Var.f4240c);
                    } else {
                        unsafe.putObject(t, j, u4.a(object2, j3Var.f4240c));
                    }
                    unsafe.putInt(t, j2, i5);
                    return a3;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    b2 = g3.e(bArr, i2, j3Var);
                    unsafe.putObject(t, j, j3Var.f4240c);
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int a4 = g3.a(bArr, i2, j3Var);
                    int i11 = j3Var.f4238a;
                    y4 c2 = c(i9);
                    if (c2 != null && !c2.zza(i11)) {
                        e(t).a(i4, Long.valueOf(i11));
                        return a4;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i11));
                    b2 = a4;
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    b2 = g3.a(bArr, i2, j3Var);
                    unsafe.putObject(t, j, Integer.valueOf(w3.a(j3Var.f4238a)));
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    b2 = g3.b(bArr, i2, j3Var);
                    unsafe.putObject(t, j, Long.valueOf(w3.a(j3Var.f4239b)));
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    b2 = g3.a(a(i9), bArr, i2, i3, (i4 & (-8)) | 4, j3Var);
                    Object object3 = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                    if (object3 == null) {
                        unsafe.putObject(t, j, j3Var.f4240c);
                    } else {
                        unsafe.putObject(t, j, u4.a(object3, j3Var.f4240c));
                    }
                    unsafe.putInt(t, j2, i5);
                    return b2;
                }
                return i2;
            default:
                return i2;
        }
    }

    public final t6 a(int i2) {
        int i3 = (i2 / 3) << 1;
        t6 t6Var = (t6) this.f4206b[i3];
        if (t6Var != null) {
            return t6Var;
        }
        t6<T> a2 = p6.a().a((Class) this.f4206b[i3 + 1]);
        this.f4206b[i3] = a2;
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x04da, code lost:
    
        if (r6 == r1) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x04dc, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x04e2, code lost:
    
        r1 = null;
        r2 = r9.j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x04e7, code lost:
    
        if (r2 >= r9.k) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x04e9, code lost:
    
        r1 = (c.c.a.b.f.e.n7) r9.a(r12, r9.f4213i[r2], (int) r1, (c.c.a.b.f.e.k7<UT, int>) r9.n);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x04f8, code lost:
    
        if (r1 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x04fa, code lost:
    
        r9.n.b(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x04ff, code lost:
    
        if (r7 != 0) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0503, code lost:
    
        if (r0 != r31) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x050a, code lost:
    
        throw c.c.a.b.f.e.c5.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0511, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x050d, code lost:
    
        if (r0 > r31) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x050f, code lost:
    
        if (r3 != r7) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0517, code lost:
    
        throw c.c.a.b.f.e.c5.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(T r28, byte[] r29, int r30, int r31, int r32, c.c.a.b.f.e.j3 r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.a(java.lang.Object, byte[], int, int, int, c.c.a.b.f.e.j3):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02dc, code lost:
    
        if (r0 == r5) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02e0, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0348, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0323, code lost:
    
        if (r0 == r15) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0346, code lost:
    
        if (r0 == r15) goto L116;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0095. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // c.c.a.b.f.e.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r31, byte[] r32, int r33, int r34, c.c.a.b.f.e.j3 r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.h6.a(java.lang.Object, byte[], int, int, c.c.a.b.f.e.j3):void");
    }

    public final <UT, UB> UB a(Object obj, int i2, UB ub, k7<UT, UB> k7Var) {
        y4 c2;
        int i3 = this.f4205a[i2];
        Object f2 = q7.f(obj, d(i2) & 1048575);
        return (f2 == null || (c2 = c(i2)) == null) ? ub : (UB) a(i2, i3, this.p.a(f2), c2, (y4) ub, (k7<UT, y4>) k7Var);
    }

    public final <K, V, UT, UB> UB a(int i2, int i3, Map<K, V> map, y4 y4Var, UB ub, k7<UT, UB> k7Var) {
        u5<?, ?> e2 = this.p.e(b(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!y4Var.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = k7Var.a();
                }
                s3 zzc = k3.zzc(v5.a(e2, next.getKey(), next.getValue()));
                try {
                    v5.a(zzc.b(), e2, next.getKey(), next.getValue());
                    k7Var.a((k7<UT, UB>) ub, i3, zzc.a());
                    it.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Object obj, int i2, t6 t6Var) {
        return t6Var.b(q7.f(obj, i2 & 1048575));
    }

    public static void a(int i2, Object obj, h8 h8Var) throws IOException {
        if (obj instanceof String) {
            h8Var.a(i2, (String) obj);
        } else {
            h8Var.a(i2, (k3) obj);
        }
    }

    public final boolean a(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return a((h6<T>) t, i2);
        }
        return (i4 & i5) != 0;
    }

    public final boolean a(T t, int i2) {
        int e2 = e(i2);
        long j = e2 & 1048575;
        if (j != 1048575) {
            return (q7.a(t, j) & (1 << (e2 >>> 20))) != 0;
        }
        int d2 = d(i2);
        long j2 = d2 & 1048575;
        switch ((d2 & 267386880) >>> 20) {
            case 0:
                return q7.e(t, j2) != 0.0d;
            case 1:
                return q7.d(t, j2) != 0.0f;
            case 2:
                return q7.b(t, j2) != 0;
            case 3:
                return q7.b(t, j2) != 0;
            case 4:
                return q7.a(t, j2) != 0;
            case 5:
                return q7.b(t, j2) != 0;
            case 6:
                return q7.a(t, j2) != 0;
            case 7:
                return q7.c(t, j2);
            case 8:
                Object f2 = q7.f(t, j2);
                if (f2 instanceof String) {
                    return !((String) f2).isEmpty();
                }
                if (f2 instanceof k3) {
                    return !k3.zza.equals(f2);
                }
                throw new IllegalArgumentException();
            case 9:
                return q7.f(t, j2) != null;
            case 10:
                return !k3.zza.equals(q7.f(t, j2));
            case 11:
                return q7.a(t, j2) != 0;
            case 12:
                return q7.a(t, j2) != 0;
            case 13:
                return q7.a(t, j2) != 0;
            case 14:
                return q7.b(t, j2) != 0;
            case 15:
                return q7.a(t, j2) != 0;
            case 16:
                return q7.b(t, j2) != 0;
            case 17:
                return q7.f(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean a(T t, int i2, int i3) {
        return q7.a(t, (long) (e(i3) & 1048575)) == i2;
    }

    public final int a(int i2, int i3) {
        if (i2 < this.f4207c || i2 > this.f4208d) {
            return -1;
        }
        return b(i2, i3);
    }
}
