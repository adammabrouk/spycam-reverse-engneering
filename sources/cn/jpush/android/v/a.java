package cn.jpush.android.v;

import android.content.Context;

/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static volatile a f9893g;

    /* renamed from: a, reason: collision with root package name */
    public int f9894a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f9895b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9896c = true;

    /* renamed from: d, reason: collision with root package name */
    public long f9897d = 120000;

    /* renamed from: e, reason: collision with root package name */
    public long f9898e = 120000;

    /* renamed from: f, reason: collision with root package name */
    public long f9899f = 120000;

    public static a a() {
        if (f9893g == null) {
            synchronized (a.class) {
                f9893g = new a();
            }
        }
        return f9893g;
    }

    private long b() {
        long j;
        int i2 = this.f9894a;
        if ((i2 & 16) == 16) {
            j = this.f9897d;
        } else {
            boolean z = true;
            if ((i2 & 1) == 1) {
                try {
                    double d2 = this.f9898e;
                    double pow = Math.pow(2.0d, this.f9895b);
                    Double.isNaN(d2);
                    long j2 = (long) (d2 * pow);
                    if (j2 >= this.f9899f) {
                        z = false;
                    }
                    this.f9896c = z;
                    j = Math.min(j2, this.f9899f);
                } catch (Throwable unused) {
                    j = this.f9899f;
                }
            } else {
                j = 120000;
            }
        }
        if (j <= 0) {
            return 120000L;
        }
        return j;
    }

    public void a(Context context) {
        if ((this.f9894a & 1) == 1 && this.f9896c) {
            this.f9895b++;
        }
        long b2 = b();
        e.a().b(context, b2);
        cn.jpush.android.r.b.b("NativeTimer", "dispatchMessage start native ad heartbeat after:" + b2);
    }

    public void a(Context context, long j, long j2) {
        this.f9894a |= 1;
        this.f9895b = 0;
        this.f9896c = true;
        this.f9898e = j;
        this.f9899f = j2;
        long b2 = b();
        e.a().b(context, b2);
        cn.jpush.android.r.b.b("NativeTimer", "onCmd77 start native ad heartbeat after:" + b2);
    }

    public void b(Context context) {
        this.f9895b = 0;
        this.f9896c = true;
        long b2 = b();
        e.a().b(context, b2);
        cn.jpush.android.r.b.b("NativeTimer", "onTcpConnected start native ad heartbeat after:" + b2);
    }

    public void b(Context context, long j, long j2) {
        this.f9894a |= 16;
        this.f9897d = j;
        e.a().a(context, this.f9897d, false);
        cn.jpush.android.r.b.b("NativeTimer", "onCmd3 start native ad heartbeat after:" + this.f9897d);
    }

    public void c(Context context) {
        this.f9895b = 0;
        this.f9896c = true;
        e.a().b(context);
        cn.jpush.android.r.b.b("NativeTimer", "onTcpDisconnected stop native ad heartbeat");
    }

    public void d(Context context) {
        this.f9894a &= 1;
        this.f9895b = 0;
        this.f9896c = true;
        this.f9897d = 0L;
        long b2 = b();
        e.a().b(context, b2);
        cn.jpush.android.r.b.b("NativeTimer", "onPage start native ad heartbeat after:" + b2);
    }

    public void e(Context context) {
        this.f9894a &= 1;
        this.f9895b = 0;
        this.f9896c = true;
        this.f9897d = 0L;
        e.a().b(context);
        cn.jpush.android.r.b.b("NativeTimer", "onBackground stop native ad heartbeat");
    }
}
