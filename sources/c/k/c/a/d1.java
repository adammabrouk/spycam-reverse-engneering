package c.k.c.a;

import android.content.Context;
import c.k.d.j;
import c.k.d.j7;
import c.k.d.v6;
import c.k.d.v7;

/* loaded from: classes.dex */
public final class d1 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v7 f6813a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6814b;

    public d1(v7 v7Var, Context context) {
        this.f6813a = v7Var;
        this.f6814b = context;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        v7 v7Var = this.f6813a;
        if (v7Var != null) {
            v7Var.a(c.k.d.p9.p.a());
            i0.a(this.f6814b.getApplicationContext()).a((i0) this.f6813a, v6.Notification, true, (j7) null, true);
        }
    }
}
