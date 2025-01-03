package c.j.a.f;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* loaded from: classes.dex */
public final class i extends r {

    /* renamed from: e, reason: collision with root package name */
    public int f6508e;

    /* renamed from: f, reason: collision with root package name */
    public int f6509f;

    public i() {
        super(12);
        this.f6508e = -1;
        this.f6509f = -1;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f6508e);
        eVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f6509f);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6508e = eVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f6508e);
        this.f6509f = eVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f6509f);
    }

    public final int f() {
        return this.f6508e;
    }

    public final int g() {
        return this.f6509f;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
