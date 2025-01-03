package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5100a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzkn f5101b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzm f5102c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r7 f5103d;

    public t7(r7 r7Var, boolean z, zzkn zzknVar, zzm zzmVar) {
        this.f5103d = r7Var;
        this.f5100a = z;
        this.f5101b = zzknVar;
        this.f5102c = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        o3Var = this.f5103d.f5045d;
        if (o3Var == null) {
            this.f5103d.c().t().a("Discarding data. Failed to set user property");
        } else {
            this.f5103d.a(o3Var, this.f5100a ? null : this.f5101b, this.f5102c);
            this.f5103d.K();
        }
    }
}
