package c.j.a.f;

/* compiled from: StopServiceCommand.java */
/* loaded from: classes.dex */
public final class x extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public String f6535c;

    public x(String str) {
        super(2008);
        this.f6535c = str;
    }

    @Override // c.j.a.v
    public final void c(c.j.a.e eVar) {
        eVar.a("package_name", this.f6535c);
    }

    @Override // c.j.a.v
    public final void d(c.j.a.e eVar) {
        this.f6535c = eVar.a("package_name");
    }

    @Override // c.j.a.v
    public final String toString() {
        return "StopServiceCommand";
    }
}
