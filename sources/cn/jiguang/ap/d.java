package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.utilcode.LogUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8290a = false;

    public static synchronized Bundle a(Context context, String str, String str2, JSONObject jSONObject) {
        Bundle bundle;
        synchronized (d.class) {
            bundle = new Bundle();
            try {
                String a2 = cn.jiguang.ar.c.a(context, str, str2, jSONObject);
                JSONObject jSONObject2 = new JSONObject(a2);
                int i2 = jSONObject2.getInt(JThirdPlatFormInterface.KEY_CODE);
                bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i2);
                if (i2 == 0) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(JThirdPlatFormInterface.KEY_DATA);
                    String string = jSONObject3.getString("cuid");
                    int optInt = jSONObject3.optInt("isNew", 0);
                    if (!TextUtils.isEmpty(string) && !LogUtils.NULL.equals(string)) {
                        cn.jiguang.ar.f.a("JOperateImp", "sendLoginTag cuidNew:" + string);
                        cn.jiguang.ar.e.a(context, string);
                        if (!string.equals(str)) {
                            cn.jiguang.ar.e.b(context, 0L);
                            cn.jiguang.ar.e.a(context, 0L);
                            b(context, new JSONArray().toString());
                            a(context, new JSONArray().toString());
                            f8290a = false;
                            a(context, 0L, (String) null);
                        }
                    }
                    if (1 == optInt) {
                        h.a(context);
                    }
                } else {
                    cn.jiguang.ar.f.d("JOperateImp", "setLoginTag f:" + a2);
                    bundle.putString(JThirdPlatFormInterface.KEY_MSG, jSONObject2.optString(JThirdPlatFormInterface.KEY_MSG, "unknown error"));
                }
            } catch (Throwable th) {
                cn.jiguang.ar.f.b("JOperateImp", "setLoginTag e:", th);
                bundle.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
                bundle.putString(JThirdPlatFormInterface.KEY_MSG, th.getMessage());
            }
        }
        return bundle;
    }

    public static synchronized Bundle a(Context context, String str, JSONObject jSONObject) {
        Bundle bundle;
        synchronized (d.class) {
            bundle = new Bundle();
            String a2 = cn.jiguang.ar.c.a(context, str, jSONObject);
            try {
                JSONObject jSONObject2 = new JSONObject(a2);
                int i2 = jSONObject2.getInt(JThirdPlatFormInterface.KEY_CODE);
                bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i2);
                if (i2 != 0) {
                    cn.jiguang.ar.f.d("JOperateImp", "setChannel:" + jSONObject2);
                    bundle.putString(JThirdPlatFormInterface.KEY_MSG, jSONObject.optString(JThirdPlatFormInterface.KEY_MSG, "unknown error"));
                }
            } catch (Throwable th) {
                cn.jiguang.ar.f.b("JOperateImp", "setChannel:" + a2 + ":", th);
                bundle.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
                bundle.putString(JThirdPlatFormInterface.KEY_MSG, th.getMessage());
            }
        }
        return bundle;
    }

    public static synchronized Bundle a(Context context, JSONObject jSONObject) {
        synchronized (d.class) {
            String c2 = cn.jiguang.ar.e.c(context);
            String e2 = f.e(context);
            if (TextUtils.isEmpty(e2)) {
                cn.jiguang.ar.f.d("JOperateImp", "setLoginTag rid null");
                Bundle bundle = new Bundle();
                bundle.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
                bundle.putString(JThirdPlatFormInterface.KEY_MSG, "No RID, please try again later");
                return bundle;
            }
            if (TextUtils.isEmpty(c2)) {
                cn.jiguang.ar.f.d("JOperateImp", "setLoginTag cUid null");
                Bundle bundle2 = new Bundle();
                bundle2.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
                bundle2.putString(JThirdPlatFormInterface.KEY_MSG, "No cUID, please try again later ");
                return bundle2;
            }
            if (jSONObject.length() == 0) {
                cn.jiguang.ar.f.d("JOperateImp", "setLoginTag value is null");
                Bundle bundle3 = new Bundle();
                bundle3.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
                bundle3.putString(JThirdPlatFormInterface.KEY_MSG, "value is not null ");
                return bundle3;
            }
            if (!TextUtils.isEmpty(jSONObject.optString("loginId", "").trim()) || !TextUtils.isEmpty(jSONObject.optString("phone", "").trim())) {
                return a(context, c2, e2, jSONObject);
            }
            cn.jiguang.ar.f.d("JOperateImp", "setLoginTag loginId is null and phone is null");
            Bundle bundle4 = new Bundle();
            bundle4.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
            bundle4.putString(JThirdPlatFormInterface.KEY_MSG, "loginId and phone value is not null ");
            return bundle4;
        }
    }

    public static void a(Context context, long j, String str) {
        String str2;
        Context applicationContext = context.getApplicationContext();
        if (f8290a) {
            str2 = "isDownloadSucc is true";
        } else if (str == null && TextUtils.isEmpty(f.e(applicationContext))) {
            str2 = "no has registrationId";
        } else if (j > 0 || f.f(applicationContext) > 0) {
            return;
        } else {
            str2 = "no has uid";
        }
        cn.jiguang.ar.f.a("JOperateImp", str2);
    }

    public static void a(Context context, String str) {
        cn.jiguang.ar.d.f(context, str);
        cn.jiguang.ar.e.c(context, null);
    }

    public static synchronized Bundle b(Context context, JSONObject jSONObject) {
        synchronized (d.class) {
            String c2 = cn.jiguang.ar.e.c(context);
            if (!TextUtils.isEmpty(c2)) {
                return a(context, c2, jSONObject);
            }
            cn.jiguang.ar.f.d("JOperateImp", "setChannel cUid null");
            Bundle bundle = new Bundle();
            bundle.putInt(JThirdPlatFormInterface.KEY_CODE, -1);
            bundle.putString(JThirdPlatFormInterface.KEY_MSG, "No cUID, please try again later ");
            return bundle;
        }
    }

    public static void b(Context context, String str) {
        cn.jiguang.ar.d.e(context, str);
        cn.jiguang.ar.e.b(context, (String) null);
    }
}
