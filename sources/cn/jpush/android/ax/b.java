package cn.jpush.android.ax;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.d.d;
import cn.jpush.android.l.c;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static PendingIntent a(Context context, int i2, String str, String str2, d dVar) {
        Intent intent;
        try {
            String o = cn.jpush.android.bm.a.o(context);
            if (TextUtils.isEmpty(o)) {
                cn.jpush.android.r.b.f("NotificationFeedBackHelper", "not found commonServiceClass");
                intent = null;
            } else {
                cn.jpush.android.r.b.d("NotificationFeedBackHelper", "found commonServiceClass（JCommonService), " + o + ", action: " + str);
                intent = new Intent();
                intent.setClass(context, Class.forName(o));
                intent.setAction("a3");
                Bundle bundle = new Bundle();
                bundle.putString(ActionManager.SDK_TYPE, JPushConstants.SDK_TYPE);
                bundle.putString("internal_action", "ssp_neg_fb");
                bundle.putString("ssp_fb_action_type", str);
                bundle.putInt("notification_id", i2);
                bundle.putString("message_data", dVar.f9705i);
                bundle.putString("feedback_name", str2);
                intent.putExtras(bundle);
                intent.setData(Uri.parse(str));
            }
            if (intent != null) {
                return PendingIntent.getService(context, i2, intent, 201326592);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("NotificationFeedBackHelper", "[NotificationFeedBackHelper] getServiceIntent error:" + th);
        }
        return null;
    }

    public static void a(Context context, int i2, String str) {
        if (context != null) {
            try {
                d a2 = d.a(str, context.getPackageName(), cn.jpush.android.l.a.c(context), 0L);
                a2.a(context);
                a.d(context, a2);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("NotificationFeedBackHelper", "[handleNotLikeCancelAction] failed, " + th.getMessage());
            }
        }
    }

    public static void a(Context context, int i2, String str, int i3, String str2) {
        if (context != null) {
            try {
                d a2 = d.a(str, context.getPackageName(), cn.jpush.android.l.a.c(context), 0L);
                a2.a(context);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("fbName", str2);
                    }
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("NotificationFeedBackHelper", "json add fbname error" + th);
                }
                c.a(context, a2.f9700d, i3, "", 3, "", jSONObject);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(i2);
                }
            } catch (Throwable th2) {
                cn.jpush.android.r.b.f("NotificationFeedBackHelper", "[handleNotLikeReportAction] failed, " + th2.getMessage());
            }
        }
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        try {
            String string = bundle.getString("ssp_fb_action_type");
            int i2 = bundle.getInt("notification_id", 0);
            String string2 = bundle.getString("feedback_name");
            String string3 = bundle.getString("message_data");
            cn.jpush.android.r.b.b("NotificationFeedBackHelper", "handleNotifyFbAction action: " + string + ", notification_id: " + i2 + ", fbName: " + string2 + ", subStr: " + string3);
            if ("cn.jpush.android.action.fb_no_like".equals(string)) {
                b(context, i2, string3);
            } else if ("cn.jpush.android.action.fb_no_like_cancle".equals(string)) {
                a(context, i2, string3);
            } else if ("cn.jpush.android.action.fb_no_like_01".equals(string)) {
                a(context, i2, string3, 1090, string2);
            } else if ("cn.jpush.android.action.fb_no_like_02".equals(string)) {
                a(context, i2, string3, 1091, string2);
            } else if ("cn.jpush.android.action.fb_no_like_03".equals(string)) {
                a(context, i2, string3, 1092, string2);
            } else if ("cn.jpush.android.action.fb_no_like_04".equals(string)) {
                a(context, i2, string3, 1093, string2);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("NotificationFeedBackHelper", "handle notify fb action failed, " + th.getMessage());
        }
    }

    public static void b(Context context, int i2, String str) {
        cn.jpush.android.r.b.b("NotificationFeedBackHelper", "user click not like this notification,originmsg : " + str);
        if (context != null) {
            try {
                d a2 = d.a(str, context.getPackageName(), cn.jpush.android.l.a.c(context), 0L);
                a2.a(context);
                a.c(context, a2);
                c.a(context, a2.f9700d, 1094, 3);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("NotificationFeedBackHelper", "[handleNotLikeAction] failed, " + th.getMessage());
            }
        }
    }
}
