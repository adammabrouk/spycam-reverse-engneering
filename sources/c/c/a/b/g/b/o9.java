package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzm;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class o9 implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f4983a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l9 f4984b;

    public o9(l9 l9Var, zzm zzmVar) {
        this.f4984b = l9Var;
        this.f4983a = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        d5 c2 = this.f4984b.c(this.f4983a);
        if (c2 != null) {
            return c2.m();
        }
        this.f4984b.c().w().a("App info was null when attempting to get app instance id");
        return null;
    }
}
