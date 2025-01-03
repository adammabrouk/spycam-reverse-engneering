package cn.jiguang.f;

import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.e.f;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public static String f8874a = "cn.jiguang.sdk.share.profile";

    /* renamed from: b, reason: collision with root package name */
    public static String f8875b = "cn.jpush.preferences.v2";

    /* renamed from: c, reason: collision with root package name */
    public String f8876c;

    /* renamed from: d, reason: collision with root package name */
    public String f8877d;

    /* renamed from: e, reason: collision with root package name */
    public T f8878e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8879f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8880g;

    public a(String str, String str2, T t) {
        this.f8876c = str;
        this.f8877d = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f8878e = t;
    }

    public static a<Long> A() {
        return new a<>(f8875b, "lbs_delay", 0L);
    }

    public static a<Boolean> B() {
        return new a<>(f8875b, "jcore_lbs_enable", true);
    }

    public static a<Boolean> C() {
        return new a<>(MultiSpHelper.SP_FILE, "is_tcp_close", false);
    }

    public static a<Integer> D() {
        return new a(MultiSpHelper.SP_FILE, "jpush_register_code", -1).ag();
    }

    public static a<String> E() {
        return new a<>(f8875b, "device_config_appkey", "");
    }

    public static a<String> F() {
        return new a<>(f8875b, "i_new", "");
    }

    public static a<String> G() {
        return new a<>(f8875b, "push_udid", "");
    }

    public static a<String> H() {
        return new a<>(f8875b, "last_connection_type", "");
    }

    public static a<String> I() {
        return new a(f8875b, "sis_report_history", "").ah();
    }

    public static a<Long> J() {
        return new a<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static a<Integer> K() {
        return new a<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static a<String> L() {
        return new a("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").ah();
    }

    public static a<String> M() {
        return new a("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").ah();
    }

    public static a<Boolean> N() {
        return new a<>("cn.jiguang.sdk.address", "udp_data_report", false);
    }

    public static a<Long> O() {
        return new a<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static a<Long> P() {
        return new a<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static a<String> Q() {
        return new a("cn.jiguang.sdk.address", "default_sis_ips", "").ah();
    }

    public static a<String> R() {
        return new a("cn.jiguang.sdk.address", "default_conn", "").ah();
    }

    public static a<String> S() {
        return new a("cn.jiguang.sdk.address", "default_conn_srv", "").ah();
    }

    public static a<String> T() {
        return new a("cn.jiguang.sdk.address", "tcp_report", "").ag().ah();
    }

    public static a<String> U() {
        return new a<>("PrefsFile", "key", "");
    }

    public static a<Integer> V() {
        return new a<>("internal_debug", "violation_count", 0);
    }

    public static a<Integer> W() {
        return new a("internal_debug", "log_enable", 0).ag();
    }

    public static a<Integer> X() {
        return new a("internal_debug", "cmd_print_log", 0).ag();
    }

    public static a<Long> Y() {
        return new a("internal_debug", "expire", 0L).ag();
    }

    public static a<Integer> Z() {
        return new a("internal_debug", "delay_upload", 0).ag();
    }

    public static a<String> a() {
        return new a(MultiSpHelper.SP_FILE, "devcie_id_generated", "").ag();
    }

    public static a<String> a(String str) {
        return new a<>(MultiSpHelper.SP_FILE, "sdk_version_" + str, "");
    }

    public static a<String> a(boolean z) {
        return new a("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").ag().ah();
    }

    public static a<Long> aa() {
        return new a<>("internal_debug", "sentry_time", 0L);
    }

    public static a<Boolean> ab() {
        return new a<>("internal_debug", "sentry_sample_switch", false);
    }

    public static a<String> ac() {
        return new a<>("cn.jiguang.sdk.device", "di_ml", "");
    }

    public static a<String> ad() {
        return new a<>("cn.jiguang.sdk.device", "di_mft", "");
    }

    public static a<String> ae() {
        return new a<>("cn.jiguang.sdk.device", "di_rm", "");
    }

    public static a<String> af() {
        return new a<>("cn.jiguang.sdk.device", "di_ov", "");
    }

    private a<T> ag() {
        this.f8879f = true;
        return this;
    }

    private a<T> ah() {
        this.f8880g = true;
        return this;
    }

    public static a<Boolean> b() {
        return new a<>(MultiSpHelper.SP_FILE, "upload_crash", true);
    }

    public static a<String> b(String str) {
        return new a("cn.jiguang.sdk.address", "dns_" + str, "").ah();
    }

    public static a<String> b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_sis_address");
        sb.append(z ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").ah();
    }

    public static a<Long> c() {
        return new a("cn.jiguang.sdk.user.profile", "key_uid", 0L).ag();
    }

    public static a<Long> c(String str) {
        return new a<>("cn.jiguang.sdk.address", "dns_last_update_" + str, 0L);
    }

    public static a<String> c(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_conn");
        sb.append(z ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").ah();
    }

    public static a<String> d() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid", "").ag();
    }

    public static a<String> d(String str) {
        return new a("cn.jiguang.sdk.address", "srv_" + str, "").ah();
    }

    public static a<String> d(boolean z) {
        return new a("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").ag().ah();
    }

    public static a<Long> e() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid_time", 0L).ag();
    }

    public static a<Long> e(String str) {
        return new a<>("cn.jiguang.sdk.address", "srv_last_update_" + str, 0L);
    }

    public static a<String> f() {
        return new a("cn.jiguang.sdk.user.profile", "key_ww", "").ag().ah();
    }

    public static a<String> f(String str) {
        return new a("IpInfos", str, "").ah();
    }

    public static a<String> g() {
        return new a("cn.jiguang.sdk.user.profile", "key_pwd", "").ag();
    }

    public static a<String> g(String str) {
        return new a("IpInfos", f.d(str), "").ah();
    }

    public static a<Integer> h() {
        return new a("cn.jiguang.sdk.user.profile", "idc", -1).ag();
    }

    public static a<Integer> h(String str) {
        return new a<>("netinfo", str, 0);
    }

    public static a<Long> i() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static a<Long> j() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static a<String> k() {
        return new a(f8874a, "key_share_process_uuid", "").ag();
    }

    public static a<Long> l() {
        return new a(f8874a, "key_share_process_uuid_creattime", -1L).ag();
    }

    public static a<Integer> m() {
        return new a(f8874a, "sp_state", -1).ag();
    }

    public static a<String> n() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static a<String> o() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static a<Boolean> p() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", true);
    }

    public static a<Long> q() {
        return new a<>("Push_Page_Config", PushSA.SESSION_START_MILLIS, 0L);
    }

    public static a<Long> r() {
        return new a<>("Push_Page_Config", PushSA.SESSION_END_MILLIS, 0L);
    }

    public static a<Long> s() {
        return new a<>("Push_Page_Config", "last_pause", -1L);
    }

    public static a<String> t() {
        return new a<>("Push_Page_Config", PushSA.KEY_SESSION_ID, "");
    }

    public static a<String> u() {
        return new a("cn.jiguang.sdk.report", "report_urls", "").ah();
    }

    public static a<String> v() {
        return new a("cn.jiguang.sdk.report", "report_sis_urls", "").ah();
    }

    public static a<Long> w() {
        return new a<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static a<Long> x() {
        return new a<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", Long.valueOf(JConstants.HOUR));
    }

    public static a<String> y() {
        return new a(f8875b, "sdk_version", "").ag();
    }

    public static a<Long> z() {
        return new a<>(f8875b, "first_init", 0L);
    }

    public a<T> a(T t) {
        this.f8878e = t;
        return this;
    }

    public a<T> i(String str) {
        this.f8876c = str;
        return this;
    }

    public a<T> j(String str) {
        this.f8877d = str;
        return this;
    }
}
