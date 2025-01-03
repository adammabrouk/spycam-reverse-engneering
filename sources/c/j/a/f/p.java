package c.j.a.f;

import android.text.TextUtils;

/* compiled from: OnNotifyArrivedReceiveCommand.java */
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: g, reason: collision with root package name */
    public c.j.a.t.a f6522g;

    /* renamed from: h, reason: collision with root package name */
    public String f6523h;

    public p() {
        super(4);
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        String b2 = c.j.a.z.w.b(this.f6522g);
        this.f6523h = b2;
        eVar.a("notification_v1", b2);
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        String a2 = eVar.a("notification_v1");
        this.f6523h = a2;
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        c.j.a.t.a a3 = c.j.a.z.w.a(this.f6523h);
        this.f6522g = a3;
        if (a3 != null) {
            a3.a(f());
        }
    }

    public final c.j.a.t.a h() {
        return this.f6522g;
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.f6523h)) {
            return this.f6523h;
        }
        c.j.a.t.a aVar = this.f6522g;
        if (aVar == null) {
            return null;
        }
        return c.j.a.z.w.b(aVar);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
