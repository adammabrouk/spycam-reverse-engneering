package c.j.a.f;

import android.text.TextUtils;

/* compiled from: OnMessageReceiveCommand.java */
/* loaded from: classes.dex */
public final class n extends u {

    /* renamed from: g, reason: collision with root package name */
    public c.j.a.t.c f6516g;

    public n() {
        super(3);
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("msg_v1", this.f6516g.c());
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        String a2 = eVar.a("msg_v1");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        c.j.a.t.c cVar = new c.j.a.t.c(a2);
        this.f6516g = cVar;
        cVar.a(f());
    }

    public final String h() {
        c.j.a.t.c cVar = this.f6516g;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }

    public final c.j.a.t.c i() {
        return this.f6516g;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnMessageCommand";
    }
}
