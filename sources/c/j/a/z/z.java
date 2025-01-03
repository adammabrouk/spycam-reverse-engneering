package c.j.a.z;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PushPackageUtils.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f6740a;

    /* renamed from: b, reason: collision with root package name */
    public static String f6741b;

    public static c.j.a.t.e a(Context context) {
        c.j.a.t.e eVar;
        c.j.a.t.e f2;
        Context applicationContext = c.c(context).getApplicationContext();
        c.j.a.t.e d2 = d(applicationContext);
        if (d2 != null) {
            v.d("PushPackageUtils", "get system push info :".concat(String.valueOf(d2)));
            return d2;
        }
        List<String> e2 = e(applicationContext);
        c.j.a.t.e f3 = f(applicationContext, applicationContext.getPackageName());
        if (e2.size() <= 0) {
            if (f3 != null && f3.d()) {
                d2 = f3;
            }
            v.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            c.j.a.t.e eVar2 = null;
            String b2 = e0.b(applicationContext).b("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(b2) || !a(applicationContext, b2, "com.vivo.pushservice.action.METHOD") || (eVar = f(applicationContext, b2)) == null || !eVar.d()) {
                eVar = null;
            }
            if (f3 == null || !f3.d()) {
                f3 = null;
            }
            if (eVar == null) {
                eVar = null;
            }
            if (f3 == null || (eVar != null && (!f3.c() ? !(eVar.c() || f3.b() > eVar.b()) : !(eVar.c() && f3.b() > eVar.b())))) {
                f3 = eVar;
            }
            HashMap hashMap = new HashMap();
            if (f3 == null) {
                f3 = null;
            } else if (f3.c()) {
                eVar2 = f3;
                f3 = null;
            }
            int size = e2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = e2.get(i2);
                if (!TextUtils.isEmpty(str) && (f2 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f2);
                    if (f2.d()) {
                        if (f2.c()) {
                            if (eVar2 == null || f2.b() > eVar2.b()) {
                                eVar2 = f2;
                            }
                        } else if (f3 == null || f2.b() > f3.b()) {
                            f3 = f2;
                        }
                    }
                }
            }
            if (f3 != null) {
                d2 = f3;
            } else {
                v.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                d2 = eVar2;
            }
        }
        if (d2 == null) {
            v.b(applicationContext, "查找最优包为空!");
            v.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (d2.c()) {
            v.a(applicationContext, "查找最优包为:" + d2.a() + "(" + d2.b() + ", Black)");
            v.d("PushPackageUtils", "finSuitablePushPackage" + d2.a() + "(" + d2.b() + ", Black)");
        } else {
            v.a(applicationContext, "查找最优包为:" + d2.a() + "(" + d2.b() + ")");
            v.d("PushPackageUtils", "finSuitablePushPackage" + d2.a() + "(" + d2.b() + ")");
        }
        return d2;
    }

    public static String b(Context context) {
        String str;
        Cursor query;
        if (!TextUtils.isEmpty(f6741b)) {
            return f6741b;
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    query = context.getContentResolver().query(c.j.a.w.f6663a, null, null, null, null);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
        } catch (Exception e3) {
            v.a("PushPackageUtils", "close", e3);
        }
        try {
            if (query != null) {
                boolean z = false;
                str = null;
                while (query.moveToNext()) {
                    try {
                        if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                            str = query.getString(query.getColumnIndex("value"));
                        } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                            z = Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                f6741b = str;
                if (TextUtils.isEmpty(str)) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e5) {
                            v.a("PushPackageUtils", "close", e5);
                        }
                    }
                    return null;
                }
                if (z) {
                    if (query != null) {
                        query.close();
                    }
                    return str;
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e6) {
                        v.a("PushPackageUtils", "close", e6);
                    }
                }
                return null;
            }
            try {
                v.a("PushPackageUtils", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e7) {
                        v.a("PushPackageUtils", "close", e7);
                    }
                }
                return null;
            } catch (Exception e8) {
                e = e8;
                str = null;
            }
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e9) {
                    v.a("PushPackageUtils", "close", e9);
                }
            }
            throw th;
        }
        v.a("PushPackageUtils", "getSystemPush", e);
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    public static c.j.a.t.e d(Context context) {
        String b2 = b(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        c.j.a.t.e eVar = new c.j.a.t.e(b2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, RecyclerView.c0.FLAG_IGNORE);
            if (packageInfo != null) {
                eVar.a(packageInfo.versionCode);
                eVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                eVar.a(f0.a(context, b2));
            }
            eVar.a(a(context, eVar.b()));
            eVar.b(a(context, b2));
            return eVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            v.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    public static c.j.a.t.e f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                c.j.a.t.e eVar = new c.j.a.t.e(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, RecyclerView.c0.FLAG_IGNORE);
                    if (packageInfo != null) {
                        eVar.a(packageInfo.versionCode);
                        eVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        eVar.a(f0.a(context, str));
                    }
                    eVar.b(a(context, str));
                    eVar.a(a(context, eVar.b()));
                    return eVar;
                } catch (Exception e2) {
                    v.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    public static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & ThreadUtils.TYPE_SINGLE).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                v.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    public static boolean c(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f6740a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", RecyclerView.c0.FLAG_IGNORE)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f6740a = valueOf;
        return valueOf.booleanValue();
    }

    public static List<String> e(Context context) {
        List<ResolveInfo> list;
        m.a("findAllCoreClientPush");
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResolveInfo resolveInfo = list.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            v.d("PushPackageUtils", "get all push packages is null");
        }
        return arrayList;
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static int b(Context context, String str) {
        int i2 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i2;
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i2);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
            v.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    public static boolean a(Context context, long j) {
        c.j.a.j.e a2 = c.j.a.j.c.a().a(context);
        if (a2 != null) {
            return a2.a(j);
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}
