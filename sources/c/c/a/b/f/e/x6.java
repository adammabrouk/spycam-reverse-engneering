package c.c.a.b.f.e;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public class x6<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f4516a;

    /* renamed from: b, reason: collision with root package name */
    public List<c7> f4517b;

    /* renamed from: c, reason: collision with root package name */
    public Map<K, V> f4518c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4519d;

    /* renamed from: e, reason: collision with root package name */
    public volatile e7 f4520e;

    /* renamed from: f, reason: collision with root package name */
    public Map<K, V> f4521f;

    /* renamed from: g, reason: collision with root package name */
    public volatile y6 f4522g;

    public x6(int i2) {
        this.f4516a = i2;
        this.f4517b = Collections.emptyList();
        this.f4518c = Collections.emptyMap();
        this.f4521f = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends n4<FieldDescriptorType>> x6<FieldDescriptorType, Object> c(int i2) {
        return new w6(i2);
    }

    public void a() {
        if (this.f4519d) {
            return;
        }
        this.f4518c = this.f4518c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4518c);
        this.f4521f = this.f4521f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4521f);
        this.f4519d = true;
    }

    public final boolean b() {
        return this.f4519d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f4517b.isEmpty()) {
            this.f4517b.clear();
        }
        if (this.f4518c.isEmpty()) {
            return;
        }
        this.f4518c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((x6<K, V>) comparable) >= 0 || this.f4518c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        return this.f4518c.isEmpty() ? b7.a() : this.f4518c.entrySet();
    }

    public final Set<Map.Entry<K, V>> e() {
        if (this.f4522g == null) {
            this.f4522g = new y6(this, null);
        }
        return this.f4522g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f4520e == null) {
            this.f4520e = new e7(this, null);
        }
        return this.f4520e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x6)) {
            return super.equals(obj);
        }
        x6 x6Var = (x6) obj;
        int size = size();
        if (size != x6Var.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != x6Var.c()) {
            return entrySet().equals(x6Var.entrySet());
        }
        for (int i2 = 0; i2 < c2; i2++) {
            if (!a(i2).equals(x6Var.a(i2))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f4518c.equals(x6Var.f4518c);
        }
        return true;
    }

    public final void f() {
        if (this.f4519d) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> g() {
        f();
        if (this.f4518c.isEmpty() && !(this.f4518c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4518c = treeMap;
            this.f4521f = treeMap.descendingMap();
        }
        return (SortedMap) this.f4518c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((x6<K, V>) comparable);
        return a2 >= 0 ? (V) this.f4517b.get(a2).getValue() : this.f4518c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c2 = c();
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            i2 += this.f4517b.get(i3).hashCode();
        }
        return this.f4518c.size() > 0 ? i2 + this.f4518c.hashCode() : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((x6<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((x6<K, V>) comparable);
        if (a2 >= 0) {
            return (V) b(a2);
        }
        if (this.f4518c.isEmpty()) {
            return null;
        }
        return this.f4518c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f4517b.size() + this.f4518c.size();
    }

    public final V b(int i2) {
        f();
        V v = (V) this.f4517b.remove(i2).getValue();
        if (!this.f4518c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f4517b.add(new c7(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final int c() {
        return this.f4517b.size();
    }

    public /* synthetic */ x6(int i2, w6 w6Var) {
        this(i2);
    }

    public final Map.Entry<K, V> a(int i2) {
        return this.f4517b.get(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((x6<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f4517b.get(a2).setValue(v);
        }
        f();
        if (this.f4517b.isEmpty() && !(this.f4517b instanceof ArrayList)) {
            this.f4517b = new ArrayList(this.f4516a);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f4516a) {
            return g().put(k, v);
        }
        int size = this.f4517b.size();
        int i3 = this.f4516a;
        if (size == i3) {
            c7 remove = this.f4517b.remove(i3 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f4517b.add(i2, new c7(this, k, v));
        return null;
    }

    public final int a(K k) {
        int size = this.f4517b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f4517b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.f4517b.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }
}
