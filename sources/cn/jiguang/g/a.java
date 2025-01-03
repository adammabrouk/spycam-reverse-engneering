package cn.jiguang.g;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.ap.b;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.l.d;
import com.shix.shixipc.system.ContentCommon;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f8890a;

    public static void a(Context context, int i2) {
        cn.jiguang.ai.a.a("JAnalytics", "sendStartAPP:" + i2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f8890a < 2000) {
            cn.jiguang.ai.a.a("JAnalytics", "sendStartAPP return:" + i2);
            return;
        }
        f8890a = currentTimeMillis;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentCommon.TYPE, i2);
        } catch (Throwable unused) {
        }
        a(context, 2021, "Start the APP", jSONObject);
    }

    public static void a(Context context, int i2, String str, JSONObject jSONObject) {
        b(context, i2, str, jSONObject);
    }

    public static void b(Context context, int i2, String str, JSONObject jSONObject) {
        if (context == null) {
            cn.jiguang.ai.a.f("JAnalytics", "reportPushAnylysis NULL context");
        } else if (d.c()) {
            JCoreManager.onEvent(context, null, 89, "start_app", new Bundle(), new Object[0]);
        } else {
            b.a(context, "start_app_wake_save", new Bundle());
        }
    }
}
