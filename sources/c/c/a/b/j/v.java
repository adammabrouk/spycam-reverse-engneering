package c.c.a.b.j;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class v<TResult> implements z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5296a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5297b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public e<? super TResult> f5298c;

    public v(Executor executor, e<? super TResult> eVar) {
        this.f5296a = executor;
        this.f5298c = eVar;
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        if (hVar.e()) {
            synchronized (this.f5297b) {
                if (this.f5298c == null) {
                    return;
                }
                this.f5296a.execute(new w(this, hVar));
            }
        }
    }
}
