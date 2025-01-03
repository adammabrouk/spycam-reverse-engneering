package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f5125b;

    public u6(h6 h6Var, AtomicReference atomicReference) {
        this.f5125b = h6Var;
        this.f5124a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5124a) {
            try {
                this.f5124a.set(Integer.valueOf(this.f5125b.l().b(this.f5125b.p().A(), r.N)));
            } finally {
                this.f5124a.notify();
            }
        }
    }
}
