package c.c.a.b.g.b;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class h9 extends i9 {

    /* renamed from: d, reason: collision with root package name */
    public final AlarmManager f4786d;

    /* renamed from: e, reason: collision with root package name */
    public final j f4787e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f4788f;

    public h9(l9 l9Var) {
        super(l9Var);
        this.f4786d = (AlarmManager) d().getSystemService("alarm");
        this.f4787e = new g9(this, l9Var.u(), l9Var);
    }

    public final void a(long j) {
        q();
        F();
        Context d2 = d();
        if (!t4.a(d2)) {
            c().A().a("Receiver not registered/enabled");
        }
        if (!s9.a(d2, false)) {
            c().A().a("Service not registered/enabled");
        }
        t();
        c().B().a("Scheduling upload, millis", Long.valueOf(j));
        long b2 = b().b() + j;
        if (j < Math.max(0L, r.x.a(null).longValue()) && !this.f4787e.b()) {
            this.f4787e.a(j);
        }
        F();
        if (Build.VERSION.SDK_INT < 24) {
            this.f4786d.setInexactRepeating(2, b2, Math.max(r.s.a(null).longValue(), j), w());
            return;
        }
        Context d3 = d();
        ComponentName componentName = new ComponentName(d3, "com.google.android.gms.measurement.AppMeasurementJobService");
        int v = v();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        c.c.a.b.f.e.k6.a(d3, new JobInfo.Builder(v, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    @Override // c.c.a.b.g.b.i9
    public final boolean s() {
        this.f4786d.cancel(w());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        u();
        return false;
    }

    public final void t() {
        q();
        c().B().a("Unscheduling upload");
        this.f4786d.cancel(w());
        this.f4787e.c();
        if (Build.VERSION.SDK_INT >= 24) {
            u();
        }
    }

    @TargetApi(24)
    public final void u() {
        ((JobScheduler) d().getSystemService("jobscheduler")).cancel(v());
    }

    public final int v() {
        if (this.f4788f == null) {
            String valueOf = String.valueOf(d().getPackageName());
            this.f4788f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f4788f.intValue();
    }

    public final PendingIntent w() {
        Context d2 = d();
        return PendingIntent.getBroadcast(d2, 0, new Intent().setClassName(d2, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }
}
