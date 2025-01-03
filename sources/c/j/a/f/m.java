package c.j.a.f;

/* compiled from: OnLogReceiveCommand.java */
/* loaded from: classes.dex */
public final class m extends r {

    /* renamed from: e, reason: collision with root package name */
    public String f6513e;

    /* renamed from: f, reason: collision with root package name */
    public int f6514f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6515g;

    public m() {
        super(7);
        this.f6514f = 0;
        this.f6515g = false;
    }

    public final void a(int i2) {
        this.f6514f = i2;
    }

    public final void b(String str) {
        this.f6513e = str;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("content", this.f6513e);
        eVar.a("log_level", this.f6514f);
        eVar.a("is_server_log", this.f6515g);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6513e = eVar.a("content");
        this.f6514f = eVar.b("log_level", 0);
        this.f6515g = eVar.e("is_server_log");
    }

    public final String f() {
        return this.f6513e;
    }

    public final int g() {
        return this.f6514f;
    }

    public final boolean h() {
        return this.f6515g;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f6515g = z;
    }
}
