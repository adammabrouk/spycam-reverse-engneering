package c.k.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import c.k.d.a7;
import c.k.d.n9;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.lang.Thread;

/* loaded from: classes.dex */
public class k1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f6854d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f6855e = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};

    /* renamed from: a, reason: collision with root package name */
    public Context f6856a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f6857b;

    /* renamed from: c, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f6858c;

    public k1(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public k1(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f6856a = context;
        this.f6858c = uncaughtExceptionHandler;
    }

    public final String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < Math.min(3, stackTrace.length); i2++) {
            sb.append(stackTrace[i2].toString() + "\r\n");
        }
        String sb2 = sb.toString();
        return TextUtils.isEmpty(sb2) ? "" : c.k.d.k0.a(sb2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m38a() {
        c.k.d.j.a(this.f6856a).a(new l1(this));
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m39a(Throwable th) {
        String b2 = b(th);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String a2 = a(th);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        h1.a(this.f6856a).a(b2, a2);
        if (m40a()) {
            m38a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m40a() {
        this.f6857b = this.f6856a.getSharedPreferences("mipush_extra", 4);
        if (c.k.d.e0.e(this.f6856a)) {
            if (c.k.d.p9.m.a(this.f6856a).a(a7.Crash4GUploadSwitch.a(), true)) {
                return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.f6857b.getLong("last_crash_upload_time_stamp", 0L))) >= ((float) Math.max(3600, c.k.d.p9.m.a(this.f6856a).a(a7.Crash4GUploadFrequency.a(), 3600))) * 0.9f;
            }
            return false;
        }
        if (c.k.d.e0.d(this.f6856a)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f6857b.getLong("last_crash_upload_time_stamp", 0L)) >= ((long) Math.max(60, c.k.d.p9.m.a(this.f6856a).a(a7.CrashWIFIUploadFrequency.a(), 1800)));
        }
        return true;
    }

    public final boolean a(boolean z, String str) {
        for (String str2 : f6855e) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z;
    }

    public final String b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(th.toString());
        sb.append("\r\n");
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            z = a(z, stackTraceElement2);
            sb.append(stackTraceElement2);
            sb.append("\r\n");
        }
        return z ? sb.toString() : "";
    }

    public final void b() {
        SharedPreferences sharedPreferences = this.f6856a.getSharedPreferences("mipush_extra", 4);
        this.f6857b = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        n9.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m39a(th);
        synchronized (f6854d) {
            try {
                f6854d.wait(NetworkUtils.SCAN_PERIOD_MILLIS);
            } catch (InterruptedException e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6858c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}
