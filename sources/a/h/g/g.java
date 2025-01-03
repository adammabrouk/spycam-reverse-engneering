package a.h.g;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: RequestExecutor.java */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f1055a;

        /* renamed from: b, reason: collision with root package name */
        public int f1056b;

        /* compiled from: RequestExecutor.java */
        /* renamed from: a.h.g.g$a$a, reason: collision with other inner class name */
        public static class C0022a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final int f1057a;

            public C0022a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f1057a = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f1057a);
                super.run();
            }
        }

        public a(String str, int i2) {
            this.f1055a = str;
            this.f1056b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0022a(runnable, this.f1055a, this.f1056b);
        }
    }

    /* compiled from: RequestExecutor.java */
    public static class b<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Callable<T> f1058a;

        /* renamed from: b, reason: collision with root package name */
        public a.h.i.a<T> f1059b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f1060c;

        /* compiled from: RequestExecutor.java */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a.h.i.a f1061a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f1062b;

            public a(b bVar, a.h.i.a aVar, Object obj) {
                this.f1061a = aVar;
                this.f1062b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f1061a.accept(this.f1062b);
            }
        }

        public b(Handler handler, Callable<T> callable, a.h.i.a<T> aVar) {
            this.f1058a = callable;
            this.f1059b = aVar;
            this.f1060c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.f1058a.call();
            } catch (Exception unused) {
                t = null;
            }
            this.f1060c.post(new a(this, this.f1059b, t));
        }
    }

    public static <T> void a(Executor executor, Callable<T> callable, a.h.i.a<T> aVar) {
        executor.execute(new b(a.h.g.b.a(), callable, aVar));
    }

    public static <T> T a(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }

    public static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
