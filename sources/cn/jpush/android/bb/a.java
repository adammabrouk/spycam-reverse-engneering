package cn.jpush.android.bb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.bg.b;
import cn.jpush.android.bi.e;
import cn.jpush.android.bm.f;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import cn.jpush.android.local.JPushAction;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.service.JPushMessageReceiver;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends JPushAction {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f9498a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f9499b;

    /* renamed from: c, reason: collision with root package name */
    public Context f9500c;

    /* renamed from: cn.jpush.android.bb.a$a, reason: collision with other inner class name */
    public static class C0153a {
        public static String a(byte b2) {
            switch (b2) {
                case 0:
                case 7:
                default:
                    return "jpush";
                case 1:
                    return "xiaomi";
                case 2:
                    return "huawei";
                case 3:
                    return "meizu";
                case 4:
                    return "oppo";
                case 5:
                    return "vivo";
                case 6:
                    return "asus";
                case 8:
                    return "fcm";
            }
        }

        public static void a(int i2, String str, Intent intent) {
            String str2;
            if (i2 == 1) {
                intent.setData(Uri.parse(str));
                return;
            }
            if (i2 == 2) {
                str2 = "JMessageExtra";
            } else if (i2 != 3) {
                return;
            } else {
                str2 = "asus_data";
            }
            intent.putExtra(str2, str);
        }

        public static void a(Context context, int i2, String str, String str2) {
            try {
                Intent a2 = Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.bm.a.a(str, 4) : cn.jpush.android.bm.a.a(str, 0);
                a2.addFlags(268435456);
                a2.setPackage(context.getPackageName());
                a(i2, str2, a2);
                Logger.d("JPushActionImpl", "intentSend:" + a2);
                context.startActivity(a2);
            } catch (Throwable th) {
                Logger.ww("JPushActionImpl", "url_intent:" + str);
                Logger.ww("JPushActionImpl", "url_intent e:" + th.getMessage());
            }
        }

        public static void a(Context context, JSONObject jSONObject) {
            try {
                String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
                String optString2 = jSONObject.optString("n_title");
                String optString3 = jSONObject.optString("n_content");
                String optString4 = jSONObject.optString("n_extras");
                d dVar = new d();
                dVar.u = optString2;
                dVar.f9700d = optString;
                dVar.w = optString3;
                dVar.D = optString4;
                cn.jpush.android.ba.a.a(context, dVar);
            } catch (Throwable unused) {
            }
        }

        public static void a(Context context, JSONObject jSONObject, byte b2) {
            if (3 != b2) {
                Bundle bundle = new Bundle();
                bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, b2);
                bundle.putString(JThirdPlatFormInterface.KEY_DATA, jSONObject.toString());
                JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED, bundle);
            }
        }

        public static boolean a(Context context, int i2, String str) {
            Logger.d("JPushActionImpl", "msg content is " + String.valueOf(str));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
                byte optInt = (byte) jSONObject.optInt("rom_type");
                Logger.d("JPushActionImpl", "通道：" + a(optInt));
                boolean has = jSONObject.has(JThirdPlatFormInterface.KEY_MSG_ID);
                boolean has2 = jSONObject.has("rom_type");
                boolean has3 = jSONObject.has("n_title");
                boolean has4 = jSONObject.has("n_content");
                Logger.d("JPushActionImpl", "hasMsgid:" + has);
                Logger.d("JPushActionImpl", "hasWhich:" + has2);
                Logger.d("JPushActionImpl", "hasTitle:" + has3);
                Logger.d("JPushActionImpl", "hasContent:" + has4);
                if (has && has2 && has3 && has4) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("n_intent");
                    jSONObject.remove("n_intent");
                    if (optJSONObject == null) {
                        Logger.d("JPushActionImpl", "n_intent is null");
                        a(context, jSONObject, optInt);
                        return false;
                    }
                    c.a(context, optString, optInt, str);
                    a(context, jSONObject);
                    String optString2 = optJSONObject.optString("n_url", "");
                    String optString3 = optJSONObject.optString("n_ssl", "");
                    int optInt2 = optJSONObject.optInt("n_type", 1);
                    Logger.d("JPushActionImpl", "n_url:" + optString2);
                    Logger.d("JPushActionImpl", "n_ssl:" + optString3);
                    Logger.d("JPushActionImpl", "n_type:" + optInt2);
                    String str2 = new String(Base64.decode(optString2, 0));
                    if (!TextUtils.isEmpty(optString2) && !f.a().a(context, optString2, optString3, optInt2)) {
                        Logger.e("JPushActionImpl", "illegal jump,so return url_intent=" + str2);
                        c.a(optString, "", optInt, 1107, context, str);
                        return false;
                    }
                    Logger.d("JPushActionImpl", "url_intent:" + str2);
                    String jSONObject2 = jSONObject.toString();
                    if (optInt2 == 1) {
                        a(context, i2, str2, jSONObject2);
                    } else if (optInt2 == 2) {
                        b.d(context, str2);
                    } else if (optInt2 == 3) {
                        b(context, i2, jSONObject2);
                    }
                    return true;
                }
                Logger.d("JPushActionImpl", "参数缺失");
                return false;
            } catch (Throwable th) {
                Logger.w("JPushActionImpl", "parse notification error : " + th.getMessage());
                return false;
            }
        }

        public static boolean a(Context context, Intent intent) {
            int i2;
            String str;
            Logger.d("JPushActionImpl", "用户点击打开了通知");
            if (intent.getData() != null) {
                str = intent.getData().toString();
                Logger.d("JPushActionImpl", "华为：" + str);
                i2 = 1;
            } else {
                i2 = 0;
                str = null;
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                str = intent.getExtras().getString("JMessageExtra");
                Logger.d("JPushActionImpl", "fcm、oppo、vivo、华硕、小米：" + str);
                i2 = 2;
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                str = intent.getExtras().getString("asus_data");
                Logger.d("JPushActionImpl", "asus_data：" + str);
                i2 = 3;
            }
            return a(context, i2, str);
        }

        public static void b(Context context, int i2, String str) {
            Intent g2 = cn.jpush.android.bm.a.g(context);
            if (g2 != null) {
                try {
                    a(i2, str, g2);
                    context.startActivity(g2);
                } catch (Throwable th) {
                    Logger.ww("JPushActionImpl", "start main intent error:" + th.getMessage());
                }
            }
        }
    }

    public static JSONObject a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("JPushActionImpl", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            Logger.w("JPushActionImpl", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }

    public static void a(Context context, int i2, long j) {
        if (i2 != 10) {
            if (i2 == 37) {
                cn.jpush.android.b.d.a(context).a(j, JPushInterface.ErrorCode.TIMEOUT, null);
                return;
            }
            switch (i2) {
                case 26:
                    cn.jpush.android.helper.d.a().a(context, j, JPushInterface.ErrorCode.TIMEOUT);
                    break;
                case 27:
                    cn.jpush.android.bl.a.a().b(context, j);
                    break;
            }
        }
        cn.jpush.android.bk.a.a(context, cn.jpush.android.bk.b.a().a(j), JPushInterface.ErrorCode.TIMEOUT, j);
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setMaxNotificationNum] bundle is bull");
            return;
        }
        int i2 = bundle.getInt("num");
        Logger.dd("JPushActionImpl", "action:setMaxNotificationNum :" + i2);
        int b2 = cn.jpush.android.bg.f.b();
        Logger.v("JPushActionImpl", "number in queue: " + b2);
        if (i2 < b2) {
            int i3 = b2 - i2;
            Logger.v("JPushActionImpl", "decreaseNotification:" + i3);
            b.c(context, i3);
        }
        cn.jpush.android.cache.a.c(context, i2);
    }

    public static void a(Context context, JPushResponse jPushResponse) {
        Logger.dd("JPushActionImpl", "action:handleMsg:" + jPushResponse);
        if (jPushResponse == null) {
            return;
        }
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            cn.jpush.android.bi.c cVar = new cn.jpush.android.bi.c(jPushResponse);
            if (cn.jpush.android.cache.a.e(context)) {
                Logger.d("JPushActionImpl", "JPush was stoped");
                if (cVar.a() != 20) {
                    return;
                }
            }
            cn.jpush.android.d.b.a(context, cVar);
            return;
        }
        if (cmd != 10) {
            if (cmd == 36) {
                cn.jpush.android.b.d.a(context).a(new cn.jpush.android.bd.b(jPushResponse));
                return;
            }
            if (cmd == 37) {
                cn.jpush.android.b.d.a(context).a(jPushResponse.getRquestId(), 0, new cn.jpush.android.bd.d(jPushResponse));
                return;
            }
            switch (cmd) {
                case 25:
                    JSONObject a2 = a(jPushResponse.getBody());
                    if (a2 != null) {
                        switch (a2.optInt("cmd")) {
                            case 56:
                                cn.jpush.android.b.d.a(context).a(a2);
                                break;
                            case 57:
                                break;
                            case 58:
                            default:
                                Logger.d("JPushActionImpl", "Unknown command for ctrl");
                                break;
                            case 59:
                                a(context, a2);
                                break;
                            case 60:
                                b.a(context, 2, true);
                                break;
                        }
                    }
                    break;
                case 26:
                    cn.jpush.android.bi.a aVar = new cn.jpush.android.bi.a(jPushResponse);
                    cn.jpush.android.helper.d.a().a(context, aVar.getRquestId(), aVar.a());
                    break;
                case 27:
                    cn.jpush.android.bi.a aVar2 = new cn.jpush.android.bi.a(jPushResponse);
                    if (aVar2.a() != 0) {
                        cn.jpush.android.bl.a.a().a(context, jPushResponse.getRquestId(), aVar2.a());
                        break;
                    } else {
                        cn.jpush.android.bl.a.a().a(context, jPushResponse.getRquestId());
                        break;
                    }
                case 28:
                case 29:
                    break;
                default:
                    Logger.w("JPushActionImpl", "Unknown command for parsing inbound. Union AD cmd: " + jPushResponse.getCmd());
                    break;
            }
            return;
        }
        cn.jpush.android.bk.a.a(context, new e(jPushResponse).a(), jPushResponse.getCmd() != 28 ? 2 : 1, jPushResponse.getRquestId());
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Logger.d("JPushActionImpl", "dealCancelNotification ids=" + optString);
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    if (cn.jpush.android.bg.d.a(context, str)) {
                        int a2 = b.a(str, 0);
                        Logger.d("JPushActionImpl", "message id:" + str + " is in local history ,try cancel notificationID : " + a2);
                        if (b.a(context, a2)) {
                            b.d(context, a2);
                            c.a(split.length == 2 ? split[1] : str, 1068, context);
                        }
                    } else if (cn.jpush.android.bg.d.a(context, str, null)) {
                        Logger.d("JPushActionImpl", "dealCancelNotification , do nothing ");
                    } else {
                        byte a3 = cn.jpush.android.bl.c.a().a(context, str);
                        Logger.d("JPushActionImpl", "message id:" + str + " may be ospush channel,try cancel by sdkType: " + ((int) a3));
                        if (a3 != -1) {
                            c.a(str, "", a3, 1069, context);
                        }
                    }
                    linkedList.add(str);
                }
            }
            cn.jpush.android.bg.d.a(context, linkedList);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "dealCancelNotification e:" + th);
        }
    }

    private boolean a(Context context) {
        Boolean bool = this.f9498a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            Logger.ww("JPushActionImpl", "context is null");
            return false;
        }
        this.f9500c = context.getApplicationContext();
        Boolean valueOf = Boolean.valueOf(cn.jpush.android.bm.a.h(context));
        this.f9498a = valueOf;
        cn.jpush.android.bc.a.a(context, valueOf.booleanValue());
        return this.f9498a.booleanValue();
    }

    private void b(Context context) {
        Logger.d("JPushActionImpl", "serviceInit...");
        try {
            if (this.f9499b != null) {
                return;
            }
            this.f9499b = true;
            boolean z = JPushConstants.SUPPORT_DY;
            b.a(context, 0, true);
            f.a().a(context);
            c(context);
            Logger.d("JPushActionImpl", "google:true");
            int i2 = cn.jpush.android.bc.b.f9501a != JPushConstants.SDK_VERSION_CODE ? 2 : 0;
            Logger.d("JPushActionImpl", "custom:1,dynamic:" + i2);
            cn.jpush.android.bg.e.a().a(context, null);
            JCoreHelper.reportSdkType(context, "push", 1, i2, cn.jpush.android.bc.b.f9501a);
            if (JPushConstants.canGetLbsInBackGround(context)) {
                cn.jpush.android.b.d.a(context).a();
            }
            cn.jpush.android.bc.a.a(context);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setSilenceTime] bundle is bull");
            return;
        }
        String string = bundle.getString("time");
        Logger.dd("JPushActionImpl", "action:setSilenceTime pushTime:" + string);
        cn.jpush.android.cache.a.c(context, string);
    }

    private void c(Context context) {
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("update", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setPushTime] bundle is bull");
            return;
        }
        cn.jpush.android.cache.a.b(context, true);
        String string = bundle.getString("time");
        if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(string).matches()) {
            Logger.ee("JPushActionImpl", "Invalid time format - " + string);
            return;
        }
        String h2 = cn.jpush.android.cache.a.h(context);
        if (string.equals(h2)) {
            Logger.dd("JPushActionImpl", "Already SetPushTime, give up - " + h2);
            return;
        }
        Logger.dd("JPushActionImpl", "action:setPushTime pushTime:" + string);
        cn.jpush.android.cache.a.b(context, string);
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object beforLogin(Context context, String str, int i2, String str2) {
        String str3;
        a(context);
        if (context == null) {
            str3 = "context was null";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                if ("platformtype".equals(str2)) {
                    if (i2 >= 16) {
                        return Byte.valueOf(cn.jpush.android.bl.c.a().e(context));
                    }
                } else if ("platformregid".equals(str2)) {
                    return cn.jpush.android.bl.c.a().f(context);
                }
                return null;
            }
            str3 = " filed name was empty";
        }
        Logger.e("JPushActionImpl", str3);
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPopWinActivity(Context context) {
        return new cn.jpush.android.ui.b();
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPushActivity(Context context) {
        return new cn.jpush.android.ui.c();
    }

    @Override // cn.jpush.android.local.JPushAction
    public String getSdkVersion(String str) {
        return cn.jpush.android.bc.b.f9502b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x04a8, code lost:
    
        if (r4 == 2001) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04aa, code lost:
    
        if (r4 == 0) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04ac, code lost:
    
        if (r4 != 2002) goto L221;
     */
    @Override // cn.jpush.android.local.JPushAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleAction(android.content.Context r18, java.lang.String r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bb.a.handleAction(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // cn.jpush.android.local.JPushAction
    public void handleNotificationIntent(Context context, Intent intent) {
        d a2 = b.a(context, intent);
        Logger.i("JPushActionImpl", "handleNotificationIntent:" + a2);
        if (a2 == null) {
            if (C0153a.a(context, intent)) {
                Logger.i("JPushActionImpl", "handleNotificationIntent handleOpenClick:true");
                return;
            }
            return;
        }
        if (cn.jpush.android.d.b.a(a2.f9697a, a2)) {
            Logger.d("JPushActionImpl", "ssp notification touch action, action: " + intent.getAction());
            cn.jpush.android.bc.a.a(context, intent.getAction(), a2);
            return;
        }
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()) && a2.m != 1) {
            byte b2 = a2.af;
            if (b2 == 0) {
                c.a(a2.f9700d, 1000, context);
            } else {
                c.a(context, a2.f9700d, b2, (String) null);
            }
            int d2 = b.d(context, a2);
            Logger.d("JPushActionImpl", "is deep link:" + d2);
            if (d2 == 0) {
                try {
                    List<String> b3 = cn.jpush.android.bm.a.b(context, new Intent(intent.getAction()), a2.f9698b + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
                    if (b3 == null || b3.isEmpty()) {
                        Logger.dd("JPushActionImpl", "not found receiver by action:cn.jpush.android.intent.NOTIFICATION_OPENED,will start main activity");
                        cn.jpush.android.bm.a.f(context);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        b.a(context, intent.getAction(), a2, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onActivityLifeCallback(Activity activity, String str) {
        try {
            cn.jpush.android.bc.a.a(activity, str);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "onActivityLifeCallback failed. " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_CLICK);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        cn.jpush.android.helper.a.a().a(context.getApplicationContext(), jPushMessageReceiver, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMessage(Context context, CustomMessage customMessage) {
        cn.jpush.android.helper.a.a(context, customMessage);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMultiAction(Context context, Intent intent) {
        cn.jpush.android.helper.a.a(context, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_OPENED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onTagAliasResponse(Context context, long j, int i2, Intent intent) {
        cn.jpush.android.bk.c.a().a(context.getApplicationContext(), j, i2, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        cn.jpush.android.bk.a.a(context, str, set, callBackParams);
    }
}
