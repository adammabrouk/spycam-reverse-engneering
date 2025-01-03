package cn.jpush.android.az;

import android.content.Context;

/* loaded from: classes.dex */
public class d {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("jpush_notification_icon", "drawable", context.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        try {
            identifier = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
            cn.jpush.android.r.b.d("ResourceHelper", "JPush.mPackageInconId == 0 ?, get icon from application info.");
            return identifier;
        } catch (Throwable th) {
            cn.jpush.android.r.b.c("ResourceHelper", "failed to get application info and icon.", th);
            return identifier;
        }
    }
}
