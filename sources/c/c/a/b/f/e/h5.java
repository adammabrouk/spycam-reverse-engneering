package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class h5 {

    /* renamed from: a, reason: collision with root package name */
    public volatile d6 f4203a;

    /* renamed from: b, reason: collision with root package name */
    public volatile k3 f4204b;

    static {
        e4.a();
    }

    public final d6 a(d6 d6Var) {
        d6 d6Var2 = this.f4203a;
        this.f4204b = null;
        this.f4203a = d6Var;
        return d6Var2;
    }

    public final d6 b(d6 d6Var) {
        if (this.f4203a == null) {
            synchronized (this) {
                if (this.f4203a == null) {
                    try {
                        this.f4203a = d6Var;
                        this.f4204b = k3.zza;
                    } catch (c5 unused) {
                        this.f4203a = d6Var;
                        this.f4204b = k3.zza;
                    }
                }
            }
        }
        return this.f4203a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h5)) {
            return false;
        }
        h5 h5Var = (h5) obj;
        d6 d6Var = this.f4203a;
        d6 d6Var2 = h5Var.f4203a;
        return (d6Var == null && d6Var2 == null) ? b().equals(h5Var.b()) : (d6Var == null || d6Var2 == null) ? d6Var != null ? d6Var.equals(h5Var.b(d6Var.c())) : b(d6Var2.c()).equals(d6Var2) : d6Var.equals(d6Var2);
    }

    public int hashCode() {
        return 1;
    }

    public final int a() {
        if (this.f4204b != null) {
            return this.f4204b.zza();
        }
        if (this.f4203a != null) {
            return this.f4203a.e();
        }
        return 0;
    }

    public final k3 b() {
        if (this.f4204b != null) {
            return this.f4204b;
        }
        synchronized (this) {
            if (this.f4204b != null) {
                return this.f4204b;
            }
            if (this.f4203a == null) {
                this.f4204b = k3.zza;
            } else {
                this.f4204b = this.f4203a.d();
            }
            return this.f4204b;
        }
    }
}
