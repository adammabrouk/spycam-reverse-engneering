package com.shix.shixipc.utilcode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class ThreadUtils {
    public static final byte TYPE_CACHED = -2;
    public static final byte TYPE_CPU = -8;
    public static final byte TYPE_IO = -4;
    public static final byte TYPE_SINGLE = -1;
    public static Executor sDeliver;
    public static final Handler HANDLER = new Handler(Looper.getMainLooper());
    public static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    public static final Map<Task, ExecutorService> TASK_POOL_MAP = new ConcurrentHashMap();
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    public static final Timer TIMER = new Timer();

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        public int mCapacity;
        public volatile ThreadPoolExecutor4Util mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueue4Util(int i2) {
            this.mCapacity = Integer.MAX_VALUE;
            this.mCapacity = i2;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.shix.shixipc.utilcode.ThreadUtils.Task
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.shix.shixipc.utilcode.ThreadUtils.Task
        public void onFail(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    public static abstract class Task<T> implements Runnable {
        public static final int CANCELLED = 4;
        public static final int COMPLETING = 3;
        public static final int EXCEPTIONAL = 2;
        public static final int INTERRUPTED = 5;
        public static final int NEW = 0;
        public static final int RUNNING = 1;
        public static final int TIMEOUT = 6;
        public Executor deliver;
        public volatile boolean isSchedule;
        public OnTimeoutListener mTimeoutListener;
        public long mTimeoutMillis;
        public Timer mTimer;
        public volatile Thread runner;
        public final AtomicInteger state = new AtomicInteger(0);

        public interface OnTimeoutListener {
            void onTimeout();
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            return executor == null ? ThreadUtils.getGlobalDeliver() : executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z) {
            this.isSchedule = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(6);
                if (this.runner != null) {
                    this.runner.interrupt();
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        public abstract T doInBackground() throws Throwable;

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public abstract void onCancel();

        public void onDone() {
            ThreadUtils.TASK_POOL_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    }
                    this.runner = Thread.currentThread();
                    if (this.mTimeoutListener != null) {
                        Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else {
                if (!this.state.compareAndSet(0, 1)) {
                    return;
                }
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    timer.schedule(new TimerTask() { // from class: com.shix.shixipc.utilcode.ThreadUtils.Task.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            if (Task.this.isDone() || Task.this.mTimeoutListener == null) {
                                return;
                            }
                            Task.this.timeout();
                            Task.this.mTimeoutListener.onTimeout();
                            Task.this.onDone();
                        }
                    }, this.mTimeoutMillis);
                }
            }
            try {
                final T doInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.shix.shixipc.utilcode.ThreadUtils.Task.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                        }
                    });
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new Runnable() { // from class: com.shix.shixipc.utilcode.ThreadUtils.Task.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new Runnable() { // from class: com.shix.shixipc.utilcode.ThreadUtils.Task.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onFail(th);
                            Task.this.onDone();
                        }
                    });
                }
            }
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public Task<T> setTimeout(long j, OnTimeoutListener onTimeoutListener) {
            this.mTimeoutMillis = j;
            this.mTimeoutListener = onTimeoutListener;
            return this;
        }

        public void cancel(boolean z) {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(4);
                if (z && this.runner != null) {
                    this.runner.interrupt();
                }
                getDeliver().execute(new Runnable() { // from class: com.shix.shixipc.utilcode.ThreadUtils.Task.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Task.this.onCancel();
                        Task.this.onDone();
                    }
                });
            }
        }
    }

    public static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        public final AtomicInteger mSubmittedCount;
        public LinkedBlockingQueue4Util mWorkQueue;

        public ThreadPoolExecutor4Util(int i2, int i3, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.mSubmittedCount = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        public static ExecutorService createPool(int i2, int i3) {
            if (i2 == -8) {
                return new ThreadPoolExecutor4Util(ThreadUtils.CPU_COUNT + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i3));
            }
            if (i2 == -4) {
                return new ThreadPoolExecutor4Util((ThreadUtils.CPU_COUNT * 2) + 1, (ThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i3));
            }
            if (i2 == -2) {
                return new ThreadPoolExecutor4Util(0, RecyclerView.c0.FLAG_IGNORE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i3));
            }
            if (i2 == -1) {
                return new ThreadPoolExecutor4Util(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i3));
            }
            return new ThreadPoolExecutor4Util(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i2 + ")", i3));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.mWorkQueue.offer(runnable);
            } catch (Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        public static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        public static final long serialVersionUID = -9209200509960368598L;
        public final boolean isDaemon;
        public final String namePrefix;
        public final int priority;

        public UtilsThreadFactory(String str, int i2) {
            this(str, i2, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.shix.shixipc.utilcode.ThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.shix.shixipc.utilcode.ThreadUtils.UtilsThreadFactory.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    System.out.println(th);
                }
            });
            thread.setPriority(this.priority);
            return thread;
        }

        public UtilsThreadFactory(String str, int i2, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i2;
            this.isDaemon = z;
        }
    }

    public static void cancel(Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    public static <T> void execute(ExecutorService executorService, Task<T> task) {
        execute(executorService, task, 0L, 0L, null);
    }

    public static <T> void executeAtFixedRate(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        execute(executorService, task, j, j2, timeUnit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j, timeUnit);
    }

    public static <T> void executeByCustom(ExecutorService executorService, Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0L, j, timeUnit);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j, timeUnit);
    }

    public static <T> void executeByFixed(int i2, Task<T> task) {
        execute(getPoolByTypeAndPriority(i2), task);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i2, Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i2), task, j, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j, timeUnit);
    }

    public static <T> void executeWithDelay(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        execute(executorService, task, j, 0L, timeUnit);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getFixedPool(int i2) {
        return getPoolByTypeAndPriority(i2);
    }

    public static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() { // from class: com.shix.shixipc.utilcode.ThreadUtils.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    ThreadUtils.runOnUiThread(runnable);
                }
            };
        }
        return sDeliver;
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    public static ExecutorService getPoolByTypeAndPriority(int i2) {
        return getPoolByTypeAndPriority(i2, 5);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j) {
        HANDLER.postDelayed(runnable, j);
    }

    public static void setDeliver(Executor executor) {
        sDeliver = executor;
    }

    public static void cancel(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (Task task : taskArr) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static <T> void execute(final ExecutorService executorService, final Task<T> task, long j, long j2, TimeUnit timeUnit) {
        synchronized (TASK_POOL_MAP) {
            if (TASK_POOL_MAP.get(task) != null) {
                Log.e("ThreadUtils", "Task can only be executed once.");
                return;
            }
            TASK_POOL_MAP.put(task, executorService);
            if (j2 != 0) {
                task.setSchedule(true);
                TIMER.scheduleAtFixedRate(new TimerTask() { // from class: com.shix.shixipc.utilcode.ThreadUtils.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        executorService.execute(task);
                    }
                }, timeUnit.toMillis(j), timeUnit.toMillis(j2));
            } else if (j == 0) {
                executorService.execute(task);
            } else {
                TIMER.schedule(new TimerTask() { // from class: com.shix.shixipc.utilcode.ThreadUtils.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        executorService.execute(task);
                    }
                }, timeUnit.toMillis(j));
            }
        }
    }

    public static <T> void executeByCached(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-2, i2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i2), task, j, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-8, i2), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i2), task, j, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j, j2, timeUnit);
    }

    public static <T> void executeByFixed(int i2, Task<T> task, int i3) {
        execute(getPoolByTypeAndPriority(i2, i3), task);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j, TimeUnit timeUnit, int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i2, Task<T> task, long j, TimeUnit timeUnit, int i3) {
        executeWithDelay(getPoolByTypeAndPriority(i2, i3), task, j, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-4, i2), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i2), task, j, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(-1, i2), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j, TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i2), task, j, timeUnit);
    }

    public static ExecutorService getCachedPool(int i2) {
        return getPoolByTypeAndPriority(-2, i2);
    }

    public static ExecutorService getCpuPool(int i2) {
        return getPoolByTypeAndPriority(-8, i2);
    }

    public static ExecutorService getFixedPool(int i2, int i3) {
        return getPoolByTypeAndPriority(i2, i3);
    }

    public static ExecutorService getIoPool(int i2) {
        return getPoolByTypeAndPriority(-4, i2);
    }

    public static ExecutorService getPoolByTypeAndPriority(int i2, int i3) {
        ExecutorService executorService;
        synchronized (TYPE_PRIORITY_POOLS) {
            Map<Integer, ExecutorService> map = TYPE_PRIORITY_POOLS.get(Integer.valueOf(i2));
            if (map == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = ThreadPoolExecutor4Util.createPool(i2, i3);
                concurrentHashMap.put(Integer.valueOf(i3), executorService);
                TYPE_PRIORITY_POOLS.put(Integer.valueOf(i2), concurrentHashMap);
            } else {
                executorService = map.get(Integer.valueOf(i3));
                if (executorService == null) {
                    executorService = ThreadPoolExecutor4Util.createPool(i2, i3);
                    map.put(Integer.valueOf(i3), executorService);
                }
            }
        }
        return executorService;
    }

    public static ExecutorService getSinglePool(int i2) {
        return getPoolByTypeAndPriority(-1, i2);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2), task, j, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j, j2, timeUnit);
    }

    public static class SyncValue<T> {
        public T mValue;
        public CountDownLatch mLatch = new CountDownLatch(1);
        public AtomicBoolean mFlag = new AtomicBoolean();

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return this.mValue;
        }

        public void setValue(T t) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = t;
                this.mLatch.countDown();
            }
        }

        public T getValue(long j, TimeUnit timeUnit, T t) {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await(j, timeUnit);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return t;
                }
            }
            return this.mValue;
        }
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i2), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i2), task, j, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i2, Task<T> task, long j, long j2, TimeUnit timeUnit, int i3) {
        executeAtFixedRate(getPoolByTypeAndPriority(i2, i3), task, j, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i2), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j, long j2, TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i2), task, j, j2, timeUnit);
    }

    public static void cancel(List<Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Task task : list) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry<Task, ExecutorService> entry : TASK_POOL_MAP.entrySet()) {
                if (entry.getValue() == executorService) {
                    cancel(entry.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }
}
