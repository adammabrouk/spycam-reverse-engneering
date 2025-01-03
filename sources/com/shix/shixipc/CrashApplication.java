package com.shix.shixipc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import c.c.a.b.j.c;
import c.c.a.b.j.h;
import c.c.b.l.a;
import c.j.a.z.f;
import c.k.c.a.l;
import cn.jpush.android.api.JPushInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CrashApplication extends Application {
    public static CrashApplication app;
    public static Context context;
    public static int pushBrand;
    public static Set<String> tags = new HashSet();

    static {
        System.loadLibrary("app_ipcapi");
        System.loadLibrary("avi");
        System.loadLibrary("myjni01");
    }

    public static synchronized Context getContext() {
        Context context2;
        synchronized (CrashApplication.class) {
            context2 = context;
        }
        return context2;
    }

    private void getFcmToken() {
        FirebaseInstanceId.o().b().a(new c<a>() { // from class: com.shix.shixipc.CrashApplication.1
            @Override // c.c.a.b.j.c
            public void onComplete(h<a> hVar) {
                if (!hVar.e()) {
                    Log.w("Constraints", "getInstanceId failed", hVar.a());
                    return;
                }
                String a2 = hVar.b().a();
                SharedPreferencesUtils.getInstance().putString("FcmToken", a2);
                Log.d("Constraints", a2);
            }
        });
    }

    public static synchronized CrashApplication getInstance() {
        CrashApplication crashApplication;
        synchronized (CrashApplication.class) {
            crashApplication = app;
        }
        return crashApplication;
    }

    public static int getPushBrand() {
        return pushBrand;
    }

    public static Set<String> getTags() {
        return tags;
    }

    private void initJpush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    private void initVivoPush() {
        try {
            c.j.a.c.a(getApplicationContext()).d();
            c.j.a.c.a(getApplicationContext()).a(new c.j.a.a() { // from class: com.shix.shixipc.CrashApplication.2
                @Override // c.j.a.a
                public void onStateChanged(int i2) {
                    LogUtils.e("biniy", "VIVOPUSH-initVivoPush-state = " + i2);
                }
            });
        } catch (f e2) {
            e2.printStackTrace();
        }
    }

    private void sendRegTokenToServer(String str) {
        Log.i("Constraints", "sending token to server. token:" + str);
    }

    public static void setTags(Set<String> set) {
        tags = set;
    }

    private boolean shouldInit() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        String str = getApplicationInfo().processName;
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && str.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
        a.o.a.c(context2);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
        initVivoPush();
        if (shouldInit()) {
            LogUtils.e("biniy", "xmpush-1");
            l.c(this, ContentCommon.XM_APP_ID, ContentCommon.XM_APP_KEY);
            l.h(this);
        }
        MMKV.a(this);
        CrashReport.initCrashReport(getApplicationContext(), "b8ba2d2f4f", true);
    }
}
