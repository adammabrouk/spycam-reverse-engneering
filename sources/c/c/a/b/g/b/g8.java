package c.c.a.b.g.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class g8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzy f4747c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzm f4748d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzy f4749e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r7 f4750f;

    public g8(r7 r7Var, boolean z, boolean z2, zzy zzyVar, zzm zzmVar, zzy zzyVar2) {
        this.f4750f = r7Var;
        this.f4745a = z;
        this.f4746b = z2;
        this.f4747c = zzyVar;
        this.f4748d = zzmVar;
        this.f4749e = zzyVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f4750f.f5045d;
        if (o3Var == null) {
            this.f4750f.c().t().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f4745a) {
            this.f4750f.a(o3Var, this.f4746b ? null : this.f4747c, this.f4748d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f4749e.f10227a)) {
                    o3Var.a(this.f4747c, this.f4748d);
                } else {
                    o3Var.a(this.f4747c);
                }
            } catch (RemoteException e2) {
                this.f4750f.c().t().a("Failed to send conditional user property to the service", e2);
            }
        }
        this.f4750f.K();
    }
}
