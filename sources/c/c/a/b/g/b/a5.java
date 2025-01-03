package c.c.a.b.g.b;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzaa;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public class a5 implements y5 {
    public static volatile a5 G;
    public volatile Boolean A;
    public Boolean B;
    public Boolean C;
    public int D;
    public final long F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4572a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4573b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4574c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4575d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4576e;

    /* renamed from: f, reason: collision with root package name */
    public final fa f4577f;

    /* renamed from: g, reason: collision with root package name */
    public final b f4578g;

    /* renamed from: h, reason: collision with root package name */
    public final j4 f4579h;

    /* renamed from: i, reason: collision with root package name */
    public final w3 f4580i;
    public final x4 j;
    public final w8 k;
    public final s9 l;
    public final u3 m;
    public final c.c.a.b.c.s.e n;
    public final l7 o;
    public final h6 p;
    public final z q;
    public final g7 r;
    public s3 s;
    public r7 t;
    public l u;
    public t3 v;
    public s4 w;
    public Boolean y;
    public long z;
    public boolean x = false;
    public AtomicInteger E = new AtomicInteger(0);

    public a5(d6 d6Var) {
        Bundle bundle;
        boolean z = false;
        c.c.a.b.c.o.r.a(d6Var);
        fa faVar = new fa(d6Var.f4664a);
        this.f4577f = faVar;
        m3.f4926a = faVar;
        this.f4572a = d6Var.f4664a;
        this.f4573b = d6Var.f4665b;
        this.f4574c = d6Var.f4666c;
        this.f4575d = d6Var.f4667d;
        this.f4576e = d6Var.f4671h;
        this.A = d6Var.f4668e;
        zzaa zzaaVar = d6Var.f4670g;
        if (zzaaVar != null && (bundle = zzaaVar.f10192g) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzaaVar.f10192g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        c.c.a.b.f.e.a2.a(this.f4572a);
        c.c.a.b.c.s.e d2 = c.c.a.b.c.s.h.d();
        this.n = d2;
        Long l = d6Var.f4672i;
        this.F = l != null ? l.longValue() : d2.a();
        this.f4578g = new b(this);
        j4 j4Var = new j4(this);
        j4Var.o();
        this.f4579h = j4Var;
        w3 w3Var = new w3(this);
        w3Var.o();
        this.f4580i = w3Var;
        s9 s9Var = new s9(this);
        s9Var.o();
        this.l = s9Var;
        u3 u3Var = new u3(this);
        u3Var.o();
        this.m = u3Var;
        this.q = new z(this);
        l7 l7Var = new l7(this);
        l7Var.x();
        this.o = l7Var;
        h6 h6Var = new h6(this);
        h6Var.x();
        this.p = h6Var;
        w8 w8Var = new w8(this);
        w8Var.x();
        this.k = w8Var;
        g7 g7Var = new g7(this);
        g7Var.o();
        this.r = g7Var;
        x4 x4Var = new x4(this);
        x4Var.o();
        this.j = x4Var;
        zzaa zzaaVar2 = d6Var.f4670g;
        if (zzaaVar2 != null && zzaaVar2.f10187b != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (this.f4572a.getApplicationContext() instanceof Application) {
            h6 u = u();
            if (u.d().getApplicationContext() instanceof Application) {
                Application application = (Application) u.d().getApplicationContext();
                if (u.f4767c == null) {
                    u.f4767c = new a7(u, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(u.f4767c);
                    application.registerActivityLifecycleCallbacks(u.f4767c);
                    u.c().B().a("Registered activity lifecycle callback");
                }
            }
        } else {
            c().w().a("Application context is not an Application");
        }
        this.j.a(new c5(this, d6Var));
    }

    public final String A() {
        return this.f4574c;
    }

    public final String B() {
        return this.f4575d;
    }

    public final boolean C() {
        return this.f4576e;
    }

    public final l7 D() {
        b(this.o);
        return this.o;
    }

    public final r7 E() {
        b(this.t);
        return this.t;
    }

    @Override // c.c.a.b.g.b.y5
    public final fa F() {
        return this.f4577f;
    }

    public final l G() {
        b(this.u);
        return this.u;
    }

    public final t3 H() {
        b(this.v);
        return this.v;
    }

    public final z I() {
        z zVar = this.q;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final void a(d6 d6Var) {
        String concat;
        y3 y3Var;
        a().g();
        l lVar = new l(this);
        lVar.o();
        this.u = lVar;
        t3 t3Var = new t3(this, d6Var.f4669f);
        t3Var.x();
        this.v = t3Var;
        s3 s3Var = new s3(this);
        s3Var.x();
        this.s = s3Var;
        r7 r7Var = new r7(this);
        r7Var.x();
        this.t = r7Var;
        this.l.p();
        this.f4579h.p();
        this.w = new s4(this);
        this.v.y();
        c().z().a("App measurement initialized, version", Long.valueOf(this.f4578g.n()));
        c().z().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String A = t3Var.A();
        if (TextUtils.isEmpty(this.f4573b)) {
            if (v().d(A)) {
                y3Var = c().z();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                y3 z = c().z();
                String valueOf = String.valueOf(A);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                y3Var = z;
            }
            y3Var.a(concat);
        }
        c().A().a("Debug-level message logging enabled");
        if (this.D != this.E.get()) {
            c().t().a("Not all components initialized", Integer.valueOf(this.D), Integer.valueOf(this.E.get()));
        }
        this.x = true;
    }

    @Override // c.c.a.b.g.b.y5
    public final c.c.a.b.c.s.e b() {
        return this.n;
    }

    @Override // c.c.a.b.g.b.y5
    public final w3 c() {
        b(this.f4580i);
        return this.f4580i;
    }

    @Override // c.c.a.b.g.b.y5
    public final Context d() {
        return this.f4572a;
    }

    public final void e() {
        a().g();
        if (p().f4827e.a() == 0) {
            p().f4827e.a(this.n.a());
        }
        if (Long.valueOf(p().j.a()).longValue() == 0) {
            c().B().a("Persisting first open", Long.valueOf(this.F));
            p().j.a(this.F);
        }
        if (this.f4578g.a(r.Q0)) {
            u().f4772h.b();
        }
        if (l()) {
            if (!TextUtils.isEmpty(H().B()) || !TextUtils.isEmpty(H().C())) {
                v();
                if (s9.a(H().B(), p().t(), H().C(), p().u())) {
                    c().z().a("Rechecking which service to use due to a GMP App Id change");
                    p().w();
                    x().A();
                    this.t.H();
                    this.t.E();
                    p().j.a(this.F);
                    p().l.a(null);
                }
                p().c(H().B());
                p().d(H().C());
            }
            u().a(p().l.a());
            if (c.c.a.b.f.e.k9.a() && this.f4578g.a(r.w0) && !v().w() && !TextUtils.isEmpty(p().A.a())) {
                c().w().a("Remote config removed with active feature rollouts");
                p().A.a(null);
            }
            if (!TextUtils.isEmpty(H().B()) || !TextUtils.isEmpty(H().C())) {
                boolean g2 = g();
                if (!p().z() && !this.f4578g.p()) {
                    p().c(!g2);
                }
                if (g2) {
                    u().I();
                }
                r().f5167d.a();
                E().a(new AtomicReference<>());
            }
        } else if (g()) {
            if (!v().c("android.permission.INTERNET")) {
                c().t().a("App is missing INTERNET permission");
            }
            if (!v().c("android.permission.ACCESS_NETWORK_STATE")) {
                c().t().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!c.c.a.b.c.t.c.b(this.f4572a).a() && !this.f4578g.u()) {
                if (!t4.a(this.f4572a)) {
                    c().t().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!s9.a(this.f4572a, false)) {
                    c().t().a("AppMeasurementService not registered/enabled");
                }
            }
            c().t().a("Uploading is not possible. App measurement disabled");
        }
        p().t.a(this.f4578g.a(r.a0));
        p().u.a(this.f4578g.a(r.b0));
    }

    public final boolean f() {
        return this.A != null && this.A.booleanValue();
    }

    public final boolean g() {
        return h() == 0;
    }

    public final int h() {
        a().g();
        if (this.f4578g.p()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean x = p().x();
        if (x != null) {
            return x.booleanValue() ? 0 : 3;
        }
        b bVar = this.f4578g;
        bVar.F();
        Boolean d2 = bVar.d("firebase_analytics_collection_enabled");
        if (d2 != null) {
            return d2.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (c.c.a.b.c.l.m.c.b()) {
            return 6;
        }
        return (!this.f4578g.a(r.T) || this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    public final void i() {
    }

    public final void j() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public final void k() {
        this.E.incrementAndGet();
    }

    public final boolean l() {
        if (!this.x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        a().g();
        Boolean bool = this.y;
        if (bool == null || this.z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.n.b() - this.z) > 1000)) {
            this.z = this.n.b();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(v().c("android.permission.INTERNET") && v().c("android.permission.ACCESS_NETWORK_STATE") && (c.c.a.b.c.t.c.b(this.f4572a).a() || this.f4578g.u() || (t4.a(this.f4572a) && s9.a(this.f4572a, false))));
            this.y = valueOf;
            if (valueOf.booleanValue()) {
                if (!v().a(H().B(), H().C(), H().D()) && TextUtils.isEmpty(H().C())) {
                    z = false;
                }
                this.y = Boolean.valueOf(z);
            }
        }
        return this.y.booleanValue();
    }

    public final void m() {
        a().g();
        b(n());
        String A = H().A();
        Pair<String, Boolean> a2 = p().a(A);
        if (!this.f4578g.q().booleanValue() || ((Boolean) a2.second).booleanValue() || TextUtils.isEmpty((CharSequence) a2.first)) {
            c().A().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!n().s()) {
            c().w().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL a3 = v().a(H().l().n(), A, (String) a2.first, p().z.a() - 1);
        g7 n = n();
        f7 f7Var = new f7(this) { // from class: c.c.a.b.g.b.e5

            /* renamed from: a, reason: collision with root package name */
            public final a5 f4692a;

            {
                this.f4692a = this;
            }

            @Override // c.c.a.b.g.b.f7
            public final void a(String str, int i2, Throwable th, byte[] bArr, Map map) {
                this.f4692a.a(str, i2, th, bArr, map);
            }
        };
        n.g();
        n.n();
        c.c.a.b.c.o.r.a(a3);
        c.c.a.b.c.o.r.a(f7Var);
        n.a().b(new i7(n, A, a3, null, null, f7Var));
    }

    public final g7 n() {
        b(this.r);
        return this.r;
    }

    public final b o() {
        return this.f4578g;
    }

    public final j4 p() {
        a((w5) this.f4579h);
        return this.f4579h;
    }

    public final w3 q() {
        w3 w3Var = this.f4580i;
        if (w3Var == null || !w3Var.r()) {
            return null;
        }
        return this.f4580i;
    }

    public final w8 r() {
        b(this.k);
        return this.k;
    }

    public final s4 s() {
        return this.w;
    }

    public final x4 t() {
        return this.j;
    }

    public final h6 u() {
        b(this.p);
        return this.p;
    }

    public final s9 v() {
        a((w5) this.l);
        return this.l;
    }

    public final u3 w() {
        a((w5) this.m);
        return this.m;
    }

    public final s3 x() {
        b(this.s);
        return this.s;
    }

    public final boolean y() {
        return TextUtils.isEmpty(this.f4573b);
    }

    public final String z() {
        return this.f4573b;
    }

    public static void b(v5 v5Var) {
        if (v5Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (v5Var.r()) {
            return;
        }
        String valueOf = String.valueOf(v5Var.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    public static void b(c3 c3Var) {
        if (c3Var != null) {
            if (c3Var.v()) {
                return;
            }
            String valueOf = String.valueOf(c3Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    @Override // c.c.a.b.g.b.y5
    public final x4 a() {
        b(this.j);
        return this.j;
    }

    public static a5 a(Context context, String str, String str2, Bundle bundle) {
        return a(context, new zzaa(0L, 0L, true, null, null, null, bundle), null);
    }

    public static a5 a(Context context, zzaa zzaaVar, Long l) {
        Bundle bundle;
        if (zzaaVar != null && (zzaaVar.f10190e == null || zzaaVar.f10191f == null)) {
            zzaaVar = new zzaa(zzaaVar.f10186a, zzaaVar.f10187b, zzaaVar.f10188c, zzaaVar.f10189d, null, null, zzaaVar.f10192g);
        }
        c.c.a.b.c.o.r.a(context);
        c.c.a.b.c.o.r.a(context.getApplicationContext());
        if (G == null) {
            synchronized (a5.class) {
                if (G == null) {
                    G = new a5(new d6(context, zzaaVar, l));
                }
            }
        } else if (zzaaVar != null && (bundle = zzaaVar.f10192g) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            G.a(zzaaVar.f10192g.getBoolean("dataCollectionDefaultEnabled"));
        }
        return G;
    }

    public static void a(w5 w5Var) {
        if (w5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public final void a(boolean z) {
        this.A = Boolean.valueOf(z);
    }

    public final void a(v5 v5Var) {
        this.D++;
    }

    public final void a(c3 c3Var) {
        this.D++;
    }

    public final /* synthetic */ void a(String str, int i2, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && th == null)) {
            c().w().a("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            return;
        }
        p().y.a(true);
        if (bArr.length == 0) {
            c().A().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                c().A().a("Deferred Deep Link is empty.");
                return;
            }
            s9 v = v();
            v.e();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = v.d().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                c().w().a("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.p.a("auto", "_cmp", bundle);
            s9 v2 = v();
            if (TextUtils.isEmpty(optString) || !v2.a(optString, optDouble)) {
                return;
            }
            v2.d().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e2) {
            c().t().a("Failed to parse the Deferred Deep Link response. exception", e2);
        }
    }
}
