package c.c.a.b.g.b;

import com.shix.shixipc.utilcode.LogUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class ga extends da {

    /* renamed from: g, reason: collision with root package name */
    public c.c.a.b.f.e.k0 f4753g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ aa f4754h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(aa aaVar, String str, int i2, c.c.a.b.f.e.k0 k0Var) {
        super(str, i2);
        this.f4754h = aaVar;
        this.f4753g = k0Var;
    }

    @Override // c.c.a.b.g.b.da
    public final int a() {
        return this.f4753g.n();
    }

    @Override // c.c.a.b.g.b.da
    public final boolean b() {
        return true;
    }

    @Override // c.c.a.b.g.b.da
    public final boolean c() {
        return false;
    }

    public final boolean a(Long l, Long l2, c.c.a.b.f.e.f1 f1Var, boolean z) {
        boolean z2 = c.c.a.b.f.e.p9.a() && this.f4754h.l().d(this.f4681a, r.f0);
        boolean q = this.f4753g.q();
        boolean r = this.f4753g.r();
        boolean t = this.f4753g.t();
        boolean z3 = q || r || t;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && !z3) {
            this.f4754h.c().B().a("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f4682b), this.f4753g.zza() ? Integer.valueOf(this.f4753g.n()) : null);
            return true;
        }
        c.c.a.b.f.e.i0 p = this.f4753g.p();
        boolean r2 = p.r();
        if (f1Var.r()) {
            if (p.o()) {
                bool = da.a(da.a(f1Var.s(), p.p()), r2);
            } else {
                this.f4754h.c().w().a("No number filter for long property. property", this.f4754h.i().c(f1Var.o()));
            }
        } else if (f1Var.t()) {
            if (p.o()) {
                bool = da.a(da.a(f1Var.u(), p.p()), r2);
            } else {
                this.f4754h.c().w().a("No number filter for double property. property", this.f4754h.i().c(f1Var.o()));
            }
        } else if (!f1Var.p()) {
            this.f4754h.c().w().a("User property has no value, property", this.f4754h.i().c(f1Var.o()));
        } else if (p.zza()) {
            bool = da.a(da.a(f1Var.q(), p.n(), this.f4754h.c()), r2);
        } else if (!p.o()) {
            this.f4754h.c().w().a("No string or number filter defined. property", this.f4754h.i().c(f1Var.o()));
        } else if (p9.a(f1Var.q())) {
            bool = da.a(da.a(f1Var.q(), p.p()), r2);
        } else {
            this.f4754h.c().w().a("Invalid user property value for Numeric number filter. property, value", this.f4754h.i().c(f1Var.o()), f1Var.q());
        }
        this.f4754h.c().B().a("Property filter result", bool == null ? LogUtils.NULL : bool);
        if (bool == null) {
            return false;
        }
        this.f4683c = true;
        if (t && !bool.booleanValue()) {
            return true;
        }
        if (!z || this.f4753g.q()) {
            this.f4684d = bool;
        }
        if (bool.booleanValue() && z3 && f1Var.zza()) {
            long n = f1Var.n();
            if (l != null) {
                n = l.longValue();
            }
            if (z2 && this.f4753g.q() && !this.f4753g.r() && l2 != null) {
                n = l2.longValue();
            }
            if (this.f4753g.r()) {
                this.f4686f = Long.valueOf(n);
            } else {
                this.f4685e = Long.valueOf(n);
            }
        }
        return true;
    }
}
