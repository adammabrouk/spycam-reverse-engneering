package c.j.a.f;

/* compiled from: OnDispatcherReceiveCommand.java */
/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: e, reason: collision with root package name */
    public int f6510e;

    /* renamed from: f, reason: collision with root package name */
    public int f6511f;

    public k() {
        super(2016);
        this.f6510e = -1;
        this.f6511f = -1;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("key_dispatch_environment", this.f6510e);
        eVar.a("key_dispatch_area", this.f6511f);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6510e = eVar.b("key_dispatch_environment", 1);
        this.f6511f = eVar.b("key_dispatch_area", 1);
    }

    public final int f() {
        return this.f6510e;
    }

    public final int g() {
        return this.f6511f;
    }
}
