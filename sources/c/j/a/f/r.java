package c.j.a.f;

/* compiled from: OnReceiveCommand.java */
/* loaded from: classes.dex */
public class r extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public String f6524c;

    /* renamed from: d, reason: collision with root package name */
    public int f6525d;

    public r(int i2) {
        super(i2);
        this.f6524c = null;
        this.f6525d = 0;
    }

    @Override // c.j.a.v
    public void c(c.j.a.e eVar) {
        eVar.a("req_id", this.f6524c);
        eVar.a("status_msg_code", this.f6525d);
    }

    public final String d() {
        return this.f6524c;
    }

    public final int e() {
        return this.f6525d;
    }

    @Override // c.j.a.v
    public String toString() {
        return "OnReceiveCommand";
    }

    @Override // c.j.a.v
    public void d(c.j.a.e eVar) {
        this.f6524c = eVar.a("req_id");
        this.f6525d = eVar.b("status_msg_code", this.f6525d);
    }
}
