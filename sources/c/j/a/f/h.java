package c.j.a.f;

/* compiled from: OnAppReceiveCommand.java */
/* loaded from: classes.dex */
public final class h extends r {

    /* renamed from: e, reason: collision with root package name */
    public String f6505e;

    /* renamed from: f, reason: collision with root package name */
    public String f6506f;

    /* renamed from: g, reason: collision with root package name */
    public String f6507g;

    public h(int i2) {
        super(i2);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("app_id", this.f6505e);
        eVar.a("client_id", this.f6506f);
        eVar.a("client_token", this.f6507g);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6505e = eVar.a("app_id");
        this.f6506f = eVar.a("client_id");
        this.f6507g = eVar.a("client_token");
    }

    public final String f() {
        return this.f6505e;
    }

    public final String g() {
        return this.f6507g;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnBindCommand";
    }
}
