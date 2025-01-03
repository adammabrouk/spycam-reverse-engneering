package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.bg.a;
import cn.jpush.android.bg.b;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.c;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public abstract class JThirdPlatFormInterface {
    public static final String ACTION_NOTIFICATION_ARRIVED = "action_notification_arrived";
    public static final String ACTION_NOTIFICATION_CLCKED = "action_notification_clicked";
    public static final String ACTION_NOTIFICATION_SHOW = "action_notification_show";
    public static final String ACTION_NOTIFICATION_UN_SHOW = "action_notification_unshow";
    public static final String ACTION_PLUGIN_PALTFORM_ON_MESSAGING = "intent.plugin.platform.ON_MESSAGING";
    public static final String ACTION_PLUGIN_PALTFORM_REFRESSH_REGID = "intent.plugin.platform.REFRESSH_REGID";
    public static final String ACTION_PLUGIN_PALTFORM_REQUEST_REGID = "intent.plugin.platform.REQUEST_REGID";
    public static final String ACTION_REGISTER_TOKEN = "action_register_token";
    public static final int CMD_CALL_BACK = 10000;
    public static final String KEY_CODE = "code";
    public static final String KEY_DATA = "data";
    public static final String KEY_MSG = "msg";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_NOTI_ID = "noti_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_TOKEN = "token";

    public static void doAction(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("third_key_action", str);
        ActionHelper.getInstance().doAction(context, "third_action", bundle);
    }

    public static int getNofiticationID(String str, int i2) {
        return b.a(str, i2);
    }

    public static void onEvent(Thread thread, Throwable th) {
        ActionHelper.getInstance().onEvent(thread, th);
    }

    public static NotificationMessage parseMessage(Context context, String str) {
        return d.a(context, str, "").b();
    }

    public static void reportThirdSDKMsgActionResult(String str, String str2, byte b2, int i2, Context context) {
        c.a(str, str2, b2, i2, context);
    }

    public static void sendActionByJCore(Context context, Bundle bundle, String str) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
    }

    public static void setNotification(Context context, Notification notification, String str, CharSequence charSequence, int i2, int i3, String str2) {
        a.a(context, notification, str, charSequence, i2, i3, str2);
    }

    public static void setNotificationChannel(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i2, int i3) {
        a.a(context, builder, str, charSequence, i2, i3, (String) null);
    }

    public static void setNotificationChannel(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i2, int i3, String str2) {
        a.a(context, builder, str, charSequence, i2, i3, str2);
    }

    public static String toMD5(String str) {
        return cn.jpush.android.bm.a.d(str);
    }

    public abstract void clearNotification(Context context, int i2);

    public abstract String getAppId(Context context);

    public abstract String getAppkey(Context context);

    public abstract String getRomName();

    public abstract byte getRomType(Context context);

    public abstract String getToken(Context context);

    public abstract void init(Context context);

    public abstract boolean isNeedClearToken(Context context);

    public abstract boolean isSupport(Context context);

    public boolean needSendToMainProcess() {
        return false;
    }

    public abstract void register(Context context);

    public void resumePush(Context context) {
    }

    public void stopPush(Context context) {
    }
}
