package c.c.a.b.f.e;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class u3 extends v3 {
    public final byte[] zzb;

    public u3(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
        this.zzb = bArr;
    }

    @Override // c.c.a.b.f.e.k3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k3) || zza() != ((k3) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof u3)) {
            return obj.equals(this);
        }
        u3 u3Var = (u3) obj;
        int zzd = zzd();
        int zzd2 = u3Var.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(u3Var, 0, zza());
        }
        return false;
    }

    @Override // c.c.a.b.f.e.k3
    public byte zza(int i2) {
        return this.zzb[i2];
    }

    @Override // c.c.a.b.f.e.k3
    public byte zzb(int i2) {
        return this.zzb[i2];
    }

    @Override // c.c.a.b.f.e.k3
    public final boolean zzc() {
        int zze = zze();
        return t7.a(this.zzb, zze, zza() + zze);
    }

    public int zze() {
        return 0;
    }

    @Override // c.c.a.b.f.e.k3
    public int zza() {
        return this.zzb.length;
    }

    @Override // c.c.a.b.f.e.k3
    public final k3 zza(int i2, int i3) {
        int zzb = k3.zzb(0, i3, zza());
        if (zzb == 0) {
            return k3.zza;
        }
        return new r3(this.zzb, zze(), zzb);
    }

    @Override // c.c.a.b.f.e.k3
    public final void zza(l3 l3Var) throws IOException {
        l3Var.a(this.zzb, zze(), zza());
    }

    @Override // c.c.a.b.f.e.k3
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // c.c.a.b.f.e.v3
    public final boolean zza(k3 k3Var, int i2, int i3) {
        if (i3 <= k3Var.zza()) {
            if (i3 <= k3Var.zza()) {
                if (k3Var instanceof u3) {
                    u3 u3Var = (u3) k3Var;
                    byte[] bArr = this.zzb;
                    byte[] bArr2 = u3Var.zzb;
                    int zze = zze() + i3;
                    int zze2 = zze();
                    int zze3 = u3Var.zze();
                    while (zze2 < zze) {
                        if (bArr[zze2] != bArr2[zze3]) {
                            return false;
                        }
                        zze2++;
                        zze3++;
                    }
                    return true;
                }
                return k3Var.zza(0, i3).equals(zza(0, i3));
            }
            int zza = k3Var.zza();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i3);
            sb.append(", ");
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        }
        int zza2 = zza();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(zza2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // c.c.a.b.f.e.k3
    public final int zza(int i2, int i3, int i4) {
        return u4.a(i2, this.zzb, zze(), i4);
    }
}
