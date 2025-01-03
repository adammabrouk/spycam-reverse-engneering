package cn.jiguang.an;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.l.c;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.DActivity;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.service.DownloadProvider;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f8220a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f8221b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f8222c = "Xiaomi".toLowerCase();

    public static cn.jiguang.am.c a(Context context, PackageManager packageManager, String str, String str2) {
        StringBuilder sb;
        String message;
        if (packageManager != null && !TextUtils.isEmpty(str)) {
            try {
                int checkPermission = packageManager.checkPermission(str + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, RecyclerView.c0.FLAG_IGNORE);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String b2 = cn.jiguang.l.d.b(context);
                    Intent intent = new Intent();
                    intent.setClassName(str, "cn.jpush.android.service.PushService");
                    boolean z = packageManager.resolveService(intent, 0) != null;
                    if (checkPermission == 0 && z && !TextUtils.isEmpty(b2) && b2.length() == 24) {
                        cn.jiguang.am.c cVar = new cn.jiguang.am.c(str, str2, applicationInfo.targetSdkVersion);
                        ComponentInfo a2 = cn.jiguang.l.d.a(context, str, (Class<?>) DownloadProvider.class);
                        if (a2 instanceof ProviderInfo) {
                            ProviderInfo providerInfo = (ProviderInfo) a2;
                            if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                                    cVar.f8208d = providerInfo.authority;
                                }
                            }
                        }
                        return cVar;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart exception:");
                message = e2.toString();
                sb.append(message);
                cn.jiguang.ai.a.d("JWakeComponentHelper", sb.toString());
                return null;
            } catch (Throwable th) {
                sb = new StringBuilder();
                sb.append("checkWhetherToStart throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ai.a.d("JWakeComponentHelper", sb.toString());
                return null;
            }
        }
        return null;
    }

    public static void a(Context context, boolean z) {
        a(context, z, "cn.jpush.android.intent.DaemonService", DaemonService.class);
        b(context, z, DownloadProvider.class);
        if (b(context)) {
            a(context, z, DActivity.class);
            try {
                a(context, z, Class.forName("cn.jpush.android.service.BActivity", false, context.getClassLoader()));
            } catch (Throwable unused) {
                cn.jiguang.ai.a.a("JWakeComponentHelper", "can't find BActivity");
            }
        }
    }

    public static void a(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i2 = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, (Class<?>) cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i2) {
                cn.jiguang.ai.a.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            cn.jiguang.ai.a.a("JWakeComponentHelper", componentName + " setActivityEnabledSetting newState: " + i2);
            packageManager.setComponentEnabledSetting(componentName, i2, 1);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeComponentHelper", "setActivityEnabled throwable:" + th.getMessage());
        }
    }

    public static void a(Context context, boolean z, String str, Class cls) {
        String str2;
        try {
            if (context == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            String packageName = context.getPackageName();
            int i2 = z ? 1 : 2;
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(str);
            ResolveInfo resolveService = packageManager.resolveService(intent, 512);
            if (resolveService != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (serviceInfo == null) {
                    return;
                }
                String str3 = serviceInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                try {
                    Class<?> cls2 = Class.forName(str3);
                    if (cls2 == null) {
                        return;
                    }
                    if (!cls.isAssignableFrom(cls2)) {
                        cn.jiguang.ai.a.e("JWakeComponentHelper", "give up setting, as " + str3 + " is not extend from: " + cls.getName());
                        return;
                    }
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    cn.jiguang.ai.a.a("JWakeComponentHelper", componentName + " setComponentEnabledSetting newState: " + i2);
                    if (packageManager.getComponentEnabledSetting(componentName) != i2) {
                        packageManager.setComponentEnabledSetting(componentName, i2, 1);
                        return;
                    }
                    cn.jiguang.ai.a.a("JWakeComponentHelper", "DaemonService  enabled is :" + z + ", no need repeat set.");
                    return;
                } catch (ClassNotFoundException unused) {
                    str2 = "cant't find service class:" + str3;
                }
            } else {
                str2 = "cant't find DaemonService";
            }
            cn.jiguang.ai.a.d("JWakeComponentHelper", str2);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeComponentHelper", "setServiceEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean a(Context context) {
        Boolean bool = f8221b;
        if (bool != null) {
            return bool.booleanValue();
        }
        f8221b = Boolean.valueOf(c(context));
        return f8221b.booleanValue();
    }

    public static boolean a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return packageManager.resolveActivity(intent, 0) != null;
        } catch (Throwable th) {
            cn.jiguang.ai.a.e("JWakeComponentHelper", "hasActivityIntentFilter error:" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, Intent intent, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            intent.setPackage(str);
            if (!z) {
                intent.setAction("cn.jpush.android.intent.DActivity");
                intent.addCategory(str);
            }
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            if (resolveActivity == null) {
                cn.jiguang.ai.a.d("JWakeComponentHelper", "getDActivity resolveInfo was null from:" + intent);
                return false;
            }
            cn.jiguang.ai.a.a("JWakeComponentHelper", "target actvity name:" + resolveActivity.activityInfo.name + ", theme:" + resolveActivity.activityInfo.theme + ",exported:" + resolveActivity.activityInfo.exported);
            if (resolveActivity.activityInfo.exported && resolveActivity.activityInfo.enabled) {
                if (!z && !"jpush.custom".equals(resolveActivity.activityInfo.taskAffinity)) {
                    cn.jiguang.ai.a.d("JWakeComponentHelper", "activity taskAffinity must be jpush.custom");
                    return false;
                }
                if (resolveActivity.activityInfo.theme != 16973840) {
                    cn.jiguang.ai.a.d("JWakeComponentHelper", resolveActivity.activityInfo.name + "activity theme must config as @android:style/Theme.Translucent.NoTitleBar");
                    return false;
                }
                cn.jiguang.ai.a.a("JWakeComponentHelper", "dIntent:" + intent);
                return true;
            }
            cn.jiguang.ai.a.d("JWakeComponentHelper", "activity muse be exported and enabled");
            return false;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeComponentHelper", "get deeplink activity error#" + th);
            return false;
        }
    }

    public static void b(Context context, boolean z, Class cls) {
        try {
            if (context == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "context is null, give up setComponentEnabled");
                return;
            }
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager == null) {
                cn.jiguang.ai.a.e("JWakeComponentHelper", "PackageManager is null, give up setComponentEnabled");
                return;
            }
            int i2 = z ? 1 : 2;
            ComponentName componentName = new ComponentName(context, (Class<?>) cls);
            if (packageManager.getComponentEnabledSetting(componentName) == i2) {
                cn.jiguang.ai.a.a("JWakeComponentHelper", componentName.getClassName() + " enabled is :" + z + ", no need repeat set.");
                return;
            }
            cn.jiguang.ai.a.a("JWakeComponentHelper", componentName + " setDownloadProviderEnabledSetting newState: " + i2);
            packageManager.setComponentEnabledSetting(componentName, i2, 1);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JWakeComponentHelper", "setContentProviderEnabled throwable:" + th.getMessage());
        }
    }

    public static boolean b(Context context) {
        Boolean bool = f8220a;
        if (bool != null) {
            return bool.booleanValue();
        }
        f8220a = Boolean.valueOf(a(context, "cn.jpush.android.intent.DActivity"));
        return f8220a.booleanValue();
    }

    public static boolean c(Context context) {
        try {
            String str = c.a.f8947b;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(f8222c, str.toLowerCase());
        } catch (Throwable th) {
            cn.jiguang.ai.a.e("JWakeComponentHelper", "get MANUFACTURER failed - error:" + th);
            return false;
        }
    }
}
