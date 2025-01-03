package c.c.a.b.g.b;

import android.os.RemoteException;
import c.c.a.b.f.e.yc;
import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaq f4610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4611b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yc f4612c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r7 f4613d;

    public b8(r7 r7Var, zzaq zzaqVar, String str, yc ycVar) {
        this.f4613d = r7Var;
        this.f4610a = zzaqVar;
        this.f4611b = str;
        this.f4612c = ycVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        try {
            o3Var = this.f4613d.f5045d;
            if (o3Var == null) {
                this.f4613d.c().t().a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] a2 = o3Var.a(this.f4610a, this.f4611b);
            this.f4613d.K();
            this.f4613d.j().a(this.f4612c, a2);
        } catch (RemoteException e2) {
            this.f4613d.c().t().a("Failed to send event to the service to bundle", e2);
        } finally {
            this.f4613d.j().a(this.f4612c, (byte[]) null);
        }
    }
}
