package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import c.c.a.b.f.e.yc;
import cn.jiguang.internal.JConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r7 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public final j8 f5044c;

    /* renamed from: d, reason: collision with root package name */
    public o3 f5045d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Boolean f5046e;

    /* renamed from: f, reason: collision with root package name */
    public final j f5047f;

    /* renamed from: g, reason: collision with root package name */
    public final d9 f5048g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Runnable> f5049h;

    /* renamed from: i, reason: collision with root package name */
    public final j f5050i;

    public r7(a5 a5Var) {
        super(a5Var);
        this.f5049h = new ArrayList();
        this.f5048g = new d9(a5Var.b());
        this.f5044c = new j8(this);
        this.f5047f = new u7(this, a5Var);
        this.f5050i = new a8(this, a5Var);
    }

    public final boolean A() {
        g();
        w();
        return this.f5045d != null;
    }

    public final void B() {
        g();
        w();
        a(new e8(this, a(true)));
    }

    public final void C() {
        g();
        e();
        w();
        zzm a2 = a(false);
        if (J()) {
            s().A();
        }
        a(new v7(this, a2));
    }

    public final void D() {
        g();
        w();
        zzm a2 = a(true);
        s().B();
        a(new z7(this, a2));
    }

    public final void E() {
        g();
        w();
        if (A()) {
            return;
        }
        if (L()) {
            this.f5044c.b();
            return;
        }
        if (l().u()) {
            return;
        }
        F();
        List<ResolveInfo> queryIntentServices = d().getPackageManager().queryIntentServices(new Intent().setClassName(d(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(queryIntentServices != null && queryIntentServices.size() > 0)) {
            c().t().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context d2 = d();
        F();
        intent.setComponent(new ComponentName(d2, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f5044c.a(intent);
    }

    public final Boolean G() {
        return this.f5046e;
    }

    public final void H() {
        g();
        w();
        this.f5044c.a();
        try {
            c.c.a.b.c.r.a.a().a(d(), this.f5044c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f5045d = null;
    }

    public final boolean I() {
        g();
        w();
        return !L() || j().u() >= 200900;
    }

    public final boolean J() {
        F();
        return true;
    }

    public final void K() {
        g();
        this.f5048g.a();
        this.f5047f.a(r.J.a(null).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean L() {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.r7.L():boolean");
    }

    public final void M() {
        g();
        if (A()) {
            c().B().a("Inactivity, disconnecting from the service");
            H();
        }
    }

    public final void N() {
        g();
        c().B().a("Processing queued up service tasks", Integer.valueOf(this.f5049h.size()));
        Iterator<Runnable> it = this.f5049h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e2) {
                c().t().a("Task exception while flushing queue", e2);
            }
        }
        this.f5049h.clear();
        this.f5050i.c();
    }

    public final void a(o3 o3Var, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int i2;
        List<AbstractSafeParcelable> a2;
        g();
        e();
        w();
        boolean J = J();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!J || (a2 = s().a(100)) == null) {
                i2 = 0;
            } else {
                arrayList.addAll(a2);
                i2 = a2.size();
            }
            if (abstractSafeParcelable != null && i2 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        o3Var.a((zzaq) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        c().t().a("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkn) {
                    try {
                        o3Var.a((zzkn) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        c().t().a("Failed to send user property to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzy) {
                    try {
                        o3Var.a((zzy) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e4) {
                        c().t().a("Failed to send conditional user property to the service", e4);
                    }
                } else {
                    c().t().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i4 = i2;
        }
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return false;
    }

    public final void a(zzaq zzaqVar, String str) {
        c.c.a.b.c.o.r.a(zzaqVar);
        g();
        w();
        boolean J = J();
        a(new c8(this, J, J && s().a(zzaqVar), zzaqVar, a(true), str));
    }

    public final void a(zzy zzyVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        g();
        w();
        F();
        a(new g8(this, true, s().a(zzyVar), new zzy(zzyVar), a(true), zzyVar));
    }

    public final void a(AtomicReference<List<zzy>> atomicReference, String str, String str2, String str3) {
        g();
        w();
        a(new f8(this, atomicReference, str, str2, str3, a(false)));
    }

    public final void a(yc ycVar, String str, String str2) {
        g();
        w();
        a(new i8(this, str, str2, a(false), ycVar));
    }

    public final void a(AtomicReference<List<zzkn>> atomicReference, String str, String str2, String str3, boolean z) {
        g();
        w();
        a(new h8(this, atomicReference, str, str2, str3, z, a(false)));
    }

    public final void a(yc ycVar, String str, String str2, boolean z) {
        g();
        w();
        a(new k8(this, str, str2, z, a(false), ycVar));
    }

    public final void a(zzkn zzknVar) {
        g();
        w();
        a(new t7(this, J() && s().a(zzknVar), zzknVar, a(true)));
    }

    public final void a(AtomicReference<String> atomicReference) {
        g();
        w();
        a(new x7(this, atomicReference, a(false)));
    }

    public final void a(yc ycVar) {
        g();
        w();
        a(new w7(this, a(false), ycVar));
    }

    public final void a(m7 m7Var) {
        g();
        w();
        a(new y7(this, m7Var));
    }

    public final void a(o3 o3Var) {
        g();
        c.c.a.b.c.o.r.a(o3Var);
        this.f5045d = o3Var;
        K();
        N();
    }

    public final void a(ComponentName componentName) {
        g();
        if (this.f5045d != null) {
            this.f5045d = null;
            c().B().a("Disconnected from device MeasurementService", componentName);
            g();
            E();
        }
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        g();
        if (A()) {
            runnable.run();
        } else {
            if (this.f5049h.size() >= 1000) {
                c().t().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f5049h.add(runnable);
            this.f5050i.a(JConstants.MIN);
            E();
        }
    }

    public final zzm a(boolean z) {
        F();
        return p().a(z ? c().C() : null);
    }

    public final void a(yc ycVar, zzaq zzaqVar, String str) {
        g();
        w();
        if (j().a(c.c.a.b.c.h.f3820a) != 0) {
            c().w().a("Not bundling data. Service unavailable or out of date");
            j().a(ycVar, new byte[0]);
        } else {
            a(new b8(this, zzaqVar, str, ycVar));
        }
    }

    public static /* synthetic */ o3 a(r7 r7Var, o3 o3Var) {
        r7Var.f5045d = null;
        return null;
    }
}
