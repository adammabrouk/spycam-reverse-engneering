package c.c.a.b.f.e;

import cn.jiguang.internal.JConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u8 implements v8 {
    public static final a2<Long> A;
    public static final a2<Long> B;
    public static final a2<Long> C;
    public static final a2<Long> D;
    public static final a2<Long> E;
    public static final a2<String> F;
    public static final a2<Long> G;

    /* renamed from: a, reason: collision with root package name */
    public static final a2<Long> f4468a;

    /* renamed from: b, reason: collision with root package name */
    public static final a2<Long> f4469b;

    /* renamed from: c, reason: collision with root package name */
    public static final a2<String> f4470c;

    /* renamed from: d, reason: collision with root package name */
    public static final a2<String> f4471d;

    /* renamed from: e, reason: collision with root package name */
    public static final a2<Long> f4472e;

    /* renamed from: f, reason: collision with root package name */
    public static final a2<Long> f4473f;

    /* renamed from: g, reason: collision with root package name */
    public static final a2<Long> f4474g;

    /* renamed from: h, reason: collision with root package name */
    public static final a2<Long> f4475h;

    /* renamed from: i, reason: collision with root package name */
    public static final a2<Long> f4476i;
    public static final a2<Long> j;
    public static final a2<Long> k;
    public static final a2<Long> l;
    public static final a2<Long> m;
    public static final a2<Long> n;
    public static final a2<Long> o;
    public static final a2<Long> p;
    public static final a2<Long> q;
    public static final a2<Long> r;
    public static final a2<Long> s;
    public static final a2<Long> t;
    public static final a2<Long> u;
    public static final a2<Long> v;
    public static final a2<Long> w;
    public static final a2<Long> x;
    public static final a2<Long> y;
    public static final a2<Long> z;

    static {
        g2 g2Var = new g2(b2.a("com.google.android.gms.measurement"));
        f4468a = g2Var.a("measurement.ad_id_cache_time", 10000L);
        f4469b = g2Var.a("measurement.config.cache_time", JConstants.DAY);
        g2Var.a("measurement.log_tag", "FA");
        f4470c = g2Var.a("measurement.config.url_authority", "app-measurement.com");
        f4471d = g2Var.a("measurement.config.url_scheme", "https");
        f4472e = g2Var.a("measurement.upload.debug_upload_interval", 1000L);
        f4473f = g2Var.a("measurement.lifetimevalue.max_currency_tracked", 4L);
        f4474g = g2Var.a("measurement.store.max_stored_events_per_app", 100000L);
        f4475h = g2Var.a("measurement.experiment.max_ids", 50L);
        f4476i = g2Var.a("measurement.audience.filter_result_max_count", 200L);
        j = g2Var.a("measurement.alarm_manager.minimum_interval", JConstants.MIN);
        k = g2Var.a("measurement.upload.minimum_delay", 500L);
        l = g2Var.a("measurement.monitoring.sample_period_millis", JConstants.DAY);
        m = g2Var.a("measurement.upload.realtime_upload_interval", 10000L);
        n = g2Var.a("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        g2Var.a("measurement.config.cache_time.service", JConstants.HOUR);
        o = g2Var.a("measurement.service_client.idle_disconnect_millis", 5000L);
        g2Var.a("measurement.log_tag.service", "FA-SVC");
        p = g2Var.a("measurement.upload.stale_data_deletion_interval", JConstants.DAY);
        q = g2Var.a("measurement.upload.backoff_period", 43200000L);
        r = g2Var.a("measurement.upload.initial_upload_delay_time", 15000L);
        s = g2Var.a("measurement.upload.interval", JConstants.HOUR);
        t = g2Var.a("measurement.upload.max_bundle_size", 65536L);
        u = g2Var.a("measurement.upload.max_bundles", 100L);
        v = g2Var.a("measurement.upload.max_conversions_per_day", 500L);
        w = g2Var.a("measurement.upload.max_error_events_per_day", 1000L);
        x = g2Var.a("measurement.upload.max_events_per_bundle", 1000L);
        y = g2Var.a("measurement.upload.max_events_per_day", 100000L);
        z = g2Var.a("measurement.upload.max_public_events_per_day", 50000L);
        A = g2Var.a("measurement.upload.max_queue_time", 2419200000L);
        B = g2Var.a("measurement.upload.max_realtime_events_per_day", 10L);
        C = g2Var.a("measurement.upload.max_batch_size", 65536L);
        D = g2Var.a("measurement.upload.retry_count", 6L);
        E = g2Var.a("measurement.upload.retry_time", 1800000L);
        F = g2Var.a("measurement.upload.url", "https://app-measurement.com/a");
        G = g2Var.a("measurement.upload.window_interval", JConstants.HOUR);
    }

    @Override // c.c.a.b.f.e.v8
    public final String C() {
        return f4470c.b();
    }

    @Override // c.c.a.b.f.e.v8
    public final String D() {
        return f4471d.b();
    }

    @Override // c.c.a.b.f.e.v8
    public final long E() {
        return f4472e.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long F() {
        return u.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long H() {
        return t.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long a() {
        return q.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long b() {
        return m.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long c() {
        return r.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long d() {
        return n.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long e() {
        return f4473f.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long f() {
        return f4474g.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long g() {
        return p.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long h() {
        return l.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long i() {
        return C.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long j() {
        return y.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long k() {
        return f4475h.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long l() {
        return G.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long m() {
        return z.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long n() {
        return v.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long o() {
        return f4476i.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long p() {
        return D.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long q() {
        return j.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long r() {
        return A.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long s() {
        return w.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long t() {
        return E.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long u() {
        return s.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long v() {
        return o.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long w() {
        return k.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long x() {
        return B.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long y() {
        return x.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final String z() {
        return F.b();
    }

    @Override // c.c.a.b.f.e.v8
    public final long zza() {
        return f4468a.b().longValue();
    }

    @Override // c.c.a.b.f.e.v8
    public final long zzb() {
        return f4469b.b().longValue();
    }
}
