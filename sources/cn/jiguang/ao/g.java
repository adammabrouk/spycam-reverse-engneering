package cn.jiguang.ao;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8278a = cn.jiguang.p.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 118, 102, 112, 120, 87, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 1, 15, 111, 109, 100, 98, 89, 79, 119, 37, 117, 121, 85, 67, 114});

    /* renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f8279b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static long f8280c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f8281d = null;

    /* renamed from: e, reason: collision with root package name */
    public static JSONObject f8282e = null;

    public static class a extends cn.jiguang.bj.b {

        /* renamed from: a, reason: collision with root package name */
        public Context f8283a;

        public a(Context context) {
            this.f8283a = context;
            this.f8813h = "JLimitConfig";
        }

        private int a(Context context) {
            String a2;
            int i2;
            StringBuilder sb;
            try {
                a2 = cn.jiguang.ao.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a2)) {
                cn.jiguang.as.d.g("JLimitConfig", "request bannedConfig failed because can't get appKey");
                JSONObject unused2 = g.f8282e = null;
                return -1;
            }
            String str = g.f8278a;
            if (g.f8282e != null && g.f8282e.length() > 0) {
                g.f8282e.put("appkey", a2);
                g.f8282e.put(JThirdPlatFormInterface.KEY_PLATFORM, "android");
            }
            cn.jiguang.as.d.c("JLimitConfig", "request url: " + str + ", param json:" + g.f8282e.toString());
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.as.d.g("JLimitConfig", "can't get url, give up upload");
                JSONObject unused3 = g.f8282e = null;
                return -1;
            }
            cn.jiguang.au.g a3 = cn.jiguang.au.b.a(str, g.f8282e.toString(), context, false, 3, 3);
            int a4 = a3.a();
            String b2 = a3.b();
            cn.jiguang.as.d.c("JLimitConfig", "code: " + a4 + ", responseBody:" + b2);
            int a5 = a3.a();
            if (a5 != -3) {
                if (a5 == -1) {
                    sb = new StringBuilder();
                    sb.append("upload");
                    sb.append(g.f8282e.toString());
                    sb.append(" error:");
                    sb.append(a3.b());
                } else if (a5 != 0) {
                    sb = new StringBuilder();
                    sb.append("upload");
                    sb.append(g.f8282e.toString());
                    sb.append(" failed");
                } else {
                    if (!TextUtils.isEmpty(b2)) {
                        g.b(context, new JSONObject(b2));
                    }
                    i2 = 0;
                }
                cn.jiguang.as.d.c("JLimitConfig", sb.toString());
                JSONObject unused4 = g.f8282e = null;
                return -1;
            }
            i2 = -2;
            JSONObject unused5 = g.f8282e = null;
            return i2;
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            cn.jiguang.as.d.c("JLimitConfig", "start request sdk limit config");
            int a2 = a(this.f8283a);
            if (a2 != 0) {
                cn.jiguang.as.d.g("JLimitConfig", "request limit config failed, code: " + a2);
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "save sdk limit status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_limit_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKDeveloperIdLimitHelper", "[saveSdkLimitStatus] parse json error, " + th.getMessage());
        }
    }

    public static void a(Context context, boolean z, long j) {
        f8280c = j;
        if (f8279b.get() != z) {
            cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "sdk limit status changed, update status, sdkLimit: " + z);
            if (!z) {
                f8279b = new AtomicBoolean(z);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z) {
            cn.jiguang.as.d.i("JSDKDeveloperIdLimitHelper", "sdk is limit...");
        }
        f8279b = new AtomicBoolean(z);
        cn.jiguang.as.d.e("JSDKDeveloperIdLimitHelper", "sdk limit status, limit: " + z + ", nextTime: " + f8280c);
    }

    public static boolean a() {
        Context appContext;
        f8282e = new JSONObject();
        if (!ActionManager.getInstance().wrapSdkTypeVersionInfo(f8282e)) {
            f8282e = null;
        } else if (f8281d == null && (appContext = JConstants.getAppContext(null)) != null) {
            cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "[isSDKLimit] first request limit config");
            return a(appContext);
        }
        return f8279b.get();
    }

    public static boolean a(int i2) {
        return i2 == 1 || i2 == 4 || i2 == 5 || i2 == 3;
    }

    public static synchronized boolean a(Context context) {
        synchronized (g.class) {
            if (f8281d != null) {
                return f8279b.get();
            }
            f8281d = true;
            b(context);
            if (System.currentTimeMillis() > f8280c) {
                cn.jiguang.bj.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (f8279b.get()) {
                    cn.jiguang.as.d.i("JSDKDeveloperIdLimitHelper", "sdk is limit...");
                }
                cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "request sdk limit config not time up, not request");
            }
            return f8279b.get();
        }
    }

    public static int b() {
        return !TextUtils.isEmpty(cn.jiguang.a.a.f8100d) ? 4 : 2;
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean z = true;
            if (jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE) != 1) {
                z = false;
            }
            long optLong = jSONObject.optLong("nexttime", 43200L);
            cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "from server sdk limit status: " + z + ", next request time: " + optLong);
            if (optLong <= 0) {
                optLong = 0;
            }
            if (optLong >= 86400) {
                optLong = 86400;
            }
            long currentTimeMillis = System.currentTimeMillis() + (optLong * 1000);
            a(context, z + "," + currentTimeMillis);
            a(context, z, currentTimeMillis);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKDeveloperIdLimitHelper", "parse sdk limit config failed, " + th.getMessage());
        }
    }

    public static boolean b(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_limit_status", "");
            cn.jiguang.as.d.e("JSDKDeveloperIdLimitHelper", "local sdk limit config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.as.d.c("JSDKDeveloperIdLimitHelper", "local limit config, isLimit: " + parseBoolean + ", nextReqTime: " + parseLong);
                f8280c = parseLong;
                f8279b = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKDeveloperIdLimitHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }
}
