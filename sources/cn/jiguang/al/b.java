package cn.jiguang.al;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.JConstants;
import cn.jiguang.l.e;
import com.shix.shixipc.system.ContentCommon;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public Context f8189a;

        /* renamed from: c, reason: collision with root package name */
        public JSONObject f8190c;

        public a(Context context, JSONObject jSONObject) {
            this.f8189a = context;
            this.f8190c = jSONObject;
            this.f8954b = "JWakeCmd#WakeAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            try {
                long e2 = cn.jiguang.l.b.e(this.f8189a, "JWakeCmdcmd");
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f8190c == null && currentTimeMillis - e2 < JConstants.HOUR) {
                    cn.jiguang.ai.a.d("JWakeCmd", "is not cmd wake time");
                }
                b.c(this.f8189a, this.f8190c);
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JWakeCmd", "WakeAction failed:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            cn.jiguang.ai.a.a("JWakeCmd", jSONObject == null ? "executeWakeAction: [JWakeCmd] from heartBeat" : "executeWakeAction: [JWakeCmd] from cmd");
            boolean booleanValue = ((Boolean) cn.jiguang.al.a.b(context)).booleanValue();
            cn.jiguang.ai.a.a("JWakeCmd", "JWakeCmd isActionUserEnable:" + booleanValue);
            if (booleanValue) {
                cn.jiguang.l.d.a(new a(context, jSONObject));
            }
        } catch (Throwable th) {
            cn.jiguang.ai.a.e("JWakeCmd", "[executeWakeAction] failed:" + th.getMessage());
        }
    }

    public static void c(Context context, JSONObject jSONObject) {
        List<cn.jiguang.am.c> list;
        ApplicationInfo applicationInfo;
        try {
            cn.jiguang.l.b.d(context, "JWakeCmdcmd");
            String c2 = cn.jiguang.p.c.c(context, "bwct.catch.v2");
            cn.jiguang.ai.a.a("JWakeCmd", "read cmd wakeTarget:" + c2);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    int optInt = jSONObject2.optInt(ContentCommon.TYPE, 1);
                    String optString = jSONObject2.optString("pkgName", "");
                    String optString2 = jSONObject2.optString("serviceName", "");
                    list = null;
                    if (optInt == 1) {
                        try {
                            applicationInfo = context.getPackageManager().getApplicationInfo(optString, RecyclerView.c0.FLAG_IGNORE);
                        } catch (Throwable unused) {
                            cn.jiguang.ai.a.e("JWakeCmd", "not found application:" + optString);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            list = new ArrayList<>();
                            cn.jiguang.am.c cVar = new cn.jiguang.am.c();
                            cVar.f8205a = optString;
                            cVar.f8206b = optString2;
                            cVar.f8207c = applicationInfo.targetSdkVersion;
                            cVar.f8213i = 1;
                            cVar.f8211g = 4;
                            list.add(cVar);
                        }
                    }
                    String a2 = cn.jiguang.an.c.a(cn.jiguang.an.d.a(c2, optString, optString2, optInt));
                    cn.jiguang.ai.a.a("JWakeCmd", "write cmd wakeTarget:" + a2);
                    cn.jiguang.p.c.a(context, "bwct.catch.v2", a2);
                } catch (Throwable th) {
                    cn.jiguang.ai.a.d("JWakeCmd", "stop wake,the json form cmd is illegal:" + th.getMessage());
                    return;
                }
            } else {
                if (c2 == null || TextUtils.isEmpty(c2)) {
                    cn.jiguang.ai.a.d("JWakeCmd", "there are no cache cmd wakeTarget");
                    return;
                }
                list = cn.jiguang.an.c.a(context, cn.jiguang.an.c.a(c2));
            }
            if (list != null) {
                cn.jiguang.al.a.a(context, list);
            }
        } catch (Throwable th2) {
            cn.jiguang.ai.a.d("JWakeCmd", "parse throwable:" + th2.getMessage());
        }
    }
}
