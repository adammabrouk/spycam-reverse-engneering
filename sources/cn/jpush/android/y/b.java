package cn.jpush.android.y;

import android.content.Context;
import cn.jiguang.internal.ActionManager;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static String a(Context context, int i2, int i3) {
        JSONObject a2 = a(context, 1);
        if (a2 == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_count", i2);
            jSONObject.put("wx_md5", cn.jpush.android.bm.a.g(context, ShareSystemFileUtils.PACKAGE_WECHAT));
            jSONObject.put("wx_appid", cn.jpush.android.bm.a.n(context));
            jSONObject.put("expire_time", i3);
            a2.put("content", jSONObject.toString());
            return a2.toString();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdPackageUtil", "package native ad body failed, e: " + th.getMessage());
            return "";
        }
    }

    public static JSONObject a(Context context, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_type", cn.jpush.android.m.a.a());
            jSONObject.put(ActionManager.SDK_TYPE, 1);
            jSONObject.put("render_type", i2);
            return jSONObject;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdPackageUtil", "package ad header failed, e: " + th.getMessage());
            return null;
        }
    }
}
