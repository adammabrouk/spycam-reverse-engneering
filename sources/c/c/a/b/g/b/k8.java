package c.c.a.b.g.b;

import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4865a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4866b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4867c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzm f4868d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ yc f4869e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r7 f4870f;

    public k8(r7 r7Var, String str, String str2, boolean z, zzm zzmVar, yc ycVar) {
        this.f4870f = r7Var;
        this.f4865a = str;
        this.f4866b = str2;
        this.f4867c = z;
        this.f4868d = zzmVar;
        this.f4869e = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        Bundle bundle = new Bundle();
        try {
            o3Var = this.f4870f.f5045d;
            if (o3Var == null) {
                this.f4870f.c().t().a("Failed to get user properties; not connected to service", this.f4865a, this.f4866b);
                return;
            }
            Bundle a2 = s9.a(o3Var.a(this.f4865a, this.f4866b, this.f4867c, this.f4868d));
            this.f4870f.K();
            this.f4870f.j().a(this.f4869e, a2);
        } catch (RemoteException e2) {
            this.f4870f.c().t().a("Failed to get user properties; remote exception", this.f4865a, e2);
        } finally {
            this.f4870f.j().a(this.f4869e, bundle);
        }
    }
}
