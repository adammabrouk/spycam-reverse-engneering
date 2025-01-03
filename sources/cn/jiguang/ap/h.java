package cn.jiguang.ap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.system.ContentCommon;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8301a = true;

    /* renamed from: b, reason: collision with root package name */
    public static long f8302b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static long f8303c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8304d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8305e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f8306f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static JSONArray f8307g = null;

    /* renamed from: h, reason: collision with root package name */
    public static JSONArray f8308h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f8309i = false;
    public static String j;
    public static String k;

    public static Object a(Context context, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("lifecycle_name");
        String string2 = bundle.getString("activity_name");
        cn.jiguang.ar.f.a("JOperateReport", "activityLifecycle:" + string);
        cn.jiguang.ar.f.a("JOperateReport", "activity_name:" + string2);
        if ("onActivityResumed".equals(string)) {
            e(context);
        }
        return null;
    }

    public static String a() {
        try {
            return String.valueOf(Class.forName("cn.jiguang.joperate.api.JOperateInterface").getDeclaredMethod("getVersion", new Class[0]).invoke(null, new Object[0]));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(Context context, int i2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            long f2 = f.f(context);
            String c2 = cn.jiguang.ar.e.c(context);
            jSONObject.put("uid", f2);
            jSONObject.put("cuid", c2);
            jSONObject.put(ContentCommon.TYPE, i2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("random_id", UUID.randomUUID());
            jSONObject.put("peripheralProperty", b(context, z));
        } catch (Throwable th) {
            cn.jiguang.ar.f.b("JOperateReport", "peripheralProperty:", th);
        }
        return jSONObject;
    }

    public static void a(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str);
            jSONObject3.put("value", jSONObject);
            jSONObject2.put(InAppSlotParams.SLOT_KEY.EVENT, jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        c(context, "jg_app_cuid", new JSONObject());
    }

    public static void a(final Context context, Intent intent) {
        Uri data;
        String queryParameter;
        String scheme;
        String host;
        cn.jiguang.ar.f.a("JOperateReport", "setReportDebug intent:" + intent);
        if (intent == null || (data = intent.getData()) == null || (queryParameter = data.getQueryParameter(JThirdPlatFormInterface.KEY_TOKEN)) == null || (scheme = data.getScheme()) == null || (host = data.getHost()) == null || !"joperate_debug".equals(host)) {
            return;
        }
        cn.jiguang.ar.f.b("JOperateReport", "setReportDebug intent:" + intent);
        if (cn.jiguang.ar.e.a(context) + cn.jiguang.ar.e.b(context) <= 0) {
            cn.jiguang.ar.f.f("JOperateReport", "There is no CUID now, please wait a while and try again！");
            return;
        }
        f8309i = true;
        k = queryParameter;
        j = scheme;
        cn.jiguang.ar.f.a("JOperateReport", "setReportDebug mToken:" + k);
        cn.jiguang.ar.f.a("JOperateReport", "setReportDebug mScheme:" + j);
        f.a(new Runnable() { // from class: cn.jiguang.ap.h.6
            @Override // java.lang.Runnable
            public void run() {
                h.f(context, h.f(context, 0, "jg_debug", new JSONObject(), false));
            }
        }, new int[0]);
    }

    public static void a(Context context, String str, JSONObject jSONObject, boolean z) {
        d(context, 0, str, jSONObject, z);
    }

    public static void a(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentCommon.TYPE, "operate_event");
            jSONObject.put(JThirdPlatFormInterface.KEY_DATA, jSONArray);
            cn.jiguang.ar.f.a("JOperateReport", "reportJcore:" + jSONObject);
            f.a(context, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        Iterator<Map.Entry<String, cn.jiguang.aq.a>> it;
        int i2;
        double doubleValue;
        try {
            jSONObject3 = new JSONObject();
            jSONObject4 = new JSONObject();
            jSONObject5 = new JSONObject();
            it = a.a(context).a().iterator();
        } catch (Throwable unused) {
            return;
        }
        while (true) {
            i2 = 1;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, cn.jiguang.aq.a> next = it.next();
            String key = next.getKey();
            cn.jiguang.aq.a value = next.getValue();
            Object b2 = value.b();
            if (jSONObject.has(key)) {
                Object obj = jSONObject.get(key);
                if (value.c() == 1) {
                    double d2 = 0.0d;
                    try {
                        d2 = Double.parseDouble(String.valueOf(b2));
                    } catch (Throwable unused2) {
                        cn.jiguang.ar.f.f("JOperateReport", "value type must be numeric");
                    }
                    if (obj instanceof Integer) {
                        doubleValue = ((Integer) obj).intValue();
                    } else if (obj instanceof Float) {
                        doubleValue = ((Float) obj).floatValue();
                    } else if (obj instanceof Double) {
                        doubleValue = ((Double) obj).doubleValue();
                        double d3 = d2 + doubleValue;
                        value.a(Double.valueOf(d3));
                        jSONObject5.put(key, obj);
                        jSONObject4.put("jga_" + key, obj);
                        b2 = Double.valueOf(d3);
                    } else {
                        cn.jiguang.ar.f.f("JOperateReport", "The user " + key + " type must be numeric");
                    }
                    Double.isNaN(doubleValue);
                    double d32 = d2 + doubleValue;
                    value.a(Double.valueOf(d32));
                    jSONObject5.put(key, obj);
                    jSONObject4.put("jga_" + key, obj);
                    b2 = Double.valueOf(d32);
                } else if (value.c() == 0 && !String.valueOf(obj).equals(String.valueOf(b2))) {
                    if ((!(obj instanceof Number) || !(b2 instanceof Number)) && b2 != null && !obj.getClass().equals(b2.getClass())) {
                        cn.jiguang.ar.f.f("JOperateReport", "The user " + key + " type must be " + b2.getClass());
                    }
                    value.a(obj);
                    jSONObject5.put(key, obj);
                    b2 = obj;
                }
                jSONObject.remove(key);
            }
            jSONObject4.put(key, b2);
            return;
        }
        d.a(context, a.a(context).b().toString());
        jSONObject3.put("value", jSONObject4);
        jSONObject3.put("newValue", jSONObject5);
        if (jSONObject5.length() <= 0) {
            i2 = 0;
        }
        jSONObject2.put("isNewUserProperties", i2);
        jSONObject2.put("userProperties", jSONObject3);
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (h.class) {
            if (0 != f8302b) {
                return;
            }
            if (z) {
                return;
            }
            if (context.getPackageName().equals(f.g(context))) {
                f8302b = System.currentTimeMillis();
                if (cn.jiguang.ar.e.h(context)) {
                    f8303c = System.currentTimeMillis();
                    cn.jiguang.ar.e.a(context, false);
                    c(context, "jg_app_active", new JSONObject());
                }
            }
        }
    }

    public static boolean a(String str) {
        return "jg_app_active".equals(str) || "jg_app_cuid".equals(str);
    }

    public static boolean a(String str, JSONObject jSONObject) {
        StringBuilder sb;
        String str2;
        Iterator<String> keys = jSONObject.keys();
        if (str.length() <= 256) {
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                str = keys.next();
                if (str.length() > 256) {
                    sb = new StringBuilder();
                    str2 = "Max cannot greater than 256，key:";
                    break;
                }
                Object opt = jSONObject.opt(str);
                if (String.valueOf(opt).length() > 256) {
                    cn.jiguang.ar.f.d("JOperateReport", "Max cannot greater than 256，value:" + opt);
                    try {
                        jSONObject.put(str, String.valueOf(opt).substring(0, 257));
                        break;
                    } catch (Throwable unused) {
                    }
                }
            }
            return false;
        }
        sb = new StringBuilder();
        str2 = "Max cannot greater than 256，eventKey:";
        sb.append(str2);
        sb.append(str);
        cn.jiguang.ar.f.f("JOperateReport", sb.toString());
        return true;
    }

    public static JSONArray b(String str) {
        String[] split;
        JSONArray jSONArray = new JSONArray();
        if (str != null && (split = str.split(OSSUtils.NEW_LINE)) != null) {
            for (int i2 = 0; i2 < split.length; i2++) {
                cn.jiguang.ar.f.a("JOperateReport", "getOldReportData file:" + i2 + ":" + split[i2]);
                try {
                    if (!TextUtils.isEmpty(split[i2])) {
                        jSONArray.put(new JSONObject(split[i2]));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject b(Context context, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("jg_network_type", f.h(context));
            jSONObject.put("jg_launch_first", (f8303c > 0L ? 1 : (f8303c == 0L ? 0 : -1)) != 0 ? 1 : 0);
            jSONObject.put("jg_launch_background", f8301a ? 1 : 0);
            jSONObject.put("jg_event_duration", (System.currentTimeMillis() - f8302b) / 1000);
            jSONObject.put("jg_carrier", f.i(context));
            jSONObject.put("jg_wifi", f.j(context) ? 1 : 0);
            jSONObject.put("jg_app_name", cn.jiguang.ar.a.b(context));
            jSONObject.put("jg_operate_sdk_ver", a());
            jSONObject.put("jg_sdk_version", f.c(context));
            jSONObject.put("jg_app_version", cn.jiguang.ar.a.a(context));
            jSONObject.put("jg_app_key", f.l(context));
            if (!z) {
                jSONObject.put("jg_channel_source", f.b(context));
                jSONObject.put("jg_device_id", f.k(context));
                JSONObject a2 = f.a(context);
                if (a2 != null) {
                    jSONObject.put("jg_manufacturer", a2.optString("manufacturer", ""));
                    jSONObject.put("jg_devices_model", a2.optString("model", ""));
                    jSONObject.put("jg_os_language", a2.optString("language", ""));
                    jSONObject.put("jg_rom_version", a2.optString("romversion", ""));
                    jSONObject.put("jg_os_version", a2.optString("os_version", ""));
                    String[] split = a2.optString("resolution", "").split("\\*");
                    if (2 == split.length) {
                        jSONObject.put("jg_screen_width", split[0]);
                        jSONObject.put("jg_screen_height", split[1]);
                    }
                    jSONObject.put("jg_screen_size", a2.optString("screensize", ""));
                    jSONObject.put("jg_mac_address", a2.optString("mac", ""));
                    jSONObject.put("jg_time_zone", a2.optString("timezone", ""));
                }
                Bundle d2 = f.d(context);
                if (d2 != null) {
                    boolean containsKey = d2.containsKey("lat");
                    boolean containsKey2 = d2.containsKey("lot");
                    if (containsKey && containsKey2) {
                        jSONObject.put("jg_latitude", d2.getDouble("lat"));
                        jSONObject.put("jg_longitude", d2.getDouble("lot"));
                    }
                    if (d2.containsKey("wss")) {
                        jSONObject.put("jg_ssid", d2.getString("wss"));
                    }
                }
            }
            jSONObject.put("jg_platform_type", "android");
            jSONObject.put("jg_os", "android");
            String a3 = cn.jiguang.ar.a.a();
            if (a3 != null) {
                jSONObject.put("jg_platform_type", "harmony");
                jSONObject.put("jg_os", "harmony");
                jSONObject.put("jg_os_version", a3);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.f.b("JOperateReport", "getJsonPeripheralProperty:", th);
        }
        return jSONObject;
    }

    public static void b(Context context) {
        f8301a = false;
        c(context, "jg_app_launch", new JSONObject());
    }

    public static void b(Context context, Bundle bundle) {
        d(context, bundle.getString("event_id"), c(bundle.getString("event_property")));
    }

    public static void b(Context context, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        if (jSONObject2 == null) {
            cn.jiguang.ar.d.a(context, jSONObject2);
            return;
        }
        cn.jiguang.ar.d.b(context, OSSUtils.NEW_LINE + jSONObject2);
    }

    public static JSONObject c(String str) {
        if (str == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            cn.jiguang.ar.f.b("JOperateReport", "" + str, th);
            return new JSONObject();
        }
    }

    public static void c(Context context) {
        a(context, "jg_app_launch", new JSONObject(), true);
    }

    public static void c(Context context, Bundle bundle) {
        c(context, bundle.getString("event_id"), c(bundle.getString("event_property")));
    }

    public static void c(Context context, String str, JSONObject jSONObject) {
        d(context, 0, str, jSONObject, false);
    }

    public static void c(Context context, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        cn.jiguang.ar.f.a("JOperateReport", "setOldReportData file:" + jSONObject2);
        if (jSONObject2 == null) {
            cn.jiguang.ar.d.c(context, "");
            return;
        }
        cn.jiguang.ar.d.d(context, OSSUtils.NEW_LINE + jSONObject2);
    }

    public static JSONObject d(Context context, JSONObject jSONObject) {
        try {
            long f2 = f.f(context);
            String c2 = cn.jiguang.ar.e.c(context);
            jSONObject.put("uid", f2);
            jSONObject.put("cuid", c2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void d(Context context) {
        f8301a = true;
        c(context, "jg_app_end", new JSONObject());
    }

    public static void d(final Context context, final int i2, final String str, final JSONObject jSONObject, final boolean z) {
        if (cn.jiguang.ar.e.k(context)) {
            cn.jiguang.ar.f.a("JOperateReport", "report JOpetate Off");
            return;
        }
        if (jSONObject.length() > 500) {
            cn.jiguang.ar.f.f("JOperateReport", "Max cannot greater than 500，Number of attributes");
            return;
        }
        if (a(str, jSONObject)) {
            return;
        }
        boolean h2 = h(context);
        cn.jiguang.ar.f.a("JOperateReport", "hasVersion:" + h2 + ", isSaveWake:" + z + ", eventKey:" + str);
        f.a(new Runnable() { // from class: cn.jiguang.ap.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.e(context, i2, str, jSONObject, z);
            }
        }, new int[0]);
        if (!h2 || z) {
            f.a(new Runnable() { // from class: cn.jiguang.ap.h.5
                @Override // java.lang.Runnable
                public void run() {
                    h.f(context, str, h.g(context, i2, str, jSONObject, z));
                }
            }, new int[0]);
            return;
        }
        f.a(new Runnable() { // from class: cn.jiguang.ap.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.f(context, null, null);
            }
        }, new int[0]);
        if (a.a(context).a(str)) {
            if (f8309i) {
                f.a(new Runnable() { // from class: cn.jiguang.ap.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.f(context, h.f(context, i2, str, jSONObject, z));
                    }
                }, new int[0]);
                return;
            } else {
                f.a(new Runnable() { // from class: cn.jiguang.ap.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.e(context, str, h.f(context, i2, str, jSONObject, z));
                    }
                }, new int[0]);
                return;
            }
        }
        cn.jiguang.ar.f.a("JOperateReport", "report no hasEventKey:" + str);
    }

    public static void d(Context context, String str, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (keys.next().trim().startsWith("jg")) {
                cn.jiguang.ar.f.f("JOperateReport", "attribute key not starts with 'jg'");
                return;
            }
        }
        if (str.trim().startsWith("jg")) {
            cn.jiguang.ar.f.f("JOperateReport", "event Key not starts with 'jg'");
        } else {
            d(context, 1, str, jSONObject, false);
        }
    }

    public static JSONObject e(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(InAppSlotParams.SLOT_KEY.EVENT);
            JSONObject optJSONObject = jSONObject2.optJSONObject("value");
            a(context, optJSONObject, jSONObject);
            a(jSONObject2.optInt(ContentCommon.TYPE), jSONObject2.optString("id"), optJSONObject, jSONObject);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void e(Context context) {
        c(context, "jg_app_viewscreen", new JSONObject());
    }

    public static void e(Context context, int i2, String str, JSONObject jSONObject, boolean z) {
        synchronized (f8306f) {
            if ("jg_app_active".equals(str)) {
                cn.jiguang.ar.e.d(context, g(context, i2, str, jSONObject, z).toString());
            } else if ("jg_app_cuid".equals(str)) {
                cn.jiguang.ar.e.e(context, f(context, i2, str, jSONObject, z).toString());
            }
        }
    }

    public static void e(Context context, String str, JSONObject jSONObject) {
        synchronized (f8305e) {
            cn.jiguang.ar.f.a("JOperateReport", "newReport:" + jSONObject);
            cn.jiguang.ar.f.a("JOperateReport", "newReport reportCache:" + f8307g);
            if (f8307g == null) {
                JSONArray j2 = j(context);
                f8307g = j2;
                if (j2 == null) {
                    f8307g = new JSONArray();
                }
            }
            cn.jiguang.ar.f.a("JOperateReport", "newReport reportCache length:" + f8307g.length());
            if (!a(str)) {
                f8307g.put(jSONObject);
                b(context, jSONObject);
            }
            i(context);
            long currentTimeMillis = System.currentTimeMillis() - cn.jiguang.ar.e.f(context);
            if (f8307g.length() > 0 && (currentTimeMillis > 15000 || f8307g.length() >= 50)) {
                a(context, f8307g);
                f8307g = new JSONArray();
                b(context, (JSONObject) null);
                cn.jiguang.ar.e.g(context);
            }
        }
    }

    public static JSONObject f(Context context, int i2, String str, JSONObject jSONObject, boolean z) {
        JSONObject a2 = a(context, i2, z);
        try {
            a(context, jSONObject, a2);
            a(i2, str, jSONObject, a2);
        } catch (Throwable unused) {
        }
        return a2;
    }

    public static void f(Context context) {
        g(context);
    }

    public static void f(Context context, String str, JSONObject jSONObject) {
        synchronized (f8304d) {
            cn.jiguang.ar.f.a("JOperateReport", "oldReport:" + jSONObject);
            cn.jiguang.ar.f.a("JOperateReport", "oldReport reportCacheOld:" + f8308h);
            long currentTimeMillis = System.currentTimeMillis();
            if (f8308h == null) {
                JSONArray k2 = k(context);
                f8308h = k2;
                if (k2 == null) {
                    f8308h = new JSONArray();
                }
                cn.jiguang.ar.f.c("JOperateReport", "oldReport getOldReportData time:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            cn.jiguang.ar.f.a("JOperateReport", "oldReport reportCacheOld:" + f8308h.toString().length());
            cn.jiguang.ar.f.a("JOperateReport", "oldReport reportCacheOld length:" + f8308h.length());
            if (jSONObject == null) {
                i(context);
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < f8308h.length(); i2++) {
                    JSONObject optJSONObject = f8308h.optJSONObject(i2);
                    if (optJSONObject != null) {
                        try {
                            String optString = optJSONObject.getJSONObject(InAppSlotParams.SLOT_KEY.EVENT).optString("id");
                            if (a.a(context).a(optString)) {
                                jSONArray.put(e(context, d(context, optJSONObject)));
                                if (jSONArray.length() == 50) {
                                    a(context, jSONArray);
                                    jSONArray = new JSONArray();
                                }
                            } else {
                                cn.jiguang.ar.f.a("JOperateReport", "oldReport no hasEventKey:" + optString);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    a(context, jSONArray);
                    new JSONArray();
                }
                c(context, (JSONObject) null);
                f8308h = null;
                cn.jiguang.ar.f.c("JOperateReport", "oldReport send time:" + (System.currentTimeMillis() - currentTimeMillis));
            } else {
                if (f8308h.length() > 1000) {
                    cn.jiguang.ar.f.c("JOperateReport", "oldReport Just the first 1,000.");
                    return;
                }
                if (!a(str)) {
                    f8308h.put(jSONObject);
                    c(context, jSONObject);
                }
                cn.jiguang.ar.f.a("JOperateReport", "oldReport save time:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public static void f(final Context context, final JSONObject jSONObject) {
        if (f8309i) {
            f.a(new Runnable() { // from class: cn.jiguang.ap.h.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ContentCommon.TYPE, "operate_event");
                        JSONArray jSONArray = new JSONArray();
                        jSONObject2.put(JThirdPlatFormInterface.KEY_DATA, jSONArray);
                        jSONObject2.put("scheme", h.j);
                        jSONObject2.put(JThirdPlatFormInterface.KEY_TOKEN, h.k);
                        jSONObject2.put("appkey", f.l(context));
                        jSONArray.put(jSONObject);
                        cn.jiguang.ar.f.a("JOperateReport", "reportDebug jsonObject:" + jSONObject2);
                        cn.jiguang.ar.f.a("JOperateReport", "reportDebug sendDebugReport re:" + cn.jiguang.ar.c.a(context, jSONObject2));
                    } catch (Throwable unused) {
                    }
                }
            }, new int[0]);
        }
    }

    public static JSONObject g(Context context, int i2, String str, JSONObject jSONObject, boolean z) {
        JSONObject a2 = a(context, i2, z);
        try {
            a(i2, str, jSONObject, a2);
        } catch (Throwable unused) {
        }
        return a2;
    }

    public static void g(Context context) {
        cn.jiguang.ar.f.a("JOperateReport", "sendNotificationPermissions");
        int a2 = cn.jiguang.ar.g.a(context);
        if (a2 == cn.jiguang.ar.e.a(context, -1)) {
            cn.jiguang.ar.f.a("JOperateReport", "sendNotificationPermissions enabled == integer : " + a2);
            return;
        }
        cn.jiguang.ar.e.b(context, a2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("jg_date_time", System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        c(context, 1 == a2 ? "jg_notification_state_on" : "jg_notification_state_off", jSONObject);
    }

    public static boolean h(Context context) {
        long a2 = cn.jiguang.ar.e.a(context);
        long b2 = cn.jiguang.ar.e.b(context);
        long j2 = a2 + b2;
        cn.jiguang.ar.f.a("JOperateReport", "userVersion:" + a2);
        cn.jiguang.ar.f.a("JOperateReport", "eventVersion:" + b2);
        return j2 > 0;
    }

    public static void i(Context context) {
        synchronized (f8306f) {
            if (h(context)) {
                String i2 = cn.jiguang.ar.e.i(context);
                if (!TextUtils.isEmpty(i2)) {
                    if (a.a(context).a("jg_app_active")) {
                        try {
                            a(context, new JSONArray().put(e(context, d(context, new JSONObject(i2)))));
                        } catch (Throwable unused) {
                        }
                        cn.jiguang.ar.e.d(context, null);
                    } else {
                        cn.jiguang.ar.f.a("JOperateReport", "report no hasEventKey::jg_app_active");
                    }
                }
                String j2 = cn.jiguang.ar.e.j(context);
                if (!TextUtils.isEmpty(j2)) {
                    if (a.a(context).a("jg_app_cuid")) {
                        try {
                            a(context, new JSONArray().put(new JSONObject(j2)));
                        } catch (Throwable unused2) {
                        }
                        cn.jiguang.ar.e.e(context, null);
                    } else {
                        cn.jiguang.ar.f.a("JOperateReport", "report no hasEventKey::jg_app_cuid");
                    }
                }
            }
        }
    }

    public static JSONArray j(Context context) {
        return b(cn.jiguang.ar.d.a(context));
    }

    public static JSONArray k(Context context) {
        return b(cn.jiguang.ar.d.b(context));
    }
}
