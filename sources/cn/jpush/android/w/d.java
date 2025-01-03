package cn.jpush.android.w;

import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.shix.shixipc.utilcode.RomUtils;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f9929a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f9930b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f9931c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f9932d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f9933e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f9934f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f9935g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f9936h = "";

    public static String a() {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("xiaomi")) {
                    return f();
                }
                if (lowerCase.contains("meizu")) {
                    return b();
                }
                if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                    return lowerCase.contains("vivo") ? d() : lowerCase.contains("oneplus") ? g() : lowerCase.contains("samsung") ? h() : lowerCase.contains("meitu") ? i() : "";
                }
                return e();
            }
            return c();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.i("RomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("RomVersionHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static String b() {
        if (!TextUtils.isEmpty(f9934f)) {
            return f9934f;
        }
        String a2 = a("ro.build.display.id");
        f9934f = a2;
        return a2;
    }

    public static String c() {
        if (!TextUtils.isEmpty(f9929a)) {
            return f9929a;
        }
        String a2 = a("ro.build.version.emui");
        f9929a = a2;
        return a2;
    }

    public static String d() {
        if (!TextUtils.isEmpty(f9931c)) {
            return f9931c;
        }
        String a2 = a(RomUtils.VERSION_PROPERTY_VIVO);
        f9931c = a2;
        return a2;
    }

    public static String e() {
        if (!TextUtils.isEmpty(f9930b)) {
            return f9930b;
        }
        String str = "OPPO_" + a("ro.build.version.opporom");
        f9930b = str;
        return str;
    }

    public static String f() {
        if (!TextUtils.isEmpty(f9933e)) {
            return f9933e;
        }
        String str = "MIUI_" + a("ro.miui.ui.version.name");
        f9933e = str;
        return str;
    }

    public static String g() {
        if (!TextUtils.isEmpty(f9932d)) {
            return f9932d;
        }
        String a2 = a(RomUtils.VERSION_PROPERTY_ONEPLUS);
        f9932d = a2;
        if (TextUtils.isEmpty(a2)) {
            f9932d = "OXYGEN_" + a("ro.oxygen.version");
        }
        if (!TextUtils.isEmpty(f9932d) && !f9932d.startsWith("Hydrogen") && !f9932d.startsWith("OXYGEN_")) {
            f9932d = "ONEPLUS_" + f9932d;
        }
        Logger.d("RomVersionHelper", "getOnePlusVersion = " + f9932d);
        return f9932d;
    }

    public static String h() {
        String str;
        if (!TextUtils.isEmpty(f9935g)) {
            return f9935g;
        }
        String a2 = a("ro.build.version.sem");
        if ("2601".equals(a2)) {
            str = "SAMSUNG_EXUI_9.0";
        } else if ("2801".equals(a2)) {
            str = "SAMSUNG_ONEUI_1.0";
        } else if ("2802".equals(a2)) {
            str = "SAMSUNG_ONEUI_1.x";
        } else if ("2803".equals(a2)) {
            str = "SAMSUNG_ONEUI_1.5";
        } else {
            if (!"2901".equals(a2)) {
                if ("2902".equals(a2)) {
                    str = "SAMSUNG_ONEUI_2.1";
                }
                return f9935g;
            }
            str = "SAMSUNG_ONEUI_2.0";
        }
        f9935g = str;
        return f9935g;
    }

    public static String i() {
        if (!TextUtils.isEmpty(f9936h)) {
            return f9936h;
        }
        String str = "MEIOS_" + a("ro.build.version.meios");
        f9936h = str;
        return str;
    }
}
