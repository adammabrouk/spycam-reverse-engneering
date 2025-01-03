package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class r5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f5040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5 f5041b;

    public r5(g5 g5Var, zzm zzmVar) {
        this.f5041b = g5Var;
        this.f5040a = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f5041b.f4739a;
        l9Var.s();
        l9Var2 = this.f5041b.f4739a;
        l9Var2.b(this.f5040a);
    }
}
