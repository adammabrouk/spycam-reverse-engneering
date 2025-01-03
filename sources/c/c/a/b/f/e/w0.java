package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class w0 extends s4<w0, a> implements f6 {
    public static final w0 zzf;
    public static volatile n6<w0> zzg;
    public int zzc;
    public int zzd;
    public long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<w0, a> implements f6 {
        public a() {
            super(w0.zzf);
        }

        public final a a(int i2) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((w0) this.f4417b).b(i2);
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
            ((w0) this.f4417b).a(j);
            return this;
        }
    }

    static {
        w0 w0Var = new w0();
        zzf = w0Var;
        s4.a((Class<w0>) w0.class, w0Var);
    }

    public static a q() {
        return zzf.i();
    }

    public final void a(long j) {
        this.zzc |= 2;
        this.zze = j;
    }

    public final void b(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    public final int n() {
        return this.zzd;
    }

    public final boolean o() {
        return (this.zzc & 2) != 0;
    }

    public final long p() {
        return this.zze;
    }

    public final boolean zza() {
        return (this.zzc & 1) != 0;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new w0();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                n6<w0> n6Var = zzg;
                if (n6Var == null) {
                    synchronized (w0.class) {
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
