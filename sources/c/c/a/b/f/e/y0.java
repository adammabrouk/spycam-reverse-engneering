package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class y0 extends s4<y0, a> implements f6 {
    public static final y0 zzf;
    public static volatile n6<y0> zzg;
    public int zzc;
    public String zzd = "";
    public long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<y0, a> implements f6 {
        public a() {
            super(y0.zzf);
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }
    }

    static {
        y0 y0Var = new y0();
        zzf = y0Var;
        s4.a((Class<y0>) y0.class, y0Var);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new y0();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                n6<y0> n6Var = zzg;
                if (n6Var == null) {
                    synchronized (y0.class) {
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
