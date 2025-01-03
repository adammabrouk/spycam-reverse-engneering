package c.j.a.f;

import android.text.TextUtils;

/* compiled from: OnNotificationClickReceiveCommand.java */
/* loaded from: classes.dex */
public final class o extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public String f6517c;

    /* renamed from: d, reason: collision with root package name */
    public String f6518d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f6519e;

    /* renamed from: f, reason: collision with root package name */
    public long f6520f;

    /* renamed from: g, reason: collision with root package name */
    public c.j.a.t.a f6521g;

    public o(String str, long j, c.j.a.t.a aVar) {
        super(5);
        this.f6517c = str;
        this.f6520f = j;
        this.f6521g = aVar;
    }

    @Override // c.j.a.v
    public final void c(c.j.a.e eVar) {
        eVar.a("package_name", this.f6517c);
        eVar.a("notify_id", this.f6520f);
        eVar.a("notification_v1", c.j.a.z.w.b(this.f6521g));
        eVar.a("open_pkg_name", this.f6518d);
        eVar.a("open_pkg_name_encode", this.f6519e);
    }

    public final String d() {
        return this.f6517c;
    }

    public final long e() {
        return this.f6520f;
    }

    public final c.j.a.t.a f() {
        return this.f6521g;
    }

    @Override // c.j.a.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // c.j.a.v
    public final void d(c.j.a.e eVar) {
        this.f6517c = eVar.a("package_name");
        this.f6520f = eVar.b("notify_id", -1L);
        this.f6518d = eVar.a("open_pkg_name");
        this.f6519e = eVar.b("open_pkg_name_encode");
        String a2 = eVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f6521g = c.j.a.z.w.a(a2);
        }
        c.j.a.t.a aVar = this.f6521g;
        if (aVar != null) {
            aVar.a(this.f6520f);
        }
    }

    public o() {
        super(5);
    }
}
