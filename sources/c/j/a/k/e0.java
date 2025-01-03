package c.j.a.k;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: OnNotificationClickTask.java */
/* loaded from: classes.dex */
public final class e0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6583a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f6584b;

    public e0(d0 d0Var, Context context, Map map) {
        this.f6583a = context;
        this.f6584b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f6583a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f6583a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        c.j.a.z.v.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        d0.a(intent, this.f6584b);
                        this.f6583a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            c.j.a.z.v.a("OnNotificationClickTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f6583a.getPackageManager().getLaunchIntentForPackage(this.f6583a.getPackageName());
        if (launchIntentForPackage == null) {
            c.j.a.z.v.a("OnNotificationClickTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        d0.a(launchIntentForPackage, this.f6584b);
        this.f6583a.startActivity(launchIntentForPackage);
    }
}
