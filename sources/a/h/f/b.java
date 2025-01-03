package a.h.f;

import android.os.Build;
import android.os.CancellationSignal;

/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1015a;

    /* renamed from: b, reason: collision with root package name */
    public a f1016b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1017c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1018d;

    /* compiled from: CancellationSignal.java */
    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            if (this.f1015a) {
                return;
            }
            this.f1015a = true;
            this.f1018d = true;
            a aVar = this.f1016b;
            Object obj = this.f1017c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1018d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1018d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f1015a;
        }
        return z;
    }

    public final void c() {
        while (this.f1018d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void setOnCancelListener(a aVar) {
        synchronized (this) {
            c();
            if (this.f1016b == aVar) {
                return;
            }
            this.f1016b = aVar;
            if (this.f1015a && aVar != null) {
                aVar.a();
            }
        }
    }
}
