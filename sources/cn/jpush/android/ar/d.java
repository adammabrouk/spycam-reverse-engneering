package cn.jpush.android.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PushActivity;
import com.shix.shixipc.utils.ShareSystemFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static long f9294a;

    /* renamed from: b, reason: collision with root package name */
    public static int f9295b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, String> f9296c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, String> f9297d = new HashMap();

    public static int a(int i2, int i3) {
        int i4 = 2;
        if (i2 != 1) {
            if (i2 != 2) {
                i4 = 3;
                if (i2 != 3) {
                    i4 = 0;
                } else if (i3 == 0) {
                    i4 = 4;
                }
            } else {
                i4 = 5;
            }
        } else if (i3 == 0) {
            i4 = 1;
        }
        cn.jpush.android.r.b.b("InAppHelper", "getMsgDisplayStyle, msgType: " + i2 + ", displayPos: " + i3 + ", style: " + i4);
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[Catch: all -> 0x000b, TRY_ENTER, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0005, B:14:0x002d, B:17:0x0033, B:18:0x0035, B:20:0x003f, B:22:0x0045, B:25:0x006f, B:27:0x0075, B:29:0x007b, B:32:0x004d, B:34:0x00a1), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x000b, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0005, B:14:0x002d, B:17:0x0033, B:18:0x0035, B:20:0x003f, B:22:0x0045, B:25:0x006f, B:27:0x0075, B:29:0x007b, B:32:0x004d, B:34:0x00a1), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[Catch: all -> 0x000b, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0005, B:14:0x002d, B:17:0x0033, B:18:0x0035, B:20:0x003f, B:22:0x0045, B:25:0x006f, B:27:0x0075, B:29:0x007b, B:32:0x004d, B:34:0x00a1), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[Catch: all -> 0x000b, TRY_LEAVE, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0005, B:14:0x002d, B:17:0x0033, B:18:0x0035, B:20:0x003f, B:22:0x0045, B:25:0x006f, B:27:0x0075, B:29:0x007b, B:32:0x004d, B:34:0x00a1), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r11, int r12, long r13) {
        /*
            r0 = -3
            java.lang.String r1 = "InAppHelper"
            if (r11 != 0) goto Le
            java.lang.String r11 = "unexception context is null"
            cn.jpush.android.r.b.f(r1, r11)     // Catch: java.lang.Throwable -> Lb
            return r0
        Lb:
            r11 = move-exception
            goto Lb0
        Le:
            r2 = 0
            r4 = 0
            java.lang.String r5 = cn.jpush.android.cache.a.p(r11)     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)     // Catch: java.lang.Throwable -> L29
            r6 = r5[r4]     // Catch: java.lang.Throwable -> L29
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L29
            r7 = 1
            r5 = r5[r7]     // Catch: java.lang.Throwable -> L2a
            long r7 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> L2a
            goto L2b
        L29:
            r6 = 0
        L2a:
            r7 = r2
        L2b:
            if (r6 != 0) goto L2f
            int r6 = cn.jpush.android.ar.d.f9295b     // Catch: java.lang.Throwable -> Lb
        L2f:
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 != 0) goto L35
            long r7 = cn.jpush.android.ar.d.f9294a     // Catch: java.lang.Throwable -> Lb
        L35:
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb
            boolean r5 = cn.jpush.android.bm.b.a(r9, r7)     // Catch: java.lang.Throwable -> Lb
            if (r5 == 0) goto La1
            cn.jpush.android.ar.d.f9295b = r6     // Catch: java.lang.Throwable -> Lb
            cn.jpush.android.ar.d.f9294a = r7     // Catch: java.lang.Throwable -> Lb
            if (r12 != 0) goto L4b
            java.lang.String r11 = "inApp count is 0, not limit count"
            cn.jpush.android.r.b.b(r1, r11)     // Catch: java.lang.Throwable -> Lb
            goto L6b
        L4b:
            if (r6 < r12) goto L6b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb
            r11.<init>()     // Catch: java.lang.Throwable -> Lb
            java.lang.String r13 = "inApp message count limit,inAppLastCount:"
            r11.append(r13)     // Catch: java.lang.Throwable -> Lb
            r11.append(r6)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r13 = ",inAppLimitCount:"
            r11.append(r13)     // Catch: java.lang.Throwable -> Lb
            r11.append(r12)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lb
            cn.jpush.android.r.b.f(r1, r11)     // Catch: java.lang.Throwable -> Lb
            r11 = -1
            return r11
        L6b:
            int r11 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r11 != 0) goto L75
            java.lang.String r11 = "inApp interval is 0, not limit time"
            cn.jpush.android.r.b.b(r1, r11)     // Catch: java.lang.Throwable -> Lb
            goto Laf
        L75:
            long r11 = r9 - r7
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 > 0) goto Laf
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb
            r11.<init>()     // Catch: java.lang.Throwable -> Lb
            java.lang.String r12 = "inApp message time limit,inAppLastTime:"
            r11.append(r12)     // Catch: java.lang.Throwable -> Lb
            r11.append(r7)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r12 = ",currentTime:"
            r11.append(r12)     // Catch: java.lang.Throwable -> Lb
            r11.append(r9)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r12 = ",inAppLimitInterval:"
            r11.append(r12)     // Catch: java.lang.Throwable -> Lb
            r11.append(r13)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lb
            cn.jpush.android.r.b.f(r1, r11)     // Catch: java.lang.Throwable -> Lb
            r11 = -2
            return r11
        La1:
            cn.jpush.android.ar.d.f9295b = r4     // Catch: java.lang.Throwable -> Lb
            cn.jpush.android.ar.d.f9294a = r2     // Catch: java.lang.Throwable -> Lb
            java.lang.String r12 = "is a new day,reset inAppState"
            cn.jpush.android.r.b.b(r1, r12)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r12 = "0,0"
            cn.jpush.android.cache.a.g(r11, r12)     // Catch: java.lang.Throwable -> Lb
        Laf:
            return r4
        Lb0:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "getSSPState error:"
            r12.append(r13)
            java.lang.String r11 = r11.getMessage()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            cn.jpush.android.r.b.f(r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.d.a(android.content.Context, int, long):int");
    }

    public static int a(Context context, String str, int i2, long j) {
        String str2;
        long j2;
        int i3;
        String str3;
        if (context == null) {
            str2 = "unexpected context is null";
        } else {
            cn.jpush.android.r.b.b("InAppHelper", "getInAppAdPosState adPosId: " + str + ", srvLimitCount: " + i2 + ", srvInterval: " + j);
            try {
                String q = cn.jpush.android.cache.a.q(context);
                if (TextUtils.isEmpty(q)) {
                    cn.jpush.android.r.b.b("InAppHelper", "no adpos frequency state data");
                    return 0;
                }
                try {
                    JSONArray jSONArray = new JSONArray(q);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                        if (jSONObject != null && jSONObject.optString("ad_pos_id", "").equals(str)) {
                            i3 = jSONObject.optInt("pos_msg_total_count", 0);
                            try {
                                j2 = jSONObject.optLong("pos_msg_latest_time", 0L);
                                try {
                                    cn.jpush.android.r.b.b("InAppHelper", "check adpos frequency, adPosId: " + str + ", lastCount: " + i3 + ", latestTime: " + j2);
                                    break;
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                                j2 = 0;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
                j2 = 0;
                i3 = 0;
                long currentTimeMillis = System.currentTimeMillis();
                if (cn.jpush.android.bm.b.a(currentTimeMillis, j2)) {
                    if (i2 == 0) {
                        cn.jpush.android.r.b.b("InAppHelper", "inApp adpos count is 0, not limit count");
                    } else if (i3 >= i2) {
                        cn.jpush.android.r.b.f("InAppHelper", "inApp adpos message count limit,inAppLastCount:" + i3 + ",inAppLimitCount:" + i2);
                        return -1;
                    }
                    if (j != 0) {
                        if (currentTimeMillis - j2 <= j) {
                            cn.jpush.android.r.b.f("InAppHelper", "inApp adpos message time limit,inAppLastTime:" + j2 + ",currentTime:" + currentTimeMillis + ",inAppLimitInterval:" + j);
                            return -2;
                        }
                        return 0;
                    }
                    str3 = "inApp adpos interval is 0, not limit time";
                } else {
                    str3 = "is a new day,reset inapp adpos state";
                }
                cn.jpush.android.r.b.b("InAppHelper", str3);
                return 0;
            } catch (Throwable th) {
                str2 = "getInAppAdPosState error: " + th.getMessage();
            }
        }
        cn.jpush.android.r.b.f("InAppHelper", str2);
        return -3;
    }

    public static String a() {
        Iterator<String> it = f9296c.values().iterator();
        String str = "";
        String next = it.hasNext() ? it.next() : "";
        Iterator<String> it2 = f9296c.keySet().iterator();
        while (it2.hasNext()) {
            str = it2.next();
        }
        if (!TextUtils.isEmpty(next)) {
            if (!TextUtils.isEmpty(str)) {
                next = str + "&" + next;
            }
            str = next;
        }
        cn.jpush.android.r.b.b("InAppHelper", "getCurrentPageNames: " + str);
        return str;
    }

    public static String a(Context context) {
        return cn.jpush.android.cache.a.r(context);
    }

    public static void a(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.aA;
            String str2 = dVar.aB;
            long currentTimeMillis = System.currentTimeMillis();
            String d2 = cn.jpush.android.bm.a.d(str + str2);
            cn.jpush.android.r.b.b("InAppHelper", "in-app message contentMd5: " + d2);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            cn.jpush.android.o.b.a(context, d2, currentTimeMillis);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHelper", "setLatestInAppInfo failed, " + th.getMessage());
        }
    }

    public static void a(Context context, String str) {
        long j;
        try {
            if (context == null) {
                cn.jpush.android.r.b.f("InAppHelper", "[setInAppState] unexpected context is null");
                return;
            }
            c(context, str);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            try {
                String[] split = cn.jpush.android.cache.a.p(context).split(",");
                i2 = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            } catch (Throwable unused) {
                j = 0;
            }
            if (i2 == 0) {
                i2 = f9295b;
            }
            if (j == 0) {
                j = f9294a;
            }
            int i3 = cn.jpush.android.bm.b.a(currentTimeMillis, j) ? 1 + i2 : 1;
            f9295b = i3;
            f9294a = currentTimeMillis;
            cn.jpush.android.r.b.b("InAppHelper", "setInAppState inAppCount:" + i3 + ",inAppTime:" + currentTimeMillis);
            StringBuilder sb = new StringBuilder();
            sb.append(i3);
            sb.append(",");
            sb.append(currentTimeMillis);
            cn.jpush.android.cache.a.g(context, sb.toString());
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHelper", "setInAppLastState error:" + th.getMessage());
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("funName", str);
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppHelper", "json add funName: " + str + ", error" + th.getMessage());
            }
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            cn.jpush.android.l.c.a(context, str2, 1257, "", 0, "", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(String str, int i2, boolean z) {
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                cn.jpush.android.r.b.f("InAppHelper", "[updateCurrentPage] pageName is null");
                return;
            }
            if (z) {
                if (i2 == 0 && !f9296c.isEmpty()) {
                    f9297d.putAll(f9296c);
                }
                if (f9296c.containsKey(str)) {
                    f9296c.clear();
                }
                if (i2 == 1) {
                    f9296c.put(str, f9297d.get(str));
                }
            } else if (i2 == 1) {
                Iterator<String> it = f9296c.keySet().iterator();
                if (it.hasNext()) {
                    f9296c.put(it.next(), str);
                }
            } else {
                Iterator<String> it2 = f9296c.keySet().iterator();
                if (it2.hasNext()) {
                    String next = it2.next();
                    if (str.equals(f9296c.get(next))) {
                        f9296c.put(next, "");
                    }
                }
            }
            cn.jpush.android.r.b.b("InAppHelper", "updateCurrentPage current pages: " + f9296c.toString());
        }
    }

    public static boolean a(Context context, int i2, String str, cn.jpush.android.d.d dVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            cn.jpush.android.r.b.b("InAppHelper", "link uri is empty, url: " + str + ", context: " + context);
            return false;
        }
        cn.jpush.android.r.b.b("InAppHelper", "[openWebUri], urlOpenType: " + i2 + ", url: " + str);
        try {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            if (i2 != 0) {
                if (i2 == 1) {
                    if (!cn.jpush.android.bm.a.d(context, "com.android.browser")) {
                        cn.jpush.android.r.b.c("InAppHelper", "not found com.android.browser,user will choose other browser");
                        throw new Throwable("not found com.android.browser,user will choose other browser");
                    }
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    a(context, intent);
                }
            } else {
                if (!e(context)) {
                    cn.jpush.android.r.b.g("InAppHelper", "please check layout file jpush_webview_layout.xml!");
                    throw new Throwable("not found layout file jpush_webview_layout.xml");
                }
                intent.setClass(context, PushActivity.class);
                if (dVar != null) {
                    dVar.W = str;
                    intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
                    intent.putExtra("msg_data", dVar.c());
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    intent.addFlags(536870912);
                }
            }
            context.startActivity(intent);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHelper", "first open url failed, use browser open again. " + th.getMessage());
            try {
                try {
                    if (!cn.jpush.android.bm.a.d(context, "com.android.browser")) {
                        cn.jpush.android.r.b.c("InAppHelper", "not found com.android.browser,user will choose other browser");
                        throw new Throwable("not found com.android.browser,user will choose other browser");
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    intent2.setFlags(268435456);
                    intent2.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    a(context, intent2);
                    context.startActivity(intent2);
                } catch (Throwable unused) {
                    Intent a2 = cn.jpush.android.bm.a.a(str, 0);
                    a2.setFlags(268435456);
                    a(context, a2);
                    context.startActivity(a2);
                }
            } catch (Throwable th2) {
                cn.jpush.android.r.b.b("InAppHelper", "[openWebUri] start fail uri error:" + th2.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, cn.jpush.android.aw.e eVar) {
        String m;
        String m2;
        String m3;
        String m4;
        if (context == null || eVar == null) {
            cn.jpush.android.r.b.f("InAppHelper", "deep link open with unexpected error, context: " + context + ", message: " + eVar);
            if (eVar != null) {
                a(context, "deepLinkOpen", eVar.m());
            }
            return false;
        }
        if (TextUtils.isEmpty(eVar.f9428c) && !eVar.t) {
            cn.jpush.android.r.b.f("InAppHelper", "is not deep link in-app message");
            cn.jpush.android.l.c.a(context, eVar.m(), 1293, 0);
            return false;
        }
        try {
            if (eVar.l() == 2) {
                cn.jpush.android.r.b.b("InAppHelper", "open wechat mini program");
                d(context, eVar);
            } else {
                cn.jpush.android.r.b.b("InAppHelper", "in-app open deeplink, targetPkg:" + eVar.f9431f + ", forNewUser: " + eVar.f9433h);
                if (!TextUtils.isEmpty(eVar.f9431f)) {
                    if (cn.jpush.android.bm.a.a(context, eVar.f9431f, !eVar.f9433h ? eVar.f9428c : "")) {
                        cn.jpush.android.v.c.a().a(context, eVar.f9431f, true);
                        cn.jpush.android.r.b.b("InAppHelper", "p installed, targetPkgName: " + eVar.f9431f);
                        if (eVar.f9433h) {
                            cn.jpush.android.r.b.f("InAppHelper", "link for new user, p installed not download");
                            cn.jpush.android.l.c.a(context, eVar.m(), 1248, 0);
                        } else if (b(context, eVar)) {
                            m4 = eVar.m();
                            cn.jpush.android.l.c.a(context, m4, 1214, 0);
                        } else {
                            m3 = eVar.m();
                            cn.jpush.android.l.c.a(context, m3, 1215, 0);
                        }
                    } else {
                        cn.jpush.android.v.c.a().a(context, eVar.f9431f, false);
                        if (!eVar.f9433h) {
                            cn.jpush.android.l.c.a(context, eVar.m(), 1216, 0);
                            cn.jpush.android.r.b.b("InAppHelper", "app not installed,fail_handle_type:" + eVar.f9429d + ",fail_handle_url:" + eVar.f9430e);
                            if (eVar.f9429d != 1) {
                                cn.jpush.android.l.c.a(context, eVar.m(), 1301, 0);
                            } else if (TextUtils.isEmpty(eVar.f9430e)) {
                                cn.jpush.android.r.b.f("InAppHelper", "fail_handle_url is empty");
                            } else {
                                eVar.f9428c = eVar.f9430e;
                                if (b(context, eVar)) {
                                    cn.jpush.android.l.c.a(context, eVar.m(), 1217, 0);
                                } else {
                                    cn.jpush.android.l.c.a(context, eVar.m(), 1218, 0);
                                }
                            }
                        } else if (e(context, eVar)) {
                            m2 = eVar.m();
                            cn.jpush.android.l.c.a(context, m2, 1300, 0);
                        } else {
                            m = eVar.m();
                            cn.jpush.android.l.c.a(context, m, 1299, 0);
                        }
                    }
                } else if (eVar.f9433h) {
                    if (e(context, eVar)) {
                        m2 = eVar.m();
                        cn.jpush.android.l.c.a(context, m2, 1300, 0);
                    } else {
                        m = eVar.m();
                        cn.jpush.android.l.c.a(context, m, 1299, 0);
                    }
                } else if (b(context, eVar)) {
                    m4 = eVar.m();
                    cn.jpush.android.l.c.a(context, m4, 1214, 0);
                } else {
                    m3 = eVar.m();
                    cn.jpush.android.l.c.a(context, m3, 1215, 0);
                }
            }
            return true;
        } catch (Throwable th) {
            cn.jpush.android.l.c.a(context, eVar.m(), 1294, 0);
            cn.jpush.android.r.b.f("InAppHelper", "url failed:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str.trim())) {
            cn.jpush.android.r.b.b("InAppHelper", "[checkInSrvPageList] server not set the page to show ad");
            return true;
        }
        String a2 = a();
        cn.jpush.android.r.b.b("InAppHelper", "checkInSrvPageList, currentPage: " + a2 + ", srvPages: " + str);
        return TextUtils.equals(str, a2);
    }

    public static int b(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static String b() {
        Iterator<String> it = f9296c.values().iterator();
        String next = it.hasNext() ? it.next() : "";
        if (!TextUtils.isEmpty(next)) {
            return next;
        }
        Iterator<String> it2 = f9296c.keySet().iterator();
        return it2.hasNext() ? it2.next() : next;
    }

    public static void b(Context context) {
        if (context == null) {
            cn.jpush.android.r.b.g("InAppHelper", "context is null");
            return;
        }
        if (!cn.jpush.android.bm.a.a(context, (Class<?>) JNotifyActivity.class)) {
            cn.jpush.android.r.b.i("InAppHelper", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName());
            return;
        }
        if (!cn.jpush.android.bm.a.c(context)) {
            cn.jpush.android.r.b.c("InAppHelper", "no draw overlay permission");
        }
        boolean j = cn.jpush.android.bm.a.j(context);
        cn.jpush.android.o.b.f9826c = j;
        cn.jpush.android.o.b.a(context, j);
        if ((j ? cn.jpush.android.ao.a.a(context) : -1) == 0) {
            cn.jpush.android.r.b.c("InAppHelper", "can install apk by system");
        } else {
            cn.jpush.android.r.b.g("InAppHelper", "not allowed install apk by system");
        }
        if (!e(context)) {
            cn.jpush.android.r.b.g("InAppHelper", "please check layout file jpush_webview_layout.xml, no this file can not open h5 in app");
        }
        cn.jpush.android.r.b.c("InAppHelper", "junion ad is integrated succeed~");
    }

    public static void b(Context context, cn.jpush.android.d.d dVar) {
        cn.jpush.android.r.b.b("InAppHelper", "google play not allowed");
    }

    public static boolean b(Context context, cn.jpush.android.aw.e eVar) {
        if (context == null || eVar == null) {
            return false;
        }
        try {
            return (TextUtils.isEmpty(eVar.f9428c) || !eVar.f9428c.startsWith("http")) ? cn.jpush.android.ax.a.a(context, eVar.f9428c, eVar.f9431f) : a(context, eVar.f9432g, eVar.f9428c, eVar.t());
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHelper", "open deeplink failed, error: " + th.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (context == null) {
            cn.jpush.android.r.b.f("InAppHelper", "[checkInBlackList] context is null");
            return true;
        }
        if (!cn.jpush.android.at.b.b(context)) {
            cn.jpush.android.r.b.b("InAppHelper", "[checkInBlackList] request black list not completed");
            return true;
        }
        List<String> d2 = cn.jpush.android.at.b.d(context);
        if (d2 == null || d2.isEmpty()) {
            cn.jpush.android.r.b.b("InAppHelper", "no blacklist and check whitelist");
            return !d(context, str);
        }
        boolean contains = d2.contains(str);
        cn.jpush.android.r.b.b("InAppHelper", "[checkInBlackList] isBlack: " + contains + ", curPageName: " + str);
        return contains;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0087 A[Catch: all -> 0x0102, TryCatch #0 {all -> 0x0102, blocks: (B:3:0x000b, B:26:0x007c, B:28:0x0087, B:29:0x0088, B:31:0x00ae, B:32:0x00b3, B:33:0x00cc, B:35:0x00d2, B:37:0x00e0), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae A[Catch: all -> 0x0102, TryCatch #0 {all -> 0x0102, blocks: (B:3:0x000b, B:26:0x007c, B:28:0x0087, B:29:0x0088, B:31:0x00ae, B:32:0x00b3, B:33:0x00cc, B:35:0x00d2, B:37:0x00e0), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2 A[Catch: all -> 0x0102, LOOP:1: B:33:0x00cc->B:35:0x00d2, LOOP_END, TryCatch #0 {all -> 0x0102, blocks: (B:3:0x000b, B:26:0x007c, B:28:0x0087, B:29:0x0088, B:31:0x00ae, B:32:0x00b3, B:33:0x00cc, B:35:0x00d2, B:37:0x00e0), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.d.c(android.content.Context, java.lang.String):void");
    }

    public static boolean c(Context context) {
        Activity p;
        String canonicalName;
        StringBuilder sb;
        String str;
        if (!f9296c.isEmpty()) {
            canonicalName = b();
            sb = new StringBuilder();
            str = "[checkInBlackList] curPageName: ";
        } else {
            if (!f(context) || (p = cn.jpush.android.bm.a.p(context)) == null) {
                return false;
            }
            canonicalName = p.getClass().getCanonicalName();
            sb = new StringBuilder();
            str = "[checkInBlackList] getCurrentActivity->curPageName: ";
        }
        sb.append(str);
        sb.append(canonicalName);
        cn.jpush.android.r.b.b("InAppHelper", sb.toString());
        return b(context, canonicalName);
    }

    public static boolean c(Context context, cn.jpush.android.aw.e eVar) {
        cn.jpush.android.r.b.b("InAppHelper", "google play not allowed");
        return false;
    }

    public static void d(Context context, cn.jpush.android.aw.e eVar) {
        int i2;
        eVar.f9431f = ShareSystemFileUtils.PACKAGE_WECHAT;
        String m = eVar.m();
        if (cn.jpush.android.bm.a.a(context, eVar.f9431f, "weixin://")) {
            i2 = !cn.jpush.android.ax.a.a(context, eVar.p, eVar.q, eVar.s, eVar.r) ? 1213 : 1212;
        } else {
            cn.jpush.android.r.b.b("InAppHelper", "wechat apk not install");
            i2 = 1221;
        }
        cn.jpush.android.l.c.a(context, m, i2, 0);
    }

    public static boolean d(Context context) {
        Activity p;
        String canonicalName;
        StringBuilder sb;
        String str;
        if (!f9296c.isEmpty()) {
            canonicalName = b();
            sb = new StringBuilder();
            str = "[checkInWhiteList] curPageName: ";
        } else {
            if (!f(context) || (p = cn.jpush.android.bm.a.p(context)) == null) {
                return true;
            }
            canonicalName = p.getClass().getCanonicalName();
            sb = new StringBuilder();
            str = "[checkInWhiteList] getCurrentActivity->curPageName: ";
        }
        sb.append(str);
        sb.append(canonicalName);
        cn.jpush.android.r.b.b("InAppHelper", sb.toString());
        return d(context, canonicalName);
    }

    public static boolean d(Context context, String str) {
        if (context == null) {
            cn.jpush.android.r.b.f("InAppHelper", "[checkInWhiteList] context is null");
            return false;
        }
        if (!cn.jpush.android.at.b.b(context)) {
            cn.jpush.android.r.b.b("InAppHelper", "[checkInWhiteList] request black list not completed");
            return false;
        }
        List<String> c2 = cn.jpush.android.at.b.c(context);
        if (c2 == null || c2.isEmpty()) {
            cn.jpush.android.r.b.b("InAppHelper", "not set white list");
            return true;
        }
        boolean contains = c2.contains(str);
        StringBuilder sb = new StringBuilder();
        sb.append("[checkInWhiteList] isBlack: ");
        sb.append(!contains);
        sb.append(", curPageName: ");
        sb.append(str);
        cn.jpush.android.r.b.b("InAppHelper", sb.toString());
        return contains;
    }

    public static boolean e(Context context) {
        if (context != null) {
            return b(context, "jpush_webview_layout", "layout") > 0 && b(context, "actionbarLayoutId", "id") > 0 && b(context, "rlRichpushTitleBar", "id") > 0 && b(context, "tvRichpushTitle", "id") > 0 && b(context, "imgRichpushBtnBack", "id") > 0 && b(context, "pushPrograssBar", "id") > 0;
        }
        cn.jpush.android.r.b.f("InAppHelper", "context is null");
        return false;
    }

    public static boolean e(Context context, cn.jpush.android.aw.e eVar) {
        cn.jpush.android.r.b.b("InAppHelper", "google play not allowed");
        return false;
    }

    public static boolean f(Context context) {
        return context.getPackageName().equals(cn.jpush.android.bm.a.d(context));
    }
}
