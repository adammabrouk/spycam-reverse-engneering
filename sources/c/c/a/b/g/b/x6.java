package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5183a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f5184b;

    public x6(h6 h6Var, AtomicReference atomicReference) {
        this.f5184b = h6Var;
        this.f5183a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5183a) {
            try {
                this.f5183a.set(Double.valueOf(this.f5184b.l().c(this.f5184b.p().A(), r.O)));
            } finally {
                this.f5183a.notify();
            }
        }
    }
}
