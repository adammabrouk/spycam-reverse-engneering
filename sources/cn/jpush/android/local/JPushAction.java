package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.bc.b;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class JPushAction {
    public abstract Object beforLogin(Context context, String str, int i2, String str2);

    public abstract ProxyActivityAction getPopWinActivity(Context context);

    public abstract ProxyActivityAction getPushActivity(Context context);

    public String getSdkVersion(String str) {
        return b.f9502b;
    }

    public abstract Object handleAction(Context context, String str, Object obj);

    public abstract void handleNotificationIntent(Context context, Intent intent);

    public boolean isSupportedCMD(String str, int i2) {
        return i2 == 3 || i2 == 29 || i2 == 28 || i2 == 27 || i2 == 10 || i2 == 26 || i2 == 25 || i2 == 34 || i2 == 36 || i2 == 37;
    }

    public abstract void onActivityLifeCallback(Activity activity, String str);

    public abstract void onInAppMessageArrived(Context context, NotificationMessage notificationMessage);

    public abstract void onInAppMessageClick(Context context, NotificationMessage notificationMessage);

    public abstract void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent);

    public abstract void onMessage(Context context, CustomMessage customMessage);

    public abstract void onMultiAction(Context context, Intent intent);

    public abstract void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage);

    public abstract void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage);

    public abstract void onTagAliasResponse(Context context, long j, int i2, Intent intent);

    public abstract void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams);
}
