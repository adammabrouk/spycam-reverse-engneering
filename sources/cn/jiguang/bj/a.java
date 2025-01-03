package cn.jiguang.bj;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    public int f8808a;

    /* renamed from: b, reason: collision with root package name */
    public String f8809b;

    /* renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f8810c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f8811d;

    public a(String str, int i2) {
        this.f8809b = str;
        if (i2 <= 0) {
            this.f8808a = 3;
        }
        this.f8808a = i2;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        cn.jiguang.as.d.c("JRejectedExecutionHandler", "poolName: " + this.f8809b + ", Exceeded ThreadPoolExecutor pool size");
        if (this.f8810c == null) {
            synchronized (this) {
                if (this.f8810c == null) {
                    this.f8811d = new LinkedBlockingQueue<>();
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(this.f8808a, this.f8808a, 3L, TimeUnit.SECONDS, this.f8811d, new c(this.f8809b + "_rjt"));
                    this.f8810c = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        this.f8810c.execute(runnable);
    }
}
