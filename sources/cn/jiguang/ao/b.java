package cn.jiguang.ao;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static String f8255g;

    /* renamed from: a, reason: collision with root package name */
    public static final String f8249a = cn.jiguang.p.a.b(new byte[]{59, 87, 87, 6, 101, 43, 62, 39, 85, 116, 16, 46, 74, 39, 32, 7, 19, 43, 57, 36, 40, 1, 21, 90, 78, 87, 82, 115, 24, 91, 77, 47});

    /* renamed from: b, reason: collision with root package name */
    public static final String f8250b = cn.jiguang.p.a.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 114, 95, 78, Byte.MAX_VALUE, 97, 113, 60, 90, 85, 119, 97, 121, Byte.MAX_VALUE, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, 31, 83, 105, 97, 122});

    /* renamed from: c, reason: collision with root package name */
    public static String f8251c = "";

    /* renamed from: d, reason: collision with root package name */
    public static long f8252d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static long f8253e = 43200;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicBoolean f8254f = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f8256h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f8257i = ".pkg_idx_v390";

    public static Object a(Context context) {
        String str;
        Object a2;
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f8255g)) {
            try {
                return new JSONObject(f8255g);
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.be.a a3 = cn.jiguang.be.a.a(context);
            jSONObject.put("android_id", a3.f8687i);
            jSONObject.put("manufacturer", a3.l);
            jSONObject.put("model", a3.f8681c);
            Object a4 = cn.jiguang.az.e.a(context, "deviceinfo", null);
            if (a4 instanceof JSONObject) {
                JSONArray jSONArray = ((JSONObject) a4).getJSONArray("sim_slots");
                String str2 = "";
                String str3 = str2;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject.put("imei1", str2);
                            }
                        } else {
                            str3 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("imei2", str3);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    jSONObject.put("imei1", a3.p);
                }
                jSONObject.put("os_version", ((JSONObject) a4).optString("os_version", ""));
                jSONObject.put("language", ((JSONObject) a4).optString("language", ""));
                try {
                    str = jSONObject.getJSONObject("ids").optString("joad", "");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = f8256h;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str = "";
                }
                if (TextUtils.isEmpty(str) && (a2 = cn.jiguang.az.e.a(context, "get_all_ids", null)) != null && (a2 instanceof JSONObject)) {
                    str = ((JSONObject) a2).optString("joad", "");
                }
                jSONObject.put("joad", str);
            }
        } catch (Throwable unused4) {
        }
        f8255g = jSONObject.toString();
        cn.jiguang.as.d.c("JAppListProbeHelper", "force dev info " + jSONObject.toString());
        return jSONObject;
    }
}
