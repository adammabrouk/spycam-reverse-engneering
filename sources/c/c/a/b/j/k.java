package c.c.a.b.j;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class k {

    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final CountDownLatch f5271a;

        public a() {
            this.f5271a = new CountDownLatch(1);
        }

        @Override // c.c.a.b.j.e
        public final void a(Object obj) {
            this.f5271a.countDown();
        }

        public final void b() throws InterruptedException {
            this.f5271a.await();
        }

        @Override // c.c.a.b.j.d
        public final void a(Exception exc) {
            this.f5271a.countDown();
        }

        public /* synthetic */ a(d0 d0Var) {
            this();
        }

        @Override // c.c.a.b.j.b
        public final void a() {
            this.f5271a.countDown();
        }

        public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f5271a.await(j, timeUnit);
        }
    }

    public interface b extends c.c.a.b.j.b, d, e<Object> {
    }

    public static <TResult> h<TResult> a(TResult tresult) {
        c0 c0Var = new c0();
        c0Var.a((c0) tresult);
        return c0Var;
    }

    public static <TResult> TResult b(h<TResult> hVar) throws ExecutionException {
        if (hVar.e()) {
            return hVar.b();
        }
        if (hVar.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(hVar.a());
    }

    public static <TResult> h<TResult> a(Executor executor, Callable<TResult> callable) {
        c.c.a.b.c.o.r.a(executor, "Executor must not be null");
        c.c.a.b.c.o.r.a(callable, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new d0(c0Var, callable));
        return c0Var;
    }

    public static <TResult> TResult a(h<TResult> hVar) throws ExecutionException, InterruptedException {
        c.c.a.b.c.o.r.a();
        c.c.a.b.c.o.r.a(hVar, "Task must not be null");
        if (hVar.d()) {
            return (TResult) b(hVar);
        }
        a aVar = new a(null);
        a((h<?>) hVar, (b) aVar);
        aVar.b();
        return (TResult) b(hVar);
    }

    public static <TResult> TResult a(h<TResult> hVar, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        c.c.a.b.c.o.r.a();
        c.c.a.b.c.o.r.a(hVar, "Task must not be null");
        c.c.a.b.c.o.r.a(timeUnit, "TimeUnit must not be null");
        if (hVar.d()) {
            return (TResult) b(hVar);
        }
        a aVar = new a(null);
        a((h<?>) hVar, (b) aVar);
        if (aVar.a(j, timeUnit)) {
            return (TResult) b(hVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static void a(h<?> hVar, b bVar) {
        hVar.a(j.f5269b, (e<? super Object>) bVar);
        hVar.a(j.f5269b, (d) bVar);
        hVar.a(j.f5269b, (c.c.a.b.j.b) bVar);
    }
}
