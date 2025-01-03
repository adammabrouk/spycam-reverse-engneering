package c.c.b.p;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import c.c.b.l.e1;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    public static final long f6129i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a, reason: collision with root package name */
    public final FirebaseInstanceId f6130a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6131b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.b.l.r f6132c;

    /* renamed from: d, reason: collision with root package name */
    public final e1 f6133d;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f6135f;

    /* renamed from: h, reason: collision with root package name */
    public final b0 f6137h;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, ArrayDeque<c.c.a.b.j.i<Void>>> f6134e = new a.e.a();

    /* renamed from: g, reason: collision with root package name */
    public boolean f6136g = false;

    public e(FirebaseInstanceId firebaseInstanceId, c.c.b.l.r rVar, b0 b0Var, e1 e1Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f6130a = firebaseInstanceId;
        this.f6132c = rVar;
        this.f6137h = b0Var;
        this.f6133d = e1Var;
        this.f6131b = context;
        this.f6135f = scheduledExecutorService;
    }

    public static c.c.a.b.j.h<e> a(c.c.b.c cVar, final FirebaseInstanceId firebaseInstanceId, final c.c.b.l.r rVar, c.c.b.q.h hVar, c.c.b.k.c cVar2, c.c.b.n.h hVar2, final Context context, Executor executor, final ScheduledExecutorService scheduledExecutorService) {
        final e1 e1Var = new e1(cVar, rVar, executor, hVar, cVar2, hVar2);
        return c.c.a.b.j.k.a(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseInstanceId, rVar, e1Var) { // from class: c.c.b.p.d

            /* renamed from: a, reason: collision with root package name */
            public final Context f6124a;

            /* renamed from: b, reason: collision with root package name */
            public final ScheduledExecutorService f6125b;

            /* renamed from: c, reason: collision with root package name */
            public final FirebaseInstanceId f6126c;

            /* renamed from: d, reason: collision with root package name */
            public final c.c.b.l.r f6127d;

            /* renamed from: e, reason: collision with root package name */
            public final e1 f6128e;

            {
                this.f6124a = context;
                this.f6125b = scheduledExecutorService;
                this.f6126c = firebaseInstanceId;
                this.f6127d = rVar;
                this.f6128e = e1Var;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e.a(this.f6124a, this.f6125b, this.f6126c, this.f6127d, this.f6128e);
            }
        });
    }

    public static boolean d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x000d, code lost:
    
        if (d() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0018, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b() throws java.io.IOException {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            c.c.b.p.b0 r0 = r5.f6137h     // Catch: java.lang.Throwable -> L5c
            c.c.b.p.c0 r0 = r0.a()     // Catch: java.lang.Throwable -> L5c
            if (r0 != 0) goto L19
            boolean r0 = d()     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L16
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L5c
        L16:
            r0 = 1
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            return r0
        L19:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            boolean r1 = r5.a(r0)
            if (r1 != 0) goto L22
            r0 = 0
            return r0
        L22:
            c.c.b.p.b0 r1 = r5.f6137h
            r1.a(r0)
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.c.a.b.j.i<java.lang.Void>>> r1 = r5.f6134e
            monitor-enter(r1)
            java.lang.String r0 = r0.c()     // Catch: java.lang.Throwable -> L59
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.c.a.b.j.i<java.lang.Void>>> r2 = r5.f6134e     // Catch: java.lang.Throwable -> L59
            boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Throwable -> L59
            if (r2 != 0) goto L38
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            goto L0
        L38:
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.c.a.b.j.i<java.lang.Void>>> r2 = r5.f6134e     // Catch: java.lang.Throwable -> L59
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L59
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2     // Catch: java.lang.Throwable -> L59
            java.lang.Object r3 = r2.poll()     // Catch: java.lang.Throwable -> L59
            c.c.a.b.j.i r3 = (c.c.a.b.j.i) r3     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L4c
            r4 = 0
            r3.a(r4)     // Catch: java.lang.Throwable -> L59
        L4c:
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L57
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.c.a.b.j.i<java.lang.Void>>> r2 = r5.f6134e     // Catch: java.lang.Throwable -> L59
            r2.remove(r0)     // Catch: java.lang.Throwable -> L59
        L57:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            goto L0
        L59:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            throw r0
        L5c:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5f:
            throw r0
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.b.p.e.b():boolean");
    }

    public final synchronized boolean c() {
        return this.f6136g;
    }

    public final void a() {
        if (!(this.f6137h.a() != null) || c()) {
            return;
        }
        a(0L);
    }

    public final void a(long j) {
        a(new g(this, this.f6131b, this.f6132c, Math.min(Math.max(30L, j << 1), f6129i)), j);
        a(true);
    }

    public final void a(Runnable runnable, long j) {
        this.f6135f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    public final boolean a(c0 c0Var) throws IOException {
        try {
            String b2 = c0Var.b();
            char c2 = 65535;
            int hashCode = b2.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85 && b2.equals("U")) {
                    c2 = 1;
                }
            } else if (b2.equals("S")) {
                c2 = 0;
            }
            if (c2 == 0) {
                String a2 = c0Var.a();
                c.c.b.l.a aVar = (c.c.b.l.a) a(this.f6130a.b());
                a(this.f6133d.b(aVar.c(), aVar.a(), a2));
                if (d()) {
                    String a3 = c0Var.a();
                    StringBuilder sb = new StringBuilder(String.valueOf(a3).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(a3);
                    sb.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb.toString());
                }
            } else if (c2 != 1) {
                if (d()) {
                    String valueOf = String.valueOf(c0Var);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 24);
                    sb2.append("Unknown topic operation");
                    sb2.append(valueOf);
                    sb2.append(".");
                    Log.d("FirebaseMessaging", sb2.toString());
                }
            } else {
                String a4 = c0Var.a();
                c.c.b.l.a aVar2 = (c.c.b.l.a) a(this.f6130a.b());
                a(this.f6133d.c(aVar2.c(), aVar2.a(), a4));
                if (d()) {
                    String a5 = c0Var.a();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(a5).length() + 35);
                    sb3.append("Unsubscribe from topic: ");
                    sb3.append(a5);
                    sb3.append(" succeeded.");
                    Log.d("FirebaseMessaging", sb3.toString());
                }
            }
            return true;
        } catch (IOException e2) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                if (e2.getMessage() == null) {
                    Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                }
                throw e2;
            }
            String message = e2.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
            sb4.append("Topic operation failed: ");
            sb4.append(message);
            sb4.append(". Will retry Topic operation.");
            Log.e("FirebaseMessaging", sb4.toString());
            return false;
        }
    }

    public static <T> T a(c.c.a.b.j.h<T> hVar) throws IOException {
        try {
            return (T) c.c.a.b.j.k.a(hVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e3);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e4) {
            e = e4;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public final synchronized void a(boolean z) {
        this.f6136g = z;
    }

    public static final /* synthetic */ e a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, c.c.b.l.r rVar, e1 e1Var) throws Exception {
        return new e(firebaseInstanceId, rVar, b0.a(context, scheduledExecutorService), e1Var, context, scheduledExecutorService);
    }
}
