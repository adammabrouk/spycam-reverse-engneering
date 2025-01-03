package c.c.a.b.f.e;

import android.app.Activity;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class f0 extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f4161e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ vc f4162f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c.C0094c f4163g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(c.C0094c c0094c, Activity activity, vc vcVar) {
        super(c.this);
        this.f4163g = c0094c;
        this.f4161e = activity;
        this.f4162f = vcVar;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = c.this.f4106g;
        xcVar.onActivitySaveInstanceState(c.c.a.b.d.b.a(this.f4161e), this.f4162f, this.f4108b);
    }
}
