package c.c.a.b.j;

/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5281b;

    public o(n nVar, h hVar) {
        this.f5281b = nVar;
        this.f5280a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        a aVar;
        try {
            aVar = this.f5281b.f5278b;
            h hVar = (h) aVar.a(this.f5280a);
            if (hVar == null) {
                this.f5281b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            hVar.a(j.f5269b, (e) this.f5281b);
            hVar.a(j.f5269b, (d) this.f5281b);
            hVar.a(j.f5269b, (b) this.f5281b);
        } catch (f e2) {
            if (e2.getCause() instanceof Exception) {
                c0Var3 = this.f5281b.f5279c;
                c0Var3.a((Exception) e2.getCause());
            } else {
                c0Var2 = this.f5281b.f5279c;
                c0Var2.a((Exception) e2);
            }
        } catch (Exception e3) {
            c0Var = this.f5281b.f5279c;
            c0Var.a(e3);
        }
    }
}
