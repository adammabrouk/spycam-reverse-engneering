package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class i0 extends s4<i0, a> implements f6 {
    public static final i0 zzh;
    public static volatile n6<i0> zzi;
    public int zzc;
    public l0 zzd;
    public j0 zze;
    public boolean zzf;
    public String zzg = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<i0, a> implements f6 {
        public a() {
            super(i0.zzh);
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((i0) this.f4417b).a(str);
            return this;
        }

        public /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    static {
        i0 i0Var = new i0();
        zzh = i0Var;
        s4.a((Class<i0>) i0.class, i0Var);
    }

    public static i0 u() {
        return zzh;
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 8;
        this.zzg = str;
    }

    public final l0 n() {
        l0 l0Var = this.zzd;
        return l0Var == null ? l0.u() : l0Var;
    }

    public final boolean o() {
        return (this.zzc & 2) != 0;
    }

    public final j0 p() {
        j0 j0Var = this.zze;
        return j0Var == null ? j0.w() : j0Var;
    }

    public final boolean q() {
        return (this.zzc & 4) != 0;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzc & 8) != 0;
    }

    public final String t() {
        return this.zzg;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new i0();
            case 2:
                return new a(m0Var);
            case 3:
                return s4.a(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                n6<i0> n6Var = zzi;
                if (n6Var == null) {
                    synchronized (i0.class) {
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
