package c.e.b.g;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.RomUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* compiled from: FuckRomUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6290a = {"huawei"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f6291b = {"vivo"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6292c = {"xiaomi"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f6293d = {"oppo"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f6294e = {"leeco", "letv"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f6295f = {"360", "qiku"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f6296g = {"zte"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f6297h = {"oneplus"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f6298i = {"nubia"};
    public static final String[] j = {"coolpad", "yulong"};
    public static final String[] k = {"lg", "lge"};
    public static final String[] l = {"google"};
    public static final String[] m = {"samsung"};
    public static final String[] n = {"meizu"};
    public static final String[] o = {"lenovo"};
    public static final String[] p = {"smartisan"};
    public static final String[] q = {"htc"};
    public static final String[] r = {"sony"};
    public static final String[] s = {"gionee", "amigo"};
    public static final String[] t = {"motorola"};
    public static C0121a u;

    /* compiled from: FuckRomUtils.java */
    /* renamed from: c.e.b.g.a$a, reason: collision with other inner class name */
    public static class C0121a {

        /* renamed from: a, reason: collision with root package name */
        public String f6299a;

        /* renamed from: b, reason: collision with root package name */
        public String f6300b;

        public String toString() {
            return "RomInfo{name=" + this.f6299a + ", version=" + this.f6300b + "}";
        }
    }

    public static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static C0121a c() {
        C0121a c0121a = u;
        if (c0121a != null) {
            return c0121a;
        }
        u = new C0121a();
        String a2 = a();
        String b2 = b();
        if (a(a2, b2, f6290a)) {
            u.f6299a = f6290a[0];
            String a3 = a("ro.build.version.emui");
            String[] split = a3.split("_");
            if (split.length > 1) {
                u.f6300b = split[1];
            } else {
                u.f6300b = a3;
            }
            return u;
        }
        if (a(a2, b2, f6291b)) {
            u.f6299a = f6291b[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_VIVO);
            return u;
        }
        if (a(a2, b2, f6292c)) {
            u.f6299a = f6292c[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_XIAOMI);
            return u;
        }
        if (a(a2, b2, f6293d)) {
            u.f6299a = f6293d[0];
            u.f6300b = a("ro.build.version.opporom");
            return u;
        }
        if (a(a2, b2, f6294e)) {
            u.f6299a = f6294e[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_LEECO);
            return u;
        }
        if (a(a2, b2, f6295f)) {
            u.f6299a = f6295f[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_360);
            return u;
        }
        if (a(a2, b2, f6296g)) {
            u.f6299a = f6296g[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_ZTE);
            return u;
        }
        if (a(a2, b2, f6297h)) {
            u.f6299a = f6297h[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_ONEPLUS);
            return u;
        }
        if (a(a2, b2, f6298i)) {
            u.f6299a = f6298i[0];
            u.f6300b = a(RomUtils.VERSION_PROPERTY_NUBIA);
            return u;
        }
        if (a(a2, b2, j)) {
            u.f6299a = j[0];
        } else if (a(a2, b2, k)) {
            u.f6299a = k[0];
        } else if (a(a2, b2, l)) {
            u.f6299a = l[0];
        } else if (a(a2, b2, m)) {
            u.f6299a = m[0];
        } else if (a(a2, b2, n)) {
            u.f6299a = n[0];
        } else if (a(a2, b2, o)) {
            u.f6299a = o[0];
        } else if (a(a2, b2, p)) {
            u.f6299a = p[0];
        } else if (a(a2, b2, q)) {
            u.f6299a = q[0];
        } else if (a(a2, b2, r)) {
            u.f6299a = r[0];
        } else if (a(a2, b2, s)) {
            u.f6299a = s[0];
        } else if (a(a2, b2, t)) {
            u.f6299a = t[0];
        } else {
            u.f6299a = b2;
        }
        u.f6300b = a("");
        return u;
    }

    public static boolean d() {
        return m[0].equals(c().f6299a);
    }

    public static boolean e() {
        return f6291b[0].equals(c().f6299a);
    }

    public static String d(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    readLine = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (readLine != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return readLine;
            }
            bufferedReader.close();
            return "";
        } catch (IOException unused5) {
            return "";
        }
    }

    public static String e(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b(String str) {
        String d2 = d(str);
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        String e2 = e(str);
        return (TextUtils.isEmpty(e2) && Build.VERSION.SDK_INT < 28) ? c(str) : e2;
    }

    public static String a(String str) {
        String b2 = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(b2) || b2.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    b2 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(b2) ? "unknown" : b2;
    }

    public static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
