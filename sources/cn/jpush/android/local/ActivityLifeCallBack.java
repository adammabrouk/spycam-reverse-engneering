package cn.jpush.android.local;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import cn.jpush.android.helper.Logger;

@TargetApi(14)
/* loaded from: classes.dex */
public class ActivityLifeCallBack implements Application.ActivityLifecycleCallbacks {
    public static final String TAG = "ActivityLifeCallBack";
    public static int activityTaskCount = 0;
    public static String gLatestActivityName = "";

    public static void syncActivityTaskCount() {
        int i2 = activityTaskCount;
        if (i2 == 0) {
            activityTaskCount = i2 + 1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "destroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "paused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "resumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "started");
        if (activityTaskCount == 0) {
            Logger.d(TAG, "is Foreground");
            if (activity != null) {
                JPushConstants.changeForegroudStat(activity.getApplicationContext(), true);
            }
        }
        gLatestActivityName = activity.getClass().getCanonicalName();
        activityTaskCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ActionHelper.getInstance().onActivityLifeCallback(activity, "stopped");
        int i2 = activityTaskCount;
        if (i2 > 0) {
            activityTaskCount = i2 - 1;
        }
        if (activityTaskCount != 0 || activity == null) {
            return;
        }
        String canonicalName = activity.getClass().getCanonicalName();
        Logger.d(TAG, "onActivityStopped, curClzName: " + canonicalName + ", latestCurClzName: " + gLatestActivityName);
        if (!gLatestActivityName.equals(canonicalName)) {
            activityTaskCount++;
        } else {
            Logger.d(TAG, "is not Foreground");
            JPushConstants.changeForegroudStat(activity.getApplicationContext(), false);
        }
    }
}
