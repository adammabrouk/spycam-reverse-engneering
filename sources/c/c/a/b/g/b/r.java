package c.c.a.b.g.b;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r {
    public static p3<Long> A;
    public static p3<Boolean> A0;
    public static p3<Long> B;
    public static p3<Boolean> B0;
    public static p3<Integer> C;
    public static p3<Boolean> C0;
    public static p3<Long> D;
    public static p3<Boolean> D0;
    public static p3<Integer> E;
    public static p3<Boolean> E0;
    public static p3<Integer> F;
    public static p3<Boolean> F0;
    public static p3<Integer> G;
    public static p3<Boolean> G0;
    public static p3<Integer> H;
    public static p3<Boolean> H0;
    public static p3<Integer> I;
    public static p3<Boolean> I0;
    public static p3<Long> J;
    public static p3<Boolean> J0;
    public static p3<Boolean> K;
    public static p3<Boolean> K0;
    public static p3<String> L;
    public static p3<Boolean> L0;
    public static p3<Long> M;
    public static p3<Boolean> M0;
    public static p3<Integer> N;
    public static p3<Boolean> N0;
    public static p3<Double> O;
    public static p3<Boolean> O0;
    public static p3<Integer> P;
    public static p3<Boolean> P0;
    public static p3<Integer> Q;
    public static p3<Boolean> Q0;
    public static p3<Boolean> R;
    public static p3<Long> R0;
    public static p3<Boolean> S;
    public static p3<Boolean> T;
    public static p3<Boolean> U;
    public static p3<Boolean> V;
    public static p3<Boolean> W;
    public static p3<Boolean> X;
    public static p3<Boolean> Y;
    public static p3<Boolean> Z;

    /* renamed from: a, reason: collision with root package name */
    public static List<p3<?>> f5026a = Collections.synchronizedList(new ArrayList());
    public static p3<Boolean> a0;

    /* renamed from: b, reason: collision with root package name */
    public static p3<Long> f5027b;
    public static p3<Boolean> b0;

    /* renamed from: c, reason: collision with root package name */
    public static p3<Long> f5028c;
    public static p3<Boolean> c0;

    /* renamed from: d, reason: collision with root package name */
    public static p3<Long> f5029d;
    public static p3<Boolean> d0;

    /* renamed from: e, reason: collision with root package name */
    public static p3<String> f5030e;
    public static p3<Boolean> e0;

    /* renamed from: f, reason: collision with root package name */
    public static p3<String> f5031f;
    public static p3<Boolean> f0;

    /* renamed from: g, reason: collision with root package name */
    public static p3<Integer> f5032g;
    public static p3<Boolean> g0;

    /* renamed from: h, reason: collision with root package name */
    public static p3<Integer> f5033h;
    public static p3<Boolean> h0;

    /* renamed from: i, reason: collision with root package name */
    public static p3<Integer> f5034i;
    public static p3<Boolean> i0;
    public static p3<Integer> j;
    public static p3<Boolean> j0;
    public static p3<Integer> k;
    public static p3<Boolean> k0;
    public static p3<Integer> l;
    public static p3<Boolean> l0;
    public static p3<Integer> m;
    public static p3<Boolean> m0;
    public static p3<Integer> n;
    public static p3<Boolean> n0;
    public static p3<Integer> o;
    public static p3<Boolean> o0;
    public static p3<Integer> p;
    public static p3<Boolean> p0;
    public static p3<String> q;
    public static p3<Boolean> q0;
    public static p3<Long> r;
    public static p3<Boolean> r0;
    public static p3<Long> s;
    public static p3<Boolean> s0;
    public static p3<Long> t;
    public static p3<Boolean> t0;
    public static p3<Long> u;
    public static p3<Boolean> u0;
    public static p3<Long> v;
    public static p3<Boolean> v0;
    public static p3<Long> w;
    public static p3<Boolean> w0;
    public static p3<Long> x;
    public static p3<Boolean> x0;
    public static p3<Long> y;
    public static p3<Boolean> y0;
    public static p3<Long> z;
    public static p3<Boolean> z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f5027b = a("measurement.ad_id_cache_time", 10000L, 10000L, q.f5009a);
        Long valueOf = Long.valueOf(JConstants.DAY);
        f5028c = a("measurement.monitoring.sample_period_millis", valueOf, valueOf, t.f5080a);
        Long valueOf2 = Long.valueOf(JConstants.HOUR);
        f5029d = a("measurement.config.cache_time", valueOf, valueOf2, d0.f4651a);
        f5030e = a("measurement.config.url_scheme", "https", "https", q0.f5010a);
        f5031f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", z0.f5211a);
        f5032g = a("measurement.upload.max_bundles", 100, 100, n1.f4945a);
        f5033h = a("measurement.upload.max_batch_size", 65536, 65536, w1.f5151a);
        f5034i = a("measurement.upload.max_bundle_size", 65536, 65536, k2.f4849a);
        j = a("measurement.upload.max_events_per_bundle", 1000, 1000, t2.f5083a);
        Integer valueOf3 = Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        k = a("measurement.upload.max_events_per_day", valueOf3, valueOf3, h3.f4759a);
        l = a("measurement.upload.max_error_events_per_day", 1000, 1000, s.f5054a);
        m = a("measurement.upload.max_public_events_per_day", 50000, 50000, v.f5130a);
        n = a("measurement.upload.max_conversions_per_day", 10000, 10000, u.f5109a);
        o = a("measurement.upload.max_realtime_events_per_day", 10, 10, x.f5172a);
        p = a("measurement.store.max_stored_events_per_app", valueOf3, valueOf3, w.f5149a);
        q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", a0.f4563a);
        r = a("measurement.upload.backoff_period", 43200000L, 43200000L, y.f5191a);
        s = a("measurement.upload.window_interval", valueOf2, valueOf2, c0.f4625a);
        t = a("measurement.upload.interval", valueOf2, valueOf2, b0.f4597a);
        u = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, e0.f4687a);
        v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, g0.f4735a);
        w = a("measurement.upload.minimum_delay", 500L, 500L, f0.f4716a);
        Long valueOf4 = Long.valueOf(JConstants.MIN);
        x = a("measurement.alarm_manager.minimum_interval", valueOf4, valueOf4, i0.f4791a);
        y = a("measurement.upload.stale_data_deletion_interval", valueOf, valueOf, h0.f4756a);
        z = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, k0.f4847a);
        A = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, j0.f4821a);
        B = a("measurement.upload.retry_time", 1800000L, 1800000L, m0.f4923a);
        C = a("measurement.upload.retry_count", 6, 6, l0.f4879a);
        D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, o0.f4963a);
        E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, n0.f4944a);
        F = a("measurement.audience.filter_result_max_count", 200, 200, p0.f4985a);
        G = a("measurement.upload.max_public_user_properties", 25, 25, null);
        H = a("measurement.upload.max_event_name_cardinality", 500, 500, null);
        I = a("measurement.upload.max_public_event_params", 25, 25, null);
        J = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, s0.f5055a);
        K = a("measurement.test.boolean_flag", false, false, r0.f5035a);
        L = a("measurement.test.string_flag", "---", "---", u0.f5110a);
        M = a("measurement.test.long_flag", -1L, -1L, t0.f5081a);
        N = a("measurement.test.int_flag", -2, -2, w0.f5150a);
        Double valueOf5 = Double.valueOf(-3.0d);
        O = a("measurement.test.double_flag", valueOf5, valueOf5, v0.f5131a);
        P = a("measurement.experiment.max_ids", 50, 50, y0.f5192a);
        Q = a("measurement.max_bundles_per_iteration", 2, 2, x0.f5173a);
        R = a("measurement.validation.internal_limits_internal_event_params", false, false, b1.f4598a);
        S = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, d1.f4652a);
        T = a("measurement.collection.firebase_global_collection_flag_enabled", true, true, c1.f4626a);
        U = a("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, f1.f4717a);
        V = a("measurement.collection.redundant_engagement_removal_enabled", false, false, e1.f4688a);
        W = a("measurement.client.freeride_engagement_fix", true, true, h1.f4757a);
        X = a("measurement.experiment.enable_experiment_reporting", true, true, g1.f4736a);
        Y = a("measurement.collection.log_event_and_bundle_v2", true, true, j1.f4822a);
        Z = a("measurement.quality.checksum", false, false, null);
        a0 = a("measurement.sdk.dynamite.use_dynamite3", true, true, i1.f4792a);
        b0 = a("measurement.sdk.dynamite.allow_remote_dynamite", false, false, l1.f4880a);
        c0 = a("measurement.sdk.collection.validate_param_names_alphabetical", true, true, k1.f4848a);
        d0 = a("measurement.collection.event_safelist", true, true, m1.f4924a);
        a("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, p1.f4986a);
        e0 = a("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, o1.f4964a);
        f0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, r1.f5036a);
        g0 = a("measurement.audience.refresh_event_count_filters_timestamp", false, false, q1.f5011a);
        h0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, t1.f5082a);
        i0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, s1.f5056a);
        j0 = a("measurement.sdk.collection.last_deep_link_referrer2", true, true, v1.f5132a);
        k0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, u1.f5111a);
        l0 = a("measurement.sdk.collection.last_gclid_from_referrer2", false, false, x1.f5174a);
        m0 = a("measurement.sdk.collection.enable_extend_user_property_size", true, true, z1.f5212a);
        n0 = a("measurement.upload.file_lock_state_check", false, false, y1.f5193a);
        o0 = a("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, c2.f4627a);
        p0 = a("measurement.ga.ga_app_id", false, false, a2.f4566a);
        q0 = a("measurement.lifecycle.app_backgrounded_tracking", true, true, e2.f4689a);
        r0 = a("measurement.lifecycle.app_in_background_parameter", false, false, d2.f4653a);
        s0 = a("measurement.integration.disable_firebase_instance_id", false, false, g2.f4737a);
        t0 = a("measurement.lifecycle.app_backgrounded_engagement", false, false, f2.f4718a);
        u0 = a("measurement.collection.service.update_with_analytics_fix", false, false, i2.f4793a);
        v0 = a("measurement.service.use_appinfo_modified", false, false, h2.f4758a);
        w0 = a("measurement.client.firebase_feature_rollout.v1.enable", true, true, j2.f4823a);
        x0 = a("measurement.client.sessions.check_on_reset_and_enable2", true, true, m2.f4925a);
        y0 = a("measurement.config.string.always_update_disk_on_set", true, true, l2.f4881a);
        z0 = a("measurement.scheduler.task_thread.cleanup_on_exit", false, false, o2.f4965a);
        A0 = a("measurement.upload.file_truncate_fix", false, false, n2.f4946a);
        B0 = a("measurement.engagement_time_main_thread", true, true, q2.f5012a);
        C0 = a("measurement.sdk.referrer.delayed_install_referrer_api", false, false, p2.f4987a);
        D0 = a("measurement.sdk.screen.disabling_automatic_reporting", true, true, s2.f5057a);
        E0 = a("measurement.sdk.screen.manual_screen_view_logging", true, true, r2.f5037a);
        F0 = a("measurement.gold.enhanced_ecommerce.format_logs", false, false, u2.f5112a);
        G0 = a("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false, false, w2.f5152a);
        H0 = a("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false, false, v2.f5133a);
        I0 = a("measurement.gold.enhanced_ecommerce.log_nested_complex_events", false, false, y2.f5194a);
        J0 = a("measurement.gold.enhanced_ecommerce.updated_schema.client", false, false, x2.f5175a);
        K0 = a("measurement.gold.enhanced_ecommerce.updated_schema.service", false, false, a3.f4567a);
        a("measurement.collection.synthetic_data_mitigation", false, false, z2.f5213a);
        L0 = a("measurement.service.configurable_service_limits", false, false, d3.f4654a);
        M0 = a("measurement.client.configurable_service_limits", false, false, b3.f4602a);
        N0 = a("measurement.androidId.delete_feature", true, true, f3.f4719a);
        O0 = a("measurement.client.global_params.dev", false, false, e3.f4690a);
        a("measurement.service.global_params", false, false, g3.f4738a);
        P0 = a("measurement.client.string_reader", true, true, j3.f4824a);
        Q0 = a("measurement.sdk.attribution.cache", true, true, i3.f4794a);
        R0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, l3.f4882a);
    }

    public static Map<String, String> a(Context context) {
        c.c.a.b.f.e.m1 a2 = c.c.a.b.f.e.m1.a(context.getContentResolver(), c.c.a.b.f.e.b2.a("com.google.android.gms.measurement"));
        return a2 == null ? Collections.emptyMap() : a2.a();
    }

    public static final /* synthetic */ Long q0() {
        fa faVar = m3.f4926a;
        return Long.valueOf(c.c.a.b.f.e.s8.j());
    }

    public static <V> p3<V> a(String str, V v2, V v3, n3<V> n3Var) {
        p3<V> p3Var = new p3<>(str, v2, v3, n3Var);
        f5026a.add(p3Var);
        return p3Var;
    }
}
