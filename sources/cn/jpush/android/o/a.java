package cn.jpush.android.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.local.JPushConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(14)
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public static int f9817a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f9818b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Activity f9819c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9820d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f9821e = "";

    /* renamed from: f, reason: collision with root package name */
    public static AtomicLong f9822f = new AtomicLong(System.currentTimeMillis());

    /* renamed from: g, reason: collision with root package name */
    public static AtomicLong f9823g = new AtomicLong(System.currentTimeMillis());

    public static long a() {
        return f9822f.get();
    }

    public static Activity a(Context context) {
        if (f9819c != null) {
            cn.jpush.android.r.b.c("DyActivityLifeCallback", "use dLifeCycle activity, " + f9819c.getLocalClassName());
            return f9819c;
        }
        Activity activity = null;
        try {
            if (f9818b != null) {
                cn.jpush.android.r.b.b("DyActivityLifeCallback", "mActivity is null, try to use weakActivity: " + f9818b);
                Activity activity2 = f9818b.get();
                if (activity2 != null) {
                    try {
                        cn.jpush.android.r.b.c("DyActivityLifeCallback", "use weak activity, " + f9818b.get().getLocalClassName());
                    } catch (Throwable unused) {
                        activity = activity2;
                    }
                }
                activity = activity2;
            }
            if (activity == null) {
                activity = cn.jpush.android.bm.a.p(context);
                if (activity != null) {
                    cn.jpush.android.r.b.c("DyActivityLifeCallback", "use current stack activity, " + activity.getLocalClassName());
                    f9818b = new WeakReference<>(activity);
                    if (!f9820d) {
                        cn.jpush.android.r.b.b("DyActivityLifeCallback", "init activity lifecycle for getting current stack activity");
                        f9820d = true;
                        b.a(context);
                    }
                } else {
                    cn.jpush.android.r.b.b("DyActivityLifeCallback", "current stack activity is null");
                }
            }
        } catch (Throwable unused2) {
        }
        return activity;
    }

    public static long b() {
        return f9823g.get();
    }

    public static void c() {
        long currentTimeMillis = System.currentTimeMillis();
        cn.jpush.android.r.b.b("DyActivityLifeCallback", "resetTimeByPageChange, old: " + f9823g.get() + ", new: " + currentTimeMillis);
        f9823g.set(currentTimeMillis);
    }

    public void a(Activity activity) {
        f9819c = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            try {
                cn.jpush.android.an.a.a().c(activity.getApplicationContext(), activity.getClass().getCanonicalName());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            if (f9819c == null || activity == null) {
                return;
            }
            cn.jpush.android.r.b.b("DyActivityLifeCallback", "[onActivityPaused], mActivityName: " + f9819c.getClass().getCanonicalName() + ", activityName: " + activity.getClass().getCanonicalName());
            if (f9819c.getClass().getCanonicalName() != null && f9819c.getClass().getCanonicalName().equals(activity.getClass().getCanonicalName())) {
                f9819c = null;
            }
            f9818b = new WeakReference<>(activity);
            cn.jpush.android.an.a.a().a(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("DyActivityLifeCallback", " onActivityDestroyed error: " + th.getMessage());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity);
        if (activity != null) {
            f9821e = activity.getClass().getCanonicalName();
            cn.jpush.android.an.a.a().b(activity.getApplicationContext(), f9821e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            a(activity);
            if (f9817a == 0) {
                cn.jpush.android.r.b.b("DyActivityLifeCallback", "is Foreground");
                f9822f.set(System.currentTimeMillis());
                b.a(activity.getApplicationContext(), cn.jpush.android.bm.a.a(activity) ? 2 : 1);
            }
            f9817a++;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            if (f9817a > 0) {
                f9817a--;
            }
            if (f9817a != 0 || activity == null) {
                return;
            }
            String canonicalName = activity.getClass().getCanonicalName();
            cn.jpush.android.r.b.b("DyActivityLifeCallback", "onActivityStopped, curClzName: " + canonicalName + ", latestCurClzName: " + f9821e);
            if (!f9821e.equals(canonicalName)) {
                f9817a++;
            } else {
                cn.jpush.android.r.b.b("DyActivityLifeCallback", "is not Foreground");
                b.a(JPushConstants.getAppContext(activity), 0);
            }
        } catch (Throwable unused) {
        }
    }
}
