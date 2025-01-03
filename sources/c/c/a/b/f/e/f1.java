package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class f1 extends s4<f1, a> implements f6 {
    public static final f1 zzj;
    public static volatile n6<f1> zzk;
    public int zzc;
    public long zzd;
    public String zze = "";
    public String zzf = "";
    public long zzg;
    public float zzh;
    public double zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<f1, a> implements f6 {
        public a() {
            super(f1.zzj);
        }

        public final a a(long j) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).a(j);
            return this;
        }

        public final a b(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).b(str);
            return this;
        }

        public final a j() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).w();
            return this;
        }

        public final a k() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).x();
            return this;
        }

        public final a zza() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).v();
            return this;
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).a(str);
            return this;
        }

        public final a b(long j) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).b(j);
            return this;
        }

        public final a a(double d2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((f1) this.f4417b).a(d2);
            return this;
        }
    }

    static {
        f1 f1Var = new f1();
        zzj = f1Var;
        s4.a((Class<f1>) f1.class, f1Var);
    }

    public static a y() {
        return zzj.i();
    }

    public final void a(long j) {
        this.zzc |= 1;
        this.zzd = j;
    }

    public final void b(String str) {
        str.getClass();
        this.zzc |= 4;
        this.zzf = str;
    }

    public final long n() {
        return this.zzd;
    }

    public final String o() {
        return this.zze;
    }

    public final boolean p() {
        return (this.zzc & 4) != 0;
    }

    public final String q() {
        return this.zzf;
    }

    public final boolean r() {
        return (this.zzc & 8) != 0;
    }

    public final long s() {
        return this.zzg;
    }

    public final boolean t() {
        return (this.zzc & 32) != 0;
    }

    public final double u() {
        return this.zzi;
    }

    public final void v() {
        this.zzc &= -5;
        this.zzf = zzj.zzf;
    }

    public final void w() {
        this.zzc &= -9;
        this.zzg = 0L;
    }

    public final void x() {
        this.zzc &= -33;
        this.zzi = 0.0d;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public final void b(long j) {
        this.zzc |= 8;
        this.zzg = j;
    }

    public final void a(double d2) {
        this.zzc |= 32;
        this.zzi = d2;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new f1();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                n6<f1> n6Var = zzk;
                if (n6Var == null) {
                    synchronized (f1.class) {
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
