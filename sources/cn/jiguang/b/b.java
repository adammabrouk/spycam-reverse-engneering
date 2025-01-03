package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.as.d;
import cn.jiguang.au.f;
import cn.jiguang.internal.JConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.bj.b implements ReportCallBack {
    public b() {
        this.f8813h = "ReportCrashLogDirect";
    }

    private JSONObject a(Context context) {
        JSONArray c2 = a.c(context);
        if (c2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", c2);
            jSONObject.put("network_type", cn.jiguang.e.a.l(context));
            cn.jiguang.d.a.a(context, jSONObject, "crash_log");
            Object a2 = cn.jiguang.c.b.a(context);
            JSONObject jSONObject2 = a2 instanceof JSONObject ? (JSONObject) a2 : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("device_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.bj.b
    public void a() {
        try {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                d.g("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject a2 = a(appContext);
            if (a2 != null) {
                f.a(appContext, a2, this);
            }
        } catch (Throwable th) {
            d.i("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i2) {
        d.g("ReportCrashLogDirect", "ReportDirect finish : " + i2);
        if (i2 == 0) {
            a.d(JConstants.getAppContext(null));
        }
    }
}
