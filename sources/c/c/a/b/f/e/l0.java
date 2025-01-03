package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class l0 extends s4<l0, a> implements f6 {
    public static final l0 zzh;
    public static volatile n6<l0> zzi;
    public int zzc;
    public int zzd;
    public boolean zzf;
    public String zze = "";
    public z4<String> zzg = s4.m();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<l0, a> implements f6 {
        public a() {
            super(l0.zzh);
        }

        public /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public enum b implements w4 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);

        public final int zzi;

        static {
            new p0();
        }

        b(int i2) {
            this.zzi = i2;
        }

        public static y4 zzb() {
            return t0.f4440a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }

        @Override // c.c.a.b.f.e.w4
        public final int zza() {
            return this.zzi;
        }

        public static b zza(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }
    }

    static {
        l0 l0Var = new l0();
        zzh = l0Var;
        s4.a((Class<l0>) l0.class, l0Var);
    }

    public static l0 u() {
        return zzh;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new l0();
            case 2:
                return new a(m0Var);
            case 3:
                return s4.a(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", b.zzb(), "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                n6<l0> n6Var = zzi;
                if (n6Var == null) {
                    synchronized (l0.class) {
                        n6Var = zzi;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzh);
                            zzi = n6Var;
                        }
                    }
                }
                return n6Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final b n() {
        b zza = b.zza(this.zzd);
        return zza == null ? b.UNKNOWN_MATCH_TYPE : zza;
    }

    public final boolean o() {
        return (this.zzc & 2) != 0;
    }

    public final String p() {
        return this.zze;
    }

    public final boolean q() {
        return (this.zzc & 4) != 0;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final List<String> s() {
        return this.zzg;
    }

    public final int t() {
        return this.zzg.size();
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }
}
