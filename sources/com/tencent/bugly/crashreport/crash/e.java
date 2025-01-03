package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h, reason: collision with root package name */
    public static String f10992h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f10993i = new Object();

    /* renamed from: a, reason: collision with root package name */
    public Context f10994a;

    /* renamed from: b, reason: collision with root package name */
    public b f10995b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.bugly.crashreport.common.strategy.a f10996c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.bugly.crashreport.common.info.a f10997d;

    /* renamed from: e, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f10998e;

    /* renamed from: f, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f10999f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11000g = false;
    public int j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.f10994a = context;
        this.f10995b = bVar;
        this.f10996c = aVar;
        this.f10997d = aVar2;
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f11000g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f10999f = defaultUncaughtExceptionHandler;
                this.f10998e = defaultUncaughtExceptionHandler;
            } else {
                x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f10998e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        x.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f11000g = false;
        x.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f10998e);
            this.j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f10993i) {
            a(thread, th, true, null, null);
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String a2;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m = c.a().m();
        String str2 = (m && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m && z) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.F = this.f10997d.l();
        crashDetailBean.G = this.f10997d.k();
        crashDetailBean.H = this.f10997d.m();
        crashDetailBean.w = z.a(this.f10994a, c.f10967e, (String) null);
        byte[] a3 = y.a();
        crashDetailBean.y = a3;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(a3 == null ? 0 : a3.length);
        x.a("user log size:%d", objArr);
        crashDetailBean.f10908b = z ? 0 : 2;
        crashDetailBean.f10911e = this.f10997d.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f10997d;
        crashDetailBean.f10912f = aVar.j;
        crashDetailBean.f10913g = aVar.r();
        crashDetailBean.m = this.f10997d.g();
        String name = th.getClass().getName();
        String b2 = b(th, 1000);
        if (b2 == null) {
            b2 = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.n = th2.getClass().getName();
            String b3 = b(th2, 1000);
            crashDetailBean.o = b3;
            if (b3 == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(b2);
            sb.append(OSSUtils.NEW_LINE);
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append(OSSUtils.NEW_LINE);
            a2 = a(th2, c.f10968f);
            sb.append(a2);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            String str3 = b2 + str2;
            crashDetailBean.o = str3;
            if (str3 == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = stackTraceElement;
            a2 = a(th, c.f10968f);
            crashDetailBean.q = a2;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = z.a(c.f10968f, false);
            crashDetailBean.A = this.f10997d.f10873d;
            String str4 = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.B = str4;
            crashDetailBean.z.put(str4, a2);
            crashDetailBean.I = this.f10997d.t();
            crashDetailBean.f10914h = this.f10997d.q();
            crashDetailBean.f10915i = this.f10997d.C();
            crashDetailBean.M = this.f10997d.f10870a;
            crashDetailBean.N = this.f10997d.a();
            if (z) {
                this.f10995b.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.O = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.U = bArr;
                }
            }
            crashDetailBean.Q = this.f10997d.A();
            crashDetailBean.R = this.f10997d.B();
            crashDetailBean.S = this.f10997d.u();
            crashDetailBean.T = this.f10997d.z();
        } catch (Throwable th3) {
            x.e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    public static boolean a(Thread thread) {
        synchronized (f10993i) {
            if (f10992h != null && thread.getName().equals(f10992h)) {
                return true;
            }
            f10992h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            x.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                x.a("this class has handled this exception", new Object[0]);
                if (this.f10999f != null) {
                    x.a("call system handler", new Object[0]);
                    this.f10999f.uncaughtException(thread, th);
                } else {
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            x.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f11000g) {
                x.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f10998e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f10998e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10999f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f10999f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f10996c.b()) {
                x.d("no remote but still store!", new Object[0]);
            }
            if (!this.f10996c.c().f10886e && this.f10996c.b()) {
                x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f10997d.f10873d, thread.getName(), z.a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f10998e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f10998e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10999f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f10999f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b2 = b(thread, th, z, str, bArr);
            if (b2 == null) {
                x.e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f10998e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f10998e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f10999f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f10999f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f10997d.f10873d, thread.getName(), z.a(th), b2);
            if (!this.f10995b.a(b2)) {
                this.f10995b.a(b2, NetworkUtils.SCAN_PERIOD_MILLIS, z);
            }
            if (z) {
                this.f10995b.c(b2);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f10998e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    x.e("sys default last handle start!", new Object[0]);
                    this.f10998e.uncaughtException(thread, th);
                    x.e("sys default last handle end!", new Object[0]);
                } else if (this.f10999f != null) {
                    x.e("system handle start!", new Object[0]);
                    this.f10999f.uncaughtException(thread, th);
                    x.e("system handle end!", new Object[0]);
                } else {
                    x.e("crashreport last handle start!", new Object[0]);
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    x.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f10998e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f10998e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f10999f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f10999f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f10998e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f10998e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f10999f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f10999f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    public static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    public static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f10886e != this.f11000g) {
                x.a("java changed to %b", Boolean.valueOf(strategyBean.f10886e));
                if (strategyBean.f10886e) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    public static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append(OSSUtils.NEW_LINE);
                }
            }
        } catch (Throwable th2) {
            x.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }
}
