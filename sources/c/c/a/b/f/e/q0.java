package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class q0 extends s4<q0, a> implements f6 {
    public static final q0 zzh;
    public static volatile n6<q0> zzi;
    public int zzc;
    public String zzd = "";
    public boolean zze;
    public boolean zzf;
    public int zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<q0, a> implements f6 {
        public a() {
            super(q0.zzh);
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((q0) this.f4417b).a(str);
            return this;
        }

        public final boolean j() {
            return ((q0) this.f4417b).n();
        }

        public final boolean k() {
            return ((q0) this.f4417b).o();
        }

        public final boolean l() {
            return ((q0) this.f4417b).p();
        }

        public final int m() {
            return ((q0) this.f4417b).q();
        }

        public final String zza() {
            return ((q0) this.f4417b).zza();
        }

        public /* synthetic */ a(u0 u0Var) {
            this();
        }
    }

    static {
        q0 q0Var = new q0();
        zzh = q0Var;
        s4.a((Class<q0>) q0.class, q0Var);
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final boolean n() {
        return this.zze;
    }

    public final boolean o() {
        return this.zzf;
    }

    public final boolean p() {
        return (this.zzc & 8) != 0;
    }

    public final int q() {
        return this.zzg;
    }

    public final String zza() {
        return this.zzd;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        u0 u0Var = null;
        switch (u0.f4452a[i2 - 1]) {
            case 1:
                return new q0();
            case 2:
                return new a(u0Var);
            case 3:
                return s4.a(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                n6<q0> n6Var = zzi;
                if (n6Var == null) {
                    synchronized (q0.class) {
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
}
