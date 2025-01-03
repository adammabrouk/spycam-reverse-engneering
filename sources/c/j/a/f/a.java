package c.j.a.f;

/* compiled from: AppCommand.java */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: h, reason: collision with root package name */
    public String f6496h;

    /* renamed from: i, reason: collision with root package name */
    public String f6497i;
    public String j;
    public String k;

    public a(boolean z, String str) {
        super(z ? 2006 : 2007, str);
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("sdk_clients", this.f6496h);
        eVar.a("sdk_version", 323L);
        eVar.a("BaseAppCommand.EXTRA_APPID", this.j);
        eVar.a("BaseAppCommand.EXTRA_APPKEY", this.f6497i);
        eVar.a("PUSH_REGID", this.k);
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6496h = eVar.a("sdk_clients");
        this.j = eVar.a("BaseAppCommand.EXTRA_APPID");
        this.f6497i = eVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.k = eVar.a("PUSH_REGID");
    }

    public final void g() {
        this.j = null;
    }

    public final void h() {
        this.f6497i = null;
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
