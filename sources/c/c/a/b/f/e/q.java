package c.c.a.b.f.e;

import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class q extends c.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4366f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4367g;
    public final /* synthetic */ c j;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4365e = 5;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4368h = null;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f4369i = null;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c cVar, boolean z, int i2, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.j = cVar;
        this.f4366f = str;
        this.f4367g = obj;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.j.f4106g;
        xcVar.logHealthData(this.f4365e, this.f4366f, c.c.a.b.d.b.a(this.f4367g), c.c.a.b.d.b.a(this.f4368h), c.c.a.b.d.b.a(this.f4369i));
    }
}
