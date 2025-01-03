package cn.jpush.android.o;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f9824a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9825b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9826c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9827d;

    public static void a(Context context) {
        b(context);
    }

    public static void a(Context context, int i2) {
        cn.jpush.android.r.b.b("DyPushConstants", "changeForegroundStat, userType: " + i2);
        f9824a = i2;
        a(i2 > 0);
        Bundle bundle = new Bundle();
        bundle.putInt("user_type", i2);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "change_foreground_dy", bundle);
        cn.jpush.android.an.a.a().b(context, i2);
    }

    public static void a(Context context, Bundle bundle) {
    }

    public static void a(Context context, String str) {
        cn.jpush.android.r.b.b("DyPushConstants", "saveInAppState...");
        Bundle bundle = new Bundle();
        bundle.putString(ContentCommon.TYPE, "config_state");
        bundle.putString("content", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "save_config", bundle);
    }

    public static void a(Context context, String str, long j) {
        cn.jpush.android.r.b.b("DyPushConstants", "saveInAppInfo, content: " + str + ", displayTime: " + j);
        Bundle bundle = new Bundle();
        bundle.putString(ContentCommon.TYPE, "config_info");
        bundle.putString("content", str);
        bundle.putLong("display_time", j);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "save_config", bundle);
    }

    public static void a(Context context, String str, long j, long j2) {
        cn.jpush.android.r.b.b("DyPushConstants", "[sendDisplayStatusToRemoteProcess]. adPosId: " + str + ", interval: " + j + ", delayTime: " + j2);
        Bundle bundle = new Bundle();
        bundle.putString("ad_slot", str);
        bundle.putLong("delay_time", j2);
        bundle.putLong("interval_time", j);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "display_status_sync", bundle);
    }

    public static void a(Context context, boolean z) {
        cn.jpush.android.r.b.b("DyPushConstants", "changeInstallStatus, support: " + z);
        f9826c = z;
        Bundle bundle = new Bundle();
        bundle.putBoolean("install_status", z);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "install_status", bundle);
    }

    public static void a(boolean z) {
        cn.jpush.android.r.b.b("DyPushConstants", "set foreground: " + z + ", old value: " + f9825b);
        f9825b = z;
    }

    public static boolean a() {
        cn.jpush.android.r.b.b("DyPushConstants", "get foreground status isforeground: " + f9825b);
        return f9825b;
    }

    public static void b(Context context) {
        String str;
        Activity p;
        if (JPushConstants.SDK_VERSION_CODE >= 369) {
            cn.jpush.android.r.b.b("DyPushConstants", "JPush local version: " + JPushConstants.SDK_VERSION_CODE + ", large than: 369 min in app version, need not register another lifecycle");
            return;
        }
        cn.jpush.android.r.b.b("DyPushConstants", "initPageLifecycle init, local jpush version: " + JPushConstants.SDK_VERSION_CODE + ", isInitLife: " + f9827d);
        if (f9827d) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            f9827d = true;
            if (Build.VERSION.SDK_INT < 14 || !(applicationContext instanceof Application)) {
                return;
            }
            String d2 = cn.jpush.android.bm.a.d(applicationContext);
            String packageName = applicationContext.getPackageName();
            if (d2 == null || packageName == null || !applicationContext.getPackageName().equals(d2)) {
                d dVar = new d();
                dVar.r = 2;
                cn.jpush.android.bg.b.a(applicationContext, "sync_reg_lifecycle", dVar, (Intent) null);
                str = "need not initPageLifecycle in other process :" + d2;
            } else {
                a aVar = new a();
                ((Application) applicationContext).registerActivityLifecycleCallbacks(aVar);
                if (a.f9817a == 0 && (p = cn.jpush.android.bm.a.p(applicationContext)) != null) {
                    aVar.onActivityCreated(p, null);
                    aVar.onActivityStarted(p);
                    aVar.onActivityResumed(p);
                }
                str = "initPageLifecycle in main process,packageName:" + packageName + ",currentProcessName:" + d2;
            }
            cn.jpush.android.r.b.b("DyPushConstants", str);
        } catch (Throwable th) {
            cn.jpush.android.r.b.g("DyPushConstants", "registerActivityLifecycleCallbacks failed:" + th.getMessage());
        }
    }

    public static void b(Context context, String str) {
        d dVar = new d();
        dVar.bu = str;
        cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.SYNC_BLACK_LIST", dVar, true);
    }
}
