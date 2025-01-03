package c.c.a.b.f.e;

import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class j extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4229e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4230f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c cVar, String str) {
        super(cVar);
        this.f4230f = cVar;
        this.f4229e = str;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4230f.f4106g;
        xcVar.endAdUnitExposure(this.f4229e, this.f4108b);
    }
}
