package c.c.a.b.f.e;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class k3 implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final q3 f4252a;
    public static final k3 zza = new u3(u4.f4459b);
    public int zzc = 0;

    static {
        n3 n3Var = null;
        f4252a = h3.a() ? new x3(n3Var) : new o3(n3Var);
        new m3();
    }

    public static int a(byte b2) {
        return b2 & ThreadUtils.TYPE_SINGLE;
    }

    public static k3 zza(byte[] bArr, int i2, int i3) {
        zzb(i2, i2 + i3, bArr.length);
        return new u3(f4252a.a(bArr, i2, i3));
    }

    public static s3 zzc(int i2) {
        return new s3(i2, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zza2 = zza();
            i2 = zza(zza2, 0, zza2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new n3(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? g7.a(this) : String.valueOf(g7.a(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i2);

    public abstract int zza();

    public abstract int zza(int i2, int i3, int i4);

    public abstract k3 zza(int i2, int i3);

    public abstract String zza(Charset charset);

    public abstract void zza(l3 l3Var) throws IOException;

    public abstract byte zzb(int i2);

    public final String zzb() {
        return zza() == 0 ? "" : zza(u4.f4458a);
    }

    public abstract boolean zzc();

    public final int zzd() {
        return this.zzc;
    }

    public static k3 zza(byte[] bArr) {
        return new u3(bArr);
    }

    public static int zzb(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i3);
        sb3.append(" >= ");
        sb3.append(i4);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public static k3 zza(String str) {
        return new u3(str.getBytes(u4.f4458a));
    }
}
