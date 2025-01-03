package cn.jiguang.aw;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.f.b;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8401a;

    /* renamed from: b, reason: collision with root package name */
    public static int f8402b;

    /* renamed from: c, reason: collision with root package name */
    public static String f8403c;

    /* renamed from: d, reason: collision with root package name */
    public static int f8404d;

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f8405e;

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f8406f;

    /* renamed from: g, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f8407g;

    /* renamed from: h, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f8408h;

    /* renamed from: i, reason: collision with root package name */
    public static String f8409i;
    public static String j;
    public static String k;
    public static String l;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f8405e = linkedHashMap;
        linkedHashMap.put("s.jpush.cn", 19000);
        f8405e.put("sis.jpush.io", 19000);
        f8405e.put("easytomessage.com", 19000);
        f8406f = new LinkedHashMap<>();
        try {
            String str = new String(Base64.decode("MTIzLjE5Ni4xMTguMjM=", 2));
            String str2 = new String(Base64.decode("MTAzLjIyOS4yMTUuNjA=", 2));
            String str3 = new String(Base64.decode("MTE3LjEyMS40OS4xMDA=", 2));
            f8406f.put(str, 19000);
            f8406f.put(str2, 19000);
            f8406f.put(str3, 19000);
        } catch (Throwable unused) {
        }
        f8407g = new LinkedHashMap<>();
        f8408h = new LinkedHashMap<>();
        f8409i = "";
        j = "";
        k = "";
        l = "";
    }

    public static String a(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f8409i)) {
            return f8409i;
        }
        String str = (String) b.b(context, cn.jiguang.f.a.R());
        return !TextUtils.isEmpty(str) ? str : "im64.jpush.cn";
    }

    public static LinkedHashMap<String, Integer> a() {
        return (!JCoreManager.isTestEnv() || f8407g.isEmpty()) ? f8405e : f8407g;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            d.g("HostConfig", "conn info was empty");
            return;
        }
        d.c("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("srv");
            d.c("HostConfig", "save srvHost:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.S().a((cn.jiguang.f.a<String>) optString)});
            }
            String optString2 = jSONObject.optString("conn");
            d.c("HostConfig", "save connHost:" + optString2);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.R().a((cn.jiguang.f.a<String>) optString2)});
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(j)) {
            return j;
        }
        String str = (String) b.b(context, cn.jiguang.f.a.S());
        return !TextUtils.isEmpty(str) ? str : "_im64._tcp.jpush.cn";
    }

    public static LinkedHashMap<String, Integer> b() {
        return (!JCoreManager.isTestEnv() || f8408h.isEmpty()) ? f8406f : f8408h;
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(k)) ? "_psis._udp.jpush.cn" : k;
    }

    public static String d() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(l)) ? "" : l;
    }
}
