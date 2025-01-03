package c.j.a.f;

/* compiled from: OnUndoMsgReceiveCommand.java */
/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: g, reason: collision with root package name */
    public long f6528g;

    /* renamed from: h, reason: collision with root package name */
    public int f6529h;

    public t() {
        super(20);
        this.f6528g = -1L;
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("undo_msg_v1", this.f6528g);
        eVar.a("undo_msg_type_v1", this.f6529h);
    }

    @Override // c.j.a.f.u, c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6528g = eVar.b("undo_msg_v1", this.f6528g);
        this.f6529h = eVar.b("undo_msg_type_v1", 0);
    }

    public final long h() {
        return this.f6528g;
    }

    public final String i() {
        long j = this.f6528g;
        if (j != -1) {
            return String.valueOf(j);
        }
        return null;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }
}
