package c.c.a.a.j.w.j;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class e implements s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3669a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.w.k.c f3670b;

    /* renamed from: c, reason: collision with root package name */
    public final g f3671c;

    public e(Context context, c.c.a.a.j.w.k.c cVar, g gVar) {
        this.f3669a = context;
        this.f3670b = cVar;
        this.f3671c = gVar;
    }

    public int a(c.c.a.a.j.l lVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f3669a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(lVar.a().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(c.c.a.a.j.z.a.a(lVar.c())).array());
        if (lVar.b() != null) {
            adler32.update(lVar.b());
        }
        return (int) adler32.getValue();
    }

    public final boolean a(JobScheduler jobScheduler, int i2, int i3) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i4 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i2) {
                return i4 >= i3;
            }
        }
        return false;
    }

    @Override // c.c.a.a.j.w.j.s
    public void a(c.c.a.a.j.l lVar, int i2) {
        ComponentName componentName = new ComponentName(this.f3669a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f3669a.getSystemService("jobscheduler");
        int a2 = a(lVar);
        if (a(jobScheduler, a2, i2)) {
            c.c.a.a.j.u.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", lVar);
            return;
        }
        long b2 = this.f3670b.b(lVar);
        g gVar = this.f3671c;
        JobInfo.Builder builder = new JobInfo.Builder(a2, componentName);
        gVar.a(builder, lVar.c(), b2, i2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", lVar.a());
        persistableBundle.putInt("priority", c.c.a.a.j.z.a.a(lVar.c()));
        if (lVar.b() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(lVar.b(), 0));
        }
        builder.setExtras(persistableBundle);
        c.c.a.a.j.u.a.a("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", lVar, Integer.valueOf(a2), Long.valueOf(this.f3671c.a(lVar.c(), b2, i2)), Long.valueOf(b2), Integer.valueOf(i2));
        jobScheduler.schedule(builder.build());
    }
}
