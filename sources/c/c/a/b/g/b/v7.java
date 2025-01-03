package c.c.a.b.g.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f5144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r7 f5145b;

    public v7(r7 r7Var, zzm zzmVar) {
        this.f5145b = r7Var;
        this.f5144a = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f5145b.f5045d;
        if (o3Var == null) {
            this.f5145b.c().t().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            o3Var.c(this.f5144a);
        } catch (RemoteException e2) {
            this.f5145b.c().t().a("Failed to reset data on the service: remote exception", e2);
        }
        this.f5145b.K();
    }
}
