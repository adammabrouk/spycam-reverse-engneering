package c.c.a.b.f.e;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class g3 {
    public static int a(byte[] bArr, int i2, j3 j3Var) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a(b2, bArr, i3, j3Var);
        }
        j3Var.f4238a = b2;
        return i3;
    }

    public static int b(byte[] bArr, int i2, j3 j3Var) {
        int i3 = i2 + 1;
        long j = bArr[i2];
        if (j >= 0) {
            j3Var.f4239b = j;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        j3Var.f4239b = j2;
        return i4;
    }

    public static double c(byte[] bArr, int i2) {
        return Double.longBitsToDouble(b(bArr, i2));
    }

    public static float d(byte[] bArr, int i2) {
        return Float.intBitsToFloat(a(bArr, i2));
    }

    public static int e(byte[] bArr, int i2, j3 j3Var) throws c5 {
        int a2 = a(bArr, i2, j3Var);
        int i3 = j3Var.f4238a;
        if (i3 < 0) {
            throw c5.zzb();
        }
        if (i3 > bArr.length - a2) {
            throw c5.zza();
        }
        if (i3 == 0) {
            j3Var.f4240c = k3.zza;
            return a2;
        }
        j3Var.f4240c = k3.zza(bArr, a2, i3);
        return a2 + i3;
    }

    public static int c(byte[] bArr, int i2, j3 j3Var) throws c5 {
        int a2 = a(bArr, i2, j3Var);
        int i3 = j3Var.f4238a;
        if (i3 < 0) {
            throw c5.zzb();
        }
        if (i3 == 0) {
            j3Var.f4240c = "";
            return a2;
        }
        j3Var.f4240c = new String(bArr, a2, i3, u4.f4458a);
        return a2 + i3;
    }

    public static int d(byte[] bArr, int i2, j3 j3Var) throws c5 {
        int a2 = a(bArr, i2, j3Var);
        int i3 = j3Var.f4238a;
        if (i3 < 0) {
            throw c5.zzb();
        }
        if (i3 == 0) {
            j3Var.f4240c = "";
            return a2;
        }
        j3Var.f4240c = t7.b(bArr, a2, i3);
        return a2 + i3;
    }

    public static int a(int i2, byte[] bArr, int i3, j3 j3Var) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            j3Var.f4238a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            j3Var.f4238a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            j3Var.f4238a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            j3Var.f4238a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                j3Var.f4238a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static long b(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & ThreadUtils.TYPE_SINGLE) << 24) | (bArr[i2] & ThreadUtils.TYPE_SINGLE) | ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) << 8) | ((bArr[i2 + 2] & ThreadUtils.TYPE_SINGLE) << 16);
    }

    public static int a(t6 t6Var, byte[] bArr, int i2, int i3, j3 j3Var) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = a(i5, bArr, i4, j3Var);
            i5 = j3Var.f4238a;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object zza = t6Var.zza();
            int i7 = i5 + i6;
            t6Var.a(zza, bArr, i6, i7, j3Var);
            t6Var.c(zza);
            j3Var.f4240c = zza;
            return i7;
        }
        throw c5.zza();
    }

    public static int a(t6 t6Var, byte[] bArr, int i2, int i3, int i4, j3 j3Var) throws IOException {
        h6 h6Var = (h6) t6Var;
        Object zza = h6Var.zza();
        int a2 = h6Var.a((h6) zza, bArr, i2, i3, i4, j3Var);
        h6Var.c((h6) zza);
        j3Var.f4240c = zza;
        return a2;
    }

    public static int a(int i2, byte[] bArr, int i3, int i4, z4<?> z4Var, j3 j3Var) {
        v4 v4Var = (v4) z4Var;
        int a2 = a(bArr, i3, j3Var);
        v4Var.a(j3Var.f4238a);
        while (a2 < i4) {
            int a3 = a(bArr, a2, j3Var);
            if (i2 != j3Var.f4238a) {
                break;
            }
            a2 = a(bArr, a3, j3Var);
            v4Var.a(j3Var.f4238a);
        }
        return a2;
    }

    public static int a(byte[] bArr, int i2, z4<?> z4Var, j3 j3Var) throws IOException {
        v4 v4Var = (v4) z4Var;
        int a2 = a(bArr, i2, j3Var);
        int i3 = j3Var.f4238a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, j3Var);
            v4Var.a(j3Var.f4238a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw c5.zza();
    }

    public static int a(t6<?> t6Var, int i2, byte[] bArr, int i3, int i4, z4<?> z4Var, j3 j3Var) throws IOException {
        int a2 = a(t6Var, bArr, i3, i4, j3Var);
        z4Var.add(j3Var.f4240c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, j3Var);
            if (i2 != j3Var.f4238a) {
                break;
            }
            a2 = a(t6Var, bArr, a3, i4, j3Var);
            z4Var.add(j3Var.f4240c);
        }
        return a2;
    }

    public static int a(int i2, byte[] bArr, int i3, int i4, n7 n7Var, j3 j3Var) throws c5 {
        if ((i2 >>> 3) == 0) {
            throw c5.zzd();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int b2 = b(bArr, i3, j3Var);
            n7Var.a(i2, Long.valueOf(j3Var.f4239b));
            return b2;
        }
        if (i5 == 1) {
            n7Var.a(i2, Long.valueOf(b(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int a2 = a(bArr, i3, j3Var);
            int i6 = j3Var.f4238a;
            if (i6 >= 0) {
                if (i6 > bArr.length - a2) {
                    throw c5.zza();
                }
                if (i6 == 0) {
                    n7Var.a(i2, k3.zza);
                } else {
                    n7Var.a(i2, k3.zza(bArr, a2, i6));
                }
                return a2 + i6;
            }
            throw c5.zzb();
        }
        if (i5 != 3) {
            if (i5 == 5) {
                n7Var.a(i2, Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            }
            throw c5.zzd();
        }
        n7 e2 = n7.e();
        int i7 = (i2 & (-8)) | 4;
        int i8 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int a3 = a(bArr, i3, j3Var);
            int i9 = j3Var.f4238a;
            i8 = i9;
            if (i9 == i7) {
                i3 = a3;
                break;
            }
            int a4 = a(i8, bArr, a3, i4, e2, j3Var);
            i8 = i9;
            i3 = a4;
        }
        if (i3 <= i4 && i8 == i7) {
            n7Var.a(i2, e2);
            return i3;
        }
        throw c5.zzg();
    }

    public static int a(int i2, byte[] bArr, int i3, int i4, j3 j3Var) throws c5 {
        if ((i2 >>> 3) == 0) {
            throw c5.zzd();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return b(bArr, i3, j3Var);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return a(bArr, i3, j3Var) + j3Var.f4238a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw c5.zzd();
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = a(bArr, i3, j3Var);
            i7 = j3Var.f4238a;
            if (i7 == i6) {
                break;
            }
            i3 = a(i7, bArr, i3, i4, j3Var);
        }
        if (i3 > i4 || i7 != i6) {
            throw c5.zzg();
        }
        return i3;
    }
}
