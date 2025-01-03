package c.c.a.b.g.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzm;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class h8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4780b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4781c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4782d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4783e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzm f4784f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r7 f4785g;

    public h8(r7 r7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.f4785g = r7Var;
        this.f4779a = atomicReference;
        this.f4780b = str;
        this.f4781c = str2;
        this.f4782d = str3;
        this.f4783e = z;
        this.f4784f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o3 o3Var;
        synchronized (this.f4779a) {
            try {
                try {
                    o3Var = this.f4785g.f5045d;
                } finally {
                    this.f4779a.notify();
                }
            } catch (RemoteException e2) {
                this.f4785g.c().t().a("(legacy) Failed to get user properties; remote exception", w3.a(this.f4780b), this.f4781c, e2);
                this.f4779a.set(Collections.emptyList());
            }
            if (o3Var == null) {
                this.f4785g.c().t().a("(legacy) Failed to get user properties; not connected to service", w3.a(this.f4780b), this.f4781c, this.f4782d);
                this.f4779a.set(Collections.emptyList());
                return;
            }
            if (TextUtils.isEmpty(this.f4780b)) {
                this.f4779a.set(o3Var.a(this.f4781c, this.f4782d, this.f4783e, this.f4784f));
            } else {
                this.f4779a.set(o3Var.a(this.f4780b, this.f4781c, this.f4782d, this.f4783e));
            }
            this.f4785g.K();
            this.f4779a.notify();
        }
    }
}
