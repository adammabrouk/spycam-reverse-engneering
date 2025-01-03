package cn.jpush.android.l;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.d.d;
import cn.jpush.android.k.e;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static void a(Context context, String str, int i2, int i3) {
        a(context, str, i2, "", i3, "", null);
    }

    public static void a(Context context, String str, int i2, String str2, int i3) {
        a(context, str, i2, str2, i3, "", null);
    }

    public static void a(Context context, String str, int i2, String str2, int i3, String str3) {
        a(context, str, i2, str2, i3, str3, null);
    }

    public static void a(Context context, String str, int i2, String str2, int i3, String str3, JSONObject jSONObject) {
        String str4;
        String str5;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("JUnionAdReportHelper", "report failed " + th.getMessage());
                return;
            }
        }
        if (i3 == 3) {
            String b2 = d.b(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = d.c(str);
            }
            str5 = b2;
            str4 = "";
        } else {
            String b3 = cn.jpush.android.x.b.b(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = cn.jpush.android.x.b.c(str);
            }
            str4 = b3;
            str5 = "";
        }
        jSONObject.put("render_type", i3);
        jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("url", str3);
        }
        a(context, str, i2, jSONObject.toString(), str5, str4);
        a(context, str, i2, str4, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:17:0x0063, B:19:0x0073, B:20:0x0078, B:22:0x007e, B:23:0x0083, B:26:0x008b, B:28:0x0094, B:30:0x009b, B:32:0x00a2, B:34:0x00b2, B:36:0x00c7), top: B:16:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[Catch: all -> 0x00cf, TRY_LEAVE, TryCatch #0 {all -> 0x00cf, blocks: (B:17:0x0063, B:19:0x0073, B:20:0x0078, B:22:0x007e, B:23:0x0083, B:26:0x008b, B:28:0x0094, B:30:0x009b, B:32:0x00a2, B:34:0x00b2, B:36:0x00c7), top: B:16:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "msg_status"
            java.lang.String r1 = "JUnionAdReportHelper"
            if (r4 != 0) goto Lc
            java.lang.String r4 = "context did not init, return"
            cn.jpush.android.r.b.b(r1, r4)
            return
        Lc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "action:report - messageId: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = ", code: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = "-"
            r2.append(r3)
            java.lang.String r3 = cn.jiguang.union.ads.api.JUnionAdError.getMessage(r6)
            r2.append(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L3b
            java.lang.String r3 = "， report content: "
            r2.append(r3)
            r2.append(r7)
        L3b:
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L49
            java.lang.String r3 = "， report jData:"
            r2.append(r3)
            r2.append(r8)
        L49:
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto L57
            java.lang.String r3 = ", report jAdPosData: "
            r2.append(r3)
            r2.append(r9)
        L57:
            java.lang.String r2 = r2.toString()
            cn.jpush.android.r.b.b(r1, r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "msg_id"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r5 = "result"
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> Lcf
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lcf
            if (r5 != 0) goto L78
            java.lang.String r5 = "data"
            r2.put(r5, r7)     // Catch: java.lang.Throwable -> Lcf
        L78:
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lcf
            if (r5 != 0) goto L83
            java.lang.String r5 = "_j_data_"
            r2.put(r5, r8)     // Catch: java.lang.Throwable -> Lcf
        L83:
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r7 = ""
            if (r5 != 0) goto La1
            java.lang.String r5 = "&"
            java.lang.String[] r5 = r9.split(r5)     // Catch: java.lang.Throwable -> Lcf
            int r8 = r5.length     // Catch: java.lang.Throwable -> Lcf
            if (r8 <= 0) goto La1
            r8 = 0
            r8 = r5[r8]     // Catch: java.lang.Throwable -> Lcf
            int r9 = r5.length     // Catch: java.lang.Throwable -> Lcf
            r3 = 1
            if (r9 <= r3) goto L9e
            r5 = r5[r3]     // Catch: java.lang.Throwable -> Lcf
            r7 = r5
        L9e:
            r5 = r7
            r7 = r8
            goto La2
        La1:
            r5 = r7
        La2:
            java.lang.String r8 = "position_id"
            r2.put(r8, r7)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r7 = "position"
            r2.put(r7, r5)     // Catch: java.lang.Throwable -> Lcf
            org.json.JSONObject r5 = cn.jpush.android.helper.JCoreHelper.fillBase(r4, r2, r0)     // Catch: java.lang.Throwable -> Lcf
            if (r5 != 0) goto Lc7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r4.<init>()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r5 = "report msg json is null, code: "
            r4.append(r5)     // Catch: java.lang.Throwable -> Lcf
            r4.append(r6)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lcf
            cn.jpush.android.r.b.g(r1, r4)     // Catch: java.lang.Throwable -> Lcf
            return
        Lc7:
            java.lang.String r6 = "type"
            r5.put(r6, r0)     // Catch: java.lang.Throwable -> Lcf
            a(r4, r5)     // Catch: java.lang.Throwable -> Lcf
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.l.c.a(android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void a(Context context, String str, int i2, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        try {
            str3 = "";
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("&");
                if (split.length > 0) {
                    String str5 = split[0];
                    str4 = split.length > 1 ? split[1] : "";
                    str3 = str5;
                    cn.jpush.android.z.a.a().b(context, new e().a(str).b(i2).c(str3).d(str4).a(jSONObject.optInt("render_type")).b(jSONObject.optString(InAppSlotParams.SLOT_KEY.SEQ)).e(jSONObject.optString("url")).c(jSONObject.optInt("url_result")).f(jSONObject.optString("page_name")).g(jSONObject.optString("fbName")).d((int) jSONObject.optLong("exp_time")).a());
                }
            }
            str4 = "";
            cn.jpush.android.z.a.a().b(context, new e().a(str).b(i2).c(str3).d(str4).a(jSONObject.optInt("render_type")).b(jSONObject.optString(InAppSlotParams.SLOT_KEY.SEQ)).e(jSONObject.optString("url")).c(jSONObject.optInt("url_result")).f(jSONObject.optString("page_name")).g(jSONObject.optString("fbName")).d((int) jSONObject.optLong("exp_time")).a());
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JUnionAdReportHelper", "reportMsgActionResultToUnion failed, " + th.getMessage());
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        cn.jpush.android.r.b.b("JUnionAdReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }
}
