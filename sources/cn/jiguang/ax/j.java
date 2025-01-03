package cn.jiguang.ax;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    public k f8432b;

    /* renamed from: c, reason: collision with root package name */
    public h f8433c;

    /* renamed from: f, reason: collision with root package name */
    public o f8436f;

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashSet<g> f8431a = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public p f8434d = new p(5, RecyclerView.MAX_SCROLL_DURATION, null, "ssn");

    /* renamed from: e, reason: collision with root package name */
    public f f8435e = new f();

    public j(k kVar) {
        this.f8432b = kVar;
    }

    private void a(LinkedHashSet<g> linkedHashSet) {
        linkedHashSet.removeAll(this.f8431a);
        if (linkedHashSet.isEmpty()) {
            return;
        }
        LinkedHashSet<g> a2 = e.a(this.f8432b.f8438a, linkedHashSet, 0L);
        cn.jiguang.as.d.c("SisConn", "connect: last good sis info" + a2);
        Iterator<g> it = a2.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    private void a(LinkedHashSet<g> linkedHashSet, long j) {
        InetAddress[] b2;
        this.f8435e.a();
        this.f8434d.b();
        linkedHashSet.removeAll(this.f8431a);
        LinkedHashSet<g> a2 = e.a(this.f8432b.f8438a, linkedHashSet, System.currentTimeMillis());
        cn.jiguang.as.d.c("SisConn", "connect: new sis info=" + a2);
        if (a2.isEmpty()) {
            return;
        }
        Iterator<g> it = a2.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (SystemClock.uptimeMillis() >= j || a(next)) {
                return;
            }
        }
        cn.jiguang.as.d.c("SisConn", "after connect use new sis, wait connect Result");
        long uptimeMillis = j - SystemClock.uptimeMillis();
        if (uptimeMillis > 0 && this.f8434d.a(uptimeMillis) == null && this.f8436f == null) {
            HashSet hashSet = new HashSet();
            Iterator<g> it2 = a2.iterator();
            while (it2.hasNext()) {
                g next2 = it2.next();
                if (this.f8431a.contains(next2)) {
                    hashSet.add(next2.f8423a);
                }
            }
            int b3 = this.f8432b.b();
            g a3 = g.a((String) cn.jiguang.f.b.a(this.f8432b.f8438a, cn.jiguang.f.a.b(b3 == 1 || b3 == 0)));
            if (a3 == null || (b2 = cn.jiguang.ba.b.a().b(this.f8432b.f8438a, a3.f8423a, NetworkUtils.SCAN_PERIOD_MILLIS, false)) == null || b2.length <= 0) {
                return;
            }
            a3.f8425c = b2[0];
            long uptimeMillis2 = j - SystemClock.uptimeMillis();
            if (uptimeMillis2 < 10) {
                return;
            }
            this.f8436f = new o(this.f8432b, a3, hashSet);
            cn.jiguang.as.d.c("SisConn", "second sis, addr=" + a3 + ", failIps=" + hashSet);
            FutureTask futureTask = new FutureTask(this.f8436f);
            try {
                JCoreManager.onEvent(null, null, 11, "ASYNC", null, futureTask);
                l lVar = (l) futureTask.get(uptimeMillis2, TimeUnit.MILLISECONDS);
                LinkedHashSet<g> linkedHashSet2 = lVar != null ? lVar.f8445a : null;
                if (linkedHashSet2 == null || linkedHashSet2.isEmpty()) {
                    return;
                }
                this.f8432b.a(lVar.f8451g);
                a(linkedHashSet2, j);
            } catch (Throwable th) {
                cn.jiguang.as.d.g("SisConn", "second sis e:" + th);
            }
        }
    }

    private boolean a() {
        return (a(this.f8432b.f8438a, cn.jiguang.e.g.c(this.f8432b.f8438a)) || cn.jiguang.e.h.a(((Long) cn.jiguang.f.b.a(this.f8432b.f8438a, cn.jiguang.f.a.O())).longValue(), 180000L)) ? false : true;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        cn.jiguang.as.d.c("SisConn", "newType=" + str + " last=" + ((String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.H())));
        return !str.equalsIgnoreCase(r3);
    }

    private boolean a(g gVar) {
        cn.jiguang.az.f fVar;
        if (!this.f8433c.f8426a) {
            if (this.f8434d.a()) {
                return true;
            }
            if (gVar != null && gVar.a() && !this.f8431a.contains(gVar)) {
                cn.jiguang.ba.b a2 = cn.jiguang.ba.b.a();
                k kVar = this.f8432b;
                InetAddress[] b2 = a2.b(kVar.f8438a, gVar.f8423a, NetworkUtils.SCAN_PERIOD_MILLIS, kVar.a());
                if (b2 != null && b2.length != 0) {
                    Iterator it = cn.jiguang.e.h.a(Arrays.asList(b2)).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!this.f8433c.f8426a) {
                            if (!this.f8434d.a()) {
                                g gVar2 = new g(inetAddress, gVar.f8424b);
                                if (!this.f8431a.contains(gVar2) && this.f8435e.a(gVar2)) {
                                    this.f8431a.add(gVar2);
                                    p pVar = this.f8434d;
                                    pVar.a((Callable<?>) new b(this.f8432b, pVar, this.f8435e, this.f8433c));
                                    break;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            fVar = new cn.jiguang.az.f(-991, null);
                            break;
                        }
                    }
                    this.f8431a.add(gVar);
                }
            }
            return false;
        }
        fVar = new cn.jiguang.az.f(-991, null);
        this.f8434d.a(fVar);
        return true;
    }

    private void b() {
        g a2 = g.a((String) cn.jiguang.f.b.a(this.f8432b.f8438a, cn.jiguang.f.a.c(true)));
        cn.jiguang.as.d.c("SisConn", "connect: use last good v4 address=" + a2);
        if (a(a2)) {
            return;
        }
        g a3 = g.a((String) cn.jiguang.f.b.a(this.f8432b.f8438a, cn.jiguang.f.a.c(false)));
        cn.jiguang.as.d.c("SisConn", "connect: use last good v6 address=" + a3);
        if (a(a3)) {
            return;
        }
        LinkedHashSet<g> c2 = c();
        if (c2 != null) {
            c2.removeAll(this.f8431a);
        }
        LinkedList a4 = cn.jiguang.e.h.a(c2);
        cn.jiguang.as.d.c("SisConn", "connect: use defaultConn=" + a4);
        Iterator it = a4.iterator();
        while (it.hasNext()) {
            if (a((g) it.next())) {
                return;
            }
        }
        LinkedHashSet<g> a5 = cn.jiguang.ay.l.a().a(cn.jiguang.aw.a.b(this.f8432b.f8438a), 10000L);
        a4.clear();
        if (a5 != null) {
            a5.removeAll(this.f8431a);
            a4 = cn.jiguang.e.h.a(a5);
        }
        cn.jiguang.as.d.c("SisConn", "connect: use srv address" + a4);
        Iterator it2 = a4.iterator();
        while (it2.hasNext() && !a((g) it2.next())) {
        }
    }

    private LinkedHashSet<g> c() {
        InetAddress[] b2;
        LinkedList a2;
        try {
            String a3 = cn.jiguang.aw.a.a(this.f8432b.f8438a);
            cn.jiguang.as.d.c("SisConn", "load Default Conn, from host=" + a3);
            if (!TextUtils.isEmpty(a3) && (b2 = cn.jiguang.ba.b.a().b(this.f8432b.f8438a, a3, NetworkUtils.SCAN_PERIOD_MILLIS, this.f8432b.a())) != null && b2.length != 0 && (a2 = cn.jiguang.e.h.a(Arrays.asList(b2))) != null && !a2.isEmpty()) {
                String hostAddress = ((InetAddress) a2.get(0)).getHostAddress();
                LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
                linkedHashSet.add(new g(hostAddress, 7000));
                linkedHashSet.add(new g(hostAddress, 7002));
                linkedHashSet.add(new g(hostAddress, 7003));
                linkedHashSet.add(new g(hostAddress, 7004));
                linkedHashSet.add(new g(hostAddress, 7005));
                linkedHashSet.add(new g(hostAddress, 7006));
                linkedHashSet.add(new g(hostAddress, 7007));
                linkedHashSet.add(new g(hostAddress, 7008));
                linkedHashSet.add(new g(hostAddress, 7009));
                return linkedHashSet;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public cn.jiguang.bc.a a(h hVar) {
        this.f8433c = hVar;
        cn.jiguang.as.d.c("SisConn", "start sisAndConnect...");
        this.f8435e = new f();
        long uptimeMillis = SystemClock.uptimeMillis() + 12000;
        LinkedHashSet<g> b2 = g.b((String) cn.jiguang.f.b.a(this.f8432b.f8438a, cn.jiguang.f.a.L()));
        boolean z = (b2 == null || b2.isEmpty()) ? false : true;
        boolean a2 = a();
        if (z && a2) {
            a(b2);
        }
        l a3 = this.f8432b.a(12000L);
        LinkedHashSet<g> linkedHashSet = a3 != null ? a3.f8445a : null;
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            this.f8432b.a(a3.f8451g);
            a(linkedHashSet, uptimeMillis);
        } else if (z && !a2) {
            a(b2);
        }
        b();
        cn.jiguang.as.d.c("SisConn", "wait final result...");
        Object a4 = this.f8434d.a(JConstants.MIN);
        this.f8434d.a(false);
        if (a4 instanceof cn.jiguang.bc.a) {
            cn.jiguang.as.d.c("SisConn", "connect succeed");
            return (cn.jiguang.bc.a) a4;
        }
        if (a4 instanceof Exception) {
            cn.jiguang.as.d.c("SisConn", "all sis and connect failed, e:" + a4);
            throw ((Exception) a4);
        }
        cn.jiguang.as.d.g("SisConn", "all sis and connect failed:" + a4);
        throw new cn.jiguang.az.f(1, null);
    }
}
