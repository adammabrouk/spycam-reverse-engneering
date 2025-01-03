package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class ab extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11043a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11044b = false;

    /* renamed from: c, reason: collision with root package name */
    public List<aa> f11045c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public List<ac> f11046d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<aa> f11047e = new ArrayList<>();

    private int e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f11045c.size(); i3++) {
            try {
                i2 = Math.max(i2, this.f11045c.get(i3).c());
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        return i2;
    }

    public final void a() {
        a(new Handler(Looper.getMainLooper()), 5000L);
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f11045c.size(); i2++) {
            try {
                if (this.f11045c.get(i2).d().equals(Looper.getMainLooper().getThread().getName())) {
                    x.c("remove handler::%s", this.f11045c.get(i2));
                    this.f11045c.remove(i2);
                }
            } catch (Exception e2) {
                x.b(e2);
                return;
            }
        }
    }

    public final boolean c() {
        this.f11043a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            x.b(e2);
        }
        return true;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            x.b(e2);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f11043a) {
            for (int i2 = 0; i2 < this.f11045c.size(); i2++) {
                try {
                    this.f11045c.get(i2).a();
                } catch (Exception e2) {
                    x.b(e2);
                } catch (OutOfMemoryError e3) {
                    x.b(e3);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j);
            }
            int e4 = e();
            if (e4 != 0 && e4 != 1) {
                this.f11047e.clear();
                for (int i3 = 0; i3 < this.f11045c.size(); i3++) {
                    aa aaVar = this.f11045c.get(i3);
                    if (aaVar.b()) {
                        this.f11047e.add(aaVar);
                        aaVar.a(RecyclerView.FOREVER_NS);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler == null || !nativeCrashHandler.isEnableCatchAnrTrace()) {
                    x.c("do not enable jni mannual dump anr trace", new Object[0]);
                } else {
                    nativeCrashHandler.dumpAnrNativeStack();
                    x.c("jni mannual dump anr trace", new Object[0]);
                }
                int i4 = 0;
                while (true) {
                    if (this.f11044b) {
                        break;
                    }
                    x.c("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i4++;
                    if (i4 == 15) {
                        this.f11047e.clear();
                        break;
                    }
                }
                for (int i5 = 0; i5 < this.f11047e.size(); i5++) {
                    aa aaVar2 = this.f11047e.get(i5);
                    for (int i6 = 0; i6 < this.f11046d.size(); i6++) {
                        x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f11046d.get(i6).a(aaVar2);
                        this.f11044b = false;
                    }
                }
            }
        }
    }

    private void a(Handler handler, long j) {
        if (handler == null) {
            x.e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f11045c.size(); i2++) {
            try {
                if (this.f11045c.get(i2).d().equals(handler.getLooper().getThread().getName())) {
                    x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        this.f11045c.add(new aa(handler, name, 5000L));
    }

    public final void b(ac acVar) {
        this.f11046d.remove(acVar);
    }

    public final void a(ac acVar) {
        if (this.f11046d.contains(acVar)) {
            x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f11046d.add(acVar);
        }
    }

    public final void a(boolean z) {
        this.f11044b = true;
    }
}
