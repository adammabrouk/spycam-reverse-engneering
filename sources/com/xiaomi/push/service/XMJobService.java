package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import c.k.a.a.a.c;
import c.k.d.f0;
import c.k.d.k4;

/* loaded from: classes.dex */
public class XMJobService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f11263a = null;

    @TargetApi(21)
    public static class a extends JobService {

        /* renamed from: a, reason: collision with root package name */
        public Binder f11264a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f11265b;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        public static class HandlerC0166a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public JobService f11266a;

            public HandlerC0166a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f11266a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                c.m6a("Job finished " + jobParameters.getJobId());
                this.f11266a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    k4.a(false);
                }
            }
        }

        public a(Service service) {
            this.f11264a = null;
            this.f11264a = (Binder) f0.a(this, "onBind", new Intent());
            f0.a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            c.m6a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f11265b == null) {
                this.f11265b = new HandlerC0166a(this);
            }
            Handler handler = this.f11265b;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            c.m6a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f11263a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f11263a = new a(this).f11264a;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
