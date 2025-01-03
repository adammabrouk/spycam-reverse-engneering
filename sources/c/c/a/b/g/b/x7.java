package c.c.a.b.g.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzm;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x7 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzm f5186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r7 f5187c;

    public x7(r7 r7Var, AtomicReference atomicReference, zzm zzmVar) {
        this.f5187c = r7Var;
        this.f5185a = atomicReference;
        this.f5186b = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        synchronized (this.f5185a) {
            try {
                try {
                    o3Var = this.f5187c.f5045d;
                } catch (RemoteException e2) {
                    this.f5187c.c().t().a("Failed to get app instance id", e2);
                }
                if (o3Var == null) {
                    this.f5187c.c().t().a("Failed to get app instance id");
                    return;
                }
                this.f5185a.set(o3Var.b(this.f5186b));
                String str = (String) this.f5185a.get();
                if (str != null) {
                    this.f5187c.o().a(str);
                    this.f5187c.k().l.a(str);
                }
                this.f5187c.K();
                this.f5185a.notify();
            } finally {
                this.f5185a.notify();
            }
        }
    }
}
