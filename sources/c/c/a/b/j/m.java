package c.c.a.b.j;

/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5275a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f5276b;

    public m(l lVar, h hVar) {
        this.f5276b = lVar;
        this.f5275a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        a aVar;
        c0 c0Var4;
        c0 c0Var5;
        if (this.f5275a.c()) {
            c0Var5 = this.f5276b.f5274c;
            c0Var5.f();
            return;
        }
        try {
            aVar = this.f5276b.f5273b;
            Object a2 = aVar.a(this.f5275a);
            c0Var4 = this.f5276b.f5274c;
            c0Var4.a((c0) a2);
        } catch (f e2) {
            if (e2.getCause() instanceof Exception) {
                c0Var3 = this.f5276b.f5274c;
                c0Var3.a((Exception) e2.getCause());
            } else {
                c0Var2 = this.f5276b.f5274c;
                c0Var2.a((Exception) e2);
            }
        } catch (Exception e3) {
            c0Var = this.f5276b.f5274c;
            c0Var.a(e3);
        }
    }
}
