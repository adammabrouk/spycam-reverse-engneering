package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f9744a;

    /* renamed from: cn.jpush.android.helper.a$a, reason: collision with other inner class name */
    public class C0157a extends cn.jpush.android.bm.e {

        /* renamed from: b, reason: collision with root package name */
        public Context f9746b;

        /* renamed from: c, reason: collision with root package name */
        public JPushMessageReceiver f9747c;

        /* renamed from: d, reason: collision with root package name */
        public Intent f9748d;

        public C0157a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.f9746b = context;
            this.f9747c = jPushMessageReceiver;
            this.f9748d = intent;
            this.f9666f = "JMessageReceiverHelper#MessageReceiverRunable";
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                if (this.f9748d != null && this.f9747c != null) {
                    String action = this.f9748d.getAction();
                    Logger.d("JMessageReceiverHelper", "do receiver action :" + action);
                    if (action == null) {
                        Logger.w("JMessageReceiverHelper", "Unexpected error, action is null");
                        return;
                    }
                    if (action.equals(JPushConstants.USER_MESSAGE_RECEIVER_ACTION)) {
                        int intExtra = this.f9748d.getIntExtra("message_type", -1);
                        JPushMessage a2 = (1 == intExtra || 2 == intExtra) ? cn.jpush.android.bk.c.a().a(this.f9746b, this.f9748d) : null;
                        Logger.d("JMessageReceiverHelper", "messageType:" + intExtra + ",jPushMessage:" + a2);
                        if (a2 == null) {
                            Logger.w("JMessageReceiverHelper", "parse tagalias message failed");
                            return;
                        }
                        if (intExtra == 1) {
                            if (a2.isTagCheckOperator()) {
                                this.f9747c.onCheckTagOperatorResult(this.f9746b, a2);
                                return;
                            } else {
                                this.f9747c.onTagOperatorResult(this.f9746b, a2);
                                return;
                            }
                        }
                        if (intExtra == 2) {
                            this.f9747c.onAliasOperatorResult(this.f9746b, a2);
                            return;
                        } else {
                            Logger.w("JMessageReceiverHelper", "unsupport message type");
                            return;
                        }
                    }
                    if (action.equals("mobile_result")) {
                        this.f9747c.onMobileNumberOperatorResult(this.f9746b, d.a().a(this.f9746b, this.f9748d));
                        return;
                    }
                    if (action.equals(cn.jpush.android.bm.a.f(this.f9746b, "custom_msg"))) {
                        this.f9747c.onMessage(this.f9746b, cn.jpush.android.d.b.a(this.f9748d));
                        return;
                    }
                    if (action.equals(cn.jpush.android.bm.a.f(this.f9746b, "cmd_msg"))) {
                        a.a(this.f9747c, this.f9746b, this.f9748d);
                        return;
                    }
                    if (action.equals("cn.jpush.android.intent.NOTIFICATION_ARRIVED")) {
                        this.f9747c.onNotifyMessageArrived(this.f9746b, cn.jpush.android.bg.b.b(this.f9746b, this.f9748d));
                        return;
                    }
                    if (action.equals("cn.jpush.android.intent.NOTIFICATION_UN_SHOW")) {
                        try {
                            this.f9747c.onNotifyMessageUnShow(this.f9746b, cn.jpush.android.bg.b.b(this.f9746b, this.f9748d));
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    if (action.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                        this.f9747c.onNotifyMessageOpened(this.f9746b, cn.jpush.android.bg.b.b(this.f9746b, this.f9748d));
                        return;
                    }
                    if (action.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                        this.f9747c.onNotifyMessageDismiss(this.f9746b, cn.jpush.android.bg.b.b(this.f9746b, this.f9748d));
                        return;
                    }
                    if ("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY".equals(this.f9748d.getAction())) {
                        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                        if (this.f9748d.getExtras() != null) {
                            intent.putExtras(this.f9748d.getExtras());
                        }
                        this.f9747c.onMultiActionClicked(this.f9746b, intent);
                        return;
                    }
                    if ("on_noti_settings_check".equals(action)) {
                        this.f9747c.onNotificationSettingsCheck(this.f9746b, this.f9748d.getBooleanExtra("isOn", false), this.f9748d.getIntExtra("source", 0));
                        return;
                    }
                    if ("cn.jpush.android.intent.GEO_RECEIVED".equals(action)) {
                        String stringExtra = this.f9748d.getStringExtra("geo");
                        if (TextUtils.isEmpty(stringExtra)) {
                            stringExtra = "";
                        }
                        this.f9747c.onGeofenceReceived(this.f9746b, stringExtra);
                        return;
                    }
                    if ("cn.jpush.android.intent.GEO_REGION".equals(action)) {
                        this.f9747c.onGeofenceRegion(this.f9746b, this.f9748d.getStringExtra("geo"), this.f9748d.getDoubleExtra("geoLng", 200.0d), this.f9748d.getDoubleExtra("geoLat", 200.0d));
                        return;
                    } else {
                        Logger.d("JMessageReceiverHelper", "unsupport action type, action: " + action);
                        return;
                    }
                }
                Logger.w("JMessageReceiverHelper", "intent or jPushMessageReceiver was null");
            } catch (Throwable th) {
                Logger.ww("JMessageReceiverHelper", "MessageReceiver run failed:" + th.getMessage());
            }
        }
    }

    public static a a() {
        if (f9744a == null) {
            synchronized (a.class) {
                if (f9744a == null) {
                    f9744a = new a();
                }
            }
        }
        return f9744a;
    }

    public static void a(Context context, Intent intent) {
        try {
            Logger.i("JMessageReceiverHelper", "Click notification action with extra: " + intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA));
            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
            intent2.putExtras(intent.getExtras());
            intent2.addCategory(context.getPackageName());
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "Click notification sendBroadcast :" + th.getMessage());
        }
    }

    public static void a(Context context, CustomMessage customMessage) {
        if (context == null || customMessage == null) {
            Logger.dd("JMessageReceiverHelper", "Send custom message to app failed, param is invalid!");
            return;
        }
        Logger.dd("JMessageReceiverHelper", "not found user push message,use old action to user");
        Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
        intent.putExtra(JPushInterface.EXTRA_APP_KEY, customMessage.senderId);
        intent.putExtra(JPushInterface.EXTRA_MESSAGE, customMessage.message);
        intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
        intent.putExtra(JPushInterface.EXTRA_TITLE, customMessage.title);
        intent.putExtra(JPushInterface.EXTRA_EXTRA, customMessage.extra);
        intent.putExtra(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
        if (JPushConstants.SDK_VERSION_CODE >= 387) {
            intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, customMessage.platform);
        }
        intent.addCategory(customMessage.appId);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
        Logger.i("JMessageReceiverHelper", "Send broadcast to app: " + String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9 A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7 A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d6 A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e5 A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4 A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff A[Catch: all -> 0x019d, TryCatch #0 {all -> 0x019d, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x005d, B:13:0x0065, B:14:0x006c, B:16:0x0071, B:18:0x0079, B:19:0x007d, B:20:0x00a5, B:22:0x00a9, B:23:0x00bf, B:25:0x00c7, B:26:0x00ce, B:28:0x00d6, B:29:0x00dd, B:31:0x00e5, B:32:0x00ec, B:34:0x00f4, B:35:0x00fb, B:37:0x00ff, B:39:0x0103, B:41:0x0108, B:43:0x010c, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012d, B:51:0x013e, B:53:0x0144, B:55:0x0152, B:56:0x0156, B:58:0x0160, B:60:0x0163, B:61:0x0167, B:64:0x0170, B:65:0x0179, B:69:0x0081, B:71:0x0086, B:73:0x008e, B:74:0x0093, B:76:0x0098, B:78:0x00a0), top: B:7:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r8, cn.jpush.android.api.NotificationMessage r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.a.a(android.content.Context, cn.jpush.android.api.NotificationMessage, java.lang.String):void");
    }

    public static void a(JPushMessageReceiver jPushMessageReceiver, Context context, Intent intent) {
        int intExtra;
        int intExtra2;
        String stringExtra;
        Bundle extras;
        CmdMessage cmdMessage;
        try {
            intExtra = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -2);
            intExtra2 = intent.getIntExtra("cmd", -2);
            stringExtra = intent.getStringExtra("message");
            Logger.d("JMessageReceiverHelper", "[callCmdMessage] code:" + intExtra + ",cmd:" + intExtra2 + ",message:" + stringExtra);
            extras = intent.getExtras();
        } catch (Throwable th) {
            Logger.e("JMessageReceiverHelper", "callCmdMessage failed:" + th.getMessage());
            return;
        }
        if (intExtra2 == -1) {
            jPushMessageReceiver.onConnected(context, false);
            return;
        }
        if (intExtra2 == 0) {
            if (intExtra == 0) {
                jPushMessageReceiver.onRegister(context, stringExtra);
                return;
            }
            cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
        } else {
            if (intExtra2 == 1) {
                jPushMessageReceiver.onConnected(context, true);
                return;
            }
            if (intExtra2 == 2001) {
                return;
            }
            if (intExtra2 != 10000) {
                switch (intExtra2) {
                    default:
                        switch (intExtra2) {
                            case 100001:
                            case 100002:
                            case 100003:
                            case 100004:
                            case 100005:
                                break;
                            default:
                                Logger.dd("JMessageReceiverHelper", "unkown cmd:" + intExtra2);
                                break;
                        }
                    case 2003:
                    case 2004:
                    case 2005:
                    case 2006:
                    case 2007:
                        cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
                        break;
                }
                return;
            }
            cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
        }
        jPushMessageReceiver.onCommandResult(context, cmdMessage);
    }

    public void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        JCoreHelper.majorExecutor(context, "JMessageReceiverHelper", new C0157a(context, jPushMessageReceiver, intent));
        cn.jpush.android.bc.a.a(context, intent, jPushMessageReceiver);
    }
}
