package c.c.a.b.g.b;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m7 f5204a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r7 f5205b;

    public y7(r7 r7Var, m7 m7Var) {
        this.f5205b = r7Var;
        this.f5204a = m7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f5205b.f5045d;
        if (o3Var == null) {
            this.f5205b.c().t().a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f5204a == null) {
                o3Var.a(0L, (String) null, (String) null, this.f5205b.d().getPackageName());
            } else {
                o3Var.a(this.f5204a.f4938c, this.f5204a.f4936a, this.f5204a.f4937b, this.f5205b.d().getPackageName());
            }
            this.f5205b.K();
        } catch (RemoteException e2) {
            this.f5205b.c().t().a("Failed to send current screen to the service", e2);
        }
    }
}
