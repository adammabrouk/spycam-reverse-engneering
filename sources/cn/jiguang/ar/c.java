package cn.jiguang.ar;

import android.content.Context;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8339a = b.b(new byte[]{109, 80, 79, 112, 92, 113, 16, 94, 75, 69, 96, 119, 115, 80, 106, 37, 85, 97, 101, 91, 73, 71, 68, 113, 97, 45, 79, 88, 80, 116, 99, 91, 97, 71, 90, 114, 71, 72, 76, 82, 118, 82, 82, 88, 90, 64, 101, 106, 17, 74, 125, 98, 126, 114, 70, 83, 70, 81, 98, 102, 86, 86, 70, 71, 39, 31, 87, 122, 126, 122, 91, 69, 69, 96, 56, 47, 82, 116, 66, 79, 57, 94, 71, 89, 116, 76, 126, 122, 105, 117, 99, 84, 88, 80, 114, 104, 76, 125, 124, 81, 83, 96, 111, 107, 105, Byte.MAX_VALUE, 105, 102, 73, 111, 82, 69, 67, 105, 76, 110, 126, 124, 72, 101, 107, 106, 102, 67, 93, 118, 108, 88, 66, 89, 40, 91, 106, 90, 112, 64, 112, 2, 102, 113, 68, 70, 85, 84, 90, 87, 63, 117, 97, 94, 70, 44, Byte.MAX_VALUE, 126, 33, 123, 116, 46, 48, 96, 70, 31, 82, 94, 56, 90, 93, 87, 22, 95, 94, 103, 121, 104, 111, 122, 100, 66, 73, 117, 68, 45, 112, 102, 41, 82, 100, 104, 108, 123, 71, 74, 106, 117, 66, 89, 72, 5, 88, 105, 114, 47, 115, 117, 118, 87, 69, 35, 62, 97, 105, 93, 73, 71, 80, 114});

    public static String a() {
        return f8339a;
    }

    public static String a(Context context, String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appKey", cn.jiguang.ap.f.l(context));
            jSONObject2.put("cuid", str);
            jSONObject2.put("rid", str2);
            jSONObject2.put("value", jSONObject);
            jSONObject2.put("time", System.currentTimeMillis());
            return b(context, c(), jSONObject2);
        } catch (Throwable th) {
            f.b("JOperateHttpHelper", "setLoginTag e1:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, String str, JSONObject jSONObject) {
        try {
            jSONObject.put("appKey", cn.jiguang.ap.f.l(context));
            jSONObject.put("cuid", str);
            jSONObject.put("time", System.currentTimeMillis());
            return b(context, d(), jSONObject);
        } catch (Throwable th) {
            f.b("JOperateHttpHelper", "setChannel:", th);
            return a(th).toString();
        }
    }

    public static String a(Context context, JSONObject jSONObject) {
        return b(context, b(), jSONObject);
    }

    public static String a(String str) {
        try {
            return cn.jiguang.bk.e.b(str, a(), "RSA/ECB/PKCS1Padding");
        } catch (Throwable unused) {
            f.e("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static JSONObject a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, -1);
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG, th.getMessage());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String b() {
        return b("/v1/visual-bury-sdk-api/smartop/debug/report");
    }

    public static String b(Context context, String str, JSONObject jSONObject) {
        try {
            HttpRequest httpRequest = new HttpRequest(str);
            httpRequest.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpRequest.setRequestProperty("Accept", "application/json");
            String a2 = cn.jiguang.bk.e.a(cn.jiguang.bk.e.a());
            httpRequest.setRequestProperty(HttpHeaders.AUTHORIZATION, a(a2));
            String jSONObject2 = jSONObject.toString();
            f.a("JOperateHttpHelper", "sendHttp ulr:" + httpRequest.getUrl());
            f.a("JOperateHttpHelper", "sendHttp body:" + jSONObject2);
            httpRequest.setBody(cn.jiguang.bk.e.a(jSONObject2.getBytes("UTF-8"), a2, "q5bfn8msyozljacg", true));
            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
            f.a("JOperateHttpHelper", "sendHttp httpResponse:" + httpPost.toString());
            if (200 == httpPost.getResponseCode()) {
                return httpPost.getResponseBody();
            }
            f.f("JOperateHttpHelper", "sendHttp: httpResponse:" + httpPost);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(JThirdPlatFormInterface.KEY_CODE, -1);
                jSONObject3.put(JThirdPlatFormInterface.KEY_MSG, httpPost);
            } catch (Throwable unused) {
            }
            return jSONObject3.toString();
        } catch (Throwable th) {
            f.b("JOperateHttpHelper", "sendHttp11:", th);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(JThirdPlatFormInterface.KEY_CODE, -1);
                jSONObject4.put(JThirdPlatFormInterface.KEY_MSG, th.getMessage());
            } catch (Throwable unused2) {
            }
            return jSONObject4.toString();
        }
    }

    public static String b(String str) {
        return "https://sdkapi-smartop.jiguang.cn" + str;
    }

    public static String c() {
        return b("/v1/visual-bury-sdk-api/smartop/setUserInfo");
    }

    public static String d() {
        return b("/v1/visual-bury-sdk-api/smartop/setChannel");
    }
}
