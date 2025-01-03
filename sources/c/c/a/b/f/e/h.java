package c.c.a.b.f.e;

import android.app.Activity;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class h extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f4194e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4195f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f4196g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4197h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c cVar, Activity activity, String str, String str2) {
        super(cVar);
        this.f4197h = cVar;
        this.f4194e = activity;
        this.f4195f = str;
        this.f4196g = str2;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4197h.f4106g;
        xcVar.setCurrentScreen(c.c.a.b.d.b.a(this.f4194e), this.f4195f, this.f4196g, this.f4107a);
    }
}
