package cn.jpush.android.local;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.bg.b;
import cn.jpush.android.bm.a;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.JPushMessageReceiver;
import com.hjq.permissions.Permission;
import java.util.Iterator;

/* loaded from: classes.dex */
public class JPushConstants {
    public static int BUILD_ID = 179;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final int FORE_GROUND = 0;
    public static final int FORE_GROUND_NO = 1;
    public static final int FORE_GROUND_UNKNOWN = -1;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_PRE = "http://";
    public static final boolean IG = true;
    public static boolean IS_HB_PERIOD_ENABLE = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JPUSH";
    public static int SDK_VERSION_CODE = 450;
    public static String SDK_VERSION_NAME = "4.5.0";
    public static boolean SUPPORT_DY = true;
    public static final String TAG = "JPushConstants";
    public static boolean THIRD_ENABLE = true;
    public static final String USER_MESSAGE_RECEIVER_ACTION = "cn.jpush.android.intent.RECEIVE_MESSAGE";
    public static int isForeGround = -1;
    public static boolean isInitLife = false;
    public static Boolean isSameProcessWithJCommonService = null;
    public static boolean isTestAndroidQ = false;
    public static JPushMessageReceiver jPushMessageReceiver;
    public static Context mApplicationContext;
    public static String messageReceiverClass;
    public static String messageReceiverProcess;
    public static boolean tcpConnected;

    public static class TEST_CONFIG {
        public static String TEST_FILE_URL = "";
        public static String TEST_FILE_VERSION = "";
    }

