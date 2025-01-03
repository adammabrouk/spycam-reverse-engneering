package cn.jiguang.ax;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashSet<g> f8420a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashSet<g> f8421b = new LinkedHashSet<>();

    /* renamed from: c, reason: collision with root package name */
    public List<Boolean> f8422c = new ArrayList();

    private g a(boolean z, boolean z2) {
        LinkedHashSet<g> linkedHashSet = z ? this.f8421b : this.f8420a;
        LinkedHashSet<g> linkedHashSet2 = z2 ? null : z ? this.f8420a : this.f8421b;
        return (g) ((linkedHashSet2 == null || linkedHashSet2.isEmpty() || !(linkedHashSet == null || linkedHashSet.isEmpty() || a(z))) ? a(linkedHashSet) : a(linkedHashSet2));
    }

    public static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        collection.remove(next);
        return next;
    }

    private boolean a(boolean z) {
        if (this.f8422c.size() < 2) {
            return false;
        }
        for (int size = this.f8422c.size() - 1; size >= this.f8422c.size() - 2; size--) {
            if (this.f8422c.get(size).booleanValue() != z) {
                return false;
            }
        }
        return true;
    }

    public g a(int i2) {
        cn.jiguang.as.d.c("IpPool", "current ipv4List=" + this.f8420a + " ipv6List=" + this.f8421b);
        g a2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : a(true, false) : a(true, true) : a(false, true) : a(false, false);
        cn.jiguang.as.d.c("IpPool", "get ipPort=" + a2);
        if (a2 != null) {
            InetAddress inetAddress = a2.f8425c;
            if (inetAddress instanceof Inet4Address) {
                this.f8422c.add(false);
            } else if (inetAddress instanceof Inet6Address) {
                this.f8422c.add(true);
            }
        }
        return a2;
    }

    public void a() {
        try {
            this.f8420a.clear();
            this.f8421b.clear();
        } catch (Throwable unused) {
        }
    }

    public boolean a(g gVar) {
        LinkedHashSet<g> linkedHashSet;
        if (gVar == null || !gVar.a()) {
            return false;
        }
        InetAddress inetAddress = gVar.f8425c;
        if (inetAddress instanceof Inet4Address) {
            linkedHashSet = this.f8420a;
        } else {
            if (!(inetAddress instanceof Inet6Address)) {
                return false;
            }
            linkedHashSet = this.f8421b;
        }
        return linkedHashSet.add(gVar);
    }
}
