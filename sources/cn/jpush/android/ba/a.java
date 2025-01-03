package cn.jpush.android.ba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static void a(Context context, d dVar) {
        Logger.d("JAnalytics", "sendClickNotificationMessage");
        a(context, "jg_message_click", c(context, dVar));
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        Logger.d("JAnalytics", "report eventId:" + str + ", eventProperty:" + jSONObject);
        Bundle bundle = new Bundle();
        bundle.putString("event_id", str);
        if (jSONObject != null) {
            bundle.putString("event_property", jSONObject.toString());
        }
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 89, "report_reserved", bundle, new Object[0]);
    }

    public static void b(Context context, d dVar) {
        Logger.d("JAnalytics", "sendClearNotificationMessage");
        a(context, "jg_message_clean", c(context, dVar));
    }

    public static JSONObject c(Context context, d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            NotificationMessage b2 = dVar.b();
            if (TextUtils.isEmpty(b2.appkey)) {
                b2.appkey = JCoreHelper.getAppKey(context);
            }
            Logger.w("JAnalytics", "notificationMessage:" + b2);
            jSONObject.put("jg_msg_id", b2.msgId);
            jSONObject.put("jg_msg_title", b2.notificationTitle);
            jSONObject.put("jg_msg_content", b2.notificationContent);
            jSONObject.put("jg_msg_type", dVar.f9697a);
            jSONObject.put("jg_msg_url", b2.deeplink);
            String str = b2.notificationExtras;
            if (str != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.put("jg_task_id", jSONObject2.optString("_jg_taskid", ""));
                    jSONObject.put("jg_plan_id", jSONObject2.optString("_jg_planid", ""));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            Logger.ee("JAnalytics", "getJsonNotificationMessage:", th);
        }
        return jSONObject;
    }
}
