package c.j.a.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.List;

/* compiled from: OnChangePushStatusReceiveTask.java */
/* loaded from: classes.dex */
public final class o extends c.j.a.r {
    public o(c.j.a.v vVar) {
        super(vVar);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            c.j.a.z.v.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 1) {
            c.j.a.z.v.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        c.j.a.z.v.d("OnChangePushStatusTask", "enableService push service.");
        return true;
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            c.j.a.z.v.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
            c.j.a.z.v.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        c.j.a.z.v.d("OnChangePushStatusTask", "disableService push service.");
        return true;
    }

    public static List<ResolveInfo> c(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return list;
        }
        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
        } catch (Exception unused2) {
            return list;
        }
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        if (this.f6635a.getPackageName().equals(c.j.a.z.z.b(this.f6635a))) {
            return;
        }
        c.j.a.f.i iVar = (c.j.a.f.i) vVar;
        int f2 = iVar.f();
        int g2 = iVar.g();
        c.j.a.z.v.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + f2 + " ; receiverStatus is " + g2);
        if (f2 == 2) {
            b(this.f6635a);
        } else if (f2 == 1) {
            a(this.f6635a);
        } else if (f2 == 0) {
            Context context = this.f6635a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    c.j.a.z.v.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    c.j.a.z.v.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                c.j.a.z.v.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (g2 == 2) {
            Context context2 = this.f6635a;
            List<ResolveInfo> c2 = c(context2);
            if (c2 != null && c2.size() > 0) {
                String str = c2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    c.j.a.z.v.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                } else {
                    PackageManager packageManager2 = context2.getPackageManager();
                    ComponentName componentName2 = new ComponentName(context2, str);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                        c.j.a.z.v.d("OnChangePushStatusTask", "push service disableReceiver ");
                    } else {
                        c.j.a.z.v.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    }
                }
            } else {
                c.j.a.z.v.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            }
            c.j.a.y.b.b().a();
            return;
        }
        if (g2 == 1) {
            Context context3 = this.f6635a;
            List<ResolveInfo> c3 = c(context3);
            if (c3 != null && c3.size() > 0) {
                String str2 = c3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    c.j.a.z.v.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, str2);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 1) {
                    packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                    c.j.a.z.v.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    c.j.a.z.v.d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            c.j.a.z.v.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (g2 == 0) {
            Context context4 = this.f6635a;
            List<ResolveInfo> c4 = c(context4);
            if (c4 != null && c4.size() > 0) {
                String str3 = c4.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    c.j.a.z.v.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str3);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 0) {
                    packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                    c.j.a.z.v.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    c.j.a.z.v.d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            c.j.a.z.v.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
