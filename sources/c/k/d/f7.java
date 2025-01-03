package c.k.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.hjq.permissions.Permission;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class f7 {

    /* renamed from: a, reason: collision with root package name */
    public static String f7122a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f7123b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f7124c;

    /* renamed from: d, reason: collision with root package name */
    public static String f7125d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f7126e = String.valueOf((char) 2);

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f7127f = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: g, reason: collision with root package name */
    public static String f7128g = null;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f7129h = false;

    public static double a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    public static float a(int i2) {
        float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    @TargetApi(17)
    public static int a() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = f0.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = (i2 * 31) + str.charAt(i3);
        }
        return i2;
    }

    public static long a(File file) {
        long blockCount;
        long blockSize;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockCount = statFs.getBlockCountLong();
            blockSize = statFs.getBlockSizeLong();
        } else {
            blockCount = statFs.getBlockCount();
            blockSize = statFs.getBlockSize();
        }
        return blockSize * blockCount;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m151a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 8 && i2 < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return (String) f0.a("android.os.Build", "getSerial", (Object[]) null);
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m152a(int i2) {
        if (i2 > 0) {
            String[] strArr = f7127f;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f7127f[0];
    }

    public static String a(Context context) {
        return "a-" + k0.b(((String) null) + e(context) + ((String) null));
    }

    public static String a(Context context, boolean z) {
        if (f7124c == null) {
            String e2 = e(context);
            String f2 = !g9.d() ? z ? f(context) : p(context) : "";
            String m151a = m151a();
            int i2 = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(f2) && b(m151a)) {
                String a2 = y.a(context).a();
                if (TextUtils.isEmpty(a2)) {
                    String o = o(context);
                    if (TextUtils.isEmpty(o)) {
                        String b2 = y.a(context).b();
                        if (TextUtils.isEmpty(b2)) {
                            i2 = 5;
                        } else {
                            i2 = 4;
                            e2 = b2;
                        }
                    } else {
                        e2 = o;
                        i2 = 3;
                    }
                } else {
                    e2 = a2 + e2;
                    i2 = 2;
                }
            } else {
                e2 = f2 + e2 + m151a;
            }
            c.k.a.a.a.c.b("devid rule select:" + i2);
            if (i2 == 3) {
                f7124c = e2;
            } else {
                f7124c = m152a(i2) + k0.b(e2);
            }
            b(context, f7124c);
        }
        return f7124c;
    }

    public static void a(Context context, String str) {
        c.k.a.a.a.c.c("update vdevid = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f7128g = str;
        r9 r9Var = null;
        try {
            try {
                if (m158c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    r9Var = r9.a(context, file2);
                    v9.m512a(file2);
                    v9.a(file2, f7128g);
                }
                v9.a(new File(context.getFilesDir(), ".vdevid"), f7128g);
                if (r9Var == null) {
                    return;
                }
            } catch (IOException e2) {
                c.k.a.a.a.c.m6a("update vdevid failure :" + e2.getMessage());
                if (r9Var == null) {
                    return;
                }
            }
            r9Var.a();
        } catch (Throwable th) {
            if (r9Var != null) {
                r9Var.a();
            }
            throw th;
        }
    }

    public static void a(Context context, Map<String, String> map) {
        if (map == null || context == null) {
            return;
        }
        String o = o(context);
        if (TextUtils.isEmpty(o)) {
            return;
        }
        map.put("local_virt_devid", o);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m153a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m154a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f7127f;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static int b() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        int i2 = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        i2 = Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i2;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return i2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m155b() {
        return a(b()) + "GB";
    }

    public static String b(Context context) {
        try {
            return g8.a(context).a();
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static void b(Context context, String str) {
        c.k.a.a.a.c.c("write lvdd = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r9 r9Var = null;
        try {
            try {
                if (m158c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (file2.exists() && file2.isFile()) {
                        c.k.a.a.a.c.b("vdr exists, not rewrite.");
                        return;
                    }
                    r9Var = r9.a(context, file2);
                    v9.m512a(file2);
                    v9.a(file2, f7124c + f7126e + a(f7124c));
                    c.k.a.a.a.c.b("lvdd write succ.");
                } else {
                    c.k.a.a.a.c.m6a("not support write lvdd.");
                }
                if (r9Var == null) {
                    return;
                }
            } catch (IOException e2) {
                c.k.a.a.a.c.m6a("write lvdd failure :" + e2.getMessage());
                if (0 == 0) {
                    return;
                }
            }
            r9Var.a();
        } catch (Throwable th) {
            if (0 != 0) {
                r9Var.a();
            }
            throw th;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m156b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(LogUtils.NULL) || trim.equalsIgnoreCase("unknown");
    }

    public static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c, reason: collision with other method in class */
    public static String m157c() {
        double a2 = a(Environment.getDataDirectory());
        Double.isNaN(a2);
        return a(((a2 / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    public static String c(Context context) {
        r9 r9Var = null;
        if (!m158c(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(f7128g)) {
            return f7128g;
        }
        String a2 = v9.a(new File(context.getFilesDir(), ".vdevid"));
        f7128g = a2;
        if (!TextUtils.isEmpty(a2)) {
            return f7128g;
        }
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                r9Var = r9.a(context, file);
                f7128g = "";
                String a3 = v9.a(file);
                if (a3 != null) {
                    f7128g = a3;
                }
                String str = f7128g;
                if (r9Var != null) {
                    r9Var.a();
                }
                return str;
            } catch (IOException e2) {
                c.k.a.a.a.c.m6a("getVDevID failure :" + e2.getMessage());
                if (r9Var != null) {
                    r9Var.a();
                }
                return f7128g;
            }
        } catch (Throwable th) {
            if (r9Var != null) {
                r9Var.a();
            }
            throw th;
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m158c(Context context) {
        if (!h9.a(context, Permission.WRITE_EXTERNAL_STORAGE) || g9.m183a()) {
            return false;
        }
        boolean z = Build.VERSION.SDK_INT >= 26;
        return !z ? q9.m436a(context) : z;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && k0.m261b(str) && !k0.c(str);
    }

    public static String d() {
        return b() + "KB";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r6) {
        /*
            boolean r0 = m158c(r6)
            r1 = 0
            if (r0 == 0) goto Lcb
            boolean r0 = c.k.d.f7.f7129h
            if (r0 == 0) goto Ld
            goto Lcb
        Ld:
            r0 = 1
            c.k.d.f7.f7129h = r0
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.getFilesDir()
            java.lang.String r3 = ".vdevid"
            r0.<init>(r2, r3)
            java.lang.String r0 = c.k.d.v9.a(r0)
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.lang.String r5 = "/.vdevdir/"
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            c.k.d.r9 r2 = c.k.d.r9.a(r6, r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            java.lang.String r3 = c.k.d.v9.a(r4)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> Lc3
            if (r2 == 0) goto L62
            r2.a()
            goto L62
        L3d:
            r3 = move-exception
            goto L44
        L3f:
            r6 = move-exception
            goto Lc5
        L42:
            r3 = move-exception
            r2 = r1
        L44:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r4.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "check id failure :"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> Lc3
            r4.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> Lc3
            c.k.a.a.a.c.m6a(r3)     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L61
            r2.a()
        L61:
            r3 = r1
        L62:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto Lbb
            c.k.d.f7.f7128g = r0
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L85
            int r2 = r3.length()
            r4 = 128(0x80, float:1.794E-43)
            if (r2 <= r4) goto L79
            goto L85
        L79:
            boolean r6 = android.text.TextUtils.equals(r0, r3)
            if (r6 != 0) goto L9c
            java.lang.String r6 = "vid changed, need sync"
            c.k.a.a.a.c.m6a(r6)
            return r3
        L85:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "recover vid :"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            c.k.a.a.a.c.m6a(r2)
            a(r6, r0)
        L9c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "vdevid = "
            r6.append(r0)
            java.lang.String r0 = c.k.d.f7.f7128g
            r6.append(r0)
            java.lang.String r0 = " "
            r6.append(r0)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            c.k.a.a.a.c.c(r6)
            return r1
        Lbb:
            java.lang.String r6 = "empty local vid"
            c.k.a.a.a.c.m6a(r6)
            java.lang.String r6 = "F*"
            return r6
        Lc3:
            r6 = move-exception
            r1 = r2
        Lc5:
            if (r1 == 0) goto Lca
            r1.a()
        Lca:
            throw r6
        Lcb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.f7.d(android.content.Context):java.lang.String");
    }

    /* renamed from: d, reason: collision with other method in class */
    public static boolean m159d(Context context) {
        return context.getPackageManager().checkPermission(Permission.READ_PHONE_STATE, context.getPackageName()) == 0;
    }

    public static String e() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
            return null;
        }
    }

    public static String f(Context context) {
        int c2 = c();
        String g2 = g(context);
        while (g2 == null) {
            int i2 = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            c2 = i2;
        }
        return g2;
    }

    public static String g(Context context) {
        Object obj;
        Object a2;
        Object a3;
        if (g9.d()) {
            return "";
        }
        String str = f7122a;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (!g9.m183a() || (a2 = f0.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = f0.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str2 == null && m159d(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str2 = telephonyManager.getDeviceId();
                } else {
                    if (1 == telephonyManager.getPhoneType()) {
                        obj = f0.a(telephonyManager, "getImei", (Object[]) null);
                    } else if (2 == telephonyManager.getPhoneType()) {
                        obj = f0.a(telephonyManager, "getMeid", (Object[]) null);
                    }
                    str2 = (String) obj;
                }
            }
            if (!c(str2)) {
                return "";
            }
            f7122a = str2;
            return str2;
        } catch (Throwable th) {
            c.k.a.a.a.c.a(th);
            return null;
        }
    }

    public static String h(Context context) {
        int c2 = c();
        String j = j(context);
        while (j == null) {
            int i2 = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            j = j(context);
            c2 = i2;
        }
        return j;
    }

    public static String i(Context context) {
        Object a2;
        if (g9.d() || Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(f7123b)) {
            return f7123b;
        }
        if (!m159d(context)) {
            return "";
        }
        g(context);
        if (TextUtils.isEmpty(f7122a)) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Integer num = (Integer) f0.a(telephonyManager, "getPhoneCount", new Object[0]);
            if (num == null || num.intValue() <= 1) {
                return "";
            }
            String str = null;
            for (int i2 = 0; i2 < num.intValue(); i2++) {
                if (Build.VERSION.SDK_INT < 26) {
                    a2 = f0.a(telephonyManager, "getDeviceId", Integer.valueOf(i2));
                } else if (1 == telephonyManager.getPhoneType()) {
                    a2 = f0.a(telephonyManager, "getImei", Integer.valueOf(i2));
                } else {
                    if (2 == telephonyManager.getPhoneType()) {
                        a2 = f0.a(telephonyManager, "getMeid", Integer.valueOf(i2));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(f7122a, str) && c(str)) {
                        f7123b += str + ",";
                    }
                }
                str = (String) a2;
                if (!TextUtils.isEmpty(str)) {
                    f7123b += str + ",";
                }
            }
            int length = f7123b.length();
            if (length > 0) {
                f7123b = f7123b.substring(0, length - 1);
            }
            return f7123b;
        } catch (Exception e2) {
            c.k.a.a.a.c.d(e2.toString());
            return "";
        }
    }

    public static String j(Context context) {
        i(context);
        String str = "";
        if (TextUtils.isEmpty(f7123b)) {
            return "";
        }
        for (String str2 : f7123b.split(",")) {
            if (c(str2)) {
                str = str + k0.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String k(Context context) {
        synchronized (f7.class) {
            if (f7125d != null) {
                return f7125d;
            }
            String b2 = k0.b(e(context) + m151a());
            f7125d = b2;
            return b2;
        }
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (f7.class) {
            b2 = k0.b(e(context) + ((String) null));
        }
        return b2;
    }

    public static String m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String n(Context context) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        r1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        if (r1 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String o(android.content.Context r6) {
        /*
            boolean r0 = m158c(r6)
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r6 = "not support read lvdd."
            c.k.a.a.a.c.m6a(r6)
            return r1
        Ld:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r3 = "/.vdevdir/"
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r3 = ".vdevidlocal"
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            if (r0 == 0) goto L6e
            boolean r0 = r2.isFile()     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            if (r0 == 0) goto L6e
            c.k.d.r9 r6 = c.k.d.r9.a(r6, r2)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r0 = c.k.d.v9.a(r2)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            if (r3 != 0) goto L54
            java.lang.String r3 = c.k.d.f7.f7126e     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            int r3 = r0.length     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4 = 2
            if (r3 != r4) goto L54
            r3 = 0
            r3 = r0[r3]     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4 = 1
            r0 = r0[r4]     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            int r4 = a(r3)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L66
            if (r4 != r0) goto L54
            r1 = r3
        L54:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            if (r0 == 0) goto L62
            c.k.d.v9.m512a(r2)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.lang.String r0 = "lvdd content invalid, remove it."
            c.k.a.a.a.c.b(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
        L62:
            r5 = r1
            r1 = r6
            r6 = r5
            goto L74
        L66:
            r0 = move-exception
            r1 = r6
            goto L9a
        L69:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L7e
        L6e:
            java.lang.String r6 = "lvdf not exists"
            c.k.a.a.a.c.b(r6)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            r6 = r1
        L74:
            if (r1 == 0) goto L99
        L76:
            r1.a()
            goto L99
        L7a:
            r0 = move-exception
            goto L9a
        L7c:
            r0 = move-exception
            r6 = r1
        L7e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r2.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "get lvdd failure :"
            r2.append(r3)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L7a
            r2.append(r0)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L7a
            c.k.a.a.a.c.m6a(r0)     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L99
            goto L76
        L99:
            return r6
        L9a:
            if (r1 == 0) goto L9f
            r1.a()
        L9f:
            goto La1
        La0:
            throw r0
        La1:
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.f7.o(android.content.Context):java.lang.String");
    }

    public static String p(Context context) {
        int c2 = c();
        String g2 = g(context);
        while (TextUtils.isEmpty(g2)) {
            int i2 = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            c2 = i2;
        }
        return g2;
    }
}
