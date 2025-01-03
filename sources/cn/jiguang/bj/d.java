package cn.jiguang.bj;

import cn.jiguang.ao.f;
import cn.jiguang.ao.g;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, ExecutorService> f8819a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f8820b;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f8820b = hashMap;
        hashMap.put("SDK_INIT", "ic");
        f8820b.put("SDK_SERVICE_INIT", "mn");
        f8820b.put("TCP_CONN_TASK", "tc");
        f8820b.put("UPLOAD_REPORT", "rp");
        f8820b.put("ONCE_TASK", "oc");
        f8820b.put("SCHEDULE_TASK", "sc");
        f8820b.put("MAJOR_TASK", "mj");
        f8820b.put("NORMAL_TASK", "nr");
        f8820b.put("FUTURE_TASK", "fr");
        f8820b.put("DELAY_TASK", "dl");
    }

    public static void a(String str) {
        try {
            a(c(str));
        } catch (Throwable th) {
            cn.jiguang.as.d.i("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 0, true);
    }

    public static void a(String str, Runnable runnable, int i2) {
        a(str, runnable, i2, true);
    }

    public static void a(String str, Runnable runnable, int i2, boolean z) {
        if (z) {
            try {
                if (f.a() || g.a()) {
                    return;
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.i("SDKWorker_XExecutor", "execute failed, try again e:" + th);
                return;
            }
        }
        ExecutorService c2 = c(str);
        if (c2 != null) {
            if (i2 <= 0 || !(c2 instanceof ScheduledExecutorService)) {
                c2.execute(runnable);
            } else {
                ((ScheduledExecutorService) c2).schedule(runnable, i2, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            if (executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                return;
            }
            cn.jiguang.as.d.a("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            cn.jiguang.as.d.a("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            cn.jiguang.as.d.g("SDKWorker_XExecutor", "shutDown e:" + th);
        }
    }

    public static boolean b(String str) {
        try {
            ExecutorService c2 = c(str);
            if (c2 == null || c2.isShutdown()) {
                return false;
            }
            return !c2.isTerminated();
        } catch (Throwable th) {
            cn.jiguang.as.d.i("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r4 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.ExecutorService c(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bj.d.c(java.lang.String):java.util.concurrent.ExecutorService");
    }
}
