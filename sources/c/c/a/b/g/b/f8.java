package c.c.a.b.g.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzm;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class f8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4728a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4729b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4730c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4731d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzm f4732e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r7 f4733f;

    public f8(r7 r7Var, AtomicReference atomicReference, String str, String str2, String str3, zzm zzmVar) {
        this.f4733f = r7Var;
        this.f4728a = atomicReference;
        this.f4729b = str;
        this.f4730c = str2;
        this.f4731d = str3;
        this.f4732e = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        synchronized (this.f4728a) {
            try {
                try {
                    o3Var = this.f4733f.f5045d;
                } catch (RemoteException e2) {
                    this.f4733f.c().t().a("(legacy) Failed to get conditional properties; remote exception", w3.a(this.f4729b), this.f4730c, e2);
                    this.f4728a.set(Collections.emptyList());
                }
                if (o3Var == null) {
                    this.f4733f.c().t().a("(legacy) Failed to get conditional properties; not connected to service", w3.a(this.f4729b), this.f4730c, this.f4731d);
                    this.f4728a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f4729b)) {
                    this.f4728a.set(o3Var.a(this.f4730c, this.f4731d, this.f4732e));
                } else {
                    this.f4728a.set(o3Var.b(this.f4729b, this.f4730c, this.f4731d));
                }
                this.f4733f.K();
                this.f4728a.notify();
            } finally {
                this.f4728a.notify();
            }
        }
    }
}
