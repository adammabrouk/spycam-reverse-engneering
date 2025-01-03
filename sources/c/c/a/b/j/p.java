package c.c.a.b.j;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class p<TResult> implements z<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5282a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5283b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public b f5284c;

    public p(Executor executor, b bVar) {
        this.f5282a = executor;
        this.f5284c = bVar;
    }

    @Override // c.c.a.b.j.z
    public final void onComplete(h hVar) {
        if (hVar.c()) {
            synchronized (this.f5283b) {
                if (this.f5284c == null) {
                    return;
                }
                this.f5282a.execute(new q(this));
            }
        }
    }
}
