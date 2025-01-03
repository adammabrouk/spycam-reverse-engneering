package c.c.a.b.j;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f5265a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f5266b;

    public d0(c0 c0Var, Callable callable) {
        this.f5265a = c0Var;
        this.f5266b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5265a.a((c0) this.f5266b.call());
        } catch (Exception e2) {
            this.f5265a.a(e2);
        }
    }
}
