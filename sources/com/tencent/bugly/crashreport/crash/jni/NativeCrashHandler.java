package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.NetworkUtils;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {

    /* renamed from: a, reason: collision with root package name */
    public static NativeCrashHandler f11017a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f11018b = 1;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean p = true;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11019c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.info.a f11020d;

    /* renamed from: e, reason: collision with root package name */
    public final w f11021e;

    /* renamed from: f, reason: collision with root package name */
    public NativeExceptionHandler f11022f;

    /* renamed from: g, reason: collision with root package name */
    public String f11023g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11024h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11025i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public com.tencent.bugly.crashreport.crash.b o;

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.f11019c = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f10872c + "/app_bugly";
        }
        this.o = bVar;
        this.f11023g = str;
        this.f11020d = aVar;
        this.f11021e = wVar;
        this.f11024h = z;
        this.f11022f = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f11017a == null) {
                f11017a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = f11017a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return p;
    }

    public static void setShouldHandleInJava(boolean z) {
        p = z;
        NativeCrashHandler nativeCrashHandler = f11017a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f11025i || this.j) && m && str != null && str2 != null && str3 != null) {
            try {
                if (this.j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f11021e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!z.a(NativeCrashHandler.this.f11019c, "native_record_lock", 10000L)) {
                    x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.p) {
                    NativeCrashHandler.a(NativeCrashHandler.this, 999, Bugly.SDK_IS_DEV);
                }
                CrashDetailBean a2 = b.a(NativeCrashHandler.this.f11019c, NativeCrashHandler.this.f11023g, NativeCrashHandler.this.f11022f);
                if (a2 != null) {
                    x.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.o.a(a2)) {
                        NativeCrashHandler.this.o.a(a2, NetworkUtils.SCAN_PERIOD_MILLIS, false);
                    }
                    b.a(false, NativeCrashHandler.this.f11023g);
                }
                NativeCrashHandler.this.a();
                z.b(NativeCrashHandler.this.f11019c, "native_record_lock");
            }
        });
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30 || i2 < 23) {
            return;
        }
        f11018b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f11023g;
    }

    public String getLogFromNative() {
        if ((!this.f11025i && !this.j) || !m) {
            return null;
        }
        try {
            return this.j ? getNativeLog() : (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            m = false;
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f11022f;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (f11018b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f10886e != this.k) {
                x.d("server native changed to %b", Boolean.valueOf(strategyBean.f10886e));
            }
        }
        boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().f10886e && this.l;
        if (z != this.k) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f11025i || this.j) && m && str != null && str2 != null) {
            try {
                if (this.j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f11023g);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f11023g = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : Bugly.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e2) {
            if (x.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().f10886e;
        }
        if (isUserOpened != this.k) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.j && !this.f11025i) {
            String str = "Bugly";
            boolean z = !z.a(this.f11020d.m);
            String str2 = this.f11020d.m;
            if (z) {
                str = str2;
            } else {
                this.f11020d.getClass();
            }
            boolean a2 = a(str, z);
            this.j = a2;
            if (a2 || this.f11025i) {
                a(this.f11024h);
                if (m) {
                    setNativeAppVersion(this.f11020d.j);
                    setNativeAppChannel(this.f11020d.l);
                    setNativeAppPackage(this.f11020d.f10872c);
                    setNativeUserId(this.f11020d.g());
                    setNativeIsAppForeground(this.f11020d.a());
                    setNativeLaunchTime(this.f11020d.f10870a);
                }
                return;
            }
            return;
        }
        a(this.f11024h);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.j) {
            testCrash();
        } else {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public native String unregist();

    public static /* synthetic */ boolean a(NativeCrashHandler nativeCrashHandler, int i2, String str) {
        return nativeCrashHandler.a(999, str);
    }

    private synchronized void c() {
        if (!this.k) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
                return;
            }
        } catch (Throwable unused) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.k = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
            this.j = false;
            this.f11025i = false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:41|(1:43)(16:69|(1:71)|45|46|(1:48)|49|(1:51)|53|(1:55)(1:67)|56|(1:58)(1:66)|59|(1:61)|62|63|64)|44|45|46|(0)|49|(0)|53|(0)(0)|56|(0)(0)|59|(0)|62|63|64) */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080 A[Catch: all -> 0x008e, TryCatch #3 {all -> 0x008e, blocks: (B:46:0x0076, B:48:0x0080, B:49:0x0082, B:51:0x008c), top: B:45:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #3 {all -> 0x008e, blocks: (B:46:0x0076, B:48:0x0080, B:49:0x0082, B:51:0x008c), top: B:45:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00cc, B:62:0x00e2, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5 A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00cc, B:62:0x00e2, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00cc, B:62:0x00e2, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00cc, B:62:0x00e2, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009a A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00cc, B:62:0x00e2, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(boolean r12) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f11017a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.l != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    public static boolean a(String str, boolean z) {
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    public final void a() {
        long b2 = z.b() - c.f10969g;
        long b3 = z.b() + JConstants.DAY;
        File file = new File(this.f11023g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    private boolean a(int i2, String str) {
        if (this.j && n) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                n = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
