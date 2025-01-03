package cn.jiguang.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.analytics.page.JOperateActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.e.c;
import cn.jiguang.e.f;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static Object a() {
        return ActionManager.getActionMap();
    }

    public static JSONObject a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                d.c("JBridgeHelper", "file_name is null , give up read ");
                return null;
            }
            String d2 = c.d(c.a(context, str));
            if (!f.a(d2)) {
                return new JSONObject(d2.trim());
            }
            d.c("JBridgeHelper", "read String is empty");
            return null;
        } catch (Throwable th) {
            d.c("JBridgeHelper", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", b.b(context));
            jSONObject.put(ContentCommon.TYPE, str);
            jSONObject.put("account_id", cn.jiguang.f.b.a(context, cn.jiguang.f.a.o()));
        } catch (JSONException e2) {
            d.g("JBridgeHelper", "fillBase exception:" + e2);
        }
        return jSONObject;
    }

    public static synchronized void a(Context context) {
        String str;
        String str2;
        synchronized (a.class) {
            try {
                if (JConstants.isInstrumentationHookFailed && Build.VERSION.SDK_INT >= 14 && (context instanceof Application)) {
                    String a2 = cn.jiguang.e.a.a(context);
                    String packageName = context.getPackageName();
                    if (a2 == null || packageName == null || !context.getPackageName().equals(a2)) {
                        str = "JBridgeHelper";
                        str2 = "need not registerActivityLifecycleCallbacks in other process :" + a2;
                    } else {
                        JConstants.isInstrumentationHookFailed = false;
                        ActivityLifecycle activityLifecycle = new ActivityLifecycle();
                        ((Application) context).registerActivityLifecycleCallbacks(activityLifecycle);
                        ((Application) context).registerActivityLifecycleCallbacks(new JOperateActivityLifecycle());
                        Activity o = cn.jiguang.e.a.o(context);
                        if (o != null && ActivityLifecycle.activityTaskCount == 0) {
                            activityLifecycle.onActivityCreated(o, null);
                            activityLifecycle.onActivityStarted(o);
                            activityLifecycle.onActivityResumed(o);
                        }
                        str = "JBridgeHelper";
                        str2 = "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + a2;
                    }
                    d.c(str, str2);
                }
            } finally {
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    JCoreManager.onEvent(context, JConstants.SDK_TYPE, 3, "asm", intent.getExtras(), new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                d.g("JBridgeHelper", "shareActionRun error:" + th.getMessage());
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("shareActionRun intent error:");
        sb.append(intent == null ? LogUtils.NULL : intent.getAction());
        d.c("JBridgeHelper", sb.toString());
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(String str, String str2) {
        ActionManager.addAction(str, str2);
    }

    public static String b(Context context) {
        return (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.d());
    }

    public static String c(Context context) {
        return (String) cn.jiguang.f.b.b(context, cn.jiguang.f.a.n());
    }

    public static String d(Context context) {
        return (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.o());
    }

    public static String e(Context context) {
        return cn.jiguang.ao.a.a(context);
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
    }

    public static String g(Context context) {
        return cn.jiguang.ao.a.c(context);
    }

    public static String h(Context context) {
        return (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.a());
    }

    public static String i(Context context) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.f());
        return TextUtils.isEmpty(str) ? (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.g()) : str;
    }

    public static Object j(Context context) {
        HashMap hashMap = new HashMap();
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.k());
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.l())).longValue();
        int intValue = ((Integer) cn.jiguang.f.b.a(context, cn.jiguang.f.a.m())).intValue();
        hashMap.put("uuid", str);
        hashMap.put("ct", Long.valueOf(longValue));
        hashMap.put("state", Integer.valueOf(intValue));
        return hashMap;
    }

    public static int k(Context context) {
        return ((Integer) cn.jiguang.f.b.a(context, cn.jiguang.f.a.h())).intValue();
    }

    public static boolean l(Context context) {
        d.c("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.f.b.a(context, cn.jiguang.f.a.B());
        if (bool != null && !bool.booleanValue()) {
            d.d("JBridgeHelper", "lbs disable");
            return false;
        }
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.A())).longValue();
        long longValue2 = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.z())).longValue();
        d.c("JBridgeHelper", "lbs permission dialog shield, firstInit=" + longValue2 + ", delay=" + longValue);
        if (longValue2 > 0) {
            return longValue <= 0 || System.currentTimeMillis() > longValue2 + longValue;
        }
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.z().a((cn.jiguang.f.a<Long>) Long.valueOf(System.currentTimeMillis()))});
        return longValue <= 0;
    }

    public static int m(Context context) {
        return ((Integer) cn.jiguang.f.b.a(context, cn.jiguang.f.a.m())).intValue();
    }
}
