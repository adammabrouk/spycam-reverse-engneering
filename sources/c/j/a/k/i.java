package c.j.a.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.bugly.CrashModule;
import java.util.List;

/* compiled from: SendCommandTask.java */
/* loaded from: classes.dex */
public final class i extends c.j.a.r {
    public i(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        Context context = this.f6635a;
        if (context == null) {
            c.j.a.z.v.d("SendCommandTask", "SendCommandTask " + vVar + " ; mContext is Null");
            return;
        }
        if (vVar == null) {
            c.j.a.z.v.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        c.j.a.t.e a2 = c.j.a.z.z.a(context);
        int b2 = vVar.b();
        if (b2 != 0) {
            if (b2 == 2009) {
                c.j.a.z.v.a(c.j.a.j.a.a(this.f6635a).c());
                if (c.j.a.z.v.a()) {
                    c.j.a.m.m().h();
                    c.j.a.z.h hVar = new c.j.a.z.h();
                    hVar.a(this.f6635a, "com.vivo.push_preferences.hybridapptoken_v1");
                    hVar.a();
                    c.j.a.z.h hVar2 = new c.j.a.z.h();
                    hVar2.a(this.f6635a, "com.vivo.push_preferences.appconfig_v1");
                    hVar2.a();
                    if (!c.j.a.m.m().d()) {
                        c.j.a.j.a.a(this.f6635a).a();
                    }
                }
            } else if (b2 != 2011) {
                switch (b2) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (a2 == null || a2.c()) {
                            c.j.a.m.m().a(((c.j.a.f.b) vVar).f(), 1005);
                            break;
                        } else {
                            c.j.a.f.b bVar = (c.j.a.f.b) vVar;
                            int a3 = c.j.a.z.y.a(bVar);
                            if (a3 != 0) {
                                c.j.a.m.m().a(bVar.f(), a3);
                                return;
                            }
                        }
                        break;
                }
            } else {
                c.j.a.z.v.a(c.j.a.j.a.a(this.f6635a).a(((c.j.a.f.v) vVar).d()));
            }
        } else if (c.j.a.m.m().d()) {
            Context context2 = this.f6635a;
            Intent intent = new Intent();
            intent.setPackage(context2.getPackageName());
            intent.setClassName(context2.getPackageName(), "com.vivo.push.sdk.service.CommandService");
            List<ResolveInfo> queryIntentServices = context2.getPackageManager().queryIntentServices(intent, RecyclerView.c0.FLAG_IGNORE);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                c.j.a.z.v.d("ModuleUtil", "disableDeprecatedService is null");
            } else {
                PackageManager packageManager = context2.getPackageManager();
                ComponentName componentName = new ComponentName(context2, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                }
            }
            Context context3 = this.f6635a;
            Intent intent2 = new Intent();
            intent2.setPackage(context3.getPackageName());
            intent2.setClassName(context3.getPackageName(), "com.vivo.push.sdk.service.LinkProxyActivity");
            List<ResolveInfo> queryIntentActivities = context3.getPackageManager().queryIntentActivities(intent2, RecyclerView.c0.FLAG_IGNORE);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                c.j.a.z.v.d("ModuleUtil", "disableDeprecatedActivity is null");
            } else {
                PackageManager packageManager2 = context3.getPackageManager();
                ComponentName componentName2 = new ComponentName(context3, queryIntentActivities.get(0).activityInfo.name);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                    packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                }
            }
        }
        if (a2 == null) {
            c.j.a.z.v.d("SendCommandTask", "SendCommandTask " + vVar + " ; pushPkgInfo is Null");
            return;
        }
        String a4 = a2.a();
        if (a2.c()) {
            c.j.a.m.m().a(((c.j.a.f.b) vVar).f(), CrashModule.MODULE_ID);
            vVar = new c.j.a.f.d();
            c.j.a.z.v.d("SendCommandTask", "SendCommandTask " + vVar + " ; pkgName is InBlackList ");
        }
        c.j.a.d.a.a(this.f6635a, a4, vVar);
    }
}
