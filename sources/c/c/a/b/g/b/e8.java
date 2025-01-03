package c.c.a.b.g.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class e8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f4702a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r7 f4703b;

    public e8(r7 r7Var, zzm zzmVar) {
        this.f4703b = r7Var;
        this.f4702a = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f4703b.f5045d;
        if (o3Var == null) {
            this.f4703b.c().t().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            o3Var.a(this.f4702a);
            this.f4703b.K();
        } catch (RemoteException e2) {
            this.f4703b.c().t().a("Failed to send measurementEnabled to the service", e2);
        }
    }
}
