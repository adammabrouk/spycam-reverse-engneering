package cn.jpush.android.api;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.be.d;
import cn.jpush.android.bk.a;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.b;
import cn.jpush.android.helper.c;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JPushInterface {
    public static final String ACTION_CONNECTION_CHANGE = "cn.jpush.android.intent.CONNECTION";
    public static final String ACTION_IN_APP_MSG_CLICK = "cn.jpush.android.intent.IN_APP_MSG_CLICK";
    public static final String ACTION_IN_APP_MSG_RECEIVED = "cn.jpush.android.intent.IN_APP_MSG_RECEIVED";
    public static final String ACTION_MESSAGE_RECEIVED = "cn.jpush.android.intent.MESSAGE_RECEIVED";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    public static final String ACTION_NOTIFICATION_OPENED = "cn.jpush.android.intent.NOTIFICATION_OPENED";
    public static final String ACTION_NOTIFICATION_RECEIVED = "cn.jpush.android.intent.NOTIFICATION_RECEIVED";
    public static final String ACTION_NOTIFICATION_RECEIVED_PROXY = "cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY";
    public static final String ACTION_REGISTRATION_ID = "cn.jpush.android.intent.REGISTRATION";
    public static final String ACTION_RICHPUSH_CALLBACK = "cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK";
    public static int DEFAULT_NOTIFICATION_NUM = 5;
    public static final String EXTRA_ACTIVITY_PARAM = "cn.jpush.android.ACTIVITY_PARAM";
    public static final String EXTRA_ALERT = "cn.jpush.android.ALERT";
    public static final String EXTRA_ALERT_TYPE = "cn.jpush.android.ALERT_TYPE";
    public static final String EXTRA_APP_KEY = "cn.jpush.android.APPKEY";
    public static final String EXTRA_BIG_PIC_PATH = "cn.jpush.android.BIG_PIC_PATH";
    public static final String EXTRA_BIG_TEXT = "cn.jpush.android.BIG_TEXT";
    public static final String EXTRA_CONNECTION_CHANGE = "cn.jpush.android.CONNECTION_CHANGE";
    public static final String EXTRA_CONTENT_TYPE = "cn.jpush.android.CONTENT_TYPE";
    public static final String EXTRA_EXTRA = "cn.jpush.android.EXTRA";
    public static final String EXTRA_INBOX = "cn.jpush.android.INBOX";
    public static final String EXTRA_MESSAGE = "cn.jpush.android.MESSAGE";
    public static final String EXTRA_MSG_ID = "cn.jpush.android.MSG_ID";
    public static final String EXTRA_NOTIFICATION_ACTION_EXTRA = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA";
    public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0 = "cn.jpush.android.NOTIFICATION_DEVELOPER_ARG0";
    public static final String EXTRA_NOTIFICATION_ID = "cn.jpush.android.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_LARGET_ICON = "cn.jpush.android.NOTIFICATION_LARGE_ICON";
    public static final String EXTRA_NOTIFICATION_SMALL_ICON = "cn.jpush.android.NOTIFICATION_SMALL_ICON";
    public static final String EXTRA_NOTIFICATION_TITLE = "cn.jpush.android.NOTIFICATION_CONTENT_TITLE";
    public static final String EXTRA_NOTIFICATION_URL = "cn.jpush.android.NOTIFICATION_URL";
    public static final String EXTRA_NOTI_CATEGORY = "cn.jpush.android.NOTI_CATEGORY";
    public static final String EXTRA_NOTI_PRIORITY = "cn.jpush.android.NOTI_PRIORITY";
    public static final String EXTRA_NOTI_TYPE = "cn.jpush.android.NOTIFICATION_TYPE";
    public static final String EXTRA_PUSH_ID = "cn.jpush.android.PUSH_ID";
    public static final String EXTRA_REGISTRATION_ID = "cn.jpush.android.REGISTRATION_ID";
    public static final String EXTRA_RICHPUSH_FILE_PATH = "cn.jpush.android.FILE_PATH";
    public static final String EXTRA_RICHPUSH_FILE_TYPE = "cn.jpush.android.FILE_TYPE";
    public static final String EXTRA_RICHPUSH_HTML_PATH = "cn.jpush.android.HTML_PATH";
    public static final String EXTRA_RICHPUSH_HTML_RES = "cn.jpush.android.HTML_RES";
    public static final String EXTRA_STATUS = "cn.jpush.android.STATUS";
    public static final String EXTRA_TITLE = "cn.jpush.android.TITLE";
    public static final String EXTRA_TYPE_PLATFORM = "cn.jpush.android.TYPE_PLATFORM";
    public static final String PUSH_MESSAGE_PERMISSION_POSTFIX = ".permission.JPUSH_MESSAGE";

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f9178a = 0;

    public static class ErrorCode {
        public static int ERROR_CODE_ALIAS_LIMIT = 6027;
        public static int ERROR_CODE_ALIAS_OPERATORING = 6022;
        public static int ERROR_CODE_BLACKLIST = 6015;
        public static int ERROR_CODE_GET_FAILED = 6019;
        public static int ERROR_CODE_INTERNEL_SERVER_ERROR = 6024;
        public static int ERROR_CODE_INVALIDREQ = 6017;
        public static int ERROR_CODE_INVALIDUSER = 6016;
        public static int ERROR_CODE_INVALID_MOBILENUMBER = 6023;
        public static int ERROR_CODE_MODE_NOT_MATCH = 6034;
        public static int ERROR_CODE_NOT_PULL_IN_BLOCK_LIST = 6035;
        public static int ERROR_CODE_NO_IN_APP_DATA = 6029;
        public static int ERROR_CODE_OVER_FREQUENCY = 6031;
        public static int ERROR_CODE_OVER_FREQUENCY_SRV = 6030;
        public static int ERROR_CODE_SERVER_INTERNAL_ERROR = 6033;
        public static int ERROR_CODE_SERVER_UNAVAILABLE = 6020;
        public static int ERROR_CODE_STYLE_NOT_SUPPORT = 6032;
        public static int ERROR_CODE_TAG_OPERATORING = 6021;
        public static int ERROR_CODE_TOO_BUSY = 6014;
        public static int ERROR_CODE_TOO_LONG_MOBILENUMBER = 6025;
        public static int ERROR_CODE_TOO_MANY_TAGS = 6018;
        public static int HAS_IN_APP_DATA = 6028;
        public static int INCORRECT_TIME = 6013;
        public static int INVALID_ALIAS = 6003;
        public static int INVALID_JSON = 6010;
        public static int INVALID_TAGS = 6005;
        public static int INVOKE_TOO_SOON = 6011;
        public static int NULL_TAGANDALIAS = 6001;
        public static int PUSH_STOPED = 6012;
        public static int SUCCESS = 0;
        public static int TIMEOUT = 6002;
        public static int TOO_LONG_ALIAS = 6004;
        public static int TOO_LONG_TAGALIAS = 6008;
        public static int TOO_LONG_TAGS = 6006;
        public static int TOO_MANY_TAGS = 6007;
        public static int UNKNOWN_ERROR = 6009;
    }

    public static class InAppStyle {
        public static int STYLE_BANNER = 1;
        public static int STYLE_FLOAT = 4;
        public static int STYLE_MODAL = 2;
    }

    static {
        JCoreManager.addDispatchAction(JPushConstants.SDK_TYPE, b.class.getName());
    }

    public static void addLocalNotification(Context context, JPushLocalNotification jPushLocalNotification) {
        checkContext(context);
        d.a(context, jPushLocalNotification);
    }

    public static void addTags(Context context, int i2, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, set, 1, 1);
    }

    public static void attachBaseContext(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("attachBaseContext", Context.class).invoke(null, context);
            Logger.d("JPushInterface", "use time:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable unused) {
        }
    }

    public static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        JPushConstants.mApplicationContext = context.getApplicationContext();
    }

    public static boolean checkLengthOfTags(String str) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length + 0 : 0;
        Logger.v("JPushInterface", "tags length:" + length);
        return length <= 7000;
    }

    public static void checkSupportVasMessage(Context context, int i2) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(ContentCommon.TYPE, i2);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_vas_integrate", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void checkTagBindState(Context context, int i2, String str) {
        HashSet hashSet;
        checkContext(context);
        if (TextUtils.isEmpty(str)) {
            hashSet = null;
        } else {
            hashSet = new HashSet();
            hashSet.add(str);
        }
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, hashSet, 1, 6);
    }

    public static void cleanTags(Context context, int i2) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, new HashSet(), 1, 4);
    }

    public static void clearAllNotifications(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "clear_all_notify", null);
    }

    public static void clearLocalNotifications(Context context) {
        checkContext(context);
        d.a(context);
    }

    public static void clearNotificationById(Context context, int i2) {
        checkContext(context);
        if (i2 <= 0) {
            Logger.ee("JPushInterface", "Invalid notificationId, Give up action..");
        } else {
            ((NotificationManager) context.getSystemService("notification")).cancel(i2);
            JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "clear_by_id", null);
        }
    }

    public static void deleteAlias(Context context, int i2) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i2, null, 2, 3);
    }

    public static void deleteGeofence(Context context, String str) {
        checkContext(context);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "delete_geo_fence", bundle);
    }

    public static void deleteTags(Context context, int i2, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, set, 1, 3);
    }

    public static Set<String> filterValidTags(Set<String> set) {
        return a.a(set);
    }

    public static void getAlias(Context context, int i2) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i2, null, 2, 5);
    }

    public static void getAllTags(Context context, int i2) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, new HashSet(), 1, 5);
    }

    @Deprecated
    public static boolean getConnectionState(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_connection", null);
        return JCoreManager.getConnectionState(context);
    }

    public static String getRegistrationID(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "get_rid", null);
        return JCoreHelper.getRegistrationID(context);
    }

    public static String getStringTags(Set<String> set) {
        return a.b(set);
    }

    public static String getUdid(Context context) {
        checkContext(context);
        return JCoreHelper.getDeviceId(context);
    }

    public static void goToAppNotificationSettings(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "go_settings", null);
        if (cn.jpush.android.bg.b.e(context)) {
            return;
        }
        cn.jpush.android.bg.b.f(context);
    }

    public static void init(Context context) {
        Logger.dd("JPushInterface", "action:init - sdkVersion:" + JPushConstants.SDK_VERSION_NAME + ", buildId:" + JPushConstants.BUILD_ID);
        checkContext(context);
        if (cn.jpush.android.bm.a.h(context)) {
            JPushConstants.init(context);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "init", null);
            ActionHelper.getInstance().doSingleAction(context, "third_init", null);
        }
    }

    public static void initCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.initCrashHandler(context);
    }

    public static int isNotificationEnabled(Context context) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "is_enable", null);
        return cn.jpush.android.bg.b.d(context);
    }

    public static boolean isPushStopped(Context context) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "check_stop", null);
        return cn.jpush.android.cache.a.e(context);
    }

    public static void onFragmentPause(Context context, String str) {
        JCoreHelper.saEvent(context, "f_pause", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", false);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onFragmentResume(Context context, String str) {
        JCoreHelper.saEvent(context, "f_resume", str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("JPushInterface", "fragmentName can not null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putBoolean("state", true);
        ActionHelper.getInstance().doSingleAction(context, "sync_fragment_life", bundle);
    }

    public static void onKillProcess(Context context) {
        JCoreHelper.saEvent(context, "kill", null);
    }

    public static void onPause(Context context) {
        JCoreHelper.saEvent(context, "pause", null);
    }

    public static void onResume(Context context) {
        JCoreHelper.saEvent(context, "resume", null);
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i2) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i2);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static void pullInAppMessage(Context context, int i2, int i3) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i2);
            bundle.putInt(ContentCommon.TYPE, i3);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void pullInAppMessage(Context context, int i2, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i2);
            bundle.putString("AdPositionKey", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void pullInAppMessageWithParams(Context context, InAppSlotParams inAppSlotParams) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            if (inAppSlotParams != null) {
                bundle.putString("inapp_param", inAppSlotParams.toJSONString());
            }
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_req", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void removeLocalNotification(Context context, long j) {
        checkContext(context);
        d.a(context, j);
    }

    public static void reportMessageOpened(Context context, String str, byte b2) {
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            c.a(str, "", b2, 1028, context);
            return;
        }
        Logger.ee("JPushInterface", "The msgId is not valid - " + str);
    }

    public static void reportNotificationOpened(Context context, String str) {
        checkContext(context);
        if (!TextUtils.isEmpty(str)) {
            c.a(str, 1028, context);
            return;
        }
        Logger.ee("JPushInterface", "The msgId is not valid - " + str);
    }

    public static void reportNotificationOpened(Context context, String str, byte b2) {
    }

    public static void reportNotificationOpened(Context context, String str, byte b2, String str2) {
    }

    public static void reportWakedData(Context context, Bundle bundle, int i2) {
        checkContext(context);
        try {
            JCoreManager.reportWakedData(context, bundle, i2);
        } catch (Throwable unused) {
            Logger.ee("JPushInterface", "not found [reportWakedData] in jcore");
        }
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            Logger.ww("JPushInterface", "[requestPermission] unexcepted - context was null");
        } else {
            JCoreManager.requestPermission(context);
        }
    }

    public static void resumePush(Context context) {
        Logger.dd("JPushInterface", "action:resumePush");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "resume", null);
        ActionHelper.getInstance().doSingleAction(context, "third_resume", null);
    }

    public static void setAlias(Context context, int i2, String str) {
        checkContext(context);
        ActionHelper.getInstance().setAliasWithCallBack(context, i2, str, 2, 2);
    }

    @Deprecated
    public static void setAlias(Context context, String str, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, str, null, tagAliasCallback);
    }

    @Deprecated
    public static void setAliasAndTags(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        ActionHelper.getInstance().setAliasAndTagsWithCallBack(context, str, set, tagAliasCallback, 0, 0);
    }

    public static void setBadgeNumber(Context context, int i2) {
        Context appContext = JPushConstants.getAppContext(context);
        if (i2 < 0) {
            i2 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i2);
        JCoreHelper.runActionWithService(appContext, JPushConstants.SDK_TYPE, "set_badge", bundle);
    }

    public static void setChannel(Context context, String str) {
        JCoreHelper.setChannel(context, str);
    }

    public static void setDaemonAction(String str) {
    }

    public static void setDebugMode(boolean z) {
        JCoreManager.setDebugMode(z);
    }

    public static void setDefaultNotifactionNumber(Context context) {
        setLatestNotificationNumber(context, DEFAULT_NOTIFICATION_NUM);
    }

    public static void setDefaultPushNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL notification");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", f9178a.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    public static void setGeofenceInterval(Context context, long j) {
        checkContext(context);
        if (j < 180000 || j > JConstants.DAY) {
            Logger.ee("JPushInterface", "Invalid interval, it should be a ms number between 3 mins and 1 day!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("interval", j);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_interval", bundle);
    }

    public static void setHbPeriodEnable(Context context, boolean z) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_hb_period_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void setLatestNotificationNumber(Context context, int i2) {
        checkContext(context);
        Logger.dd("JPushInterface", "action:setLatestNotificationNumber : " + i2);
        if (i2 <= 0) {
            Logger.ee("JPushInterface", "maxNum should > 0, Give up action..");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i2);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "max_num", bundle);
    }

    public static void setLbsEnable(Context context, boolean z) {
        try {
            JCoreManager.setLBSEnable(context, z);
        } catch (Throwable unused) {
            Logger.ee("JPushInterface", "not found [setLBSEnable] in jcore");
        }
        if (!z) {
            try {
                cn.jpush.android.cache.a.d(context, false);
            } catch (Throwable unused2) {
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable", z);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "enable_lbs", bundle);
    }

    public static void setMaxGeofenceNumber(Context context, int i2) {
        checkContext(context);
        if (i2 < 1 || i2 > 100) {
            Logger.ee("JPushInterface", "Invalid maxNumber,it should be a number between 1 and 100!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", i2);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "geo_fence_max_num", bundle);
    }

    public static void setMobileNumber(Context context, int i2, String str) {
        checkContext(context);
        cn.jpush.android.helper.d.a().a(context, i2, str);
    }

    public static void setPowerSaveMode(Context context, boolean z) {
    }

    public static void setPushNotificationBuilder(Integer num, PushNotificationBuilder pushNotificationBuilder) {
        Logger.vv("JPushInterface", "action:setPushNotificationBuilder - id:" + num);
        if (pushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL pushNotificationBuilder");
        }
        if (num.intValue() < 1) {
            Logger.ee("JPushInterface", "id should be larger than 0");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("buidler_id", num.intValue());
        bundle.putString("buidler_string", pushNotificationBuilder.toString());
        JCoreHelper.runActionWithService(JPushConstants.mApplicationContext, JPushConstants.SDK_TYPE, "set_custom_notify", bundle);
    }

    public static void setPushTime(Context context, Set<Integer> set, int i2, int i3) {
        checkContext(context);
        if (!cn.jpush.android.bm.a.a(context)) {
            Logger.dd("JPushInterface", "检测到当前没有网络。此动作将在有网络时自动继续执行。");
        }
        if (set == null) {
            Bundle bundle = new Bundle();
            bundle.putString("time", "0123456_0^23");
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle);
            return;
        }
        if (set.size() == 0 || set.isEmpty()) {
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "disable_push", null);
            return;
        }
        if (i2 > i3) {
            Logger.ee("JPushInterface", "Invalid time format - startHour should less than endHour");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : set) {
            if (num.intValue() > 6 || num.intValue() < 0) {
                Logger.ee("JPushInterface", "Invalid day format - " + num);
                return;
            }
            sb.append(num);
        }
        sb.append("_");
        sb.append(i2);
        sb.append("^");
        sb.append(i3);
        Bundle bundle2 = new Bundle();
        bundle2.putString("time", sb.toString());
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "pushtime", bundle2);
    }

    public static void setSilenceTime(Context context, int i2, int i3, int i4, int i5) {
        checkContext(context);
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || i3 > 59 || i5 > 59 || i4 > 23 || i2 > 23) {
            Logger.ee("JPushInterface", "Invalid parameter format, startHour and endHour should between 0 ~ 23, startMins and endMins should between 0 ~ 59. ");
            return;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("time", "");
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle);
            Logger.dd("JPushInterface", "Remove the silence time!");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startHour", i2);
            jSONObject.put("startMins", i3);
            jSONObject.put("endHour", i4);
            jSONObject.put("endtMins", i5);
            Bundle bundle2 = new Bundle();
            bundle2.putString("time", jSONObject.toString());
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "silenceTime", bundle2);
        } catch (JSONException unused) {
        }
    }

    public static void setStatisticsEnable(boolean z) {
    }

    public static void setStatisticsSessionTimeout(long j) {
    }

    public static void setTags(Context context, int i2, Set<String> set) {
        checkContext(context);
        ActionHelper.getInstance().setTagsWithCallBack(context, i2, set, 1, 2);
    }

    @Deprecated
    public static void setTags(Context context, Set<String> set, TagAliasCallback tagAliasCallback) {
        checkContext(context);
        setAliasAndTags(context, null, set, tagAliasCallback);
    }

    public static void setThirdPushEnable(Context context, boolean z) {
        try {
            JPushConstants.THIRD_ENABLE = z;
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_enable", bundle);
        } catch (Throwable unused) {
        }
    }

    public static void si(Context context, Bundle bundle) {
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "si", bundle);
    }

    public static void stopCrashHandler(Context context) {
        checkContext(context);
        JCoreManager.stopCrashHandler(context);
    }

    public static void stopPush(Context context) {
        Logger.dd("JPushInterface", "action:stopPush");
        checkContext(context);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "stop", null);
        ActionHelper.getInstance().doSingleAction(context, "third_stop", null);
    }

    public static void taq() {
        JPushConstants.testAndroidQ();
    }

    public static void triggerInAppMsgByEvent(Context context, int i2, String str) {
        checkContext(context);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i2);
            bundle.putString("event_name", str);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "trigger_in_app_event", bundle);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public void setAliasAndTags(Context context, String str, Set<String> set) {
        checkContext(context);
        setAliasAndTags(context, str, set, null);
    }
}
