package cn.jiguang.ax;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f8476a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f8477b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f8478c;

    /* renamed from: e, reason: collision with root package name */
    public final cn.jiguang.ax.a<Object> f8480e;

    /* renamed from: g, reason: collision with root package name */
    public Object f8482g;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f8479d = new AtomicBoolean(true);

    /* renamed from: f, reason: collision with root package name */
    public volatile long f8481f = 0;

    /* renamed from: h, reason: collision with root package name */
    public CountDownLatch f8483h = new CountDownLatch(1);

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f8485a;

        public a(ExecutorService executorService) {
            super(p.d());
            this.f8485a = executorService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f8485a.isShutdown()) {
                    cn.jiguang.as.d.g("Step", "executor is shutdown");
                } else {
                    this.f8485a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.i("Step", "handleMessage e:" + th);
            }
        }
    }

    public p(int i2, int i3, cn.jiguang.ax.a<Object> aVar, String str) {
        this.f8476a = i3;
        this.f8480e = aVar;
        this.f8477b = new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cn.jiguang.bj.c(str)) { // from class: cn.jiguang.ax.p.1
            /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
            
                if (r1.f8484a.f8478c.hasMessages(233) == false) goto L11;
             */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
            @Override // java.util.concurrent.ThreadPoolExecutor
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void afterExecute(java.lang.Runnable r2, java.lang.Throwable r3) {
                /*
                    r1 = this;
                    r2 = 1
                    int r3 = r1.getActiveCount()     // Catch: java.lang.Throwable -> L22
                    if (r3 > r2) goto L20
                    java.util.concurrent.BlockingQueue r3 = r1.getQueue()     // Catch: java.lang.Throwable -> L22
                    boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L22
                    if (r3 == 0) goto L20
                    cn.jiguang.ax.p r3 = cn.jiguang.ax.p.this     // Catch: java.lang.Throwable -> L22
                    android.os.Handler r3 = cn.jiguang.ax.p.a(r3)     // Catch: java.lang.Throwable -> L22
                    r0 = 233(0xe9, float:3.27E-43)
                    boolean r3 = r3.hasMessages(r0)     // Catch: java.lang.Throwable -> L22
                    if (r3 != 0) goto L20
                    goto L22
                L20:
                    r3 = 0
                    goto L23
                L22:
                    r3 = 1
                L23:
                    if (r3 == 0) goto L37
                    cn.jiguang.ax.p r3 = cn.jiguang.ax.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.atomic.AtomicBoolean r3 = cn.jiguang.ax.p.b(r3)     // Catch: java.lang.Throwable -> L37
                    r3.set(r2)     // Catch: java.lang.Throwable -> L37
                    cn.jiguang.ax.p r2 = cn.jiguang.ax.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.CountDownLatch r2 = cn.jiguang.ax.p.c(r2)     // Catch: java.lang.Throwable -> L37
                    r2.countDown()     // Catch: java.lang.Throwable -> L37
                L37:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ax.p.AnonymousClass1.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
            }
        };
        this.f8478c = new a(this.f8477b);
    }

    private synchronized long b(long j) {
        long j2 = this.f8481f + j;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j2 < uptimeMillis) {
            this.f8481f = uptimeMillis;
            return -1L;
        }
        this.f8481f = j2;
        return j2;
    }

    public static Looper d() {
        HandlerThread handlerThread = new HandlerThread("jg_step_thread") { // from class: cn.jiguang.ax.p.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public synchronized Object a(long j) {
        if (a()) {
            return this.f8482g;
        }
        if (this.f8479d.get()) {
            return null;
        }
        try {
            if (j != -1) {
                this.f8483h.await(j, TimeUnit.MILLISECONDS);
            } else {
                this.f8483h.await();
            }
        } catch (InterruptedException unused) {
        }
        if (this.f8483h.getCount() == 0) {
            this.f8483h = new CountDownLatch(1);
        }
        return this.f8482g;
    }

    public void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.f8482g = obj;
        this.f8483h.countDown();
        cn.jiguang.ax.a<Object> aVar = this.f8480e;
        if (aVar != null) {
            aVar.a(obj);
        }
        a(true);
        cn.jiguang.as.d.c("Step", "done!");
    }

    public void a(Callable<?> callable) {
        try {
            long b2 = b(this.f8476a);
            if (b2 < 0) {
                this.f8477b.submit(callable);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 233;
                obtain.obj = callable;
                this.f8478c.sendMessageAtTime(obtain, b2);
            }
            this.f8479d.set(false);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.f8478c.removeMessages(233);
        if (!this.f8477b.isShutdown()) {
            if (z) {
                this.f8477b.shutdownNow();
            } else {
                this.f8477b.shutdown();
            }
        }
        try {
            this.f8478c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.as.d.c("Step", "StepParallelScheduler stop !");
    }

    public boolean a() {
        return this.f8482g != null;
    }

    public void b() {
        try {
            if (this.f8477b != null) {
                this.f8477b.getQueue().clear();
                this.f8478c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }
}
