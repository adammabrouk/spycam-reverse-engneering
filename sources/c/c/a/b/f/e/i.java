package c.c.a.b.f.e;

import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class i extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4219e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4220f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c cVar, String str) {
        super(cVar);
        this.f4220f = cVar;
        this.f4219e = str;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4220f.f4106g;
        xcVar.beginAdUnitExposure(this.f4219e, this.f4108b);
    }
}
