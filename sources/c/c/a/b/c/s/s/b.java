package c.c.a.b.c.s.s;

import android.os.Process;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f4024a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4025b;

    public b(Runnable runnable, int i2) {
        this.f4024a = runnable;
        this.f4025b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f4025b);
        this.f4024a.run();
    }
}
