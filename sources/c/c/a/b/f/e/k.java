package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class k extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ vc f4250e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4251f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c cVar, vc vcVar) {
        super(cVar);
        this.f4251f = cVar;
        this.f4250e = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4251f.f4106g;
        xcVar.getCachedAppInstanceId(this.f4250e);
    }

    @Override // c.c.a.b.f.e.c.a
    public final void b() {
        this.f4250e.a((Bundle) null);
    }
}
