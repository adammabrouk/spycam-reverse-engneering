package c.j.a.f;

/* compiled from: MsgArriveCommand.java */
/* loaded from: classes.dex */
public final class g extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public String f6504c;

    public g() {
        super(2013);
    }

    @Override // c.j.a.v
    public final void c(c.j.a.e eVar) {
        eVar.a("MsgArriveCommand.MSG_TAG", this.f6504c);
    }

    @Override // c.j.a.v
    public final void d(c.j.a.e eVar) {
        this.f6504c = eVar.a("MsgArriveCommand.MSG_TAG");
    }

    public g(String str) {
        this();
        this.f6504c = str;
    }
}
