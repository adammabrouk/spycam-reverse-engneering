package cn.jpush.android.ar;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends cn.jpush.android.bm.e {

    /* renamed from: a, reason: collision with root package name */
    public Context f9298a;

    /* renamed from: b, reason: collision with root package name */
    public cn.jpush.android.d.d f9299b;

    /* renamed from: c, reason: collision with root package name */
    public cn.jpush.android.as.a f9300c;

    public e(Context context, cn.jpush.android.d.d dVar, cn.jpush.android.as.a aVar) {
        this.f9298a = context;
        this.f9299b = dVar;
        this.f9300c = aVar;
        this.f9666f = "AdInAppHelper#Action";
    }

    private boolean a(Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            cn.jpush.android.r.b.b("InAppMessageAction", "[handleInAppMessage] context or pushEntity is null");
            if (dVar != null) {
                d.a(context, "handleInAppMessage", dVar.f9700d);
            }
            return false;
        }
        cn.jpush.android.r.b.b("InAppMessageAction", "[handleInAppMessage] message: type: " + dVar.aC + ", showType: " + dVar.aD + ", showPos: " + dVar.aE + ", checkIntentType: " + dVar.bd);
        try {
            int b2 = b(context, dVar);
            if (b2 != 0) {
                cn.jpush.android.l.c.a(context, dVar.f9700d, b2, 0);
                cn.jpush.android.r.b.f("InAppMessageAction", "in-app message not show frequency is too frequently");
                return false;
            }
            int c2 = c(context, dVar);
            if (c2 != 0) {
                cn.jpush.android.l.c.a(context, dVar.f9700d, c2, 0);
                cn.jpush.android.r.b.f("InAppMessageAction", "in-app message not show for adPos frequency is too frequently");
                return false;
            }
            if (d(context, dVar)) {
                return false;
            }
            if (!f(context, dVar)) {
                cn.jpush.android.r.b.f("InAppMessageAction", "wx mini program link, but some param not match, in-app not show");
                cn.jpush.android.r.b.g("IN-AT", "bad params of wx mini link");
                return false;
            }
            if (!e(context, dVar)) {
                cn.jpush.android.r.b.g("IN-AT", "bad params of d link");
                return false;
            }
            if (g(context, dVar) == null) {
                cn.jpush.android.r.b.g("IN-AT", "dl tpl failed");
                return false;
            }
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1263, 0);
            cn.jpush.android.an.a.a(context, "ad_arrived_sdk", dVar, true);
            return true;
        } catch (Throwable th) {
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1268, 0);
            cn.jpush.android.r.b.f("InAppMessageAction", "[handleInAppMessage] error. " + th.getMessage());
            return false;
        }
    }

    public static int b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (dVar == null || context == null) {
                cn.jpush.android.r.b.f("InAppMessageAction", "unexcepted error param is null");
                return 1269;
            }
            int max = Math.max(dVar.aL, 0);
            long max2 = Math.max(dVar.aM, 0L) * 1000;
            if (max > 0) {
                cn.jpush.android.r.b.b("InAppMessageAction", "set in-app message LimitCount:" + max);
            }
            if (max2 > 0) {
                cn.jpush.android.r.b.b("InAppMessageAction", "set in-app message LimitInterval:" + max2);
            }
            int a2 = d.a(context, max, max2);
            if (a2 == -3) {
                return 1269;
            }
            if (a2 != -2) {
                return a2 != -1 ? 0 : 1202;
            }
            return 1203;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppMessageAction", "parse in-app message frequency failed, error:" + th.getMessage());
            return 1269;
        }
    }

    public static int c(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (dVar == null || context == null) {
                cn.jpush.android.r.b.f("InAppMessageAction", "[checkInAppAdPosFrequency] unexcepted error param is null");
                return 1269;
            }
            int max = Math.max(dVar.bD, 0);
            long max2 = Math.max(dVar.bE, 0) * 1000;
            if (max > 0) {
                cn.jpush.android.r.b.b("InAppMessageAction", "set in-app message adpos LimitCount:" + max);
            }
            if (max2 > 0) {
                cn.jpush.android.r.b.b("InAppMessageAction", "set in-app message adpos LimitInterval:" + max2);
            }
            String str = dVar.by;
            if (TextUtils.isEmpty(str)) {
                str = "default";
            }
            int a2 = d.a(context, str, max, max2);
            if (a2 == -3) {
                return 1269;
            }
            if (a2 != -2) {
                return a2 != -1 ? 0 : 1332;
            }
            return 1333;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppMessageAction", "parse in-app message adpos frequency failed, error:" + th.getMessage());
            return 1269;
        }
    }

    public static boolean d(Context context, cn.jpush.android.d.d dVar) {
        if (context != null && dVar != null) {
            try {
                if (dVar.aI == 1 && cn.jpush.android.an.a.a().c(context, 200)) {
                    cn.jpush.android.r.b.c("InAppMessageAction", "need not show in-app message by user");
                    cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_UN_SHOW_INTERVAL", dVar, false);
                    cn.jpush.android.l.c.a(context, dVar.f9700d, 1206, 0);
                    return true;
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppMessageAction", "check user intercept the message show error. " + th.getMessage());
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c9, code lost:
    
        cn.jpush.android.r.b.b("InAppMessageAction", "deeplink is empty or not a http/https url, not show in-app message");
        cn.jpush.android.l.c.a(r14, r4, 1207, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d3, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0110, code lost:
    
        cn.jpush.android.r.b.f("InAppMessageAction", "targetPkgname:" + r6 + " not installed and failed type:" + r11 + ", not show in-app message");
        cn.jpush.android.l.c.a(r14, r4, 1208, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0136, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean e(android.content.Context r14, cn.jpush.android.d.d r15) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.e.e(android.content.Context, cn.jpush.android.d.d):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c7 A[Catch: all -> 0x0207, TryCatch #0 {all -> 0x0207, blocks: (B:5:0x000f, B:6:0x0030, B:8:0x0036, B:12:0x01c9, B:13:0x005d, B:81:0x0065, B:15:0x0070, B:18:0x00ac, B:20:0x00b2, B:22:0x00b8, B:25:0x00c7, B:27:0x00da, B:34:0x00ec, B:77:0x0136, B:36:0x0142, B:38:0x0148, B:40:0x0150, B:69:0x0156, B:42:0x0162, B:66:0x0168, B:44:0x0174, B:46:0x018e, B:48:0x0194, B:51:0x019b, B:54:0x01a9, B:56:0x01b7, B:61:0x01c0, B:58:0x01c7, B:73:0x01d2, B:85:0x01e0, B:87:0x01fe), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(android.content.Context r22, cn.jpush.android.d.d r23) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.e.f(android.content.Context, cn.jpush.android.d.d):boolean");
    }

    public static cn.jpush.android.d.d g(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        boolean z;
        if (context == null || dVar == null) {
            cn.jpush.android.r.b.f("InAppMessageAction", "unexpected param is null, context: " + context + ", pushEntity: " + dVar);
            if (dVar != null) {
                d.a(context, "handleH5Template", dVar.f9700d);
            }
            return null;
        }
        String str3 = dVar.bf;
        String str4 = dVar.f9700d;
        LinkedHashMap<String, cn.jpush.android.aw.f> a2 = g.a(context);
        cn.jpush.android.aw.f fVar = a2.get(str3);
        str = "";
        if (fVar != null) {
            str2 = fVar.f9436b;
            if (cn.jpush.android.bm.c.a(str2)) {
                dVar.bb = "file://" + str2;
                fVar.f9437c = System.currentTimeMillis();
                boolean lastModified = new File(str2).setLastModified(fVar.f9437c);
                cn.jpush.android.l.c.a(context, str4, 1283, 0);
                cn.jpush.android.r.b.b("InAppMessageAction", "use cache template, templateId: " + str3 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a2.values().size() + ", update template file time: " + lastModified);
            } else {
                a2.remove(str3);
                cn.jpush.android.r.b.b("InAppMessageAction", "local config has template path, but the template file is not exist, will download again.");
                str2 = "";
            }
            g.a(context, a2);
        } else {
            str2 = "";
        }
        String str5 = dVar.bg;
        if (TextUtils.isEmpty(str2)) {
            cn.jpush.android.r.b.b("InAppMessageAction", "no local template cache, start download template, url: " + str5);
            if (TextUtils.isEmpty(str5)) {
                cn.jpush.android.r.b.f("InAppMessageAction", "template url is Empty! Give up to download!");
                z = false;
            } else {
                String a3 = cn.jpush.android.bf.a.a(str5, 5, 5000L);
                boolean isEmpty = TextUtils.isEmpty(a3);
                str = isEmpty ? "" : a3;
                z = !isEmpty;
            }
            if (!z) {
                cn.jpush.android.r.b.f("InAppMessageAction", "NOTE: failed to download html page. Give up this.");
                cn.jpush.android.l.c.a(context, dVar.f9700d, 1231, 0);
                return null;
            }
            String str6 = cn.jpush.android.bm.c.a(context, "h5_tpls", 20) + str3 + ".html";
            cn.jpush.android.r.b.b("InAppMessageAction", "download template success, will save to local of path: " + str6);
            if (cn.jpush.android.bm.c.b(str6, str)) {
                dVar.bb = "file://" + str6;
                cn.jpush.android.r.b.b("InAppMessageAction", "cache h5 template to local success, templateId: " + str3 + ", path: " + dVar.bb);
                a2.put(str3, cn.jpush.android.aw.f.a(str3, str6, System.currentTimeMillis()));
                g.a(context, a2);
                cn.jpush.android.l.c.a(context, str4, 1273, 0);
            } else {
                cn.jpush.android.l.c.a(context, str4, 1233, 0);
                dVar.bb = dVar.bg;
            }
        }
        if (dVar.bk.size() > 0 || !TextUtils.isEmpty(dVar.bp)) {
            String substring = str5.substring(0, str5.lastIndexOf("/") + 1);
            if (dVar.bk.size() > 0) {
                cn.jpush.android.r.b.b("InAppMessageAction", "template has image resource, start download image to local, images: " + dVar.bk.toString());
                ArrayList<String> a4 = g.a(dVar.bk, context, substring, str4);
                if (a4 == null) {
                    cn.jpush.android.l.c.a(context, str4, 1232, 0);
                    cn.jpush.android.r.b.f("InAppMessageAction", "Loads in-app message image resources failed, give up this in app!");
                    return null;
                }
                cn.jpush.android.r.b.b("InAppMessageAction", "Loads in-app message image succeed, webView will open cache!");
                String str7 = dVar.bi;
                try {
                    JSONObject jSONObject = new JSONObject(str7);
                    int i2 = 0;
                    while (i2 < a4.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        int i3 = i2 + 1;
                        sb.append(i3);
                        jSONObject.put(sb.toString(), a4.get(i2));
                        i2 = i3;
                    }
                    dVar.bi = jSONObject.toString();
                    cn.jpush.android.r.b.b("InAppMessageAction", "http image resources replace local path, new templateData: " + dVar.bi);
                } catch (JSONException e2) {
                    dVar.bi = str7;
                    cn.jpush.android.l.c.a(context, str4, 1266, 0);
                    cn.jpush.android.r.b.f("InAppMessageAction", "replace template picture resource error, " + e2.getMessage());
                }
            }
            if (!TextUtils.isEmpty(dVar.bp)) {
                cn.jpush.android.r.b.b("InAppMessageAction", "template has image resource, start download image to local, icon: " + dVar.bp);
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar.bp);
                ArrayList<String> a5 = g.a(arrayList, context, substring, str4, false);
                if (a5 == null) {
                    cn.jpush.android.l.c.a(context, str4, 1232, 0);
                    cn.jpush.android.r.b.f("InAppMessageAction", "Loads in-app message image icon resources failed, give up this in app!");
                    return null;
                }
                cn.jpush.android.r.b.b("InAppMessageAction", "Loads in-app message image icon succeed, webView will open cache!");
                String str8 = dVar.bi;
                try {
                    JSONObject jSONObject2 = new JSONObject(str8);
                    for (int i4 = 0; i4 < a5.size(); i4++) {
                        jSONObject2.put("in_app_icon", a5.get(i4));
                    }
                    dVar.bi = jSONObject2.toString();
                    cn.jpush.android.r.b.b("InAppMessageAction", "http image icon resources replace local path, new templateData: " + dVar.bi);
                } catch (JSONException e3) {
                    dVar.bi = str8;
                    cn.jpush.android.l.c.a(context, str4, 1266, 0);
                    cn.jpush.android.r.b.f("InAppMessageAction", "replace template picture icon resource error, " + e3.getMessage());
                }
            }
        } else {
            cn.jpush.android.r.b.b("InAppMessageAction", "template no image resource.");
        }
        return dVar;
    }

    @Override // cn.jpush.android.bm.e
    public void a() {
        try {
            if (a(this.f9298a, this.f9299b) || this.f9300c == null) {
                return;
            }
            this.f9300c.a(this.f9298a, this.f9299b.bq, d.a(this.f9299b.aC, this.f9299b.aE), 0);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppMessageAction", "run InAppMessageAction failed:" + th.getMessage());
        }
    }
}
