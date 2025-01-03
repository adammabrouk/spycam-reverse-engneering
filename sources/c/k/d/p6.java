package c.k.d;

import c.k.d.l6;
import c.k.d.p9.r;
import com.xiaomi.push.service.XMPushService;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class p6 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f7505a = o4.PING_RTT.a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Hashtable<Integer, Long> f7506a = new Hashtable<>();
    }

    public static void a() {
        a(0, f7505a);
    }

    public static void a(int i2) {
        p4 m308a = n6.m307a().m308a();
        m308a.a(o4.CHANNEL_STATS_COUNTER.a());
        m308a.c(i2);
        n6.m307a().a(m308a);
    }

    public static synchronized void a(int i2, int i3) {
        synchronized (p6.class) {
            if (i3 < 16777215) {
                a.f7506a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                c.k.a.a.a.c.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        p4 m308a = n6.m307a().m308a();
        m308a.a((byte) i2);
        m308a.a(i3);
        m308a.b(i4);
        m308a.b(str);
        m308a.c(i5);
        n6.m307a().a(m308a);
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        synchronized (p6.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.f7506a.containsKey(Integer.valueOf(i5))) {
                p4 m308a = n6.m307a().m308a();
                m308a.a(i3);
                m308a.b((int) (currentTimeMillis - a.f7506a.get(Integer.valueOf(i5)).longValue()));
                m308a.b(str);
                if (i4 > -1) {
                    m308a.c(i4);
                }
                n6.m307a().a(m308a);
                a.f7506a.remove(Integer.valueOf(i3));
            } else {
                c.k.a.a.a.c.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, r.b bVar) {
        new i6(xMPushService, bVar).a();
    }

    public static void a(String str, int i2, Exception exc) {
        p4 m308a = n6.m307a().m308a();
        if (i2 > 0) {
            m308a.a(o4.GSLB_REQUEST_SUCCESS.a());
            m308a.b(str);
            m308a.b(i2);
            n6.m307a().a(m308a);
            return;
        }
        try {
            l6.a a2 = l6.a(exc);
            m308a.a(a2.f7350a.a());
            m308a.c(a2.f7351b);
            m308a.b(str);
            n6.m307a().a(m308a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            l6.a b2 = l6.b(exc);
            p4 m308a = n6.m307a().m308a();
            m308a.a(b2.f7350a.a());
            m308a.c(b2.f7351b);
            m308a.b(str);
            n6.m307a().a(m308a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m337a() {
        q4 m309a = n6.m307a().m309a();
        if (m309a != null) {
            return h8.a(m309a);
        }
        return null;
    }

    public static void b() {
        a(0, f7505a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            l6.a d2 = l6.d(exc);
            p4 m308a = n6.m307a().m308a();
            m308a.a(d2.f7350a.a());
            m308a.c(d2.f7351b);
            m308a.b(str);
            n6.m307a().a(m308a);
        } catch (NullPointerException unused) {
        }
    }
}
