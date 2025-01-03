package c.j.a.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* loaded from: classes.dex */
public final class s extends r {

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f6526e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f6527f;

    public s(int i2) {
        super(i2);
        this.f6526e = null;
        this.f6527f = null;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void c(c.j.a.e eVar) {
        super.c(eVar);
        eVar.a("content", this.f6526e);
        eVar.a("error_msg", this.f6527f);
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final void d(c.j.a.e eVar) {
        super.d(eVar);
        this.f6526e = eVar.c("content");
        this.f6527f = eVar.c("error_msg");
    }

    public final ArrayList<String> f() {
        return this.f6526e;
    }

    public final List<String> g() {
        return this.f6527f;
    }

    @Override // c.j.a.f.r, c.j.a.v
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
