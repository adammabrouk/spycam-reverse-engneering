package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class i5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzy f4801a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5 f4802b;

    public i5(g5 g5Var, zzy zzyVar) {
        this.f4802b = g5Var;
        this.f4801a = zzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9 l9Var3;
        l9Var = this.f4802b.f4739a;
        l9Var.s();
        if (this.f4801a.f10229c.zza() == null) {
            l9Var3 = this.f4802b.f4739a;
            l9Var3.b(this.f4801a);
        } else {
            l9Var2 = this.f4802b.f4739a;
            l9Var2.a(this.f4801a);
        }
    }
}
