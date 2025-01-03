package cn.jiguang.au;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.l.c;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.shix.shixipc.system.ContentCommon;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static a f8372a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile FutureTask<?> f8373b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8374c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet<String> f8375d = new LinkedHashSet<>();

    /* renamed from: e, reason: collision with root package name */
    public static final String f8376e;

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedHashSet<String> f8377f;

    public static class a extends cn.jiguang.bj.b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f8378a;

        public a(Context context) {
            this.f8378a = context;
            this.f8813h = "SisTask";
        }

        @Override // cn.jiguang.bj.b
        public void a() {
            try {
                String c2 = e.c(this.f8378a);
                LinkedHashSet d2 = e.d(this.f8378a);
                d2.addAll(e.a());
                cn.jiguang.as.d.c("ReportSis", "sis urls=" + d2.toString() + " post json=" + c2);
                if (!cn.jiguang.e.a.d(this.f8378a)) {
                    cn.jiguang.as.d.g("ReportSis", "give up sis, because network is not connected");
                    return;
                }
                Iterator it = d2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!TextUtils.isEmpty(str)) {
                        if (Build.VERSION.SDK_INT >= 28 && !str.startsWith(c.a.f8949d)) {
                            cn.jiguang.as.d.g("ReportSis", "won't use http at device since 28");
                        } else if (e.b(this.f8378a, str, c2)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        String b2 = cn.jiguang.p.a.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 68, 83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 114, 94});
        f8376e = b2;
        f8375d.add(b2);
        f8377f = new LinkedHashSet<>();
    }

    public static LinkedHashSet<String> a() {
        return (!JConstants.isTestEnv() || f8377f.isEmpty()) ? f8375d : f8377f;
    }

    public static void a(Context context, boolean z) {
        StringBuilder sb;
        if (f8372a == null) {
            f8372a = new a(context);
        }
        if (f8373b == null || f8373b.isCancelled() || f8373b.isDone()) {
            synchronized (f8374c) {
                if (f8373b == null || f8373b.isCancelled() || f8373b.isDone()) {
                    try {
                        f8373b = new FutureTask<>(f8372a, null);
                        cn.jiguang.bj.d.a("FUTURE_TASK", f8373b);
                    } catch (Throwable th) {
                        cn.jiguang.as.d.g("ReportSis", "new sis task e:" + th);
                    }
                }
            }
        }
        if (z) {
            try {
                f8373b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.as.d.g("ReportSis", sb.toString());
            } catch (ExecutionException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.as.d.g("ReportSis", sb.toString());
            } catch (TimeoutException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.as.d.g("ReportSis", sb.toString());
            } catch (Throwable th2) {
                e = th2;
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.as.d.g("ReportSis", sb.toString());
            }
        }
    }

    public static boolean b(Context context, String str, String str2) {
        g a2 = b.a(str, str2, context, true, 3, 2);
        cn.jiguang.as.d.c("ReportSis", "report sis code[" + a2.a() + "] from url=" + str + "\n body=" + a2.b());
        if (a2.a() != 0) {
            return false;
        }
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        try {
            cn.jiguang.au.a.a().a(context, new JSONObject(b2).getJSONObject("ret"));
            return true;
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReportSis", "getUrls e:" + th);
            return false;
        }
    }

    public static String c(Context context) {
        long j;
        Object a2;
        double d2;
        double d3;
        JSONObject jSONObject = new JSONObject();
        try {
            String e2 = cn.jiguang.d.a.e(context);
            long longValue = ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue();
            int a3 = cn.jiguang.e.g.a(context);
            String b2 = cn.jiguang.e.g.b(context);
            jSONObject.put(ContentCommon.TYPE, a3);
            jSONObject.put("appkey", e2);
            jSONObject.put("sdkver", cn.jiguang.a.a.f8098b);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            j = 0;
            if (longValue != 0) {
                jSONObject.put("uid", longValue);
            }
            if (b2 != null) {
                jSONObject.put("opera", b2);
            }
            a2 = cn.jiguang.az.e.a(context, "get_loc_info", null);
            d2 = 200.0d;
        } catch (Throwable unused) {
        }
        if (a2 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a2;
                double d4 = bundle.getDouble("lat");
                try {
                    d2 = bundle.getDouble("lot");
                    j = bundle.getLong("time");
                } catch (Throwable unused2) {
                }
                double d5 = d2;
                d2 = d4;
                d3 = d5;
            } catch (Throwable unused3) {
            }
            if (d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d) {
                jSONObject.put("lat", d2);
                jSONObject.put("lng", d3);
                jSONObject.put("time", j);
            }
            return jSONObject.toString();
        }
        d3 = 200.0d;
        if (d2 > -90.0d) {
            jSONObject.put("lat", d2);
            jSONObject.put("lng", d3);
            jSONObject.put("time", j);
        }
        return jSONObject.toString();
    }

    public static LinkedHashSet<String> d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.v());
        if (TextUtils.isEmpty(str)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                linkedHashSet.add(jSONArray.optString(i2));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }
}
