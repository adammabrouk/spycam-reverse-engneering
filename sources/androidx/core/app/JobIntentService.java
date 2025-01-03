package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<ComponentName, h> f2453g = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public b f2454a;

    /* renamed from: b, reason: collision with root package name */
    public h f2455b;

    /* renamed from: c, reason: collision with root package name */
    public a f2456c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2457d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2458e = false;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<d> f2459f;

    public interface b {
        e a();

        IBinder b();
    }

    public static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        public final PowerManager.WakeLock f2461d;

        /* renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f2462e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f2463f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2464g;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2461d = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2462e = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void a() {
            synchronized (this) {
                if (this.f2464g) {
                    if (this.f2463f) {
                        this.f2461d.acquire(JConstants.MIN);
                    }
                    this.f2464g = false;
                    this.f2462e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                if (!this.f2464g) {
                    this.f2464g = true;
                    this.f2462e.acquire(600000L);
                    this.f2461d.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                this.f2463f = false;
            }
        }
    }

    public final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f2465a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2466b;

        public d(Intent intent, int i2) {
            this.f2465a = intent;
            this.f2466b = i2;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f2466b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f2465a;
        }
    }

    public interface e {
        void a();

        Intent getIntent();
    }

    public static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        public final JobIntentService f2468a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f2469b;

        /* renamed from: c, reason: collision with root package name */
        public JobParameters f2470c;

        public final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            public final JobWorkItem f2471a;

            public a(JobWorkItem jobWorkItem) {
                this.f2471a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f2469b) {
                    if (f.this.f2470c != null) {
                        f.this.f2470c.completeWork(this.f2471a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f2471a.getIntent();
            }
        }

        public f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2469b = new Object();
            this.f2468a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e a() {
            synchronized (this.f2469b) {
                if (this.f2470c == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.f2470c.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.f2468a.getClassLoader());
                return new a(dequeueWork);
            }
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder b() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f2470c = jobParameters;
            this.f2468a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f2468a.b();
            synchronized (this.f2469b) {
                this.f2470c = null;
            }
            return b2;
        }
    }

    public static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        public final JobInfo f2473d;

        public g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            a(i2);
            this.f2473d = new JobInfo.Builder(i2, this.f2474a).setOverrideDeadline(0L).build();
        }
    }

    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f2474a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2475b;

        /* renamed from: c, reason: collision with root package name */
        public int f2476c;

        public h(ComponentName componentName) {
            this.f2474a = componentName;
        }

        public void a() {
        }

        public void a(int i2) {
            if (!this.f2475b) {
                this.f2475b = true;
                this.f2476c = i2;
            } else {
                if (this.f2476c == i2) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f2476c);
            }
        }

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2459f = null;
        } else {
            this.f2459f = new ArrayList<>();
        }
    }

    public static h a(Context context, ComponentName componentName, boolean z, int i2) {
        h cVar;
        h hVar = f2453g.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i2);
        }
        h hVar2 = cVar;
        f2453g.put(componentName, hVar2);
        return hVar2;
    }

    public abstract void a(Intent intent);

    public boolean b() {
        a aVar = this.f2456c;
        if (aVar != null) {
            aVar.cancel(this.f2457d);
        }
        return c();
    }

    public boolean c() {
        return true;
    }

    public void d() {
        ArrayList<d> arrayList = this.f2459f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2456c = null;
                if (this.f2459f != null && this.f2459f.size() > 0) {
                    a(false);
                } else if (!this.f2458e) {
                    this.f2455b.a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f2454a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2454a = new f(this);
            this.f2455b = null;
        } else {
            this.f2454a = null;
            this.f2455b = a(this, new ComponentName(this, (Class<?>) JobIntentService.class), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f2459f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2458e = true;
                this.f2455b.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.f2459f == null) {
            return 2;
        }
        this.f2455b.c();
        synchronized (this.f2459f) {
            ArrayList<d> arrayList = this.f2459f;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            a(true);
        }
        return 3;
    }

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.a(a2.getIntent());
                a2.a();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.d();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.d();
        }
    }

    public void a(boolean z) {
        if (this.f2456c == null) {
            this.f2456c = new a();
            h hVar = this.f2455b;
            if (hVar != null && z) {
                hVar.b();
            }
            this.f2456c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public e a() {
        b bVar = this.f2454a;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.f2459f) {
            if (this.f2459f.size() <= 0) {
                return null;
            }
            return this.f2459f.remove(0);
        }
    }
}
