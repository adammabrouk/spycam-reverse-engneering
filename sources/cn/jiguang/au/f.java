package cn.jiguang.au;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.az.i;
import cn.jiguang.e.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.l.c;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.system.ContentCommon;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static final String f8383e = cn.jiguang.p.a.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, 58, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    /* renamed from: f, reason: collision with root package name */
    public static String f8384f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f8385g = "/v3/report";

    /* renamed from: a, reason: collision with root package name */
    public static JSONObject f8379a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8380b = true;

    /* renamed from: h, reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f8386h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public static Handler f8387i = new Handler(b());

    /* renamed from: c, reason: collision with root package name */
    public static String f8381c = "";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f8382d = true;

    public static class a extends cn.jiguang.bj.b {

        /* renamed from: a, reason: collision with root package name */
        public Context f8390a;

        /* renamed from: b, reason: collision with root package name */
        public String f8391b;

        /* renamed from: c, reason: collision with root package name */
        public String f8392c;

        /* renamed from: d, reason: collision with root package name */
        public JSONObject f8393d;

        /* renamed from: e, reason: collision with root package name */
        public File f8394e;

        /* renamed from: f, reason: collision with root package name */
        public long f8395f = SystemClock.elapsedRealtime();

        public a(Context context, String str, String str2, JSONObject jSONObject) {
            this.f8390a = context;
            this.f8391b = str;
            this.f8392c = str2;
            this.f8393d = jSONObject;
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            cn.jiguang.as.d.c("ReportUtils", "task id is : " + this.f8391b + " running save file");
            File a2 = d.a(this.f8390a, this.f8392c, this.f8393d, true);
            this.f8394e = a2;
            if (a2 != null) {
                a aVar = (a) f.f8386h.get(this.f8391b);
                if (aVar != null) {
                    aVar.f8394e = this.f8394e;
                    f.f8386h.replace(this.f8391b, aVar);
                }
                cn.jiguang.as.d.c("ReportUtils", "task id is : " + this.f8391b + ", save file : " + this.f8392c + ", file is : " + this.f8394e.getAbsolutePath());
            }
        }
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        return a(context, set, jSONObject, file, reportCallBack, "");
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack, String str) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!cn.jiguang.e.a.d(context)) {
                        cn.jiguang.as.d.g("ReportUtils", "no network, give up upload");
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    Pair<byte[], Integer> a2 = a(jSONObject.toString(), true, 2);
                    if (a2 != null && a2.first != null && ((byte[]) a2.first).length != 0) {
                        byte[] bArr = (byte[]) a2.first;
                        int intValue = ((Integer) a2.second).intValue();
                        cn.jiguang.as.d.c("ReportUtils", "will upload length=" + bArr.length);
                        if (a(set, bArr.length)) {
                            i.a().a(context, i.a().a(context, jSONObject, bArr, intValue, file, set, reportCallBack, str));
                            return 1;
                        }
                        int a3 = a(context, bArr, intValue, set);
                        if (a3 == 0) {
                            cn.jiguang.as.d.c("ReportUtils", "http upload success json=" + cn.jiguang.e.d.a(jSONObject));
                            if (TextUtils.isEmpty(str)) {
                                cn.jiguang.e.c.a(file);
                            } else {
                                c(str);
                            }
                        }
                        if (a3 != 1) {
                            if (TextUtils.isEmpty(str)) {
                                d.a(file);
                            }
                            if (reportCallBack != null) {
                                reportCallBack.onFinish(a3);
                            }
                        }
                        return a3;
                    }
                    cn.jiguang.as.d.g("ReportUtils", "package body failed, give up upload");
                    if (TextUtils.isEmpty(str)) {
                        d.a(file);
                    }
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                }
            } catch (Throwable th) {
                try {
                    cn.jiguang.as.d.g("ReportUtils", "upload failed, error:" + th);
                    if (TextUtils.isEmpty(str)) {
                        d.a(file);
                    }
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                } catch (Throwable th2) {
                    if (0 != 1) {
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(0);
                        }
                    }
                    throw th2;
                }
            }
        }
        cn.jiguang.as.d.g("ReportUtils", "upload content is empty, do nothing");
        if (TextUtils.isEmpty(str)) {
            d.a(file);
        }
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    public static int a(Context context, byte[] bArr, int i2, Set<String> set) {
        String str;
        LinkedHashSet<String> a2 = a(context, set);
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.as.d.g("ReportUtils", "can't get url, give up upload");
            return -2;
        }
        String str2 = " type=" + set;
        for (String str3 : a2) {
            if (TextUtils.isEmpty(str3)) {
                cn.jiguang.as.d.g("ReportUtils", "can't get url, give up upload");
            } else if (Build.VERSION.SDK_INT < 28 || str3.startsWith(c.a.f8949d)) {
                if (!str3.endsWith(f8385g)) {
                    str3 = str3 + f8385g;
                }
                String str4 = str3;
                cn.jiguang.as.d.c("ReportUtils", "upload" + str2 + " to url:" + str4);
                g a3 = b.a(context, str4, bArr, i2, 3, 1);
                int a4 = a3.a();
                if (a4 == -3) {
                    d.a(context, cn.jiguang.d.a.e(context));
                    return -2;
                }
                if (a4 == -1) {
                    str = "upload" + str2 + " error:" + a3.b();
                } else {
                    if (a4 == 0) {
                        return 0;
                    }
                    str = "upload" + str2 + " failed";
                }
                cn.jiguang.as.d.c("ReportUtils", str);
            } else {
                cn.jiguang.as.d.g("ReportUtils", "won't use http at device since 28");
            }
        }
        return -1;
    }

    public static Pair<byte[], Integer> a(String str, boolean z, int i2) {
        String str2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z) {
                try {
                    bytes = h.a(bytes);
                } catch (IOException unused) {
                    return null;
                }
            }
            int a2 = cn.jiguang.bk.e.a();
            String a3 = cn.jiguang.bk.e.a(a2);
            if (i2 == 1) {
                str2 = "0102030405060708";
            } else {
                if (i2 != 2) {
                    return null;
                }
                str2 = "iop203040506aPk!";
            }
            return new Pair<>(cn.jiguang.bk.e.a(bytes, a3, str2, true), Integer.valueOf(a2));
        } catch (UnsupportedEncodingException | Exception unused2) {
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        String e2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
        if (longValue == 0) {
            cn.jiguang.as.d.c("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        if (z) {
            e2 = f8383e;
        } else {
            String str3 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.f());
            if (TextUtils.isEmpty(str3)) {
                str3 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.g());
            }
            e2 = cn.jiguang.e.f.e(str3);
        }
        String k = cn.jiguang.e.f.k(longValue + e2 + str);
        if (cn.jiguang.e.f.a(k)) {
            return null;
        }
        try {
            return Base64.encodeToString((longValue + ":" + k + ":" + str2).getBytes(), 10);
        } catch (Exception unused) {
            cn.jiguang.as.d.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String a(String str) {
        try {
            return cn.jiguang.bk.e.b(str, cn.jiguang.bk.b.a(), cn.jiguang.bk.b.f8822a);
        } catch (Throwable unused) {
            cn.jiguang.as.d.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static ArrayList<JSONArray> a(JSONArray jSONArray, int i2, int i3) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i4 = 0;
            int i5 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                try {
                    int b2 = cn.jiguang.e.d.b(optJSONObject);
                    if (b2 != 0) {
                        int i6 = i4 + b2;
                        if (i6 > i3) {
                            break;
                        }
                        int i7 = i5 + b2;
                        if (i7 > i2) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(optJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.as.d.g("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(optJSONObject);
                            b2 = i7;
                        }
                        i5 = b2;
                        i4 = i6;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    public static LinkedHashSet<String> a(Context context, Set<String> set) {
        StringBuilder sb;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String c2 = c();
        if (!"stats.jpush.cn".equals(c2)) {
            linkedHashSet.add(c2);
            return linkedHashSet;
        }
        Set<String> b2 = cn.jiguang.au.a.a().b(context).b(set);
        if (b2 != null) {
            for (String str : b2) {
                if (!TextUtils.isEmpty(str)) {
                    linkedHashSet.add(str);
                }
            }
        }
        String str2 = c.a.f8949d;
        if (!TextUtils.isEmpty(c2)) {
            linkedHashSet.add(str2 + c2);
        }
        String str3 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.a(true));
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                if (!cn.jiguang.e.f.f(str4)) {
                    if (!cn.jiguang.e.f.g(str4)) {
                        sb = new StringBuilder();
                    } else if (!f8382d) {
                        sb = new StringBuilder();
                    }
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                } else if (f8382d) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                }
            }
        }
        cn.jiguang.as.d.c("ReportUtils", "types=" + set + " find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : c(jSONObject.optJSONArray("content"));
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, c.a.a.j.a.o);
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
            if (longValue == 0) {
                cn.jiguang.as.d.g("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put("uid", longValue);
            String e2 = cn.jiguang.d.a.e(context);
            if (cn.jiguang.e.f.a(e2)) {
                cn.jiguang.as.d.i("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put("app_key", e2);
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f8098b);
            String g2 = cn.jiguang.d.a.g(context);
            if (cn.jiguang.e.f.a(g2)) {
                cn.jiguang.as.d.h("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", g2);
            }
            Pair<String, Long> c2 = cn.jiguang.c.b.c(context);
            if (c2 == null || cn.jiguang.e.f.a((String) c2.first)) {
                cn.jiguang.as.d.h("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", c2.first);
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    public static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        cn.jiguang.e.d.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r2, int r3, org.json.JSONObject r4, byte[] r5, int r6, java.io.File r7, java.util.Set<java.lang.String> r8, cn.jiguang.api.ReportCallBack r9, java.lang.String r10) {
        /*
            java.lang.String r4 = "ReportUtils"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r0.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = "onTcpReportResult, types="
            r0.append(r1)     // Catch: java.lang.Throwable -> L5b
            r0.append(r8)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = " code="
            r0.append(r1)     // Catch: java.lang.Throwable -> L5b
            r0.append(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5b
            cn.jiguang.as.d.c(r4, r0)     // Catch: java.lang.Throwable -> L5b
            r4 = -3
            if (r3 == r4) goto L42
            if (r3 == 0) goto L39
            int r3 = a(r2, r5, r6, r8)     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L4f
            boolean r2 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L35
        L31:
            cn.jiguang.e.c.a(r7)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L35:
            c(r10)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L39:
            boolean r2 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L35
            goto L31
        L42:
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5b
            r5 = 0
            java.lang.String r6 = cn.jiguang.d.a.e(r2)     // Catch: java.lang.Throwable -> L5b
            r4[r5] = r6     // Catch: java.lang.Throwable -> L5b
            cn.jiguang.au.d.a(r2, r4)     // Catch: java.lang.Throwable -> L5b
        L4f:
            if (r9 == 0) goto L54
            r9.onFinish(r3)
        L54:
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L6a
            goto L67
        L5b:
            if (r9 == 0) goto L61
            r9.onFinish(r3)
        L61:
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L6a
        L67:
            cn.jiguang.au.d.a(r7)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.au.f.a(android.content.Context, int, org.json.JSONObject, byte[], int, java.io.File, java.util.Set, cn.jiguang.api.ReportCallBack, java.lang.String):void");
    }

    public static void a(final Context context, final Object obj) {
        try {
            if (b(obj)) {
                cn.jiguang.bj.d.a("UPLOAD_REPORT", new cn.jiguang.bj.b("ReportUtils#report") { // from class: cn.jiguang.au.f.1
                    @Override // cn.jiguang.bj.b
                    public void a() {
                        cn.jiguang.as.d.c("ReportUtils", "push queue report");
                        try {
                            JSONArray c2 = f.c(obj);
                            if (c2 != null) {
                                Set c3 = f.c(c2);
                                if (f.b((Set<String>) c3)) {
                                    f.c(context, c2, c3);
                                } else {
                                    f.d(context, c2, c3);
                                }
                            } else {
                                cn.jiguang.as.d.c("ReportUtils", JThirdPlatFormInterface.KEY_DATA + obj + " is empty");
                            }
                        } catch (Throwable unused) {
                        }
                        cn.jiguang.as.d.c("ReportUtils", "pop queue report");
                    }
                });
            } else {
                cn.jiguang.as.d.c("ReportUtils", "data is invalid or empty");
            }
            d.b(context);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReportUtils", "report e:" + th);
        }
    }

    public static void a(Context context, String str, Object obj) {
        try {
            cn.jiguang.as.d.c("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(ActionManager.SDK_TYPE, str);
            }
            if (b(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            cn.jiguang.a.a.a(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                cn.jiguang.as.d.d("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                cn.jiguang.as.d.d("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        b(context, jSONObject, reportCallBack);
    }

    public static void a(String str, JSONObject jSONObject, String str2) {
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            return;
        }
        try {
            a aVar = new a(appContext, str2, str, jSONObject);
            f8387i.postDelayed(aVar, 500L);
            f8386h.put(aVar.f8391b, aVar);
            cn.jiguang.as.d.c("ReportUtils", "start timer lastTime is : " + aVar.f8395f + ", task id is : " + aVar.f8391b);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        try {
            if (cn.jiguang.e.f.a(str)) {
                cn.jiguang.as.d.c("ReportUtils", "file_name is null , give up save ");
                return false;
            }
            if (context != null) {
                return cn.jiguang.e.c.c(cn.jiguang.e.c.a(context, str), jSONObject != null ? jSONObject.toString() : "");
            }
            cn.jiguang.as.d.c("ReportUtils", "context is null , give up save " + str);
            return false;
        } catch (Throwable th) {
            cn.jiguang.as.d.c("ReportUtils", "writeLogFile e:" + th);
            return false;
        }
    }

    public static boolean a(Set<String> set, int i2) {
        return (!f8380b || i2 >= 30680 || set == null || set.contains("crash_log") || set.contains("operate_event")) ? false : true;
    }

    public static Looper b() {
        HandlerThread handlerThread = new HandlerThread("jg_timer") { // from class: cn.jiguang.au.f.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static String b(String str) {
        try {
            return cn.jiguang.bk.e.b(str, cn.jiguang.bk.b.b(), cn.jiguang.bk.b.f8823b);
        } catch (Throwable unused) {
            cn.jiguang.as.d.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString(ContentCommon.TYPE);
        }
        return null;
    }

    public static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    public static void b(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject a2 = a(context);
                    if (a2 == null) {
                        cn.jiguang.as.d.i("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                    } else {
                        String b2 = b(jSONObject);
                        JSONObject a3 = a(new JSONArray().put(jSONObject), a2);
                        HashSet hashSet = new HashSet();
                        hashSet.add(b2);
                        cn.jiguang.as.d.c("ReportUtils", "reportWithoutStore type=" + b2);
                        a(context, hashSet, a3, null, reportCallBack);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.i("ReportUtils", "reportWithoutStore exception:" + th);
            }
        }
        d.b(context);
    }

    public static boolean b(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && b((JSONArray) obj).length() > 0;
    }

    public static boolean b(Set<String> set) {
        if (set == null) {
            return false;
        }
        return set.contains(PushSA.REPORT_ACTIVE_LAUNCH) || set.contains(PushSA.REPORT_ACTIVE_TERMINATE) || set.contains(ActionManager.SDK_TYPE) || set.contains("android_notification_state") || set.contains("operate_event");
    }

    public static String c() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(f8381c)) ? "stats.jpush.cn" : f8381c;
    }

    public static Set<String> c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String b2 = b(jSONArray.optJSONObject(i2));
                if (b2 == null) {
                    b2 = "";
                }
                hashSet.add(b2);
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0001, B:8:0x0037, B:10:0x003d, B:5:0x0020, B:7:0x0024, B:16:0x002e, B:18:0x0032), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray c(java.lang.Object r3) {
        /*
            r0 = 0
            boolean r1 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L20
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Le
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Le
            goto L37
        Le:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L36
            r1.<init>()     // Catch: java.lang.Throwable -> L36
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L36
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36
            org.json.JSONArray r3 = r1.put(r2)     // Catch: java.lang.Throwable -> L36
            r1 = r3
            goto L37
        L20:
            boolean r1 = r3 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L2e
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L44
            org.json.JSONArray r1 = r1.put(r3)     // Catch: java.lang.Throwable -> L44
            goto L37
        L2e:
            boolean r1 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L36
            r1 = r3
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch: java.lang.Throwable -> L44
            goto L37
        L36:
            r1 = r0
        L37:
            org.json.JSONArray r3 = b(r1)     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L5b
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L44
            if (r1 <= 0) goto L5b
            return r3
        L44:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adapt JSONArray e:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReportUtils"
            cn.jiguang.as.d.g(r1, r3)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.au.f.c(java.lang.Object):org.json.JSONArray");
    }

    public static void c(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a2 = cn.jiguang.au.a.a().a(context).a(set);
            JSONObject a3 = a(context);
            boolean z = a3 != null;
            StringBuilder sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(a2);
            sb.append(File.separator);
            sb.append(z ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                try {
                    JSONObject a4 = a(it.next(), a3);
                    File a5 = d.a(context, sb2, a4, z);
                    cn.jiguang.as.d.c("ReportUtils", "save report types=" + set + " at " + sb2 + File.separator + a5.getName());
                    if (z) {
                        a(context, set, a4, a5, null);
                    }
                } catch (Throwable th) {
                    cn.jiguang.as.d.c("ReportUtils", "buildReport [for item]", th);
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.as.d.i("ReportUtils", "report exception:" + th2);
        }
    }

    public static void c(String str) {
        a aVar;
        cn.jiguang.as.d.c("ReportUtils", "cancelTimer, task id is : " + str);
        if (TextUtils.isEmpty(str) || (aVar = f8386h.get(str)) == null) {
            return;
        }
        if (SystemClock.elapsedRealtime() - aVar.f8395f > 500) {
            File file = aVar.f8394e;
            if (file != null) {
                cn.jiguang.e.c.a(file);
            }
            d.a(aVar.f8394e);
        } else if (aVar != null) {
            f8387i.removeCallbacks(aVar);
        }
        f8386h.remove(aVar.f8391b);
    }

    public static void d(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a2 = cn.jiguang.au.a.a().a(context).a(set);
            JSONObject a3 = a(context);
            boolean z = a3 != null;
            StringBuilder sb = new StringBuilder();
            sb.append(File.separator);
            sb.append(a2);
            sb.append(File.separator);
            sb.append(z ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                try {
                    JSONObject a4 = a(it.next(), a3);
                    if (z) {
                        String uuid = UUID.randomUUID().toString();
                        a(sb2, a4, uuid);
                        a(context, set, a4, null, null, uuid);
                    } else {
                        cn.jiguang.as.d.c("ReportUtils", "save report types=" + set + " at " + sb2 + File.separator + d.a(context, sb2, a4, false).getName());
                    }
                } catch (Throwable th) {
                    cn.jiguang.as.d.c("ReportUtils", "buildReport [for item]", th);
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.as.d.i("ReportUtils", "report exception:" + th2);
        }
    }
}
