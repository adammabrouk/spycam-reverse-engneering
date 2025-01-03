package c.k.d;

import android.content.Context;
import c.k.d.j;

/* loaded from: classes.dex */
public class x0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7997a;

    public x0(u0 u0Var) {
        this.f7997a = u0Var;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        l1 l1Var;
        l1 l1Var2;
        Context context;
        l1Var = this.f7997a.f7911e;
        if (l1Var != null) {
            l1Var2 = this.f7997a.f7911e;
            context = this.f7997a.f7907a;
            l1Var2.b(context);
            this.f7997a.b("delete_time");
        }
    }
}
