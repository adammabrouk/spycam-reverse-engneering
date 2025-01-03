package c.k.d;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes.dex */
public abstract class h5 extends z4 {
    public Exception r;
    public Socket s;
    public String t;
    public XMPushService u;
    public volatile long v;
    public int w;

    public h5(XMPushService xMPushService, a5 a5Var) {
        super(xMPushService, a5Var);
        this.r = null;
        this.v = 0L;
        this.u = xMPushService;
    }

    public p1 a(String str) {
        p1 a2 = u1.a().a(str, false);
        if (!a2.b()) {
            d6.a(new k5(this, str));
        }
        return a2;
    }

    @Override // c.k.d.z4
    /* renamed from: a */
    public String mo543a() {
        return this.t;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Socket m206a() {
        return new Socket();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void mo207a() {
        throw null;
    }

    @Override // c.k.d.z4
    public void a(int i2, Exception exc) {
        b(i2, exc);
        if ((exc != null || i2 == 18) && this.v != 0) {
            a(exc);
        }
    }

    public final void a(a5 a5Var) {
        a(a5Var.c(), a5Var.m71a());
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.v < 300000) {
            if (!e0.b(this.u)) {
                return;
            }
            int i2 = this.w + 1;
            this.w = i2;
            if (i2 < 2) {
                return;
            }
            String mo543a = mo543a();
            c.k.a.a.a.c.m6a("max short conn time reached, sink down current host:" + mo543a);
            a(mo543a, 0L, exc);
        }
        this.w = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0273, code lost:
    
        if (android.text.TextUtils.equals(r5, c.k.d.e0.m138a((android.content.Context) r24.u)) == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0283 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r25, int r26) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.h5.a(java.lang.String, int):void");
    }

    public void a(String str, long j, Exception exc) {
        p1 a2 = u1.a().a(a5.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0L, exc);
            u1.a().m497c();
        }
    }

    @Override // c.k.d.z4
    public void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        mo527b(z);
        if (z) {
            return;
        }
        this.u.a(new i5(this, 13, currentTimeMillis), 10000L);
    }

    public synchronized void b(int i2, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i2, exc);
        this.f8073i = "";
        try {
            this.s.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public abstract void mo527b(boolean z);

    public String c() {
        return this.f8073i;
    }

    public void c(int i2, Exception exc) {
        this.u.a(new j5(this, 2, i2, exc));
    }

    public synchronized void e() {
        try {
            if (!m549c() && !m548b()) {
                a(0, 0, (Exception) null);
                a(this.l);
                return;
            }
            c.k.a.a.a.c.m6a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new l5(e2);
        }
    }

    public void f() {
        SystemClock.elapsedRealtime();
    }

    public void g() {
        SystemClock.elapsedRealtime();
    }
}
