package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class h5 implements Callable<List<t9>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f4763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4764b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4765c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g5 f4766d;

    public h5(g5 g5Var, zzm zzmVar, String str, String str2) {
        this.f4766d = g5Var;
        this.f4763a = zzmVar;
        this.f4764b = str;
        this.f4765c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<t9> call() throws Exception {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4766d.f4739a;
        l9Var.s();
        l9Var2 = this.f4766d.f4739a;
        return l9Var2.k().a(this.f4763a.f10218a, this.f4764b, this.f4765c);
    }
}
