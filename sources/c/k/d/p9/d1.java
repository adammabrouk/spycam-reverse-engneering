package c.k.d.p9;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import java.util.List;

/* loaded from: classes.dex */
public class d1 {
    public static boolean a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryIntentServices != null) {
                return !queryIntentServices.isEmpty();
            }
            return false;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        PackageManager packageManager;
        boolean z = false;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders((String) null, 0, 8);
        if (queryContentProviders != null && !queryContentProviders.isEmpty()) {
            for (ProviderInfo providerInfo : queryContentProviders) {
                if (providerInfo.enabled && providerInfo.exported && providerInfo.authority.equals(str)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 32);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return false;
        }
    }
}
