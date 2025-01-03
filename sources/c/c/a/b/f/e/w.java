package c.c.a.b.f.e;

import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class w extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4499e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4500f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4501g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f4502h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f4503i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(c cVar, String str, String str2, Object obj, boolean z) {
        super(cVar);
        this.f4503i = cVar;
        this.f4499e = str;
        this.f4500f = str2;
        this.f4501g = obj;
        this.f4502h = z;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        xcVar = this.f4503i.f4106g;
        xcVar.setUserProperty(this.f4499e, this.f4500f, c.c.a.b.d.b.a(this.f4501g), this.f4502h, this.f4107a);
    }
}
