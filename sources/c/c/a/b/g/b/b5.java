package c.c.a.b.g.b;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b5 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4604a;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue<y4<?>> f4605b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4606c = false;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x4 f4607d;

    public b5(x4 x4Var, String str, BlockingQueue<y4<?>> blockingQueue) {
        this.f4607d = x4Var;
        c.c.a.b.c.o.r.a(str);
        c.c.a.b.c.o.r.a(blockingQueue);
        this.f4604a = new Object();
        this.f4605b = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f4604a) {
            this.f4604a.notifyAll();
        }
    }

    public final void b() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        b5 b5Var;
        b5 b5Var2;
        obj = this.f4607d.f5182i;
        synchronized (obj) {
            if (!this.f4606c) {
                semaphore = this.f4607d.j;
                semaphore.release();
                obj2 = this.f4607d.f5182i;
                obj2.notifyAll();
                b5Var = this.f4607d.f5176c;
                if (this == b5Var) {
                    x4.a(this.f4607d, null);
                } else {
                    b5Var2 = this.f4607d.f5177d;
                    if (this == b5Var2) {
                        x4.b(this.f4607d, null);
                    } else {
                        this.f4607d.c().t().a("Current scheduler thread is neither worker nor network");
                    }
                }
                this.f4606c = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore = this.f4607d.j;
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException e2) {
                a(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                y4<?> poll = this.f4605b.poll();
                if (poll == null) {
                    synchronized (this.f4604a) {
                        if (this.f4605b.peek() == null) {
                            z = this.f4607d.k;
                            if (!z) {
                                try {
                                    this.f4604a.wait(30000L);
                                } catch (InterruptedException e3) {
                                    a(e3);
                                }
                            }
                        }
                    }
                    obj = this.f4607d.f5182i;
                    synchronized (obj) {
                        if (this.f4605b.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(poll.f5200b ? threadPriority : 10);
                    poll.run();
                }
            }
            if (this.f4607d.l().a(r.z0)) {
                b();
            }
        } finally {
            b();
        }
    }

    public final void a(InterruptedException interruptedException) {
        this.f4607d.c().w().a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
