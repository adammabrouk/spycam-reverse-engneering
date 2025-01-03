package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.a.a;
import cn.jiguang.ao.f;
import cn.jiguang.as.d;
import cn.jiguang.e.e;
import cn.jiguang.f.b;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import com.shix.shixipc.system.ContentCommon;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class JCoreManager {
    public static final String TAG = "JCoreManager";
    public static final AtomicBoolean isInited = new AtomicBoolean();

    public static void addDispatchAction(String str, String str2) {
        a.c(e.a());
        cn.jiguang.d.a.a(str, str2);
    }

    public static void changeLiveStatus(boolean z) {
    }

    public static Context getAppContext(Context context) {
        return JConstants.getAppContext(context);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        Object onEvent = JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 67, false, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean getDebugMode() {
        return JConstants.DEBUG_MODE;
    }

    public static void init(Context context) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext == null) {
            return;
        }
        JConstants.isCallInit.set(true);
        if (isInited.get()) {
            return;
        }
        isInited.set(true);
        try {
            if (f.a(appContext)) {
                isInited.set(false);
                JConstants.isCallInit.set(false);
            } else {
                cn.jiguang.d.a.a(appContext);
                JCoreInternalHelper.getInstance().onEvent(appContext, JConstants.SDK_TYPE, 10, true, "tcp_a1", null, new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }

    public static void initCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 70, true, null, null, new Object[0]);
    }

    public static boolean isInternal() {
        return false;
    }

    public static boolean isTestEnv() {
        return JConstants.isTestEnv();
    }

    public static Object onEvent(Context context, String str, int i2, String str2, Bundle bundle, Object... objArr) {
        boolean z;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 18:
            case 19:
            case 20:
            case 21:
            case 25:
            case 26:
            case 32:
            case 33:
            case 34:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 49:
            case 53:
            case 58:
            case 60:
            case 63:
            case 64:
            case 67:
            case 68:
            case 69:
            case 75:
            case 76:
            case 77:
            case 78:
            case 82:
            case 83:
            case 90:
            case 91:
            case 92:
            case 94:
            case 95:
            case 96:
                z = false;
                break;
            default:
                z = true;
                break;
        }
        return onEvent(context, str, i2, z, str2, bundle, objArr);
    }

    public static Object onEvent(Context context, String str, int i2, boolean z, String str2, Bundle bundle, Object... objArr) {
        if (i2 != 18 && i2 != 13 && i2 != 52) {
            init(context);
        }
        return JCoreInternalHelper.getInstance().onEvent(context, str, i2, z, str2, bundle, objArr);
    }

    public static void register(Context context, String str) {
        try {
            if (f.a(context)) {
                JConstants.isCallInit.set(false);
                return;
            }
            JConstants.isCallInit.set(true);
            cn.jiguang.d.a.a(context);
            String b2 = cn.jiguang.ao.a.b(context);
            if (!TextUtils.isEmpty(b2) && !b2.equals(str)) {
                d.h(TAG, "[register] not same appkey with manifest,please check it");
                Bundle bundle = new Bundle();
                bundle.putString("appkey", str);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "a5", bundle, new Object[0]);
            }
            JConstants.APP_KEY = str;
            Bundle bundle2 = new Bundle();
            bundle2.putString("appkey", str);
            JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "a5", bundle2, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void reportWakedData(Context context, Bundle bundle, int i2) {
        if (context == null) {
            d.h(TAG, "[reportWakedData] context was null");
            return;
        }
        if (bundle == null) {
            d.h(TAG, "[reportWakedData] bundle was null");
            return;
        }
        int i3 = bundle.getInt(ContentCommon.TYPE, -1);
        if (i3 != -1) {
            i2 = i3;
        }
        if (i2 != 8 && i2 != 16) {
            d.h(TAG, "[reportWakedData] wrong type:" + i2);
            return;
        }
        bundle.putInt(ContentCommon.TYPE, i2);
        d.c(TAG, "action - reportWakedData" + bundle.toString());
        onEvent(context, null, 74, null, bundle, new Object[0]);
    }

    public static void requestPermission(Context context) {
        String str;
        if (context == null) {
            str = "[requestPermission] context was null";
        } else if (!(context instanceof Activity)) {
            str = "[requestPermission] context must instanceof Activity";
        } else if (Build.VERSION.SDK_INT < 23) {
            str = "[requestPermission] android.os.Build.VERSION.SDK_INT<23";
        } else {
            if (context.getApplicationInfo().targetSdkVersion >= 23) {
                if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
                    return;
                }
                try {
                    List<String> a2 = cn.jiguang.e.a.a(context, new LinkedList());
                    if (a2 != null && !a2.isEmpty()) {
                        d.a(TAG, "lackPermissions:" + a2);
                        Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a2.toArray(new String[a2.size()]), 1);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    d.h(TAG, "#unexcepted - requestPermission e:" + e2);
                    return;
                }
            }
            str = "[requestPermission] app targetSdkVersion<23";
        }
        d.h(TAG, str);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        JConstants.jAnalyticsAction = jAnalyticsAction;
    }

    public static void setDebugMode(boolean z) {
        JConstants.DEBUG_MODE = z;
    }

    public static void setLBSEnable(Context context, boolean z) {
        d.c(TAG, "action - setLBSEnable-control:" + z);
        if (!z) {
            try {
                b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.B().a((cn.jiguang.f.a<Boolean>) false)});
            } catch (Throwable unused) {
            }
        }
        onEvent(context, null, 27, null, null, Boolean.valueOf(z));
    }

    public static void setSDKConfigs(Context context, Bundle bundle) {
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 55, true, null, bundle, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        onEvent(context, JConstants.SDK_TYPE, 71, true, null, null, new Object[0]);
    }

    public static void unRegister(Context context) {
        JConstants.isCallInit.set(true);
        cn.jiguang.d.a.a(context);
        JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 10, true, "tcp_a23", null, new Object[0]);
    }
}
