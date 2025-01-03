package c.c.a.b.j;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5304a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f5305b;

    public y(x xVar, h hVar) {
        this.f5305b = xVar;
        this.f5304a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar;
        try {
            gVar = this.f5305b.f5302b;
            h a2 = gVar.a(this.f5304a.b());
            if (a2 == null) {
                this.f5305b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            a2.a(j.f5269b, (e) this.f5305b);
            a2.a(j.f5269b, (d) this.f5305b);
            a2.a(j.f5269b, (b) this.f5305b);
        } catch (f e2) {
            if (e2.getCause() instanceof Exception) {
                this.f5305b.a((Exception) e2.getCause());
            } else {
                this.f5305b.a((Exception) e2);
            }
        } catch (CancellationException unused) {
            this.f5305b.a();
        } catch (Exception e3) {
            this.f5305b.a(e3);
        }
    }
}
