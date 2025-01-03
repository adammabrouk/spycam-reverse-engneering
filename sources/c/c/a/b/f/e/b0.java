package c.c.a.b.f.e;

import android.app.Activity;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class b0 extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f4079e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c.C0094c f4080f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c.C0094c c0094c, Activity activity) {
        super(c.this);
        this.f4080f = c0094c;
        this.f4079e = activity;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = c.this.f4106g;
        xcVar.onActivityStarted(c.c.a.b.d.b.a(this.f4079e), this.f4108b);
    }
}
