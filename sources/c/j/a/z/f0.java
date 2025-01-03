package c.j.a.z;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.hjq.permissions.Permission;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f6699c;

    /* renamed from: a, reason: collision with root package name */
    public static String[] f6697a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b, reason: collision with root package name */
    public static String[] f6698b = {"android.permission.INTERNET", Permission.READ_PHONE_STATE, "android.permission.ACCESS_NETWORK_STATE", Permission.WRITE_SETTINGS, "android.permission.VIBRATE", Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", Permission.GET_ACCOUNTS, "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* renamed from: d, reason: collision with root package name */
    public static String[] f6700d = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: e, reason: collision with root package name */
    public static String[] f6701e = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: f, reason: collision with root package name */
    public static String[] f6702f = new String[0];

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, Bundle> f6703g = new ConcurrentHashMap();

    public static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Boolean bool = f6699c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            v.d("Utility", "isPushProcess context is null");
            return false;
        }
        String b2 = z.b(context);
        if (context != null && context.getPackageName() != null && context.getPackageName().equals(b2)) {
            Boolean bool2 = Boolean.TRUE;
            f6699c = bool2;
            return bool2.booleanValue();
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = null;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean valueOf = Boolean.valueOf(str.contains(":pushservice"));
        f6699c = valueOf;
        return valueOf.booleanValue();
    }

    public static long b(Context context) {
        String b2 = z.b(context);
        if (!TextUtils.isEmpty(b2)) {
            return a(context, b2);
        }
        v.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String c(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    public static void d(Context context, String str) throws f {
        try {
            if (context.getPackageManager() == null) {
                throw new f("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new f("serviceInfos is null");
            }
            for (String str2 : f6700d) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new f("error " + e2.getMessage());
        }
    }

    public static void e(Context context, String str) throws f {
        if (f6702f.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new f("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new f("activityInfos is null");
            }
            for (String str2 : f6702f) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new f("error " + e2.getMessage());
        }
    }

    public static void f(Context context, String str) throws f {
        try {
            if (context.getPackageManager() == null) {
                throw new f("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new f("receivers is null");
            }
            for (String str2 : f6701e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new f(e2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c7, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r23) throws c.j.a.z.f {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.j.a.z.f0.c(android.content.Context):void");
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.app_id");
        if (a2 != null) {
            return a2.toString();
        }
        Object a3 = a(context, str, "app_id");
        return a3 != null ? a3.toString() : "";
    }

    public static PublicKey d(Context context) {
        Cursor query = context.getContentResolver().query(c.j.a.w.f6663a, null, null, null, null);
        if (query == null) {
            return null;
        }
        while (query.moveToNext()) {
            try {
                try {
                    if ("pushkey".equals(query.getString(query.getColumnIndex("name")))) {
                        String string = query.getString(query.getColumnIndex("value"));
                        v.d("Utility", "result key : ".concat(String.valueOf(string)));
                        PublicKey a2 = a0.a(string);
                        try {
                            query.close();
                        } catch (Exception unused) {
                        }
                        return a2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        try {
            query.close();
        } catch (Exception unused3) {
        }
        return null;
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean e(Context context) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Exception e2) {
                    v.a("Utility", "isSupport", e2);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        v.a("Utility", "close", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            v.a("Utility", "close", e4);
        }
        if (context == null) {
            v.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        Cursor query = context.getContentResolver().query(c.j.a.w.f6664b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"323", packageName, String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
        if (query == null) {
            v.a("Utility", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    v.a("Utility", "close", e5);
                }
            }
            return false;
        }
        if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
            if (query != null) {
                query.close();
            }
            return false;
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e6) {
                v.a("Utility", "close", e6);
            }
        }
        return true;
    }

    public static boolean b(Context context, String str, String str2) {
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Exception e2) {
                    v.a("Utility", "isOverdue", e2);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (Exception e3) {
                v.a("Utility", "close", e3);
            }
            if (context == null) {
                v.a("Utility", "context is null");
                return false;
            }
            Cursor query = context.getContentResolver().query(c.j.a.w.f6665c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "323"}, null);
            if (query == null) {
                v.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        v.a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!query.moveToFirst()) {
                if (query != null) {
                    query.close();
                }
                return false;
            }
            boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e5) {
                    v.a("Utility", "close", e5);
                }
            }
            return parseBoolean;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                    v.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                v.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        v.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    public static Object a(Context context, String str, String str2) {
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object obj = (f6703g == null || f6703g.size() <= 0 || (bundle = f6703g.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, RecyclerView.c0.FLAG_IGNORE);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj2 = r0 != null ? r0.get(str2) : obj;
                try {
                    if (f6703g.size() > 300) {
                        return obj2;
                    }
                    f6703g.put(str, r0);
                    return obj2;
                } catch (Exception e2) {
                    r0 = obj2;
                    e = e2;
                    v.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return r0;
                }
            } catch (Exception e3) {
                e = e3;
                r0 = obj;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws f {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new f(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new f(str + " module Push-SDK need is not exist");
    }

    public static void a(ComponentInfo componentInfo, String str) throws f {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f6697a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new f("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) throws f {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new f("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new f(str2 + " is missing");
                }
                throw new f("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new f(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new f(str2 + " is missing");
            }
            throw new f("checkModule " + intent + " has no services");
        } catch (Exception e2) {
            v.a("Utility", "error  " + e2.getMessage());
            throw new f("checkModule error" + e2.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        String b2 = z.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            v.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            v.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (b2.equals(context.getPackageName())) {
            v.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!b2.equals(stringExtra)) {
            v.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        v.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
    }
}
