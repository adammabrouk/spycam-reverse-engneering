package c.c.b.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public int f5943a;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f5944b;

    /* renamed from: c, reason: collision with root package name */
    public o f5945c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    public final Queue<q<?>> f5946d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    public final SparseArray<q<?>> f5947e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f5948f;

    public f(e eVar) {
        this.f5948f = eVar;
        this.f5943a = 0;
        this.f5944b = new Messenger(new c.c.a.b.f.d.e(Looper.getMainLooper(), new Handler.Callback(this) { // from class: c.c.b.l.i

            /* renamed from: a, reason: collision with root package name */
            public final f f5959a;

            {
                this.f5959a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f5959a.a(message);
            }
        }));
        this.f5946d = new ArrayDeque();
        this.f5947e = new SparseArray<>();
    }

    public final synchronized boolean a(q<?> qVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i2 = this.f5943a;
        if (i2 == 0) {
            this.f5946d.add(qVar);
            c.c.a.b.c.o.r.b(this.f5943a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f5943a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            c.c.a.b.c.r.a a2 = c.c.a.b.c.r.a.a();
            context = this.f5948f.f5931a;
            if (a2.a(context, intent, this, 1)) {
                scheduledExecutorService = this.f5948f.f5932b;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: c.c.b.l.h

                    /* renamed from: a, reason: collision with root package name */
                    public final f f5954a;

                    {
                        this.f5954a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5954a.c();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i2 == 1) {
            this.f5946d.add(qVar);
            return true;
        }
        if (i2 == 2) {
            this.f5946d.add(qVar);
            a();
            return true;
        }
        if (i2 != 3 && i2 != 4) {
            int i3 = this.f5943a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i3);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    public final synchronized void b() {
        Context context;
        if (this.f5943a == 2 && this.f5946d.isEmpty() && this.f5947e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f5943a = 3;
            c.c.a.b.c.r.a a2 = c.c.a.b.c.r.a.a();
            context = this.f5948f.f5931a;
            a2.a(context, this);
        }
    }

    public final synchronized void c() {
        if (this.f5943a == 1) {
            a(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.f5948f.f5932b;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: c.c.b.l.k

            /* renamed from: a, reason: collision with root package name */
            public final f f5963a;

            /* renamed from: b, reason: collision with root package name */
            public final IBinder f5964b;

            {
                this.f5963a = this;
                this.f5964b = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f fVar = this.f5963a;
                IBinder iBinder2 = this.f5964b;
                synchronized (fVar) {
                    try {
                        if (iBinder2 == null) {
                            fVar.a(0, "Null service connection");
                            return;
                        }
                        try {
                            fVar.f5945c = new o(iBinder2);
                            fVar.f5943a = 2;
                            fVar.a();
                        } catch (RemoteException e2) {
                            fVar.a(0, e2.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.f5948f.f5932b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: c.c.b.l.m

            /* renamed from: a, reason: collision with root package name */
            public final f f5976a;

            {
                this.f5976a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5976a.a(2, "Service disconnected");
            }
        });
    }

    public final boolean a(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            q<?> qVar = this.f5947e.get(i2);
            if (qVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f5947e.remove(i2);
            b();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                qVar.a(new p(4, "Not supported by GmsCore"));
            } else {
                qVar.a(data);
            }
            return true;
        }
    }

    public final void a() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f5948f.f5932b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: c.c.b.l.j

            /* renamed from: a, reason: collision with root package name */
            public final f f5960a;

            {
                this.f5960a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final q<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final f fVar = this.f5960a;
                while (true) {
                    synchronized (fVar) {
                        if (fVar.f5943a != 2) {
                            return;
                        }
                        if (fVar.f5946d.isEmpty()) {
                            fVar.b();
                            return;
                        }
                        poll = fVar.f5946d.poll();
                        fVar.f5947e.put(poll.f5985a, poll);
                        scheduledExecutorService2 = fVar.f5948f.f5932b;
                        scheduledExecutorService2.schedule(new Runnable(fVar, poll) { // from class: c.c.b.l.l

                            /* renamed from: a, reason: collision with root package name */
                            public final f f5968a;

                            /* renamed from: b, reason: collision with root package name */
                            public final q f5969b;

                            {
                                this.f5968a = fVar;
                                this.f5969b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f5968a.a(this.f5969b.f5985a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = fVar.f5948f.f5931a;
                    Messenger messenger = fVar.f5944b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f5987c;
                    obtain.arg1 = poll.f5985a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle(JThirdPlatFormInterface.KEY_DATA, poll.f5988d);
                    obtain.setData(bundle);
                    try {
                        fVar.f5945c.a(obtain);
                    } catch (RemoteException e2) {
                        fVar.a(2, e2.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void a(int i2, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i3 = this.f5943a;
        if (i3 == 0) {
            throw new IllegalStateException();
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    return;
                }
                int i4 = this.f5943a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
            this.f5943a = 4;
            return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f5943a = 4;
        c.c.a.b.c.r.a a2 = c.c.a.b.c.r.a.a();
        context = this.f5948f.f5931a;
        a2.a(context, this);
        p pVar = new p(i2, str);
        Iterator<q<?>> it = this.f5946d.iterator();
        while (it.hasNext()) {
            it.next().a(pVar);
        }
        this.f5946d.clear();
        for (int i5 = 0; i5 < this.f5947e.size(); i5++) {
            this.f5947e.valueAt(i5).a(pVar);
        }
        this.f5947e.clear();
    }

    public final synchronized void a(int i2) {
        q<?> qVar = this.f5947e.get(i2);
        if (qVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f5947e.remove(i2);
            qVar.a(new p(3, "Timed out waiting for response"));
            b();
        }
    }
}
