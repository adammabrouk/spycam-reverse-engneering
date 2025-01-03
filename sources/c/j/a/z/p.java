package c.j.a.z;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6722a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f6723b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f6724c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f6725d;

    /* renamed from: e, reason: collision with root package name */
    public static String f6726e;

    /* renamed from: f, reason: collision with root package name */
    public static String f6727f;

    static {
        f0.b("ro.vivo.product.overseas", "no").equals("yes");
        String b2 = Build.VERSION.SDK_INT >= 26 ? f0.b("ro.product.country.region", "N") : f0.b("ro.product.customize.bbk", "N");
        f6722a = b2;
        "RU".equals(b2);
        "IN".equals(f6722a);
        b("rom_1.0");
        f6723b = b("rom_2.0");
        f6724c = b("rom_2.5");
        b("rom_3.0");
        f6726e = null;
        f6727f = null;
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean b(String str) {
        String b2 = f0.b("ro.vivo.rom", "");
        String b3 = f0.b("ro.vivo.rom.version", "");
        v.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (p.class) {
            if (f6726e == null && f6727f == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f6725d = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f6726e = (String) f6725d.invoke(null, "ro.vivo.rom", "@><@");
                    f6727f = (String) f6725d.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    v.b("Device", "getRomCode error");
                }
            }
            v.d("Device", "sRomProperty1 : " + f6726e + " ; sRomProperty2 : " + f6727f);
            String a2 = a(f6726e);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(f6727f);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            return a3;
        }
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            v.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        v.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}
