package c.c.a.b.g.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class c8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4634b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzaq f4635c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzm f4636d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4637e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r7 f4638f;

    public c8(r7 r7Var, boolean z, boolean z2, zzaq zzaqVar, zzm zzmVar, String str) {
        this.f4638f = r7Var;
        this.f4633a = z;
        this.f4634b = z2;
        this.f4635c = zzaqVar;
        this.f4636d = zzmVar;
        this.f4637e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f4638f.f5045d;
        if (o3Var == null) {
            this.f4638f.c().t().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f4633a) {
            this.f4638f.a(o3Var, this.f4634b ? null : this.f4635c, this.f4636d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f4637e)) {
                    o3Var.a(this.f4635c, this.f4636d);
                } else {
                    o3Var.a(this.f4635c, this.f4637e, this.f4638f.c().C());
                }
            } catch (RemoteException e2) {
                this.f4638f.c().t().a("Failed to send event to the service", e2);
            }
        }
        this.f4638f.K();
    }
}
