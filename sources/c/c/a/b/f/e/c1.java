package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class c1 extends s4<c1, b> implements f6 {
    public static final c1 zzf;
    public static volatile n6<c1> zzg;
    public int zzc;
    public int zzd = 1;
    public z4<y0> zze = s4.m();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public enum a implements w4 {
        RADS(1),
        PROVISIONING(2);

        public final int zzd;

        static {
            new i1();
        }

        a(int i2) {
            this.zzd = i2;
        }

        public static y4 zzb() {
            return h1.f4198a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }

        @Override // c.c.a.b.f.e.w4
        public final int zza() {
            return this.zzd;
        }

        public static a zza(int i2) {
            if (i2 == 1) {
                return RADS;
            }
            if (i2 != 2) {
                return null;
            }
            return PROVISIONING;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class b extends s4.b<c1, b> implements f6 {
        public b() {
            super(c1.zzf);
        }

        public /* synthetic */ b(g1 g1Var) {
            this();
        }
    }

    static {
        c1 c1Var = new c1();
        zzf = c1Var;
        s4.a((Class<c1>) c1.class, c1Var);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new c1();
            case 2:
                return new b(g1Var);
            case 3:
                return s4.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", a.zzb(), "zze", y0.class});
            case 4:
                return zzf;
            case 5:
                n6<c1> n6Var = zzg;
                if (n6Var == null) {
                    synchronized (c1.class) {
                        n6Var = zzg;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzf);
                            zzg = n6Var;
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
}
