package a.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public c<K, V> f632a;

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f633b;

    /* renamed from: c, reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f634c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public int f635d = 0;

    /* compiled from: SafeIterableMap.java */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f639d;
        }

        @Override // a.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f638c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.c.a.b.b$b, reason: collision with other inner class name */
    public static class C0009b<K, V> extends e<K, V> {
        public C0009b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f638c;
        }

        @Override // a.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f639d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f636a;

        /* renamed from: b, reason: collision with root package name */
        public final V f637b;

        /* renamed from: c, reason: collision with root package name */
        public c<K, V> f638c;

        /* renamed from: d, reason: collision with root package name */
        public c<K, V> f639d;

        public c(K k, V v) {
            this.f636a = k;
            this.f637b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f636a.equals(cVar.f636a) && this.f637b.equals(cVar.f637b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f636a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f637b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f636a.hashCode() ^ this.f637b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f636a + "=" + this.f637b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f640a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f641b = true;

        public d() {
        }

        @Override // a.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f640a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f639d;
                this.f640a = cVar3;
                this.f641b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f641b) {
                return b.this.f632a != null;
            }
            c<K, V> cVar = this.f640a;
            return (cVar == null || cVar.f638c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f641b) {
                this.f641b = false;
                this.f640a = b.this.f632a;
            } else {
                c<K, V> cVar = this.f640a;
                this.f640a = cVar != null ? cVar.f638c : null;
            }
            return this.f640a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f643a;

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f644b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f643a = cVar2;
            this.f644b = cVar;
        }

        @Override // a.c.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f643a == cVar && cVar == this.f644b) {
                this.f644b = null;
                this.f643a = null;
            }
            c<K, V> cVar2 = this.f643a;
            if (cVar2 == cVar) {
                this.f643a = b(cVar2);
            }
            if (this.f644b == cVar) {
                this.f644b = a();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f644b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f644b;
            this.f644b = a();
            return cVar;
        }

        public final c<K, V> a() {
            c<K, V> cVar = this.f644b;
            c<K, V> cVar2 = this.f643a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* compiled from: SafeIterableMap.java */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f632a;
        while (cVar != null && !cVar.f636a.equals(k)) {
            cVar = cVar.f638c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f637b;
        }
        a(k, v);
        return null;
    }

    public Map.Entry<K, V> d() {
        return this.f632a;
    }

    public b<K, V>.d e() {
        b<K, V>.d dVar = new d();
        this.f634c.put(dVar, false);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry<K, V> f() {
        return this.f633b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().hashCode();
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f632a, this.f633b);
        this.f634c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f635d--;
        if (!this.f634c.isEmpty()) {
            Iterator<f<K, V>> it = this.f634c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(a2);
            }
        }
        c<K, V> cVar = a2.f639d;
        if (cVar != null) {
            cVar.f638c = a2.f638c;
        } else {
            this.f632a = a2.f638c;
        }
        c<K, V> cVar2 = a2.f638c;
        if (cVar2 != null) {
            cVar2.f639d = a2.f639d;
        } else {
            this.f633b = a2.f639d;
        }
        a2.f638c = null;
        a2.f639d = null;
        return a2.f637b;
    }

    public int size() {
        return this.f635d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f635d++;
        c<K, V> cVar2 = this.f633b;
        if (cVar2 == null) {
            this.f632a = cVar;
            this.f633b = cVar;
            return cVar;
        }
        cVar2.f638c = cVar;
        cVar.f639d = cVar2;
        this.f633b = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0009b c0009b = new C0009b(this.f633b, this.f632a);
        this.f634c.put(c0009b, false);
        return c0009b;
    }
}
