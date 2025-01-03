package c.c.a.b.f.e;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class z extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f4546e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Bundle f4547f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c.C0094c f4548g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c.C0094c c0094c, Activity activity, Bundle bundle) {
        super(c.this);
        this.f4548g = c0094c;
        this.f4546e = activity;
        this.f4547f = bundle;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = c.this.f4106g;
        xcVar.onActivityCreated(c.c.a.b.d.b.a(this.f4546e), this.f4547f, this.f4108b);
    }
}
