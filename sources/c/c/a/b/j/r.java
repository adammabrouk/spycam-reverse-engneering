package c.c.a.b.j;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class r<TResult> implements z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5286a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5287b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public c<TResult> f5288c;

    public r(Executor executor, c<TResult> cVar) {
        this.f5286a = executor;
        this.f5288c = cVar;
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        synchronized (this.f5287b) {
            if (this.f5288c == null) {
                return;
            }
            this.f5286a.execute(new s(this, hVar));
        }
    }
}
