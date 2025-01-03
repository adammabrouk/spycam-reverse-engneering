package com.google.zxing.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class InactivityTimer {
    public static final int INACTIVITY_DELAY_SECONDS = 300;
    public final Activity activity;
    public final ScheduledExecutorService inactivityTimer = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());
    public ScheduledFuture<?> inactivityFuture = null;

    public static final class DaemonThreadFactory implements ThreadFactory {
        public DaemonThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public InactivityTimer(Activity activity) {
        this.activity = activity;
        onActivity();
    }

    private void cancel() {
        ScheduledFuture<?> scheduledFuture = this.inactivityFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.inactivityFuture = null;
        }
    }

    public void onActivity() {
        cancel();
        this.inactivityFuture = this.inactivityTimer.schedule(new FinishListener(this.activity), 300L, TimeUnit.SECONDS);
    }

    public void shutdown() {
        cancel();
        this.inactivityTimer.shutdown();
    }
}
