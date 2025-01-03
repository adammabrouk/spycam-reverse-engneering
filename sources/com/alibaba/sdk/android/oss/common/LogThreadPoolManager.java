package com.alibaba.sdk.android.oss.common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class LogThreadPoolManager {
    public static final int PERIOD_TASK_QOS = 1000;
    public static final int SIZE_CACHE_QUEUE = 200;
    public static final int SIZE_CORE_POOL = 1;
    public static final int SIZE_MAX_POOL = 1;
    public static final int SIZE_WORK_QUEUE = 500;
    public static final int TIME_KEEP_ALIVE = 5000;
    public static LogThreadPoolManager sThreadPoolManager = new LogThreadPoolManager();
    public final Runnable mAccessBufferThread;
    public final ScheduledFuture<?> mTaskHandler;
    public final Queue<Runnable> mTaskQueue = new LinkedList();
    public final RejectedExecutionHandler mHandler = new RejectedExecutionHandler() { // from class: com.alibaba.sdk.android.oss.common.LogThreadPoolManager.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (LogThreadPoolManager.this.mTaskQueue.size() >= 200) {
                LogThreadPoolManager.this.mTaskQueue.poll();
            }
            LogThreadPoolManager.this.mTaskQueue.offer(runnable);
        }
    };
    public final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(1, 1, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(500), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.common.LogThreadPoolManager.2
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-log-thread");
        }
    }, this.mHandler);

    public LogThreadPoolManager() {
        Runnable runnable = new Runnable() { // from class: com.alibaba.sdk.android.oss.common.LogThreadPoolManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (LogThreadPoolManager.this.hasMoreAcquire()) {
                    LogThreadPoolManager.this.mThreadPool.execute((Runnable) LogThreadPoolManager.this.mTaskQueue.poll());
                }
            }
        };
        this.mAccessBufferThread = runnable;
        this.mTaskHandler = this.scheduler.scheduleAtFixedRate(runnable, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMoreAcquire() {
        return !this.mTaskQueue.isEmpty();
    }

    public static LogThreadPoolManager newInstance() {
        if (sThreadPoolManager == null) {
            sThreadPoolManager = new LogThreadPoolManager();
        }
        return sThreadPoolManager;
    }

    public void addExecuteTask(Runnable runnable) {
        if (runnable != null) {
            this.mThreadPool.execute(runnable);
        }
    }
}
