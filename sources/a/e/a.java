package a.e;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: h, reason: collision with root package name */
    public f<K, V> f665h;

    /* compiled from: ArrayMap.java */
    /* renamed from: a.e.a$a, reason: collision with other inner class name */
    public class C0011a extends f<K, V> {
        public C0011a() {
        }

        @Override // a.e.f
        public Object a(int i2, int i3) {
            return a.this.f713b[(i2 << 1) + i3];
        }

        @Override // a.e.f
        public int b(Object obj) {
            return a.this.b(obj);
        }

        @Override // a.e.f
        public int c() {
            return a.this.f714c;
        }

        @Override // a.e.f
        public int a(Object obj) {
            return a.this.a(obj);
        }

        @Override // a.e.f
        public Map<K, V> b() {
            return a.this;
        }

        @Override // a.e.f
        public void a(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.e.f
        public V a(int i2, V v) {
            return a.this.a(i2, (int) v);
        }

        @Override // a.e.f
        public void a(int i2) {
            a.this.d(i2);
        }

        @Override // a.e.f
        public void a() {
            a.this.clear();
        }
    }

    public a() {
    }

    public boolean a(Collection<?> collection) {
        return f.c(this, collection);
    }

    public final f<K, V> b() {
        if (this.f665h == null) {
            this.f665h = new C0011a();
        }
        return this.f665h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(this.f714c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }
}
