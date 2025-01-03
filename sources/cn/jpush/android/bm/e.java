package cn.jpush.android.bm;

import cn.jiguang.api.JCoreManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.Thread;

/* loaded from: classes.dex */
public abstract class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f9665a;

    /* renamed from: f, reason: collision with root package name */
    public String f9666f;

    public e() {
        this.f9665a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.bm.e.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(e.this.f9666f);
                sb.append(", thread id:");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public e(String str) {
        this.f9666f = str;
        this.f9665a = new Thread.UncaughtExceptionHandler() { // from class: cn.jpush.android.bm.e.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
                StringBuilder sb = new StringBuilder();
                sb.append("name: ");
                sb.append(e.this.f9666f);
                sb.append(", thread id: ");
                sb.append(thread != null ? thread.getName() : "");
                sb.append("-");
                sb.append(thread != null ? Long.valueOf(thread.getId()) : "");
                sb.append("\n e:");
                sb.append(th);
                Logger.e("JPushRunnable", sb.toString());
            }
        };
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f9665a);
        a();
        Thread.currentThread().setUncaughtExceptionHandler(null);
    }
}
