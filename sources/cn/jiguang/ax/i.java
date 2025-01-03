package cn.jiguang.ax;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.JConstants;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class i implements Callable<l> {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashSet<g> f8429a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public k f8430b;

    public i(k kVar) {
        this.f8430b = kVar;
    }

    private LinkedHashSet<g> a(Context context) {
        LinkedHashSet<g> b2 = g.b((String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.Q()));
        return (b2 == null || b2.isEmpty()) ? g.a(cn.jiguang.aw.a.b()) : b2;
    }

    private void a(p pVar, f fVar) {
        LinkedHashSet<g> a2 = g.a(cn.jiguang.aw.a.a());
        a2.removeAll(this.f8429a);
        LinkedList a3 = cn.jiguang.e.h.a(a2);
        cn.jiguang.as.d.c("Sis", "main sis: sis host=" + a3);
        Iterator it = a3.iterator();
        while (it.hasNext()) {
            if (a((g) it.next(), pVar, fVar)) {
                return;
            }
        }
        g a4 = g.a((String) cn.jiguang.f.b.a(this.f8430b.f8438a, cn.jiguang.f.a.b(true)));
        cn.jiguang.as.d.c("Sis", "main sis: last good sis v4 address=" + a4);
        if (a(a4, pVar, fVar)) {
            return;
        }
        g a5 = g.a((String) cn.jiguang.f.b.a(this.f8430b.f8438a, cn.jiguang.f.a.b(false)));
        cn.jiguang.as.d.c("Sis", "main sis: last good sis v6 address=" + a5);
        a(a5, pVar, fVar);
    }

    private boolean a(g gVar, p pVar, f fVar) {
        if (pVar.a()) {
            return true;
        }
        if (gVar != null && gVar.a() && !this.f8429a.contains(gVar)) {
            cn.jiguang.ba.b a2 = cn.jiguang.ba.b.a();
            k kVar = this.f8430b;
            InetAddress[] b2 = a2.b(kVar.f8438a, gVar.f8423a, NetworkUtils.SCAN_PERIOD_MILLIS, kVar.a());
            if (b2 != null && b2.length != 0) {
                Iterator it = cn.jiguang.e.h.a(Arrays.asList(b2)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it.next();
                    if (!pVar.a()) {
                        g gVar2 = new g(inetAddress, gVar.f8424b);
                        if (!this.f8429a.contains(gVar2) && fVar.a(gVar2)) {
                            this.f8429a.add(gVar2);
                            pVar.a((Callable<?>) new o(this.f8430b, pVar, fVar));
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                this.f8429a.add(gVar);
            }
        }
        return false;
    }

    private void b(p pVar, f fVar) {
        LinkedHashSet<g> a2 = a(this.f8430b.f8438a);
        a2.removeAll(this.f8429a);
        LinkedList a3 = cn.jiguang.e.h.a(a2);
        cn.jiguang.as.d.c("Sis", "main sis: default sis" + a3);
        Iterator it = a3.iterator();
        while (it.hasNext()) {
            if (a((g) it.next(), pVar, fVar)) {
                return;
            }
        }
        LinkedHashSet<g> a4 = cn.jiguang.ay.l.a().a(cn.jiguang.aw.a.c(), 10000L);
        a3.clear();
        if (a4 != null) {
            a4.removeAll(this.f8429a);
            a3 = cn.jiguang.e.h.a(a4);
        }
        cn.jiguang.as.d.c("Sis", "main sis: sis srv" + a3);
        Iterator it2 = a3.iterator();
        while (it2.hasNext() && !a((g) it2.next(), pVar, fVar)) {
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() {
        f fVar = new f();
        p pVar = new p(5, RecyclerView.MAX_SCROLL_DURATION, null, "ss");
        a(pVar, fVar);
        cn.jiguang.as.d.c("Sis", "main sis: after host and last good, wait Result");
        Object a2 = pVar.a(JConstants.MIN);
        if (a2 instanceof l) {
            return (l) a2;
        }
        b(pVar, fVar);
        cn.jiguang.as.d.c("Sis", "main sis: after default and srv, wait Result");
        Object a3 = pVar.a(JConstants.MIN);
        pVar.a(false);
        if (a3 instanceof l) {
            return (l) a3;
        }
        return null;
    }
}
