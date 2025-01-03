package cn.jpush.android.helper;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static void a(Context context, String str, byte b2, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b2, 1000, context, str2);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        Logger.d("JPushReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }

    public static void a(String str, int i2, Context context) {
        a(str, i2, (String) null, context);
    }

    public static void a(String str, int i2, String str2, Context context) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + i2 + "-" + e.a(i2));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("， report content: " + str2);
        }
        String b2 = cn.jpush.android.d.d.b(str);
        if (!TextUtils.isEmpty(b2)) {
            stringBuffer.append("， report jData:" + b2);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("result", i2);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(JThirdPlatFormInterface.KEY_DATA, str2);
            }
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("_j_data_", b2);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "msg_status");
            if (fillBase != null) {
                fillBase.put(ContentCommon.TYPE, "msg_status");
                a(context, fillBase);
            } else {
                Logger.ww("JPushReportHelper", "report msg json is null, code: " + i2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, byte b2, int i2, Context context) {
        a(str, str2, b2, i2, context, null);
    }

    public static void a(String str, String str2, byte b2, int i2, Context context, String str3) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + i2);
        String b3 = cn.jpush.android.d.d.b(str);
        if (TextUtils.isEmpty(b3) && !TextUtils.isEmpty(str3)) {
            try {
                b3 = new JSONObject(str3).optString("_j_data_", "");
                Logger.d("JPushReportHelper", "get jdata from third push msg:" + b3);
            } catch (Throwable th) {
                Logger.d("JPushReportHelper", "get jdata from third push msg error:" + th.getMessage());
            }
        }
        if (!TextUtils.isEmpty(b3)) {
            stringBuffer.append("， report jData:" + b3);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("tmsg_id", str2);
            jSONObject.put("result", i2);
            jSONObject.put(ActionManager.SDK_TYPE, (int) b2);
            if (!TextUtils.isEmpty(b3)) {
                jSONObject.put("_j_data_", b3);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "third_msg_status");
            if (fillBase != null) {
                fillBase.put(ContentCommon.TYPE, "third_msg_status");
                a(context, fillBase);
            } else {
                Logger.ww("JPushReportHelper", "report third sdk msg json is null, code: " + i2);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            JCoreHelper.fillBase(context, jSONObject, "api_record");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().intValue() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("method", entry.getKey());
                    jSONObject2.put("count", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("record_list", jSONArray);
            a(context, jSONObject);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }
}
