package c.c.a.b.f.e;

import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class v extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4484e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f4485f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(c cVar, boolean z) {
        super(cVar);
        this.f4485f = cVar;
        this.f4484e = z;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4485f.f4106g;
        xcVar.setDataCollectionEnabled(this.f4484e);
    }
}
