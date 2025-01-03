package cn.jpush.android.v;

import android.content.Context;

/* loaded from: classes.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static volatile b f9900f;

    /* renamed from: a, reason: collision with root package name */
    public int f9901a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f9902b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9903c = true;

    /* renamed from: d, reason: collision with root package name */
    public long f9904d = 120000;

    /* renamed from: e, reason: collision with root package name */
    public long f9905e = 120000;

    /* renamed from: g, reason: collision with root package name */
    public long f9906g;

    public static b a() {
        if (f9900f == null) {
            synchronized (b.class) {
                f9900f = new b();
            }
        }
        return f9900f;
    }

    private long b() {
        long j;
        boolean z = true;
        if ((this.f9901a & 1) == 1) {
            try {
                double d2 = this.f9904d;
                double pow = Math.pow(2.0d, this.f9902b);
                Double.isNaN(d2);
                long j2 = (long) (d2 * pow);
                if (j2 >= this.f9905e) {
                    z = false;
                }
                this.f9903c = z;
                j = Math.min(j2, this.f9905e);
            } catch (Throwable unused) {
                j = this.f9905e;
            }
        } else {
            j = 120000;
        }
        if (j <= 0) {
            return 120000L;
        }
        return j;
    }

    public void a(Context context) {
        if (this.f9903c) {
            this.f9902b++;
        }
        long b2 = b();
        e.a().a(context, b2);
        cn.jpush.android.r.b.b("NotifyTimer", "dispatchMessage start notify ad heartbeat after:" + b2);
    }

    public void a(Context context, long j, long j2) {
        this.f9901a |= 1;
        this.f9902b = 0;
        this.f9903c = true;
        this.f9904d = j;
        this.f9905e = j2;
        e.a().a(context, this.f9904d);
        cn.jpush.android.r.b.b("NotifyTimer", "onCmd77 start notify ad heartbeat after:" + this.f9904d);
    }

    public void b(Context context) {
        this.f9906g = System.currentTimeMillis();
        this.f9902b = 0;
        this.f9903c = true;
        long b2 = b();
        e.a().a(context, b2);
        cn.jpush.android.r.b.b("NotifyTimer", "onTcpConnected start notify ad heartbeat after:" + b2);
    }

    public void c(Context context) {
        this.f9902b = 0;
        this.f9903c = true;
        e.a().a(context);
        cn.jpush.android.r.b.b("NotifyTimer", "onTcpDisconnected stop notify ad heartbeat");
    }

    public void d(Context context) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f9906g;
        if (j == 0 || currentTimeMillis - j < 30000) {
            str = "onForeground start notify ad heartbeat failed, because not time";
        } else {
            this.f9901a &= 1;
            this.f9902b = 0;
            this.f9903c = true;
            long b2 = b();
            e.a().a(context, b2);
            str = "onForeground start notify ad heartbeat after:" + b2;
        }
        cn.jpush.android.r.b.b("NotifyTimer", str);
    }
}
