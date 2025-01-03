package cn.jpush.android.r;

import com.shix.shixipc.utilcode.LogUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9843a = System.getProperty("line.separator");

    public static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return LogUtils.NULL;
        }
        try {
            return f9843a + jSONObject.toString(2);
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public static void a(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 2, str2, (Throwable) null);
    }

    public static void a(String str, String str2, Throwable th) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 5, str2, th);
    }

    public static void b(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 3, str2, (Throwable) null);
    }

    public static void b(String str, String str2, Throwable th) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 6, str2, th);
    }

    public static void c(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 3, str2, (Throwable) null);
    }

    public static void c(String str, String str2, Throwable th) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 6, str2, th);
    }

    public static void d(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 4, str2, (Throwable) null);
    }

    public static void e(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 4, str2, (Throwable) null);
    }

    public static void f(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 5, str2, (Throwable) null);
    }

    public static void g(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 5, str2, (Throwable) null);
    }

    public static void h(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, true, 6, str2, (Throwable) null);
    }

    public static void i(String str, String str2) {
        cn.jpush.android.l.a.a("JUnionAd", str, false, 6, str2, (Throwable) null);
    }
}
