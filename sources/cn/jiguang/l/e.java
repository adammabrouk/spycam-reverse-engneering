package cn.jiguang.l;

import cn.jiguang.bf.h;
import java.lang.Thread;

/* loaded from: classes.dex */
public abstract class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8953a = new Thread.UncaughtExceptionHandler() { // from class: cn.jiguang.l.e.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            h.a().a(thread, th);
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(e.this.f8954b);
            sb.append("thread id: ");
            sb.append(thread != null ? thread.getName() : "");
            sb.append("-");
            sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
            sb.append("\n e:");
            sb.append(th);
            cn.jiguang.ai.a.f("JCommonRunnable", sb.toString());
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public String f8954b;

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f8953a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
