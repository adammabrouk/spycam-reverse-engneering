package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class j0 extends s4<j0, b> implements f6 {
    public static final j0 zzi;
    public static volatile n6<j0> zzj;
    public int zzc;
    public int zzd;
    public boolean zze;
    public String zzf = "";
    public String zzg = "";
    public String zzh = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public enum a implements w4 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        public final int zzg;

        static {
            new o0();
        }

        a(int i2) {
            this.zzg = i2;
        }

        public static y4 zzb() {
            return n0.f4315a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // c.c.a.b.f.e.w4
        public final int zza() {
            return this.zzg;
        }

        public static a zza(int i2) {
            if (i2 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i2 == 1) {
                return LESS_THAN;
            }
            if (i2 == 2) {
                return GREATER_THAN;
            }
            if (i2 == 3) {
                return EQUAL;
            }
            if (i2 != 4) {
                return null;
            }
            return BETWEEN;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class b extends s4.b<j0, b> implements f6 {
        public b() {
            super(j0.zzi);
        }

        public /* synthetic */ b(m0 m0Var) {
            this();
        }
    }

    static {
        j0 j0Var = new j0();
        zzi = j0Var;
        s4.a((Class<j0>) j0.class, j0Var);
    }

    public static j0 w() {
        return zzi;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new j0();
            case 2:
                return new b(m0Var);
            case 3:
                return s4.a(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", a.zzb(), "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                n6<j0> n6Var = zzj;
                if (n6Var == null) {
                    synchronized (j0.class) {
                        n6Var = zzj;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzi);
                            zzj = n6Var;
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

    public final a n() {
        a zza = a.zza(this.zzd);
        return zza == null ? a.UNKNOWN_COMPARISON_TYPE : zza;
    }

    public final boolean o() {
        return (this.zzc & 2) != 0;
    }

    public final boolean p() {
        return this.zze;
    }

    public final boolean q() {
        return (this.zzc & 4) != 0;
    }

    public final String r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzc & 8) != 0;
    }

    public final String t() {
        return this.zzg;
    }

    public final boolean u() {
        return (this.zzc & 16) != 0;
    }

    public final String v() {
        return this.zzh;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }
}
