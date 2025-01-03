package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class e1 extends s4<e1, a> implements f6 {
    public static final e1 zzf;
    public static volatile n6<e1> zzg;
    public int zzc;
    public int zzd;
    public a5 zze = s4.l();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<e1, a> implements f6 {
        public a() {
            super(e1.zzf);
        }

        public final a a(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((e1) this.f4417b).c(i2);
            return this;
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(Iterable<? extends Long> iterable) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((e1) this.f4417b).a(iterable);
            return this;
        }
    }

    static {
        e1 e1Var = new e1();
        zzf = e1Var;
        s4.a((Class<e1>) e1.class, e1Var);
    }

    public static a q() {
        return zzf.i();
    }

    public final void a(Iterable<? extends Long> iterable) {
        a5 a5Var = this.zze;
        if (!a5Var.zza()) {
            this.zze = s4.a(a5Var);
        }
        b3.a(iterable, this.zze);
    }

    public final long b(int i2) {
        return this.zze.zzb(i2);
    }

    public final void c(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    public final int n() {
        return this.zzd;
    }

    public final List<Long> o() {
        return this.zze;
    }

    public final int p() {
        return this.zze.size();
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new e1();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                n6<e1> n6Var = zzg;
                if (n6Var == null) {
                    synchronized (e1.class) {
                        n6Var = zzg;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzf);
                            zzg = n6Var;
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
