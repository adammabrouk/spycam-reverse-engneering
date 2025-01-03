package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class d1 extends s4<d1, a> implements f6 {
    public static final d1 zzg;
    public static volatile n6<d1> zzh;
    public a5 zzc = s4.l();
    public a5 zzd = s4.l();
    public z4<w0> zze = s4.m();
    public z4<e1> zzf = s4.m();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<d1, a> implements f6 {
        public a() {
            super(d1.zzg);
        }

        public final a a(Iterable<? extends Long> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).a(iterable);
            return this;
        }

        public final a b(Iterable<? extends Long> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).b(iterable);
            return this;
        }

        public final a c(Iterable<? extends w0> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).c(iterable);
            return this;
        }

        public final a d(Iterable<? extends e1> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).d(iterable);
            return this;
        }

        public final a j() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).v();
            return this;
        }

        public final a zza() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).u();
            return this;
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).d(i2);
            return this;
        }

        public final a b(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((d1) this.f4417b).e(i2);
            return this;
        }
    }

    static {
        d1 d1Var = new d1();
        zzg = d1Var;
        s4.a((Class<d1>) d1.class, d1Var);
    }

    public static a y() {
        return zzg.i();
    }

    public static d1 z() {
        return zzg;
    }

    public final void a(Iterable<? extends Long> iterable) {
        a5 a5Var = this.zzc;
        if (!a5Var.zza()) {
            this.zzc = s4.a(a5Var);
        }
        b3.a(iterable, this.zzc);
    }

    public final void b(Iterable<? extends Long> iterable) {
        a5 a5Var = this.zzd;
        if (!a5Var.zza()) {
            this.zzd = s4.a(a5Var);
        }
        b3.a(iterable, this.zzd);
    }

    public final void c(Iterable<? extends w0> iterable) {
        w();
        b3.a(iterable, this.zze);
    }

    public final void d(int i2) {
        w();
        this.zze.remove(i2);
    }

    public final void e(int i2) {
        x();
        this.zzf.remove(i2);
    }

    public final int n() {
        return this.zzc.size();
    }

    public final List<Long> o() {
        return this.zzd;
    }

    public final int p() {
        return this.zzd.size();
    }

    public final List<w0> q() {
        return this.zze;
    }

    public final int r() {
        return this.zze.size();
    }

    public final List<e1> s() {
        return this.zzf;
    }

    public final int t() {
        return this.zzf.size();
    }

    public final void u() {
        this.zzc = s4.l();
    }

    public final void v() {
        this.zzd = s4.l();
    }

    public final void w() {
        z4<w0> z4Var = this.zze;
        if (z4Var.zza()) {
            return;
        }
        this.zze = s4.a(z4Var);
    }

    public final void x() {
        z4<e1> z4Var = this.zzf;
        if (z4Var.zza()) {
            return;
        }
        this.zzf = s4.a(z4Var);
    }

    public final List<Long> zza() {
        return this.zzc;
    }

    public final e1 c(int i2) {
        return this.zzf.get(i2);
    }

    public final void d(Iterable<? extends e1> iterable) {
        x();
        b3.a(iterable, this.zzf);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new d1();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", w0.class, "zzf", e1.class});
            case 4:
                return zzg;
            case 5:
                n6<d1> n6Var = zzh;
                if (n6Var == null) {
                    synchronized (d1.class) {
                        n6Var = zzh;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzg);
                            zzh = n6Var;
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

    public final w0 b(int i2) {
        return this.zze.get(i2);
    }
}
