package cn.jiguang.ao;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8273a = cn.jiguang.p.a.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, 31, 83, 109, 105, 98, 100, 67});

    /* renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f8274b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static long f8275c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f8276d = null;

    public static class a extends cn.jiguang.bj.b {

        /* renamed from: a, reason: collision with root package name */
        public Context f8277a;

        public a(Context context) {
            this.f8277a = context;
            this.f8813h = "JBannedConfig";
        }

        private int a(Context context) {
            String a2;
            StringBuilder sb;
            try {
                a2 = cn.jiguang.ao.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a2)) {
                cn.jiguang.as.d.g("JBannedConfig", "request bannedConfig failed because can't get appKey");
                return -1;
            }
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
            String str = f.f8273a;
            String uuid = UUID.randomUUID().toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", a2);
            jSONObject.put("uid", longValue);
            jSONObject.put("stoken", uuid);
            cn.jiguang.as.d.c("JBannedConfig", "request url: " + str + ", param json:" + jSONObject.toString());
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.as.d.g("JBannedConfig", "can't get url, give up upload");
                return -1;
            }
            cn.jiguang.au.g a3 = cn.jiguang.au.b.a(str, jSONObject.toString(), context, false, 3, 3);
            int a4 = a3.a();
            String b2 = a3.b();
            cn.jiguang.as.d.c("JBannedConfig", "code: " + a4 + ", responseBody:" + b2);
            int a5 = a3.a();
            if (a5 == -3) {
                return -2;
            }
            if (a5 == -1) {
                sb = new StringBuilder();
                sb.append("upload");
                sb.append(jSONObject.toString());
                sb.append(" error:");
                sb.append(a3.b());
            } else {
                if (a5 == 0) {
                    if (TextUtils.isEmpty(b2)) {
                        return 0;
                    }
                    String optString = new JSONObject(b2).optString("stoken");
                    if (uuid.equals(optString)) {
                        f.b(context, new JSONObject(b2));
                        return 0;
                    }
                    cn.jiguang.as.d.g("JBannedConfig", "banned config uuid not match, reqUuid: " + uuid + ", resUuid: " + optString);
                    return 0;
                }
                sb = new StringBuilder();
                sb.append("upload");
                sb.append(jSONObject.toString());
                sb.append(" failed");
            }
            cn.jiguang.as.d.c("JBannedConfig", sb.toString());
            return -1;
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            cn.jiguang.as.d.c("JBannedConfig", "start request sdk banned config");
            int a2 = a(this.f8277a);
            if (a2 != 0) {
                cn.jiguang.as.d.g("JBannedConfig", "request banned config failed, code: " + a2);
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.as.d.c("JSDKBannedHelper", "save sdk banned status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_banned_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKBannedHelper", "[saveBannedConfigJson] parse json error, " + th.getMessage());
        }
    }

    public static void a(Context context, boolean z, long j) {
        f8275c = j;
        if (f8274b.get() != z) {
            cn.jiguang.as.d.c("JSDKBannedHelper", "sdk banned status changed, update status, sdkBanned: " + z);
            if (!z) {
                f8274b = new AtomicBoolean(z);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z) {
            cn.jiguang.as.d.i("JSDKBannedHelper", "sdk is banned...");
        }
        f8274b = new AtomicBoolean(z);
        cn.jiguang.as.d.e("JSDKBannedHelper", "sdk banned status, banned: " + z + ", nextTime: " + f8275c);
    }

    public static boolean a() {
        Context appContext;
        if (f8276d != null || (appContext = JConstants.getAppContext(null)) == null) {
            return f8274b.get();
        }
        cn.jiguang.as.d.c("JSDKBannedHelper", "[isSDKBanned] first request banned config");
        return a(appContext);
    }

    public static synchronized boolean a(Context context) {
        synchronized (f.class) {
            if (f8276d != null) {
                return f8274b.get();
            }
            f8276d = true;
            b(context);
            if (System.currentTimeMillis() > f8275c) {
                cn.jiguang.bj.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (f8274b.get()) {
                    cn.jiguang.as.d.i("JSDKBannedHelper", "sdk is banned...");
                }
                cn.jiguang.as.d.c("JSDKBannedHelper", "request sdk banned config not time up, not request");
            }
            return f8274b.get();
        }
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("values");
            if (optJSONObject != null) {
                boolean equals = "banned".equals(optJSONObject.optString("status"));
                long optLong = optJSONObject.optLong("nexttime", 43200L);
                cn.jiguang.as.d.c("JSDKBannedHelper", "from server sdk banned status: " + equals + ", next request time: " + optLong);
                if (optLong <= 0) {
                    optLong = 0;
                }
                if (optLong >= 86400) {
                    optLong = 86400;
                }
                long currentTimeMillis = System.currentTimeMillis() + (optLong * 1000);
                a(context, equals + "," + currentTimeMillis);
                a(context, equals, currentTimeMillis);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKBannedHelper", "parse sdk banned config failed, " + th.getMessage());
        }
    }

    public static boolean b(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_banned_status", "");
            cn.jiguang.as.d.e("JSDKBannedHelper", "local sdk banned config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.as.d.c("JSDKBannedHelper", "local banned config, isBanned: " + parseBoolean + ", nextReqTime: " + parseLong);
                f8275c = parseLong;
                f8274b = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("JSDKBannedHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }
}
