package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5021a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f5022b;

    public q6(h6 h6Var, AtomicReference atomicReference) {
        this.f5022b = h6Var;
        this.f5021a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5021a) {
            try {
                this.f5021a.set(this.f5022b.l().i(this.f5022b.p().A()));
            } finally {
                this.f5021a.notify();
            }
        }
    }
}
