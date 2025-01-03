package cn.jpush.android.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.e.c;
import cn.jpush.android.f.e;
import cn.jpush.android.i.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            b.g("PushPlatformManager", "appId is empty");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(e.f9734b, "", "appId is empty"));
                return;
            }
            return;
        }
        if (str.length() != 24) {
            b.g("PushPlatformManager", "Invalid appId : " + str + ", Please check your appId again!");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(e.f9734b, "", "Invalid appId"));
                return;
            }
            return;
        }
        try {
            String b2 = cn.jpush.android.a.b.b(context);
            if (!TextUtils.isEmpty(b2)) {
                b.d("PushPlatformManager", "has register,token:" + b2);
                if (cVar != null) {
                    cVar.a(new cn.jpush.android.e.b(0, b2, "has register"));
                    return;
                }
                return;
            }
            cn.jpush.android.f.c.f9722b = str;
            b.b("PushPlatformManager", "register: appId - " + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("JPUSH_APPKEY", str);
            jSONObject.put("FIRST_REQUESTA", cn.jpush.android.a.b.c(context));
            cn.jpush.android.a.b.d(context);
            long a2 = cn.jpush.android.f.c.a();
            cn.jpush.android.f.a.a(new cn.jpush.android.f.b("ups.register", a2), cVar);
            cn.jpush.android.f.c.a(context, "ups.register", a2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
