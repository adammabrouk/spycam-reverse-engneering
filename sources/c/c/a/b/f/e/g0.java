package c.c.a.b.f.e;

import c.c.a.b.f.e.h0;
import c.c.a.b.f.e.k0;
import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class g0 extends s4<g0, a> implements f6 {
    public static final g0 zzi;
    public static volatile n6<g0> zzj;
    public int zzc;
    public int zzd;
    public z4<k0> zze = s4.m();
    public z4<h0> zzf = s4.m();
    public boolean zzg;
    public boolean zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<g0, a> implements f6 {
        public a() {
            super(g0.zzi);
        }

        public final k0 a(int i2) {
            return ((g0) this.f4417b).b(i2);
        }

        public final h0 b(int i2) {
            return ((g0) this.f4417b).c(i2);
        }

        public final int j() {
            return ((g0) this.f4417b).r();
        }

        public final int zza() {
            return ((g0) this.f4417b).p();
        }

        public /* synthetic */ a(m0 m0Var) {
            this();
        }

        public final a a(int i2, k0.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((g0) this.f4417b).a(i2, (k0) ((s4) aVar.F()));
            return this;
        }

        public final a a(int i2, h0.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((g0) this.f4417b).a(i2, (h0) ((s4) aVar.F()));
            return this;
        }
    }

    static {
        g0 g0Var = new g0();
        zzi = g0Var;
        s4.a((Class<g0>) g0.class, g0Var);
    }

    public final void a(int i2, k0 k0Var) {
        k0Var.getClass();
        z4<k0> z4Var = this.zze;
        if (!z4Var.zza()) {
            this.zze = s4.a(z4Var);
        }
        this.zze.set(i2, k0Var);
    }

    public final k0 b(int i2) {
        return this.zze.get(i2);
    }

    public final h0 c(int i2) {
        return this.zzf.get(i2);
    }

    public final int n() {
        return this.zzd;
    }

    public final List<k0> o() {
        return this.zze;
    }

    public final int p() {
        return this.zze.size();
    }

    public final List<h0> q() {
        return this.zzf;
    }

    public final int r() {
        return this.zzf.size();
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    public final void a(int i2, h0 h0Var) {
        h0Var.getClass();
        z4<h0> z4Var = this.zzf;
        if (!z4Var.zza()) {
            this.zzf = s4.a(z4Var);
        }
        this.zzf.set(i2, h0Var);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new g0();
            case 2:
                return new a(m0Var);
            case 3:
                return s4.a(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", k0.class, "zzf", h0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                n6<g0> n6Var = zzj;
                if (n6Var == null) {
                    synchronized (g0.class) {
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
