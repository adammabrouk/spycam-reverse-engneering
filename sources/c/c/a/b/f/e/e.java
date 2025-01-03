package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class e extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4135e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4136f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Bundle f4137g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4138h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, String str, String str2, Bundle bundle) {
        super(cVar);
        this.f4138h = cVar;
        this.f4135e = str;
        this.f4136f = str2;
        this.f4137g = bundle;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4138h.f4106g;
        xcVar.clearConditionalUserProperty(this.f4135e, this.f4136f, this.f4137g);
    }
}
