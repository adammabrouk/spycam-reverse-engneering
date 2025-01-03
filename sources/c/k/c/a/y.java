package c.k.c.a;

import android.content.Context;
import c.k.d.b7;
import c.k.d.g7;
import c.k.d.h8;
import c.k.d.j;
import c.k.d.j7;
import c.k.d.o7;
import c.k.d.v6;
import c.k.d.v7;

/* loaded from: classes.dex */
public class y extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f6936a;

    public y(Context context) {
        this.f6936a = context;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        c.k.d.p9.m a2 = c.k.d.p9.m.a(this.f6936a);
        o7 o7Var = new o7();
        o7Var.a(c.k.d.p9.n.a(a2, b7.MISC_CONFIG));
        o7Var.b(c.k.d.p9.n.a(a2, b7.PLUGIN_CONFIG));
        v7 v7Var = new v7("-1", false);
        v7Var.c(g7.DailyCheckClientConfig.f30a);
        v7Var.a(h8.a(o7Var));
        i0.a(this.f6936a).a((i0) v7Var, v6.Notification, (j7) null);
    }
}
