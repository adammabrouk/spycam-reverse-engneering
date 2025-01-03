package c.c.a.b.g.b;

import android.os.Handler;
import android.os.Looper;
import c.c.a.b.f.e.kb;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class w8 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public Handler f5166c;

    /* renamed from: d, reason: collision with root package name */
    public final f9 f5167d;

    /* renamed from: e, reason: collision with root package name */
    public final c9 f5168e;

    /* renamed from: f, reason: collision with root package name */
    public final x8 f5169f;

    public w8(a5 a5Var) {
        super(a5Var);
        this.f5167d = new f9(this);
        this.f5168e = new c9(this);
        this.f5169f = new x8(this);
    }

    public final void A() {
        g();
        if (this.f5166c == null) {
            this.f5166c = new kb(Looper.getMainLooper());
        }
    }

    public final void a(long j) {
        g();
        A();
        c().B().a("Activity resumed, time", Long.valueOf(j));
        if (l().a(r.E0)) {
            if (l().r().booleanValue() || k().x.a()) {
                this.f5168e.a(j);
            }
            this.f5169f.a();
        } else {
            this.f5169f.a();
            if (l().r().booleanValue()) {
                this.f5168e.a(j);
            }
        }
        f9 f9Var = this.f5167d;
        f9Var.f4734a.g();
        if (f9Var.f4734a.f5160a.g()) {
            if (!f9Var.f4734a.l().a(r.E0)) {
                f9Var.f4734a.k().x.a(false);
            }
            f9Var.a(f9Var.f4734a.b().a(), false);
        }
    }

    public final void b(long j) {
        g();
        A();
        c().B().a("Activity paused, time", Long.valueOf(j));
        this.f5169f.a(j);
        if (l().r().booleanValue()) {
            this.f5168e.b(j);
        }
        f9 f9Var = this.f5167d;
        if (f9Var.f4734a.l().a(r.E0)) {
            return;
        }
        f9Var.f4734a.k().x.a(true);
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return false;
    }

    public final boolean a(boolean z, boolean z2, long j) {
        return this.f5168e.a(z, z2, j);
    }
}
