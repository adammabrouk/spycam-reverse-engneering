package a.h.a;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f863g = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f857a = a();

    /* renamed from: b, reason: collision with root package name */
    public static final Field f858b = b();

    /* renamed from: c, reason: collision with root package name */
    public static final Field f859c = c();

    /* renamed from: d, reason: collision with root package name */
    public static final Method f860d = b(f857a);

    /* renamed from: e, reason: collision with root package name */
    public static final Method f861e = a(f857a);

    /* renamed from: f, reason: collision with root package name */
    public static final Method f862f = c(f857a);

    /* compiled from: ActivityRecreator.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f864a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f865b;

        public a(d dVar, Object obj) {
            this.f864a = dVar;
            this.f865b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f864a.f870a = this.f865b;
        }
    }

    /* compiled from: ActivityRecreator.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f866a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f867b;

        public b(Application application, d dVar) {
            this.f866a = application;
            this.f867b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f866a.unregisterActivityLifecycleCallbacks(this.f867b);
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* renamed from: a.h.a.c$c, reason: collision with other inner class name */
    public class RunnableC0015c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f868a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f869b;

        public RunnableC0015c(Object obj, Object obj2) {
            this.f868a = obj;
            this.f869b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.f860d != null) {
                    c.f860d.invoke(this.f868a, this.f869b, false, "AppCompat recreation");
                } else {
                    c.f861e.invoke(this.f868a, this.f869b, false);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* compiled from: ActivityRecreator.java */
    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public Object f870a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f871b;

        /* renamed from: c, reason: collision with root package name */
        public final int f872c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f873d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f874e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f875f = false;

        public d(Activity activity) {
            this.f871b = activity;
            this.f872c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f871b == activity) {
                this.f871b = null;
                this.f874e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f874e || this.f875f || this.f873d || !c.a(this.f870a, this.f872c, activity)) {
                return;
            }
            this.f875f = true;
            this.f870a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f871b == activity) {
                this.f873d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static boolean a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (d() && f862f == null) {
            return false;
        }
        if (f861e == null && f860d == null) {
            return false;
        }
        try {
            Object obj2 = f859c.get(activity);
            if (obj2 == null || (obj = f858b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f863g.post(new a(dVar, obj2));
            try {
                if (d()) {
                    f862f.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f863g.post(new b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (d() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f859c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f863g.postAtFrontOfQueue(new RunnableC0015c(f858b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
