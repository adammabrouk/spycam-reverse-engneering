package cn.jiguang.e;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.service.PushReceiver;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.RomUtils;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8849a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f8850b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f8851c = "";

    /* renamed from: d, reason: collision with root package name */
    public static int f8852d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static String f8853e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f8854f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f8855g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f8856h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f8857i = "";

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.as.d.g("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            componentInfoArr = i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            cn.jiguang.as.d.h("AndroidUtil", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static ProviderInfo a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8);
                if (packageInfo.providers != null && packageInfo.providers.length != 0) {
                    for (ProviderInfo providerInfo : packageInfo.providers) {
                        if (str2.equals(providerInfo.authority)) {
                            return providerInfo;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(Context context) {
        String c2;
        if (!TextUtils.isEmpty(f8849a)) {
            return f8849a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                f8849a = processName;
                if (!TextUtils.isEmpty(processName)) {
                    return f8849a;
                }
            }
            c2 = e.c();
            f8849a = c2;
        } catch (Throwable th) {
            cn.jiguang.as.d.h("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(c2)) {
            return f8849a;
        }
        f8849a = d();
        return f8849a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        if (r4.checkPermission(r6, r5.activityInfo.packageName) != 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, android.content.Intent r5, java.lang.String r6) {
        /*
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L31
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch: java.lang.Throwable -> L31
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L31
            android.content.pm.ServiceInfo r0 = r5.serviceInfo     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L31
            android.content.pm.ServiceInfo r0 = r5.serviceInfo     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r0.name     // Catch: java.lang.Throwable -> L31
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L31
            r2 = 1
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L2d
            android.content.pm.ActivityInfo r5 = r5.activityInfo     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = r5.packageName     // Catch: java.lang.Throwable -> L31
            int r4 = r4.checkPermission(r6, r5)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L2d
            goto L2e
        L2d:
            r1 = 1
        L2e:
            if (r1 == 0) goto L31
            return r0
        L31:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.a(android.content.Context, android.content.Intent, java.lang.String):java.lang.String");
    }

    public static String a(Context context, Class<?> cls) {
        if (!TextUtils.isEmpty(f8850b)) {
            return f8850b;
        }
        try {
            f8850b = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), cls.getCanonicalName()), RecyclerView.c0.FLAG_IGNORE).processName;
        } catch (Exception unused) {
        }
        return f8850b;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), RecyclerView.c0.FLAG_IGNORE).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!c(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
            b(context, intent);
        }
    }

    public static void a(Context context, String str, int i2) {
        int i3;
        Notification notification;
        if (!g(context)) {
            cn.jiguang.as.d.c("AndroidUtil", "not debuggable");
            return;
        }
        if (!b(context, (Class<?>) PushReceiver.class)) {
            d(context, str);
            return;
        }
        cn.jiguang.as.d.c("AndroidUtil", "action:showPermanentNotification");
        Intent intent = new Intent(context, (Class<?>) PushReceiver.class);
        intent.setAction("noti_open_proxy");
        intent.addCategory(context.getPackageName());
        intent.putExtra("debug_notification", true);
        intent.putExtra("toastText", str);
        intent.putExtra(ContentCommon.TYPE, i2);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        try {
            i3 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
        } catch (Throwable th) {
            cn.jiguang.as.d.e("AndroidUtil", "failed to get application info and icon.", th);
            i3 = R.drawable.ic_menu_share;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
            Notification.Builder when = new Notification.Builder(context.getApplicationContext()).setContentTitle("Jiguang提示：包名和AppKey不匹配").setContentText("请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段").setContentIntent(broadcast).setSmallIcon(i3).setTicker(str).setWhen(currentTimeMillis);
            if (Build.VERSION.SDK_INT >= 26) {
                if (notificationManager.getNotificationChannel("JPush_Notification") == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("JPush_Notification", "JPush_Notification", 3));
                }
                when.setChannelId("JPush_Notification");
            }
            notification = when.getNotification();
            notification.flags = 34;
        } else {
            Notification notification2 = new Notification(i3, str, currentTimeMillis);
            notification2.flags = 34;
            try {
                e.a(notification2, "setLatestEventInfo", new Object[]{context, "Jiguang提示：包名和AppKey不匹配", "请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段", broadcast}, new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class});
            } catch (Exception unused) {
            }
            notification = notification2;
        }
        f8852d = 10000;
        notificationManager.notify(10000, notification);
    }

    public static boolean a() {
        return false;
    }

    public static String b() {
        return null;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f8851c)) {
            return f8851c;
        }
        String packageName = context.getPackageName();
        f8851c = packageName;
        return packageName;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), RecyclerView.c0.FLAG_IGNORE).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            return (String) e.a(context.getClassLoader().loadClass("android.os.SystemProperties"), "get", new Object[]{str, str2}, new Class[]{String.class, String.class});
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void b(Context context, Intent intent) {
        try {
            List<String> b2 = b(context, intent, (String) null);
            if (b2 == null || b2.isEmpty()) {
                cn.jiguang.as.d.h("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str : b2) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str));
                    context.sendBroadcast(intent2);
                } catch (Exception e2) {
                    cn.jiguang.as.d.h("AndroidUtil", "sendBroadcast failed again:" + e2.getMessage() + ", action:" + intent.getAction());
                }
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.h("AndroidUtil", "tryAgainSendBrocast failed:" + th.getMessage());
        }
    }

    public static boolean b(Context context, Class<?> cls) {
        boolean z;
        boolean z2 = false;
        try {
            z = !context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable unused) {
        }
        if (z) {
            return z;
        }
        try {
            if (a(context, context.getPackageName(), cls) != null) {
                z2 = true;
            }
        } catch (Throwable unused2) {
            z2 = z;
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(android.content.Context r6) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = -1
            if (r6 != 0) goto L6
            return r1
        L6:
            android.content.IntentFilter r2 = new android.content.IntentFilter
            java.lang.String r3 = "android.intent.action.BATTERY_CHANGED"
            r2.<init>(r3)
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.<init>()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = r6.getPackageName()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r5 = cn.jiguang.a.a.f8097a     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            r4.append(r5)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            android.content.Intent r3 = r6.registerReceiver(r3, r2, r4, r3)     // Catch: java.lang.Exception -> L28 java.lang.SecurityException -> L3f
            goto L44
        L28:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getChargedStatus unkown exception:"
            r2.append(r4)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            goto L41
        L3f:
            java.lang.String r6 = "getChargedStatus SecurityException"
        L41:
            cn.jiguang.as.d.g(r0, r6)
        L44:
            if (r3 != 0) goto L47
            return r1
        L47:
            java.lang.String r6 = "status"
            int r6 = r3.getIntExtra(r6, r1)
            r0 = 2
            if (r6 == r0) goto L56
            r0 = 5
            if (r6 != r0) goto L54
            goto L56
        L54:
            r6 = 0
            goto L57
        L56:
            r6 = 1
        L57:
            if (r6 != 0) goto L5a
            return r1
        L5a:
            java.lang.String r6 = "plugged"
            int r6 = r3.getIntExtra(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.c(android.content.Context):int");
    }

    public static String c() {
        return "";
    }

    public static boolean c(Context context, String str) {
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.getApplicationInfo().targetSdkVersion < 23) {
                    String permissionToOp = AppOpsManager.permissionToOp(str);
                    if (permissionToOp != null) {
                        z = ((AppOpsManager) context.getSystemService("appops")).noteProxyOpNoThrow(permissionToOp, context.getPackageName()) == 0;
                    }
                    return z;
                }
                if (context.checkSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.as.d.g("AndroidUtil", "checkPermission error:" + th.getMessage());
            return false;
        }
    }

    public static String d() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable unused) {
            }
            try {
                bArr = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
                i2 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i2 >= 256) {
                        break;
                    }
                    bArr[i2] = (byte) read;
                    i2++;
                }
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return "";
                }
                fileInputStream2.close();
                return "";
            }
            if (i2 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i2, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static void d(final Context context, final String str) {
        new Handler(Looper.getMainLooper()).post(new cn.jiguang.bj.b("AndroidUtils#ShowToast") { // from class: cn.jiguang.e.a.1
            @Override // cn.jiguang.bj.b
            public void a() {
                try {
                    Toast.makeText(context, str, 0).show();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!c(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String e(Context context, String str) {
        synchronized (a.class) {
            if (f.h("")) {
                str = "";
            }
        }
        return str;
    }

    public static boolean e(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (f.a(str)) {
            cn.jiguang.as.d.i("AndroidUtil", "Unexpected: cannot get pk installed path");
            return false;
        }
        cn.jiguang.as.d.c("AndroidUtil", "Current pk installed path: " + str);
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
            return false;
        }
        cn.jiguang.as.d.e("AndroidUtil", "NOTE: the pk does not installed in system/data. ");
        return false;
    }

    public static String f(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String f(Context context, String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty("")) {
                str = "";
            }
        }
        return str;
    }

    public static String g(Context context, String str) {
        return "";
    }

    public static boolean g(Context context) {
        boolean z = false;
        try {
            cn.jiguang.as.d.c("AndroidUtil", "isDebug:" + ((context.getApplicationInfo().flags & 2) != 0));
            X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
            String[] strArr = {"CN=Android Debug", "O=Android", "C=US"};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            boolean z2 = false;
            for (Signature signature : signatureArr) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    z2 = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                    cn.jiguang.as.d.c("AndroidUtil", "debuggable :" + z2);
                    if (z2) {
                        break;
                    }
                    String str = null;
                    try {
                        str = x509Certificate.getSubjectX500Principal().getName();
                    } catch (Exception unused) {
                    }
                    cn.jiguang.as.d.c("AndroidUtil", "certName:" + str);
                    if (str != null && str.contains(strArr[0]) && str.contains(strArr[1]) && str.contains(strArr[2])) {
                        return true;
                    }
                } catch (Throwable unused2) {
                    z = z2;
                    return z;
                }
            }
            return z2;
        } catch (Throwable unused3) {
        }
    }

    public static void h(Context context) {
        try {
            if (f8852d != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(f8852d);
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("AndroidUtil", "[canclePermanentNotification] failed:" + th.getMessage());
        }
    }

    public static boolean h(Context context, String str) {
        if (f.a(str)) {
            return false;
        }
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static String i(Context context) {
        return "";
    }

    public static boolean i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                for (String str2 : packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                    if (str.equals(str2)) {
                        cn.jiguang.as.d.c("AndroidUtil", "find permission: " + str);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.h("AndroidUtil", "hasPermissionDefined error:" + th.getMessage());
        }
        return false;
    }

    public static String j(Context context) {
        try {
            String g2 = g(context, "");
            if (g2 != null && !g2.equals("")) {
                cn.jiguang.as.d.e("AndroidUtil", "MAC addr info---- " + g2);
                return f.d(g2.toLowerCase() + Build.MODEL);
            }
            return null;
        } catch (Exception e2) {
            cn.jiguang.as.d.d("AndroidUtil", "", e2);
            return null;
        }
    }

    public static boolean k(Context context) {
        String b2 = b(context, "ro.product.brand", "");
        cn.jiguang.as.d.c("AndroidUtil", "brand = " + b2);
        String b3 = b(context, "ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(b2) || !"Xiaomi".equals(b2) || TextUtils.isEmpty(b3)) {
            return true;
        }
        String b4 = b(context, RomUtils.VERSION_PROPERTY_XIAOMI, "");
        if (TextUtils.isEmpty(b4) || !b4.startsWith("V7.1")) {
            return true;
        }
        cn.jiguang.as.d.g("AndroidUtil", "7.1 will not get wifi list");
        return false;
    }

    public static String l(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                return "Unknown";
            }
            if (f.a(subtypeName)) {
                return typeName;
            }
            return typeName + "," + subtypeName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public static String m(Context context) {
        return "";
    }

    public static String n(Context context) {
        Object invoke;
        String str = null;
        int i2 = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null && (invoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                        String str2 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
                        try {
                            i2 = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
                            str = str2;
                        } catch (Throwable th) {
                            th = th;
                            str = str2;
                            cn.jiguang.as.d.i("AndroidUtil", "getCountryCode failed, error :" + th);
                            cn.jiguang.as.d.c("AndroidUtil", "get CountCode = " + str + " source = " + i2);
                            if (i2 != 0) {
                            }
                        }
                    }
                } else {
                    cn.jiguang.as.d.c("AndroidUtil", "country_detector is null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        cn.jiguang.as.d.c("AndroidUtil", "get CountCode = " + str + " source = " + i2);
        return (i2 != 0 || i2 == 1) ? str : "";
    }

    public static Activity o(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    cn.jiguang.as.d.g("AndroidUtil", "get current activities for currentActivityThread, activities is null");
                    return null;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            cn.jiguang.as.d.g("AndroidUtil", "[getCurrentActivity] activity is null");
                            return null;
                        }
                        if (activity.getPackageName().equals(context.getPackageName())) {
                            cn.jiguang.as.d.c("AndroidUtil", "getCurrentActivity: " + activity.getLocalClassName());
                            return activity;
                        }
                        cn.jiguang.as.d.g("AndroidUtil", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                        return null;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.g("AndroidUtil", "[getCurrentActivity] error: " + th.getMessage());
            }
        }
        return null;
    }

    public static String p(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }
}
