package c.k.d;

import android.util.Pair;
import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class z4 {
    public static final AtomicInteger p = new AtomicInteger(0);
    public static boolean q;
    public a5 l;
    public XMPushService m;

    /* renamed from: a, reason: collision with root package name */
    public int f8065a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f8066b = -1;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f8067c = 0;

    /* renamed from: d, reason: collision with root package name */
    public LinkedList<Pair<Integer, Long>> f8068d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    public final Collection<c5> f8069e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final Map<f5, a> f8070f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map<f5, a> f8071g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public m5 f8072h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f8073i = "";
    public int j = 2;
    public final int k = p.getAndIncrement();
    public long n = 0;
    public long o = 0;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public f5 f8074a;

        /* renamed from: b, reason: collision with root package name */
        public n5 f8075b;

        public a(f5 f5Var, n5 n5Var) {
            this.f8074a = f5Var;
            this.f8075b = n5Var;
        }

        public void a(r5 r5Var) {
            n5 n5Var = this.f8075b;
            if (n5Var == null || n5Var.mo456a(r5Var)) {
                this.f8074a.a(r5Var);
            }
        }

        public void a(s4 s4Var) {
            this.f8074a.a(s4Var);
        }
    }

    static {
        q = false;
        try {
            q = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        g5.m173a();
    }

    public z4(XMPushService xMPushService, a5 a5Var) {
        this.l = a5Var;
        this.m = xMPushService;
        m547b();
    }

    public int a() {
        return this.f8065a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m541a() {
        return this.f8067c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a5 m542a() {
        return this.l;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String mo543a() {
        return this.l.c();
    }

    public final String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m544a(int i2) {
        synchronized (this.f8068d) {
            if (i2 == 1) {
                this.f8068d.clear();
            } else {
                this.f8068d.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.f8068d.size() > 6) {
                    this.f8068d.remove(0);
                }
            }
        }
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.j;
        if (i2 != i4) {
            c.k.a.a.a.c.m6a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), c.k.d.p9.v.a(i3)));
        }
        if (e0.b(this.m)) {
            m544a(i2);
        }
        if (i2 == 1) {
            this.m.a(10);
            if (this.j != 0) {
                c.k.a.a.a.c.m6a("try set connected while not connecting.");
            }
            this.j = i2;
            Iterator<c5> it = this.f8069e.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i2 == 0) {
            if (this.j != 2) {
                c.k.a.a.a.c.m6a("try set connecting while not disconnected.");
            }
            this.j = i2;
            Iterator<c5> it2 = this.f8069e.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i2 == 2) {
            this.m.a(10);
            int i5 = this.j;
            if (i5 == 0) {
                Iterator<c5> it3 = this.f8069e.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                Iterator<c5> it4 = this.f8069e.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i3, exc);
                }
            }
            this.j = i2;
        }
    }

    public abstract void a(int i2, Exception exc);

    public void a(c5 c5Var) {
        if (c5Var == null || this.f8069e.contains(c5Var)) {
            return;
        }
        this.f8069e.add(c5Var);
    }

    public void a(f5 f5Var, n5 n5Var) {
        if (f5Var == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f8070f.put(f5Var, new a(f5Var, n5Var));
    }

    public abstract void a(r.b bVar);

    public abstract void a(r5 r5Var);

    public abstract void a(s4 s4Var);

    public synchronized void a(String str) {
        if (this.j == 0) {
            c.k.a.a.a.c.m6a("setChallenge hash = " + j0.a(str).substring(0, 8));
            this.f8073i = str;
            a(1, 0, null);
        } else {
            c.k.a.a.a.c.m6a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(boolean z);

    public abstract void a(s4[] s4VarArr);

    /* renamed from: a, reason: collision with other method in class */
    public boolean mo545a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.n >= j;
    }

    public int b() {
        return this.j;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m546b() {
        return this.l.b();
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m547b() {
        String str;
        if (this.l.m72a() && this.f8072h == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f8072h = new s0(this);
                return;
            }
            try {
                this.f8072h = (m5) cls.getConstructor(z4.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public void b(c5 c5Var) {
        this.f8069e.remove(c5Var);
    }

    public void b(f5 f5Var, n5 n5Var) {
        if (f5Var == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f8071g.put(f5Var, new a(f5Var, n5Var));
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m548b() {
        return this.j == 0;
    }

    public synchronized void c() {
        this.n = System.currentTimeMillis();
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m549c() {
        return this.j == 1;
    }

    public void d() {
        synchronized (this.f8068d) {
            this.f8068d.clear();
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public synchronized boolean m550d() {
        return System.currentTimeMillis() - this.n < ((long) g5.a());
    }

    public synchronized boolean e() {
        return System.currentTimeMillis() - this.o < ((long) (g5.a() << 1));
    }
}
