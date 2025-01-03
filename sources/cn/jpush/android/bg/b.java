package cn.jpush.android.bg;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.bg.a;
import cn.jpush.android.bg.e;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f9572a;

    public static class a extends cn.jpush.android.bm.e {

        /* renamed from: a, reason: collision with root package name */
        public Context f9573a;

        /* renamed from: b, reason: collision with root package name */
        public cn.jpush.android.d.d f9574b;

        public a(Context context, cn.jpush.android.d.d dVar) {
            this.f9573a = context;
            this.f9574b = dVar;
            this.f9666f = "NotificationHelper#NotifyAction";
        }

        public static void a(Context context, cn.jpush.android.d.d dVar) {
            b.h(context, dVar);
            int i2 = dVar.aa;
            if (i2 != 0 && i2 != 4) {
                b.g(context, dVar);
            } else {
                cn.jpush.android.helper.c.a(dVar.f9700d, 995, context);
                b.b(context, dVar);
            }
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                long b2 = cn.jpush.android.bm.b.b(this.f9574b.as);
                long b3 = cn.jpush.android.bm.b.b(this.f9574b.at);
                if (b2 > 0 && b2 == b3) {
                    Logger.ww("NotificationHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b3 > 0) {
                    if (b3 < b2) {
                        Logger.e("NotificationHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b3 < currentTimeMillis) {
                        Logger.w("NotificationHelper", this.f9574b.f9700d + " already end");
                        cn.jpush.android.helper.c.a(this.f9574b.f9700d, 1034, this.f9573a);
                        return;
                    }
                }
                if (b2 >= currentTimeMillis) {
                    e.a().a(this.f9573a, new e.a(b2, this.f9574b, false));
                    cn.jpush.android.helper.c.a(this.f9574b.f9700d, 1035, this.f9573a);
                } else {
                    a(this.f9573a, this.f9574b);
                    if (b3 > 0) {
                        e.a().a(this.f9573a, new e.a(b3, b.a(this.f9574b)));
                    }
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }
    }

    public static int a(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 != 1) {
            return i2 != 2 ? 1 : 32;
        }
        return 16;
    }

    public static int a(cn.jpush.android.d.d dVar) {
        return a(TextUtils.isEmpty(dVar.f9704h) ? dVar.f9700d : dVar.f9704h, 0);
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Logger.w("NotificationHelper", "Ths msgId is not a integer");
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
            Logger.ww("NotificationHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Notification a(android.content.Context r7, cn.jpush.android.d.d r8, cn.jpush.android.bg.c r9, cn.jpush.android.bg.c r10) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.a(android.content.Context, cn.jpush.android.d.d, cn.jpush.android.bg.c, cn.jpush.android.bg.c):android.app.Notification");
    }

    public static Intent a(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!cn.jpush.android.bm.a.k(context) && Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        return intent;
    }

    @TargetApi(23)
    public static Icon a(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
            Logger.w("NotificationHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "createIcon err:" + th);
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, "raw", context.getPackageName()) == 0) {
                Logger.d("NotificationHelper", "not found sound=" + str);
                return null;
            }
            Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("found sound uri=");
            sb.append(parse);
            Logger.d("NotificationHelper", sb.toString());
            return parse;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "find sound e:" + th);
            return null;
        }
    }

    public static PushNotificationBuilder a(Context context, NotificationMessage notificationMessage) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.support.JPushSupport");
            return (PushNotificationBuilder) cls.getDeclaredMethod("getNotificationBuilder", Context.class, NotificationMessage.class).invoke(cls, context, notificationMessage);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(11)
    public static c a(Context context, String str, int i2) {
        c cVar = new c();
        Object b2 = b(context, str, i2);
        if (b2 == null) {
            cVar.c(973);
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 23 && (b2 instanceof Icon)) {
            cVar.a(102);
            cVar.a(b2);
        } else {
            if (!(b2 instanceof Bitmap)) {
                cVar.c(973);
                return cVar;
            }
            cVar.a(100);
            cVar.a((Bitmap) b2);
        }
        return cVar;
    }

    @TargetApi(11)
    public static c a(Context context, String str, String str2, String str3, String str4, String str5) {
        Icon a2;
        c cVar = new c();
        String str6 = "";
        int i2 = 0;
        try {
            if (TextUtils.isEmpty(str3)) {
                Logger.d("NotificationHelper", "[buildSmallIcon] smallIcon is empty");
            } else if (cn.jpush.android.bm.a.c(str3)) {
                str6 = d(JPushConstants.mApplicationContext, str3, 307200);
            } else {
                i2 = JPushConstants.mApplicationContext.getResources().getIdentifier(str3, "drawable", JPushConstants.mApplicationContext.getPackageName());
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load small icon failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                Bitmap decodeFile = cn.jpush.android.bm.c.a(str6) ? BitmapFactory.decodeFile(str6) : null;
                if (decodeFile != null) {
                    Logger.d("NotificationHelper", "set small icon with path bitmap:" + decodeFile);
                    cVar.a(100);
                    cVar.a(decodeFile);
                    return cVar;
                }
                Logger.d("NotificationHelper", "not set small icon by bitmap");
                if (Build.VERSION.SDK_INT >= 23 && (a2 = a(str6)) != null) {
                    Logger.d("NotificationHelper", "set small icon success by path:" + str6);
                    cVar.a(102);
                    cVar.a(a2);
                    return cVar;
                }
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with sdcard path");
            }
        }
        if (i2 != 0) {
            cVar.a(101);
            cVar.b(i2);
            Logger.d("NotificationHelper", "set small icon success by resId:" + i2 + ",resName:" + str3);
            return cVar;
        }
        if (TextUtils.isEmpty(str2) || str2.equals(context.getPackageName())) {
            int a3 = g.a(context);
            if (a3 == 0) {
                cVar.c(972);
                return cVar;
            }
            cVar.a(101);
            cVar.b(a3);
            Logger.d("NotificationHelper", "set small icon success by mine icon resId:" + a3);
            return cVar;
        }
        try {
            if (!cn.jpush.android.bm.a.a(context, str2, str5)) {
                Logger.w("NotificationHelper", "targetApp ：" + str2 + " is not install,will give up notify the msg");
                cVar.c(993);
                return cVar;
            }
            Bitmap c2 = c(context, str2);
            if (c2 == null) {
                Logger.w("NotificationHelper", "not found targetApp small icon bitmap,will give up notify the msg");
                cVar.c(972);
                return cVar;
            }
            cVar.a(100);
            cVar.a(c2);
            Logger.d("NotificationHelper", "set small icon success by targetAppBitmap");
            return cVar;
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "set small icon by targetApp icon bitmap failed:" + th2.getMessage());
            cVar.c(972);
            return cVar;
        }
    }

    public static cn.jpush.android.d.d a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return cn.jpush.android.d.d.a(stringExtra);
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, a.C0154a c0154a) {
        if (c0154a != null) {
            try {
                if (Build.VERSION.SDK_INT < 16) {
                    notification.defaults = c0154a.f9568e;
                    notification.sound = c0154a.f9570g;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        while (true) {
            Integer valueOf = Integer.valueOf(f.a());
            if (valueOf.intValue() == 0) {
                return;
            } else {
                d(context, valueOf.intValue());
            }
        }
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
            Logger.w("NotificationHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, int i2, boolean z) {
        try {
            boolean z2 = true;
            if (d(context) != 1) {
                z2 = false;
            }
            Logger.d("NotificationHelper", "[checkNotificationSettings] new state:" + z2 + ",last state:" + f9572a + ",soucre:" + i2 + ",isFocre:" + z);
            if (f9572a != null && z2 == f9572a.booleanValue() && !z) {
                Logger.d("NotificationHelper", "[checkNotificationSettings] no change");
                return;
            }
            f9572a = Boolean.valueOf(z2);
            JPushMessageReceiver pushMessageReceiver = JPushConstants.getPushMessageReceiver(context);
            if (pushMessageReceiver != null) {
                pushMessageReceiver.onNotificationSettingsCheck(context, f9572a.booleanValue(), i2);
            } else {
                try {
                    Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                    intent.setAction("on_noti_settings_check");
                    intent.putExtra("isOn", f9572a);
                    intent.putExtra("source", i2);
                    context.sendBroadcast(intent);
                } catch (Throwable th) {
                    Logger.w("NotificationHelper", "checkNotificationSettings send to user e:" + th);
                }
            }
            cn.jpush.android.bj.a.a().a(context, "on_check");
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "checkNotificationSettings e:" + th2);
        }
    }

    public static void a(Context context, Notification.Builder builder, a.C0154a c0154a) {
        if (c0154a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && c0154a.f9571h) {
                    Logger.d("NotificationHelper", "setChannelId =" + c0154a.f9564a);
                    e(context, c0154a.f9564a);
                    builder.setChannelId(c0154a.f9564a);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    builder.setPriority(c0154a.f9566c);
                    builder.setDefaults(c0154a.f9568e);
                    builder.setSound(c0154a.f9570g);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.d("NotificationHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.ab == 0) {
            JCoreHelper.majorExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar));
            return;
        }
        Logger.d("NotificationHelper", "Unexpected: unknown show  mode - " + dVar.ab);
    }

    public static void a(Context context, Integer num, Notification notification) {
        if (num == null) {
            return;
        }
        Key<Integer> BadgeCurNum = Key.BadgeCurNum();
        int intValue = ((Integer) Sp.get(context, BadgeCurNum)).intValue();
        if (intValue < 0) {
            intValue = 0;
        }
        if (num.intValue() != 0) {
            if (num.intValue() + intValue < 0) {
                num = Integer.valueOf(-intValue);
            }
            intValue += num.intValue();
            Sp.set(context, BadgeCurNum.set(Integer.valueOf(intValue)));
        }
        Logger.d("NotificationHelper", "curNum：" + intValue + ",addNum:" + num);
        a(context, notification, num.intValue(), intValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0004, B:5:0x0013, B:7:0x0019, B:9:0x0023, B:10:0x0026, B:12:0x002b, B:13:0x004c, B:16:0x0056, B:18:0x005e, B:19:0x00c3, B:21:0x00c9, B:24:0x00cd, B:26:0x00d3, B:29:0x006b, B:31:0x0072, B:32:0x0076, B:34:0x007e, B:35:0x0084, B:37:0x008c, B:38:0x0094, B:40:0x009a, B:41:0x00a2, B:43:0x00a8, B:44:0x00b0, B:46:0x00b8, B:47:0x00c0), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cd A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0004, B:5:0x0013, B:7:0x0019, B:9:0x0023, B:10:0x0026, B:12:0x002b, B:13:0x004c, B:16:0x0056, B:18:0x005e, B:19:0x00c3, B:21:0x00c9, B:24:0x00cd, B:26:0x00d3, B:29:0x006b, B:31:0x0072, B:32:0x0076, B:34:0x007e, B:35:0x0084, B:37:0x008c, B:38:0x0094, B:40:0x009a, B:41:0x00a2, B:43:0x00a8, B:44:0x00b0, B:46:0x00b8, B:47:0x00c0), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, java.lang.String r6, cn.jpush.android.d.d r7, android.content.Intent r8) {
        /*
            java.lang.String r0 = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA"
            java.lang.String r1 = "NotificationHelper"
            java.lang.String r2 = cn.jpush.android.local.JPushConstants.getMessageReceiverClass(r5)     // Catch: java.lang.Throwable -> Ld7
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> Ld7
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Ld7
            r3.<init>(r5, r2)     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto L26
            android.os.Bundle r8 = r8.getExtras()     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto L26
            java.lang.String r8 = r8.getString(r0)     // Catch: java.lang.Throwable -> Ld7
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 != 0) goto L26
            r3.putExtra(r0, r8)     // Catch: java.lang.Throwable -> Ld7
        L26:
            r3.setAction(r6)     // Catch: java.lang.Throwable -> Ld7
            if (r7 == 0) goto L4c
            java.lang.String r8 = "msg_data"
            java.lang.String r0 = r7.c()     // Catch: java.lang.Throwable -> Ld7
            r3.putExtra(r8, r0)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r8.<init>()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = "send broadcast pushEntry: "
            r8.append(r0)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = r7.c()     // Catch: java.lang.Throwable -> Ld7
            r8.append(r0)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Ld7
            cn.jpush.android.helper.Logger.d(r1, r8)     // Catch: java.lang.Throwable -> Ld7
        L4c:
            cn.jpush.android.service.JPushMessageReceiver r8 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = "cn.jpush.android.intent.NOTIFICATION_OPENED"
            java.lang.String r2 = "cn.jpush.android.intent.NOTIFICATION_DISMISS"
            if (r8 == 0) goto Lc0
            java.lang.String r8 = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto L6b
            java.lang.String r8 = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION"
            r3.setAction(r8)     // Catch: java.lang.Throwable -> Ld7
            cn.jpush.android.service.JPushMessageReceiver r8 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            r8.onMultiActionClicked(r5, r3)     // Catch: java.lang.Throwable -> Ld7
            goto Lc3
        L6b:
            cn.jpush.android.api.NotificationMessage r8 = new cn.jpush.android.api.NotificationMessage     // Catch: java.lang.Throwable -> Ld7
            r8.<init>()     // Catch: java.lang.Throwable -> Ld7
            if (r7 == 0) goto L76
            cn.jpush.android.api.NotificationMessage r8 = r7.b()     // Catch: java.lang.Throwable -> Ld7
        L76:
            java.lang.String r4 = r8.appkey     // Catch: java.lang.Throwable -> Ld7
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto L84
            java.lang.String r4 = cn.jpush.android.helper.JCoreHelper.getAppKey(r5)     // Catch: java.lang.Throwable -> Ld7
            r8.appkey = r4     // Catch: java.lang.Throwable -> Ld7
        L84:
            java.lang.String r4 = "cn.jpush.android.intent.NOTIFICATION_ARRIVED"
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto L94
            cn.jpush.android.service.JPushMessageReceiver r3 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            r3.onNotifyMessageArrived(r5, r8)     // Catch: java.lang.Throwable -> Ld7
            goto Lc3
        L94:
            boolean r4 = r6.equals(r2)     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto La2
            cn.jpush.android.service.JPushMessageReceiver r3 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            r3.onNotifyMessageDismiss(r5, r8)     // Catch: java.lang.Throwable -> Ld7
            goto Lc3
        La2:
            boolean r4 = r6.equals(r0)     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto Lb0
            cn.jpush.android.service.JPushMessageReceiver r3 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            r3.onNotifyMessageOpened(r5, r8)     // Catch: java.lang.Throwable -> Ld7
            goto Lc3
        Lb0:
            java.lang.String r4 = "cn.jpush.android.intent.NOTIFICATION_UN_SHOW"
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto Lc0
            cn.jpush.android.service.JPushMessageReceiver r3 = cn.jpush.android.local.JPushConstants.getPushMessageReceiver(r5)     // Catch: java.lang.Throwable -> Ld7
            r3.onNotifyMessageUnShow(r5, r8)     // Catch: java.lang.Throwable -> Ld7
            goto Lc3
        Lc0:
            r5.sendBroadcast(r3)     // Catch: java.lang.Throwable -> Ld7
        Lc3:
            boolean r8 = r6.equals(r2)     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto Lcd
            cn.jpush.android.ba.a.b(r5, r7)     // Catch: java.lang.Throwable -> Ld7
            goto Lf0
        Lcd:
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> Ld7
            if (r6 == 0) goto Lf0
            cn.jpush.android.ba.a.a(r5, r7)     // Catch: java.lang.Throwable -> Ld7
            goto Lf0
        Ld7:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "sendToUserReceiver failed:"
            r6.append(r7)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            cn.jpush.android.helper.Logger.w(r1, r5)
        Lf0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.a(android.content.Context, java.lang.String, cn.jpush.android.d.d, android.content.Intent):void");
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Logger.i("NotificationHelper", "get EMUI version is:" + str);
                return cn.jpush.android.bm.a.a(str.toLowerCase().replace("emotionui_", ""), "8.0") >= 0;
            }
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " getEmuiVersion wrong error:" + th);
        }
        return false;
    }

    public static boolean a(Notification notification, int i2) {
        if (notification != null) {
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i2));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, int i2) {
        String str;
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                StatusBarNotification[] activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                Logger.d("NotificationHelper", "active size:" + activeNotifications.length);
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
            Logger.dd("NotificationHelper", str);
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "[checkNotficationShow] failed:" + th.getMessage());
        }
        return z;
    }

    @TargetApi(11)
    public static boolean a(Context context, Notification.Builder builder, c cVar, c cVar2) {
        boolean z;
        boolean z2;
        int a2 = cVar.a();
        if (a2 != 102 || Build.VERSION.SDK_INT < 23) {
            z = false;
        } else {
            builder.setSmallIcon((Icon) cVar.b());
            z = true;
        }
        if (!z && a2 == 100 && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(Icon.createWithBitmap(cVar.c()));
            z = true;
        }
        if (!z && a2 == 101) {
            try {
                context.getResources().getDrawable(cVar.d());
                z2 = true;
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with local app");
                z2 = false;
            }
            if (z2) {
                Logger.d("NotificationHelper", "set small icon by local resId:" + cVar.d());
                builder.setSmallIcon(Integer.valueOf(cVar.d()).intValue());
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        int a3 = cVar2.a();
        if (a3 == 102) {
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setLargeIcon((Icon) cVar2.b());
            }
        } else if (a3 == 100) {
            builder.setLargeIcon(cVar2.c());
        } else {
            Logger.d("NotificationHelper", "not set large icon");
        }
        return true;
    }

    public static boolean a(Context context, Notification notification, int i2, int i3) {
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return a(notification, i2);
        }
        if (a()) {
            if (i3 == 0 || i2 != 0) {
                return g(context, i3);
            }
            return false;
        }
        if (cn.jpush.android.bm.a.b()) {
            if (i3 == 0 || i2 != 0) {
                return f(context, i3);
            }
            return false;
        }
        if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR")) {
            Logger.d("NotificationHelper", "not support");
            return false;
        }
        if (i3 == 0 || i2 != 0) {
            return e(context, i3);
        }
        return false;
    }

    public static boolean a(Context context, String str, cn.jpush.android.d.d dVar, NotificationMessage notificationMessage) {
        try {
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "check display foreground failed:" + th.getMessage());
        }
        if (Class.forName(str).getMethod("onNotifyMessageUnShow", Context.class, NotificationMessage.class) == null) {
            Logger.dd("NotificationHelper", "not found onNotifyMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(dVar.G)) {
            if (dVar.G.equals("0")) {
                if (cn.jpush.android.bm.a.k(context)) {
                    Logger.dd("NotificationHelper", "displayForeground...");
                    a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                    cn.jpush.android.helper.c.a(dVar.f9700d, 1060, context);
                    return true;
                }
            } else if (!((JPushMessageReceiver) Class.forName(str).newInstance()).isNeedShowNotification(context, notificationMessage, cn.jpush.android.bm.a.d(context))) {
                Logger.dd("NotificationHelper", "need not show notication by user");
                a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                cn.jpush.android.helper.c.a(dVar.f9700d, 1061, context);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean c2;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            Logger.d("NotificationHelper", "url:" + str);
            if (str.startsWith("http")) {
                c2 = f(context, str);
            } else {
                Logger.d("NotificationHelper", "jump intent:" + str);
                c2 = c(context, str, str2);
            }
            return c2;
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, 100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3, int i2) {
        Logger.d("NotificationHelper", "[handleWxMini] appid=" + str + ",originid=" + str2 + ",path=" + str3 + ", type=" + i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Logger.d("NotificationHelper", "launchWXUsingPendingIntent");
                PendingIntent.getActivity(context, 1, context.getPackageManager().getLaunchIntentForPackage(ShareSystemFileUtils.PACKAGE_WECHAT), 201326592).send(context, 2, null, new PendingIntent.OnFinished() { // from class: cn.jpush.android.bg.b.1
                    @Override // android.app.PendingIntent.OnFinished
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i3, String str4, Bundle bundle) {
                        Logger.d("NotificationHelper", "onSendFinished resultCode: " + i3 + ", resultData: " + str4);
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
                Logger.d("NotificationHelper", "[handleWxMini] open wx mini failed,e:" + th.getMessage());
                return false;
            }
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "launchWXUsingPendingIntent pendingIntent send failed: " + th2.getMessage());
            return false;
        }
    }

    public static Intent b(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static NotificationMessage b(Context context, Intent intent) {
        cn.jpush.android.d.d a2 = a(context, intent);
        NotificationMessage notificationMessage = new NotificationMessage();
        if (a2 != null) {
            notificationMessage = a2.b();
        }
        if (TextUtils.isEmpty(notificationMessage.appkey)) {
            notificationMessage.appkey = JCoreHelper.getAppKey(context);
        }
        return notificationMessage;
    }

    public static Object b(Context context, String str) {
        return b(context, str, 307200);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:19:0x0055, B:20:0x006e, B:24:0x009e, B:27:0x00a6, B:28:0x00bb, B:33:0x00e4, B:36:0x00bf, B:38:0x00c5, B:40:0x00cb, B:43:0x0072, B:45:0x0078, B:47:0x0083), top: B:17:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(android.content.Context r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.b(android.content.Context, java.lang.String, int):java.lang.Object");
    }

    public static String b(Context context, String str, String str2) {
        if (!cn.jpush.android.bm.a.b(str)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String str3 = cn.jpush.android.bm.c.c(context, str2) + (str2 + cn.jpush.android.bm.a.a(str));
        Logger.i("NotificationHelper", "Big picture notification resource path: " + str3);
        byte[] a2 = cn.jpush.android.bf.a.a(str, 5, 5000L, 4);
        return (a2 == null || !cn.jpush.android.bm.c.a(str3, a2)) ? "" : str3;
    }

    public static void b(Context context, int i2) {
        int a2;
        if (!f.b(i2)) {
            f.a(i2);
        }
        int j = cn.jpush.android.cache.a.j(context);
        Logger.d("NotificationHelper", "queueSize:" + f.b() + ", max num:" + j);
        if (f.b() <= j || (a2 = f.a()) == 0) {
            return;
        }
        d(context, a2);
    }

    public static void b(Context context, int i2, int i3, String str) {
        a(context, i2, i3, str, (Bundle) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[Catch: all -> 0x01b8, TryCatch #3 {all -> 0x01b8, blocks: (B:3:0x0010, B:6:0x001b, B:9:0x0024, B:12:0x0033, B:14:0x003d, B:15:0x0042, B:17:0x0059, B:19:0x0068, B:21:0x0075, B:23:0x0086, B:29:0x00bc, B:31:0x00c2, B:86:0x00a1, B:87:0x0040, B:25:0x008b, B:27:0x0091), top: B:2:0x0010, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b1 A[Catch: all -> 0x01b5, TRY_LEAVE, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017d A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016e A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f4 A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:38:0x00d7, B:42:0x00e6, B:44:0x00ea, B:45:0x00f8, B:47:0x011d, B:48:0x011f, B:50:0x012e, B:51:0x0130, B:53:0x013a, B:54:0x0173, B:57:0x0179, B:58:0x01ad, B:60:0x01b1, B:64:0x017d, B:66:0x0181, B:68:0x018a, B:69:0x0191, B:70:0x0199, B:71:0x016e, B:72:0x00ef, B:73:0x00f4), top: B:37:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r17, cn.jpush.android.d.d r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.b(android.content.Context, cn.jpush.android.d.d):void");
    }

    public static boolean b(Context context) {
        try {
            if (!cn.jpush.android.cache.a.g(context)) {
                Logger.ii("NotificationHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String h2 = cn.jpush.android.cache.a.h(context);
            if (TextUtils.isEmpty(h2)) {
                Logger.i("NotificationHelper", "no time limited");
                return true;
            }
            Logger.i("NotificationHelper", "push time is ：" + h2);
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
            Logger.ii("NotificationHelper", "Current time is out of the push time - " + h2);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static Intent c(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(8388608);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static synchronized Bitmap c(Context context, String str) {
        synchronized (b.class) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                Drawable applicationIcon = packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0));
                if (applicationIcon != null) {
                    if (Build.VERSION.SDK_INT < 26 || !(applicationIcon instanceof AdaptiveIconDrawable)) {
                        return ((BitmapDrawable) applicationIcon).getBitmap();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    applicationIcon.draw(canvas);
                    Logger.d("NotificationHelper", "adaptive-icon to bitmap");
                    return createBitmap;
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "getTargetAppBitmap failed:" + th.getMessage());
            }
            return null;
        }
    }

    public static String c(Context context, String str, int i2) {
        if (!cn.jpush.android.bm.a.b(str)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String d2 = cn.jpush.android.bm.a.d(str);
        if (TextUtils.isEmpty(d2)) {
            d2 = UUID.randomUUID().toString();
        }
        String str2 = cn.jpush.android.bm.c.c(context, "noti_res") + (d2 + cn.jpush.android.bm.a.a(str));
        Logger.i("NotificationHelper", "picture notification resource path: " + str2);
        if (!new File(str2).exists()) {
            byte[] a2 = cn.jpush.android.bf.a.a(str, 2, i2);
            return (a2 == null || !cn.jpush.android.bm.c.a(str2, a2)) ? "" : str2;
        }
        Logger.d("NotificationHelper", "need not download again with same url:" + str);
        return str2;
    }

    public static void c(Context context, int i2) {
        if (i2 <= 0) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            Integer valueOf = Integer.valueOf(f.a());
            if (valueOf.intValue() != 0) {
                d(context, valueOf.intValue());
            }
        }
    }

    public static void c(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    public static void c(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            d(context, a(dVar));
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
    public static boolean c(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.c(android.content.Context):boolean");
    }

    public static boolean c(Context context, String str, String str2) {
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
            Logger.d("NotificationHelper", "deeplink is wrong, " + str);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int d(Context context) {
        StringBuilder sb;
        String str;
        if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
            Logger.ww("NotificationHelper", "sdk is banned, call failed");
            return 0;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return -1;
                }
                boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                Logger.d("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                return areNotificationsEnabled ? 1 : 0;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else {
            if (i2 < 19) {
                Logger.d("NotificationHelper", "below 19 return true");
                return 1;
            }
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i3 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                ?? r1 = ((Integer) cls.getMethod(CommonUtil.CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(CommonUtil.OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0 ? 1 : 0;
                Logger.d("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r1));
                return r1;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        Logger.w("NotificationHelper", sb.toString());
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0173 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0174 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r9, cn.jpush.android.d.d r10) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bg.b.d(android.content.Context, cn.jpush.android.d.d):int");
    }

    public static String d(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith(JPushConstants.HTTP_PRE) && !str.startsWith(JPushConstants.HTTPS_PRE)) {
            return null;
        }
        String c2 = c(context, str, i2);
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        Logger.ww("NotificationHelper", "Get network picture failed.");
        return null;
    }

    public static void d(Context context, int i2) {
        try {
            Logger.d("NotificationHelper", "action:cleanNotification - notificationId:" + i2);
            ((NotificationManager) context.getSystemService("notification")).cancel(i2);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    public static boolean d(Context context, String str) {
        boolean c2;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            Logger.d("NotificationHelper", "url:" + str);
            if (str.startsWith("http")) {
                c2 = f(context, str);
            } else {
                Logger.d("NotificationHelper", "jump intent:" + str);
                c2 = c(context, str, "");
            }
            return c2;
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, 100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static boolean e(Context context) {
        String str;
        ApplicationInfo applicationInfo;
        try {
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                Logger.ww("NotificationHelper", "sdk is banned, call failed");
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT < 26) {
                if (Build.VERSION.SDK_INT >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    str = "app_uid";
                    applicationInfo = context.getApplicationInfo();
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            str = "android.provider.extra.CHANNEL_ID";
            applicationInfo = context.getApplicationInfo();
            intent.putExtra(str, applicationInfo.uid);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean e(Context context, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                    Logger.e("NotificationHelper", " setHonorBadge fail, uri is null");
                    return false;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i2);
            contentResolver.call(parse, "change_badge", (String) null, bundle);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setHonorBadge wrong error:" + th);
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str)) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null && notificationChannel.getImportance() != 0) {
                Logger.dd("NotificationHelper", str + " channel is opened,will use it");
                return true;
            }
            Logger.ww("NotificationHelper", str + " channel maybe closed,please check it");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean f(Context context, int i2) {
        try {
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("className", h(context));
            intent.putExtra("notificationNum", i2);
            intent.addFlags(16777216);
            context.sendBroadcast(intent);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setVivoBadge wrong error:" + th);
            return false;
        }
    }

    public static boolean f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        Logger.d("NotificationHelper", "[openWebUri]:" + str);
        try {
        } catch (Throwable unused) {
            Logger.d("NotificationHelper", "start android default browser failed");
            try {
                Intent a2 = cn.jpush.android.bm.a.a(str, 0);
                a2.setFlags(268435456);
                c(context, a2);
                context.startActivity(a2);
                a(context, 100002, 0, str + "---by parse");
            } catch (Throwable th) {
                Logger.d("NotificationHelper", "[openWebUri] start fail uri error:" + th.getMessage());
                a(context, 100002, 1, str + "---" + th.getMessage());
                return false;
            }
        }
        if (!cn.jpush.android.bm.a.d(context, "com.android.browser")) {
            Logger.dd("NotificationHelper", "not found com.android.browser,user will choose other browser");
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

    public static String g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void g(Context context, cn.jpush.android.d.d dVar) {
        String str;
        boolean z;
        String str2 = dVar.f9700d;
        String str3 = dVar.W;
        str = "";
        if (TextUtils.isEmpty(str3)) {
            Logger.w("NotificationHelper", "Show url is Empty! Give up to download!");
            z = false;
        } else {
            String a2 = cn.jpush.android.bf.a.a(str3, 5, 5000L);
            boolean isEmpty = TextUtils.isEmpty(a2);
            str = isEmpty ? "" : a2;
            z = !isEmpty;
        }
        String c2 = cn.jpush.android.bm.c.c(context, str2);
        if (!z) {
            Logger.w("NotificationHelper", "NOTE: failed to download html page. Give up this.");
            cn.jpush.android.helper.c.a(str2, 1014, context);
            cn.jpush.android.helper.c.a(str2, 1021, (String) null, context);
            return;
        }
        String str4 = c2 + str2 + ".html";
        String substring = str3.substring(0, str3.lastIndexOf("/") + 1);
        if (dVar.ac.isEmpty()) {
            dVar.Y = dVar.W;
        } else {
            if (!h.a(dVar.ac, context, substring, str2, true)) {
                Logger.d("NotificationHelper", "Loads rich push resources failed, webView will open url!");
                cn.jpush.android.helper.c.a(str2, 1014, context);
                b(context, dVar);
                return;
            }
            Logger.d("NotificationHelper", "Loads rich push resources succeed, webView will open cache!");
            if (!cn.jpush.android.bm.c.b(str4, str.replaceAll("img src=\"" + substring, "img src=\"" + c2))) {
                cn.jpush.android.helper.c.a(str2, 1014, context);
                return;
            }
            dVar.Y = "file://" + str4;
            cn.jpush.android.helper.c.a(str2, 995, context);
        }
        b(context, dVar);
    }

    public static boolean g(Context context, int i2) {
        try {
            Logger.d("NotificationHelper", "【setEMUIBadge】number：" + i2);
            if (Build.VERSION.SDK_INT < 11) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i2);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            return true;
        } catch (Exception e2) {
            Logger.e("NotificationHelper", "e: " + e2);
            return false;
        }
    }

    public static String h(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
        } catch (Throwable unused) {
        }
        return g(context);
    }

    public static void h(Context context, cn.jpush.android.d.d dVar) {
        String b2;
        String str;
        String str2 = dVar.z;
        dVar.z = "";
        if (dVar.x != 3 || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.startsWith(JPushConstants.HTTP_PRE) || str2.startsWith(JPushConstants.HTTPS_PRE)) {
            b2 = b(context, str2, dVar.f9700d);
            if (TextUtils.isEmpty(b2)) {
                str = "Get network picture failed, show basic notification only.";
                Logger.ww("NotificationHelper", str);
                return;
            }
            dVar.z = b2;
        }
        b2 = cn.jpush.android.bm.c.d(context, str2);
        if (TextUtils.isEmpty(b2)) {
            str = "Get developer picture failed, show basic notification only.";
            Logger.ww("NotificationHelper", str);
            return;
        }
        dVar.z = b2;
    }
}
