package c.j.a.k;

import com.tencent.bugly.CrashModule;

/* compiled from: BindAppSendCommandTask.java */
/* loaded from: classes.dex */
public final class a extends c.j.a.r {
    public a(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.b bVar = (c.j.a.f.b) vVar;
        c.j.a.t.e a2 = c.j.a.z.z.a(this.f6635a);
        if (a2 == null) {
            c.j.a.m.m().a(bVar.f(), 1005, new Object[0]);
            return;
        }
        String a3 = a2.a();
        if (a2.c()) {
            c.j.a.m.m().a(bVar.f(), CrashModule.MODULE_ID, new Object[0]);
            vVar = new c.j.a.f.d();
        } else {
            int a4 = c.j.a.z.y.a(bVar);
            if (a4 != 0) {
                c.j.a.m.m().a(bVar.f(), a4, new Object[0]);
                return;
            }
        }
        c.j.a.d.a.a(this.f6635a, a3, vVar);
    }
}
