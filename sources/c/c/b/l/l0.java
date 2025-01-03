package c.c.b.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class l0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5970a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f5971b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f5972c;

    /* renamed from: d, reason: collision with root package name */
    public final Queue<k0> f5973d;

    /* renamed from: e, reason: collision with root package name */
    public g0 f5974e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5975f;

    public l0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new c.c.a.b.c.s.s.a("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    public final synchronized c.c.a.b.j.h<Void> a(Intent intent) {
        final k0 k0Var;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
        }
        k0Var = new k0(intent);
        ScheduledExecutorService scheduledExecutorService = this.f5972c;
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(k0Var) { // from class: c.c.b.l.n0

            /* renamed from: a, reason: collision with root package name */
            public final k0 f5978a;

            {
                this.f5978a = k0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5978a.c();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
        k0Var.a().a(scheduledExecutorService, new c.c.a.b.j.c(schedule) { // from class: c.c.b.l.m0

            /* renamed from: a, reason: collision with root package name */
            public final ScheduledFuture f5977a;

            {
                this.f5977a = schedule;
            }

            @Override // c.c.a.b.j.c
            public final void onComplete(c.c.a.b.j.h hVar) {
                this.f5977a.cancel(false);
            }
        });
        this.f5973d.add(k0Var);
        a();
        return k0Var.a();
    }

    public final void b() {
        while (!this.f5973d.isEmpty()) {
            this.f5973d.poll().b();
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f5975f = false;
        if (iBinder instanceof g0) {
            this.f5974e = (g0) iBinder;
            a();
            return;
        }
        String valueOf2 = String.valueOf(iBinder);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
        sb2.append("Invalid service connection: ");
        sb2.append(valueOf2);
        Log.e("FirebaseInstanceId", sb2.toString());
        b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        a();
    }

    public l0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f5973d = new ArrayDeque();
        this.f5975f = false;
        this.f5970a = context.getApplicationContext();
        this.f5971b = new Intent(str).setPackage(this.f5970a.getPackageName());
        this.f5972c = scheduledExecutorService;
    }

    public final synchronized void a() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.f5973d.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            if (this.f5974e != null && this.f5974e.isBinderAlive()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
                }
                this.f5974e.a(this.f5973d.poll());
            } else {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    boolean z = !this.f5975f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if (!this.f5975f) {
                    this.f5975f = true;
                    try {
                    } catch (SecurityException e2) {
                        Log.e("FirebaseInstanceId", "Exception while binding the service", e2);
                    }
                    if (c.c.a.b.c.r.a.a().a(this.f5970a, this.f5971b, this, 65)) {
                        return;
                    }
                    Log.e("FirebaseInstanceId", "binding to the service failed");
                    this.f5975f = false;
                    b();
                }
                return;
            }
        }
    }
}
