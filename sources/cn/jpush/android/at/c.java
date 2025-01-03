package cn.jpush.android.at;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import com.tencent.bugly.CrashModule;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f9330a = 120;

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f9331b = null;
    public static String l = "";
    public static long m = 0;
    public static long n = 43200;

    /* renamed from: h, reason: collision with root package name */
    public long f9337h;
    public String q;
    public String r;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9332c = true;

    /* renamed from: d, reason: collision with root package name */
    public int f9333d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f9334e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9335f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9336g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9338i = true;
    public String j = "";
    public long k = 0;
    public long o = 0;
    public long p = 0;
    public f s = new f() { // from class: cn.jpush.android.at.c.1
        @Override // cn.jpush.android.at.f
        public void a(Message message) {
            if (message == null || message.what != 1004) {
                return;
            }
            Context context = JPushConstants.mApplicationContext;
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            c.this.a(context, "tcp_send_rtc", bundle);
        }
    };

    public class a extends cn.jpush.android.bm.e {

        /* renamed from: b, reason: collision with root package name */
        public Context f9341b;

        /* renamed from: c, reason: collision with root package name */
        public String f9342c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f9343d;

        public a(Context context, String str, Bundle bundle) {
            this.f9341b = context;
            this.f9342c = str;
            this.f9343d = bundle;
            this.f9666f = "HbPeriodManager#Action";
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            c cVar;
            Context context;
            Bundle bundle;
            try {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "action: " + this.f9342c);
                if (this.f9342c.equals("tcp_rtc")) {
                    d.a().a(this.f9341b, false);
                    cVar = c.this;
                    context = this.f9341b;
                    bundle = this.f9343d;
                } else if (this.f9342c.equals("tcp_send_rtc")) {
                    c.this.c(this.f9341b, this.f9343d);
                    return;
                } else {
                    if (!"special_rtc".equals(this.f9342c)) {
                        return;
                    }
                    cVar = c.this;
                    context = this.f9341b;
                    bundle = this.f9343d;
                }
                cVar.a(context, bundle);
            } catch (Throwable th) {
                cn.jpush.android.r.b.g("InAppHbPeriodManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    public static c a() {
        if (f9331b == null) {
            synchronized (c.class) {
                if (f9331b == null) {
                    f9331b = new c();
                }
            }
        }
        return f9331b;
    }

    private boolean a(boolean z) {
        if (z) {
            return System.currentTimeMillis() - this.f9337h < 5000;
        }
        int i2 = this.f9333d;
        long currentTimeMillis = System.currentTimeMillis() - this.f9337h;
        return i2 > 0 ? currentTimeMillis < ((long) (this.f9333d + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Bundle bundle) {
        try {
            if (!d()) {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "HB Period is disabled by user");
                return;
            }
            if (a(bundle != null ? bundle.getBoolean("force", false) : false)) {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "No need to in app rtc, Because it have succeed recently");
            } else if (!this.f9335f) {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "socket is closed or push isn't login");
            } else {
                cn.jpush.android.r.b.c("InAppHbPeriodManager", "Send heart beat");
                a(context, 22);
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHbPeriodManager", "[rtcKeepAlive] failed, " + th.getMessage());
        }
    }

    private boolean d() {
        try {
            if (JPushConstants.SDK_VERSION_CODE >= 410) {
                return JPushConstants.IS_HB_PERIOD_ENABLE;
            }
        } catch (Throwable unused) {
        }
        return this.f9338i;
    }

    public static String f(Context context) {
        return cn.jpush.android.v.c.a().c(context);
    }

    public static String g(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
        return onEvent instanceof JSONObject ? ((JSONObject) onEvent).toString() : "";
    }

    public synchronized void a(Context context) {
        if (this.f9336g) {
            return;
        }
        this.f9334e = 0;
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "start push period worker...");
        g.a().b();
        d.a().a(context, true);
        this.f9336g = true;
    }

    public void a(Context context, int i2) {
        Context context2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("timer send ");
            sb.append(i2 == 21 ? "notify" : "native");
            sb.append(" ad heartbeat start");
            cn.jpush.android.r.b.b("InAppHbPeriodManager", sb.toString());
            if (!this.f9335f) {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "tcp not connected, can't send ad heartbeat");
                cn.jpush.android.ae.c.a(context, i2, 104, "");
                return;
            }
            if (cn.jpush.android.ar.d.c(context)) {
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "current page in black list, not send hb");
                cn.jpush.android.ae.c.a(context, i2, 106, "");
                cn.jpush.android.l.c.a(context, JCoreHelper.getUid(context) + "", 1325, 0);
                return;
            }
            int i3 = cn.jpush.android.o.b.f9824a;
            if (i3 != 2) {
                i3 = cn.jpush.android.af.e.a(context) ? 1 : 0;
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "send heartbeat local userType= " + cn.jpush.android.o.b.f9824a + ", use process importance to judge type: " + i3);
            }
            int i4 = cn.jpush.android.o.b.f9826c ? 1 : 0;
            byte g2 = cn.jpush.android.ar.a.g(context);
            byte b2 = cn.jpush.android.az.e.b(context);
            int a2 = cn.jpush.android.az.e.a(context);
            String d2 = d(context);
            String e2 = e(context);
            String lowerCase = String.valueOf(UUID.randomUUID()).toLowerCase();
            StringBuilder sb2 = new StringBuilder();
            try {
                sb2.append(" $$");
                sb2.append(TextUtils.isEmpty(this.q) ? LogUtils.PLACEHOLDER : this.q);
                sb2.append("$$");
                sb2.append(TextUtils.isEmpty(this.r) ? LogUtils.PLACEHOLDER : this.r);
                sb2.append("$$");
                sb2.append(lowerCase);
                sb2.append("$$1");
                String sb3 = sb2.toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_type", i2 == 21 ? 1 : 2);
                jSONObject.put("user_type", i3);
                jSONObject.put(ActionManager.SDK_TYPE, 1);
                jSONObject.put("render_type", 0);
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "send status report - userType:" + i3 + ", supportInstall:" + i4 + ", sspLayoutVersion=" + a2 + " , suppprtINAPP:" + ((int) g2) + ", supportSSP: " + ((int) b2) + ", pkgIndex:" + d2 + ", devInfo: " + e2 + ", adInfo: " + sb3 + ", extra: " + jSONObject.toString());
                JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 35, 6, 1L, 0L, cn.jpush.android.bi.b.a(i3, i4, 1, a2, g2, b2, d2, e2, sb3, jSONObject.toString()));
                StringBuilder sb4 = new StringBuilder();
                sb4.append("timer send ");
                sb4.append(i2 == 21 ? "notify" : "native");
                sb4.append(" ad heartbeat end");
                cn.jpush.android.r.b.b("InAppHbPeriodManager", sb4.toString());
                this.r = "";
                this.f9337h = System.currentTimeMillis();
                context2 = context;
            } catch (Throwable th) {
                th = th;
                context2 = context;
            }
            try {
                cn.jpush.android.ae.c.a(context2, i2, 0, "");
            } catch (Throwable th2) {
                th = th2;
                cn.jpush.android.ae.c.a(context2, i2, 105, "");
                cn.jpush.android.r.b.f("InAppHbPeriodManager", "send hb failed, error: " + th.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            context2 = context;
        }
    }

    public void a(Context context, Bundle bundle) {
        long j;
        if (cn.jpush.android.cache.a.e(context)) {
            cn.jpush.android.r.b.c("InAppHbPeriodManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j = bundle.getLong("delay_time", 0L);
        } else {
            j = 0;
        }
        if (j <= 0) {
            c(context, bundle);
        } else {
            g.a().b(CrashModule.MODULE_ID, j, this.s);
        }
        cn.jpush.android.r.b.d("InAppHbPeriodManager", "send rtc force=" + z + " delay=" + j);
    }

    public void a(Context context, String str) {
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "trigger inapp heartbeat by event: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r = str;
        cn.jpush.android.v.e.a().d(context);
    }

    public void a(Context context, String str, Bundle bundle) {
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "[doAction] action: " + str + ", userInAppHb: " + this.f9332c);
        a(context);
        JCoreHelper.normalExecutor(context, "InAppHbPeriodManager", new a(context, str, bundle));
    }

    public void a(Context context, String str, boolean z, long j) {
        try {
            cn.jpush.android.r.b.b("InAppHbPeriodManager", "[sendRtcToTcp], action: " + str + ", force: " + z + ", delayTime: " + j);
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j * 1000);
            a(context, str, bundle);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("InAppHbPeriodManager", "sendRtcToTcp error:" + th.getMessage());
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("inapp_next_time");
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "need request in app soon, next_time: " + optInt);
                a(context, "special_rtc", true, (long) Math.max(optInt, 0));
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("InAppHbPeriodManager", "[handleCtrlNextInAppCmd] error:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z) {
        try {
            this.f9338i = z;
            if (JPushConstants.IS_HB_PERIOD_ENABLE && !z) {
                cn.jpush.android.v.e.a().f(context);
            } else if (!JPushConstants.IS_HB_PERIOD_ENABLE && z) {
                cn.jpush.android.v.e.a().e(context);
            }
            JPushConstants.IS_HB_PERIOD_ENABLE = z;
        } catch (Throwable unused) {
        }
        cn.jpush.android.l.c.a(context, "NO MSGID", 1327, 0);
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "user set HB Period status, enable: " + z);
    }

    public void b() {
        int i2;
        int i3 = this.f9334e;
        int i4 = this.f9333d;
        if (i4 > 0) {
            if (i3 == 0) {
                i2 = i4 * 2;
            } else {
                int i5 = i3 * 2;
                int i6 = f9330a;
                if (i5 < i6) {
                    i2 = i3 * 2;
                } else {
                    this.f9334e = i6;
                }
            }
            this.f9334e = i2;
        }
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.f9334e + ", old hbInterval: " + i3);
    }

    public void b(Context context) {
        this.f9335f = true;
    }

    public void b(Context context, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("activity_name");
            int i2 = bundle.getInt("state");
            boolean z = bundle.getBoolean(ContentCommon.TYPE);
            cn.jpush.android.ar.d.a(string, i2, z);
            this.q = cn.jpush.android.ar.d.a();
            boolean z2 = i2 == 1;
            cn.jpush.android.r.b.b("InAppHbPeriodManager", "handleLifeResume, pageName: " + string + ", isEnter: " + z2 + ", isActivity: " + z + ", currentPageName: " + this.q);
            if (z2) {
                cn.jpush.android.v.e.a().k(context);
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "send force rtc by page change, current page: " + this.q);
                this.o = System.currentTimeMillis();
            }
        }
    }

    public int c() {
        cn.jpush.android.r.b.b("InAppHbPeriodManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.f9334e + " hbInterval =" + this.f9333d);
        int i2 = this.f9333d;
        if (i2 <= 0) {
            return f9330a;
        }
        int i3 = this.f9334e;
        return i3 == 0 ? i2 : i3;
    }

    public void c(Context context) {
        this.f9335f = false;
    }

    public String d(Context context) {
        return JCoreHelper.getJCoreSDKVersionInt() < 266 ? "-4" : f(context);
    }

    public synchronized String e(Context context) {
        if (System.currentTimeMillis() - m < n * 1000) {
            return l;
        }
        String g2 = g(context);
        n = !TextUtils.isEmpty(g2) ? 43200L : 360L;
        if (!TextUtils.isEmpty(g2)) {
            try {
                JSONObject jSONObject = new JSONObject(g2);
                String optString = jSONObject.optString("imei1", LogUtils.PLACEHOLDER);
                String optString2 = jSONObject.optString("imei2", LogUtils.PLACEHOLDER);
                String optString3 = jSONObject.optString("joad", LogUtils.PLACEHOLDER);
                String optString4 = jSONObject.optString("android_id", LogUtils.PLACEHOLDER);
                String optString5 = jSONObject.optString("manufacturer", LogUtils.PLACEHOLDER);
                String optString6 = jSONObject.optString("model", LogUtils.PLACEHOLDER);
                String optString7 = jSONObject.optString("language", LogUtils.PLACEHOLDER);
                cn.jpush.android.s.b b2 = cn.jpush.android.n.b.a().b();
                cn.jpush.android.s.a c2 = cn.jpush.android.n.b.a().c();
                String c3 = b2.c();
                String b3 = b2.b();
                cn.jpush.android.r.b.b("InAppHbPeriodManager", "osVersion:" + b3);
                g2 = optString + "$$" + optString2 + "$$" + optString3 + "$$" + optString4 + "$$" + optString5 + "$$" + optString6 + "$$" + c3 + "$$" + b3 + "$$" + optString7 + "$$" + b2.e() + "$$" + b2.f() + "$$" + b2.d() + "$$" + c2.d();
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppHbPeriodManager", "get device info failed, " + th.getMessage());
            }
        }
        l = g2;
        m = System.currentTimeMillis();
        return g2;
    }
}
