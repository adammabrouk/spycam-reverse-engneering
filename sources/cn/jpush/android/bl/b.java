package cn.jpush.android.bl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f9636a;

    public static d a(Context context, String str, String str2) {
        return d.a(context, str, str2);
    }

    public static void a(Context context, d dVar) {
        Intent b2 = 2 == dVar.aa ? cn.jpush.android.bg.b.b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : cn.jpush.android.bg.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (b2 != null) {
            b2.addFlags(268435456);
            context.getApplicationContext().startActivity(b2);
        }
    }

    public static void a(Context context, d dVar, String str, int i2) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageArrived");
        cn.jpush.android.bg.b.a(context, "cn.jpush.android.intent.NOTIFICATION_ARRIVED", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f9700d, str, dVar.af, 1018, context);
    }

    public static void a(Context context, String str, String str2, int i2, byte b2, int i3) {
        String str3;
        if (context == null) {
            str3 = "context was null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "content was null";
        } else {
            Logger.v("PluginPlatformsNotificationHelper", "message content:" + str);
            d a2 = a(context, str, str2);
            Logger.v("PluginPlatformsNotificationHelper", "entity:" + a2);
            if (a2 == null) {
                str3 = "entity was null";
            } else {
                if (!TextUtils.isEmpty(a2.f9700d)) {
                    a2.af = b2;
                    a2.f9701e = i2;
                    if (i3 == 0) {
                        c(context, a2, str2, i2);
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(a2.f9700d);
                        cn.jpush.android.bg.d.a(context, linkedList);
                        return;
                    }
                    if (i3 == 1) {
                        a(context, a2, str2, i2);
                        return;
                    } else {
                        if (i3 != 2) {
                            return;
                        }
                        b(context, a2, str2, i2);
                        return;
                    }
                }
                str3 = "message id was empty";
            }
        }
        Logger.ww("PluginPlatformsNotificationHelper", str3);
    }

    public static void b(Context context, d dVar, String str, int i2) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageUnShow in foreground");
        dVar.f9701e = i2;
        cn.jpush.android.bg.b.a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
        cn.jpush.android.helper.c.a(dVar.f9700d, str, dVar.af, 1060, context);
    }

    public static void c(Context context, d dVar, String str, int i2) {
        Logger.v("PluginPlatformsNotificationHelper", "Action - onNotificationMessageClick");
        if (dVar.V) {
            a(context, dVar);
        } else {
            cn.jpush.android.bg.b.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, (Intent) null);
            cn.jpush.android.helper.c.a(dVar.f9700d, str, dVar.af, 1000, context);
        }
    }
}
