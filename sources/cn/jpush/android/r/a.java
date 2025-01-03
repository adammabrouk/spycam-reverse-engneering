package cn.jpush.android.r;

import android.content.Context;
import java.lang.Thread;

/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f9839a;

    /* renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f9840b;

    public a() {
        this.f9840b = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.r.a.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                cn.jpush.android.l.a.a((Context) null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(a.this.f9839a);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                b.h("JUnionAdRunnable", sb.toString());
            }
        };
    }

    public a(String str) {
        this.f9839a = str;
        this.f9840b = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.r.a.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                cn.jpush.android.l.a.a((Context) null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(a.this.f9839a);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                b.h("JUnionAdRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f9840b);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
