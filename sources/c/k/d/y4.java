package c.k.d;

/* loaded from: classes.dex */
public class y4 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x4 f8036a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(x4 x4Var, String str) {
        super(str);
        this.f8036a = x4Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        t4 t4Var;
        try {
            t4Var = this.f8036a.y;
            t4Var.m481a();
        } catch (Exception e2) {
            this.f8036a.c(9, e2);
        }
    }
}
