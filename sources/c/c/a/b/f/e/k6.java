package c.c.a.b.f.e;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
@TargetApi(24)
/* loaded from: classes.dex */
public final class k6 {

    /* renamed from: b, reason: collision with root package name */
    public static final Method f4255b = a();

    /* renamed from: c, reason: collision with root package name */
    public static final Method f4256c = b();

    /* renamed from: a, reason: collision with root package name */
    public final JobScheduler f4257a;

    public k6(JobScheduler jobScheduler) {
        this.f4257a = jobScheduler;
    }

    public static Method a() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            return null;
        }
    }

    public static Method b() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    public static int c() {
        Method method = f4256c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e2);
                }
            }
        }
        return 0;
    }

    public final int a(JobInfo jobInfo, String str, int i2, String str2) {
        Method method = f4255b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f4257a, jobInfo, str, Integer.valueOf(i2), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e(str2, "error calling scheduleAsPackage", e2);
            }
        }
        return this.f4257a.schedule(jobInfo);
    }

    public static int a(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (f4255b != null && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) {
            return new k6(jobScheduler).a(jobInfo, str, c(), str2);
        }
        return jobScheduler.schedule(jobInfo);
    }
}
