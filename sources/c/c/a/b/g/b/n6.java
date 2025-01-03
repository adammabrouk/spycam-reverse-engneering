package c.c.a.b.g.b;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4955a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f4956b;

    public n6(h6 h6Var, long j) {
        this.f4956b = h6Var;
        this.f4955a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h6 h6Var = this.f4956b;
        long j = this.f4955a;
        h6Var.g();
        h6Var.e();
        h6Var.w();
        h6Var.c().A().a("Resetting analytics data (FE)");
        w8 t = h6Var.t();
        t.g();
        t.f5168e.a();
        boolean g2 = h6Var.f5160a.g();
        j4 k = h6Var.k();
        k.j.a(j);
        if (!TextUtils.isEmpty(k.k().A.a())) {
            k.A.a(null);
        }
        if (c.c.a.b.f.e.ca.a() && k.l().a(r.x0)) {
            k.v.a(0L);
        }
        if (!k.l().p()) {
            k.c(!g2);
        }
        k.B.a(null);
        k.C.a(0L);
        k.D.a(null);
        h6Var.q().C();
        if (c.c.a.b.f.e.ca.a() && h6Var.l().a(r.x0)) {
            h6Var.t().f5167d.a();
        }
        h6Var.f4773i = !g2;
        this.f4956b.q().a(new AtomicReference<>());
    }
}
