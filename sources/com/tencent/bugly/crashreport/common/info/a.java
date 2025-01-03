package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class a {
    public static a Z;
    public boolean A;
    public SharedPreferences E;
    public final Context F;
    public String G;
    public String H;
    public String I;
    public String U;

    /* renamed from: c, reason: collision with root package name */
    public String f10872c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10873d;

    /* renamed from: g, reason: collision with root package name */
    public final String f10876g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10877h;

    /* renamed from: i, reason: collision with root package name */
    public long f10878i;
    public String j;
    public String k;
    public String l;
    public List<String> o;
    public boolean u;
    public String v;
    public String w;
    public String x;
    public String y;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10874e = true;

    /* renamed from: f, reason: collision with root package name */
    public String f10875f = "3.4.4";
    public String J = "unknown";
    public String K = "";
    public String L = null;
    public long M = -1;
    public long N = -1;
    public long O = -1;
    public String P = null;
    public String Q = null;
    public Map<String, PlugInBean> R = null;
    public boolean S = false;
    public String T = null;
    public Boolean V = null;
    public String W = null;
    public String m = null;
    public String n = null;
    public Map<String, PlugInBean> X = null;
    public Map<String, PlugInBean> Y = null;
    public int aa = -1;
    public int ab = -1;
    public Map<String, String> ac = new HashMap();
    public Map<String, String> ad = new HashMap();
    public Map<String, String> ae = new HashMap();
    public String p = "unknown";
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public boolean z = false;
    public Boolean af = null;
    public Boolean ag = null;
    public HashMap<String, String> B = new HashMap<>();
    public List<String> C = new ArrayList();
    public com.tencent.bugly.crashreport.a D = null;
    public final Object ah = new Object();
    public final Object ai = new Object();
    public final Object aj = new Object();
    public final Object ak = new Object();
    public final Object al = new Object();
    public final Object am = new Object();
    public final Object an = new Object();
    public int ao = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f10870a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final byte f10871b = 1;

    public a(Context context) {
        this.j = null;
        this.k = null;
        this.U = null;
        this.l = null;
        this.o = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = "";
        this.A = false;
        this.F = z.a(context);
        PackageInfo b2 = AppInfo.b(context);
        if (b2 != null) {
            try {
                String str = b2.versionName;
                this.j = str;
                this.v = str;
                this.w = Integer.toString(b2.versionCode);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f10872c = AppInfo.a(context);
        this.f10873d = AppInfo.a(Process.myPid());
        this.f10876g = b.k();
        this.k = AppInfo.c(context);
        this.f10877h = "Android " + b.b() + ",level " + b.c();
        String str2 = this.H + ";" + this.f10877h;
        Map<String, String> d2 = AppInfo.d(context);
        if (d2 != null) {
            try {
                this.o = AppInfo.a(d2);
                String str3 = d2.get("BUGLY_APPID");
                if (str3 != null) {
                    this.U = str3;
                    c("APP_ID", str3);
                }
                String str4 = d2.get("BUGLY_APP_VERSION");
                if (str4 != null) {
                    this.j = str4;
                }
                String str5 = d2.get("BUGLY_APP_CHANNEL");
                if (str5 != null) {
                    this.l = str5;
                }
                String str6 = d2.get("BUGLY_ENABLE_DEBUG");
                if (str6 != null) {
                    this.u = str6.equalsIgnoreCase("true");
                }
                String str7 = d2.get("com.tencent.rdm.uuid");
                if (str7 != null) {
                    this.x = str7;
                }
                String str8 = d2.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str8)) {
                    Integer.parseInt(str8);
                }
                String str9 = d2.get("BUGLY_AREA");
                if (str9 != null) {
                    this.y = str9;
                }
            } catch (Throwable th2) {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.A = true;
                x.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (com.tencent.bugly.b.f10827c) {
                th3.printStackTrace();
            }
        }
        this.E = z.a("BUGLY_COMMON_VALUES", context);
        x.c("com info create end", new Object[0]);
    }

    public static int D() {
        return b.c();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = Z;
        }
        return aVar;
    }

    public final int A() {
        int i2;
        synchronized (this.al) {
            i2 = this.aa;
        }
        return i2;
    }

    public final int B() {
        return this.ab;
    }

    public final synchronized Map<String, PlugInBean> C() {
        return null;
    }

    public final boolean E() {
        if (this.af == null) {
            this.af = Boolean.valueOf(b.e(this.F));
            x.a("Is it a virtual machine? " + this.af, new Object[0]);
        }
        return this.af.booleanValue();
    }

    public final boolean F() {
        if (this.ag == null) {
            this.ag = Boolean.valueOf(b.f(this.F));
            x.a("Does it has hook frame? " + this.ag, new Object[0]);
        }
        return this.ag.booleanValue();
    }

    public final boolean a() {
        return this.ao > 0;
    }

    public final String c() {
        return this.f10875f;
    }

    public final void d() {
        synchronized (this.ah) {
            this.G = UUID.randomUUID().toString();
        }
    }

    public final String e() {
        String str;
        synchronized (this.ah) {
            if (this.G == null) {
                synchronized (this.ah) {
                    this.G = UUID.randomUUID().toString();
                }
            }
            str = this.G;
        }
        return str;
    }

    public final String f() {
        if (z.a((String) null)) {
            return this.U;
        }
        return null;
    }

    public final String g() {
        String str;
        synchronized (this.am) {
            str = this.J;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String h() {
        /*
            r4 = this;
            java.lang.String r0 = r4.I
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.String r0 = "deviceId"
            r1 = 0
            java.lang.String r2 = com.tencent.bugly.proguard.z.c(r0, r1)
            r4.I = r2
            if (r2 == 0) goto L11
            return r2
        L11:
            java.lang.String r2 = r4.L
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "androidid"
            if (r2 == 0) goto L21
            java.lang.String r2 = com.tencent.bugly.proguard.z.c(r3, r1)
            r4.L = r2
        L21:
            java.lang.String r2 = r4.L
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L41
            boolean r2 = r4.S
            if (r2 != 0) goto L2e
            goto L43
        L2e:
            android.content.Context r1 = r4.F
            java.lang.String r1 = com.tencent.bugly.crashreport.common.info.b.a(r1)
            r4.L = r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L41
            java.lang.String r1 = r4.L
            com.tencent.bugly.proguard.z.b(r3, r1)
        L41:
            java.lang.String r1 = r4.L
        L43:
            r4.I = r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L63
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            boolean r3 = com.tencent.bugly.proguard.z.a(r1)
            if (r3 != 0) goto L61
            java.lang.String r3 = "-"
            java.lang.String r1 = r1.replaceAll(r3, r2)
        L61:
            r4.I = r1
        L63:
            java.lang.String r1 = r4.I
            if (r1 == 0) goto L6d
            com.tencent.bugly.proguard.z.b(r0, r1)
            java.lang.String r0 = r4.I
            return r0
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.a.h():java.lang.String");
    }

    public final String i() {
        String str = this.H;
        if (str != null) {
            return str;
        }
        String c2 = z.c("deviceModel", null);
        this.H = c2;
        if (c2 != null) {
            return c2;
        }
        String a2 = b.a();
        this.H = a2;
        z.b("deviceModel", a2);
        return this.H;
    }

    public final synchronized String j() {
        return this.K;
    }

    public final long k() {
        if (this.M <= 0) {
            this.M = b.d();
        }
        return this.M;
    }

    public final long l() {
        if (this.N <= 0) {
            this.N = b.f();
        }
        return this.N;
    }

    public final long m() {
        if (this.O <= 0) {
            this.O = b.h();
        }
        return this.O;
    }

    public final String n() {
        if (this.P == null) {
            this.P = b.a(this.F, true);
        }
        return this.P;
    }

    public final String o() {
        if (this.Q == null) {
            this.Q = b.d(this.F);
        }
        return this.Q;
    }

    public final String p() {
        try {
            Map<String, ?> all = this.F.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.ai) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.B.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            x.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            x.a(th2);
        }
        if (this.B.isEmpty()) {
            x.c("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.B.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        x.c("SDK_INFO = %s", sb.toString());
        c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public final synchronized Map<String, PlugInBean> q() {
        return null;
    }

    public final String r() {
        if (this.T == null) {
            this.T = b.j();
        }
        return this.T;
    }

    public final Boolean s() {
        if (this.V == null) {
            this.V = Boolean.valueOf(b.l());
        }
        return this.V;
    }

    public final String t() {
        if (this.W == null) {
            String str = b.c(this.F);
            this.W = str;
            x.a("ROM ID: %s", str);
        }
        return this.W;
    }

    public final Map<String, String> u() {
        synchronized (this.aj) {
            if (this.ac.size() <= 0) {
                return null;
            }
            return new HashMap(this.ac);
        }
    }

    public final void v() {
        synchronized (this.aj) {
            this.ac.clear();
        }
    }

    public final int w() {
        int size;
        synchronized (this.aj) {
            size = this.ac.size();
        }
        return size;
    }

    public final Set<String> x() {
        Set<String> keySet;
        synchronized (this.aj) {
            keySet = this.ac.keySet();
        }
        return keySet;
    }

    public final Map<String, String> y() {
        synchronized (this.an) {
            if (this.ad.size() <= 0) {
                return null;
            }
            return new HashMap(this.ad);
        }
    }

    public final Map<String, String> z() {
        synchronized (this.ak) {
            if (this.ae.size() <= 0) {
                return null;
            }
            return new HashMap(this.ae);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.ao++;
        } else {
            this.ao--;
        }
        com.tencent.bugly.crashreport.a aVar = this.D;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(this.ao > 0);
        }
    }

    public final void b(String str) {
        synchronized (this.am) {
            if (str == null) {
                str = "10000";
            }
            this.J = str;
        }
    }

    public final void c(String str) {
        this.I = str;
        if (!TextUtils.isEmpty(str)) {
            z.b("deviceId", str);
        }
        synchronized (this.an) {
            this.ad.put("E8", str);
        }
    }

    public final synchronized void f(String str) {
        this.K = str;
    }

    public final void d(String str) {
        x.a("change deviceModel，old:%s new:%s", this.H, str);
        this.H = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z.b("deviceModel", str);
    }

    public final String g(String str) {
        String remove;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.aj) {
            remove = this.ac.remove(str);
        }
        return remove;
    }

    public final void b(boolean z) {
        this.S = z;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (Z == null) {
                Z = new a(context);
            }
            aVar = Z;
        }
        return aVar;
    }

    public final void b(String str, String str2) {
        if (!z.a(str) && !z.a(str2)) {
            synchronized (this.aj) {
                this.ac.put(str, str2);
            }
        } else {
            x.d("key&value should not be empty %s %s", str, str2);
        }
    }

    public final synchronized void e(String str) {
        String str2 = str;
    }

    public final void c(String str, String str2) {
        if (!z.a(str) && !z.a(str2)) {
            synchronized (this.ak) {
                this.ae.put(str, str2);
            }
        } else {
            x.d("server key&value should not be empty %s %s", str, str2);
        }
    }

    public final void a(String str) {
        this.U = str;
        c("APP_ID", str);
    }

    public final String h(String str) {
        String str2;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.aj) {
            str2 = this.ac.get(str);
        }
        return str2;
    }

    public final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.ai) {
            this.B.put(str, str2);
        }
    }

    public final void b(int i2) {
        int i3 = this.ab;
        if (i3 != 24096) {
            this.ab = 24096;
            x.a("server scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.ab));
        }
    }

    public final void a(int i2) {
        synchronized (this.al) {
            int i3 = this.aa;
            if (i3 != i2) {
                this.aa = i2;
                x.a("user scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.aa));
            }
        }
    }
}
