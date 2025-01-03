package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class l5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f4888a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5 f4889b;

    public l5(g5 g5Var, zzm zzmVar) {
        this.f4889b = g5Var;
        this.f4888a = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4889b.f4739a;
        l9Var.s();
        l9Var2 = this.f4889b.f4739a;
        l9Var2.a(this.f4888a);
    }
}
