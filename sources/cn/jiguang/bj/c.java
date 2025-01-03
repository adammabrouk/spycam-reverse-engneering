package cn.jiguang.bj;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f8816a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f8817b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public final String f8818c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f8816a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f8818c = "jg_" + (TextUtils.isEmpty(str) ? "default" : str.toLowerCase()) + "_pool_thread";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        Throwable th;
        try {
            thread = new Thread(this.f8816a, runnable, this.f8818c + this.f8817b.getAndIncrement(), 0L);
        } catch (Throwable th2) {
            thread = null;
            th = th2;
        }
        try {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() == 5) {
                return thread;
            }
            thread.setPriority(5);
            return thread;
        } catch (Throwable th3) {
            th = th3;
            cn.jiguang.as.d.i("JThreadFactory", "JThreadFactory new Thread error, " + th.getMessage());
            try {
                Thread thread2 = new Thread(this.f8816a, runnable, this.f8818c + this.f8817b.getAndIncrement(), 0L);
                try {
                    if (thread2.isDaemon()) {
                        thread2.setDaemon(false);
                    }
                    if (thread2.getPriority() != 5) {
                        thread2.setPriority(5);
                    }
                    return thread2;
                } catch (Throwable th4) {
                    th = th4;
                    thread = thread2;
                    cn.jiguang.as.d.i("JThreadFactory", "JThreadFactory new Thread again error, " + th.getMessage());
                    return thread;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }
}
