package c.j.a.k;

/* compiled from: OnDispatcherReceiveTask.java */
/* loaded from: classes.dex */
public final class t extends i0 {
    public t(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.k kVar = (c.j.a.f.k) vVar;
        int f2 = kVar.f();
        int g2 = kVar.g();
        c.j.a.z.c0.b().a("key_dispatch_environment", f2);
        c.j.a.z.c0.b().a("key_dispatch_area", g2);
    }
}
