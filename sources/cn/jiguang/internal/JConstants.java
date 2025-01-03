package cn.jiguang.internal;

import android.content.Context;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.as.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class JConstants {
    public static final byte AES_CBC = 1;
    public static String APP_KEY = "";
    public static boolean AT_I = false;
    public static boolean CMD_TO_PRINT_ALL_LOG = false;
    public static final String DATA_PROVIDER_SUFFIX = ".DataProvider";
    public static final long DAY = 86400000;
    public static boolean DEBUG_MODE = false;
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final long HOUR = 3600000;
    public static final boolean INTERNAL_USE = false;
    public static final boolean IS_FOR_GOOGLE_PLAY_USE = true;
    public static final boolean IS_FOR_GOOGLE_PURE_USE = false;
    public static final boolean LOG_ENABLE = true;
    public static final int LOG_ENABLED_LEVEL = 2;
    public static final boolean LOG_FILE_ENABLE = true;
    public static final long MIN = 60000;
    public static final boolean REPORT_SUPPORT_HTTP = false;
    public static final boolean REPORT_USE_HTTPS = true;
    public static String SDK_NAME = "";
    public static final String SDK_TYPE = "JCore";
    public static String SDK_VERSION = "3.1.2";
    public static int SDK_VERSION_INT = 312;
    public static final long SECOND = 1000;
    public static final byte SM4_CBC = 2;
    public static final boolean SUPPORT_DY = false;
    public static final String TAG = "JConstants";
    public static String TUU = "";
    public static final String USER_SERVICE_ACTION = "cn.jiguang.user.service.action";
    public static boolean isInstrumentationHookFailed = true;
    public static JAnalyticsAction jAnalyticsAction;
    public static int tcpSessionId;
    public static String testJOperateBaseUrl;
    public static AtomicBoolean isCallInit = new AtomicBoolean();
    public static int DEFAULT_HEARTBEAT_INTERVAL = 285;
    public static int DEFAULT_ALARM_DELAY = 285 + 5;
    public static byte tcpAlgorithm = 1;
    public static boolean testEnv = false;
    public static String testCountry = "";
    public static String testBannedConfigUrl = "";
    public static String testLimitConfigUrl = "";
    public static boolean isTestAndroidQ = false;
    public static Context mApplicationContext = null;

    public static Context getAppContext(Context context) {
        if (mApplicationContext == null && context != null) {
            mApplicationContext = context.getApplicationContext();
        }
        return mApplicationContext;
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
            boolean r3 = cn.jiguang.internal.JConstants.isTestAndroidQ
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
            boolean r4 = cn.jiguang.internal.JConstants.isTestAndroidQ
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
            java.lang.String r4 = "JConstants"
            cn.jiguang.as.d.c(r4, r3)
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.internal.JConstants.isAndroidQ(android.content.Context, boolean, java.lang.String):boolean");
    }

    public static boolean isTestEnv() {
        return false;
    }

    public static void setTestEnv(boolean z) {
    }

    public static void testAndroidQ() {
        d.c(TAG, "call testAndroidQ");
        isTestAndroidQ = true;
    }
}
