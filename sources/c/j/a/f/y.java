package c.j.a.f;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* loaded from: classes.dex */
public final class y extends b {

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<String> f6536h;

    public y(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.f6536h = arrayList;
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("tags", (Serializable) this.f6536h);
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6536h = eVar.c("tags");
    }

    @Override // c.j.a.f.b, c.j.a.v
    public final String toString() {
        return "TagCommand";
    }
}
