package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import c.c.a.b.c.o.r;
import c.c.a.b.f.e.dd;
import c.c.a.b.f.e.ed;
import c.c.a.b.f.e.ta;
import c.c.a.b.f.e.wc;
import c.c.a.b.f.e.yc;
import c.c.a.b.g.b.a5;
import c.c.a.b.g.b.a7;
import c.c.a.b.g.b.b6;
import c.c.a.b.g.b.d7;
import c.c.a.b.g.b.d8;
import c.c.a.b.g.b.e6;
import c.c.a.b.g.b.e9;
import c.c.a.b.g.b.f6;
import c.c.a.b.g.b.h6;
import c.c.a.b.g.b.p6;
import c.c.a.b.g.b.s9;
import c.c.a.b.g.b.w9;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzaa;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends wc {

    /* renamed from: a, reason: collision with root package name */
    public a5 f10200a = null;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, f6> f10201b = new a.e.a();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    public class a implements b6 {

        /* renamed from: a, reason: collision with root package name */
        public dd f10202a;

        public a(dd ddVar) {
            this.f10202a = ddVar;
        }

        @Override // c.c.a.b.g.b.b6
        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f10202a.a(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f10200a.c().w().a("Event interceptor threw exception", e2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    public class b implements f6 {

        /* renamed from: a, reason: collision with root package name */
        public dd f10204a;

        public b(dd ddVar) {
            this.f10204a = ddVar;
        }

        @Override // c.c.a.b.g.b.f6
        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f10204a.a(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f10200a.c().w().a("Event listener threw exception", e2);
            }
        }
    }

    public final void a(yc ycVar, String str) {
        this.f10200a.v().a(ycVar, str);
    }

    @Override // c.c.a.b.f.e.xc
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.f10200a.I().a(str, j);
    }

    @Override // c.c.a.b.f.e.xc
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.f10200a.u().c(str, str2, bundle);
    }

    @Override // c.c.a.b.f.e.xc
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.f10200a.I().b(str, j);
    }

    @Override // c.c.a.b.f.e.xc
    public void generateEventId(yc ycVar) throws RemoteException {
        zza();
        this.f10200a.v().a(ycVar, this.f10200a.v().s());
    }

    @Override // c.c.a.b.f.e.xc
    public void getAppInstanceId(yc ycVar) throws RemoteException {
        zza();
        this.f10200a.a().a(new d7(this, ycVar));
    }

    @Override // c.c.a.b.f.e.xc
    public void getCachedAppInstanceId(yc ycVar) throws RemoteException {
        zza();
        a(ycVar, this.f10200a.u().H());
    }

    @Override // c.c.a.b.f.e.xc
    public void getConditionalUserProperties(String str, String str2, yc ycVar) throws RemoteException {
        zza();
        this.f10200a.a().a(new d8(this, ycVar, str, str2));
    }

    @Override // c.c.a.b.f.e.xc
    public void getCurrentScreenClass(yc ycVar) throws RemoteException {
        zza();
        a(ycVar, this.f10200a.u().K());
    }

    @Override // c.c.a.b.f.e.xc
    public void getCurrentScreenName(yc ycVar) throws RemoteException {
        zza();
        a(ycVar, this.f10200a.u().J());
    }

    @Override // c.c.a.b.f.e.xc
    public void getGmpAppId(yc ycVar) throws RemoteException {
        zza();
        a(ycVar, this.f10200a.u().L());
    }

    @Override // c.c.a.b.f.e.xc
    public void getMaxUserProperties(String str, yc ycVar) throws RemoteException {
        zza();
        this.f10200a.u();
        r.b(str);
        this.f10200a.v().a(ycVar, 25);
    }

    @Override // c.c.a.b.f.e.xc
    public void getTestFlag(yc ycVar, int i2) throws RemoteException {
        zza();
        if (i2 == 0) {
            this.f10200a.v().a(ycVar, this.f10200a.u().C());
            return;
        }
        if (i2 == 1) {
            this.f10200a.v().a(ycVar, this.f10200a.u().D().longValue());
            return;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                this.f10200a.v().a(ycVar, this.f10200a.u().E().intValue());
                return;
            } else {
                if (i2 != 4) {
                    return;
                }
                this.f10200a.v().a(ycVar, this.f10200a.u().B().booleanValue());
                return;
            }
        }
        s9 v = this.f10200a.v();
        double doubleValue = this.f10200a.u().G().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            v.f5160a.c().w().a("Error returning double value to wrapper", e2);
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void getUserProperties(String str, String str2, boolean z, yc ycVar) throws RemoteException {
        zza();
        this.f10200a.a().a(new e9(this, ycVar, str, str2, z));
    }

    @Override // c.c.a.b.f.e.xc
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // c.c.a.b.f.e.xc
    public void initialize(c.c.a.b.d.a aVar, zzaa zzaaVar, long j) throws RemoteException {
        Context context = (Context) c.c.a.b.d.b.a(aVar);
        a5 a5Var = this.f10200a;
        if (a5Var == null) {
            this.f10200a = a5.a(context, zzaaVar, Long.valueOf(j));
        } else {
            a5Var.c().w().a("Attempting to initialize multiple times");
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void isDataCollectionEnabled(yc ycVar) throws RemoteException {
        zza();
        this.f10200a.a().a(new w9(this, ycVar));
    }

    @Override // c.c.a.b.f.e.xc
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.f10200a.u().a(str, str2, bundle, z, z2, j);
    }

    @Override // c.c.a.b.f.e.xc
    public void logEventAndBundle(String str, String str2, Bundle bundle, yc ycVar, long j) throws RemoteException {
        zza();
        r.b(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f10200a.a().a(new e6(this, ycVar, new zzaq(str2, new zzal(bundle), "app", j), str));
    }

    @Override // c.c.a.b.f.e.xc
    public void logHealthData(int i2, String str, c.c.a.b.d.a aVar, c.c.a.b.d.a aVar2, c.c.a.b.d.a aVar3) throws RemoteException {
        zza();
        this.f10200a.c().a(i2, true, false, str, aVar == null ? null : c.c.a.b.d.b.a(aVar), aVar2 == null ? null : c.c.a.b.d.b.a(aVar2), aVar3 != null ? c.c.a.b.d.b.a(aVar3) : null);
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityCreated(c.c.a.b.d.a aVar, Bundle bundle, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityCreated((Activity) c.c.a.b.d.b.a(aVar), bundle);
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityDestroyed(c.c.a.b.d.a aVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityDestroyed((Activity) c.c.a.b.d.b.a(aVar));
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityPaused(c.c.a.b.d.a aVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityPaused((Activity) c.c.a.b.d.b.a(aVar));
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityResumed(c.c.a.b.d.a aVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityResumed((Activity) c.c.a.b.d.b.a(aVar));
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivitySaveInstanceState(c.c.a.b.d.a aVar, yc ycVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        Bundle bundle = new Bundle();
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivitySaveInstanceState((Activity) c.c.a.b.d.b.a(aVar), bundle);
        }
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f10200a.c().w().a("Error returning bundle value to wrapper", e2);
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityStarted(c.c.a.b.d.a aVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityStarted((Activity) c.c.a.b.d.b.a(aVar));
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void onActivityStopped(c.c.a.b.d.a aVar, long j) throws RemoteException {
        zza();
        a7 a7Var = this.f10200a.u().f4767c;
        if (a7Var != null) {
            this.f10200a.u().A();
            a7Var.onActivityStopped((Activity) c.c.a.b.d.b.a(aVar));
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void performAction(Bundle bundle, yc ycVar, long j) throws RemoteException {
        zza();
        ycVar.a(null);
    }

    @Override // c.c.a.b.f.e.xc
    public void registerOnMeasurementEventListener(dd ddVar) throws RemoteException {
        zza();
        f6 f6Var = this.f10201b.get(Integer.valueOf(ddVar.zza()));
        if (f6Var == null) {
            f6Var = new b(ddVar);
            this.f10201b.put(Integer.valueOf(ddVar.zza()), f6Var);
        }
        this.f10200a.u().a(f6Var);
    }

    @Override // c.c.a.b.f.e.xc
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.f10200a.u().c(j);
    }

    @Override // c.c.a.b.f.e.xc
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.f10200a.c().t().a("Conditional user property must not be null");
        } else {
            this.f10200a.u().a(bundle, j);
        }
    }

    @Override // c.c.a.b.f.e.xc
    public void setCurrentScreen(c.c.a.b.d.a aVar, String str, String str2, long j) throws RemoteException {
        zza();
        this.f10200a.D().a((Activity) c.c.a.b.d.b.a(aVar), str, str2);
    }

    @Override // c.c.a.b.f.e.xc
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.f10200a.u().b(z);
    }

    @Override // c.c.a.b.f.e.xc
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        final h6 u = this.f10200a.u();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        u.a().a(new Runnable(u, bundle2) { // from class: c.c.a.b.g.b.g6

            /* renamed from: a, reason: collision with root package name */
            public final h6 f4742a;

            /* renamed from: b, reason: collision with root package name */
            public final Bundle f4743b;

            {
                this.f4742a = u;
                this.f4743b = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h6 h6Var = this.f4742a;
                Bundle bundle3 = this.f4743b;
                if (ta.a() && h6Var.l().a(r.O0)) {
                    if (bundle3 == null) {
                        h6Var.k().D.a(new Bundle());
                        return;
                    }
                    Bundle a2 = h6Var.k().D.a();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            h6Var.j();
                            if (s9.a(obj)) {
                                h6Var.j().a(27, (String) null, (String) null, 0);
                            }
                            h6Var.c().y().a("Invalid default event parameter type. Name, value", str, obj);
                        } else if (s9.i(str)) {
                            h6Var.c().y().a("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            a2.remove(str);
                        } else if (h6Var.j().a("param", str, 100, obj)) {
                            h6Var.j().a(a2, str, obj);
                        }
                    }
                    h6Var.j();
                    if (s9.a(a2, h6Var.l().m())) {
                        h6Var.j().a(26, (String) null, (String) null, 0);
                        h6Var.c().y().a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    h6Var.k().D.a(a2);
                }
            }
        });
    }

    @Override // c.c.a.b.f.e.xc
    public void setEventInterceptor(dd ddVar) throws RemoteException {
        zza();
        h6 u = this.f10200a.u();
        a aVar = new a(ddVar);
        u.e();
        u.w();
        u.a().a(new p6(u, aVar));
    }

    @Override // c.c.a.b.f.e.xc
    public void setInstanceIdProvider(ed edVar) throws RemoteException {
        zza();
    }

    @Override // c.c.a.b.f.e.xc
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.f10200a.u().a(z);
    }

    @Override // c.c.a.b.f.e.xc
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.f10200a.u().a(j);
    }

    @Override // c.c.a.b.f.e.xc
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.f10200a.u().b(j);
    }

    @Override // c.c.a.b.f.e.xc
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.f10200a.u().a(null, "_id", str, true, j);
    }

    @Override // c.c.a.b.f.e.xc
    public void setUserProperty(String str, String str2, c.c.a.b.d.a aVar, boolean z, long j) throws RemoteException {
        zza();
        this.f10200a.u().a(str, str2, c.c.a.b.d.b.a(aVar), z, j);
    }

    @Override // c.c.a.b.f.e.xc
    public void unregisterOnMeasurementEventListener(dd ddVar) throws RemoteException {
        zza();
        f6 remove = this.f10201b.remove(Integer.valueOf(ddVar.zza()));
        if (remove == null) {
            remove = new b(ddVar);
        }
        this.f10200a.u().b(remove);
    }

    public final void zza() {
        if (this.f10200a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }
}
