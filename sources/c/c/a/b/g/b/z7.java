package c.c.a.b.g.b;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f5228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r7 f5229b;

    public z7(r7 r7Var, zzm zzmVar) {
        this.f5229b = r7Var;
        this.f5228a = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f5229b.f5045d;
        if (o3Var == null) {
            this.f5229b.c().t().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            o3Var.d(this.f5228a);
            this.f5229b.s().C();
            this.f5229b.a(o3Var, (AbstractSafeParcelable) null, this.f5228a);
            this.f5229b.K();
        } catch (RemoteException e2) {
            this.f5229b.c().t().a("Failed to send app launch to the service", e2);
        }
    }
}
