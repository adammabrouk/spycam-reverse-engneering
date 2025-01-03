package c.c.a.b.g.b;

import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class n5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaq f4952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4953b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5 f4954c;

    public n5(g5 g5Var, zzaq zzaqVar, String str) {
        this.f4954c = g5Var;
        this.f4952a = zzaqVar;
        this.f4953b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l9 l9Var;
        l9 l9Var2;
        l9Var = this.f4954c.f4739a;
        l9Var.s();
        l9Var2 = this.f4954c.f4739a;
        l9Var2.a(this.f4952a, this.f4953b);
    }
}
