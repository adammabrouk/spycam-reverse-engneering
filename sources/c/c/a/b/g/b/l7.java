package c.c.a.b.g.b;

import android.app.Activity;
import android.os.Bundle;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l7 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public volatile m7 f4892c;

    /* renamed from: d, reason: collision with root package name */
    public m7 f4893d;

    /* renamed from: e, reason: collision with root package name */
    public m7 f4894e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Activity, m7> f4895f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f4896g;

    /* renamed from: h, reason: collision with root package name */
    public volatile m7 f4897h;

    /* renamed from: i, reason: collision with root package name */
    public m7 f4898i;
    public final Object j;
    public String k;

    public l7(a5 a5Var) {
        super(a5Var);
        this.j = new Object();
        this.f4895f = new ConcurrentHashMap();
    }

    public final m7 A() {
        e();
        return this.f4892c;
    }

    public final m7 a(boolean z) {
        w();
        g();
        if (!l().a(r.E0) || !z) {
            return this.f4894e;
        }
        m7 m7Var = this.f4894e;
        return m7Var != null ? m7Var : this.f4898i;
    }

    public final void b(Activity activity) {
        if (l().a(r.E0)) {
            synchronized (this.j) {
            }
        }
        if (l().a(r.D0) && !l().r().booleanValue()) {
            this.f4892c = null;
            a().a(new q7(this));
            return;
        }
        m7 d2 = d(activity);
        this.f4893d = this.f4892c;
        this.f4892c = null;
        a().a(new p7(this, d2, b().b()));
    }

    public final void c(Activity activity) {
        synchronized (this.j) {
            if (activity == this.f4896g) {
                this.f4896g = null;
            }
        }
        if (l().r().booleanValue()) {
            this.f4895f.remove(activity);
        }
    }

    public final m7 d(Activity activity) {
        c.c.a.b.c.o.r.a(activity);
        m7 m7Var = this.f4895f.get(activity);
        if (m7Var == null) {
            m7 m7Var2 = new m7(null, a(activity.getClass().getCanonicalName()), j().s());
            this.f4895f.put(activity, m7Var2);
            m7Var = m7Var2;
        }
        if (!l().a(r.E0)) {
        }
        return m7Var;
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return false;
    }

    public final void a(Activity activity, String str, String str2) {
        if (!l().r().booleanValue()) {
            c().y().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.f4892c == null) {
            c().y().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f4895f.get(activity) == null) {
            c().y().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = a(activity.getClass().getCanonicalName());
        }
        boolean c2 = s9.c(this.f4892c.f4937b, str2);
        boolean c3 = s9.c(this.f4892c.f4936a, str);
        if (c2 && c3) {
            c().y().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            c().y().a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            c().y().a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        c().B().a("Setting current screen to name, class", str == null ? LogUtils.NULL : str, str2);
        m7 m7Var = new m7(str, str2, j().s());
        this.f4895f.put(activity, m7Var);
        a(activity, m7Var, true);
    }

    public final void b(Activity activity, Bundle bundle) {
        m7 m7Var;
        if (!l().r().booleanValue() || bundle == null || (m7Var = this.f4895f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", m7Var.f4938c);
        bundle2.putString("name", m7Var.f4936a);
        bundle2.putString("referrer_name", m7Var.f4937b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void a(Activity activity, m7 m7Var, boolean z) {
        m7 m7Var2;
        m7 m7Var3 = this.f4892c == null ? this.f4893d : this.f4892c;
        if (m7Var.f4937b == null) {
            m7Var2 = new m7(m7Var.f4936a, activity != null ? a(activity.getClass().getCanonicalName()) : null, m7Var.f4938c, m7Var.f4940e);
        } else {
            m7Var2 = m7Var;
        }
        this.f4893d = this.f4892c;
        this.f4892c = m7Var2;
        a().a(new o7(this, m7Var2, m7Var3, b().b(), z));
    }

    public final void a(m7 m7Var, m7 m7Var2, long j, boolean z, Bundle bundle) {
        boolean z2;
        m7 m7Var3;
        long b2;
        g();
        if (l().a(r.U)) {
            z2 = z && this.f4894e != null;
            if (z2) {
                a(this.f4894e, true, j);
            }
        } else {
            if (z && (m7Var3 = this.f4894e) != null) {
                a(m7Var3, true, j);
            }
            z2 = false;
        }
        if ((m7Var2 != null && m7Var2.f4938c == m7Var.f4938c && s9.c(m7Var2.f4937b, m7Var.f4937b) && s9.c(m7Var2.f4936a, m7Var.f4936a)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (l().a(r.E0)) {
                bundle2 = new Bundle();
            }
            a(m7Var, bundle2, true);
            if (m7Var2 != null) {
                String str = m7Var2.f4936a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = m7Var2.f4937b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", m7Var2.f4938c);
            }
            if (l().a(r.U) && z2) {
                if (c.c.a.b.f.e.ha.a() && l().a(r.W) && c.c.a.b.f.e.w9.a() && l().a(r.B0)) {
                    b2 = t().f5168e.c(j);
                } else {
                    b2 = t().f5168e.b();
                }
                if (b2 > 0) {
                    j().a(bundle2, b2);
                }
            }
            String str3 = "auto";
            if (l().a(r.E0)) {
                if (!l().r().booleanValue()) {
                    bundle2.putLong("_mt", 1L);
                }
                if (m7Var.f4940e) {
                    str3 = "app";
                }
            }
            o().b(str3, "_vs", bundle2);
        }
        this.f4894e = m7Var;
        if (l().a(r.E0) && m7Var.f4940e) {
            this.f4898i = m7Var;
        }
        q().a(m7Var);
    }

    public final void a(m7 m7Var, boolean z, long j) {
        n().a(b().b());
        if (!t().a(m7Var != null && m7Var.f4939d, z, j) || m7Var == null) {
            return;
        }
        m7Var.f4939d = false;
    }

    public static void a(m7 m7Var, Bundle bundle, boolean z) {
        if (bundle == null || m7Var == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && m7Var == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = m7Var.f4936a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = m7Var.f4937b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", m7Var.f4938c);
    }

    public final void a(String str, m7 m7Var) {
        g();
        synchronized (this) {
            if (this.k == null || this.k.equals(str) || m7Var != null) {
                this.k = str;
            }
        }
    }

    public static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    public final void a(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!l().r().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f4895f.put(activity, new m7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void a(Activity activity) {
        if (l().a(r.E0)) {
            synchronized (this.j) {
                if (activity != this.f4896g) {
                    synchronized (this.j) {
                        this.f4896g = activity;
                    }
                    if (l().a(r.D0) && l().r().booleanValue()) {
                        this.f4897h = null;
                        a().a(new s7(this));
                    }
                }
            }
        }
        if (l().a(r.D0) && !l().r().booleanValue()) {
            this.f4892c = this.f4897h;
            a().a(new n7(this));
        } else {
            a(activity, d(activity), false);
            z n = n();
            n.a().a(new a1(n, n.b().b()));
        }
    }

    public static /* synthetic */ m7 a(l7 l7Var, m7 m7Var) {
        l7Var.f4898i = null;
        return null;
    }
}
