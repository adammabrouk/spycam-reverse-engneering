package c.c.a.b.f.e;

import c.c.a.b.f.e.d1;
import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class v0 extends s4<v0, a> implements f6 {
    public static final v0 zzh;
    public static volatile n6<v0> zzi;
    public int zzc;
    public int zzd;
    public d1 zze;
    public d1 zzf;
    public boolean zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<v0, a> implements f6 {
        public a() {
            super(v0.zzh);
        }

        public final a a(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((v0) this.f4417b).b(i2);
            return this;
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(d1.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((v0) this.f4417b).a((d1) ((s4) aVar.F()));
            return this;
        }

        public final a a(d1 d1Var) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((v0) this.f4417b).b(d1Var);
            return this;
        }

        public final a a(boolean z) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((v0) this.f4417b).a(z);
            return this;
        }
    }

    static {
        v0 v0Var = new v0();
        zzh = v0Var;
        s4.a((Class<v0>) v0.class, v0Var);
    }

    public static a t() {
        return zzh.i();
    }

    public final void a(d1 d1Var) {
        d1Var.getClass();
        this.zze = d1Var;
        this.zzc |= 2;
    }

    public final void b(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    public final int n() {
        return this.zzd;
    }

    public final d1 o() {
        d1 d1Var = this.zze;
        return d1Var == null ? d1.z() : d1Var;
    }

    public final boolean p() {
        return (this.zzc & 4) != 0;
    }

    public final d1 q() {
        d1 d1Var = this.zzf;
        return d1Var == null ? d1.z() : d1Var;
    }

    public final boolean r() {
        return (this.zzc & 8) != 0;
    }

    public final boolean s() {
        return this.zzg;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    public final void b(d1 d1Var) {
        d1Var.getClass();
        this.zzf = d1Var;
        this.zzc |= 4;
    }

    public final void a(boolean z) {
        this.zzc |= 8;
        this.zzg = z;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new v0();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                n6<v0> n6Var = zzi;
                if (n6Var == null) {
                    synchronized (v0.class) {
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
