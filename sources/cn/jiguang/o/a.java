package cn.jiguang.o;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.e.e;
import cn.jiguang.l.d;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f9016b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f9017c = "";

    /* renamed from: d, reason: collision with root package name */
    public static final FileFilter f9018d = new FileFilter() { // from class: cn.jiguang.o.a.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i2 = 3; i2 < name.length(); i2++) {
                if (name.charAt(i2) < '0' || name.charAt(i2) > '9') {
                    return false;
                }
            }
            return true;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static JSONArray f9015a = new JSONArray();

    public static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < read) {
                if (bArr[i2] == 10 || i2 == 0) {
                    if (bArr[i2] == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < read; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            break;
                        }
                        if (i4 == str.length() - 1) {
                            return a(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int a(byte[] bArr, int i2) {
        while (i2 < bArr.length && bArr[i2] != 10) {
            if (bArr[i2] >= 48 && bArr[i2] <= 57) {
                int i3 = i2 + 1;
                while (i3 < bArr.length && bArr[i3] >= 48 && bArr[i3] <= 57) {
                    i3++;
                }
                return Integer.parseInt(new String(bArr, 0, i2, i3 - i2));
            }
            i2++;
        }
        return -1;
    }

    public static long a(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : b(statFs);
    }

    public static long a(String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.contains(str));
            bufferedReader.close();
            return Integer.valueOf(readLine.split("\\s+")[1]).intValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(f9016b)) {
            return f9016b;
        }
        f();
        return f9016b;
    }

    public static String a(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static String a(Context context, int i2) {
        if (i2 != 53) {
            return null;
        }
        try {
            String g2 = g(context);
            if (TextUtils.isEmpty(g2)) {
                g2 = f(context);
            }
            JSONObject jSONObject = new JSONObject(g2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rom_type", (int) d.n(context));
            jSONObject2.put("regid", d.o(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{new cn.jiguang.f.a("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a((cn.jiguang.f.a) Base64.encodeToString(str.getBytes(), 2))});
        cn.jiguang.ai.a.a("JDeviceHelper", "save device info:" + str);
    }

    public static double b(Context context) {
        double pow;
        int i2;
        Point point = new Point();
        boolean z = context instanceof Activity;
        if (z) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 31) {
                try {
                    Rect rect = (Rect) e.a(e.a(((Activity) context).getWindowManager(), "getMaximumWindowMetrics", (Object[]) null, (Class[]) null), "getBounds", (Object[]) null, (Class[]) null);
                    point.x = rect.right - rect.left;
                    point.y = rect.bottom - rect.top;
                } catch (Exception unused) {
                }
            } else if (i3 >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (i3 >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            i2 = point.y;
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            i2 = displayMetrics.heightPixels;
        }
        return Math.sqrt(pow + Math.pow(i2 / displayMetrics.ydpi, 2.0d));
    }

    public static int b(StatFs statFs) {
        return statFs.getBlockSize();
    }

    public static String b() {
        if (!TextUtils.isEmpty(f9017c)) {
            return f9017c;
        }
        f();
        return f9017c;
    }

    public static long c(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                activityManager.getProcessMemoryInfo(new int[]{0});
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1024;
            }
        } catch (Throwable unused) {
        }
        return a("MemTotal");
    }

    public static long c(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : d(statFs);
    }

    public static boolean c() {
        return false;
    }

    public static int d() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f9018d).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int d(StatFs statFs) {
        return statFs.getBlockCount();
    }

    public static long d(Context context) {
        try {
            if (!c()) {
                return -1L;
            }
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (c(statFs) * a(statFs)) / 1024;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int e() {
        int i2 = -1;
        for (int i3 = 0; i3 < d(); i3++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[RecyclerView.c0.FLAG_IGNORE];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i4 = 0;
                        while (bArr[i4] >= 48 && bArr[i4] <= 57 && i4 < 128) {
                            i4++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i4)));
                        if (valueOf.intValue() > i2) {
                            i2 = valueOf.intValue();
                        }
                    } catch (Throwable unused) {
                    }
                    fileInputStream.close();
                }
            } catch (Throwable unused2) {
                return -1;
            }
        }
        if (i2 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int a2 = a("cpu MHz", fileInputStream2) * 1000;
                if (a2 > i2) {
                    i2 = a2;
                }
                fileInputStream2.close();
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        return i2;
    }

    public static JSONArray e(Context context) {
        return new JSONArray();
    }

    public static String f(Context context) {
        try {
            cn.jiguang.be.a a2 = cn.jiguang.be.a.a(context);
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.h.a.a().d(1022)) {
                jSONObject.put("sim_slots", e(context));
            }
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put("appkey", d.b(context));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            jSONObject.put("apkversion", a2.f8679a);
            jSONObject.put("systemversion", a2.f8680b);
            if (cn.jiguang.h.a.a().d(2009)) {
                jSONObject.put("modelnumber", a2.f8681c);
            }
            if (cn.jiguang.h.a.a().d(2001)) {
                jSONObject.put("basebandversion", a2.f8682d);
            }
            jSONObject.put("buildnumber", a2.f8683e);
            jSONObject.put("channel", a2.f8684f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", d.b(0));
            jSONObject2.put("StatisticSDKVer", d.b(1));
            jSONObject2.put("ShareSDKVer", d.b(2));
            jSONObject2.put("CoreSDKVer", d.b(3));
            jSONObject2.put("SspSDKVer", d.b(4));
            jSONObject2.put("VerificationSDKVer", d.b(5));
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", a2.f8685g);
            jSONObject.put("business", d.g());
            jSONObject.put("device_id_status", d.j(context));
            jSONObject.put("device_id", d.h(context));
            if (cn.jiguang.h.a.a().d(2012)) {
                jSONObject.put("resolution", a2.f8686h);
            }
            if (cn.jiguang.h.a.a().d(RecyclerView.MAX_SCROLL_DURATION)) {
                jSONObject.put("android_id", a2.f8687i);
            }
            if (cn.jiguang.h.a.a().d(2007)) {
                jSONObject.put("mac_address", d.c(context, ""));
            }
            if (cn.jiguang.h.a.a().d(2013)) {
                jSONObject.put("serial_number", a2.j);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void f() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String str = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("Processor")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            str = readLine.substring(indexOf + 1).trim();
                        }
                        if (str != null && !stringBuffer.toString().contains(str)) {
                            stringBuffer.append(str);
                        }
                    }
                    if (readLine.contains("Hardware")) {
                        try {
                            String trim = readLine.substring(readLine.indexOf(":") + 1).trim();
                            if (!TextUtils.isEmpty(trim)) {
                                f9017c = trim;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable unused2) {
        }
        f9016b = stringBuffer.toString();
    }

    public static String g(Context context) {
        String str;
        String str2 = (String) cn.jiguang.f.b.b(context, new cn.jiguang.f.a("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
        if (TextUtils.isEmpty(str2)) {
            str = (String) cn.jiguang.f.b.b(context, new cn.jiguang.f.a("cn.jpush.preferences.v2", "udp_report_device_info", ""));
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        } else {
            str = new String(Base64.decode(str2, 2));
        }
        cn.jiguang.ai.a.a("JDeviceHelper", "read deviceinfo:" + str);
        return str;
    }
}
