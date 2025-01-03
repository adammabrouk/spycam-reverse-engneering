package cn.jiguang.ap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static Object a(Context context, String str, Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        cn.jiguang.ar.f.b("JOperateEventDispatch", "onEvent:" + str + ",bundle:" + bundle);
        try {
            g.a(context);
        } catch (Throwable th) {
            cn.jiguang.ar.f.a("JOperateEventDispatch", "type:" + str, th);
        }
        if (!g.b(context)) {
            g.a(context, str, bundle);
            return null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        h.a(context, "start_app_wake_save".equals(str));
        if ("init".equals(str)) {
            c.a(context);
        } else {
            if ("login".equals(str)) {
                try {
                    jSONObject2 = new JSONObject(bundle.getString("login_property"));
                } catch (Throwable unused) {
                    jSONObject2 = new JSONObject();
                }
                return c.a(context, jSONObject2);
            }
            if ("set_channel".equals(str)) {
                try {
                    jSONObject = new JSONObject(bundle.getString(JThirdPlatFormInterface.KEY_DATA));
                } catch (Throwable unused2) {
                    jSONObject = new JSONObject();
                }
                return c.b(context, jSONObject);
            }
            if ("set_report_debug".equals(str)) {
                h.a(context, (Intent) bundle.getParcelable("intent"));
            } else if ("set_debug".equals(str)) {
                bundle.getBoolean("debug");
            } else if ("jcore_register".equals(str)) {
                c.a(context, bundle.getLong("uid"), bundle.getString("rid"));
            } else if ("jcore_login".equals(str)) {
                c.b(context, bundle.getLong("uid"), bundle.getString("rid"));
            } else if ("period_task".equals(str)) {
                c.b(context);
                h.f(context);
            } else if ("start_app".equals(str)) {
                h.b(context);
                h.g(context);
            } else if ("start_app_wake_save".equals(str)) {
                h.c(context);
            } else if ("exit_app".equals(str)) {
                h.d(context);
            } else if ("report_custom".equals(str)) {
                h.b(context, bundle);
            } else if ("report_reserved".equals(str)) {
                h.c(context, bundle);
            } else {
                if ("get_cuid".equals(str)) {
                    return cn.jiguang.ar.e.c(context);
                }
                if ("activity_lifecycle".equals(str)) {
                    return h.a(context, bundle);
                }
            }
            cn.jiguang.ar.f.a("JOperateEventDispatch", "type:" + str, th);
        }
        return null;
    }
}
