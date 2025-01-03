package cn.jpush.android.at;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.bm.j;
import cn.jpush.android.bm.k;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.t.a;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f9325a = "";

    /* renamed from: b, reason: collision with root package name */
    public static List<String> f9326b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public static List<String> f9327c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public static AtomicBoolean f9328d = new AtomicBoolean(false);

    public static class a extends cn.jpush.android.bm.e {

        /* renamed from: a, reason: collision with root package name */
        public Context f9329a;

        public a(Context context) {
            this.f9329a = context;
        }

        private synchronized void a(Context context) {
            if (context == null) {
                cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "unexcept error context is null");
                return;
            }
            if (!b(context)) {
                cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "need not black config request");
                return;
            }
            String d2 = d(this.f9329a);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            a(context, d2);
        }

        private void a(Context context, String str) {
            b.a(context, str);
            cn.jpush.android.o.b.b(context, str);
            b.f9328d.set(true);
        }

        private boolean b(Context context) {
            String str;
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                str = "sdk is banned not request config";
            } else {
                if (System.currentTimeMillis() - ((Long) Sp.get(context, Key.BlackPagesLastReqTime())).longValue() >= ((Long) Sp.get(context, Key.BlackPagesInternalTime())).longValue() * 1000) {
                    return true;
                }
                str = "not config request internal time";
            }
            cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", str);
            return false;
        }

        private JSONObject c(Context context) {
            try {
                String appKey = JCoreHelper.getAppKey(context);
                if (TextUtils.isEmpty(appKey)) {
                    cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "request black page list config failed because can't get appKey");
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", appKey);
                jSONObject.put("uid", JCoreHelper.getUid(context));
                jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, c.a.a.j.a.o);
                return jSONObject;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "package app list probe req data failed, " + th.getMessage());
                return null;
            }
        }

        private String d(Context context) {
            JSONObject c2 = c(context);
            if (c2 == null) {
                cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "package request data failed.");
                return null;
            }
            String str = a.InterfaceC0158a.f9865c;
            String a2 = j.a(c2.toString(), k.f9681a);
            cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "url:" + str + ", param json:" + c2.toString() + ", encryptStr: " + a2);
            String a3 = cn.jpush.android.bf.a.a(context, str, a2, 1);
            if (!TextUtils.isEmpty(a3)) {
                return a3;
            }
            cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "request black pages config failed");
            return null;
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                a(this.f9329a);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "requestSrvConfig failed, " + th.getMessage());
            }
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized ("pcf.cat") {
            cn.jpush.android.bm.c.a(new File(context.getFilesDir(), "pcf.cat"), str);
            b(context, str);
        }
    }

    public static void a(String str) {
        f9325a = str;
    }

    public static void a(String str, String str2) {
        f9326b.clear();
        if (!TextUtils.isEmpty(str)) {
            f9326b.addAll(Arrays.asList(str.split("&")));
        }
        f9327c.clear();
        if (!TextUtils.isEmpty(str2)) {
            f9327c.addAll(Arrays.asList(str2.split("&")));
        }
        cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "blacklist: " + str + ", whitelist: " + str2);
    }

    public static void b(Context context, String str) {
        boolean z;
        boolean z2;
        try {
            String b2 = j.b(str, k.f9681a);
            JSONObject jSONObject = new JSONObject(b2);
            cn.jpush.android.r.b.d("InAppBlackLstConfigHelper", "response: " + str + ", decResponse: " + b2);
            long optLong = jSONObject.optLong("next_time", 21600L);
            String optString = jSONObject.optString("black_list", "");
            String optString2 = jSONObject.optString("white_list", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_conf");
            if (optJSONObject != null) {
                z2 = optJSONObject.optInt("enable_get_active", 0) == 1;
                z = optJSONObject.optInt("ignore_local", 0) == 1;
            } else {
                z = false;
                z2 = false;
            }
            Sp.set(context, Key.AllowRunningProcess().set(Boolean.valueOf(z2)));
            Sp.set(context, Key.IgnoreLocalAllowRPConfig().set(Boolean.valueOf(z)));
            if (z) {
                cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "use remote allowRP config, enable: " + z2);
                cn.jpush.android.u.a.c().setAllowRunningProcess(Boolean.valueOf(z2));
            }
            a(optString, optString2);
            Sp.set(context, Key.BlackPagesInternalTime().set(Long.valueOf(optLong)));
            Sp.set(context, Key.BlackPagesLastReqTime().set(Long.valueOf(System.currentTimeMillis())));
            f9328d.set(true);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "parseResponseConfig failed, " + th.getMessage());
        }
    }

    public static boolean b(Context context) {
        e(context);
        return f9328d.get();
    }

    public static List<String> c(Context context) {
        if (!f9327c.isEmpty()) {
            return f9327c;
        }
        e(context);
        return f9327c;
    }

    public static List<String> d(Context context) {
        if (!f9326b.isEmpty()) {
            return f9326b;
        }
        e(context);
        return f9326b;
    }

    public static void e(Context context) {
        if (f9328d.get()) {
            return;
        }
        synchronized ("pcf.cat") {
            File file = new File(context.getFilesDir(), "pcf.cat");
            if (file.exists()) {
                try {
                    String str = (String) cn.jpush.android.bm.c.a(file);
                    if (!TextUtils.isEmpty(str)) {
                        String b2 = j.b(str, k.f9681a);
                        cn.jpush.android.r.b.b("InAppBlackLstConfigHelper", "get black list config from cache file: " + b2);
                        JSONObject jSONObject = new JSONObject(b2);
                        a(jSONObject.optString("black_list", ""), jSONObject.optString("white_list", ""));
                        f9328d.set(true);
                    }
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("InAppBlackLstConfigHelper", "read black list config error, " + th.getMessage());
                }
            }
        }
    }

    public void a(Context context) {
        JCoreHelper.futureExecutor(context, new a(context));
    }
}
