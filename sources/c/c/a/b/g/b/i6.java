package c.c.a.b.g.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class i6 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4803a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h6 f4804b;

    public i6(h6 h6Var, AtomicReference atomicReference) {
        this.f4804b = h6Var;
        this.f4803a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4803a) {
            try {
                this.f4803a.set(Boolean.valueOf(this.f4804b.l().h(this.f4804b.p().A())));
            } finally {
                this.f4803a.notify();
            }
        }
    }
}
