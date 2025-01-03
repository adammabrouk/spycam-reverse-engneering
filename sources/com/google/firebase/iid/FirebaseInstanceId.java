package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.j.g;
import c.c.a.b.j.k;
import c.c.b.c;
import c.c.b.j.b;
import c.c.b.j.d;
import c.c.b.l.b0;
import c.c.b.l.c0;
import c.c.b.l.e1;
import c.c.b.l.f0;
import c.c.b.l.r;
import c.c.b.l.t0;
import c.c.b.l.w;
import c.c.b.l.y;
import c.c.b.l.y0;
import c.c.b.n.h;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public class FirebaseInstanceId {
    public static c0 j;

    @GuardedBy("FirebaseInstanceId.class")
    public static ScheduledExecutorService l;

    /* renamed from: a, reason: collision with root package name */
    public final Executor f10708a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10709b;

    /* renamed from: c, reason: collision with root package name */
    public final r f10710c;

    /* renamed from: d, reason: collision with root package name */
    public final e1 f10711d;

    /* renamed from: e, reason: collision with root package name */
    public final w f10712e;

    /* renamed from: f, reason: collision with root package name */
    public final h f10713f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    public boolean f10714g;

    /* renamed from: h, reason: collision with root package name */
    public final a f10715h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f10707i = TimeUnit.HOURS.toSeconds(8);
    public static final Pattern k = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10716a;

        /* renamed from: b, reason: collision with root package name */
        public final d f10717b;

        /* renamed from: c, reason: collision with root package name */
        @GuardedBy("this")
        public boolean f10718c;

        /* renamed from: d, reason: collision with root package name */
        @GuardedBy("this")
        public b<c.c.b.a> f10719d;

        /* renamed from: e, reason: collision with root package name */
        @GuardedBy("this")
        public Boolean f10720e;

        public a(d dVar) {
            this.f10717b = dVar;
        }

        public final synchronized boolean a() {
            b();
            if (this.f10720e != null) {
                return this.f10720e.booleanValue();
            }
            return this.f10716a && FirebaseInstanceId.this.f10709b.g();
        }

        public final synchronized void b() {
            if (this.f10718c) {
                return;
            }
            this.f10716a = d();
            Boolean c2 = c();
            this.f10720e = c2;
            if (c2 == null && this.f10716a) {
                b<c.c.b.a> bVar = new b(this) { // from class: c.c.b.l.b1

                    /* renamed from: a, reason: collision with root package name */
                    public final FirebaseInstanceId.a f5912a;

                    {
                        this.f5912a = this;
                    }

                    @Override // c.c.b.j.b
                    public final void a(c.c.b.j.a aVar) {
                        FirebaseInstanceId.a aVar2 = this.f5912a;
                        synchronized (aVar2) {
                            if (aVar2.a()) {
                                FirebaseInstanceId.this.k();
                            }
                        }
                    }
                };
                this.f10719d = bVar;
                this.f10717b.a(c.c.b.a.class, bVar);
            }
            this.f10718c = true;
        }

        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Context b2 = FirebaseInstanceId.this.f10709b.b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(b2.getPackageName(), RecyclerView.c0.FLAG_IGNORE)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public final boolean d() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context b2 = FirebaseInstanceId.this.f10709b.b();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(b2.getPackageName());
                ResolveInfo resolveService = b2.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }
    }

    public FirebaseInstanceId(c cVar, d dVar, c.c.b.q.h hVar, c.c.b.k.c cVar2, h hVar2) {
        this(cVar, new r(cVar.b()), t0.b(), t0.b(), dVar, hVar, cVar2, hVar2);
    }

    @Keep
    public static FirebaseInstanceId getInstance(c cVar) {
        a(cVar);
        return (FirebaseInstanceId) cVar.a(FirebaseInstanceId.class);
    }

    public static FirebaseInstanceId o() {
        return getInstance(c.j());
    }

    public static boolean p() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    public final synchronized void a(boolean z) {
        this.f10714g = z;
    }

    public c.c.a.b.j.h<c.c.b.l.a> b() {
        a(this.f10709b);
        return b(r.a(this.f10709b), "*");
    }

    public final c c() {
        return this.f10709b;
    }

    public final b0 d() {
        return c(r.a(this.f10709b), "*");
    }

    public final String e() throws IOException {
        return a(r.a(this.f10709b), "*");
    }

    public final synchronized void f() {
        j.a();
        if (this.f10715h.a()) {
            l();
        }
    }

    public final boolean g() {
        return this.f10710c.a();
    }

    public final void h() {
        j.b(n());
        l();
    }

    public final boolean i() {
        return this.f10715h.a();
    }

    public final /* synthetic */ void j() {
        if (this.f10715h.a()) {
            k();
        }
    }

    public final void k() {
        if (a(d())) {
            l();
        }
    }

    public final synchronized void l() {
        if (!this.f10714g) {
            a(0L);
        }
    }

    public final String m() {
        try {
            j.a(this.f10709b.e());
            c.c.a.b.j.h<String> c2 = this.f10713f.c();
            c.c.a.b.c.o.r.a(c2, "Task must not be null");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            c2.a(y0.f6017a, new c.c.a.b.j.c(countDownLatch) { // from class: c.c.b.l.x0

                /* renamed from: a, reason: collision with root package name */
                public final CountDownLatch f6016a;

                {
                    this.f6016a = countDownLatch;
                }

                @Override // c.c.a.b.j.c
                public final void onComplete(c.c.a.b.j.h hVar) {
                    this.f6016a.countDown();
                }
            });
            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            if (c2.e()) {
                return c2.b();
            }
            if (c2.c()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(c2.a());
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final String n() {
        return "[DEFAULT]".equals(this.f10709b.c()) ? "" : this.f10709b.e();
    }

    public final b0 c(String str, String str2) {
        return j.a(n(), str, str2);
    }

    public final synchronized void a(long j2) {
        a(new f0(this, Math.min(Math.max(30L, j2 << 1), f10707i)), j2);
        this.f10714g = true;
    }

    public final c.c.a.b.j.h<c.c.b.l.a> b(final String str, String str2) {
        final String a2 = a(str2);
        return k.a((Object) null).b(this.f10708a, new c.c.a.b.j.a(this, str, a2) { // from class: c.c.b.l.v0

            /* renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f6002a;

            /* renamed from: b, reason: collision with root package name */
            public final String f6003b;

            /* renamed from: c, reason: collision with root package name */
            public final String f6004c;

            {
                this.f6002a = this;
                this.f6003b = str;
                this.f6004c = a2;
            }

            @Override // c.c.a.b.j.a
            public final Object a(c.c.a.b.j.h hVar) {
                return this.f6002a.a(this.f6003b, this.f6004c, hVar);
            }
        });
    }

    public FirebaseInstanceId(c cVar, r rVar, Executor executor, Executor executor2, d dVar, c.c.b.q.h hVar, c.c.b.k.c cVar2, h hVar2) {
        this.f10714g = false;
        if (r.a(cVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (j == null) {
                    j = new c0(cVar.b());
                }
            }
            this.f10709b = cVar;
            this.f10710c = rVar;
            this.f10711d = new e1(cVar, rVar, executor, hVar, cVar2, hVar2);
            this.f10708a = executor2;
            this.f10715h = new a(dVar);
            this.f10712e = new w(executor);
            this.f10713f = hVar2;
            executor2.execute(new Runnable(this) { // from class: c.c.b.l.w0

                /* renamed from: a, reason: collision with root package name */
                public final FirebaseInstanceId f6007a;

                {
                    this.f6007a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6007a.j();
                }
            });
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static void a(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (l == null) {
                l = new ScheduledThreadPoolExecutor(1, new c.c.a.b.c.s.s.a("FirebaseInstanceId"));
            }
            l.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    public String a() {
        a(this.f10709b);
        k();
        return m();
    }

    public static void a(c cVar) {
        c.c.a.b.c.o.r.a(cVar.d().d(), (Object) "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        c.c.a.b.c.o.r.a(cVar.d().b(), (Object) "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        c.c.a.b.c.o.r.a(cVar.d().a(), (Object) "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        c.c.a.b.c.o.r.a(cVar.d().b().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        c.c.a.b.c.o.r.a(k.matcher(cVar.d().a()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public String a(String str, String str2) throws IOException {
        a(this.f10709b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((c.c.b.l.a) a(b(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final <T> T a(c.c.a.b.j.h<T> hVar) throws IOException {
        try {
            return (T) k.a(hVar, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    f();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        }
    }

    public static String a(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    public final boolean a(b0 b0Var) {
        return b0Var == null || b0Var.a(this.f10710c.c());
    }

    public final /* synthetic */ c.c.a.b.j.h a(final String str, final String str2, c.c.a.b.j.h hVar) throws Exception {
        final String m = m();
        b0 c2 = c(str, str2);
        if (!a(c2)) {
            return k.a(new c.c.b.l.d(m, c2.f5909a));
        }
        return this.f10712e.a(str, str2, new y(this, m, str, str2) { // from class: c.c.b.l.a1

            /* renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f5904a;

            /* renamed from: b, reason: collision with root package name */
            public final String f5905b;

            /* renamed from: c, reason: collision with root package name */
            public final String f5906c;

            /* renamed from: d, reason: collision with root package name */
            public final String f5907d;

            {
                this.f5904a = this;
                this.f5905b = m;
                this.f5906c = str;
                this.f5907d = str2;
            }

            @Override // c.c.b.l.y
            public final c.c.a.b.j.h zza() {
                return this.f5904a.a(this.f5905b, this.f5906c, this.f5907d);
            }
        });
    }

    public final /* synthetic */ c.c.a.b.j.h a(final String str, final String str2, final String str3) {
        return this.f10711d.a(str, str2, str3).a(this.f10708a, new g(this, str2, str3, str) { // from class: c.c.b.l.z0

            /* renamed from: a, reason: collision with root package name */
            public final FirebaseInstanceId f6023a;

            /* renamed from: b, reason: collision with root package name */
            public final String f6024b;

            /* renamed from: c, reason: collision with root package name */
            public final String f6025c;

            /* renamed from: d, reason: collision with root package name */
            public final String f6026d;

            {
                this.f6023a = this;
                this.f6024b = str2;
                this.f6025c = str3;
                this.f6026d = str;
            }

            @Override // c.c.a.b.j.g
            public final c.c.a.b.j.h a(Object obj) {
                return this.f6023a.a(this.f6024b, this.f6025c, this.f6026d, (String) obj);
            }
        });
    }

    public final /* synthetic */ c.c.a.b.j.h a(String str, String str2, String str3, String str4) throws Exception {
        j.a(n(), str, str2, str4, this.f10710c.c());
        return k.a(new c.c.b.l.d(str3, str4));
    }
}
