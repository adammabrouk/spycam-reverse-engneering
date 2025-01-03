package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f10891a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static a f10892b;

    /* renamed from: h, reason: collision with root package name */
    public static String f10893h;

    /* renamed from: c, reason: collision with root package name */
    public final List<com.tencent.bugly.a> f10894c;

    /* renamed from: d, reason: collision with root package name */
    public final w f10895d;

    /* renamed from: e, reason: collision with root package name */
    public final StrategyBean f10896e;

    /* renamed from: f, reason: collision with root package name */
    public StrategyBean f10897f = null;

    /* renamed from: g, reason: collision with root package name */
    public Context f10898g;

    public a(Context context, List<com.tencent.bugly.a> list) {
        String str;
        this.f10898g = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str2 = com.tencent.bugly.crashreport.common.info.a.a(context).y;
            if (!"oversea".equals(str2)) {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.qcloud.com/rqd/async";
            }
            StrategyBean.f10882a = str;
            StrategyBean.f10883b = str;
        }
        this.f10896e = new StrategyBean();
        this.f10894c = list;
        this.f10895d = w.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<r> a2 = p.a().a(2);
        if (a2 == null || a2.size() <= 0 || (bArr = a2.get(0).f11180g) == null) {
            return null;
        }
        return (StrategyBean) z.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f10897f;
        if (strategyBean != null) {
            if (!z.c(strategyBean.p)) {
                this.f10897f.p = StrategyBean.f10882a;
            }
            if (!z.c(this.f10897f.q)) {
                this.f10897f.q = StrategyBean.f10883b;
            }
            return this.f10897f;
        }
        if (!z.a(f10893h) && z.c(f10893h)) {
            StrategyBean strategyBean2 = this.f10896e;
            String str = f10893h;
            strategyBean2.p = str;
            strategyBean2.q = str;
        }
        return this.f10896e;
    }

    public final synchronized boolean b() {
        return this.f10897f != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (f10892b == null) {
                f10892b = new a(context, list);
            }
            aVar = f10892b;
        }
        return aVar;
    }

    public final void a(long j) {
        this.f10895d.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a2 = p.a().a(a.f10891a, (o) null, true);
                    if (a2 != null) {
                        byte[] bArr = a2.get("device");
                        byte[] bArr2 = a2.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f10898g).f(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f10898g).e(new String(bArr2));
                        }
                    }
                    a.this.f10897f = a.d();
                    if (a.this.f10897f != null) {
                        if (z.a(a.f10893h) || !z.c(a.f10893h)) {
                            a.this.f10897f.p = StrategyBean.f10882a;
                            a.this.f10897f.q = StrategyBean.f10883b;
                        } else {
                            a.this.f10897f.p = a.f10893h;
                            a.this.f10897f.q = a.f10893h;
                        }
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f10897f, false);
            }
        }, j);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = f10892b;
        }
        return aVar;
    }

    public final void a(StrategyBean strategyBean, boolean z) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f10894c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!z.a(str) && z.c(str)) {
            f10893h = str;
        } else {
            x.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(ap apVar) {
        if (apVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f10897f;
        if (strategyBean == null || apVar.f11098h != strategyBean.n) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f10886e = apVar.f11091a;
            strategyBean2.f10888g = apVar.f11093c;
            strategyBean2.f10887f = apVar.f11092b;
            if (z.a(f10893h) || !z.c(f10893h)) {
                if (z.c(apVar.f11094d)) {
                    x.c("[Strategy] Upload url changes to %s", apVar.f11094d);
                    strategyBean2.p = apVar.f11094d;
                }
                if (z.c(apVar.f11095e)) {
                    x.c("[Strategy] Exception upload url changes to %s", apVar.f11095e);
                    strategyBean2.q = apVar.f11095e;
                }
            }
            ao aoVar = apVar.f11096f;
            if (aoVar != null && !z.a(aoVar.f11089a)) {
                strategyBean2.r = apVar.f11096f.f11089a;
            }
            long j = apVar.f11098h;
            if (j != 0) {
                strategyBean2.n = j;
            }
            Map<String, String> map = apVar.f11097g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = apVar.f11097g;
                strategyBean2.s = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f10889h = true;
                } else {
                    strategyBean2.f10889h = false;
                }
                String str2 = apVar.f11097g.get("B3");
                if (str2 != null) {
                    strategyBean2.v = Long.valueOf(str2).longValue();
                }
                int i2 = apVar.f11099i;
                strategyBean2.o = i2;
                strategyBean2.u = i2;
                String str3 = apVar.f11097g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.t = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = apVar.f11097g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.j = true;
                } else {
                    strategyBean2.j = false;
                }
            }
            x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f10886e), Boolean.valueOf(strategyBean2.f10888g), Boolean.valueOf(strategyBean2.f10887f), Boolean.valueOf(strategyBean2.f10889h), Boolean.valueOf(strategyBean2.f10890i), Boolean.valueOf(strategyBean2.l), Boolean.valueOf(strategyBean2.m), Long.valueOf(strategyBean2.o), Boolean.valueOf(strategyBean2.j), Long.valueOf(strategyBean2.n));
            this.f10897f = strategyBean2;
            if (!z.c(apVar.f11094d)) {
                x.c("[Strategy] download url is null", new Object[0]);
                this.f10897f.p = "";
            }
            if (!z.c(apVar.f11095e)) {
                x.c("[Strategy] download crashurl is null", new Object[0]);
                this.f10897f.q = "";
            }
            p.a().b(2);
            r rVar = new r();
            rVar.f11175b = 2;
            rVar.f11174a = strategyBean2.f10884c;
            rVar.f11178e = strategyBean2.f10885d;
            rVar.f11180g = z.a(strategyBean2);
            p.a().a(rVar);
            a(strategyBean2, true);
        }
    }
}
