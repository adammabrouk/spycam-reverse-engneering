package c.c.a.b.c.l.m;

import android.os.RemoteException;
import c.c.a.b.c.l.m.b;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class d0 extends c0<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final f<?> f3873b;

    public d0(f<?> fVar, c.c.a.b.j.i<Boolean> iVar) {
        super(4, iVar);
        this.f3873b = fVar;
    }

    @Override // c.c.a.b.c.l.m.l
    public final /* bridge */ /* synthetic */ void a(i iVar, boolean z) {
    }

    @Override // c.c.a.b.c.l.m.v
    public final Feature[] b(b.a<?> aVar) {
        u uVar = aVar.l().get(this.f3873b);
        if (uVar == null) {
            return null;
        }
        return uVar.f3899a.b();
    }

    @Override // c.c.a.b.c.l.m.v
    public final boolean c(b.a<?> aVar) {
        u uVar = aVar.l().get(this.f3873b);
        return uVar != null && uVar.f3899a.c();
    }

    @Override // c.c.a.b.c.l.m.c0
    public final void d(b.a<?> aVar) throws RemoteException {
        u remove = aVar.l().remove(this.f3873b);
        if (remove == null) {
            this.f3872a.b((c.c.a.b.j.i<T>) false);
        } else {
            remove.f3900b.a(aVar.f(), this.f3872a);
            remove.f3899a.a();
        }
    }
}
