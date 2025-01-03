package c.c.a.b.g.b;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import c.c.a.b.a.a.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j4 extends v5 {
    public static final Pair<String, Long> E = new Pair<>("", 0L);
    public final p4 A;
    public final p4 B;
    public final n4 C;
    public final o4 D;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f4825c;

    /* renamed from: d, reason: collision with root package name */
    public q4 f4826d;

    /* renamed from: e, reason: collision with root package name */
    public final n4 f4827e;

    /* renamed from: f, reason: collision with root package name */
    public final n4 f4828f;

    /* renamed from: g, reason: collision with root package name */
    public final n4 f4829g;

    /* renamed from: h, reason: collision with root package name */
    public final n4 f4830h;

    /* renamed from: i, reason: collision with root package name */
    public final n4 f4831i;
    public final n4 j;
    public final n4 k;
    public final p4 l;
    public String m;
    public boolean n;
    public long o;
    public final n4 p;
    public final n4 q;
    public final l4 r;
    public final p4 s;
    public final l4 t;
    public final l4 u;
    public final n4 v;
    public boolean w;
    public l4 x;
    public l4 y;
    public n4 z;

    public j4(a5 a5Var) {
        super(a5Var);
        this.f4827e = new n4(this, "last_upload", 0L);
        this.f4828f = new n4(this, "last_upload_attempt", 0L);
        this.f4829g = new n4(this, "backoff", 0L);
        this.f4830h = new n4(this, "last_delete_stale", 0L);
        this.p = new n4(this, "time_before_start", 10000L);
        this.q = new n4(this, "session_timeout", 1800000L);
        this.r = new l4(this, "start_new_session", true);
        this.v = new n4(this, "last_pause_time", 0L);
        this.s = new p4(this, "non_personalized_ads", null);
        this.t = new l4(this, "use_dynamite_api", false);
        this.u = new l4(this, "allow_remote_dynamite", false);
        this.f4831i = new n4(this, "midnight_offset", 0L);
        this.j = new n4(this, "first_open_time", 0L);
        this.k = new n4(this, "app_install_time", 0L);
        this.l = new p4(this, "app_instance_id", null);
        this.x = new l4(this, "app_backgrounded", false);
        this.y = new l4(this, "deep_link_retrieval_complete", false);
        this.z = new n4(this, "deep_link_retrieval_attempts", 0L);
        this.A = new p4(this, "firebase_feature_rollouts", null);
        this.B = new p4(this, "deferred_attribution_cache", null);
        this.C = new n4(this, "deferred_attribution_cache_timestamp", 0L);
        this.D = new o4(this, "default_event_parameters", null);
    }

    public final Pair<String, Boolean> a(String str) {
        g();
        long b2 = b().b();
        if (this.m != null && b2 < this.o) {
            return new Pair<>(this.m, Boolean.valueOf(this.n));
        }
        this.o = b2 + l().a(str, r.f5027b);
        c.c.a.b.a.a.a.b(true);
        try {
            a.C0082a a2 = c.c.a.b.a.a.a.a(d());
            if (a2 != null) {
                this.m = a2.a();
                this.n = a2.b();
            }
            if (this.m == null) {
                this.m = "";
            }
        } catch (Exception e2) {
            c().A().a("Unable to get advertising id", e2);
            this.m = "";
        }
        c.c.a.b.a.a.a.b(false);
        return new Pair<>(this.m, Boolean.valueOf(this.n));
    }

    public final String b(String str) {
        g();
        String str2 = (String) a(str).first;
        MessageDigest x = s9.x();
        if (x == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, x.digest(str2.getBytes())));
    }

    public final void c(String str) {
        g();
        SharedPreferences.Editor edit = s().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    public final void d(String str) {
        g();
        SharedPreferences.Editor edit = s().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    @Override // c.c.a.b.g.b.v5
    public final void m() {
        SharedPreferences sharedPreferences = d().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f4825c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.w = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f4825c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f4826d = new q4(this, "health_monitor", Math.max(0L, r.f5028c.a(null).longValue()));
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        return true;
    }

    public final SharedPreferences s() {
        g();
        n();
        return this.f4825c;
    }

    public final String t() {
        g();
        return s().getString("gmp_app_id", null);
    }

    public final String u() {
        g();
        return s().getString("admob_app_id", null);
    }

    public final Boolean v() {
        g();
        if (s().contains("use_service")) {
            return Boolean.valueOf(s().getBoolean("use_service", false));
        }
        return null;
    }

    public final void w() {
        g();
        Boolean x = x();
        SharedPreferences.Editor edit = s().edit();
        edit.clear();
        edit.apply();
        if (x != null) {
            b(x.booleanValue());
        }
    }

    public final Boolean x() {
        g();
        if (s().contains("measurement_enabled")) {
            return Boolean.valueOf(s().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final String y() {
        g();
        String string = s().getString("previous_os_version", null);
        h().n();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = s().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    public final boolean z() {
        return this.f4825c.contains("deferred_analytics_collection");
    }

    public final void b(boolean z) {
        g();
        SharedPreferences.Editor edit = s().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    public final void c(boolean z) {
        g();
        c().B().a("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = s().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    public final void a(boolean z) {
        g();
        SharedPreferences.Editor edit = s().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    public final boolean a(long j) {
        return j - this.q.a() > this.v.a();
    }
}
