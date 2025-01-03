package c.k.d;

import android.content.Context;
import c.k.d.g0;
import c.k.d.z8;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class n6 {

    /* renamed from: a, reason: collision with root package name */
    public String f7424a;

    /* renamed from: c, reason: collision with root package name */
    public int f7426c;

    /* renamed from: d, reason: collision with root package name */
    public long f7427d;

    /* renamed from: e, reason: collision with root package name */
    public m6 f7428e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7425b = false;

    /* renamed from: f, reason: collision with root package name */
    public g0 f7429f = g0.a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final n6 f7430a = new n6();
    }

    public static m6 a() {
        m6 m6Var;
        synchronized (a.f7430a) {
            m6Var = a.f7430a.f7428e;
        }
        return m6Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static n6 m307a() {
        return a.f7430a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized p4 m308a() {
        p4 p4Var;
        p4Var = new p4();
        p4Var.a(e0.m138a((Context) this.f7428e.f7382a));
        p4Var.f7494a = (byte) 0;
        p4Var.f7495b = 1;
        p4Var.d((int) (System.currentTimeMillis() / 1000));
        return p4Var;
    }

    public final p4 a(g0.a aVar) {
        if (aVar.f7142a == 0) {
            Object obj = aVar.f7144c;
            if (obj instanceof p4) {
                return (p4) obj;
            }
            return null;
        }
        p4 m308a = m308a();
        m308a.a(o4.CHANNEL_STATS_COUNTER.a());
        m308a.c(aVar.f7142a);
        m308a.c(aVar.f7143b);
        return m308a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized q4 m309a() {
        q4 q4Var;
        q4Var = null;
        if (b()) {
            q4Var = a(e0.d(this.f7428e.f7382a) ? 750 : 375);
        }
        return q4Var;
    }

    public final q4 a(int i2) {
        ArrayList arrayList = new ArrayList();
        q4 q4Var = new q4(this.f7424a, arrayList);
        if (!e0.d(this.f7428e.f7382a)) {
            q4Var.a(f7.m(this.f7428e.f7382a));
        }
        b9 b9Var = new b9(i2);
        t8 a2 = new z8.a().a(b9Var);
        try {
            q4Var.b(a2);
        } catch (n8 unused) {
        }
        LinkedList<g0.a> m165a = this.f7429f.m165a();
        while (m165a.size() > 0) {
            try {
                p4 a3 = a(m165a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (b9Var.c() > i2) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m165a.removeLast();
            } catch (n8 | NoSuchElementException unused2) {
            }
        }
        return q4Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m310a() {
        if (!this.f7425b || System.currentTimeMillis() - this.f7427d <= this.f7426c) {
            return;
        }
        this.f7425b = false;
        this.f7427d = 0L;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m311a(int i2) {
        if (i2 > 0) {
            int i3 = i2 * 1000;
            if (i3 > 604800000) {
                i3 = 604800000;
            }
            if (this.f7426c == i3 && this.f7425b) {
                return;
            }
            this.f7425b = true;
            this.f7427d = System.currentTimeMillis();
            this.f7426c = i3;
            c.k.a.a.a.c.c("enable dot duration = " + i3 + " start = " + this.f7427d);
        }
    }

    public synchronized void a(p4 p4Var) {
        this.f7429f.a(p4Var);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f7428e = new m6(xMPushService);
        this.f7424a = "";
        c.k.d.p9.h0.a().a(new o6(this));
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m312a() {
        return this.f7425b;
    }

    public boolean b() {
        m310a();
        return this.f7425b && this.f7429f.m164a() > 0;
    }
}
