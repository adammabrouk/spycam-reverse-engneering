package cn.jpush.android.support;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.MultiActionsNotificationBuilder;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.a;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class JPushSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f9862a = 0;

    public static PushNotificationBuilder getNotificationBuilder(Context context, NotificationMessage notificationMessage) {
        try {
            int i2 = notificationMessage.notificationBuilderId;
            if (i2 < 1) {
                i2 = f9862a.intValue();
            }
            String d2 = a.d(context, i2 + "");
            if (TextUtils.isEmpty(d2)) {
                Logger.d("JPushSupport", "not found custom notification");
                return null;
            }
            Logger.ii("JPushSupport", "get customBuilder:" + d2);
            if (!d2.startsWith("basic") && !d2.startsWith("custom")) {
                return MultiActionsNotificationBuilder.parseFromPreference(context, d2);
            }
            return BasicPushNotificationBuilder.parseFromPreference(context, d2);
        } catch (Throwable th) {
            Logger.ww("JPushSupport", "getNotification failed:" + th.getMessage());
            return null;
        }
    }
}
