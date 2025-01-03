package cn.jiguang.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.as.d;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static a f8613b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static int f8614c = MemoryConstants.MB;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8615a;

    /* renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8616d = null;

    /* renamed from: e, reason: collision with root package name */
    public final Object f8617e = new Object();

    public a() {
        this.f8615a = true;
        this.f8615a = ((Boolean) cn.jiguang.f.b.a(JConstants.getAppContext(null), cn.jiguang.f.a.b())).booleanValue();
    }

    public static a a() {
        return f8613b;
    }

    private JSONArray a(Context context, Throwable th) {
        String d2 = cn.jiguang.e.c.d(cn.jiguang.e.c.a(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int i2 = 0;
        if (!TextUtils.isEmpty(d2)) {
            try {
                JSONArray jSONArray2 = new JSONArray(d2);
                try {
                    i2 = d2.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i2, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i2, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + cn.jiguang.d.b.c(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i3 = 0;
        while (true) {
            jSONObject = null;
            try {
                if (i3 >= jSONArray.length()) {
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i3);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i3++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", b(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", cn.jiguang.e.a.l(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? LogUtils.NULL : packageInfo.versionName;
                String str2 = packageInfo.versionCode + "";
                jSONObject2.put("versionname", str);
                jSONObject2.put("versioncode", str2);
            }
            if (i2 + jSONObject2.toString().length() < f8614c) {
                jSONArray.put(jSONObject2);
            } else {
                long j = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("crashtime");
                        if (j == -1 || optLong < j) {
                            i4 = i5;
                            j = optLong;
                        }
                    }
                }
                jSONArray.put(i4, jSONObject2);
            }
        }
        return jSONArray;
    }

    private void a(Context context, JSONArray jSONArray) {
        File a2;
        String jSONArray2 = jSONArray != null ? jSONArray.toString() : null;
        if (TextUtils.isEmpty(jSONArray2) || (a2 = cn.jiguang.e.c.a(context, "jpush_uncaughtexception_file")) == null) {
            return;
        }
        cn.jiguang.e.c.c(a2, jSONArray2);
    }

    private void a(Throwable th) {
        if (this.f8615a) {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                d.i("JPushCrashHandler", "handleException failed: context is null");
                return;
            }
            JSONArray a2 = a(appContext, th);
            d(appContext);
            a(appContext, a2);
        }
    }

    private String b(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length <= 1) {
                return th2;
            }
            for (int length = split.length - 1; length >= 0; length--) {
                if (!split[length].endsWith("Exception") && !split[length].endsWith("Error")) {
                }
                return split[length];
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    public static JSONArray c(Context context) {
        String d2 = cn.jiguang.e.c.d(cn.jiguang.e.c.a(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        try {
            return new JSONArray(d2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void d(Context context) {
        if (context == null) {
            d.g("JPushCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            cn.jiguang.e.c.a(cn.jiguang.e.c.a(context, "jpush_uncaughtexception_file"));
        }
    }

    public final void a(long j) {
        synchronized (this.f8617e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (j == 0) {
                while (cn.jiguang.bj.d.b("FUTURE_TASK")) {
                    this.f8617e.wait(0L);
                }
            } else {
                long j2 = 0;
                while (cn.jiguang.bj.d.b("FUTURE_TASK")) {
                    long j3 = j - j2;
                    if (j3 <= 0) {
                        break;
                    }
                    this.f8617e.wait(j3);
                    j2 = System.currentTimeMillis() - currentTimeMillis;
                }
            }
        }
    }

    public void a(Context context) {
        if (this.f8615a) {
            return;
        }
        this.f8615a = true;
        d.c("JPushCrashHandler", "init caughtException");
        cn.jiguang.f.b.a(JConstants.getAppContext(context), (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.b().a((cn.jiguang.f.a<Boolean>) true)});
    }

    public void b() {
        if (this.f8616d == null) {
            this.f8616d = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b(Context context) {
        if (this.f8615a) {
            d.c("JPushCrashHandler", "stop caughtException");
            this.f8615a = false;
            cn.jiguang.f.b.a(JConstants.getAppContext(context), (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.b().a((cn.jiguang.f.a<Boolean>) false)});
        }
    }

    public void e(Context context) {
        if (context == null) {
            d.g("JPushCrashHandler", "Action - reportCrashLog context is null");
            return;
        }
        if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.bj.d.a("FUTURE_TASK", new b());
            } catch (Throwable th) {
                d.i("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f8615a) {
            d.a("JPushCrashHandler", "enable crash report");
            a(th);
            try {
                cn.jiguang.bj.d.a("FUTURE_TASK", new b());
                a(2000L);
            } catch (Throwable th2) {
                d.i("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            d.a("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8616d;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
