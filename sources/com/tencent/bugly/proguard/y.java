package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CrashHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f11212a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f11213b = true;

    /* renamed from: c, reason: collision with root package name */
    public static SimpleDateFormat f11214c = null;

    /* renamed from: d, reason: collision with root package name */
    public static int f11215d = 30720;

    /* renamed from: e, reason: collision with root package name */
    public static StringBuilder f11216e = null;

    /* renamed from: f, reason: collision with root package name */
    public static StringBuilder f11217f = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f11218g = false;

    /* renamed from: h, reason: collision with root package name */
    public static a f11219h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f11220i = null;
    public static String j = null;
    public static Context k = null;
    public static String l = null;
    public static boolean m = false;
    public static boolean n = false;
    public static ExecutorService o;
    public static int p;
    public static final Object q = new Object();

    /* compiled from: BUGLY */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11224a;

        /* renamed from: b, reason: collision with root package name */
        public File f11225b;

        /* renamed from: c, reason: collision with root package name */
        public String f11226c;

        /* renamed from: d, reason: collision with root package name */
        public long f11227d;

        /* renamed from: e, reason: collision with root package name */
        public long f11228e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f11226c = str;
            this.f11224a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f11226c);
                this.f11225b = file;
                if (file.exists() && !this.f11225b.delete()) {
                    this.f11224a = false;
                    return false;
                }
                if (this.f11225b.createNewFile()) {
                    return true;
                }
                this.f11224a = false;
                return false;
            } catch (Throwable th) {
                x.a(th);
                this.f11224a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f11224a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f11225b, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f11227d += r10.length;
                this.f11224a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    x.a(th);
                    this.f11224a = false;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    static {
        try {
            f11214c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (y.class) {
            if (m || context == null || !f11212a) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f11217f = new StringBuilder(0);
                f11216e = new StringBuilder(0);
                k = context;
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                f11220i = a2.f10873d;
                a2.getClass();
                j = "";
                l = k.getFilesDir().getPath() + "/buglylog_" + f11220i + "_" + j + CrashHandler.FILE_NAME_SUFFIX;
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    public static synchronized void c(String str, String str2, String str3) {
        synchronized (y.class) {
            if (f11213b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    public static synchronized void d(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f11217f.append(a2);
                    if (f11217f.length() >= f11215d) {
                        f11217f = f11217f.delete(0, f11217f.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    public static synchronized void e(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f11217f.append(a2);
                } catch (Throwable unused) {
                }
                if (f11217f.length() <= f11215d) {
                    return;
                }
                if (f11218g) {
                    return;
                }
                f11218g = true;
                if (f11219h == null) {
                    f11219h = new a(l);
                } else if (f11219h.f11225b == null || f11219h.f11225b.length() + f11217f.length() > f11219h.f11228e) {
                    f11219h.a();
                }
                if (f11219h.a(f11217f.toString())) {
                    f11217f.setLength(0);
                    f11218g = false;
                }
            }
        }
    }

    public static byte[] b() {
        if (!f11212a) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            if (f11219h != null && f11219h.f11224a && f11219h.f11225b != null && f11219h.f11225b.length() > 0) {
                sb.append(z.a(f11219h.f11225b, 30720, true));
            }
            if (f11217f != null && f11217f.length() > 0) {
                sb.append(f11217f.toString());
            }
        }
        return z.a((File) null, sb.toString(), "BuglyLog.txt");
    }

    public static void a(int i2) {
        synchronized (q) {
            f11215d = i2;
            if (i2 < 0) {
                f11215d = 0;
            } else if (i2 > 30720) {
                f11215d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + z.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (y.class) {
            if (m && f11212a) {
                try {
                    o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            y.c(str, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
        }
    }

    public static String a(String str, String str2, String str3, long j2) {
        String date;
        f11216e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f11214c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f11216e;
        sb.append(date);
        sb.append(LogUtils.PLACEHOLDER);
        sb.append(p);
        sb.append(LogUtils.PLACEHOLDER);
        sb.append(j2);
        sb.append(LogUtils.PLACEHOLDER);
        sb.append(str);
        sb.append(LogUtils.PLACEHOLDER);
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f11216e.toString();
    }

    public static byte[] a() {
        if (f11213b) {
            if (f11212a) {
                return z.a((File) null, f11217f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }
}
