package c.j.a.f;

/* compiled from: PushModeCommand.java */
/* loaded from: classes.dex */
public final class v extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public int f6532c;

    public v() {
        super(2011);
        this.f6532c = 0;
    }

    @Override // c.j.a.v
    public final void c(c.j.a.e eVar) {
        eVar.a("com.bbk.push.ikey.MODE_TYPE", this.f6532c);
    }

    @Override // c.j.a.v
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f6532c;
    }

    @Override // c.j.a.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // c.j.a.v
    public final void d(c.j.a.e eVar) {
        this.f6532c = eVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
