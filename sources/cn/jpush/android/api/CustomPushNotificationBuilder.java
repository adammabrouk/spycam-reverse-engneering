package cn.jpush.android.api;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.widget.RemoteViews;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class CustomPushNotificationBuilder extends BasicPushNotificationBuilder {
    public int layout;
    public int layoutContentId;
    public int layoutIconDrawable;
    public int layoutIconId;
    public int layoutTimeId;
    public int layoutTitleId;

    public CustomPushNotificationBuilder(Context context) {
        super(context);
        this.layoutIconDrawable = 0;
    }

    public CustomPushNotificationBuilder(Context context, int i2, int i3, int i4, int i5) {
        super(context);
        this.layoutIconDrawable = 0;
        this.layout = i2;
        this.layoutIconId = i3;
        this.layoutTitleId = i4;
        this.layoutContentId = i5;
    }

    public CustomPushNotificationBuilder(Context context, int i2, int i3, int i4, int i5, int i6) {
        super(context);
        this.layoutIconDrawable = 0;
        this.layout = i2;
        this.layoutTitleId = i4;
        this.layoutContentId = i5;
        this.layoutTimeId = i6;
        this.layoutIconId = i3;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo == null) {
                Logger.ee("CustomPushNotificationB", "JPush get NULL appInfo.");
            } else {
                this.layoutIconDrawable = applicationInfo.icon;
            }
        } catch (Throwable unused) {
            Logger.ww("CustomPushNotificationB", "[statusBarDrawable] JPush get NULL appInfo.");
        }
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    public String a() {
        return super.a() + "_____" + this.layout + "_____" + this.layoutIconId + "_____" + this.layoutTitleId + "_____" + this.layoutContentId + "_____" + this.layoutIconDrawable + "_____" + this.layoutTimeId;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder
    public void a(String[] strArr) {
        super.a(strArr);
        this.layout = Integer.parseInt(strArr[5]);
        this.layoutIconId = Integer.parseInt(strArr[6]);
        this.layoutTitleId = Integer.parseInt(strArr[7]);
        this.layoutContentId = Integer.parseInt(strArr[8]);
        this.layoutIconDrawable = Integer.parseInt(strArr[9]);
        if (strArr.length == 11) {
            this.layoutTimeId = Integer.parseInt(strArr[10]);
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public RemoteViews buildContentView(String str, String str2) {
        RemoteViews remoteViews = new RemoteViews(this.f9173a.getPackageName(), this.layout);
        remoteViews.setTextViewText(this.layoutTitleId, str2);
        remoteViews.setImageViewResource(this.layoutIconId, this.layoutIconDrawable);
        remoteViews.setTextViewText(this.layoutContentId, str);
        int i2 = this.layoutTimeId;
        if (i2 != 0) {
            remoteViews.setLong(i2, "setTime", System.currentTimeMillis());
        }
        return remoteViews;
    }

    @Override // cn.jpush.android.api.BasicPushNotificationBuilder, cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return "custom_____" + a();
    }
}
