package c.j.a.f;

/* compiled from: OnVerifyReceiveCommand.java */
/* loaded from: classes.dex */
public abstract class u extends r {

    /* renamed from: e, reason: collision with root package name */
    public String f6530e;

    /* renamed from: f, reason: collision with root package name */
    public long f6531f;

    public u(int i2) {
        super(i2);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f6530e);
        eVar.a("notify_id", this.f6531f);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6530e = eVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f6531f = eVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f6531f;
    }

    public final String g() {
        return this.f6530e;
    }
}
