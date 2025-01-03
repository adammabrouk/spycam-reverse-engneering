package c.c.a.b.g.b;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import c.c.a.b.g.b.t8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class p8<T extends Context & t8> {

    /* renamed from: a, reason: collision with root package name */
    public final T f5008a;

    public p8(T t) {
        c.c.a.b.c.o.r.a(t);
        this.f5008a = t;
    }

    public final void a() {
        a5 a2 = a5.a(this.f5008a, null, null);
        w3 c2 = a2.c();
        a2.F();
        c2.B().a("Local AppMeasurementService is starting up");
    }

    public final void b() {
        a5 a2 = a5.a(this.f5008a, null, null);
        w3 c2 = a2.c();
        a2.F();
        c2.B().a("Local AppMeasurementService is shutting down");
    }

    public final void c(Intent intent) {
        if (intent == null) {
            c().t().a("onRebind called with null intent");
        } else {
            c().B().a("onRebind called. action", intent.getAction());
        }
    }

    public final w3 c() {
        return a5.a(this.f5008a, null, null).c();
    }

    public final int a(final Intent intent, int i2, final int i3) {
        a5 a2 = a5.a(this.f5008a, null, null);
        final w3 c2 = a2.c();
        if (intent == null) {
            c2.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a2.F();
        c2.B().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a(new Runnable(this, i3, c2, intent) { // from class: c.c.a.b.g.b.s8

                /* renamed from: a, reason: collision with root package name */
                public final p8 f5070a;

                /* renamed from: b, reason: collision with root package name */
                public final int f5071b;

                /* renamed from: c, reason: collision with root package name */
                public final w3 f5072c;

                /* renamed from: d, reason: collision with root package name */
                public final Intent f5073d;

                {
                    this.f5070a = this;
                    this.f5071b = i3;
                    this.f5072c = c2;
                    this.f5073d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f5070a.a(this.f5071b, this.f5072c, this.f5073d);
                }
            });
        }
        return 2;
    }

    public final boolean b(Intent intent) {
        if (intent == null) {
            c().t().a("onUnbind called with null intent");
            return true;
        }
        c().B().a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void a(Runnable runnable) {
        l9 a2 = l9.a(this.f5008a);
        a2.a().a(new u8(this, a2, runnable));
    }

    public final IBinder a(Intent intent) {
        if (intent == null) {
            c().t().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new g5(l9.a(this.f5008a));
        }
        c().w().a("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    public final boolean a(final JobParameters jobParameters) {
        a5 a2 = a5.a(this.f5008a, null, null);
        final w3 c2 = a2.c();
        String string = jobParameters.getExtras().getString("action");
        a2.F();
        c2.B().a("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        a(new Runnable(this, c2, jobParameters) { // from class: c.c.a.b.g.b.r8

            /* renamed from: a, reason: collision with root package name */
            public final p8 f5051a;

            /* renamed from: b, reason: collision with root package name */
            public final w3 f5052b;

            /* renamed from: c, reason: collision with root package name */
            public final JobParameters f5053c;

            {
                this.f5051a = this;
                this.f5052b = c2;
                this.f5053c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5051a.a(this.f5052b, this.f5053c);
            }
        });
        return true;
    }

    public final /* synthetic */ void a(w3 w3Var, JobParameters jobParameters) {
        w3Var.B().a("AppMeasurementJobService processed last upload request.");
        this.f5008a.a(jobParameters, false);
    }

    public final /* synthetic */ void a(int i2, w3 w3Var, Intent intent) {
        if (this.f5008a.zza(i2)) {
            w3Var.B().a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            c().B().a("Completed wakeful intent.");
            this.f5008a.a(intent);
        }
    }
}
