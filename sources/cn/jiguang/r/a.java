package cn.jiguang.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.l.c;
import cn.jiguang.l.d;
import cn.jiguang.t.b;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str) {
        try {
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "getIdsByLocal failed:" + th.getMessage());
        }
        if (b()) {
            cn.jiguang.ai.a.d("IdHelper", "not get id in main thread");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String g2 = d.g("KACzk43fXSu6fNDY3NHiRg==");
        if (!TextUtils.isEmpty(g2) && str.toLowerCase().equals(g2)) {
            String f2 = f(context);
            if (TextUtils.isEmpty(f2)) {
                return "";
            }
            jSONObject.put("joad", f2);
            return jSONObject.toString();
        }
        String g3 = d.g("abElWL6JFOA3DmtpsVXe5g==");
        String g4 = d.g("qqDQS9ZdTx8AkhCp5nUUmQ==");
        if ((!TextUtils.isEmpty(g3) && str.toLowerCase().equals(g3)) || (!TextUtils.isEmpty(g4) && str.toLowerCase().equals(g4))) {
            return n(context);
        }
        String g5 = d.g("ZCUqO8ru60AnJTvdxNftwg==");
        if (!TextUtils.isEmpty(g5) && str.toLowerCase().equals(g5)) {
            return l(context);
        }
        String g6 = d.g("Sqo/G40afBQEk/ThxiHCDA==");
        if (!TextUtils.isEmpty(g6) && str.toLowerCase().equals(g6)) {
            String k = k(context);
            if (TextUtils.isEmpty(k)) {
                return "";
            }
            jSONObject.put("joad", k);
            return jSONObject.toString();
        }
        String g7 = d.g("Fl44OKc45ZSCqG4pxdgAdA==");
        if (!TextUtils.isEmpty(g7) && str.toLowerCase().equals(g7)) {
            String i2 = i(context);
            if (TextUtils.isEmpty(i2)) {
                return "";
            }
            jSONObject.put("joad", i2);
            return jSONObject.toString();
        }
        String g8 = d.g("v4ibuvMAw0xxYGyCW947bw==");
        String g9 = d.g("lJTl9z+ZycJlu+D6qavE9g==");
        if ((!TextUtils.isEmpty(g8) && str.toLowerCase().equals(g8)) || (!TextUtils.isEmpty(g9) && str.toLowerCase().equals(g9))) {
            return j(context);
        }
        String g10 = d.g("7UUoz3VX0wN8BuYNQ77o2g==");
        if (!TextUtils.isEmpty(g10) && str.toLowerCase().equals(g10)) {
            return h(context);
        }
        String g11 = d.g("NftKgs8fjwuVYJ3VslncvA==");
        String g12 = d.g("Wq1559o9+HHChTmry59Bkg==");
        if ((!TextUtils.isEmpty(g11) && str.toLowerCase().equals(g11)) || (!TextUtils.isEmpty(g12) && str.toLowerCase().equals(g12))) {
            String g13 = g(context);
            if (TextUtils.isEmpty(g13)) {
                return "";
            }
            jSONObject.put("joad", g13);
            return jSONObject.toString();
        }
        String g14 = d.g("fmTCWm9ViPlyzM8H0bOrgw==");
        if (!TextUtils.isEmpty(g14) && str.toLowerCase().equals(g14)) {
            String m = m(context);
            if (TextUtils.isEmpty(m)) {
                return "";
            }
            jSONObject.put("joad", m);
            return jSONObject.toString();
        }
        String g15 = d.g("bbyVCf9F4jMXWPUAeT3frw==");
        if (!TextUtils.isEmpty(g15) && str.toLowerCase().equals(g15)) {
            String o = o(context);
            if (TextUtils.isEmpty(o)) {
                return "";
            }
            jSONObject.put("joad", o);
            return jSONObject.toString();
        }
        String g16 = d.g("0kbg5dLQpyr1z+M/7Qkp7A==");
        if ((!TextUtils.isEmpty(g16) && str.toLowerCase().equals(g16)) || cn.jiguang.ad.a.a()) {
            String p = p(context);
            if (TextUtils.isEmpty(p)) {
                return "";
            }
            jSONObject.put("joad", p);
            return jSONObject.toString();
        }
        String g17 = d.g("7kOXkVyi2CnACIIN3msOQg==");
        if ((TextUtils.isEmpty(g17) || !str.toLowerCase().equals(g17)) && !cn.jiguang.ad.a.b()) {
            cn.jiguang.ai.a.d("IdHelper", "not supported this device: " + str);
            return "";
        }
        String q = q(context);
        if (TextUtils.isEmpty(q)) {
            return "";
        }
        jSONObject.put("joad", q);
        return jSONObject.toString();
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String d2 = d(context);
            cn.jiguang.ai.a.a("IdHelper", "[getAllIds] miit id is: " + d2);
            if (TextUtils.isEmpty(d2)) {
                String str = c.a.f8947b;
                if (!TextUtils.isEmpty(str)) {
                    cn.jiguang.ai.a.a("IdHelper", "start getAllIds by local");
                    String a2 = a(context, str);
                    if (!TextUtils.isEmpty(a2)) {
                        jSONObject = new JSONObject(a2);
                    }
                }
            } else {
                jSONObject = new JSONObject(d2);
            }
            String b2 = b(context);
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("jgad", b2);
            }
            cn.jiguang.ai.a.a("IdHelper", "gaid: " + b2);
            if (jSONObject.toString().equals("{}")) {
                return null;
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "[getAllIds] failed：" + th.getMessage());
            return null;
        }
    }

    public static boolean a() {
        try {
            cn.jiguang.ai.a.a("IdHelper", "MdidSdkHelper name:" + Class.forName(d.g("PcAdtsBZRJNo5a0tkYAln7JmiO95myc4NXXWf+j90/KXOpD1MlJOBugPF6SmMTLe")).getName());
            return true;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "not found mitt class" + th);
            return false;
        }
    }

    public static String b(Context context) {
        try {
            return e(context);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "getGoogleAdid failed:" + th.getMessage());
            return "";
        }
    }

    public static boolean b() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    public static String c(Context context) {
        try {
            Class.forName(d.g("PcAdtsBZRJNo5a0tkYAln5KxAHXeXV/NVUuFAGa7lw0lgssd4d8qhC10P370VkfX"));
            FutureTask futureTask = new FutureTask(new cn.jiguang.w.a(context));
            d.b(futureTask);
            return (String) futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("IdHelper", "getMittIds by version 10 failed:" + th);
            try {
                Class.forName(d.g("KbEOJC6hqkBcbuUrDsdaXOUofElYAGZhekK9mozUIHGMGWMoSFaqAoiWtoXrQsHy"));
                FutureTask futureTask2 = new FutureTask(new cn.jiguang.x.a(context));
                d.b(futureTask2);
                return (String) futureTask2.get(2L, TimeUnit.SECONDS);
            } catch (Throwable th2) {
                cn.jiguang.ai.a.d("IdHelper", "getMittIds by version 13 failed:" + th2);
                return "";
            }
        }
    }

    public static String d(Context context) {
        if (b()) {
            cn.jiguang.ai.a.d("IdHelper", "not get id in main thread");
            return "";
        }
        if (a()) {
            String c2 = c(context);
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
            cn.jiguang.ai.a.d("IdHelper", "not get ids by mitts");
        }
        return "";
    }

    public static String e(Context context) {
        String str;
        String g2;
        if (b()) {
            str = "not get id in main thread";
        } else {
            try {
                String g3 = d.g("83JmFPusB5CQP/HtGWAx9pgfJZgEDCaE2wJbKIZa8GM=");
                if (TextUtils.isEmpty(g3)) {
                    return "";
                }
                context.getPackageManager().getPackageInfo(g3, 0);
                try {
                    g2 = d.g("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjLhqIYeN+juscczCl6Sq6PxwLAq9CdDlLtmxsbD83akRg==");
                } catch (Throwable th) {
                    cn.jiguang.ai.a.d("IdHelper", "google getAdvertisingIdInfo Exception: " + th.toString());
                }
                if (TextUtils.isEmpty(g2)) {
                    return "";
                }
                Intent intent = new Intent(g2);
                String g4 = d.g("+Fc+/S0DV5xukan0E/9N4VArQdi8pEVBp8UquAC8VbE=");
                if (TextUtils.isEmpty(g4)) {
                    return "";
                }
                intent.setPackage(g4);
                b bVar = new b();
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        if (bVar.f9051a) {
                            cn.jiguang.ai.a.d("IdHelper", "google service repeat bind");
                            return "";
                        }
                        String a2 = new cn.jiguang.t.a(bVar.f9052b.take()).a();
                        cn.jiguang.ai.a.a("IdHelper", "google ad id:" + a2);
                        return a2;
                    } catch (Throwable th2) {
                        try {
                            cn.jiguang.ai.a.d("IdHelper", "get google Ids by service error: " + th2.getMessage());
                            context.unbindService(bVar);
                        } finally {
                            context.unbindService(bVar);
                        }
                    }
                } else {
                    cn.jiguang.ai.a.d("IdHelper", "google service bind failed");
                }
                return "";
            } catch (Throwable unused) {
                str = "not supported google";
            }
        }
        cn.jiguang.ai.a.d("IdHelper", str);
        return "";
    }

    public static String f(Context context) {
        String g2;
        if (context == null) {
            return "";
        }
        try {
            String g3 = d.g("CV+BUnOM9r9hBWkUu5oSnA==");
            if (TextUtils.isEmpty(g3)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(g3, 0);
            try {
                g2 = d.g("axDZqud6H+CDQBXA/yBXOiEPy9gW6px8eLENPXdBlBHSZeanEgWxhi72s58AM6wZ");
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("IdHelper", "hw getAdvertisingIdInfo Exception: " + th.toString());
            }
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            Intent intent = new Intent(g2);
            intent.setPackage(g3);
            cn.jiguang.u.b bVar = new cn.jiguang.u.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (bindService) {
                try {
                    String a2 = new cn.jiguang.u.a(bVar.f9055a.take()).a();
                    cn.jiguang.ai.a.a("IdHelper", "hw ids-o:" + a2);
                    return a2;
                } catch (Throwable th2) {
                    try {
                        cn.jiguang.ai.a.d("IdHelper", "hw get Ids-oa error: " + th2.getMessage());
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    } finally {
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    }
                }
            } else {
                cn.jiguang.ai.a.d("IdHelper", "hw service bind failed");
            }
            return "";
        } catch (Throwable unused) {
            cn.jiguang.ai.a.d("IdHelper", "not supported hw");
            return "";
        }
    }

    public static String g(Context context) {
        String g2;
        try {
            String g3 = d.g("Mpy0fkBSw1N+kug2cBPj2YJ2JkldBoT0Hj8EbMwXMGU=");
            if (TextUtils.isEmpty(g3)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(g3, 0);
            try {
                g2 = d.g("Mpy0fkBSw1N+kug2cBPj2dTFEwqSue3aUHyxqBhF0BWQuC1TiTYwRmpXbBFYowSK");
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("IdHelper", "zui getAdvertisingIdInfo Exception: " + e2.toString());
            }
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            Intent intent = new Intent(g2);
            intent.setPackage(g3);
            cn.jiguang.ae.b bVar = new cn.jiguang.ae.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (bindService) {
                try {
                    String a2 = new cn.jiguang.ae.a(bVar.f8133a.take()).a();
                    cn.jiguang.ai.a.a("IdHelper", "zui ids-oa:" + a2);
                    return a2;
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ai.a.d("IdHelper", "get zui ids-oa error: " + th.getMessage());
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    } finally {
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    }
                }
            } else {
                cn.jiguang.ai.a.d("IdHelper", "zui service bind failed");
            }
            return "";
        } catch (Throwable unused) {
            cn.jiguang.ai.a.d("IdHelper", "package com.zui.deviceidservice not found ");
            return "";
        }
    }

    public static String h(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.y.b bVar = new cn.jiguang.y.b(context);
            String b2 = bVar.b();
            String c2 = bVar.c();
            String a2 = bVar.a();
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("joad", b2);
            }
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("jvad", c2);
            }
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("jaad", a2);
            }
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("IdHelper", "getNubiaIds err: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public static String i(Context context) {
        String g2;
        try {
            String g3 = d.g("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVtSyGK74B1pfv+DoniV/u8H");
            if (TextUtils.isEmpty(g3)) {
                return "";
            }
            if (context.getPackageManager().getPackageInfo(g3, 0) == null) {
                cn.jiguang.ai.a.d("IdHelper", "sumsung not support");
                return "";
            }
            try {
                g2 = d.g("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVsaSg3goTgfCOA0dOFWjVLPc7dVv4XHGL0Dk7MQTYMVQw==");
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("IdHelper", "sumsung getAdvertisingIdInfo Exception: " + e2.toString());
            }
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            Intent intent = new Intent();
            intent.setClassName(g3, g2);
            cn.jiguang.aa.b bVar = new cn.jiguang.aa.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (bindService) {
                try {
                    String a2 = new cn.jiguang.aa.a(bVar.f8112a.take()).a(context);
                    cn.jiguang.ai.a.a("IdHelper", "sumsuang ids-oa:" + a2);
                    return a2;
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ai.a.d("IdHelper", "get sumsung Ids-oa error: " + th.getMessage());
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    } finally {
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    }
                }
            } else {
                cn.jiguang.ai.a.d("IdHelper", "sumsung service bind failed");
            }
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            cn.jiguang.ai.a.d("IdHelper", "package com.samsung.android.deviceidservice not found");
            return "";
        }
    }

    public static String j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.v.c cVar = new cn.jiguang.v.c(context);
            String b2 = cVar.b();
            String c2 = cVar.c();
            String a2 = cVar.a();
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("joad", b2);
            }
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("jvad", c2);
            }
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("jaad", a2);
            }
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("IdHelper", "getVivoIds err: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public static String k(Context context) {
        String g2;
        try {
            String g3 = d.g("qFFOesfckPwVmbfqzGl5oG9IMWwJa4PjDfKEUokUsrU=");
            if (TextUtils.isEmpty(g3)) {
                return "";
            }
            boolean z = false;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(g3, 0);
            if (packageInfo == null) {
                cn.jiguang.ai.a.d("IdHelper", "oppo get package info is null");
                return "";
            }
            if (Build.VERSION.SDK_INT < 28 ? packageInfo.versionCode >= 1 : packageInfo.getLongVersionCode() >= 1) {
                z = true;
            }
            if (!z) {
                cn.jiguang.ai.a.a("IdHelper", "oppo not support above version 28");
                return "";
            }
            try {
                g2 = d.g("qFFOesfckPwVmbfqzGl5oOMkBF5tSSPHMYAiT/owwSwoCrUg5HXoJRYDJrCupV3K");
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("IdHelper", "oppo getAdvertisingIdInfo Exception: " + e2.toString());
            }
            if (TextUtils.isEmpty(g2)) {
                return "";
            }
            Intent intent = new Intent(g2);
            intent.setPackage(g3);
            String g4 = d.g("/3gurUKcGzqF8/YMsL45D9RvCsSd5y5lQDTuvU2S5vtG2aMIkkluUNr+NKF2loi0");
            if (TextUtils.isEmpty(g4)) {
                return "";
            }
            intent.setAction(g4);
            cn.jiguang.z.b bVar = new cn.jiguang.z.b();
            boolean bindService = context.bindService(intent, bVar, 1);
            if (bindService) {
                try {
                    String a2 = new cn.jiguang.z.a(bVar.f9081a.take()).a(context);
                    cn.jiguang.ai.a.a("IdHelper", "oppo ids-oa: " + a2);
                    return a2;
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ai.a.d("IdHelper", "get oppo ids-oa error: " + th.getMessage());
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    } finally {
                        if (bindService) {
                            context.unbindService(bVar);
                        }
                    }
                }
            } else {
                cn.jiguang.ai.a.d("IdHelper", "oppo service bind failed");
            }
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            cn.jiguang.ai.a.d("IdHelper", "package com.heytap.openid not found");
            return "";
        }
    }

    public static String l(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.ab.c cVar = new cn.jiguang.ab.c(context);
            cVar.a("");
            String b2 = cVar.b();
            String c2 = cVar.c();
            String a2 = cVar.a();
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("joad", b2);
            }
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("jvad", c2);
            }
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("jaad", a2);
            }
        } catch (JSONException e2) {
            cn.jiguang.ai.a.d("IdHelper", "getVivoIds err: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public static String m(Context context) {
        String g2;
        if (context == null) {
            return "";
        }
        try {
            g2 = d.g("AVy8x+cBVze9OKJHZKioHyNDBGqtEllVM4dvG69zMJc=");
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("IdHelper", "asus getAdvertisingIdInfo Exception: " + e2.toString());
        }
        if (TextUtils.isEmpty(g2)) {
            return "";
        }
        Intent intent = new Intent(g2);
        String g3 = d.g("8lAhWp7NB89J3VIJU4lIGQtLf0YkfPcfFvWDnnGUuiQ=");
        if (TextUtils.isEmpty(g3)) {
            return "";
        }
        String g4 = d.g("8lAhWp7NB89J3VIJU4lIGQnPwmB8zgbENyN+gUA8dpRI7pO4GGAXufB+HCPmLRg7bL9N6o9V3Rxxk98J3lyy6g==");
        if (TextUtils.isEmpty(g4)) {
            return "";
        }
        ComponentName componentName = new ComponentName(g3, g4);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        cn.jiguang.ai.a.c("IdHelper", "start to bind did service.");
        cn.jiguang.s.b bVar = new cn.jiguang.s.b();
        boolean bindService = context.bindService(intent2, bVar, 1);
        if (bindService) {
            try {
                String a2 = new cn.jiguang.s.a(bVar.f9048a.take()).a();
                cn.jiguang.ai.a.a("IdHelper", "asus ids-oa; " + a2);
                return a2;
            } catch (Throwable th) {
                try {
                    cn.jiguang.ai.a.d("IdHelper", "get asus ids-oa error: " + th.getMessage());
                    if (bindService) {
                        cn.jiguang.ai.a.c("IdHelper", "start to unbind did service");
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        cn.jiguang.ai.a.c("IdHelper", "start to unbind did service");
                        context.unbindService(bVar);
                    }
                }
            }
        }
        return "";
    }

    public static String n(Context context) {
        return cn.jiguang.ac.a.a(context);
    }

    public static String o(Context context) {
        return new cn.jiguang.ad.b(context).a();
    }

    public static String p(Context context) {
        return new cn.jiguang.ad.b(context).a();
    }

    public static String q(Context context) {
        return new cn.jiguang.ad.b(context).a();
    }
}
