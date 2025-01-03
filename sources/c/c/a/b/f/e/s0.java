package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class s0 extends s4<s0, a> implements f6 {
    public static final s0 zzf;
    public static volatile n6<s0> zzg;
    public int zzc;
    public String zzd = "";
    public String zze = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<s0, a> implements f6 {
        public a() {
            super(s0.zzf);
        }

        public /* synthetic */ a(u0 u0Var) {
            this();
        }
    }

    static {
        s0 s0Var = new s0();
        zzf = s0Var;
        s4.a((Class<s0>) s0.class, s0Var);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        u0 u0Var = null;
        switch (u0.f4452a[i2 - 1]) {
            case 1:
                return new s0();
            case 2:
                return new a(u0Var);
            case 3:
                return s4.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                n6<s0> n6Var = zzg;
                if (n6Var == null) {
                    synchronized (s0.class) {
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

    public final String n() {
        return this.zze;
    }

    public final String zza() {
        return this.zzd;
    }
}
