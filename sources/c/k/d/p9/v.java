package c.k.d.p9;

/* loaded from: classes.dex */
public abstract class v {
    public static String A = "sig";
    public static String B = "ext_notify_title";
    public static String C = "ext_notify_description";
    public static String D = "ext_messenger";
    public static String E = "title";
    public static String F = "description";
    public static String G = "notifyId";

    /* renamed from: a, reason: collision with root package name */
    public static String f7712a = "1";

    /* renamed from: b, reason: collision with root package name */
    public static String f7713b = "2";

    /* renamed from: c, reason: collision with root package name */
    public static String f7714c = "3";

    /* renamed from: d, reason: collision with root package name */
    public static String f7715d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e, reason: collision with root package name */
    public static String f7716e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f, reason: collision with root package name */
    public static String f7717f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g, reason: collision with root package name */
    public static String f7718g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h, reason: collision with root package name */
    public static String f7719h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i, reason: collision with root package name */
    public static String f7720i = "com.xiaomi.push.CLOSE_CHANNEL";
    public static String j = "com.xiaomi.push.FORCE_RECONN";
    public static String k = "com.xiaomi.push.RESET_CONN";
    public static String l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
    public static String m = "com.xiaomi.push.PING_TIMER";
    public static String n = "ext_user_id";
    public static String o = "ext_user_res";
    public static String p = "ext_chid";
    public static String q = "ext_token";
    public static String r = "ext_auth_method";
    public static String s = "ext_security";
    public static String t = "ext_kick";
    public static String u = "ext_client_attr";
    public static String v = "ext_cloud_attr";
    public static String w = "ext_pkg_name";
    public static String x = "ext_notify_id";
    public static String y = "ext_notify_type";
    public static String z = "ext_session";

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i2);
        }
    }
}
