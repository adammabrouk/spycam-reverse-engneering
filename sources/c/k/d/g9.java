package c.k.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class g9 {

    /* renamed from: a, reason: collision with root package name */
    public static int f7186a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f7187b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, j9> f7188c;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized int a() {
        /*
            java.lang.Class<c.k.d.g9> r0 = c.k.d.g9.class
            monitor-enter(r0)
            int r1 = c.k.d.g9.f7186a     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto L4a
            r1 = 0
            java.lang.String r2 = "ro.miui.ui.version.code"
            java.lang.String r2 = m181a(r2)     // Catch: java.lang.Throwable -> L2c
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2c
            r3 = 1
            if (r2 == 0) goto L24
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = m181a(r2)     // Catch: java.lang.Throwable -> L2c
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2c
            if (r2 != 0) goto L22
            goto L24
        L22:
            r2 = 0
            goto L25
        L24:
            r2 = 1
        L25:
            if (r2 == 0) goto L28
            goto L29
        L28:
            r3 = 2
        L29:
            c.k.d.g9.f7186a = r3     // Catch: java.lang.Throwable -> L2c
            goto L34
        L2c:
            r2 = move-exception
            java.lang.String r3 = "get isMIUI failed"
            c.k.a.a.a.c.a(r3, r2)     // Catch: java.lang.Throwable -> L4e
            c.k.d.g9.f7186a = r1     // Catch: java.lang.Throwable -> L4e
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "isMIUI's value is: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            int r2 = c.k.d.g9.f7186a     // Catch: java.lang.Throwable -> L4e
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4e
            c.k.a.a.a.c.b(r1)     // Catch: java.lang.Throwable -> L4e
        L4a:
            int r1 = c.k.d.g9.f7186a     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)
            return r1
        L4e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.g9.a():int");
    }

    public static j9 a(String str) {
        j9 b2 = b(str);
        return b2 == null ? j9.Global : b2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m180a() {
        synchronized (g9.class) {
            int a2 = q9.a();
            return (!m183a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? "development" : "stable";
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m181a(String str) {
        try {
            try {
                return (String) f0.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m182a() {
        if (f7188c != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f7188c = hashMap;
        hashMap.put("CN", j9.China);
        f7188c.put("FI", j9.Europe);
        f7188c.put("SE", j9.Europe);
        f7188c.put("NO", j9.Europe);
        f7188c.put("FO", j9.Europe);
        f7188c.put("EE", j9.Europe);
        f7188c.put("LV", j9.Europe);
        f7188c.put("LT", j9.Europe);
        f7188c.put("BY", j9.Europe);
        f7188c.put("MD", j9.Europe);
        f7188c.put("UA", j9.Europe);
        f7188c.put("PL", j9.Europe);
        f7188c.put("CZ", j9.Europe);
        f7188c.put("SK", j9.Europe);
        f7188c.put("HU", j9.Europe);
        f7188c.put("DE", j9.Europe);
        f7188c.put("AT", j9.Europe);
        f7188c.put("CH", j9.Europe);
        f7188c.put("LI", j9.Europe);
        f7188c.put("GB", j9.Europe);
        f7188c.put("IE", j9.Europe);
        f7188c.put("NL", j9.Europe);
        f7188c.put("BE", j9.Europe);
        f7188c.put("LU", j9.Europe);
        f7188c.put("FR", j9.Europe);
        f7188c.put("RO", j9.Europe);
        f7188c.put("BG", j9.Europe);
        f7188c.put("RS", j9.Europe);
        f7188c.put("MK", j9.Europe);
        f7188c.put("AL", j9.Europe);
        f7188c.put("GR", j9.Europe);
        f7188c.put("SI", j9.Europe);
        f7188c.put("HR", j9.Europe);
        f7188c.put("IT", j9.Europe);
        f7188c.put("SM", j9.Europe);
        f7188c.put("MT", j9.Europe);
        f7188c.put("ES", j9.Europe);
        f7188c.put("PT", j9.Europe);
        f7188c.put("AD", j9.Europe);
        f7188c.put("CY", j9.Europe);
        f7188c.put("DK", j9.Europe);
        f7188c.put("RU", j9.Russia);
        f7188c.put("IN", j9.India);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m183a() {
        boolean z;
        synchronized (g9.class) {
            z = a() == 1;
        }
        return z;
    }

    public static j9 b(String str) {
        m182a();
        return f7188c.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = o9.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("ro.product.country.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = o9.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            c.k.a.a.a.c.m6a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        c.k.a.a.a.c.m6a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static synchronized boolean m184b() {
        boolean z;
        synchronized (g9.class) {
            z = a() == 2;
        }
        return z;
    }

    public static boolean c() {
        if (f7187b < 0) {
            Object a2 = f0.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            f7187b = 0;
            if (a2 != null && (a2 instanceof Boolean) && !((Boolean) Boolean.class.cast(a2)).booleanValue()) {
                f7187b = 1;
            }
        }
        return f7187b > 0;
    }

    public static boolean d() {
        return !j9.China.name().equalsIgnoreCase(a(b()).name());
    }
}
