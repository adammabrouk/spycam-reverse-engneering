package c.c.a.b.j;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class x<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5301a;

    /* renamed from: b, reason: collision with root package name */
    public final g<TResult, TContinuationResult> f5302b;

    /* renamed from: c, reason: collision with root package name */
    public final c0<TContinuationResult> f5303c;

    public x(Executor executor, g<TResult, TContinuationResult> gVar, c0<TContinuationResult> c0Var) {
        this.f5301a = executor;
        this.f5302b = gVar;
        this.f5303c = c0Var;
    }

    @Override // c.c.a.b.j.e
    public final void a(TContinuationResult tcontinuationresult) {
        this.f5303c.a((c0<TContinuationResult>) tcontinuationresult);
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        this.f5301a.execute(new y(this, hVar));
    }

    @Override // c.c.a.b.j.d
    public final void a(Exception exc) {
        this.f5303c.a(exc);
    }

    @Override // c.c.a.b.j.b
    public final void a() {
        this.f5303c.f();
    }
}
