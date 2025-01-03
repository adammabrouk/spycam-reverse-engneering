package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import c.c.a.b.g.b.p8;
import c.c.a.b.g.b.t8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements t8 {

    /* renamed from: a, reason: collision with root package name */
    public p8<AppMeasurementService> f10199a;

    public final p8<AppMeasurementService> a() {
        if (this.f10199a == null) {
            this.f10199a = new p8<>(this);
        }
        return this.f10199a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return a().a(intent);
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        return a().a(intent, i2, i3);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().b(intent);
    }

    @Override // c.c.a.b.g.b.t8
    public final boolean zza(int i2) {
        return stopSelfResult(i2);
    }

    @Override // c.c.a.b.g.b.t8
    public final void a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // c.c.a.b.g.b.t8
    public final void a(Intent intent) {
        WakefulBroadcastReceiver.a(intent);
    }
}
