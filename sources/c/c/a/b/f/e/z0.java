package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class z0 extends s4<z0, a> implements f6 {
    public static final z0 zzj;
    public static volatile n6<z0> zzk;
    public int zzc;
    public long zzf;
    public float zzg;
    public double zzh;
    public String zzd = "";
    public String zze = "";
    public z4<z0> zzi = s4.m();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<z0, a> implements f6 {
        public a() {
            super(z0.zzj);
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).a(str);
            return this;
        }

        public final a b(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).b(str);
            return this;
        }

        public final a j() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).x();
            return this;
        }

        public final a k() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).y();
            return this;
        }

        public final int l() {
            return ((z0) this.f4417b).v();
        }

        public final a m() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).A();
            return this;
        }

        public final a zza() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).w();
            return this;
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(long j) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).a(j);
            return this;
        }

        public final a a(double d2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).a(d2);
            return this;
        }

        public final a a(a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).a((z0) ((s4) aVar.F()));
            return this;
        }

        public final a a(Iterable<? extends z0> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((z0) this.f4417b).a(iterable);
            return this;
        }
    }

    static {
        z0 z0Var = new z0();
        zzj = z0Var;
        s4.a((Class<z0>) z0.class, z0Var);
    }

    public static a B() {
        return zzj.i();
    }

    public final void A() {
        this.zzi = s4.m();
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final void b(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public final String n() {
        return this.zzd;
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

    public final long r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzc & 16) != 0;
    }

    public final double t() {
        return this.zzh;
    }

    public final List<z0> u() {
        return this.zzi;
    }

    public final int v() {
        return this.zzi.size();
    }

    public final void w() {
        this.zzc &= -3;
        this.zze = zzj.zze;
    }

    public final void x() {
        this.zzc &= -5;
        this.zzf = 0L;
    }

    public final void y() {
        this.zzc &= -17;
        this.zzh = 0.0d;
    }

    public final void z() {
        z4<z0> z4Var = this.zzi;
        if (z4Var.zza()) {
            return;
        }
        this.zzi = s4.a(z4Var);
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    public final void a(long j) {
        this.zzc |= 4;
        this.zzf = j;
    }

    public final void a(double d2) {
        this.zzc |= 16;
        this.zzh = d2;
    }

    public final void a(z0 z0Var) {
        z0Var.getClass();
        z();
        this.zzi.add(z0Var);
    }

    public final void a(Iterable<? extends z0> iterable) {
        z();
        b3.a(iterable, this.zzi);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new z0();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", z0.class});
            case 4:
                return zzj;
            case 5:
                n6<z0> n6Var = zzk;
                if (n6Var == null) {
                    synchronized (z0.class) {
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
