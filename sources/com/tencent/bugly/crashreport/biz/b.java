package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a.AnonymousClass2;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f10855a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f10856b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f10857c = 10;

    /* renamed from: d, reason: collision with root package name */
    public static long f10858d = 300000;

    /* renamed from: e, reason: collision with root package name */
    public static long f10859e = 30000;

    /* renamed from: f, reason: collision with root package name */
    public static long f10860f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f10861g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static long f10862h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static long f10863i = 0;
    public static long j = 0;
    public static Application.ActivityLifecycleCallbacks k = null;
    public static Class<?> l = null;
    public static boolean m = true;

    public static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + OSSUtils.NEW_LINE;
    }

    public static /* synthetic */ int g() {
        int i2 = f10861g;
        f10861g = i2 + 1;
        return i2;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (f10856b) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f10874e;
        m = z;
        f10855a = new a(context, z);
        f10856b = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, buglyStrategy);
                }
            }, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
        }
        f10860f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w a2;
        a aVar = f10855a;
        if (aVar != null && !z && (a2 = w.a()) != null) {
            a2.a(aVar.new AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.o;
        if (j2 > 0) {
            f10859e = j2;
        }
        int i2 = strategyBean.t;
        if (i2 > 0) {
            f10857c = i2;
        }
        long j3 = strategyBean.u;
        if (j3 > 0) {
            f10858d = j3;
        }
    }

    public static void a() {
        a aVar = f10855a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!f10856b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k != null) {
                        application.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        f10856b = false;
    }
}
