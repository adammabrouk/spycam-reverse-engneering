package c.c.a.b.g.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import c.c.a.b.f.e.q0;
import c.c.a.b.f.e.r0;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class v4 extends i9 implements d {
    public static int j = 65535;
    public static int k = 2;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, String>> f5135d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f5136e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f5137f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<String, c.c.a.b.f.e.r0> f5138g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<String, Map<String, Integer>> f5139h;

    /* renamed from: i, reason: collision with root package name */
    public final Map<String, String> f5140i;

    public v4(l9 l9Var) {
        super(l9Var);
        this.f5135d = new a.e.a();
        this.f5136e = new a.e.a();
        this.f5137f = new a.e.a();
        this.f5138g = new a.e.a();
        this.f5140i = new a.e.a();
        this.f5139h = new a.e.a();
    }

    public final c.c.a.b.f.e.r0 a(String str) {
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        i(str);
        return this.f5138g.get(str);
    }

    public final String b(String str) {
        g();
        return this.f5140i.get(str);
    }

    public final void c(String str) {
        g();
        this.f5140i.put(str, null);
    }

    public final void d(String str) {
        g();
        this.f5138g.remove(str);
    }

    public final boolean e(String str) {
        g();
        c.c.a.b.f.e.r0 a2 = a(str);
        if (a2 == null) {
            return false;
        }
        return a2.t();
    }

    public final long f(String str) {
        String a2 = a(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(a2)) {
            return 0L;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException e2) {
            c().w().a("Unable to parse timezone offset. appId", w3.a(str), e2);
            return 0L;
        }
    }

    public final boolean g(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean h(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_public"));
    }

    public final void i(String str) {
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        if (this.f5138g.get(str) == null) {
            byte[] d2 = n().d(str);
            if (d2 != null) {
                r0.a j2 = a(str, d2).j();
                a(str, j2);
                this.f5135d.put(str, a((c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F())));
                this.f5138g.put(str, (c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F()));
                this.f5140i.put(str, null);
                return;
            }
            this.f5135d.put(str, null);
            this.f5136e.put(str, null);
            this.f5137f.put(str, null);
            this.f5138g.put(str, null);
            this.f5140i.put(str, null);
            this.f5139h.put(str, null);
        }
    }

    @Override // c.c.a.b.g.b.i9
    public final boolean s() {
        return false;
    }

    public final boolean b(String str, String str2) {
        Boolean bool;
        g();
        i(str);
        if (g(str) && s9.i(str2)) {
            return true;
        }
        if (h(str) && s9.h(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f5136e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean c(String str, String str2) {
        Boolean bool;
        g();
        i(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        if (c.c.a.b.f.e.d9.a() && l().a(r.K0) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map<String, Boolean> map = this.f5137f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int d(String str, String str2) {
        Integer num;
        g();
        i(str);
        Map<String, Integer> map = this.f5139h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // c.c.a.b.g.b.d
    public final String a(String str, String str2) {
        g();
        i(str);
        Map<String, String> map = this.f5135d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public static Map<String, String> a(c.c.a.b.f.e.r0 r0Var) {
        a.e.a aVar = new a.e.a();
        if (r0Var != null) {
            for (c.c.a.b.f.e.s0 s0Var : r0Var.q()) {
                aVar.put(s0Var.zza(), s0Var.n());
            }
        }
        return aVar;
    }

    public final void a(String str, r0.a aVar) {
        a.e.a aVar2 = new a.e.a();
        a.e.a aVar3 = new a.e.a();
        a.e.a aVar4 = new a.e.a();
        if (aVar != null) {
            for (int i2 = 0; i2 < aVar.zza(); i2++) {
                q0.a j2 = aVar.a(i2).j();
                if (TextUtils.isEmpty(j2.zza())) {
                    c().w().a("EventConfig contained null event name");
                } else {
                    String a2 = a6.a(j2.zza());
                    if (!TextUtils.isEmpty(a2)) {
                        j2.a(a2);
                        aVar.a(i2, j2);
                    }
                    aVar2.put(j2.zza(), Boolean.valueOf(j2.j()));
                    aVar3.put(j2.zza(), Boolean.valueOf(j2.k()));
                    if (j2.l()) {
                        if (j2.m() >= k && j2.m() <= j) {
                            aVar4.put(j2.zza(), Integer.valueOf(j2.m()));
                        } else {
                            c().w().a("Invalid sampling rate. Event name, sample rate", j2.zza(), Integer.valueOf(j2.m()));
                        }
                    }
                }
            }
        }
        this.f5136e.put(str, aVar2);
        this.f5137f.put(str, aVar3);
        this.f5139h.put(str, aVar4);
    }

    public final boolean a(String str, byte[] bArr, String str2) {
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        r0.a j2 = a(str, bArr).j();
        if (j2 == null) {
            return false;
        }
        a(str, j2);
        this.f5138g.put(str, (c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F()));
        this.f5140i.put(str, str2);
        this.f5135d.put(str, a((c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F())));
        n().a(str, new ArrayList(j2.j()));
        try {
            j2.k();
            bArr = ((c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F())).g();
        } catch (RuntimeException e2) {
            c().w().a("Unable to serialize reduced-size config. Storing full config instead. appId", w3.a(str), e2);
        }
        c n = n();
        c.c.a.b.c.o.r.b(str);
        n.g();
        n.q();
        new ContentValues().put("remote_config", bArr);
        try {
            if (n.u().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                n.c().t().a("Failed to update remote config (got 0). appId", w3.a(str));
            }
        } catch (SQLiteException e3) {
            n.c().t().a("Error storing remote config. appId", w3.a(str), e3);
        }
        this.f5138g.put(str, (c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) j2.F()));
        return true;
    }

    public final c.c.a.b.f.e.r0 a(String str, byte[] bArr) {
        if (bArr == null) {
            return c.c.a.b.f.e.r0.w();
        }
        try {
            r0.a v = c.c.a.b.f.e.r0.v();
            p9.a(v, bArr);
            c.c.a.b.f.e.r0 r0Var = (c.c.a.b.f.e.r0) ((c.c.a.b.f.e.s4) v.F());
            c().B().a("Parsed config. version, gmp_app_id", r0Var.zza() ? Long.valueOf(r0Var.n()) : null, r0Var.o() ? r0Var.p() : null);
            return r0Var;
        } catch (c.c.a.b.f.e.c5 e2) {
            c().w().a("Unable to merge remote config. appId", w3.a(str), e2);
            return c.c.a.b.f.e.r0.w();
        } catch (RuntimeException e3) {
            c().w().a("Unable to merge remote config. appId", w3.a(str), e3);
            return c.c.a.b.f.e.r0.w();
        }
    }
}
