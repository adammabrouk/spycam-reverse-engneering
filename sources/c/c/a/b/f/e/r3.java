package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class r3 extends u3 {
    public final int zzc;
    public final int zzd;

    public r3(byte[] bArr, int i2, int i3) {
        super(bArr);
        k3.zzb(i2, i2 + i3, bArr.length);
        this.zzc = i2;
        this.zzd = i3;
    }

    @Override // c.c.a.b.f.e.u3, c.c.a.b.f.e.k3
    public final byte zza(int i2) {
        int zza = zza();
        if (((zza - (i2 + 1)) | i2) >= 0) {
            return this.zzb[this.zzc + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(zza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // c.c.a.b.f.e.u3, c.c.a.b.f.e.k3
    public final byte zzb(int i2) {
        return this.zzb[this.zzc + i2];
    }

    @Override // c.c.a.b.f.e.u3
    public final int zze() {
        return this.zzc;
    }

    @Override // c.c.a.b.f.e.u3, c.c.a.b.f.e.k3
    public final int zza() {
        return this.zzd;
    }
}
