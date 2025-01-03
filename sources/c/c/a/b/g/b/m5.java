package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzy;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class m5 implements Callable<List<zzy>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4927a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4928b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4929c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g5 f4930d;

    public m5(g5 g5Var, String str, String str2, String str3) {
        this.f4930d = g5Var;
        this.f4927a = str;
        this.f4928b = str2;
        this.f4929c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4930d.f4739a;
        l9Var.s();
        l9Var2 = this.f4930d.f4739a;
        return l9Var2.k().b(this.f4927a, this.f4928b, this.f4929c);
    }
}
