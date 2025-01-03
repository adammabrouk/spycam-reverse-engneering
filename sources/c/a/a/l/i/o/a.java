package c.a.a.l.i.o;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FifoPriorityThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f3175a;

    /* renamed from: b, reason: collision with root package name */
    public final d f3176b;

    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    public static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f3177a = 0;

        /* compiled from: FifoPriorityThreadPoolExecutor.java */
        /* renamed from: c.a.a.l.i.o.a$b$a, reason: collision with other inner class name */
        public class C0070a extends Thread {
            public C0070a(b bVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            C0070a c0070a = new C0070a(this, runnable, "fifo-pool-thread-" + this.f3177a);
            this.f3177a = this.f3177a + 1;
            return c0070a;
        }
    }

    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    public static class c<T> extends FutureTask<T> implements Comparable<c<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final int f3178a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3179b;

        public c(Runnable runnable, T t, int i2) {
            super(runnable, t);
            if (!(runnable instanceof c.a.a.l.i.o.b)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.f3178a = ((c.a.a.l.i.o.b) runnable).a();
            this.f3179b = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c<?> cVar) {
            int i2 = this.f3178a - cVar.f3178a;
            return i2 == 0 ? this.f3179b - cVar.f3179b : i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f3179b == cVar.f3179b && this.f3178a == cVar.f3178a;
        }

        public int hashCode() {
            return (this.f3178a * 31) + this.f3179b;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    public static class d {
        public static final d IGNORE = new d("IGNORE", 0);
        public static final d LOG = new C0071a("LOG", 1);
        public static final d THROW;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f3180a;

        /* compiled from: FifoPriorityThreadPoolExecutor.java */
        /* renamed from: c.a.a.l.i.o.a$d$a, reason: collision with other inner class name */
        public enum C0071a extends d {
            public C0071a(String str, int i2) {
                super(str, i2);
            }

            @Override // c.a.a.l.i.o.a.d
            public void handle(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* compiled from: FifoPriorityThreadPoolExecutor.java */
        public enum b extends d {
            public b(String str, int i2) {
                super(str, i2);
            }

            @Override // c.a.a.l.i.o.a.d
            public void handle(Throwable th) {
                super.handle(th);
                throw new RuntimeException(th);
            }
        }

        static {
            b bVar = new b("THROW", 2);
            THROW = bVar;
            f3180a = new d[]{IGNORE, LOG, bVar};
        }

        public d(String str, int i2) {
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f3180a.clone();
        }

        public void handle(Throwable th) {
        }
    }

    public a(int i2) {
        this(i2, d.LOG);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e2) {
                this.f3176b.handle(e2);
            } catch (ExecutionException e3) {
                this.f3176b.handle(e3);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new c(runnable, t, this.f3175a.getAndIncrement());
    }

    public a(int i2, d dVar) {
        this(i2, i2, 0L, TimeUnit.MILLISECONDS, new b(), dVar);
    }

    public a(int i2, int i3, long j, TimeUnit timeUnit, ThreadFactory threadFactory, d dVar) {
        super(i2, i3, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f3175a = new AtomicInteger();
        this.f3176b = dVar;
    }
}
