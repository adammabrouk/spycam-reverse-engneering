package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import c.c.a.b.f.e.z0;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class x0 extends s4<x0, a> implements f6 {
    public static final x0 zzi;
    public static volatile n6<x0> zzj;
    public int zzc;
    public z4<z0> zzd = s4.m();
    public String zze = "";
    public long zzf;
    public long zzg;
    public int zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<x0, a> implements f6 {
        public a() {
            super(x0.zzi);
        }

        public final z0 a(int i2) {
            return ((x0) this.f4417b).b(i2);
        }

        public final a b(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).c(i2);
            return this;
        }

        public final int j() {
            return ((x0) this.f4417b).n();
        }

        public final a k() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).w();
            return this;
        }

        public final String l() {
            return ((x0) this.f4417b).o();
        }

        public final long m() {
            return ((x0) this.f4417b).q();
        }

        public final long n() {
            return ((x0) this.f4417b).s();
        }

        public final List<z0> zza() {
            return Collections.unmodifiableList(((x0) this.f4417b).zza());
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(int i2, z0 z0Var) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(i2, z0Var);
            return this;
        }

        public final a b(long j) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).b(j);
            return this;
        }

        public final a a(int i2, z0.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(i2, (z0) ((s4) aVar.F()));
            return this;
        }

        public final a a(z0 z0Var) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(z0Var);
            return this;
        }

        public final a a(z0.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a((z0) ((s4) aVar.F()));
            return this;
        }

        public final a a(Iterable<? extends z0> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(iterable);
            return this;
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(str);
            return this;
        }

        public final a a(long j) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((x0) this.f4417b).a(j);
            return this;
        }
    }

    static {
        x0 x0Var = new x0();
        zzi = x0Var;
        s4.a((Class<x0>) x0.class, x0Var);
    }

    public static a x() {
        return zzi.i();
    }

    public final void a(int i2, z0 z0Var) {
        z0Var.getClass();
        v();
        this.zzd.set(i2, z0Var);
    }

    public final z0 b(int i2) {
        return this.zzd.get(i2);
    }

    public final void c(int i2) {
        v();
        this.zzd.remove(i2);
    }

    public final int n() {
        return this.zzd.size();
    }

    public final String o() {
        return this.zze;
    }

    public final boolean p() {
        return (this.zzc & 2) != 0;
    }

    public final long q() {
        return this.zzf;
    }

    public final boolean r() {
        return (this.zzc & 4) != 0;
    }

    public final long s() {
        return this.zzg;
    }

    public final boolean t() {
        return (this.zzc & 8) != 0;
    }

    public final int u() {
        return this.zzh;
    }

    public final void v() {
        z4<z0> z4Var = this.zzd;
        if (z4Var.zza()) {
            return;
        }
        this.zzd = s4.a(z4Var);
    }

    public final void w() {
        this.zzd = s4.m();
    }

    public final List<z0> zza() {
        return this.zzd;
    }

    public final void b(long j) {
        this.zzc |= 4;
        this.zzg = j;
    }

    public final void a(z0 z0Var) {
        z0Var.getClass();
        v();
        this.zzd.add(z0Var);
    }

    public final void a(Iterable<? extends z0> iterable) {
        v();
        b3.a(iterable, this.zzd);
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zze = str;
    }

    public final void a(long j) {
        this.zzc |= 2;
        this.zzf = j;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new x0();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", z0.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                n6<x0> n6Var = zzj;
                if (n6Var == null) {
                    synchronized (x0.class) {
                        n6Var = zzj;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzi);
                            zzj = n6Var;
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
