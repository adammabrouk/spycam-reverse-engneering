package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import c.c.a.b.g.b.p8;
import c.c.a.b.g.b.t8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements t8 {

    /* renamed from: a, reason: collision with root package name */
    public p8<AppMeasurementJobService> f10197a;

    public final p8<AppMeasurementJobService> a() {
        if (this.f10197a == null) {
            this.f10197a = new p8<>(this);
        }
        return this.f10197a;
    }

    @Override // c.c.a.b.g.b.t8
    public final void a(Intent intent) {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        a().c(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return a().a(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().b(intent);
    }

    @Override // c.c.a.b.g.b.t8
    public final boolean zza(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // c.c.a.b.g.b.t8
    @TargetApi(24)
    public final void a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
