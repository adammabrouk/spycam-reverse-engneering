package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class s5 implements Callable<List<t9>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f5061a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5 f5062b;

    public s5(g5 g5Var, zzm zzmVar) {
        this.f5062b = g5Var;
        this.f5061a = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<t9> call() throws Exception {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f5062b.f4739a;
        l9Var.s();
        l9Var2 = this.f5062b.f4739a;
        return l9Var2.k().a(this.f5061a.f10218a);
    }
}
