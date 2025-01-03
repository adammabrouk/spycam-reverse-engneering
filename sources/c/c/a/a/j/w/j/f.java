package c.c.a.a.j.w.j;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final JobInfoSchedulerService f3672a;

    /* renamed from: b, reason: collision with root package name */
    public final JobParameters f3673b;

    public f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f3672a = jobInfoSchedulerService;
        this.f3673b = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new f(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3672a.jobFinished(this.f3673b, false);
    }
}
