package c.c.a.b.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c.c.a.b.c.e;
import c.c.a.b.c.f;
import c.c.a.b.c.h;
import c.c.a.b.c.o.r;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public c.c.a.b.c.a f3780a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public c.c.a.b.f.a.d f3781b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    public boolean f3782c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3783d = new Object();

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("mAutoDisconnectTaskLock")
    public b f3784e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    public final Context f3785f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3786g;

    /* renamed from: h, reason: collision with root package name */
    public final long f3787h;

    /* renamed from: c.c.a.b.a.a.a$a, reason: collision with other inner class name */
    public static final class C0082a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3788a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3789b;

        public C0082a(String str, boolean z) {
            this.f3788a = str;
            this.f3789b = z;
        }

        public final String a() {
            return this.f3788a;
        }

        public final boolean b() {
            return this.f3789b;
        }

        public final String toString() {
            String str = this.f3788a;
            boolean z = this.f3789b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public static class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<a> f3790a;

        /* renamed from: b, reason: collision with root package name */
        public long f3791b;

        /* renamed from: c, reason: collision with root package name */
        public CountDownLatch f3792c = new CountDownLatch(1);

        /* renamed from: d, reason: collision with root package name */
        public boolean f3793d = false;

        public b(a aVar, long j) {
            this.f3790a = new WeakReference<>(aVar);
            this.f3791b = j;
            start();
        }

        public final void a() {
            a aVar = this.f3790a.get();
            if (aVar != null) {
                aVar.a();
                this.f3793d = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f3792c.await(this.f3791b, TimeUnit.MILLISECONDS)) {
                    return;
                }
                a();
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    public a(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        r.a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f3785f = context;
        this.f3782c = false;
        this.f3787h = j;
        this.f3786g = z2;
    }

    public static C0082a a(Context context) throws IOException, IllegalStateException, e, f {
        c cVar = new c(context);
        boolean a2 = cVar.a("gads:ad_id_app_context:enabled", false);
        float a3 = cVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a4 = cVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        a aVar = new a(context, -1L, a2, cVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.a(false);
            C0082a b2 = aVar.b();
            aVar.a(b2, a2, a3, SystemClock.elapsedRealtime() - elapsedRealtime, a4, null);
            return b2;
        } finally {
        }
    }

    public static c.c.a.b.c.a a(Context context, boolean z) throws IOException, e, f {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int a2 = c.c.a.b.c.d.a().a(context, h.f3820a);
            if (a2 != 0 && a2 != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            c.c.a.b.c.a aVar = new c.c.a.b.c.a();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (c.c.a.b.c.r.a.a().a(context, intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new e(9);
        }
    }

    public static c.c.a.b.f.a.d a(Context context, c.c.a.b.c.a aVar) throws IOException {
        try {
            return c.c.a.b.f.a.e.a(aVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static void b(boolean z) {
    }

    public final void a() {
        r.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f3785f == null || this.f3780a == null) {
                return;
            }
            try {
                if (this.f3782c) {
                    c.c.a.b.c.r.a.a().a(this.f3785f, this.f3780a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.f3782c = false;
            this.f3781b = null;
            this.f3780a = null;
        }
    }

    public final void a(boolean z) throws IOException, IllegalStateException, e, f {
        r.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f3782c) {
                a();
            }
            c.c.a.b.c.a a2 = a(this.f3785f, this.f3786g);
            this.f3780a = a2;
            this.f3781b = a(this.f3785f, a2);
            this.f3782c = true;
            if (z) {
                c();
            }
        }
    }

    public final boolean a(C0082a c0082a, boolean z, float f2, long j, String str, Throwable th) {
        if (Math.random() > f2) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (c0082a != null) {
            hashMap.put("limit_ad_tracking", c0082a.b() ? "1" : "0");
        }
        if (c0082a != null && c0082a.a() != null) {
            hashMap.put("ad_id_size", Integer.toString(c0082a.a().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new c.c.a.b.a.a.b(this, hashMap).start();
        return true;
    }

    public C0082a b() throws IOException {
        C0082a c0082a;
        r.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f3782c) {
                synchronized (this.f3783d) {
                    if (this.f3784e == null || !this.f3784e.f3793d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    a(false);
                    if (!this.f3782c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            r.a(this.f3780a);
            r.a(this.f3781b);
            try {
                c0082a = new C0082a(this.f3781b.c(), this.f3781b.a(true));
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        c();
        return c0082a;
    }

    public final void c() {
        synchronized (this.f3783d) {
            if (this.f3784e != null) {
                this.f3784e.f3792c.countDown();
                try {
                    this.f3784e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f3787h > 0) {
                this.f3784e = new b(this, this.f3787h);
            }
        }
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }
}
