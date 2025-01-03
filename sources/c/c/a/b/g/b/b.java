package c.c.a.b.g.b;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.f.e.fb;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b extends w5 {

    /* renamed from: b, reason: collision with root package name */
    public Boolean f4594b;

    /* renamed from: c, reason: collision with root package name */
    public d f4595c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f4596d;

    public b(a5 a5Var) {
        super(a5Var);
        this.f4595c = ia.f4816a;
    }

    public static long w() {
        return r.D.a(null).longValue();
    }

    public static long x() {
        return r.f5029d.a(null).longValue();
    }

    public final void a(d dVar) {
        this.f4595c = dVar;
    }

    public final int b(String str) {
        return b(str, r.o);
    }

    public final int c(String str) {
        if (c.c.a.b.f.e.x8.a() && d(null, r.L0)) {
            return a(str, r.G, 25, 100);
        }
        return 25;
    }

    public final boolean d(String str, p3<Boolean> p3Var) {
        if (str == null) {
            return p3Var.a(null).booleanValue();
        }
        String a2 = this.f4595c.a(str, p3Var.a());
        return TextUtils.isEmpty(a2) ? p3Var.a(null).booleanValue() : p3Var.a(Boolean.valueOf(Boolean.parseBoolean(a2))).booleanValue();
    }

    public final boolean e(String str, p3<Boolean> p3Var) {
        return d(str, p3Var);
    }

    public final boolean f(String str) {
        return "1".equals(this.f4595c.a(str, "gaia_collection_enabled"));
    }

    public final boolean g(String str) {
        return "1".equals(this.f4595c.a(str, "measurement.event_sampling_enabled"));
    }

    public final boolean h(String str) {
        return d(str, r.K);
    }

    public final String i(String str) {
        p3<String> p3Var = r.L;
        return str == null ? p3Var.a(null) : p3Var.a(this.f4595c.a(str, p3Var.a()));
    }

    public final int m() {
        return (c.c.a.b.f.e.x8.a() && l().d(null, r.M0) && j().u() >= 2147483) ? 100 : 25;
    }

    public final long n() {
        F();
        return 27000L;
    }

    public final boolean o() {
        if (this.f4596d == null) {
            synchronized (this) {
                if (this.f4596d == null) {
                    ApplicationInfo applicationInfo = d().getApplicationInfo();
                    String a2 = c.c.a.b.c.s.o.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f4596d = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if (this.f4596d == null) {
                        this.f4596d = Boolean.TRUE;
                        c().t().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f4596d.booleanValue();
    }

    public final boolean p() {
        F();
        Boolean d2 = d("firebase_analytics_collection_deactivated");
        return d2 != null && d2.booleanValue();
    }

    public final Boolean q() {
        e();
        Boolean d2 = d("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(d2 == null || d2.booleanValue());
    }

    public final Boolean r() {
        e();
        boolean z = true;
        if (!fb.a() || !a(r.D0)) {
            return true;
        }
        Boolean d2 = d("google_analytics_automatic_screen_reporting_enabled");
        if (d2 != null && !d2.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final String s() {
        return a("debug.firebase.analytics.app", "");
    }

    public final String t() {
        return a("debug.deferred.deeplink", "");
    }

    public final boolean u() {
        if (this.f4594b == null) {
            Boolean d2 = d("app_measurement_lite");
            this.f4594b = d2;
            if (d2 == null) {
                this.f4594b = false;
            }
        }
        return this.f4594b.booleanValue() || !this.f5160a.C();
    }

    public final Bundle v() {
        try {
            if (d().getPackageManager() == null) {
                c().t().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = c.c.a.b.c.t.c.b(d()).a(d().getPackageName(), RecyclerView.c0.FLAG_IGNORE);
            if (a2 != null) {
                return a2.metaData;
            }
            c().t().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            c().t().a("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    public final int a(String str) {
        if (c.c.a.b.f.e.x8.a() && d(null, r.L0)) {
            return a(str, r.H, 500, RecyclerView.MAX_SCROLL_DURATION);
        }
        return 500;
    }

    public final int b(String str, p3<Integer> p3Var) {
        if (str == null) {
            return p3Var.a(null).intValue();
        }
        String a2 = this.f4595c.a(str, p3Var.a());
        if (TextUtils.isEmpty(a2)) {
            return p3Var.a(null).intValue();
        }
        try {
            return p3Var.a(Integer.valueOf(Integer.parseInt(a2))).intValue();
        } catch (NumberFormatException unused) {
            return p3Var.a(null).intValue();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> e(java.lang.String r4) {
        /*
            r3 = this;
            c.c.a.b.c.o.r.b(r4)
            android.os.Bundle r0 = r3.v()
            r1 = 0
            if (r0 != 0) goto L19
            c.c.a.b.g.b.w3 r4 = r3.c()
            c.c.a.b.g.b.y3 r4 = r4.t()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.d()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            c.c.a.b.g.b.w3 r0 = r3.c()
            c.c.a.b.g.b.y3 r0 = r0.t()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.a(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.b.e(java.lang.String):java.util.List");
    }

    public final double c(String str, p3<Double> p3Var) {
        if (str == null) {
            return p3Var.a(null).doubleValue();
        }
        String a2 = this.f4595c.a(str, p3Var.a());
        if (TextUtils.isEmpty(a2)) {
            return p3Var.a(null).doubleValue();
        }
        try {
            return p3Var.a(Double.valueOf(Double.parseDouble(a2))).doubleValue();
        } catch (NumberFormatException unused) {
            return p3Var.a(null).doubleValue();
        }
    }

    public final long a(String str, p3<Long> p3Var) {
        if (str == null) {
            return p3Var.a(null).longValue();
        }
        String a2 = this.f4595c.a(str, p3Var.a());
        if (TextUtils.isEmpty(a2)) {
            return p3Var.a(null).longValue();
        }
        try {
            return p3Var.a(Long.valueOf(Long.parseLong(a2))).longValue();
        } catch (NumberFormatException unused) {
            return p3Var.a(null).longValue();
        }
    }

    public final Boolean d(String str) {
        c.c.a.b.c.o.r.b(str);
        Bundle v = v();
        if (v == null) {
            c().t().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (v.containsKey(str)) {
            return Boolean.valueOf(v.getBoolean(str));
        }
        return null;
    }

    public final int a(String str, p3<Integer> p3Var, int i2, int i3) {
        return Math.max(Math.min(b(str, p3Var), i3), i2);
    }

    public final boolean a(p3<Boolean> p3Var) {
        return d(null, p3Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(c.c.a.b.g.b.d5 r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.n()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = c.c.a.b.f.e.oa.a()
            if (r1 == 0) goto L2f
            c.c.a.b.g.b.b r1 = r5.l()
            java.lang.String r2 = r6.l()
            c.c.a.b.g.b.p3<java.lang.Boolean> r3 = c.c.a.b.g.b.r.p0
            boolean r1 = r1.d(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.p()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.o()
        L33:
            c.c.a.b.g.b.p3<java.lang.String> r2 = c.c.a.b.g.b.r.f5030e
            r3 = 0
            java.lang.Object r2 = r2.a(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            c.c.a.b.g.b.p3<java.lang.String> r4 = c.c.a.b.g.b.r.f5031f
            java.lang.Object r3 = r4.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.m()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.n()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.b.a(c.c.a.b.g.b.d5):java.lang.String");
    }

    public final String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e2) {
            c().t().a("Could not find SystemProperties class", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            c().t().a("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (NoSuchMethodException e4) {
            c().t().a("Could not find SystemProperties.get() method", e4);
            return str2;
        } catch (InvocationTargetException e5) {
            c().t().a("SystemProperties.get() threw an exception", e5);
            return str2;
        }
    }
}
