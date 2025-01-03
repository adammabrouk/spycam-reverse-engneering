package cn.jpush.android.l;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static JSONObject a(Context context, String str) {
        Object onEvent = JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 42, null, null, str);
        if (onEvent instanceof JSONObject) {
            return (JSONObject) onEvent;
        }
        return null;
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        Object onEvent = JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 26, "", null, jSONObject, str);
        if (onEvent instanceof JSONObject) {
            return (JSONObject) onEvent;
        }
        return null;
    }

    public static void a(Context context) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 29, null, null, 3);
    }

    public static void a(Context context, int i2, int i3, long j, long j2, byte[] bArr) {
        a(context, cn.jpush.android.m.a.b(), i2, i3, j, j2, bArr, true);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 39, null, null, obj);
    }

    public static void a(Context context, Runnable runnable) {
        JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 78, null, null, runnable);
    }

    public static void a(Context context, String str, int i2, int i3, long j, long j2, byte[] bArr, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i2);
        bundle.putInt("ver", i3);
        bundle.putLong("rid", j);
        bundle.putLong("timeout", j2);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z ? 17 : 16, null, bundle, new Object[0]);
    }

    public static void a(Context context, String str, Bundle bundle) {
        JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 3, str, bundle, new Object[0]);
    }

    public static void a(Context context, String str, Runnable runnable) {
        JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 11, str, null, runnable);
    }

    public static void a(Context context, Thread thread, Throwable th) {
        JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 93, null, null, thread, th);
    }

    public static void a(String str, String str2, boolean z, int i2, String str3, Throwable th) {
        try {
            JCoreManager.onEvent(null, str, 18, str2, null, Integer.valueOf(i2), Boolean.valueOf(z), str3, th);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        Object onEvent = JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 41, null, null, str, jSONObject);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static long b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 20, null, null, null);
        if (onEvent instanceof Long) {
            return ((Long) onEvent).longValue();
        }
        return 0L;
    }

    public static void b(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.u.a.f9866a >= 238) {
            JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 75, null, null, runnable);
        } else {
            a(context, str, runnable);
        }
    }

    public static String c(Context context) {
        Object onEvent = JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 7, null, null, null);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static void c(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.u.a.f9866a >= 238) {
            JCoreManager.onEvent(context, cn.jpush.android.m.a.b(), 77, null, null, runnable);
        } else {
            a(context, str, runnable);
        }
    }

    public static String d(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 6, null, null, null);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String e(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 92, null, null, null);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
