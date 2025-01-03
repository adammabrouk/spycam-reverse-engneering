package cn.jpush.android.api;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.bg.a;
import cn.jpush.android.bg.b;
import cn.jpush.android.bg.g;
import cn.jpush.android.helper.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    public static final int NOTI_STYLE_BIG_PICTURE = 3;
    public static final int NOTI_STYLE_BIG_TEXT = 1;
    public static final int NOTI_STYLE_INBOX = 2;
    public static final String TAG = "DefaultPushNotificationBuilder";
    public Context context;
    public NotificationMessage notificationMessage;

    public RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x014e  */
    @Override // cn.jpush.android.api.PushNotificationBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Notification buildNotification(android.content.Context r4, cn.jpush.android.api.NotificationMessage r5) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.DefaultPushNotificationBuilder.buildNotification(android.content.Context, cn.jpush.android.api.NotificationMessage):android.app.Notification");
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public Notification buildNotification(Map<String, String> map) {
        String str;
        int i2;
        Context context = this.context;
        if (context == null) {
            Logger.w(TAG, "Can't find valid context when build notification.");
            return null;
        }
        try {
            str = context.getApplicationInfo().loadLabel(this.context.getPackageManager()).toString();
        } catch (Throwable unused) {
            str = null;
        }
        if (map.containsKey(JPushInterface.EXTRA_MSG_ID)) {
            map.get(JPushInterface.EXTRA_MSG_ID);
        }
        String str2 = map.containsKey(JPushInterface.EXTRA_ALERT) ? map.get(JPushInterface.EXTRA_ALERT) : "";
        if (TextUtils.isEmpty(str2)) {
            Logger.ww(TAG, "No notification content to show. Give up.");
            return null;
        }
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON)) {
            map.get(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON);
        }
        String str3 = map.containsKey(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) ? map.get(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON) : "";
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_TITLE)) {
            str = map.get(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        }
        String str4 = map.containsKey(JPushInterface.EXTRA_BIG_TEXT) ? map.get(JPushInterface.EXTRA_BIG_TEXT) : "";
        String str5 = map.containsKey(JPushInterface.EXTRA_INBOX) ? map.get(JPushInterface.EXTRA_INBOX) : "";
        int parseInt = map.containsKey(JPushInterface.EXTRA_NOTI_PRIORITY) ? Integer.parseInt(map.get(JPushInterface.EXTRA_NOTI_PRIORITY)) : 0;
        String str6 = map.containsKey(JPushInterface.EXTRA_NOTI_CATEGORY) ? map.get(JPushInterface.EXTRA_NOTI_CATEGORY) : "";
        String str7 = map.containsKey(JPushInterface.EXTRA_BIG_PIC_PATH) ? map.get(JPushInterface.EXTRA_BIG_PIC_PATH) : "";
        int parseInt2 = map.containsKey(JPushInterface.EXTRA_ALERT_TYPE) ? Integer.parseInt(map.get(JPushInterface.EXTRA_ALERT_TYPE)) : -1;
        int i3 = (parseInt2 < -1 || parseInt2 > 7) ? -1 : parseInt2;
        RemoteViews buildContentView = buildContentView(str2, str);
        if (Build.VERSION.SDK_INT < 11) {
            Notification notification = new Notification(g.a(this.context), str2, System.currentTimeMillis());
            resetNotificationParams(notification);
            notification.defaults = i3;
            if (buildContentView != null) {
                notification.contentView = buildContentView;
            } else {
                b.a(notification, this.context, str, str2, (PendingIntent) null);
            }
            return notification;
        }
        Notification.Builder builder = new Notification.Builder(this.context);
        builder.setContentTitle(str).setContentText(str2).setTicker(str2);
        int a2 = g.a(this.context);
        if (a2 != 0) {
            Logger.dd(TAG, "setSmallIcon with resId:" + a2);
        } else {
            Logger.ww(TAG, "not found small icon in your app,will setSmallIcon with android.R.color.transparent ");
            a2 = R.color.transparent;
        }
        builder.setSmallIcon(a2);
        Object b2 = b.b(this.context, str3);
        if (Build.VERSION.SDK_INT >= 23) {
            if (b2 instanceof Icon) {
                builder.setLargeIcon((Icon) b2);
            } else if (b2 instanceof Bitmap) {
                builder.setLargeIcon((Bitmap) b2);
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            builder.setShowWhen(true);
        }
        Context context2 = this.context;
        NotificationMessage notificationMessage = this.notificationMessage;
        String str8 = notificationMessage != null ? notificationMessage.notificationChannelId : "";
        int i4 = i3;
        String str9 = str7;
        a.a(context2, builder, str8, "", parseInt, i4, (String) null);
        if (Build.VERSION.SDK_INT >= 16) {
            if (buildContentView == null) {
                if (!TextUtils.isEmpty(str4)) {
                    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                    bigTextStyle.bigText(str4);
                    builder.setStyle(bigTextStyle);
                }
                if (!TextUtils.isEmpty(str5)) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    try {
                        TreeMap treeMap = new TreeMap();
                        JSONObject jSONObject = new JSONObject(str5);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            treeMap.put(next, jSONObject.optString(next));
                        }
                        Iterator it = treeMap.values().iterator();
                        while (it.hasNext()) {
                            inboxStyle.addLine((String) it.next());
                        }
                        inboxStyle.setSummaryText(" + " + jSONObject.length() + " new messages");
                    } catch (Throwable th) {
                        Logger.ee(TAG, "Set inbox style error: " + th.getMessage());
                    }
                    builder.setStyle(inboxStyle);
                }
                if (!TextUtils.isEmpty(str9)) {
                    Logger.i(TAG, "Set notification BPS with picture path:" + str9);
                    try {
                        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeFile(str9));
                        builder.setStyle(bigPictureStyle);
                    } catch (Throwable unused2) {
                        Logger.ww(TAG, "Create big picture style failed.");
                    }
                }
            }
            if (parseInt != 0) {
                if (parseInt == 1) {
                    builder.setPriority(1);
                } else {
                    int i5 = 2;
                    if (parseInt != 2) {
                        if (parseInt != -1) {
                            i5 = -2;
                            i2 = parseInt != -2 ? 0 : -1;
                        }
                        builder.setPriority(i2);
                    }
                    builder.setPriority(i5);
                }
            }
            if (!TextUtils.isEmpty(str6) && Build.VERSION.SDK_INT >= 21) {
                builder.setCategory(str6);
            }
        }
        if (buildContentView != null) {
            builder.setContent(buildContentView);
            if (this.context.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 24) {
                builder.setCustomBigContentView(buildContentView);
            }
        } else {
            Logger.i(TAG, " Use default notification view! ");
        }
        builder.setDefaults(i4);
        return getNotification(builder);
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return null;
    }

    public Notification getNotification(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            Logger.ww(TAG, "Build notification error:", th);
            return null;
        }
    }

    public void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}
