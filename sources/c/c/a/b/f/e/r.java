package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class r extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4389e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ vc f4390f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f4391g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(c cVar, String str, vc vcVar) {
        super(cVar);
        this.f4391g = cVar;
        this.f4389e = str;
        this.f4390f = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4391g.f4106g;
        xcVar.getMaxUserProperties(this.f4389e, this.f4390f);
    }

    @Override // c.c.a.b.f.e.c.a
    public final void b() {
        this.f4390f.a((Bundle) null);
    }
}
