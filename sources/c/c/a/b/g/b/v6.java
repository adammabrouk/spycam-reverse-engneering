package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5142a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f5143b;

    public v6(h6 h6Var, AtomicReference atomicReference) {
        this.f5143b = h6Var;
        this.f5142a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5142a) {
            try {
                this.f5142a.set(Long.valueOf(this.f5143b.l().a(this.f5143b.p().A(), r.M)));
            } finally {
                this.f5142a.notify();
            }
        }
    }
}
