package c.c.a.b.j;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l<TResult, TContinuationResult> implements z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5272a;

    /* renamed from: b, reason: collision with root package name */
    public final a<TResult, TContinuationResult> f5273b;

    /* renamed from: c, reason: collision with root package name */
    public final c0<TContinuationResult> f5274c;

    public l(Executor executor, a<TResult, TContinuationResult> aVar, c0<TContinuationResult> c0Var) {
        this.f5272a = executor;
        this.f5273b = aVar;
        this.f5274c = c0Var;
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        this.f5272a.execute(new m(this, hVar));
    }
}
