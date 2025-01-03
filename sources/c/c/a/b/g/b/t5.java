package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class t5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzy f5092a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzm f5093b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5 f5094c;

    public t5(g5 g5Var, zzy zzyVar, zzm zzmVar) {
        this.f5094c = g5Var;
        this.f5092a = zzyVar;
        this.f5093b = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9 l9Var3;
        l9Var = this.f5094c.f4739a;
        l9Var.s();
        if (this.f5092a.f10229c.zza() == null) {
            l9Var3 = this.f5094c.f4739a;
            l9Var3.b(this.f5092a, this.f5093b);
        } else {
            l9Var2 = this.f5094c.f4739a;
            l9Var2.a(this.f5092a, this.f5093b);
        }
    }
}
