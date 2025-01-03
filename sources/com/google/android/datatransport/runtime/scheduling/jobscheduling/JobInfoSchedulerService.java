package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import c.c.a.a.j.l;
import c.c.a.a.j.q;
import c.c.a.a.j.w.j.f;
import c.c.a.a.j.z.a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        q.a(getApplicationContext());
        l.a d2 = l.d();
        d2.a(string);
        d2.a(a.a(i2));
        if (string2 != null) {
            d2.a(Base64.decode(string2, 0));
        }
        q.b().a().a(d2.a(), i3, f.a(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
