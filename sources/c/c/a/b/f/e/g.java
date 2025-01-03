package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class g extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4179e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4180f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ vc f4181g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4182h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c cVar, String str, String str2, vc vcVar) {
        super(cVar);
        this.f4182h = cVar;
        this.f4179e = str;
        this.f4180f = str2;
        this.f4181g = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4182h.f4106g;
        xcVar.getConditionalUserProperties(this.f4179e, this.f4180f, this.f4181g);
    }

    @Override // c.c.a.b.f.e.c.a
    public final void b() {
        this.f4181g.a((Bundle) null);
    }
}
