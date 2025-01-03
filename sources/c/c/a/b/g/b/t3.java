package c.c.a.b.g.b;

import android.content.Context;
import c.c.a.b.f.e.kc;
import c.c.a.b.f.e.oa;
import com.google.android.gms.measurement.internal.zzm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t3 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public String f5084c;

    /* renamed from: d, reason: collision with root package name */
    public String f5085d;

    /* renamed from: e, reason: collision with root package name */
    public int f5086e;

    /* renamed from: f, reason: collision with root package name */
    public String f5087f;

    /* renamed from: g, reason: collision with root package name */
    public long f5088g;

    /* renamed from: h, reason: collision with root package name */
    public long f5089h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f5090i;
    public int j;
    public String k;
    public String l;
    public String m;

    public t3(a5 a5Var, long j) {
        super(a5Var);
        this.f5089h = j;
    }

    public final String A() {
        w();
        return this.f5084c;
    }

    public final String B() {
        w();
        return this.k;
    }

    public final String C() {
        w();
        return this.l;
    }

    public final String D() {
        w();
        return this.m;
    }

    public final int E() {
        w();
        return this.f5086e;
    }

    public final int G() {
        w();
        return this.j;
    }

    public final List<String> H() {
        return this.f5090i;
    }

    public final String I() {
        if (kc.a() && l().a(r.s0)) {
            c().B().a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = d().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, d());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    c().y().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                c().x().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    public final zzm a(String str) {
        boolean z;
        long min;
        g();
        e();
        String A = A();
        String B = B();
        w();
        String str2 = this.f5085d;
        long E = E();
        w();
        String str3 = this.f5087f;
        long n = l().n();
        w();
        g();
        if (this.f5088g == 0) {
            this.f5088g = this.f5160a.v().a(d(), d().getPackageName());
        }
        long j = this.f5088g;
        boolean g2 = this.f5160a.g();
        boolean z2 = !k().w;
        g();
        e();
        String I = !this.f5160a.g() ? null : I();
        a5 a5Var = this.f5160a;
        Long valueOf = Long.valueOf(a5Var.p().j.a());
        if (valueOf.longValue() == 0) {
            min = a5Var.F;
            z = g2;
        } else {
            z = g2;
            min = Math.min(a5Var.F, valueOf.longValue());
        }
        int G = G();
        boolean booleanValue = l().q().booleanValue();
        b l = l();
        l.e();
        Boolean d2 = l.d("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(d2 == null || d2.booleanValue()).booleanValue();
        j4 k = k();
        k.g();
        return new zzm(A, B, str2, E, str3, n, j, str, z, z2, I, 0L, min, G, booleanValue, booleanValue2, k.s().getBoolean("deferred_analytics_collection", false), C(), l().d("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r1.booleanValue()), this.f5089h, l().a(r.d0) ? this.f5090i : null, (oa.a() && l().a(r.p0)) ? D() : null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:0|1|(1:3)(6:104|105|(1:107)(2:122|(1:124))|108|109|(4:111|(1:113)(1:120)|115|116))|4|(1:103)(1:8)|9|(1:102)(1:13)|14|(1:(1:17)(1:18))|(3:20|21|(16:24|25|(1:27)|28|29|(1:90)(1:33)|34|(1:36)(1:89)|37|38|(2:86|(1:88))(4:42|(1:44)(1:85)|45|(1:84))|(3:50|(1:52)(1:55)|53)|56|(3:58|(3:60|(1:62)(3:64|(3:67|(1:69)(1:70)|65)|71)|63)|(1:73))|74|(1:(2:77|78)(2:80|81))(2:82|83)))|101|25|(0)|28|29|(1:31)|90|34|(0)(0)|37|38|(1:40)|86|(0)|(0)|56|(0)|74|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x024b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x024c, code lost:
    
        c().t().a("Fetching Google App Id failed with exception. appId", c.c.a.b.g.b.w3.a(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01ac A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01df A[Catch: IllegalStateException -> 0x024b, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022e A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021d A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d4  */
    @Override // c.c.a.b.g.b.c3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u() {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.t3.u():void");
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return true;
    }
}
