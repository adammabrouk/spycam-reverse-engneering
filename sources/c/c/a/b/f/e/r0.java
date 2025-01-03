package c.c.a.b.f.e;

import c.c.a.b.f.e.q0;
import c.c.a.b.f.e.s4;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class r0 extends s4<r0, a> implements f6 {
    public static final r0 zzl;
    public static volatile n6<r0> zzm;
    public int zzc;
    public long zzd;
    public int zzf;
    public boolean zzk;
    public String zze = "";
    public z4<s0> zzg = s4.m();
    public z4<q0> zzh = s4.m();
    public z4<g0> zzi = s4.m();
    public String zzj = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<r0, a> implements f6 {
        public a() {
            super(r0.zzl);
        }

        public final q0 a(int i2) {
            return ((r0) this.f4417b).b(i2);
        }

        public final List<g0> j() {
            return Collections.unmodifiableList(((r0) this.f4417b).s());
        }

        public final a k() {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((r0) this.f4417b).u();
            return this;
        }

        public final int zza() {
            return ((r0) this.f4417b).r();
        }

        public /* synthetic */ a(u0 u0Var) {
            this();
        }

        public final a a(int i2, q0.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((r0) this.f4417b).a(i2, (q0) ((s4) aVar.F()));
            return this;
        }
    }

    static {
        r0 r0Var = new r0();
        zzl = r0Var;
        s4.a((Class<r0>) r0.class, r0Var);
    }

    public static a v() {
        return zzl.i();
    }

    public static r0 w() {
        return zzl;
    }

    public final void a(int i2, q0 q0Var) {
        q0Var.getClass();
        z4<q0> z4Var = this.zzh;
        if (!z4Var.zza()) {
            this.zzh = s4.a(z4Var);
        }
        this.zzh.set(i2, q0Var);
    }

    public final q0 b(int i2) {
        return this.zzh.get(i2);
    }

    public final long n() {
        return this.zzd;
    }

    public final boolean o() {
        return (this.zzc & 2) != 0;
    }

    public final String p() {
        return this.zze;
    }

    public final List<s0> q() {
        return this.zzg;
    }

    public final int r() {
        return this.zzh.size();
    }

    public final List<g0> s() {
        return this.zzi;
    }

    public final boolean t() {
        return this.zzk;
    }

    public final void u() {
        this.zzi = s4.m();
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        u0 u0Var = null;
        switch (u0.f4452a[i2 - 1]) {
            case 1:
                return new r0();
            case 2:
                return new a(u0Var);
            case 3:
                return s4.a(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", s0.class, "zzh", q0.class, "zzi", g0.class, "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                n6<r0> n6Var = zzm;
                if (n6Var == null) {
                    synchronized (r0.class) {
                        n6Var = zzm;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzl);
                            zzm = n6Var;
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
