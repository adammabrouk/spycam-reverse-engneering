package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static u f11184a;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11186c;

    /* renamed from: e, reason: collision with root package name */
    public long f11188e;

    /* renamed from: f, reason: collision with root package name */
    public long f11189f;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, Long> f11187d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f11190g = new LinkedBlockingQueue<>();

    /* renamed from: h, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f11191h = new LinkedBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    public final Object f11192i = new Object();
    public int j = 0;

    /* renamed from: b, reason: collision with root package name */
    public final p f11185b = p.a();

    public u(Context context) {
        this.f11186c = context;
    }

    public static /* synthetic */ int b(u uVar) {
        int i2 = uVar.j - 1;
        uVar.j = i2;
        return i2;
    }

    private void c(int i2) {
        w a2 = w.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f11192i) {
            x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f11190g.size();
            final int size2 = this.f11191h.size();
            if (size == 0 && size2 == 0) {
                x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a2 == null || !a2.c()) {
                size2 = 0;
            }
            for (int i3 = 0; i3 < size; i3++) {
                Runnable peek = this.f11190g.peek();
                if (peek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(peek);
                    this.f11190g.poll();
                } catch (Throwable th) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
            }
            for (int i4 = 0; i4 < size2; i4++) {
                Runnable peek2 = this.f11191h.peek();
                if (peek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(peek2);
                    this.f11191h.poll();
                } catch (Throwable th2) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
            if (size > 0) {
                x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            for (int i5 = 0; i5 < size; i5++) {
                final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.f11192i) {
                    if (this.j < 2 || a2 == null) {
                        x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (z.a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                                synchronized (u.this.f11192i) {
                                    u.b(u.this);
                                }
                            }
                        }, "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f11192i) {
                                this.j++;
                            }
                        } else {
                            x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                            a(runnable, true);
                        }
                    } else {
                        a2.a(runnable);
                    }
                }
            }
            if (size2 > 0) {
                x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            if (a2 != null) {
                a2.a(new Runnable(this) { // from class: com.tencent.bugly.proguard.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable2;
                        for (int i6 = 0; i6 < size2 && (runnable2 = (Runnable) linkedBlockingQueue2.poll()) != null; i6++) {
                            runnable2.run();
                        }
                    }
                });
            }
        }
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f11184a == null) {
                f11184a = new u(context);
            }
            uVar = f11184a;
        }
        return uVar;
    }

    public final boolean b(int i2) {
        if (com.tencent.bugly.b.f10827c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i2);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = f11184a;
        }
        return uVar;
    }

    public final void a(int i2, am amVar, String str, String str2, t tVar, long j, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new v(this.f11186c, i2, amVar.f11077g, a.a((Object) amVar), str, str2, tVar, true, z), true, true, j);
        } catch (Throwable th2) {
            th = th2;
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i2, am amVar, String str, String str2, t tVar, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new v(this.f11186c, i2, amVar.f11077g, a.a((Object) amVar), str, str2, tVar, 0, 0, false, null), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final long a(boolean z) {
        long j;
        long b2 = z.b();
        int i2 = z ? 5 : 3;
        List<r> a2 = this.f11185b.a(i2);
        if (a2 != null && a2.size() > 0) {
            j = 0;
            try {
                r rVar = a2.get(0);
                if (rVar.f11178e >= b2) {
                    j = z.b(rVar.f11180g);
                    if (i2 == 3) {
                        this.f11188e = j;
                    } else {
                        this.f11189f = j;
                    }
                    a2.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            if (a2.size() > 0) {
                this.f11185b.a(a2);
            }
        } else {
            j = z ? this.f11189f : this.f11188e;
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    public final synchronized void a(long j, boolean z) {
        int i2 = z ? 5 : 3;
        r rVar = new r();
        rVar.f11175b = i2;
        rVar.f11178e = z.b();
        rVar.f11176c = "";
        rVar.f11177d = "";
        rVar.f11180g = z.c(j);
        this.f11185b.b(i2);
        this.f11185b.a(rVar);
        if (z) {
            this.f11189f = j;
        } else {
            this.f11188e = j;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public final synchronized void a(int i2, long j) {
        if (i2 < 0) {
            x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
            return;
        }
        this.f11187d.put(Integer.valueOf(i2), Long.valueOf(j));
        r rVar = new r();
        rVar.f11175b = i2;
        rVar.f11178e = j;
        rVar.f11176c = "";
        rVar.f11177d = "";
        rVar.f11180g = new byte[0];
        this.f11185b.b(i2);
        this.f11185b.a(rVar);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), z.a(j));
    }

    public final synchronized long a(int i2) {
        if (i2 >= 0) {
            Long l = this.f11187d.get(Integer.valueOf(i2));
            if (l != null) {
                return l.longValue();
            }
        } else {
            x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return 0L;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f11192i) {
                if (z) {
                    this.f11190g.put(runnable);
                } else {
                    this.f11191h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z2) {
            a(runnable, z);
            c(0);
            return;
        }
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a2 == null) {
            x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j);
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }
}
