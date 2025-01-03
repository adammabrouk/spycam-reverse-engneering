package a.c.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f627a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f628b = Executors.newFixedThreadPool(4, new a(this));

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f629c;

    /* compiled from: DefaultTaskExecutor.java */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f630a = new AtomicInteger(0);

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f630a.getAndIncrement())));
            return thread;
        }
    }

    @Override // a.c.a.a.c
    public void a(Runnable runnable) {
        this.f628b.execute(runnable);
    }

    @Override // a.c.a.a.c
    public void b(Runnable runnable) {
        if (this.f629c == null) {
            synchronized (this.f627a) {
                if (this.f629c == null) {
                    this.f629c = a(Looper.getMainLooper());
                }
            }
        }
        this.f629c.post(runnable);
    }

    @Override // a.c.a.a.c
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static Handler a(Looper looper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i2 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
