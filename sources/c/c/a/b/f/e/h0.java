package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class h0 extends s4<h0, a> implements f6 {
    public static final h0 zzl;
    public static volatile n6<h0> zzm;
    public int zzc;
    public int zzd;
    public String zze = "";
    public z4<i0> zzf = s4.m();
    public boolean zzg;
    public j0 zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<h0, a> implements f6 {
        public a() {
            super(h0.zzl);
        }

        public final a a(String str) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((h0) this.f4417b).a(str);
            return this;
        }

        public final int j() {
            return ((h0) this.f4417b).q();
        }

        public final String zza() {
            return ((h0) this.f4417b).o();
        }

        public /* synthetic */ a(m0 m0Var) {
            this();
        }

        public final i0 a(int i2) {
            return ((h0) this.f4417b).b(i2);
        }

        public final a a(int i2, i0 i0Var) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((h0) this.f4417b).a(i2, i0Var);
            return this;
        }
    }

    static {
        h0 h0Var = new h0();
        zzl = h0Var;
        s4.a((Class<h0>) h0.class, h0Var);
    }

    public static a x() {
        return zzl.i();
    }

    public final void a(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public final i0 b(int i2) {
        return this.zzf.get(i2);
    }

    public final int n() {
        return this.zzd;
    }

    public final String o() {
        return this.zze;
    }

    public final List<i0> p() {
        return this.zzf;
    }

    public final int q() {
        return this.zzf.size();
    }

    public final boolean r() {
        return (this.zzc & 8) != 0;
    }

    public final j0 s() {
        j0 j0Var = this.zzh;
        return j0Var == null ? j0.w() : j0Var;
    }

    public final boolean t() {
        return this.zzi;
    }

    public final boolean u() {
        return this.zzj;
    }

    public final boolean v() {
        return (this.zzc & 64) != 0;
    }

    public final boolean w() {
        return this.zzk;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    public final void a(int i2, i0 i0Var) {
        i0Var.getClass();
        z4<i0> z4Var = this.zzf;
        if (!z4Var.zza()) {
            this.zzf = s4.a(z4Var);
        }
        this.zzf.set(i2, i0Var);
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        m0 m0Var = null;
        switch (m0.f4289a[i2 - 1]) {
            case 1:
                return new h0();
            case 2:
                return new a(m0Var);
            case 3:
                return s4.a(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", i0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                n6<h0> n6Var = zzm;
                if (n6Var == null) {
                    synchronized (h0.class) {
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