    public static boolean canGetLbsInBackGround(Context context) {
        String str;
        if (isAndroidQ(context, true, "canGetLbsInBackGround")) {
            if (isForeGround != 1 || a.b(context, Permission.ACCESS_BACKGROUND_LOCATION)) {
                str = (isForeGround == -1 && !a.b(context, Permission.ACCESS_BACKGROUND_LOCATION)) ? "app is unkonwn foreground stat and no android.permission.ACCESS_BACKGROUND_LOCATION" : "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            Logger.ww(TAG, str);
            return false;
        }
        return true;
    }

    public static void changeForegroudStat(Context context, boolean z) {
        Logger.d(TAG, "changeForegroudStat:" + z);
        isForeGround = !z ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z);
        JCoreHelper.runActionWithService(context, SDK_TYPE, "change_foreground", bundle);
    }

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = context.getApplicationContext();
        }
        return mApplicationContext;
    }

    public static String getMessageReceiverClass(Context context) {
        ComponentInfo a2;
        try {
        } catch (Throwable th) {
            Logger.d(TAG, "getUserServiceClass failed:" + th.getMessage());
        }
        if (messageReceiverClass != null) {
            return messageReceiverClass;
        }
        Intent intent = new Intent();
        intent.setAction(USER_MESSAGE_RECEIVER_ACTION);
        intent.setPackage(context.getPackageName());
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo != null) {
                String str = next.activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    continue;
                } else {
                    Class<?> cls = Class.forName(str);
                    if (JPushMessageReceiver.class.isAssignableFrom(cls)) {
                        messageReceiverClass = str;
                        messageReceiverProcess = next.activityInfo.processName;
                        Logger.ii(TAG, "found messageReceiverClass :" + messageReceiverClass + "at " + messageReceiverProcess + " by getCommonReceiverNames");
                        try {
                            if (messageReceiverProcess != null && messageReceiverProcess.equals(a.d(context))) {
                                jPushMessageReceiver = (JPushMessageReceiver) cls.newInstance();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(messageReceiverClass) && (a2 = a.a(context, context.getPackageName(), (Class<?>) JPushMessageReceiver.class)) != null) {
            messageReceiverClass = a2.name;
            messageReceiverProcess = a2.processName;
            Logger.ii(TAG, "found messageReceiverClass :" + messageReceiverClass + "at " + messageReceiverProcess + " by getComponentInfo");
            try {
                if (messageReceiverProcess != null && messageReceiverProcess.equals(a.d(context))) {
                    jPushMessageReceiver = (JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance();
                }
            } catch (Throwable unused2) {
            }
        }
        if (TextUtils.isEmpty(messageReceiverClass)) {
            messageReceiverClass = "";
        }
        if (TextUtils.isEmpty(messageReceiverProcess)) {
            messageReceiverProcess = "";
        }
        return messageReceiverClass;
    }

    public static JPushMessageReceiver getPushMessageReceiver(Context context) {
        getMessageReceiverClass(getAppContext(context));
        return jPushMessageReceiver;
    }

    public static void init(Context context) {
        initPageLifecycle(context);
    }

    public static void initPageLifecycle(Context context) {
        Activity p;
        if (context == null) {
            Logger.w(TAG, "[initPageLifecycle] context is null");
            return;
        }
        Logger.d(TAG, "initPageLifecycle init, isInitLife: " + isInitLife);
        if (isInitLife) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            isInitLife = true;
            if (Build.VERSION.SDK_INT < 14 || !(applicationContext instanceof Application)) {
                return;
            }
            String d2 = a.d(applicationContext);
            String packageName = applicationContext.getPackageName();
            if (d2 == null || packageName == null || !applicationContext.getPackageName().equals(d2)) {
                Logger.d(TAG, "need not initPageLifecycle in other process :" + d2);
                d dVar = new d();
                dVar.r = 1;
                b.a(applicationContext, "sync_reg_lifecycle", dVar, (Intent) null);
                return;
            }
            ActivityLifeCallBack activityLifeCallBack = new ActivityLifeCallBack();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(activityLifeCallBack);
            if (ActivityLifeCallBack.activityTaskCount == 0 && (p = a.p(applicationContext)) != null) {
                activityLifeCallBack.onActivityCreated(p, null);
                activityLifeCallBack.onActivityStarted(p);
                activityLifeCallBack.onActivityResumed(p);
            }
            Logger.d(TAG, "initPageLifecycle in main process, packageName:" + packageName + ", currentProcessName:" + d2);
        } catch (Throwable th) {
            Logger.ww(TAG, "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        if (r3.getApplicationInfo().targetSdkVersion <= 28) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isAndroidQ(android.content.Context r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            r2 = 28
            if (r4 != 0) goto L16
            boolean r3 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r3 == 0) goto Lf
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r2) goto L14
            goto L2b
        Lf:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 <= r2) goto L14
            goto L2b
        L14:
            r0 = 0
            goto L2b
        L16:
            boolean r4 = cn.jpush.android.local.JPushConstants.isTestAndroidQ
            if (r4 == 0) goto L1f
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r2) goto L14
            goto L23
        L1f:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 <= r2) goto L14
        L23:
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            if (r3 <= r2) goto L14
        L2b:
            if (r0 == 0) goto L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "is Android Q, msg: "
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "JPushConstants"
            cn.jpush.android.helper.Logger.d(r4, r3)
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.local.JPushConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean isSameProcessWithJCommonService(Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            Logger.w(TAG, "call isSameProcessWithJCommonService failed:" + th.getMessage());
        }
        if (isSameProcessWithJCommonService != null) {
            return isSameProcessWithJCommonService.booleanValue();
        }
        if (messageReceiverProcess == null) {
            getMessageReceiverClass(context);
        }
        ComponentInfo a2 = a.a(context, context.getPackageName(), (Class<?>) JCommonService.class);
        if (a2 != null) {
            if (a2.processName.equals(messageReceiverProcess)) {
                Logger.dd(TAG, "same process with JCommonService");
                z = true;
            } else {
                Logger.dd(TAG, "is not same process with JCommonService");
                z = false;
            }
            isSameProcessWithJCommonService = z;
            return isSameProcessWithJCommonService.booleanValue();
        }
        return false;
    }

    public static boolean isTcpConnected() {
        return tcpConnected;
    }

    public static void setTcpConnected(boolean z) {
        tcpConnected = z;
    }

    public static void testAndroidQ() {
    }
}
