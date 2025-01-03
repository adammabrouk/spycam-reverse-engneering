package c.c.a.b.j;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class a0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5256a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    public Queue<z<TResult>> f5257b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public boolean f5258c;

    public final void a(z<TResult> zVar) {
        synchronized (this.f5256a) {
            if (this.f5257b == null) {
                this.f5257b = new ArrayDeque();
            }
            this.f5257b.add(zVar);
        }
    }

    public final void a(h<TResult> hVar) {
        z<TResult> poll;
        synchronized (this.f5256a) {
            if (this.f5257b != null && !this.f5258c) {
                this.f5258c = true;
                while (true) {
                    synchronized (this.f5256a) {
                        poll = this.f5257b.poll();
                        if (poll == null) {
                            this.f5258c = false;
                            return;
                        }
                    }
                    poll.onComplete(hVar);
                }
            }
        }
    }
}
