package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    public static volatile j f7266e;

    /* renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f7267a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: b, reason: collision with root package name */
    public SparseArray<ScheduledFuture> f7268b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    public Object f7269c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f7270d;

    public static abstract class a implements Runnable {
        public abstract int a();
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public a f7271a;

        public b(a aVar) {
            this.f7271a = aVar;
        }

        public void a() {
        }

        public void b() {
            throw null;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f7271a.run();
            b();
        }
    }

    public j(Context context) {
        this.f7270d = context.getSharedPreferences("mipush_extra", 0);
    }

    public static j a(Context context) {
        if (f7266e == null) {
            synchronized (j.class) {
                if (f7266e == null) {
                    f7266e = new j(context);
                }
            }
        }
        return f7266e;
    }

    public static String a(int i2) {
        return "last_job_time" + i2;
    }

    public final ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f7269c) {
            scheduledFuture = this.f7268b.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i2) {
        this.f7267a.schedule(runnable, i2, TimeUnit.SECONDS);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m234a(int i2) {
        synchronized (this.f7269c) {
            ScheduledFuture scheduledFuture = this.f7268b.get(i2);
            if (scheduledFuture == null) {
                return false;
            }
            this.f7268b.remove(i2);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m235a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i2) {
        return a(aVar, i2, 0);
    }

    public boolean a(a aVar, int i2, int i3) {
        return a(aVar, i2, i3, false);
    }

    public boolean a(a aVar, int i2, int i3, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.a());
        k kVar = new k(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f7270d.getLong(a2, 0L)) / 1000;
            if (abs < i2 - i3) {
                i3 = (int) (i2 - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f7267a.scheduleAtFixedRate(kVar, i3, i2, TimeUnit.SECONDS);
            synchronized (this.f7269c) {
                this.f7268b.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return true;
        }
    }

    public boolean b(a aVar, int i2) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f7267a.schedule(new l(this, aVar), i2, TimeUnit.SECONDS);
        synchronized (this.f7269c) {
            this.f7268b.put(aVar.a(), schedule);
        }
        return true;
    }
}
