package c.j.a.k;

/* compiled from: ChangeNetPermissionTask.java */
/* loaded from: classes.dex */
public final class k extends c.j.a.r {
    public k(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.t.e a2 = c.j.a.z.z.a(this.f6635a);
        try {
            if (((c.j.a.f.c) vVar).d() ? o.a(this.f6635a) : o.b(this.f6635a)) {
                c.j.a.t.e a3 = c.j.a.z.z.a(this.f6635a);
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        c.j.a.d.a.a(this.f6635a, a2.a(), new c.j.a.f.x(a2.a()));
                    }
                    if (a3 == null || a3.a() == null) {
                        return;
                    }
                    c.j.a.d.a.a(this.f6635a, a3.a(), new c.j.a.f.e());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
