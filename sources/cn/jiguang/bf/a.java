package cn.jiguang.bf;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8694a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0137a f8695b;

    /* renamed from: c, reason: collision with root package name */
    public final e f8696c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8697d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f8698e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f8699f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f8700g;

    /* renamed from: h, reason: collision with root package name */
    public final cn.jiguang.bj.b f8701h;

    /* renamed from: cn.jiguang.bf.a$a, reason: collision with other inner class name */
    public interface InterfaceC0137a {
        void a(cn.jiguang.bg.a aVar);
    }

    public a(long j, boolean z, InterfaceC0137a interfaceC0137a, Context context) {
        this(j, z, interfaceC0137a, new f(), context);
    }

    public a(long j, boolean z, InterfaceC0137a interfaceC0137a, e eVar, Context context) {
        this.f8698e = new AtomicLong(0L);
        this.f8699f = new AtomicBoolean(false);
        this.f8701h = new cn.jiguang.bj.b() { // from class: cn.jiguang.bf.a.1
            @Override // cn.jiguang.bj.b
            public void a() {
                a.this.f8698e.set(0L);
                a.this.f8699f.set(false);
            }
        };
        this.f8694a = z;
        this.f8695b = interfaceC0137a;
        this.f8697d = j;
        this.f8696c = eVar;
        this.f8700g = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("jg_anr_watchdog");
        long j = this.f8697d;
        while (!isInterrupted()) {
            boolean z = false;
            boolean z2 = this.f8698e.get() == 0;
            this.f8698e.addAndGet(j);
            if (z2) {
                this.f8696c.a(this.f8701h);
            }
            try {
                Thread.sleep(j);
                if (this.f8698e.get() != 0 && !this.f8699f.get()) {
                    if (this.f8694a || !(Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.f8700g.getSystemService("activity");
                        if (activityManager != null) {
                            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                            if (processesInErrorState != null) {
                                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    } else if (it.next().condition == 2) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (!z) {
                                }
                            }
                        }
                        cn.jiguang.as.d.g("ANRWatchDog", "Raising ANR");
                        this.f8695b.a(new cn.jiguang.bg.a("Application Not Responding for at least " + this.f8697d + " ms.", this.f8696c.a()));
                        j = this.f8697d;
                    } else {
                        cn.jiguang.as.d.g("ANRWatchDog", "An ANR was detected but ignored because the debugger is connected.");
                    }
                    this.f8699f.set(true);
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                cn.jiguang.as.d.g("ANRWatchDog", String.format("Interrupted: %s", e2.getMessage()));
                return;
            }
        }
    }
}
