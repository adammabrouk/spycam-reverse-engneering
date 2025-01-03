package c.a.a.l.i.m;

import c.a.a.l.i.m.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
public class e<K extends h, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f3128a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<K, a<K, V>> f3129b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f3130a;

        /* renamed from: b, reason: collision with root package name */
        public List<V> f3131b;

        /* renamed from: c, reason: collision with root package name */
        public a<K, V> f3132c;

        /* renamed from: d, reason: collision with root package name */
        public a<K, V> f3133d;

        public a() {
            this(null);
        }

        public int b() {
            List<V> list = this.f3131b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k) {
            this.f3133d = this;
            this.f3132c = this;
            this.f3130a = k;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f3131b.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f3131b == null) {
                this.f3131b = new ArrayList();
            }
            this.f3131b.add(v);
        }
    }

    public static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f3133d;
        aVar2.f3132c = aVar.f3132c;
        aVar.f3132c.f3133d = aVar2;
    }

    public static <K, V> void d(a<K, V> aVar) {
        aVar.f3132c.f3133d = aVar;
        aVar.f3133d.f3132c = aVar;
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f3129b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f3129b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a((a<K, V>) v);
    }

    public final void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f3128a;
        aVar.f3133d = aVar2.f3133d;
        aVar.f3132c = aVar2;
        d(aVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f3128a.f3132c; !aVar.equals(this.f3128a); aVar = aVar.f3132c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f3130a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = this.f3129b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f3129b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.f3128a.f3133d; !aVar.equals(this.f3128a); aVar = aVar.f3133d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f3129b.remove(aVar.f3130a);
            ((h) aVar.f3130a).a();
        }
        return null;
    }

    public final void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f3128a;
        aVar.f3133d = aVar2;
        aVar.f3132c = aVar2.f3132c;
        d(aVar);
    }
}
