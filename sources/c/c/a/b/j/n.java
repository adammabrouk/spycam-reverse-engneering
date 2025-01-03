package c.c.a.b.j;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class n<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5277a;

    /* renamed from: b, reason: collision with root package name */
    public final a<TResult, h<TContinuationResult>> f5278b;

    /* renamed from: c, reason: collision with root package name */
    public final c0<TContinuationResult> f5279c;

    public n(Executor executor, a<TResult, h<TContinuationResult>> aVar, c0<TContinuationResult> c0Var) {
        this.f5277a = executor;
        this.f5278b = aVar;
        this.f5279c = c0Var;
    }

    @Override // c.c.a.b.j.e
    public final void a(TContinuationResult tcontinuationresult) {
        this.f5279c.a((c0<TContinuationResult>) tcontinuationresult);
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        this.f5277a.execute(new o(this, hVar));
    }

    @Override // c.c.a.b.j.d
    public final void a(Exception exc) {
        this.f5279c.a(exc);
    }

    @Override // c.c.a.b.j.b
    public final void a() {
        this.f5279c.f();
    }
}
