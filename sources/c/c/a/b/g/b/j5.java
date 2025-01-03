package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class j5 implements Callable<List<zzy>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f4832a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4833b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4834c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g5 f4835d;

    public j5(g5 g5Var, zzm zzmVar, String str, String str2) {
        this.f4835d = g5Var;
        this.f4832a = zzmVar;
        this.f4833b = str;
        this.f4834c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4835d.f4739a;
        l9Var.s();
        l9Var2 = this.f4835d.f4739a;
        return l9Var2.k().b(this.f4832a.f10218a, this.f4833b, this.f4834c);
    }
}
