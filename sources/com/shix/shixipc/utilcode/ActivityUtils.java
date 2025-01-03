package com.shix.shixipc.utilcode;

import a.h.a.b;
import a.h.i.d;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.shix.shixipc.utilcode.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class ActivityUtils {
    public ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void finishActivity(Activity activity) {
        finishActivity(activity, false);
    }

    public static void finishAllActivities() {
        finishAllActivities(false);
    }

    public static void finishAllActivitiesExceptNewest() {
        finishAllActivitiesExceptNewest(false);
    }

    public static void finishOtherActivities(Class<? extends Activity> cls) {
        finishOtherActivities(cls, false);
    }

    public static boolean finishToActivity(Activity activity, boolean z) {
        return finishToActivity(activity, z, false);
    }

    public static Activity getActivityByContext(Context context) {
        if (context == null) {
            return null;
        }
        Activity activityByContextInner = getActivityByContextInner(context);
        if (isActivityAlive(activityByContextInner)) {
            return activityByContextInner;
        }
        return null;
    }

    public static Activity getActivityByContextInner(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (!(context instanceof Activity)) {
                Activity activityFromDecorContext = getActivityFromDecorContext(context);
                if (activityFromDecorContext == null) {
                    arrayList.add(context);
                    context = ((ContextWrapper) context).getBaseContext();
                    if (context == null || arrayList.contains(context)) {
                        break;
                    }
                } else {
                    return activityFromDecorContext;
                }
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Activity getActivityFromDecorContext(Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Drawable getActivityIcon(Activity activity) {
        return getActivityIcon(activity.getComponentName());
    }

    public static List<Activity> getActivityList() {
        return UtilsBridge.getActivityList();
    }

    public static Drawable getActivityLogo(Activity activity) {
        return getActivityLogo(activity.getComponentName());
    }

    public static String getLauncherActivity() {
        return getLauncherActivity(Utils.getApp().getPackageName());
    }

    public static List<String> getMainActivities() {
        return getMainActivities(Utils.getApp().getPackageName());
    }

    public static Bundle getOptionsBundle(Fragment fragment, int i2, int i3) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return b.a(activity, i2, i3).a();
    }

    public static Activity getTopActivity() {
        return UtilsBridge.getTopActivity();
    }

    public static Context getTopActivityOrApp() {
        if (!UtilsBridge.isAppForeground()) {
            return Utils.getApp();
        }
        Activity topActivity = getTopActivity();
        return topActivity == null ? Utils.getApp() : topActivity;
    }

    public static boolean isActivityAlive(Context context) {
        return isActivityAlive(getActivityByContext(context));
    }

    public static boolean isActivityExists(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        PackageManager packageManager = Utils.getApp().getPackageManager();
        return (packageManager.resolveActivity(intent, 0) == null || intent.resolveActivity(packageManager) == null || packageManager.queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean isActivityExistsInStack(Activity activity) {
        Iterator<Activity> it = UtilsBridge.getActivityList().iterator();
        while (it.hasNext()) {
            if (it.next().equals(activity)) {
                return true;
            }
        }
        return false;
    }

    public static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void startActivities(Intent[] intentArr) {
        startActivities(intentArr, getTopActivityOrApp(), (Bundle) null);
    }

    public static void startActivity(Class<? extends Activity> cls) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startHomeActivity() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public static void startLauncherActivity() {
        startLauncherActivity(Utils.getApp().getPackageName());
    }

    public static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    public static void finishActivity(Activity activity, boolean z) {
        activity.finish();
        if (z) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void finishAllActivities(boolean z) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            activity.finish();
            if (!z) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    public static void finishAllActivitiesExceptNewest(boolean z) {
        List<Activity> activityList = UtilsBridge.getActivityList();
        for (int i2 = 1; i2 < activityList.size(); i2++) {
            finishActivity(activityList.get(i2), z);
        }
    }

    public static void finishOtherActivities(Class<? extends Activity> cls, boolean z) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (!activity.getClass().equals(cls)) {
                finishActivity(activity, z);
            }
        }
    }

    public static boolean finishToActivity(Activity activity, boolean z, boolean z2) {
        for (Activity activity2 : UtilsBridge.getActivityList()) {
            if (activity2.equals(activity)) {
                if (!z) {
                    return true;
                }
                finishActivity(activity2, z2);
                return true;
            }
            finishActivity(activity2, z2);
        }
        return false;
    }

    public static Drawable getActivityIcon(Class<? extends Activity> cls) {
        return getActivityIcon(new ComponentName(Utils.getApp(), cls));
    }

    public static Drawable getActivityLogo(Class<? extends Activity> cls) {
        return getActivityLogo(new ComponentName(Utils.getApp(), cls));
    }

    public static String getLauncherActivity(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
        return (queryIntentActivities == null || queryIntentActivities.size() == 0) ? "" : queryIntentActivities.get(0).activityInfo.name;
    }

    public static List<String> getMainActivities(String str) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
        int size = queryIntentActivities.size();
        if (size == 0) {
            return arrayList;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ResolveInfo resolveInfo = queryIntentActivities.get(i2);
            if (resolveInfo.activityInfo.processName.equals(str)) {
                arrayList.add(resolveInfo.activityInfo.name);
            }
        }
        return arrayList;
    }

    public static boolean isActivityAlive(Activity activity) {
        return (activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) ? false : true;
    }

    public static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity);
    }

    public static void startActivities(Intent[] intentArr, Bundle bundle) {
        startActivities(intentArr, getTopActivityOrApp(), bundle);
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, Bundle bundle) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, bundle);
    }

    public static void startLauncherActivity(String str) {
        String launcherActivity = getLauncherActivity(str);
        if (TextUtils.isEmpty(launcherActivity)) {
            return;
        }
        startActivity(str, launcherActivity);
    }

    public static Drawable getActivityIcon(ComponentName componentName) {
        try {
            return Utils.getApp().getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable getActivityLogo(ComponentName componentName) {
        try {
            return Utils.getApp().getPackageManager().getActivityLogo(componentName);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bundle getOptionsBundle(Context context, int i2, int i3) {
        return b.a(context, i2, i3).a();
    }

    public static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    public static void startActivities(Intent[] intentArr, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivities(intentArr, topActivityOrApp, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT >= 16 || !(topActivityOrApp instanceof Activity)) {
            return;
        }
        ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
    }

    public static void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, View... viewArr) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, viewArr));
    }

    public static void finishActivity(Activity activity, int i2, int i3) {
        activity.finish();
        activity.overridePendingTransition(i2, i3);
    }

    public static Bundle getOptionsBundle(Fragment fragment, View[] viewArr) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return getOptionsBundle(activity, viewArr);
    }

    public static boolean isActivityExistsInStack(Class<? extends Activity> cls) {
        Iterator<Activity> it = UtilsBridge.getActivityList().iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public static void finishAllActivitiesExceptNewest(int i2, int i3) {
        List<Activity> activityList = UtilsBridge.getActivityList();
        for (int i4 = 1; i4 < activityList.size(); i4++) {
            finishActivity(activityList.get(i4), i2, i3);
        }
    }

    public static void startActivity(Class<? extends Activity> cls, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT >= 16 || !(topActivityOrApp instanceof Activity)) {
            return;
        }
        ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
    }

    public static void finishActivity(Class<? extends Activity> cls) {
        finishActivity(cls, false);
    }

    public static void finishAllActivities(int i2, int i3) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            activity.finish();
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void finishOtherActivities(Class<? extends Activity> cls, int i2, int i3) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (!activity.getClass().equals(cls)) {
                finishActivity(activity, i2, i3);
            }
        }
    }

    public static Bundle getOptionsBundle(Activity activity, View[] viewArr) {
        int length;
        if (Build.VERSION.SDK_INT < 21 || viewArr == null || (length = viewArr.length) <= 0) {
            return null;
        }
        d[] dVarArr = new d[length];
        for (int i2 = 0; i2 < length; i2++) {
            dVarArr[i2] = d.a(viewArr[i2], viewArr[i2].getTransitionName());
        }
        return b.a(activity, dVarArr).a();
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, int i3, int i4) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void finishActivity(Class<? extends Activity> cls, boolean z) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                if (!z) {
                    activity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static boolean finishToActivity(Activity activity, boolean z, int i2, int i3) {
        for (Activity activity2 : UtilsBridge.getActivityList()) {
            if (activity2.equals(activity)) {
                if (!z) {
                    return true;
                }
                finishActivity(activity2, i2, i3);
                return true;
            }
            finishActivity(activity2, i2, i3);
        }
        return false;
    }

    public static void startActivities(Activity activity, Intent[] intentArr) {
        startActivities(intentArr, activity, (Bundle) null);
    }

    public static void startActivities(Activity activity, Intent[] intentArr, Bundle bundle) {
        startActivities(intentArr, activity, bundle);
    }

    public static void startActivities(Activity activity, Intent[] intentArr, int i2, int i3) {
        startActivities(intentArr, activity, getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void finishActivity(Class<? extends Activity> cls, int i2, int i3) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                activity.overridePendingTransition(i2, i3);
            }
        }
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z) {
        return finishToActivity(cls, z, false);
    }

    public static void startActivities(Intent[] intentArr, Context context, Bundle bundle) {
        if (!(context instanceof Activity)) {
            for (Intent intent : intentArr) {
                intent.addFlags(268435456);
            }
        }
        if (bundle != null && Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, Bundle bundle) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, Bundle bundle2) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, bundle2);
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z, boolean z2) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (activity.getClass().equals(cls)) {
                if (!z) {
                    return true;
                }
                finishActivity(activity, z2);
                return true;
            }
            finishActivity(activity, z2);
        }
        return false;
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, View... viewArr) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, View... viewArr) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, int i2, int i3) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, int i3, int i4) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z, int i2, int i3) {
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (activity.getClass().equals(cls)) {
                if (!z) {
                    return true;
                }
                finishActivity(activity, i2, i3);
                return true;
            }
            finishActivity(activity, i2, i3);
        }
        return false;
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2) {
        startActivityForResult(activity, bundle, str, str2, i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, Bundle bundle2) {
        startActivityForResult(activity, bundle, str, str2, i2, bundle2);
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls, Bundle bundle2) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, View... viewArr) {
        startActivityForResult(activity, bundle, str, str2, i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT >= 16 || !(topActivityOrApp instanceof Activity)) {
            return;
        }
        ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, int i3, int i4) {
        startActivityForResult(activity, bundle, str, str2, i2, getOptionsBundle(activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2) {
        startActivityForResult(intent, activity, i2, (Bundle) null);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, Bundle bundle) {
        startActivityForResult(intent, activity, i2, bundle);
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, View... viewArr) {
        startActivityForResult(intent, activity, i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, Bundle bundle2) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, View... viewArr) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, int i3, int i4) {
        startActivityForResult(intent, activity, i2, getOptionsBundle(activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, int i3) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2) {
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, Bundle bundle) {
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, bundle);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, View... viewArr) {
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivity(String str, String str2) {
        startActivity(getTopActivityOrApp(), (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivity(String str, String str2, Bundle bundle) {
        startActivity(getTopActivityOrApp(), (Bundle) null, str, str2, bundle);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, int i3, int i4) {
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivity(String str, String str2, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, str, str2, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT >= 16 || !(topActivityOrApp instanceof Activity)) {
            return;
        }
        ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2) {
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, Bundle bundle2) {
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, bundle2);
    }

    public static void startActivity(Activity activity, String str, String str2) {
        startActivity(activity, (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, View... viewArr) {
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivity(Activity activity, String str, String str2, Bundle bundle) {
        startActivity(activity, (Bundle) null, str, str2, bundle);
    }

    public static void startActivity(Activity activity, String str, String str2, View... viewArr) {
        startActivity(activity, (Bundle) null, str, str2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Activity activity, String str, String str2, int i2, int i3) {
        startActivity(activity, (Bundle) null, str, str2, getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, int i3, int i4) {
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivity(Bundle bundle, String str, String str2) {
        startActivity(getTopActivityOrApp(), bundle, str, str2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2) {
        startActivityForResult(fragment, bundle, str, str2, i2, (Bundle) null);
    }

    public static void startActivity(Bundle bundle, String str, String str2, Bundle bundle2) {
        startActivity(getTopActivityOrApp(), bundle, str, str2, bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, Bundle bundle2) {
        startActivityForResult(fragment, bundle, str, str2, i2, bundle2);
    }

    public static void startActivity(Bundle bundle, String str, String str2, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, str, str2, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT >= 16 || !(topActivityOrApp instanceof Activity)) {
            return;
        }
        ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, View... viewArr) {
        startActivityForResult(fragment, bundle, str, str2, i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, int i3, int i4) {
        startActivityForResult(fragment, bundle, str, str2, i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2) {
        startActivity(activity, bundle, str, str2, (Bundle) null);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2) {
        startActivityForResult(intent, fragment, i2, (Bundle) null);
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, Bundle bundle2) {
        startActivity(activity, bundle, str, str2, bundle2);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        startActivityForResult(intent, fragment, i2, bundle);
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, View... viewArr) {
        startActivity(activity, bundle, str, str2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, View... viewArr) {
        startActivityForResult(intent, fragment, i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, int i2, int i3) {
        startActivity(activity, bundle, str, str2, getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, int i3, int i4) {
        startActivityForResult(intent, fragment, i2, getOptionsBundle(fragment, i3, i4));
    }

    public static boolean startActivity(Intent intent) {
        return startActivity(intent, getTopActivityOrApp(), (Bundle) null);
    }

    public static boolean startActivityForResult(Activity activity, Bundle bundle, String str, String str2, int i2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, activity, i2, bundle2);
    }

    public static boolean startActivity(Intent intent, Bundle bundle) {
        return startActivity(intent, getTopActivityOrApp(), bundle);
    }

    public static boolean startActivity(Intent intent, int i2, int i3) {
        Context topActivityOrApp = getTopActivityOrApp();
        boolean startActivity = startActivity(intent, topActivityOrApp, getOptionsBundle(topActivityOrApp, i2, i3));
        if (startActivity && Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
        return startActivity;
    }

    public static boolean startActivityForResult(Intent intent, Activity activity, int i2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    activity.startActivityForResult(intent, i2, bundle);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("ActivityUtils", "An exception occurred in startActivityForResult, error message: " + e2.getLocalizedMessage());
                return false;
            }
        }
        activity.startActivityForResult(intent, i2);
        return true;
    }

    public static void startActivity(Activity activity, Intent intent) {
        startActivity(intent, activity, (Bundle) null);
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle) {
        startActivity(intent, activity, bundle);
    }

    public static void startActivity(Activity activity, Intent intent, View... viewArr) {
        startActivity(intent, activity, getOptionsBundle(activity, viewArr));
    }

    public static boolean startActivityForResult(Fragment fragment, Bundle bundle, String str, String str2, int i2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, fragment, i2, bundle2);
    }

    public static void startActivity(Activity activity, Intent intent, int i2, int i3) {
        startActivity(intent, activity, getOptionsBundle(activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Context context, Bundle bundle, String str, String str2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        startActivity(intent, context, bundle2);
    }

    public static boolean startActivityForResult(Intent intent, Fragment fragment, int i2, Bundle bundle) {
        if (fragment.getActivity() == null) {
            Log.e("ActivityUtils", "Fragment " + fragment + " not attached to Activity");
            return false;
        }
        if (bundle != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    fragment.startActivityForResult(intent, i2, bundle);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("ActivityUtils", "An exception occurred in fragment.startActivityForResult, error message: " + e2.getLocalizedMessage());
                return false;
            }
        }
        fragment.startActivityForResult(intent, i2);
        return true;
    }

    public static boolean startActivity(Intent intent, Context context, Bundle bundle) {
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    context.startActivity(intent, bundle);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("ActivityUtils", "An exception occurred in startActivity, error message: " + e2.getLocalizedMessage());
                return false;
            }
        }
        context.startActivity(intent);
        return true;
    }
}
