package cn.jpush.android.p;

import android.app.Activity;
import android.content.Context;
import cn.jpush.android.local.JPushConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f9831a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f9832b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Activity f9833c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9834d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f9835e = "";

    /* renamed from: f, reason: collision with root package name */
    public static AtomicLong f9836f = new AtomicLong(System.currentTimeMillis());

    /* renamed from: g, reason: collision with root package name */
    public static AtomicLong f9837g = new AtomicLong(System.currentTimeMillis());

    public static long a() {
        return JPushConstants.SDK_VERSION_CODE < 369 ? cn.jpush.android.o.a.a() : f9836f.get();
    }

    public static Activity a(Context context) {
        return JPushConstants.SDK_VERSION_CODE < 369 ? cn.jpush.android.o.a.a(context) : b(context);
    }

    public static long b() {
        return JPushConstants.SDK_VERSION_CODE < 369 ? cn.jpush.android.o.a.b() : f9837g.get();
    }

    public static Activity b(Context context) {
        if (f9833c != null) {
            cn.jpush.android.r.b.c("JPushLifecycleCallback", "use LifeCycle activity, " + f9833c.getLocalClassName());
            return f9833c;
        }
        Activity activity = null;
        try {
            if (f9832b != null) {
                cn.jpush.android.r.b.b("JPushLifecycleCallback", "mActivity is null, try to user weakActivity: " + f9832b);
                Activity activity2 = f9832b.get();
                if (activity2 != null) {
                    try {
                        cn.jpush.android.r.b.c("JPushLifecycleCallback", "use weak activity, " + f9832b.get().getLocalClassName());
                    } catch (Throwable unused) {
                        activity = activity2;
                    }
                }
                activity = activity2;
            }
            if (activity == null) {
                activity = cn.jpush.android.bm.a.p(context);
                if (activity != null) {
                    cn.jpush.android.r.b.c("JPushLifecycleCallback", "use current stack activity, " + activity.getLocalClassName());
                    f9832b = new WeakReference<>(activity);
                    if (!f9834d) {
                        cn.jpush.android.r.b.b("JPushLifecycleCallback", "init activity lifecycle for getting current stack activity");
                        f9834d = true;
                        JPushConstants.init(context);
                    }
                } else {
                    cn.jpush.android.r.b.b("JPushLifecycleCallback", "current stack activity is null");
                }
            }
        } catch (Throwable unused2) {
        }
        return activity;
    }

    public static void c() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f9837g.get();
        if (JPushConstants.SDK_VERSION_CODE < 369) {
            j = cn.jpush.android.o.a.b();
            cn.jpush.android.o.a.c();
        } else {
            f9837g.set(currentTimeMillis);
        }
        cn.jpush.android.r.b.b("JPushLifecycleCallback", "resetTimeByPageChange, old: " + j + ", new: " + currentTimeMillis);
    }

    public void a(Activity activity) {
        f9833c = activity;
    }

    public void b(Activity activity) {
        if (activity != null) {
            try {
                f9835e = activity.getClass().getCanonicalName();
                cn.jpush.android.r.b.b("JPushLifecycleCallback", "[onActivityStarted], activity: " + f9835e + ", activityTaskCount: " + f9831a);
                a(activity);
                if (JPushConstants.getAppContext(activity) != null) {
                    if (f9831a == 0) {
                        cn.jpush.android.r.b.b("JPushLifecycleCallback", "is foreground, change foreground state");
                        f9836f.set(System.currentTimeMillis());
                        cn.jpush.android.o.b.a(activity.getApplicationContext(), cn.jpush.android.bm.a.a(activity) ? 2 : 1);
                    }
                    f9831a++;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c(Activity activity) {
        a(activity);
        if (activity != null) {
            cn.jpush.android.an.a.a().b(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        }
    }

    public void d(Activity activity) {
        try {
            if (f9833c == null || activity == null) {
                return;
            }
            cn.jpush.android.r.b.b("JPushLifecycleCallback", "[onActivityPaused], mActivityName: " + f9833c.getClass().getCanonicalName() + ", activityName: " + activity.getClass().getCanonicalName());
            if (f9833c.getClass().getCanonicalName() != null && f9833c.getClass().getCanonicalName().equals(activity.getClass().getCanonicalName())) {
                f9833c = null;
            }
            f9832b = new WeakReference<>(activity);
            cn.jpush.android.an.a.a().a(activity.getApplicationContext(), activity.getClass().getCanonicalName());
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("JPushLifecycleCallback", " onActivityDestroyed error: " + th.getMessage());
        }
    }

    public void e(Activity activity) {
        if (activity != null) {
            try {
                String canonicalName = activity.getClass().getCanonicalName();
                cn.jpush.android.r.b.b("JPushLifecycleCallback", "[onActivityStopped], curClzName: " + canonicalName + ", latestCurClzName: " + f9835e + ", activityTaskCount: " + f9831a);
                Context appContext = JPushConstants.getAppContext(activity);
                if (f9831a > 0) {
                    f9831a--;
                }
                if (f9831a == 0) {
                    if (!f9835e.equals(canonicalName)) {
                        f9831a++;
                    } else {
                        cn.jpush.android.r.b.b("JPushLifecycleCallback", "is not Foreground, change to foreground state");
                        cn.jpush.android.o.b.a(appContext, 0);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void f(Activity activity) {
        cn.jpush.android.r.b.b("JPushLifecycleCallback", "[onActivityDestroyed]");
        if (activity != null) {
            try {
                cn.jpush.android.an.a.a().c(activity.getApplicationContext(), activity.getClass().getCanonicalName());
            } catch (Throwable unused) {
            }
        }
    }
}
