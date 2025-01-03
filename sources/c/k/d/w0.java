package c.k.d;

import android.content.Context;
import c.k.d.j;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class w0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7976a;

    public w0(u0 u0Var) {
        this.f7976a = u0Var;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        String c2;
        Context context;
        Context context2;
        c.k.a.a.a.c.c("exec== DbSizeControlJob");
        c2 = this.f7976a.c();
        context = this.f7976a.f7907a;
        z0 z0Var = new z0(c2, new WeakReference(context));
        context2 = this.f7976a.f7907a;
        h1.a(context2).a(z0Var);
        this.f7976a.b("check_time");
    }
}
