package c.c.a.b.f.e;

import c.c.a.b.f.e.b1;
import c.c.a.b.f.e.s4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class a1 extends s4<a1, a> implements f6 {
    public static final a1 zzd;
    public static volatile n6<a1> zze;
    public z4<b1> zzc = s4.m();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    public static final class a extends s4.b<a1, a> implements f6 {
        public a() {
            super(a1.zzd);
        }

        public final b1 a(int i2) {
            return ((a1) this.f4417b).b(0);
        }

        public /* synthetic */ a(g1 g1Var) {
            this();
        }

        public final a a(b1.a aVar) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            ((a1) this.f4417b).a((b1) ((s4) aVar.F()));
            return this;
        }
    }

    static {
        a1 a1Var = new a1();
        zzd = a1Var;
        s4.a((Class<a1>) a1.class, a1Var);
    }

    public static a n() {
        return zzd.i();
    }

    public final void a(b1 b1Var) {
        b1Var.getClass();
        z4<b1> z4Var = this.zzc;
        if (!z4Var.zza()) {
            this.zzc = s4.a(z4Var);
        }
        this.zzc.add(b1Var);
    }

    public final b1 b(int i2) {
        return this.zzc.get(0);
    }

    public final List<b1> zza() {
        return this.zzc;
    }

    @Override // c.c.a.b.f.e.s4
    public final Object a(int i2, Object obj, Object obj2) {
        g1 g1Var = null;
        switch (g1.f4183a[i2 - 1]) {
            case 1:
                return new a1();
            case 2:
                return new a(g1Var);
            case 3:
                return s4.a(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", b1.class});
            case 4:
                return zzd;
            case 5:
                n6<a1> n6Var = zze;
                if (n6Var == null) {
                    synchronized (a1.class) {
                        n6Var = zze;
                        if (n6Var == null) {
                            n6Var = new s4.a<>(zzd);
                            zze = n6Var;
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
