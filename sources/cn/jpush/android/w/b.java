package cn.jpush.android.w;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.v.e;
import java.io.LineNumberReader;
import java.io.StringReader;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static void a(Context context, int i2, String str, String str2, String str3, long j, byte b2) {
        if (!str2.equals(context.getPackageName())) {
            cn.jpush.android.r.b.h("JUnionMessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        cn.jpush.android.r.b.b("JUnionMessageHelper", "action:receivedPushMessage msgId = " + j);
        cn.jpush.android.d.d a2 = cn.jpush.android.d.d.a(str, str2, str3, j);
        if (a2 == null) {
            return;
        }
        if ((i2 == 0 && !a(a2)) || cn.jpush.android.x.d.a(context, a2.a()) || cn.jpush.android.az.b.a(context, a2.f9700d, a2.f9704h)) {
            return;
        }
        a2.af = b2;
        a2.f9697a = i2;
        cn.jpush.android.d.d a3 = cn.jpush.android.d.d.a(context, a2);
        if (a3 == null) {
            a(context, a2);
            return;
        }
        a3.f9697a = i2;
        a3.bq = 201;
        a3.aw = i2;
        cn.jpush.android.an.a.a().a(context, a3);
    }

    public static void a(Context context, cn.jpush.android.bi.c cVar) {
        int a2 = cVar.a();
        if (!a(a2)) {
            cn.jpush.android.r.b.b("JUnionMessageHelper", "not ad message need not deal it, msgType: " + a2);
            return;
        }
        long b2 = cVar.b();
        String c2 = cVar.c();
        cn.jpush.android.r.b.b("JUnionMessageHelper", "msgType = " + a2 + ", msgId = " + b2);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c2);
        cn.jpush.android.r.b.a("JUnionMessageHelper", sb.toString());
        cn.jpush.android.r.b.b("JUnionMessageHelper", "msgContent size:" + c2.getBytes().length);
        cn.jpush.android.r.b.d("JUnionMessageHelper", "receive AD message, time: " + System.currentTimeMillis());
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c2));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                cn.jpush.android.r.b.h("JUnionMessageHelper", "NO appId");
                return;
            }
            if (readLine2 == null) {
                cn.jpush.android.r.b.h("JUnionMessageHelper", "NO senderId");
                return;
            }
            int length = readLine.length() + readLine2.length() + 2;
            if (c2.length() <= length + 1) {
                cn.jpush.android.r.b.b("JUnionMessageHelper", "No msgContent");
                return;
            }
            String substring = c2.substring(length);
            if (!readLine2.equals(cn.jpush.android.l.a.c(context))) {
                cn.jpush.android.r.b.h("JUnionMessageHelper", "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + cn.jpush.android.l.a.c(context));
                return;
            }
            cn.jpush.android.r.b.a("JUnionMessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring + ", contentLen: " + substring.length());
            if (a2 != 0) {
                switch (a2) {
                    case 102:
                        a(context, substring, readLine, readLine2, b2, cVar.rquestId);
                        break;
                    case 103:
                    case 104:
                        break;
                    default:
                        cn.jpush.android.r.b.g("JUnionMessageHelper", "unkown msg type");
                        break;
                }
                return;
            }
            a(context, a2, substring, readLine, readLine2, b2, (byte) 0);
        } catch (Throwable th) {
            cn.jpush.android.r.b.b("JUnionMessageHelper", "Parse msgContent failed", th);
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        cn.jpush.android.r.b.b("JUnionMessageHelper", "processNotifyEntity type:" + dVar.f9702f);
        dVar.f9702f = 1;
        if (cn.jpush.android.cache.a.e(context)) {
            cn.jpush.android.r.b.d("JUnionMessageHelper", "Service is stoped, give up all the message");
            return;
        }
        dVar.a(context);
        if (cn.jpush.android.ax.a.a(context)) {
            cn.jpush.android.az.b.b(context, dVar.f9700d);
            cn.jpush.android.ax.a.a(context, dVar);
        } else {
            cn.jpush.android.l.c.a(context, dVar.f9700d, 986, 3);
            cn.jpush.android.r.b.e("JUnionMessageHelper", "push is invalidPushTime，Intercept the message");
        }
    }

    public static void a(Context context, String str, String str2, String str3, long j, byte b2) {
        try {
            cn.jpush.android.r.b.b("JUnionMessageHelper", "[processInAppMessage] received in-app message, msgId = " + j + ", appId: " + str2 + ", appKey: " + str3);
            cn.jpush.android.d.d a2 = cn.jpush.android.x.b.a(str, str2, str3, j);
            if (a2 == null) {
                return;
            }
            if (!str2.equals(context.getPackageName())) {
                cn.jpush.android.r.b.h("JUnionMessageHelper", "[processInAppMessage] msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
                cn.jpush.android.l.c.a(context, a2.f9700d, 1282, 0);
                return;
            }
            if (cn.jpush.android.x.d.a(context, a2.a())) {
                cn.jpush.android.l.c.a(context, a2.f9700d, 1309, 0);
                return;
            }
            if (cn.jpush.android.cache.a.e(context)) {
                cn.jpush.android.r.b.d("JUnionMessageHelper", "Service is stopped, give up all the message");
                cn.jpush.android.l.c.a(context, a2.f9700d, 1265, 0);
                return;
            }
            a2.bq = 200;
            cn.jpush.android.an.a.a().a(context, a2);
            if (TextUtils.isEmpty(a2.bx) || !cn.jpush.android.ar.d.a(a2.bx)) {
                return;
            }
            cn.jpush.android.r.b.b("JUnionMessageHelper", "inapp message receive, call cmd3, posId: " + a2.by + ", posGap: " + a2.bE + ", curPageName: " + a2.bx);
            e.a().a(context, a2.by, (long) a2.bE, 0L);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("JUnionMessageHelper", "[processInAppMessage] process in app message failed, error: " + th.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("render_type", 0);
            String optString = jSONObject.optString("ad_id", "");
            String optString2 = jSONObject.optString("sequence_id", "");
            if (optInt == 0) {
                cn.jpush.android.r.b.d("JUnionMessageHelper", "Inapp ad received, reqId: " + j2 + ", seqId: " + optString2);
                a(context, str, str2, str3, j, (byte) 0);
            } else {
                cn.jpush.android.r.b.d("JUnionMessageHelper", "Native ad received, reqId: " + j2 + ", seqId: " + optString2);
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(JThirdPlatFormInterface.KEY_MSG_ID, optString);
                jSONObject2.put("sequence_id", optString2);
                jSONObject2.put("msg_data", str);
                dVar.bG = jSONObject2.toString();
                cn.jpush.android.ax.a.a(context, "ad_arrived_native", dVar);
                cn.jpush.android.l.c.a(context, optString, 21099, 1);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionMessageHelper", "dispatchAdMessage failed, error: " + th.getMessage());
        }
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 103 || i2 == 104 || i2 == 102;
    }

    public static boolean a(cn.jpush.android.d.d dVar) {
        String str = "";
        if (dVar == null) {
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
}
