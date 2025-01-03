package c.c.a.b.g.b;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class k5 implements Callable<List<t9>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4852a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4853b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4854c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g5 f4855d;

    public k5(g5 g5Var, String str, String str2, String str3) {
        this.f4855d = g5Var;
        this.f4852a = str;
        this.f4853b = str2;
        this.f4854c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<t9> call() throws Exception {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4855d.f4739a;
        l9Var.s();
        l9Var2 = this.f4855d.f4739a;
        return l9Var2.k().a(this.f4852a, this.f4853b, this.f4854c);
    }
}
