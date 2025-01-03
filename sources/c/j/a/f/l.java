package c.j.a.f;

import java.util.ArrayList;

/* compiled from: OnListTagReceiveCommand.java */
/* loaded from: classes.dex */
public final class l extends r {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f6512e;

    public l() {
        super(8);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("tags_list", this.f6512e);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6512e = eVar.c("tags_list");
    }

    public final ArrayList<String> f() {
        return this.f6512e;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnListTagCommand";
    }
}
