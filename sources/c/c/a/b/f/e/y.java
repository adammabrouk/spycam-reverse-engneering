package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class y extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f4526e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4527f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(c cVar, Bundle bundle) {
        super(cVar);
        this.f4527f = cVar;
        this.f4526e = bundle;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4527f.f4106g;
        xcVar.setConditionalUserProperty(this.f4526e, this.f4107a);
    }
}
