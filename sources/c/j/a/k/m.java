package c.j.a.k;

import android.text.TextUtils;

/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: classes.dex */
public final class m extends i0 {
    public m(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.h hVar = (c.j.a.f.h) vVar;
        String g2 = hVar.g();
        c.j.a.m.m().a(hVar.d(), hVar.e(), g2);
        if (TextUtils.isEmpty(hVar.d()) && !TextUtils.isEmpty(g2)) {
            c.j.a.m.m().a(g2);
        }
        c.j.a.s.b(new n(this, g2, hVar));
    }
}
