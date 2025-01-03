package c.c.a.b.f.e;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.c;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* loaded from: classes.dex */
public final class x extends c.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Long f4509e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4510f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f4511g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Bundle f4512h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f4513i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ c k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c cVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(cVar);
        this.k = cVar;
        this.f4509e = l;
        this.f4510f = str;
        this.f4511g = str2;
        this.f4512h = bundle;
        this.f4513i = z;
        this.j = z2;
    }

    @Override // c.c.a.b.f.e.c.a
    public final void a() throws RemoteException {
        xc xcVar;
        Long l = this.f4509e;
        long longValue = l == null ? this.f4107a : l.longValue();
        xcVar = this.k.f4106g;
        xcVar.logEvent(this.f4510f, this.f4511g, this.f4512h, this.f4513i, this.j, longValue);
    }
}
