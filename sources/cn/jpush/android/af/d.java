package cn.jpush.android.af;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {
    public static JSONObject a(Context context, String str) {
        JSONObject a2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    a2 = cn.jpush.android.l.a.a(context, str);
                }
                return a2;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JComFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File a2 = b.a(context, str);
                    if (a2 == null) {
                        return false;
                    }
                    return b.a(a2, str2);
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JComFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        boolean a2;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    a2 = cn.jpush.android.l.a.a(context, str, jSONObject);
                }
                return a2;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JComFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }
}
