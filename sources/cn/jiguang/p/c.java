package cn.jiguang.p;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static JSONObject a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 42, null, null, str);
                    if (!(onEvent instanceof JSONObject)) {
                        return null;
                    }
                    return (JSONObject) onEvent;
                }
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommonFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File d2 = cn.jiguang.l.d.d(context, str);
                    if (d2 == null) {
                        return false;
                    }
                    return cn.jiguang.l.d.a(d2, str2);
                }
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        boolean booleanValue;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 41, null, null, str, jSONObject);
                    booleanValue = onEvent instanceof Boolean ? ((Boolean) onEvent).booleanValue() : false;
                }
                return booleanValue;
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommonFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(context, str, (JSONObject) null)) {
                return;
            }
            synchronized (str) {
                context.deleteFile(str);
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JCommonFileHelper", "cleanJson throwable:" + th.getMessage());
        }
    }

    public static String c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File d2 = cn.jiguang.l.d.d(context, str);
                    if (d2 == null) {
                        return null;
                    }
                    return cn.jiguang.l.d.a(d2);
                }
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JCommonFileHelper", "readString throwable:" + th.getMessage());
            }
        }
        return null;
    }
}
