package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f10963a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f10964b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f10965c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f10966d = true;

    /* renamed from: e, reason: collision with root package name */
    public static int f10967e = 20480;

    /* renamed from: f, reason: collision with root package name */
    public static int f10968f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static long f10969g = 604800000;

    /* renamed from: h, reason: collision with root package name */
    public static String f10970h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f10971i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    public static c r;
    public final b p;
    public final Context q;
    public final e s;
    public final NativeCrashHandler t;
    public com.tencent.bugly.crashreport.common.strategy.a u;
    public w v;
    public final com.tencent.bugly.crashreport.crash.anr.b w;
    public Boolean x;
    public int y = 31;
    public boolean z = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.c$2, reason: invalid class name */
    public class AnonymousClass2 extends Thread {
        public AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (!z.a(c.this.q, "local_crash_lock", 10000L)) {
                x.c("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            List<CrashDetailBean> a2 = c.this.p.a();
            if (a2 == null || a2.size() <= 0) {
                x.c("no crash need to be uploaded at this start", new Object[0]);
            } else {
                x.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                int size = a2.size();
                if (size > 20) {
                    ArrayList arrayList = new ArrayList();
                    Collections.sort(a2);
                    for (int i2 = 0; i2 < 20; i2++) {
                        arrayList.add(a2.get((size - 1) - i2));
                    }
                    list = arrayList;
                } else {
                    list = a2;
                }
                c.this.p.a(list, 0L, false, false, false);
            }
            z.b(c.this.q, "local_crash_lock");
        }
    }

    public c(int i2, Context context, w wVar, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        f10963a = i2;
        Context a2 = z.a(context);
        this.q = a2;
        this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.v = wVar;
        u a3 = u.a();
        p a4 = p.a();
        this.p = new b(i2, a2, a3, a4, this.u, aVar, oVar);
        com.tencent.bugly.crashreport.common.info.a a5 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new e(a2, this.p, this.u, a5);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a5, this.p, this.u, wVar, z, str);
        this.t = nativeCrashHandler;
        a5.D = nativeCrashHandler;
        this.w = com.tencent.bugly.crashreport.crash.anr.b.a(a2, this.u, a5, wVar, a4, this.p, aVar);
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        this.w.a(true);
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        this.w.a(false);
    }

    public final void e() {
        this.s.b();
    }

    public final void f() {
        this.s.a();
    }

    public final void g() {
        this.t.setUserOpened(false);
    }

    public final void h() {
        this.t.setUserOpened(true);
    }

    public final void i() {
        this.w.a(true);
    }

    public final void j() {
        this.w.a(false);
    }

    public final void k() {
        this.t.enableCatchAnrTrace();
    }

    public final synchronized void l() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    z.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean m() {
        return this.w.a();
    }

    public final void n() {
        this.t.checkUploadRecordCrash();
    }

    public final void o() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f10873d.equals(AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final boolean p() {
        return this.z;
    }

    public final boolean q() {
        return (this.y & 16) > 0;
    }

    public final boolean r() {
        return (this.y & 8) > 0;
    }

    public final boolean s() {
        return (this.y & 4) > 0;
    }

    public final boolean t() {
        return (this.y & 2) > 0;
    }

    public final boolean u() {
        return (this.y & 1) > 0;
    }

    public static synchronized c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            if (r == null) {
                r = new c(CrashModule.MODULE_ID, context, w.a(), z, aVar, null, null);
            }
            cVar = r;
        }
        return cVar;
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f10873d;
        List<r> a2 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || a2.size() <= 0) {
            this.x = false;
            return false;
        }
        for (r rVar : a2) {
            if (str.equals(rVar.f11176c)) {
                this.x = true;
                arrayList.add(rVar);
            }
        }
        if (arrayList.size() > 0) {
            p.a().a(arrayList);
        }
        return true;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.c();
        w.a().a(new AnonymousClass2(), NetworkUtils.SCAN_PERIOD_MILLIS);
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public final void a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        final boolean z3 = false;
        final String str2 = null;
        final byte[] bArr2 = null;
        this.v.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(z3));
                    c.this.s.a(thread, th, false, str2, bArr2);
                    if (z2) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.q).v();
                    }
                } catch (Throwable th2) {
                    if (!x.b(th2)) {
                        th2.printStackTrace();
                    }
                    x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public final void a(long j2) {
        w.a().a(new AnonymousClass2(), j2);
    }

    public final void a(int i2) {
        this.y = i2;
    }

    public final void a(boolean z) {
        this.z = z;
    }
}
