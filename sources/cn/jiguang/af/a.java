package cn.jiguang.af;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.hjq.permissions.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.l.a {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a f8134b;

    /* renamed from: a, reason: collision with root package name */
    public Context f8135a;

    /* renamed from: cn.jiguang.af.a$a, reason: collision with other inner class name */
    public class CallableC0133a implements Callable<cn.jiguang.ag.a> {
        public CallableC0133a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public cn.jiguang.ag.a call() {
            try {
                cn.jiguang.af.b bVar = new cn.jiguang.af.b(a.this.f8135a);
                bVar.b();
                for (int i2 = 0; i2 < 20; i2++) {
                    cn.jiguang.ag.a a2 = bVar.a();
                    if (a2 != null) {
                        return a2;
                    }
                    Thread.sleep(2000L);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JLocation", "JLocationCellInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    public class b implements Callable<cn.jiguang.ag.b> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public cn.jiguang.ag.b call() {
            try {
                c a2 = c.a(a.this.f8135a);
                a2.c();
                for (int i2 = 0; i2 < 30; i2++) {
                    if (a2.b()) {
                        return a2.a();
                    }
                    Thread.sleep(1000L);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JLocation", "JLocationGpsInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    private Bundle a(long j, double d2, double d3) {
        Bundle bundle = new Bundle();
        bundle.putLong("time", j);
        bundle.putDouble("lot", d2);
        bundle.putDouble("lat", d3);
        return bundle;
    }

    public static a a() {
        if (f8134b == null) {
            synchronized (a.class) {
                if (f8134b == null) {
                    f8134b = new a();
                }
            }
        }
        return f8134b;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a(java.util.List<cn.jiguang.ag.c> r19, cn.jiguang.ag.a r20, cn.jiguang.ag.b r21) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.a.a(java.util.List, cn.jiguang.ag.a, cn.jiguang.ag.b):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONArray jSONArray;
        cn.jiguang.ai.a.a("JLocation", "currentJson:" + jSONObject + ",cacheJson:" + jSONObject2);
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException e2) {
                e = e2;
            }
            try {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject);
                jSONObject3.put("content", jSONArray2);
                return jSONObject3;
            } catch (JSONException e3) {
                e = e3;
                jSONObject2 = jSONObject3;
                cn.jiguang.ai.a.d("JLocation", "mergeJson exception:" + e.getMessage());
                return jSONObject2;
            }
        }
        try {
            jSONArray = jSONObject2.getJSONArray("content");
        } catch (JSONException unused) {
            jSONArray = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (cn.jiguang.h.a.a().d(1505)) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("wifi");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("wifi");
                if (optJSONArray != null && optJSONArray.equals(optJSONArray2)) {
                    jSONObject.remove("wifi");
                }
            }
            if (cn.jiguang.h.a.a().d(1501)) {
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("cell");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("cell");
                if (optJSONArray3 != null && optJSONArray3.equals(optJSONArray4)) {
                    jSONObject.remove("cell");
                }
            }
            if (cn.jiguang.h.a.a().d(1502)) {
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("gps");
                JSONArray optJSONArray6 = jSONObject.optJSONArray("gps");
                if (optJSONArray5 != null && optJSONArray5.equals(optJSONArray6)) {
                    jSONObject.remove("gps");
                }
            }
        }
        if (jSONObject.length() != 0) {
            try {
                if (cn.jiguang.h.a.a().d(1504)) {
                    jSONObject.put("network_type", cn.jiguang.l.d.l(this.f8135a));
                }
                if (cn.jiguang.h.a.a().d(1503)) {
                    jSONObject.put("local_dns", cn.jiguang.l.d.f());
                }
                cn.jiguang.l.d.a(this.f8135a, jSONObject, "loc_info");
                jSONArray.put(jSONObject);
            } catch (JSONException e4) {
                cn.jiguang.ai.a.d("JLocation", "package json exception:" + e4.getMessage());
            }
        }
        return jSONObject2;
    }

    private List<cn.jiguang.ag.c> c(Context context, int i2) {
        String str;
        List<cn.jiguang.ag.c> list = null;
        try {
            if (cn.jiguang.h.a.a().d(1505)) {
                if (!cn.jiguang.l.d.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                    str = "collect wifi failed because has no android.permission.ACCESS_WIFI_STATE";
                } else if (cn.jiguang.l.d.k(context)) {
                    list = new d(context).a(i2);
                    cn.jiguang.ai.a.a("JLocation", "collect wifi success:" + list);
                } else {
                    str = "collect wifi failed because not enable to collect wifi list";
                }
                cn.jiguang.ai.a.d("JLocation", str);
            }
        } catch (Exception e2) {
            cn.jiguang.ai.a.a("JLocation", "collect wifi failed :" + e2.getMessage());
        }
        return list;
    }

    private cn.jiguang.ag.b g(Context context) {
        StringBuilder sb;
        String message;
        String str;
        String str2;
        cn.jiguang.ag.b bVar = null;
        if (c() && cn.jiguang.h.a.a().d(1502)) {
            try {
                cn.jiguang.ai.a.a("JLocation", "coares:" + cn.jiguang.l.d.a(context, Permission.ACCESS_COARSE_LOCATION));
                cn.jiguang.ai.a.a("JLocation", "fine:" + cn.jiguang.l.d.a(context, Permission.ACCESS_FINE_LOCATION));
                if (!cn.jiguang.l.d.a(context, Permission.ACCESS_COARSE_LOCATION) && !cn.jiguang.l.d.a(context, Permission.ACCESS_FINE_LOCATION)) {
                    cn.jiguang.ai.a.d("JLocation", "collect gps failed because has no Manifest.permission.LOCATION");
                }
                if (cn.jiguang.l.d.m(context) && c.a(context).e()) {
                    cn.jiguang.ag.b d2 = c.a(context).d();
                    try {
                        if (d2 == null) {
                            FutureTask futureTask = new FutureTask(new b());
                            cn.jiguang.l.d.b(futureTask);
                            cn.jiguang.ag.b bVar2 = (cn.jiguang.ag.b) futureTask.get(31000L, TimeUnit.MILLISECONDS);
                            if (bVar2 != null) {
                                try {
                                    str2 = "collect gps success:" + bVar2.toString();
                                } catch (InterruptedException e2) {
                                    e = e2;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps exception:");
                                    message = e.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ai.a.d("JLocation", str);
                                    return bVar;
                                } catch (ExecutionException e3) {
                                    e = e3;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps exception:");
                                    message = e.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ai.a.d("JLocation", str);
                                    return bVar;
                                } catch (TimeoutException unused) {
                                    bVar = bVar2;
                                    str = "collect gps time out";
                                    cn.jiguang.ai.a.d("JLocation", str);
                                    return bVar;
                                } catch (Throwable th) {
                                    th = th;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps throwable:");
                                    message = th.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ai.a.d("JLocation", str);
                                    return bVar;
                                }
                            } else {
                                str2 = "collect gps failed";
                            }
                            cn.jiguang.ai.a.a("JLocation", str2);
                            d2 = bVar2;
                        } else {
                            cn.jiguang.ai.a.a("JLocation", "load  last gps success:" + d2.toString());
                        }
                        if (d2 != null) {
                            cn.jiguang.l.b.r(context, d2.f8164a + "," + d2.f8167d + "," + d2.f8166c);
                        }
                        bVar = d2;
                    } catch (InterruptedException e4) {
                        e = e4;
                        bVar = d2;
                    } catch (ExecutionException e5) {
                        e = e5;
                        bVar = d2;
                    } catch (TimeoutException unused2) {
                        bVar = d2;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = d2;
                    }
                }
            } catch (InterruptedException e6) {
                e = e6;
            } catch (ExecutionException e7) {
                e = e7;
            } catch (TimeoutException unused3) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return bVar;
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8135a = context;
        return "JLocation";
    }

    @Override // cn.jiguang.l.a
    public void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.h.a.a().a(1500)) {
            int optInt = jSONObject.optInt("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optInt != 5) {
                if (optInt == 45) {
                    cn.jiguang.l.b.a(this.f8135a, "JLocation", optJSONObject.optLong("interval", 0L) * 1000);
                    return;
                }
                return;
            }
            boolean optBoolean = true ^ optJSONObject.optBoolean("disable", true);
            cn.jiguang.l.b.a(this.f8135a, "JLocation", optBoolean);
            if (optBoolean) {
                cn.jiguang.l.b.b(this.f8135a, "JLocation", optJSONObject.optLong("frequency", 0L) * 1000);
            }
        }
    }

    @Override // cn.jiguang.l.a
    public boolean a(Context context, String str) {
        return cn.jiguang.l.b.a(context, str);
    }

    public ArrayList<String> b(Context context, int i2) {
        ArrayList<String> arrayList = null;
        if (!c()) {
            return null;
        }
        List<cn.jiguang.ag.c> c2 = c(context, Integer.MAX_VALUE);
        if (c2 != null) {
            arrayList = new ArrayList<>();
            Iterator<cn.jiguang.ag.c> it = c2.iterator();
            while (it.hasNext()) {
                String str = it.next().f8172b;
                if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                    if (arrayList.size() == i2) {
                        break;
                    }
                }
            }
        }
        cn.jiguang.ai.a.a("JLocation", "getWifiNameArray:" + arrayList);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00d5  */
    @Override // cn.jiguang.l.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.a.b(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.l.a
    public boolean b() {
        return cn.jiguang.l.b.i(this.f8135a, "JLocation");
    }

    @Override // cn.jiguang.l.a
    public boolean c() {
        return cn.jiguang.l.b.j(this.f8135a, "JLocation");
    }

    @Override // cn.jiguang.l.a
    public boolean c(Context context) {
        return true;
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        if (cn.jiguang.h.a.a().a(1500)) {
            JSONObject a2 = cn.jiguang.p.c.a(context, "rl.catch");
            if (a2 == null) {
                cn.jiguang.ai.a.a("JLocation", "there are no data to report");
                return;
            }
            JSONArray optJSONArray = a2.optJSONArray("content");
            if (optJSONArray == null) {
                cn.jiguang.ai.a.a("JLocation", "there are no content data to report");
                return;
            }
            cn.jiguang.l.d.a(context, optJSONArray);
            cn.jiguang.ai.a.a("JLocation", "clean cache json");
            cn.jiguang.p.c.b(context, "rl.catch");
            super.d(context, str);
        }
    }

    public Bundle e(Context context) {
        long j;
        double d2;
        double d3;
        cn.jiguang.ag.b g2 = g(context);
        if (g2 != null) {
            j = g2.f8164a;
            d2 = g2.f8167d;
            d3 = g2.f8166c;
        } else {
            j = 0;
            d2 = 200.0d;
            d3 = 200.0d;
        }
        return a(j, d2, d3);
    }

    @Override // cn.jiguang.l.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bundle d(Context context) {
        long longValue;
        double doubleValue;
        double doubleValue2;
        String e2 = cn.jiguang.l.b.e(context);
        if (TextUtils.isEmpty(e2)) {
            longValue = 0;
            doubleValue = 200.0d;
            doubleValue2 = 200.0d;
        } else {
            String[] split = e2.split(",");
            longValue = Long.valueOf(split[0]).longValue();
            doubleValue = Double.valueOf(split[1]).doubleValue();
            doubleValue2 = Double.valueOf(split[2]).doubleValue();
        }
        Bundle a2 = a(longValue, doubleValue, doubleValue2);
        String f2 = cn.jiguang.l.b.f(context);
        if (!TextUtils.isEmpty(f2)) {
            a2.putString("wss", f2);
        }
        return a2;
    }
}
