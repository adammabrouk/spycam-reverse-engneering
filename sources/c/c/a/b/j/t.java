package c.c.a.b.j;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class t<TResult> implements z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5291a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5292b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public d f5293c;

    public t(Executor executor, d dVar) {
        this.f5291a = executor;
        this.f5293c = dVar;
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h<TResult> hVar) {
        if (hVar.e() || hVar.c()) {
            return;
        }
        synchronized (this.f5292b) {
            if (this.f5293c == null) {
                return;
            }
            this.f5291a.execute(new u(this, hVar));
        }
    }
}
