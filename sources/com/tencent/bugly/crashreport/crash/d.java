package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f10980a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.bugly.crashreport.common.strategy.a f10981b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.bugly.crashreport.common.info.a f10982c;

    /* renamed from: d, reason: collision with root package name */
    public b f10983d;

    /* renamed from: e, reason: collision with root package name */
    public Context f10984e;

    public d(Context context) {
        c a2 = c.a();
        if (a2 == null) {
            return;
        }
        this.f10981b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f10982c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f10983d = a2.p;
        this.f10984e = context;
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public static /* synthetic */ void a(d dVar) {
        x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.f10982c.getClass();
            z.a(cls, "sdkPackageName", "com.tencent.bugly", null);
            x.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            x.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(d dVar, Thread thread, int i2, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                x.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        x.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.f10981b.b()) {
                x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = dVar.f10981b.c();
            if (!c2.f10886e && dVar.f10981b.b()) {
                x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(str4, z.a(), dVar.f10982c.f10873d, currentThread.getName(), str + OSSUtils.NEW_LINE + str2 + OSSUtils.NEW_LINE + str3, null);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 == 5 || i2 == 6) {
                if (!c2.j) {
                    x.e("[ExtraCrashManager] %s report is disabled.", str4);
                    x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i2 == 8 && !c2.k) {
                x.e("[ExtraCrashManager] %s report is disabled.", str4);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i3 = i2 != 8 ? i2 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = dVar.f10982c.l();
            crashDetailBean.G = dVar.f10982c.k();
            crashDetailBean.H = dVar.f10982c.m();
            crashDetailBean.w = z.a(dVar.f10984e, c.f10967e, (String) null);
            crashDetailBean.f10908b = i3;
            crashDetailBean.f10911e = dVar.f10982c.h();
            crashDetailBean.f10912f = dVar.f10982c.j;
            crashDetailBean.f10913g = dVar.f10982c.r();
            crashDetailBean.m = dVar.f10982c.g();
            crashDetailBean.n = str;
            crashDetailBean.o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split(OSSUtils.NEW_LINE);
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.p = str5;
            crashDetailBean.q = str6;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
            crashDetailBean.z = z.a(c.f10968f, false);
            crashDetailBean.A = dVar.f10982c.f10873d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.I = dVar.f10982c.t();
            crashDetailBean.f10914h = dVar.f10982c.q();
            crashDetailBean.M = dVar.f10982c.f10870a;
            crashDetailBean.N = dVar.f10982c.a();
            if (!c.a().p()) {
                dVar.f10983d.d(crashDetailBean);
            }
            crashDetailBean.Q = dVar.f10982c.A();
            crashDetailBean.R = dVar.f10982c.B();
            crashDetailBean.S = dVar.f10982c.u();
            crashDetailBean.T = dVar.f10982c.z();
            crashDetailBean.y = y.a();
            if (crashDetailBean.O == null) {
                crashDetailBean.O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.O.putAll(map);
            }
            b.a(str4, z.a(), dVar.f10982c.f10873d, currentThread.getName(), str + OSSUtils.NEW_LINE + str2 + OSSUtils.NEW_LINE + str3, crashDetailBean);
            if (!dVar.f10983d.a(crashDetailBean)) {
                dVar.f10983d.a(crashDetailBean, NetworkUtils.SCAN_PERIOD_MILLIS, false);
            }
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static d a(Context context) {
        if (f10980a == null) {
            f10980a = new d(context);
        }
        return f10980a;
    }

    public static void a(final Thread thread, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.f10980a == null) {
                        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        d.a(d.f10980a, thread, i2, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
