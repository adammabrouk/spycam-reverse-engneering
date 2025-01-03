package cn.jiguang.an;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import com.shix.shixipc.system.ContentCommon;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8225a = false;

    /* renamed from: b, reason: collision with root package name */
    public static WakedResultReceiver f8226b;

    public static JSONArray a(Context context) {
        JSONObject a2;
        synchronized ("waked_cache_v2.json") {
            a2 = cn.jiguang.p.c.a(context, "waked_cache_v2.json");
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        JSONArray optJSONArray = a2.optJSONArray("content");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        cn.jiguang.ai.a.a("JWakedHelper", "no save data");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fe A[Catch: all -> 0x024c, TryCatch #0 {all -> 0x024c, blocks: (B:4:0x0008, B:9:0x0010, B:10:0x0016, B:13:0x0024, B:15:0x0034, B:18:0x003b, B:19:0x00de, B:21:0x00fe, B:23:0x010f, B:25:0x0117, B:28:0x0051, B:31:0x0061, B:33:0x006e, B:35:0x007e, B:37:0x008e, B:38:0x009d, B:39:0x00a6, B:40:0x00aa, B:41:0x00bf, B:42:0x00a1, B:43:0x00ae, B:44:0x00c3, B:47:0x011b, B:48:0x0134, B:50:0x013a, B:51:0x017b, B:53:0x0181, B:55:0x01c9, B:56:0x01d5, B:58:0x01db, B:60:0x01e7, B:65:0x0216, B:67:0x022a, B:69:0x0230, B:70:0x0244), top: B:3:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray a(android.content.Context r19, org.json.JSONArray r20) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.e.a(android.content.Context, org.json.JSONArray):org.json.JSONArray");
    }

    public static JSONObject a(String str, int i2, boolean z) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i2);
            jSONObject.put("package", str);
            jSONObject.put("app_alive", z);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakedHelper", "packageWakedJson error:" + th.getMessage());
            return null;
        }
    }

    public static void a(Context context, int i2) {
        if (context == null) {
            cn.jiguang.ai.a.d("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver c2 = c(context);
        f8226b = c2;
        if (c2 == null) {
            cn.jiguang.ai.a.d("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("1", context);
        hashMap.put(WakedResultReceiver.WAKE_TYPE_KEY, Integer.valueOf(i2));
        f8226b.onWakeMap(hashMap);
    }

    public static void a(final Context context, final Bundle bundle, final int i2) {
        try {
            cn.jiguang.ai.a.a("JWakedHelper", "executeWakedAction.");
            a(context, i2);
            cn.jiguang.l.d.a(new cn.jiguang.l.e() { // from class: cn.jiguang.an.e.1
                @Override // cn.jiguang.l.e
                public void a() {
                    e.c(context, bundle, i2);
                }
            });
            cn.jiguang.g.a.a(context, 2);
        } catch (Throwable th) {
            cn.jiguang.ai.a.a("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("di", str);
            synchronized ("di.json") {
                JSONObject a2 = cn.jiguang.p.c.a(context, "di.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put("content", optJSONArray);
                cn.jiguang.p.c.a(context, "di.json", a2);
                cn.jiguang.ai.a.a("JWakedHelper", "save di is: " + str + ", success!");
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakedHelper", "saveDId failed:" + th.getMessage());
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            cn.jiguang.ai.a.a("JWakedHelper", "save waked data : " + jSONObject.toString());
            jSONObject.put("itime", cn.jiguang.l.d.i(context));
            jSONObject.put(ContentCommon.TYPE, "aat3");
            synchronized ("waked_cache_v2.json") {
                JSONObject a2 = cn.jiguang.p.c.a(context, "waked_cache_v2.json");
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                JSONArray optJSONArray = a2.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a2.put("content", optJSONArray);
                cn.jiguang.p.c.a(context, "waked_cache_v2.json", a2);
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakedHelper", "saveWakedData failed:" + th.getMessage());
        }
    }

    public static void b(Context context) {
        synchronized ("waked_cache_v2.json") {
            cn.jiguang.p.c.a(context, "waked_cache_v2.json", (String) null);
        }
    }

    public static WakedResultReceiver c(Context context) {
        WakedResultReceiver wakedResultReceiver = f8226b;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.WakedReceiver");
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                return null;
            }
            return (WakedResultReceiver) Class.forName(queryBroadcastReceivers.get(0).activityInfo.name).newInstance();
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakedHelper", "find waked receiver throwable:" + th.getMessage());
            return null;
        }
    }

    public static void c(Context context, Bundle bundle, int i2) {
        String str;
        if (bundle == null) {
            str = "bundle is null,give up save";
        } else {
            if (b.b(context).u) {
                String str2 = null;
                try {
                    str2 = bundle.getString("from_package");
                } catch (Throwable unused) {
                }
                if (str2 == null) {
                    str2 = "";
                }
                JSONObject a2 = a(str2, i2, f8225a);
                f8225a = true;
                if (a2 == null) {
                    return;
                }
                try {
                    String string = bundle.getString("jg_extras");
                    if (!TextUtils.isEmpty(string)) {
                        a2.put("jg_extras", string);
                    }
                } catch (Throwable th) {
                    cn.jiguang.ai.a.d("JWakedHelper", "save waked extras error:" + th.getMessage());
                }
                a(context, a2);
                return;
            }
            str = "server set do not report waked data,give up save";
        }
        cn.jiguang.ai.a.d("JWakedHelper", str);
    }
}
