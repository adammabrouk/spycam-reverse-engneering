package c.k.d;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes.dex */
public class m6 implements c5 {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f7382a;

    /* renamed from: b, reason: collision with root package name */
    public int f7383b;

    /* renamed from: c, reason: collision with root package name */
    public Exception f7384c;

    /* renamed from: i, reason: collision with root package name */
    public long f7390i;
    public long j;

    /* renamed from: e, reason: collision with root package name */
    public long f7386e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f7387f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f7388g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f7389h = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f7385d = "";

    public m6(XMPushService xMPushService) {
        this.f7390i = 0L;
        this.j = 0L;
        this.f7382a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.j = TrafficStats.getUidRxBytes(myUid);
            this.f7390i = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("Failed to obtain traffic data during initialization: " + e2);
            this.j = -1L;
            this.f7390i = -1L;
        }
    }

    public Exception a() {
        return this.f7384c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m299a() {
        if (this.f7382a == null) {
            return;
        }
        String m138a = e0.m138a((Context) this.f7382a);
        boolean b2 = e0.b(this.f7382a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7386e > 0) {
            this.f7387f += elapsedRealtime - this.f7386e;
            this.f7386e = 0L;
        }
        if (this.f7388g != 0) {
            this.f7389h += elapsedRealtime - this.f7388g;
            this.f7388g = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f7385d, m138a) && this.f7387f > 30000) || this.f7387f > 5400000) {
                c();
            }
            this.f7385d = m138a;
            if (this.f7386e == 0) {
                this.f7386e = elapsedRealtime;
            }
            if (this.f7382a.m595c()) {
                this.f7388g = elapsedRealtime;
            }
        }
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var) {
        this.f7383b = 0;
        this.f7384c = null;
        this.f7385d = e0.m138a((Context) this.f7382a);
        p6.a(0, o4.CONN_SUCCESS.a());
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, int i2, Exception exc) {
        long j;
        if (this.f7383b == 0 && this.f7384c == null) {
            this.f7383b = i2;
            this.f7384c = exc;
            p6.b(z4Var.mo543a(), exc);
        }
        if (i2 == 22 && this.f7388g != 0) {
            long m541a = z4Var.m541a() - this.f7388g;
            if (m541a < 0) {
                m541a = 0;
            }
            this.f7389h += m541a + (g5.b() / 2);
            this.f7388g = 0L;
        }
        m299a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("Failed to obtain traffic data: " + e2);
            j = -1L;
        }
        c.k.a.a.a.c.c("Stats rx=" + (j2 - this.j) + ", tx=" + (j - this.f7390i));
        this.j = j2;
        this.f7390i = j;
    }

    @Override // c.k.d.c5
    public void a(z4 z4Var, Exception exc) {
        p6.a(0, o4.CHANNEL_CON_FAIL.a(), 1, z4Var.mo543a(), e0.b(this.f7382a) ? 1 : 0);
        m299a();
    }

    public final void b() {
        this.f7387f = 0L;
        this.f7389h = 0L;
        this.f7386e = 0L;
        this.f7388g = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (e0.b(this.f7382a)) {
            this.f7386e = elapsedRealtime;
        }
        if (this.f7382a.m595c()) {
            this.f7388g = elapsedRealtime;
        }
    }

    @Override // c.k.d.c5
    public void b(z4 z4Var) {
        m299a();
        this.f7388g = SystemClock.elapsedRealtime();
        p6.a(0, o4.CONN_SUCCESS.a(), z4Var.mo543a(), z4Var.a());
    }

    public final synchronized void c() {
        c.k.a.a.a.c.c("stat connpt = " + this.f7385d + " netDuration = " + this.f7387f + " ChannelDuration = " + this.f7389h + " channelConnectedTime = " + this.f7388g);
        p4 p4Var = new p4();
        p4Var.f7494a = (byte) 0;
        p4Var.a(o4.CHANNEL_ONLINE_RATE.a());
        p4Var.a(this.f7385d);
        p4Var.d((int) (System.currentTimeMillis() / 1000));
        p4Var.b((int) (this.f7387f / 1000));
        p4Var.c((int) (this.f7389h / 1000));
        n6.m307a().a(p4Var);
        b();
    }
}
