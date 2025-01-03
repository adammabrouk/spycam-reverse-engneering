package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class o extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4335e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4336f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f4337g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ vc f4338h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f4339i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(c cVar, String str, String str2, boolean z, vc vcVar) {
        super(cVar);
        this.f4339i = cVar;
        this.f4335e = str;
        this.f4336f = str2;
        this.f4337g = z;
        this.f4338h = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4339i.f4106g;
        xcVar.getUserProperties(this.f4335e, this.f4336f, this.f4337g, this.f4338h);
    }

    @Override // c.c.a.b.f.e.c.a
    public final void b() {
        this.f4338h.a((Bundle) null);
    }
}
