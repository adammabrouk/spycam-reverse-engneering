package com.shix.shixipc.utilcode;

import a.m.f;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public final class Utils {

    @SuppressLint({"StaticFieldLeak"})
    public static Application sApp;

    public static class ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onLifecycleChanged(Activity activity, f.b bVar) {
        }
    }

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Func1<Ret, Par> {
        Ret call(Par par);
    }

    public interface OnAppStatusChangedListener {
        void onBackground(Activity activity);

        void onForeground(Activity activity);
    }

    public interface Supplier<T> {
        T get();
    }

    public static abstract class Task<Result> extends ThreadUtils.SimpleTask<Result> {
        public Consumer<Result> mConsumer;

        public Task(Consumer<Result> consumer) {
            this.mConsumer = consumer;
        }

        @Override // com.shix.shixipc.utilcode.ThreadUtils.Task
        public void onSuccess(Result result) {
            Consumer<Result> consumer = this.mConsumer;
            if (consumer != null) {
                consumer.accept(result);
            }
        }
    }

    public Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Application getApp() {
        Application application = sApp;
        if (application != null) {
            return application;
        }
        init(UtilsBridge.getApplicationByReflect());
        if (sApp == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", UtilsBridge.getCurrentProcessName() + " reflect app success.");
        return sApp;
    }

    public static void init(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = sApp;
        if (application2 == null) {
            sApp = application;
            UtilsBridge.init(application);
            UtilsBridge.preLoad();
        } else {
            if (application2.equals(application)) {
                return;
            }
            UtilsBridge.unInit(sApp);
            sApp = application;
            UtilsBridge.init(application);
        }
    }
}
