package c.k.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s3 {
    public static Uri a(String str, String str2) {
        return Uri.parse("content://" + str).buildUpon().appendPath(str2).build();
    }

    public static String a(String str) {
        return Base64.encodeToString(k0.m260a(str), 2);
    }

    public static String a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : hashMap.keySet()) {
                jSONObject.put(str, hashMap.get(str));
            }
        } catch (JSONException e2) {
            c.k.a.a.a.c.a(e2);
        }
        return jSONObject.toString();
    }

    public static String b(String str) {
        return k0.a(Base64.decode(str, 2));
    }

    public static String b(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.put("event_type", hashMap.get("event_type") + "");
            hashMap2.put("description", hashMap.get("description") + "");
            String str = hashMap.get("awake_info");
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    hashMap2.put("__planId__", String.valueOf(jSONObject.opt("__planId__")));
                    hashMap2.put("flow_id", String.valueOf(jSONObject.opt("flow_id")));
                    hashMap2.put("jobkey", String.valueOf(jSONObject.opt("jobkey")));
                    hashMap2.put(JThirdPlatFormInterface.KEY_MSG_ID, String.valueOf(jSONObject.opt(JThirdPlatFormInterface.KEY_MSG_ID)));
                    hashMap2.put("A", String.valueOf(jSONObject.opt("awake_app")));
                    hashMap2.put("B", String.valueOf(jSONObject.opt("awakened_app")));
                    hashMap2.put("module", String.valueOf(jSONObject.opt("awake_type")));
                } catch (JSONException e2) {
                    c.k.a.a.a.c.a(e2);
                }
            }
        }
        return a((HashMap<String, String>) hashMap2);
    }
}
