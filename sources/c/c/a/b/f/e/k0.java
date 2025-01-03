package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class k0 extends s4<k0, a> implements f6 {
    public static final k0 zzj;
    public static volatile n6<k0> zzk;
    public int zzc;
    public int zzd;
    public String zze = "";
    public i0 zzf;
    public boolean zzg;
    public boolean zzh;
    public boolean zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<k0, a> implements f6 {
        public a() {
            super(k0.zzj);
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((k0) this.f4417b).a(str);
            return this;
        }

        public /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    static {
        k0 k0Var = new k0();
        zzj = k0Var;
        s4.a((Class<k0>) k0.class, k0Var);
    }

    public static a u() {
        return zzj.i();
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public final int n() {
        return this.zzd;
    }

    public final String o() {
        return this.zze;
    }

    public final i0 p() {
        i0 i0Var = this.zzf;
        return i0Var == null ? i0.u() : i0Var;
    }

    public final boolean q() {
        return this.zzg;
    }

    public final boolean r() {
        return this.zzh;
    }

    public final boolean s() {
        return (this.zzc & 32) != 0;
    }

    public final boolean t() {
        return this.zzi;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new k0();
            case 2:
                return new a(m0Var);
            case 3:
                return s4.a(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                n6<k0> n6Var = zzk;
                if (n6Var == null) {
                    synchronized (k0.class) {
                        n6Var = zzk;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzj);
                            zzk = n6Var;
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
