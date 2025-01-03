package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class o5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaq f4971a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzm f4972b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5 f4973c;

    public o5(g5 g5Var, zzaq zzaqVar, zzm zzmVar) {
        this.f4973c = g5Var;
        this.f4971a = zzaqVar;
        this.f4972b = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        zzaq b2 = this.f4973c.b(this.f4971a, this.f4972b);
        l9Var = this.f4973c.f4739a;
        l9Var.s();
        l9Var2 = this.f4973c.f4739a;
        l9Var2.a(b2, this.f4972b);
    }
}
