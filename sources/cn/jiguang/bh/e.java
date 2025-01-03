package cn.jiguang.bh;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Pair;
import cn.jiguang.bh.a;
import cn.jiguang.internal.ActionManager;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: cn.jiguang.bh.e$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8794a;

        static {
            int[] iArr = new int[a.EnumC0138a.values().length];
            f8794a = iArr;
            try {
                iArr[a.EnumC0138a.NOT_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8794a[a.EnumC0138a.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting package info.", e2);
            return null;
        }
    }

    public static Float a(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting device battery level.", e2);
            return null;
        }
    }

    public static Long a(ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(Build.VERSION.SDK_INT >= 16 ? memoryInfo.totalMem : Runtime.getRuntime().totalMemory());
    }

    public static Date a() {
        try {
            return cn.jiguang.e.b.a(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting the device's boot time.", e2);
            return null;
        }
    }

    public static Boolean b(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting device charging state.", e2);
            return null;
        }
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        }
        return null;
    }

    public static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (String str : Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{g(), h()}) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static Float c(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting battery temperature.", e2);
            return null;
        }
    }

    public static String c() {
        try {
            return Build.MODEL.split(LogUtils.PLACEHOLDER, -1)[0];
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting device family.", e2);
            return null;
        }
    }

    public static TimeZone c(Context context) {
        Calendar calendar;
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                calendar = Calendar.getInstance(locales.get(0));
                return calendar.getTimeZone();
            }
        }
        calendar = Calendar.getInstance();
        return calendar.getTimeZone();
    }

    public static ActivityManager.MemoryInfo d(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            cn.jiguang.as.d.c("SentryUtils", "Error getting MemoryInfo.");
            return null;
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting MemoryInfo.", e2);
            return null;
        }
    }

    public static Boolean d() {
        boolean z;
        try {
            if ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.FINGERPRINT.startsWith("generic") && !Build.FINGERPRINT.startsWith("unknown") && !Build.HARDWARE.contains("goldfish") && !Build.HARDWARE.contains("ranchu") && !Build.MODEL.contains("google_sdk") && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && !Build.PRODUCT.contains("sdk_google") && !Build.PRODUCT.contains("google_sdk") && !Build.PRODUCT.contains("sdk") && !Build.PRODUCT.contains("sdk_x86") && !Build.PRODUCT.contains("vbox86p") && !Build.PRODUCT.contains("emulator") && !Build.PRODUCT.contains("simulator")) {
                z = false;
                return Boolean.valueOf(z);
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            cn.jiguang.as.d.b("SentryUtils", "Error checking whether application is running in an emulator.", e2);
            return null;
        }
    }

    public static Intent e(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @TargetApi(19)
    public static String e() {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } finally {
            }
        } catch (IOException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Exception while attempting to read kernel information", e2);
            return property;
        }
    }

    public static cn.jiguang.bg.b f(Context context) {
        Exception e2;
        cn.jiguang.bg.b bVar;
        try {
            bVar = b.a(context.getResources().getConfiguration().orientation);
            if (bVar == null) {
                try {
                    cn.jiguang.as.d.e("SentryUtils", "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)");
                    return null;
                } catch (Exception e3) {
                    e2 = e3;
                    cn.jiguang.as.d.a("SentryUtils", "Error getting device orientation.", e2);
                    return bVar;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            bVar = null;
        }
        return bVar;
    }

    public static JSONObject f() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "sentry.java.android");
            jSONObject.put(ActionManager.SDK_VERSION, "5.0.1");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "maven:io.sentry:sentry");
            jSONObject2.put(ActionManager.SDK_VERSION, "5.0.1");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "maven:io.sentry:sentry-android-core");
            jSONObject3.put(ActionManager.SDK_VERSION, "5.0.1");
            jSONArray.put(jSONObject3);
            jSONObject.put("packages", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting SDK version.", e2);
            return null;
        }
    }

    public static DisplayMetrics g(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting DisplayMetrics.", e2);
            return null;
        }
    }

    public static String g() {
        return Build.CPU_ABI;
    }

    public static String h() {
        return Build.CPU_ABI2;
    }

    public static String h(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            return i2 == 0 ? applicationInfo.nonLocalizedLabel != null ? applicationInfo.nonLocalizedLabel.toString() : context.getPackageManager().getApplicationLabel(applicationInfo).toString() : context.getString(i2);
        } catch (Exception e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting application name.", e2);
            return null;
        }
    }

    public static JSONObject i(Context context) {
        DisplayMetrics g2;
        ActivityManager.MemoryInfo d2;
        try {
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.h.a.a().d(1005)) {
                jSONObject.put("archs", b());
            }
            jSONObject.put("name", b(context));
            if (cn.jiguang.h.a.a().d(1011)) {
                jSONObject.put("manufacturer", Build.MANUFACTURER);
            }
            if (cn.jiguang.h.a.a().d(1002)) {
                jSONObject.put("brand", Build.BRAND);
            }
            jSONObject.put("family", c());
            if (cn.jiguang.h.a.a().d(1013)) {
                jSONObject.put("model", Build.MODEL);
            }
            jSONObject.put("model_id", Build.ID);
            Intent e2 = e(context);
            if (e2 != null) {
                jSONObject.put("battery_level", a(e2));
                jSONObject.put("charging", b(e2));
                jSONObject.put("battery_temperature", c(e2));
            }
            int i2 = AnonymousClass1.f8794a[a.a(context).ordinal()];
            jSONObject.put("online", i2 != 1 ? i2 != 2 ? null : true : false);
            jSONObject.put("orientation", f(context));
            jSONObject.put("simulator", d());
            if (cn.jiguang.h.a.a().d(1016) && (d2 = d(context)) != null) {
                jSONObject.put("memory_size", a(d2));
                jSONObject.put("free_memory", d2.availMem);
                jSONObject.put("low_memory", d2.lowMemory);
            }
            if (cn.jiguang.h.a.a().d(1017) && (g2 = g(context)) != null) {
                jSONObject.put("screen_width_pixels", g2.widthPixels);
                jSONObject.put("screen_height_pixels", g2.heightPixels);
                jSONObject.put("screen_density", g2.density);
                jSONObject.put("screen_dpi", g2.densityDpi);
            }
            jSONObject.put("boot_time", a());
            if (cn.jiguang.h.a.a().d(1026)) {
                jSONObject.put("timezone", c(context));
            }
            if (cn.jiguang.h.a.a().d(1001)) {
                jSONObject.put("id", cn.jiguang.bk.c.a(context));
            }
            if (cn.jiguang.h.a.a().d(1009)) {
                jSONObject.put("language", Locale.getDefault().toString());
            }
            jSONObject.put("connection_type", a.b(context));
            return jSONObject;
        } catch (JSONException e3) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting Device.", e3);
            return null;
        }
    }

    public static JSONObject j(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageInfo a2 = a(context);
            Pair<String, Long> d2 = cn.jiguang.ao.a.d(context);
            jSONObject.put("app_build", Long.toString(((Long) d2.second).longValue()));
            jSONObject.put("app_identifier", a2.packageName);
            jSONObject.put("app_name", h(context));
            jSONObject.put("app_start_time", cn.jiguang.a.a.f8104h);
            jSONObject.put("app_version", d2.first);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting App.", e2);
            return null;
        }
    }

    public static JSONObject k(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("build", Build.DISPLAY);
            jSONObject.put("kernel_version", e());
            jSONObject.put("name", "Android");
            jSONObject.put("rooted", new d(context).a());
            if (cn.jiguang.h.a.a().d(1014)) {
                jSONObject.put(ActionManager.SDK_VERSION, Build.VERSION.RELEASE);
            }
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting OperatingSystem.", e2);
            return null;
        }
    }

    public static JSONObject l(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cn.jiguang.ao.a.a(context) + "|" + cn.jiguang.d.a.b(context));
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.as.d.a("SentryUtils", "Error getting user.", e2);
            return null;
        }
    }
}
