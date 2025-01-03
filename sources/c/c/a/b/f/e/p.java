package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class p extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ vc f4351e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4352f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(c cVar, vc vcVar) {
        super(cVar);
        this.f4352f = cVar;
        this.f4351e = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4352f.f4106g;
        xcVar.getCurrentScreenClass(this.f4351e);
    }

    @Override // c.c.a.b.f.e.c.a
    public final void b() {
        this.f4351e.a((Bundle) null);
    }
}
