package c.c.a.b.c.l.m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f3835e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3836a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3837b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("sInstance")
    public final ArrayList<InterfaceC0086a> f3838c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("sInstance")
    public boolean f3839d = false;

    /* renamed from: c.c.a.b.c.l.m.a$a, reason: collision with other inner class name */
    public interface InterfaceC0086a {
        void a(boolean z);
    }

    public static void a(Application application) {
        synchronized (f3835e) {
            if (!f3835e.f3839d) {
                application.registerActivityLifecycleCallbacks(f3835e);
                application.registerComponentCallbacks(f3835e);
                f3835e.f3839d = true;
            }
        }
    }

    public static a b() {
        return f3835e;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f3836a.compareAndSet(true, false);
        this.f3837b.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f3836a.compareAndSet(true, false);
        this.f3837b.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f3836a.compareAndSet(false, true)) {
            this.f3837b.set(true);
            a(true);
        }
    }

    @TargetApi(16)
    public final boolean b(boolean z) {
        if (!this.f3837b.get()) {
            if (!c.c.a.b.c.s.n.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f3837b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f3836a.set(true);
            }
        }
        return a();
    }

    public final boolean a() {
        return this.f3836a.get();
    }

    public final void a(InterfaceC0086a interfaceC0086a) {
        synchronized (f3835e) {
            this.f3838c.add(interfaceC0086a);
        }
    }

    public final void a(boolean z) {
        synchronized (f3835e) {
            ArrayList<InterfaceC0086a> arrayList = this.f3838c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                InterfaceC0086a interfaceC0086a = arrayList.get(i2);
                i2++;
                interfaceC0086a.a(z);
            }
        }
    }
}
