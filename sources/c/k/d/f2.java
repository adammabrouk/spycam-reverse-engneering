package c.k.d;

import c.k.d.d2;
import c.k.d.m;

/* loaded from: classes.dex */
public class f2 extends m.b {

    /* renamed from: a, reason: collision with root package name */
    public m.b f7116a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d2 f7117b;

    public f2(d2 d2Var) {
        this.f7117b = d2Var;
    }

    @Override // c.k.d.m.b
    public void b() {
        d2.b bVar = (d2.b) this.f7117b.f7054a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f7117b.f7054a.remove(bVar)) {
            this.f7116a = bVar;
        }
        m.b bVar2 = this.f7116a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // c.k.d.m.b
    public void c() {
        m.b bVar = this.f7116a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
