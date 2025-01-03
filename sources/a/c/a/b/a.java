package a.c.a.b;

import a.c.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public HashMap<K, b.c<K, V>> f631e = new HashMap<>();

    @Override // a.c.a.b.b
    public b.c<K, V> a(K k) {
        return this.f631e.get(k);
    }

    @Override // a.c.a.b.b
    public V b(K k, V v) {
        b.c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f637b;
        }
        this.f631e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f631e.containsKey(k);
    }

    @Override // a.c.a.b.b
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f631e.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.f631e.get(k).f639d;
        }
        return null;
    }
}
