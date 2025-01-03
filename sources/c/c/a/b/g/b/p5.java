package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class p5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzkn f5000a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzm f5001b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5 f5002c;

    public p5(g5 g5Var, zzkn zzknVar, zzm zzmVar) {
        this.f5002c = g5Var;
        this.f5000a = zzknVar;
        this.f5001b = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9 l9Var3;
        l9Var = this.f5002c.f4739a;
        l9Var.s();
        if (this.f5000a.zza() == null) {
            l9Var3 = this.f5002c.f4739a;
            l9Var3.b(this.f5000a, this.f5001b);
        } else {
            l9Var2 = this.f5002c.f4739a;
            l9Var2.a(this.f5000a, this.f5001b);
        }
    }
}
