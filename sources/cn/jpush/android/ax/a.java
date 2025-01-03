package cn.jpush.android.ax;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.af.e;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.az.a;
import cn.jpush.android.az.c;
import cn.jpush.android.d.d;
import cn.jpush.android.l.c;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import java.util.Calendar;
import java.util.Random;
import java.util.zip.Adler32;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: cn.jpush.android.ax.a$a, reason: collision with other inner class name */
    public static class C0151a extends cn.jpush.android.r.a {

        /* renamed from: b, reason: collision with root package name */
        public Context f9440b;

        /* renamed from: c, reason: collision with root package name */
        public d f9441c;

        public C0151a(Context context, d dVar) {
            this.f9440b = context;
            this.f9441c = dVar;
            this.f9839a = "JUnionNotifyHelper#NotifyAction";
        }

        public static void a(Context context, d dVar) {
            c.a(context, dVar.f9700d, 995, 3);
            a.b(context, dVar);
        }

        @Override // cn.jpush.android.r.a
        public void a() {
            try {
                long b2 = cn.jpush.android.bm.b.b(this.f9441c.as);
                long b3 = cn.jpush.android.bm.b.b(this.f9441c.at);
                if (b2 > 0 && b2 == b3) {
                    cn.jpush.android.r.b.g("JUnionNotifyHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b3 > 0) {
                    if (b3 < b2) {
                        cn.jpush.android.r.b.h("JUnionNotifyHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b3 < currentTimeMillis) {
                        cn.jpush.android.r.b.f("JUnionNotifyHelper", this.f9441c.f9700d + " already end");
                        c.a(this.f9440b, this.f9441c.f9700d, 1034, 3);
                        return;
                    }
                }
                if (b2 >= currentTimeMillis) {
                    cn.jpush.android.az.c.a().a(this.f9440b, new c.a(b2, this.f9441c, false), false);
                    cn.jpush.android.l.c.a(this.f9440b, this.f9441c.f9700d, 1035, 3);
                } else {
                    if (a.h(this.f9440b, this.f9441c)) {
                        return;
                    }
                    a(this.f9440b, this.f9441c);
                    if (b3 > 0) {
                        cn.jpush.android.az.c.a().a(this.f9440b, new c.a(b3, a.a(this.f9441c)), false);
                    }
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JUnionNotifyHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }
    }

    public static int a(d dVar) {
        return a(TextUtils.isEmpty(dVar.f9704h) ? dVar.f9700d : dVar.f9704h, 0);
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "Ths msgId is not a integer");
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            return value < 0 ? Math.abs(value) : value;
        }
    }

    public static Notification a(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, "raw", context.getPackageName()) == 0) {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "not found sound=" + str);
                return null;
            }
            Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("found sound uri=");
            sb.append(parse);
            cn.jpush.android.r.b.b("JUnionNotifyHelper", sb.toString());
            return parse;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "find sound e:" + th);
            return null;
        }
    }

    public static d a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return d.a(stringExtra);
    }

    public static void a(Context context, int i2, int i3, String str) {
    }

    public static void a(Context context, int i2, int i3, String str, Bundle bundle) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context, messageReceiverClass);
            intent.setAction(cn.jpush.android.bm.a.f(context, "cmd_msg"));
            intent.putExtra("cmd", i2);
            intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i3);
            intent.putExtra("message", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (JPushConstants.getPushMessageReceiver(context) != null) {
                cn.jpush.android.helper.a.a(JPushConstants.getPushMessageReceiver(context), context, intent);
            } else {
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, Notification.Builder builder, a.C0152a c0152a) {
        if (c0152a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && c0152a.f9449h) {
                    cn.jpush.android.r.b.b("JUnionNotifyHelper", "setChannelId =" + c0152a.f9442a);
                    c(context, c0152a.f9442a);
                    builder.setChannelId(c0152a.f9442a);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    builder.setPriority(c0152a.f9444c);
                    builder.setDefaults(c0152a.f9446e);
                    builder.setSound(c0152a.f9448g);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, d dVar) {
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.ab == 0) {
            cn.jpush.android.l.a.b(context, JPushConstants.SDK_TYPE, new C0151a(context, dVar));
            return;
        }
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "Unexpected: unknown show  mode - " + dVar.ab);
    }

    public static void a(Context context, String str, d dVar) {
        try {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "send ad to main process use broadcast...");
            Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
            intent.setAction(str);
            if (dVar != null) {
                intent.putExtra("msg_data", dVar.c());
            }
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "sendADToUserReceiver failed:" + th.getMessage());
        }
    }

    public static boolean a(Context context) {
        try {
            if (!cn.jpush.android.cache.a.g(context)) {
                cn.jpush.android.r.b.e("JUnionNotifyHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String h2 = cn.jpush.android.cache.a.h(context);
            if (TextUtils.isEmpty(h2)) {
                cn.jpush.android.r.b.d("JUnionNotifyHelper", "no time limited");
                return true;
            }
            cn.jpush.android.r.b.d("JUnionNotifyHelper", "push time is ：" + h2);
            String[] split = h2.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(7);
            int i3 = calendar.get(11);
            for (char c2 : charArray) {
                if (i2 == Integer.valueOf(String.valueOf(c2)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i3 >= intValue && i3 <= intValue2) {
                        return true;
                    }
                }
            }
            cn.jpush.android.r.b.e("JUnionNotifyHelper", "Current time is out of the push time - " + h2);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(Context context, int i2) {
        String str;
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                StatusBarNotification[] activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "active size:" + activeNotifications.length);
                if (activeNotifications != null) {
                    int length = activeNotifications.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        if (activeNotifications[i3].getId() == i2) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                }
            }
            if (z) {
                str = "show  notification success:" + i2;
            } else {
                str = "show  notification maybe failed:" + i2;
            }
            cn.jpush.android.r.b.c("JUnionNotifyHelper", str);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "[checkNotficationShow] failed:" + th.getMessage());
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean b2;
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "link uri is empty");
            return false;
        }
        try {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "url:" + str);
            if (str.startsWith("http")) {
                b2 = d(context, str);
            } else {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "jump intent:" + str);
                b2 = b(context, str, str2);
            }
            return b2;
        } catch (Throwable th) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, 100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3, int i2) {
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "[handleWxMini] appid=" + str + ",originid=" + str2 + ",path=" + str3 + ", type=" + i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "launchWXUsingPendingIntent");
                PendingIntent.getActivity(context, 1, context.getPackageManager().getLaunchIntentForPackage(ShareSystemFileUtils.PACKAGE_WECHAT), 201326592).send(context, 2, null, new PendingIntent.OnFinished() { // from class: cn.jpush.android.ax.a.1
                    @Override // android.app.PendingIntent.OnFinished
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i3, String str4, Bundle bundle) {
                        cn.jpush.android.r.b.b("JUnionNotifyHelper", "onSendFinished resultCode: " + i3 + ", resultData: " + str4);
                    }
                }, null);
            }
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "" + i2, ""}, null);
                if (query != null) {
                    query.close();
                }
                return true;
            } catch (Throwable th) {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "[handleWxMini] open wx mini failed,e:" + th.getMessage());
                return false;
            }
        } catch (Throwable th2) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "launchWXUsingPendingIntent pendingIntent send failed: " + th2.getMessage());
            return false;
        }
    }

    public static Intent b(Context context, String str, d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!e.a(context) && Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        return intent;
    }

    public static NotificationMessage b(Context context, Intent intent) {
        d a2 = a(context, intent);
        NotificationMessage notificationMessage = new NotificationMessage();
        if (a2 != null) {
            notificationMessage = a2.b();
        }
        if (TextUtils.isEmpty(notificationMessage.appkey)) {
            notificationMessage.appkey = cn.jpush.android.l.a.c(context);
        }
        return notificationMessage;
    }

    public static void b(Context context, int i2) {
        try {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "action:cleanNotification - notificationId:" + i2);
            ((NotificationManager) context.getSystemService("notification")).cancel(i2);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    public static void b(Context context, int i2, int i3, String str) {
        a(context, i2, i3, str, (Bundle) null);
    }

    public static void b(Context context, d dVar) {
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "showNotification start");
        cn.jpush.android.l.a.a(context);
        try {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "won't show ssp at gp");
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1054, 3);
        } catch (Throwable th) {
            b(context, 1000, 0, th.getMessage());
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1080, 3);
            cn.jpush.android.r.b.h("JUnionNotifyHelper", "showNotification failed:" + th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
    
        if (r8 <= 23) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        if (r8 < r6) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
    
        if (r7 >= r5) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        if (r7 <= r2) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ax.a.b(android.content.Context):boolean");
    }

    public static boolean b(Context context, String str) {
        boolean b2;
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "link uri is empty");
            return false;
        }
        try {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "url:" + str);
            if (str.startsWith("http")) {
                b2 = d(context, str);
            } else {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "jump intent:" + str);
                b2 = b(context, str, "");
            }
            return b2;
        } catch (Throwable th) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, 100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            Intent a2 = Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.bm.a.a(str, 4) : cn.jpush.android.bm.a.a(str, 0);
            a2.setFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                a2.setPackage(str2);
            }
            if (context.getPackageManager().resolveActivity(a2, 0) != null) {
                c(context, a2);
                context.startActivity(a2);
                a(context, 100002, 0, str);
                return true;
            }
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "deeplink is wrong, " + str);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Intent c(Context context, String str, d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static void c(Context context) {
        int identifier;
        if (context == null) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "context is null");
            return;
        }
        if (!cn.jpush.android.bm.a.a(context, (Class<?>) JNotifyActivity.class)) {
            cn.jpush.android.r.b.i("JUnionNotifyHelper", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName());
            return;
        }
        if (context.getResources().getIdentifier("push_notification", "layout", context.getPackageName()) <= 0) {
            cn.jpush.android.r.b.h("JUnionNotifyHelper", "not exist file push_notification.xml, please check directory: res/layout/");
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && (identifier = context.getResources().getIdentifier("v21", "id", context.getPackageName())) <= 0) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "device is night mode style, and v21ID = " + identifier + ", please check your layout-v21/push_notification.xml");
        }
        int identifier2 = context.getResources().getIdentifier("push_notification_large", "layout", context.getPackageName());
        if (identifier2 <= 0) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "not exist file push_notification_large.xml, please check directory: res/layout/");
        }
        int identifier3 = context.getResources().getIdentifier("push_notification_middle", "layout", context.getPackageName());
        if (identifier3 <= 0) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "not exist file push_notification_middle.xml, please check directory: res/layout/");
        }
        int identifier4 = context.getResources().getIdentifier("jpush_ic_action_cancle", "drawable", context.getPackageName());
        int identifier5 = context.getResources().getIdentifier("jpush_ic_action_close", "drawable", context.getPackageName());
        int identifier6 = context.getResources().getIdentifier("jpush_ic_action_close2", "drawable", context.getPackageName());
        if (identifier4 <= 0 || identifier5 <= 0 || identifier6 <= 0) {
            String str = "not exist file";
            if (identifier4 <= 0) {
                str = "not exist file jpush_ic_action_cancle.png";
            }
            if (identifier5 <= 0) {
                str = str + " jpush_ic_action_close.png";
            }
            if (identifier6 <= 0) {
                str = str + " jpush_ic_action_close2.png";
            }
            cn.jpush.android.r.b.g("JUnionNotifyHelper", str + ", please check directory: res/drawable/");
        }
        int identifier7 = context.getResources().getIdentifier("push_notification_layout_lefttop", "id", context.getPackageName());
        if (identifier7 <= 0) {
            cn.jpush.android.r.b.g("JUnionNotifyHelper", "not find layout push_notification_layout_lefttop in push_notification.xml, please check the file: res/layout/push_notification.xml");
        }
        int a2 = cn.jpush.android.az.e.a(context);
        if (identifier2 > 0 && identifier3 > 0 && identifier4 > 0 && identifier5 > 0 && identifier6 > 0 && identifier7 > 0) {
            cn.jpush.android.r.b.c("JUnionNotifyHelper", "ssp is integrated succeed, layoutVersion: " + a2);
            return;
        }
        cn.jpush.android.r.b.h("JUnionNotifyHelper", "some ssp functions are limited, layoutVersion: " + a2);
    }

    public static void c(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01a2, code lost:
    
        if (r0 == 4) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x032d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r27, cn.jpush.android.d.d r28) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ax.a.c(android.content.Context, cn.jpush.android.d.d):void");
    }

    public static boolean c(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str)) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null && notificationChannel.getImportance() != 0) {
                cn.jpush.android.r.b.c("JUnionNotifyHelper", str + " channel is opened,will use it");
                return true;
            }
            cn.jpush.android.r.b.g("JUnionNotifyHelper", str + " channel maybe closed,please check it");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void d(Context context, d dVar) {
        int i2;
        int i3;
        Notification notification;
        int i4 = i(context, dVar);
        int identifier = context.getResources().getIdentifier(i4 == 3 ? "push_notification_middle" : i4 == 4 ? "push_notification_large" : "push_notification", "layout", context.getPackageName());
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "layoutId:" + identifier);
        if (identifier <= 0) {
            return;
        }
        int e2 = cn.jpush.android.az.e.e();
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "use notification style :" + e2);
        int identifier2 = context.getResources().getIdentifier("push_notification_style_default", "id", context.getPackageName());
        if (e2 != 0) {
            i2 = context.getResources().getIdentifier("push_notification_style_" + e2, "id", context.getPackageName());
            if (i2 <= 0) {
                cn.jpush.android.r.b.g("JUnionNotifyHelper", "not found push_notification_style_" + e2 + " in layout");
                return;
            }
        } else {
            i2 = 0;
        }
        int identifier3 = context.getResources().getIdentifier("push_notification_fb_content", "id", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("push_notification_main_layout", "id", context.getPackageName());
        int identifier5 = context.getResources().getIdentifier("push_notification_layout_lefttop", "id", context.getPackageName());
        int identifier6 = context.getResources().getIdentifier("push_notification_banner_img", "id", context.getPackageName());
        int identifier7 = context.getResources().getIdentifier("push_notification_header_expand", "id", context.getPackageName());
        int identifier8 = context.getResources().getIdentifier("jpush_ic_action_close", "drawable", context.getPackageName());
        int identifier9 = context.getResources().getIdentifier("jpush_ic_action_close2", "drawable", context.getPackageName());
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
        remoteViews.setViewVisibility(identifier3, 8);
        if (i4 == 2 && cn.jpush.android.az.e.c()) {
            remoteViews.setViewVisibility(identifier6, 0);
        } else if ((i4 == 3 || i4 == 4) && cn.jpush.android.az.e.b()) {
            remoteViews.setViewVisibility(identifier4, 0);
            remoteViews.setViewVisibility(identifier5, 0);
        } else if (e2 == 0) {
            remoteViews.setViewVisibility(identifier2, 0);
        } else {
            remoteViews.setViewVisibility(i2, 0);
        }
        try {
            i3 = new JSONObject(dVar.D).optInt("ssp_style");
        } catch (Throwable unused) {
            i3 = 0;
        }
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "showRealNotification ssp style:" + i3);
        if ((i3 & 8) != 0) {
            remoteViews.setImageViewResource(identifier7, identifier8);
        }
        if ((i3 & 16) != 0) {
            remoteViews.setImageViewResource(identifier7, identifier9);
        }
        remoteViews.setOnClickPendingIntent(identifier7, b.a(context, a(dVar), "cn.jpush.android.action.fb_no_like", "", dVar));
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle(dVar.u).setContentText(dVar.w).setTicker("").setSmallIcon(k(context, dVar)).setDefaults(0).setVibrate(new long[]{0}).setSound(null);
            if (Build.VERSION.SDK_INT >= 17) {
                builder.setShowWhen(true);
            }
            builder.setContent(remoteViews);
            if (context.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 24) {
                builder.setCustomBigContentView(remoteViews);
            }
            a.C0152a c0152a = new a.C0152a(dVar.F, "", dVar.B, 0, "fb_ssp");
            cn.jpush.android.az.a.a(context, c0152a);
            a(context, builder, c0152a);
            if (Build.VERSION.SDK_INT >= 20) {
                if (cn.jpush.android.az.e.d()) {
                    builder.setGroupSummary(true);
                    builder.setGroup("group" + new Random(System.currentTimeMillis()).nextInt());
                } else {
                    builder.setGroupSummary(false);
                    builder.setGroup("group");
                }
            }
            notification = a(builder);
        } else {
            notification = new Notification(cn.jpush.android.az.d.a(context), dVar.w, System.currentTimeMillis());
            notification.contentView = remoteViews;
        }
        Intent c2 = dVar.V ? 2 == dVar.aa ? c(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : e(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (notification != null) {
            notification.contentIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), c2, 1140850688);
            notification.deleteIntent = PendingIntent.getActivity(context, (int) (System.currentTimeMillis() + 1), e(context, "cn.jpush.android.intent.NOTIFICATION_DISMISS", dVar), 1140850688);
            int a2 = a(dVar);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (!cn.jpush.android.az.e.d()) {
                notification.flags = 17;
            }
            if (notificationManager != null) {
                notificationManager.notify(a2, notification);
            }
        }
    }

    public static void d(Context context, String str, d dVar) {
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "handleNotificationIntent action: " + str + ", entity: " + dVar);
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(str) && dVar.m != 1 && dVar.af == 0) {
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1000, 3);
            int f2 = f(context, dVar);
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "is deep link:" + f2);
            if (f2 == 2 && cn.jpush.android.az.e.d()) {
                e(context, dVar);
            }
        }
    }

    public static boolean d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "link uri is empty");
            return false;
        }
        cn.jpush.android.r.b.b("JUnionNotifyHelper", "[openWebUri]:" + str);
        try {
        } catch (Throwable unused) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "start android default browser failed");
            try {
                Intent a2 = cn.jpush.android.bm.a.a(str, 0);
                a2.setFlags(268435456);
                c(context, a2);
                context.startActivity(a2);
                a(context, 100002, 0, str + "---by parse");
            } catch (Throwable th) {
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "[openWebUri] start fail uri error:" + th.getMessage());
                a(context, 100002, 1, str + "---" + th.getMessage());
                return false;
            }
        }
        if (!cn.jpush.android.bm.a.d(context, "com.android.browser")) {
            cn.jpush.android.r.b.c("JUnionNotifyHelper", "not found com.android.browser,user will choose other browser");
            throw new Throwable("not found com.android.browser,user will choose other browser");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        c(context, intent);
        context.startActivity(intent);
        a(context, 100002, 0, str + "---by default browser");
        return true;
    }

    public static Intent e(Context context, String str, d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(8388608);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static void e(Context context, d dVar) {
        if (dVar != null) {
            b(context, a(dVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(android.content.Context r10, cn.jpush.android.d.d r11) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ax.a.f(android.content.Context, cn.jpush.android.d.d):int");
    }

    public static boolean h(Context context, d dVar) {
        try {
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionNotifyHelper", "check same in-app show already error， err:" + th.getMessage());
        }
        if (context == null) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "[checkSameSSPAlreadyExists] context is null return false");
            return false;
        }
        if (!(!TextUtils.isEmpty(dVar.H) && dVar.Q == 1001)) {
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "not ssp notification, need not check in-app content of showing recently.");
            return false;
        }
        String d2 = cn.jpush.android.bm.a.d(dVar.u + dVar.w);
        if (!TextUtils.isEmpty(d2)) {
            JSONObject jSONObject = new JSONObject(dVar.D);
            int optInt = jSONObject.optInt("ssp_in_app_gap", 180);
            if (jSONObject.optInt("ssp_filter_msg", 1) != 0) {
                if (optInt > 0) {
                    optInt *= 1000;
                    cn.jpush.android.r.b.b("JUnionNotifyHelper", "ssp_in_app_gap: " + optInt);
                }
                int a2 = cn.jpush.android.az.e.a(context, d2, optInt);
                if (a2 == 1) {
                    cn.jpush.android.r.b.f("JUnionNotifyHelper", "in-app message display recently, spp notification delay to show, delay time: " + (optInt / 1000) + "s");
                    long currentTimeMillis = System.currentTimeMillis() + ((long) optInt);
                    cn.jpush.android.az.c.a().a(context, new c.a(currentTimeMillis, dVar, true), false);
                    long b2 = cn.jpush.android.bm.b.b(dVar.at);
                    if (b2 > 0 && b2 > currentTimeMillis) {
                        cn.jpush.android.r.b.b("JUnionNotifyHelper", "delay to show ssp, and it will auto cancel by end time, showTime: " + currentTimeMillis + ", endTime: " + b2);
                        cn.jpush.android.az.c.a().a(context, new c.a(b2, a(dVar)), false);
                    }
                    cn.jpush.android.l.c.a(context, dVar.f9700d, 1098, 3);
                    return true;
                }
                if (a2 == 2) {
                    cn.jpush.android.r.b.b("JUnionNotifyHelper", "same content in-app message display recently, ssp notification not display");
                    cn.jpush.android.l.c.a(context, dVar.f9700d, 1097, 3);
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(Context context, d dVar) {
        String str;
        if (dVar == null || context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("push_notification", "layout", context.getPackageName());
        int identifier2 = context.getResources().getIdentifier("push_notification_large", "layout", context.getPackageName());
        int identifier3 = context.getResources().getIdentifier("push_notification_middle", "layout", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("push_notification_banner_img", "id", context.getPackageName());
        int e2 = cn.jpush.android.az.e.e();
        if (e2 == 0) {
            str = "";
        } else {
            str = "style_" + e2 + "_";
        }
        int identifier5 = context.getResources().getIdentifier("push_notification_" + str + "banner_icon", "id", context.getPackageName());
        try {
            int optInt = new JSONObject(dVar.D).optInt("ssp_style");
            if ((optInt & 64) != 0) {
                if (!cn.jpush.android.az.e.b() || identifier3 <= 0 || identifier5 <= 0) {
                    return 1;
                }
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "choseLayoutType : use middle layout");
                return 3;
            }
            if ((optInt & RecyclerView.c0.FLAG_IGNORE) != 0) {
                if (!cn.jpush.android.az.e.b() || identifier2 <= 0 || identifier5 <= 0) {
                    return 1;
                }
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "choseLayoutType : use large layout");
                return 4;
            }
            if ((optInt & 32) == 0 || identifier <= 0 || identifier4 <= 0) {
                return 1;
            }
            cn.jpush.android.r.b.b("JUnionNotifyHelper", "choseLayoutType : use banner layout");
            return 2;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static boolean j(Context context, d dVar) {
        boolean z = true;
        if (dVar != null) {
            try {
                if (new JSONObject(dVar.D).optInt("ssp_use_app_icon", 0) != 0) {
                    z = false;
                }
                cn.jpush.android.r.b.b("JUnionNotifyHelper", "ssp use transparent icon: " + z + ", extras: " + dVar.D);
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static int k(Context context, d dVar) {
        return j(context, dVar) ? R.color.transparent : cn.jpush.android.az.d.a(context);
    }
}
