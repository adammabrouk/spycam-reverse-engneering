package cn.jiguang.o;

import android.text.TextUtils;
import cn.jiguang.l.c;
import com.shix.shixipc.utilcode.RomUtils;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f9019a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f9020b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f9021c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f9022d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f9023e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f9024f = "";

    public static String a() {
        try {
            String lowerCase = c.a.f8947b.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (!lowerCase.contains("xiaomi") && !lowerCase.contains("blackshark")) {
                    if (lowerCase.contains("meizu")) {
                        return e();
                    }
                    if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                        return lowerCase.contains("vivo") ? c() : lowerCase.contains("oneplus") ? g() : "";
                    }
                    return d();
                }
                return f();
            }
            return b();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            cn.jiguang.ai.a.c("JRomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            cn.jiguang.ai.a.f("JRomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static String b() {
        if (!TextUtils.isEmpty(f9019a)) {
            return f9019a;
        }
        String a2 = a("ro.build.version.emui");
        f9019a = a2;
        return a2;
    }

    public static String c() {
        if (!TextUtils.isEmpty(f9021c)) {
            return f9021c;
        }
        String a2 = a(RomUtils.VERSION_PROPERTY_VIVO);
        f9021c = a2;
        return a2;
    }

    public static String d() {
        if (!TextUtils.isEmpty(f9020b)) {
            return f9020b;
        }
        String a2 = a("ro.build.version.opporom");
        f9020b = a2;
        return a2;
    }

    public static String e() {
        if (!TextUtils.isEmpty(f9024f)) {
            return f9024f;
        }
        String a2 = a("ro.build.display.id");
        f9024f = a2;
        return a2;
    }

    public static String f() {
        if (!TextUtils.isEmpty(f9023e)) {
            return f9023e;
        }
        String a2 = a("ro.miui.ui.version.name");
        f9023e = a2;
        return a2;
    }

    public static String g() {
        if (!TextUtils.isEmpty(f9022d)) {
            return f9022d;
        }
        String a2 = a(RomUtils.VERSION_PROPERTY_ONEPLUS);
        f9022d = a2;
        return a2;
    }
}
