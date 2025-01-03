package androidx.lifecycle;

import a.m.d;
import a.m.f;
import a.m.g;
import a.m.i;
import a.m.m;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: a, reason: collision with root package name */
    public final d[] f2643a;

    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f2643a = dVarArr;
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        m mVar = new m();
        for (d dVar : this.f2643a) {
            dVar.a(iVar, bVar, false, mVar);
        }
        for (d dVar2 : this.f2643a) {
            dVar2.a(iVar, bVar, true, mVar);
        }
    }
}
