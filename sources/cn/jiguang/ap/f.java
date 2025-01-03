package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f8291a = 3;

    /* renamed from: b, reason: collision with root package name */
    public static int f8292b = 500;

    public static Bundle a(Context context, int i2) {
        cn.jiguang.ar.f.a("JOperateJCoreHelper", "getDeviceInfoP start:" + i2);
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 94, null, null, new Object[0]);
        cn.jiguang.ar.f.a("JOperateJCoreHelper", "getDeviceInfoP：" + i2 + ":" + onEvent);
        return onEvent instanceof Bundle ? (Bundle) onEvent : new Bundle();
    }

    public static JSONObject a(Context context) {
        for (int i2 = 0; i2 < f8291a; i2++) {
            Bundle a2 = a(context, i2);
            if (a2.getBoolean("isServiceProcess", false)) {
                try {
                    return new JSONObject(a2.getString("de_inf"));
                } catch (Throwable unused) {
                    return new JSONObject();
                }
            }
            try {
                Thread.sleep(f8292b);
            } catch (Throwable unused2) {
            }
        }
        return new JSONObject();
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(final Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, new cn.jiguang.bj.b("JOperate") { // from class: cn.jiguang.ap.f.1
            @Override // cn.jiguang.bj.b
            public void a() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public static synchronized Bundle b(Context context, int i2) {
        synchronized (f.class) {
            cn.jiguang.ar.f.a("JOperateJCoreHelpergetGPSP", "getGPSP start:" + i2);
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 91, null, null, new Object[0]);
            cn.jiguang.ar.f.a("JOperateJCoreHelper", "getGPS：" + i2 + ":" + onEvent);
            if (onEvent instanceof Bundle) {
                return (Bundle) onEvent;
            }
            return new Bundle();
        }
    }

    public static String b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 6, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String c(Context context) {
        Object onEvent = JCoreManager.onEvent(null, JConstants.SDK_TYPE, 92, null, null, new Object[0]);
        if (onEvent instanceof String) {
            return (String) onEvent;
        }
        return null;
    }

    public static Bundle d(Context context) {
        for (int i2 = 0; i2 < f8291a; i2++) {
            Bundle b2 = b(context, i2);
            if (b2.getBoolean("isServiceProcess", false)) {
                return b2;
            }
            try {
                Thread.sleep(f8292b);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String e(Context context) {
        return cn.jiguang.d.a.b(context);
    }

    public static long f(Context context) {
        return cn.jiguang.d.a.f(context);
    }

    public static String g(Context context) {
        return cn.jiguang.e.a.a(context);
    }

    public static String h(Context context) {
        return cn.jiguang.e.g.c(context);
    }

    public static String i(Context context) {
        return cn.jiguang.e.g.b(context);
    }

    public static boolean j(Context context) {
        return 1 == cn.jiguang.e.g.a(context);
    }

    public static String k(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 8, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String l(Context context) {
        return cn.jiguang.d.a.e(context);
    }

    public static Boolean m(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 82, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return (Boolean) onEvent;
        }
        return false;
    }
}
