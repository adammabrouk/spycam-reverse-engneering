package cn.jiguang.l;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.e.f;
import cn.jiguang.e.g;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.hjq.permissions.Permission;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {
    public static long a(Context context, long j) {
        return cn.jiguang.d.b.a(context, j);
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        return cn.jiguang.e.a.a(context, str, cls);
    }

    public static String a() {
        return cn.jiguang.a.a.f8098b;
    }

    public static String a(int i2) {
        return g.a(i2);
    }

    public static String a(Context context) {
        return cn.jiguang.d.a.g(context);
    }

    public static String a(Context context, int i2) {
        return g.a(context, i2);
    }

    public static String a(File file) {
        return cn.jiguang.e.c.d(file);
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        return cn.jiguang.d.a.a(context, jSONObject, str);
    }

    public static void a(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, "JCOMMON", 16, null, bundle, new Object[0]);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCOMMON", 39, null, null, obj);
    }

    public static void a(Context context, Object obj, Object obj2) {
        JCoreManager.onEvent(context, "JCOMMON", 15, null, null, obj, obj2);
    }

    public static void a(Runnable runnable) {
        cn.jiguang.av.b.a(runnable, new int[0]);
    }

    public static void a(Runnable runnable, int i2) {
        cn.jiguang.av.b.a(runnable, i2, new int[0]);
    }

    public static void a(String str) {
        cn.jiguang.av.b.a(str);
    }

    public static void a(String str, Runnable runnable) {
        a(runnable);
    }

    public static boolean a(Context context, String str) {
        return cn.jiguang.e.a.c(context, str);
    }

    public static boolean a(Context context, boolean z, String str) {
        return JConstants.isAndroidQ(context, z, str);
    }

    public static boolean a(File file, String str) {
        return cn.jiguang.e.c.c(file, str);
    }

    public static int b() {
        return cn.jiguang.a.a.f8099c;
    }

    public static String b(int i2) {
        return cn.jiguang.az.b.a().b(i2);
    }

    public static String b(Context context) {
        return cn.jiguang.d.a.e(context);
    }

    public static String b(String str) {
        return f.e(str);
    }

    public static void b(Runnable runnable) {
        cn.jiguang.av.b.d(runnable, new int[0]);
    }

    public static boolean b(Context context, String str) {
        return cn.jiguang.e.a.i(context, str);
    }

    public static long c(Context context) {
        return cn.jiguang.d.a.f(context);
    }

    public static String c(Context context, String str) {
        return cn.jiguang.e.a.g(context, str);
    }

    public static String c(String str) {
        return f.j(str);
    }

    public static boolean c() {
        Boolean bool;
        Boolean bool2 = cn.jiguang.a.a.f8101e;
        return (bool2 != null && bool2.booleanValue()) || ((bool = cn.jiguang.a.a.f8102f) != null && bool.booleanValue());
    }

    public static int d() {
        return JConstants.SDK_VERSION_INT;
    }

    public static File d(Context context, String str) {
        return cn.jiguang.e.c.a(context, str);
    }

    public static String d(Context context) {
        return cn.jiguang.d.a.b(context);
    }

    public static String d(String str) {
        return f.b(str);
    }

    public static void e(Context context, String str) {
        JCoreManager.onEvent(context, "", 88, null, null, str);
    }

    public static boolean e() {
        return cn.jiguang.av.b.f8399a;
    }

    public static boolean e(Context context) {
        return cn.jiguang.d.b.a(context);
    }

    public static byte[] e(String str) {
        return f.i(str);
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.e())).longValue();
    }

    public static String f() {
        return cn.jiguang.e.a.c();
    }

    public static String f(String str) {
        return cn.jiguang.bk.e.a(str, cn.jiguang.a.a.f8105i);
    }

    public static long g() {
        return cn.jiguang.az.b.a().b();
    }

    public static String g(Context context) {
        return cn.jiguang.d.a.i(context);
    }

    public static String g(String str) {
        return cn.jiguang.bk.e.b(str, cn.jiguang.a.a.f8105i);
    }

    public static int h() {
        try {
            Map<Integer, Bundle> d2 = cn.jiguang.az.b.a().d();
            cn.jiguang.ai.a.a("JCommonPresenter", "map is " + d2.toString());
            if (d2 == null || !d2.containsKey(2)) {
                return 0;
            }
            String string = d2.get(2).getString(JThirdPlatFormInterface.KEY_CODE);
            if (TextUtils.isDigitsOnly(string)) {
                return Integer.parseInt(string);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String h(Context context) {
        return cn.jiguang.d.a.h(context);
    }

    public static long i(Context context) {
        return cn.jiguang.d.b.b(context);
    }

    public static int j(Context context) {
        return cn.jiguang.bk.c.f8827a;
    }

    public static boolean k(Context context) {
        return cn.jiguang.e.a.k(context);
    }

    public static String l(Context context) {
        return cn.jiguang.e.a.l(context);
    }

    public static boolean m(Context context) {
        if (!a(context, true, "canGetLbsInBackGround") || e() || cn.jiguang.e.a.c(context, Permission.ACCESS_BACKGROUND_LOCATION)) {
            return true;
        }
        cn.jiguang.ai.a.e("JCommonPresenter", "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION");
        return false;
    }

    public static byte n(Context context) {
        return cn.jiguang.az.b.a().a(context);
    }

    public static String o(Context context) {
        return cn.jiguang.az.b.a().b(context);
    }

    public static String p(Context context) {
        Object a2 = cn.jiguang.az.b.a().a(context, JPushConstants.SDK_TYPE, 30000);
        if (a2 instanceof String) {
            return (String) a2;
        }
        return null;
    }

    public static String q(Context context) {
        Pair<String, Long> c2 = cn.jiguang.c.b.c(context);
        return (c2 == null || f.a((String) c2.first)) ? "" : (String) c2.first;
    }
}
