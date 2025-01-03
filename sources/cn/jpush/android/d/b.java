package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static CustomMessage a(Intent intent) {
        String stringExtra;
        CustomMessage customMessage;
        CustomMessage customMessage2 = null;
        try {
            stringExtra = intent.getStringExtra("msgid");
            customMessage = new CustomMessage();
        } catch (Throwable th) {
            th = th;
        }
        try {
            customMessage.messageId = stringExtra;
            customMessage.appId = intent.getStringExtra("appId");
            customMessage.senderId = intent.getStringExtra("senderId");
            String stringExtra2 = intent.getStringExtra(JThirdPlatFormInterface.KEY_DATA);
            if (stringExtra2 != null) {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                customMessage.message = jSONObject.optString("message", "");
                customMessage.contentType = jSONObject.optString("content_type", "");
                customMessage.title = jSONObject.optString("title", "");
                customMessage.extra = jSONObject.optString("extras", "");
            }
            if (JPushConstants.SDK_VERSION_CODE >= 387) {
                customMessage.platform = intent.getByteExtra(JThirdPlatFormInterface.KEY_PLATFORM, (byte) 0);
            }
            d.a(stringExtra, intent.getStringExtra("_j_data_"));
            return customMessage;
        } catch (Throwable th2) {
            th = th2;
            customMessage2 = customMessage;
            Logger.w("MessageHelper", "processMessage failed:" + th.getMessage());
            return customMessage2;
        }
    }

    public static cn.jpush.android.b.b a(d dVar) {
        try {
            cn.jpush.android.b.b a2 = cn.jpush.android.b.b.a(new JSONObject(dVar.f9705i).optJSONObject("geofence"));
            if (a2 == null) {
                return null;
            }
            a2.t = dVar;
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, int i2, long j, long j2, String str) {
        JCoreHelper.sendData(context, JPushConstants.SDK_TYPE, 4, 3, j2, cn.jpush.android.bi.b.a(0, (byte) i2, j, str));
    }

    public static void a(Context context, int i2, String str, String str2, String str3, long j, byte b2) {
        if (!str2.equals(context.getPackageName())) {
            Logger.e("MessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        Logger.d("MessageHelper", "action:receivedPushMessage msgId = " + j);
        d a2 = d.a(str, str2, str3, j);
        if (a2 == null) {
            return;
        }
        if (a(i2, a2)) {
            Logger.d("MessageHelper", "ssp notification, msgType: " + i2);
            return;
        }
        if (c.a(context, a2.a()) || cn.jpush.android.bg.d.a(context, a2.f9700d, a2.f9704h)) {
            return;
        }
        a2.af = b2;
        a2.f9697a = i2;
        cn.jpush.android.b.b a3 = a(a2);
        if (a3 == null || TextUtils.isEmpty(a3.f9482a)) {
            a(context, a2);
        } else {
            cn.jpush.android.b.d.a(context).a(a3);
        }
    }

    public static void a(Context context, cn.jpush.android.bi.c cVar) {
        String d2 = d.d(cVar.c());
        a(context, cVar.a(), cVar.b(), cVar.getRid(), d2);
        long b2 = cVar.b();
        int a2 = cVar.a();
        String c2 = cVar.c();
        Logger.d("MessageHelper", "msgType = " + a2 + ", msgId = " + b2 + ", jdata = " + d2);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c2);
        Logger.v("MessageHelper", sb.toString());
        Logger.d("MessageHelper", "msgContent size:" + c2.getBytes().length);
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c2));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                Logger.e("MessageHelper", "NO appId");
                return;
            }
            if (readLine2 == null) {
                Logger.e("MessageHelper", "NO senderId");
                return;
            }
            int length = readLine.length() + readLine2.length() + 2;
            if (c2.length() <= length + 1) {
                Logger.d("MessageHelper", "No msgContent");
                return;
            }
            String substring = c2.substring(length);
            if (!readLine2.equals(JCoreHelper.getAppKey(context))) {
                Logger.e("MessageHelper", "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + JCoreHelper.getAppKey(context));
                return;
            }
            Logger.v("MessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring + ", contentLen: " + substring.length());
            if (a2 != 0 && a2 != 2) {
                if (a2 == 20) {
                    cn.jpush.android.bk.a.a(context, substring, 0, -1L);
                    return;
                } else if (a2 != 100 && a2 != 101) {
                    Logger.d("MessageHelper", "unknown msg type, type: " + a2);
                    return;
                }
            }
            a(context, a2, substring, readLine, readLine2, b2, (byte) 0);
        } catch (Throwable th) {
            Logger.e("MessageHelper", "Parse msgContent failed", th);
        }
    }

    public static void a(Context context, d dVar) {
        Logger.d("MessageHelper", "processBasicEntity type:" + dVar.f9702f);
        int i2 = dVar.k ? dVar.j == 4 ? 3 : 1 : 2;
        dVar.f9702f = i2;
        if ((i2 & 2) != 0) {
            Logger.d("MessageHelper", "processBasicEntity user-defined message.");
            if (TextUtils.isEmpty(dVar.n) && TextUtils.isEmpty(dVar.q)) {
                Logger.ww("MessageHelper", "no message or extra send to user");
            } else {
                b(context, dVar);
            }
        }
        if ((dVar.f9702f & 1) != 0) {
            Logger.d("MessageHelper", "processBasicEntity notification");
            if (cn.jpush.android.cache.a.e(context)) {
                Logger.i("MessageHelper", "Service is stoped, give up all the message");
                return;
            }
            dVar.a(context);
            if (cn.jpush.android.bg.b.b(context)) {
                cn.jpush.android.bg.d.b(context, dVar.f9700d);
                cn.jpush.android.bg.b.a(context, dVar);
            } else {
                cn.jpush.android.helper.c.a(dVar.f9700d, 986, context);
                Logger.ii("MessageHelper", "push is invalidPushTime，Intercept the message");
            }
        }
    }

    public static boolean a(int i2, d dVar) {
        String str = "";
        if (dVar == null || i2 != 0) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(dVar.f9705i).optJSONObject("m_content");
            if (optJSONObject != null) {
                str = optJSONObject.optString("n_source", "");
            }
        } catch (Throwable unused) {
        }
        return TextUtils.equals(str, "ssp");
    }

    public static void b(Context context, d dVar) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.dd("MessageHelper", "not found user push message,use old action to user");
                Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
                intent.putExtra(JPushInterface.EXTRA_APP_KEY, dVar.f9699c);
                intent.putExtra(JPushInterface.EXTRA_MESSAGE, dVar.n);
                intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, dVar.o);
                intent.putExtra(JPushInterface.EXTRA_TITLE, dVar.p);
                intent.putExtra(JPushInterface.EXTRA_EXTRA, dVar.q);
                intent.putExtra(JPushInterface.EXTRA_MSG_ID, dVar.f9700d);
                if (JPushConstants.SDK_VERSION_CODE >= 387) {
                    intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, dVar.af);
                }
                intent.addCategory(dVar.f9698b);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", dVar.f9698b));
                Logger.i("MessageHelper", "Send broadcast to app: " + String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", dVar.f9698b));
            } else {
                Intent intent2 = new Intent(context, Class.forName(messageReceiverClass));
                intent2.setAction(cn.jpush.android.bm.a.f(context, "custom_msg"));
                intent2.putExtra(JThirdPlatFormInterface.KEY_DATA, dVar.f9705i);
                intent2.putExtra("msgid", dVar.f9700d);
                intent2.putExtra("appId", dVar.f9698b);
                intent2.putExtra("senderId", dVar.f9699c);
                intent2.putExtra(JThirdPlatFormInterface.KEY_PLATFORM, dVar.af);
                intent2.putExtra("_j_data_", dVar.f9703g);
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    JPushConstants.getPushMessageReceiver(context).onMessage(context, a(intent2));
                } else {
                    context.sendBroadcast(intent2);
                }
            }
            if (dVar.af != 0) {
                cn.jpush.android.helper.c.a(dVar.f9700d, "", dVar.af, 1106, context);
            } else {
                cn.jpush.android.helper.c.a(dVar.f9700d, 1106, context);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "sendBroadcastToApp error:" + th.getMessage());
        }
    }
}
