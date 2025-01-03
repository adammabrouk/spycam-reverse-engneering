package c.c.a.b.g.b;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class h6 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public a7 f4767c;

    /* renamed from: d, reason: collision with root package name */
    public b6 f4768d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<f6> f4769e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4770f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference<String> f4771g;

    /* renamed from: h, reason: collision with root package name */
    public final x9 f4772h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4773i;

    public h6(a5 a5Var) {
        super(a5Var);
        this.f4769e = new CopyOnWriteArraySet();
        this.f4773i = true;
        this.f4771g = new AtomicReference<>();
        this.f4772h = new x9(a5Var);
    }

    public final void A() {
        if (d().getApplicationContext() instanceof Application) {
            ((Application) d().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f4767c);
        }
    }

    public final Boolean B() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) a().a(atomicReference, 15000L, "boolean test flag value", new i6(this, atomicReference));
    }

    public final String C() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) a().a(atomicReference, 15000L, "String test flag value", new q6(this, atomicReference));
    }

    public final Long D() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) a().a(atomicReference, 15000L, "long test flag value", new v6(this, atomicReference));
    }

    public final Integer E() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) a().a(atomicReference, 15000L, "int test flag value", new u6(this, atomicReference));
    }

    public final Double G() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) a().a(atomicReference, 15000L, "double test flag value", new x6(this, atomicReference));
    }

    public final String H() {
        e();
        return this.f4771g.get();
    }

    public final void I() {
        g();
        e();
        w();
        if (this.f5160a.l()) {
            if (l().a(r.i0)) {
                b l = l();
                l.F();
                Boolean d2 = l.d("google_analytics_deferred_deep_link_enabled");
                if (d2 != null && d2.booleanValue()) {
                    c().A().a("Deferred Deep Link feature enabled.");
                    a().a(new Runnable(this) { // from class: c.c.a.b.g.b.j6

                        /* renamed from: a, reason: collision with root package name */
                        public final h6 f4836a;

                        {
                            this.f4836a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            h6 h6Var = this.f4836a;
                            h6Var.g();
                            if (h6Var.k().y.a()) {
                                h6Var.c().A().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long a2 = h6Var.k().z.a();
                            h6Var.k().z.a(1 + a2);
                            if (a2 < 5) {
                                h6Var.f5160a.m();
                            } else {
                                h6Var.c().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                h6Var.k().y.a(true);
                            }
                        }
                    });
                }
            }
            q().D();
            this.f4773i = false;
            String y = k().y();
            if (TextUtils.isEmpty(y)) {
                return;
            }
            h().n();
            if (y.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", y);
            a("auto", "_ou", bundle);
        }
    }

    public final String J() {
        m7 A = this.f5160a.D().A();
        if (A != null) {
            return A.f4936a;
        }
        return null;
    }

    public final String K() {
        m7 A = this.f5160a.D().A();
        if (A != null) {
            return A.f4937b;
        }
        return null;
    }

    public final String L() {
        if (this.f5160a.z() != null) {
            return this.f5160a.z();
        }
        try {
            return new c.c.a.b.c.o.u(d()).a("google_app_id");
        } catch (IllegalStateException e2) {
            this.f5160a.c().t().a("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    public final void M() {
        g();
        String a2 = k().s.a();
        if (a2 != null) {
            if ("unset".equals(a2)) {
                a("app", "_npa", (Object) null, b().a());
            } else {
                a("app", "_npa", Long.valueOf("true".equals(a2) ? 1L : 0L), b().a());
            }
        }
        if (!this.f5160a.g() || !this.f4773i) {
            c().A().a("Updating Scion state (FE)");
            q().B();
            return;
        }
        c().A().a("Recording app launch after enabling measurement for the first time (FE)");
        I();
        if (c.c.a.b.f.e.ca.a() && l().a(r.x0)) {
            t().f5167d.a();
        }
        if (c.c.a.b.f.e.v9.a() && l().a(r.C0)) {
            if (!(this.f5160a.s().f5060a.p().k.a() > 0)) {
                s4 s = this.f5160a.s();
                s.f5060a.i();
                s.a(s.f5060a.d().getPackageName());
            }
        }
        if (l().a(r.Q0)) {
            a().a(new y6(this));
        }
    }

    public final void a(boolean z) {
        w();
        e();
        a().a(new w6(this, z));
    }

    public final void b(boolean z) {
        w();
        e();
        a().a(new z6(this, z));
    }

    public final void c(boolean z) {
        g();
        e();
        w();
        c().A().a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        k().b(z);
        M();
    }

    public final void d(Bundle bundle) {
        g();
        w();
        c.c.a.b.c.o.r.a(bundle);
        c.c.a.b.c.o.r.b(bundle.getString("name"));
        if (!this.f5160a.g()) {
            c().B().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            q().a(new zzy(bundle.getString("app_id"), bundle.getString(OSSHeaders.ORIGIN), new zzkn(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), j().a(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString(OSSHeaders.ORIGIN), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return false;
    }

    public final void a(long j) {
        e();
        a().a(new b7(this, j));
    }

    public final void b(long j) {
        e();
        a().a(new l6(this, j));
    }

    public final void c(long j) {
        a((String) null);
        a().a(new n6(this, j));
    }

    public final void a(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, b().a());
    }

    public final void b(String str, String str2, Bundle bundle) {
        e();
        g();
        a(str, str2, b().a(), bundle);
    }

    public final void a(String str, String str2, long j, Bundle bundle) {
        e();
        g();
        a(str, str2, j, bundle, true, this.f4768d == null || s9.i(str2), false, null);
    }

    public final void c(String str, String str2, Bundle bundle) {
        e();
        b((String) null, str, str2, bundle);
    }

    public final void b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        a().a(new k6(this, str, str2, j, s9.b(bundle), z, z2, z3, str3));
    }

    public final void c(Bundle bundle) {
        g();
        w();
        c.c.a.b.c.o.r.a(bundle);
        c.c.a.b.c.o.r.b(bundle.getString("name"));
        c.c.a.b.c.o.r.b(bundle.getString(OSSHeaders.ORIGIN));
        c.c.a.b.c.o.r.a(bundle.get("value"));
        if (!this.f5160a.g()) {
            c().B().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkn zzknVar = new zzkn(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString(OSSHeaders.ORIGIN));
        try {
            zzaq a2 = j().a(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString(OSSHeaders.ORIGIN), 0L, true, false);
            q().a(new zzy(bundle.getString("app_id"), bundle.getString(OSSHeaders.ORIGIN), zzknVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), j().a(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString(OSSHeaders.ORIGIN), 0L, true, false), bundle.getLong("trigger_timeout"), a2, bundle.getLong("time_to_live"), j().a(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString(OSSHeaders.ORIGIN), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 1473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.h6.a(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void b(f6 f6Var) {
        e();
        w();
        c.c.a.b.c.o.r.a(f6Var);
        if (this.f4769e.remove(f6Var)) {
            return;
        }
        c().w().a("OnEventListener had not been registered");
    }

    public final void b(Bundle bundle) {
        c.c.a.b.c.o.r.a(bundle);
        c.c.a.b.c.o.r.b(bundle.getString("app_id"));
        m();
        throw null;
    }

    public final void b(Bundle bundle, long j) {
        c.c.a.b.c.o.r.a(bundle);
        x5.a(bundle, "app_id", String.class, null);
        x5.a(bundle, OSSHeaders.ORIGIN, String.class, null);
        x5.a(bundle, "name", String.class, null);
        x5.a(bundle, "value", Object.class, null);
        x5.a(bundle, "trigger_event_name", String.class, null);
        x5.a(bundle, "trigger_timeout", Long.class, 0L);
        x5.a(bundle, "timed_out_event_name", String.class, null);
        x5.a(bundle, "timed_out_event_params", Bundle.class, null);
        x5.a(bundle, "triggered_event_name", String.class, null);
        x5.a(bundle, "triggered_event_params", Bundle.class, null);
        x5.a(bundle, "time_to_live", Long.class, 0L);
        x5.a(bundle, "expired_event_name", String.class, null);
        x5.a(bundle, "expired_event_params", Bundle.class, null);
        c.c.a.b.c.o.r.b(bundle.getString("name"));
        c.c.a.b.c.o.r.b(bundle.getString(OSSHeaders.ORIGIN));
        c.c.a.b.c.o.r.a(bundle.get("value"));
        bundle.putLong("creation_timestamp", j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (j().b(string) != 0) {
            c().t().a("Invalid conditional user property name", i().c(string));
            return;
        }
        if (j().b(string, obj) != 0) {
            c().t().a("Invalid conditional user property value", i().c(string), obj);
            return;
        }
        Object c2 = j().c(string, obj);
        if (c2 == null) {
            c().t().a("Unable to normalize conditional user property value", i().c(string), obj);
            return;
        }
        x5.a(bundle, c2);
        long j2 = bundle.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            c().t().a("Invalid conditional user property timeout", i().c(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle.getLong("time_to_live");
        if (j3 <= 15552000000L && j3 >= 1) {
            a().a(new o6(this, bundle));
        } else {
            c().t().a("Invalid conditional user property time to live", i().c(string), Long.valueOf(j3));
        }
    }

    public final void b(String str, String str2, String str3, Bundle bundle) {
        long a2 = b().a();
        c.c.a.b.c.o.r.b(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", a2);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        a().a(new r6(this, bundle2));
    }

    public final ArrayList<Bundle> b(String str, String str2, String str3) {
        if (a().s()) {
            c().t().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (fa.a()) {
            c().t().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f5160a.a().a(atomicReference, 5000L, "get conditional user properties", new t6(this, atomicReference, str, str2, str3));
        List list = (List) atomicReference.get();
        if (list == null) {
            c().t().a("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
        return s9.b((List<zzy>) list);
    }

    public final Map<String, Object> b(String str, String str2, String str3, boolean z) {
        if (a().s()) {
            c().t().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (fa.a()) {
            c().t().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f5160a.a().a(atomicReference, 5000L, "get user properties", new s6(this, atomicReference, str, str2, str3, z));
        List<zzkn> list = (List) atomicReference.get();
        if (list == null) {
            c().t().a("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        a.e.a aVar = new a.e.a(list.size());
        for (zzkn zzknVar : list) {
            aVar.put(zzknVar.f10212b, zzknVar.zza());
        }
        return aVar;
    }

    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        e();
        b(str == null ? "app" : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.f4768d == null || s9.i(str2), !z, null);
    }

    public final void a(String str, String str2, Object obj, boolean z) {
        a(str, str2, obj, z, b().a());
    }

    public final void a(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 6;
        if (z) {
            i2 = j().b(str2);
        } else {
            s9 j2 = j();
            if (j2.a("user property", str2)) {
                if (!j2.a("user property", c6.f4631a, str2)) {
                    i2 = 15;
                } else if (j2.a("user property", 24, str2)) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            j();
            this.f5160a.v().a(i2, "_ev", s9.a(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int b2 = j().b(str2, obj);
            if (b2 != 0) {
                j();
                this.f5160a.v().a(b2, "_ev", s9.a(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object c2 = j().c(str2, obj);
                if (c2 != null) {
                    a(str3, str2, j, c2);
                    return;
                }
                return;
            }
        }
        a(str3, str2, j, (Object) null);
    }

    public final void a(String str, String str2, long j, Object obj) {
        a().a(new m6(this, str, str2, obj, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            c.c.a.b.c.o.r.b(r9)
            c.c.a.b.c.o.r.b(r10)
            r8.g()
            r8.e()
            r8.w()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L63
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L53
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L38
            r4 = r2
            goto L3a
        L38:
            r4 = 0
        L3a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            c.c.a.b.g.b.j4 r0 = r8.k()
            c.c.a.b.g.b.p4 r0 = r0.s
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4e
            java.lang.String r11 = "true"
        L4e:
            r0.a(r11)
            r6 = r10
            goto L61
        L53:
            if (r11 != 0) goto L63
            c.c.a.b.g.b.j4 r10 = r8.k()
            c.c.a.b.g.b.p4 r10 = r10.s
            java.lang.String r0 = "unset"
            r10.a(r0)
            r6 = r11
        L61:
            r3 = r1
            goto L65
        L63:
            r3 = r10
            r6 = r11
        L65:
            c.c.a.b.g.b.a5 r10 = r8.f5160a
            boolean r10 = r10.g()
            if (r10 != 0) goto L7b
            c.c.a.b.g.b.w3 r9 = r8.c()
            c.c.a.b.g.b.y3 r9 = r9.B()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7b:
            c.c.a.b.g.b.a5 r10 = r8.f5160a
            boolean r10 = r10.l()
            if (r10 != 0) goto L84
            return
        L84:
            com.google.android.gms.measurement.internal.zzkn r10 = new com.google.android.gms.measurement.internal.zzkn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            c.c.a.b.g.b.r7 r9 = r8.q()
            r9.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.h6.a(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void a(String str) {
        this.f4771g.set(str);
    }

    public final void a(b6 b6Var) {
        b6 b6Var2;
        g();
        e();
        w();
        if (b6Var != null && b6Var != (b6Var2 = this.f4768d)) {
            c.c.a.b.c.o.r.b(b6Var2 == null, "EventInterceptor already set.");
        }
        this.f4768d = b6Var;
    }

    public final void a(f6 f6Var) {
        e();
        w();
        c.c.a.b.c.o.r.a(f6Var);
        if (this.f4769e.add(f6Var)) {
            return;
        }
        c().w().a("OnEventListener already registered");
    }

    public final void a(Bundle bundle) {
        a(bundle, b().a());
    }

    public final void a(Bundle bundle, long j) {
        c.c.a.b.c.o.r.a(bundle);
        e();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            c().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        b(bundle2, j);
    }

    public final void a(String str, String str2, String str3, Bundle bundle) {
        c.c.a.b.c.o.r.b(str);
        m();
        throw null;
    }

    public final ArrayList<Bundle> a(String str, String str2) {
        e();
        return b((String) null, str, str2);
    }

    public final ArrayList<Bundle> a(String str, String str2, String str3) {
        c.c.a.b.c.o.r.b(str);
        m();
        throw null;
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        e();
        return b((String) null, str, str2, z);
    }

    public final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        c.c.a.b.c.o.r.b(str);
        m();
        throw null;
    }
}
