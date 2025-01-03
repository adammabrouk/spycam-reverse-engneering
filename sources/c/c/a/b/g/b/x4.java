package c.c.a.b.g.b;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x4 extends v5 {
    public static final AtomicLong l = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public b5 f5176c;

    /* renamed from: d, reason: collision with root package name */
    public b5 f5177d;

    /* renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue<y4<?>> f5178e;

    /* renamed from: f, reason: collision with root package name */
    public final BlockingQueue<y4<?>> f5179f;

    /* renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f5180g;

    /* renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f5181h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f5182i;
    public final Semaphore j;
    public volatile boolean k;

    public x4(a5 a5Var) {
        super(a5Var);
        this.f5182i = new Object();
        this.j = new Semaphore(2);
        this.f5178e = new PriorityBlockingQueue<>();
        this.f5179f = new LinkedBlockingQueue();
        this.f5180g = new z4(this, "Thread death: Uncaught exception on worker thread");
        this.f5181h = new z4(this, "Thread death: Uncaught exception on network thread");
    }

    public final <V> Future<V> a(Callable<V> callable) throws IllegalStateException {
        n();
        c.c.a.b.c.o.r.a(callable);
        y4<?> y4Var = new y4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5176c) {
            if (!this.f5178e.isEmpty()) {
                c().w().a("Callable skipped the worker queue.");
            }
            y4Var.run();
        } else {
            a(y4Var);
        }
        return y4Var;
    }

    public final <V> Future<V> b(Callable<V> callable) throws IllegalStateException {
        n();
        c.c.a.b.c.o.r.a(callable);
        y4<?> y4Var = new y4<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5176c) {
            y4Var.run();
        } else {
            a(y4Var);
        }
        return y4Var;
    }

    @Override // c.c.a.b.g.b.w5
    public final void f() {
        if (Thread.currentThread() != this.f5177d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // c.c.a.b.g.b.w5
    public final void g() {
        if (Thread.currentThread() != this.f5176c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        return false;
    }

    public final boolean s() {
        return Thread.currentThread() == this.f5176c;
    }

    public final void b(Runnable runnable) throws IllegalStateException {
        n();
        c.c.a.b.c.o.r.a(runnable);
        y4<?> y4Var = new y4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f5182i) {
            this.f5179f.add(y4Var);
            if (this.f5177d == null) {
                b5 b5Var = new b5(this, "Measurement Network", this.f5179f);
                this.f5177d = b5Var;
                b5Var.setUncaughtExceptionHandler(this.f5181h);
                this.f5177d.start();
            } else {
                this.f5177d.a();
            }
        }
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        n();
        c.c.a.b.c.o.r.a(runnable);
        a(new y4<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final <T> T a(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            a().a(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                y3 w = c().w();
                String valueOf = String.valueOf(str);
                w.a(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            y3 w2 = c().w();
            String valueOf2 = String.valueOf(str);
            w2.a(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    public static /* synthetic */ b5 b(x4 x4Var, b5 b5Var) {
        x4Var.f5177d = null;
        return null;
    }

    public final void a(y4<?> y4Var) {
        synchronized (this.f5182i) {
            this.f5178e.add(y4Var);
            if (this.f5176c == null) {
                b5 b5Var = new b5(this, "Measurement Worker", this.f5178e);
                this.f5176c = b5Var;
                b5Var.setUncaughtExceptionHandler(this.f5180g);
                this.f5176c.start();
            } else {
                this.f5176c.a();
            }
        }
    }

    public static /* synthetic */ b5 a(x4 x4Var, b5 b5Var) {
        x4Var.f5176c = null;
        return null;
    }
}
