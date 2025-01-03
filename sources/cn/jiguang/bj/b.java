package cn.jiguang.bj;

import cn.jiguang.bf.h;
import java.lang.Thread;

/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8812a;

    /* renamed from: h, reason: collision with root package name */
    public String f8813h;

    public b() {
        this.f8812a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.bj.b.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f8813h);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.as.d.i("JCoreRunnable", sb.toString());
            }
        };
    }

    public b(String str) {
        this.f8813h = str;
        this.f8812a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.bj.b.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                h.a().a(thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(b.this.f8813h);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                cn.jiguang.as.d.i("JCoreRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f8812a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
