package c.c.a.b.f.e;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class z6<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public int f4550a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator<Map.Entry<K, V>> f4551b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x6 f4552c;

    public z6(x6 x6Var) {
        List list;
        this.f4552c = x6Var;
        list = this.f4552c.f4517b;
        this.f4550a = list.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.f4550a;
        if (i2 > 0) {
            list = this.f4552c.f4517b;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (zza().hasNext()) {
            return zza().next();
        }
        list = this.f4552c.f4517b;
        int i2 = this.f4550a - 1;
        this.f4550a = i2;
        return (Map.Entry) list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.f4551b == null) {
            map = this.f4552c.f4521f;
            this.f4551b = map.entrySet().iterator();
        }
        return this.f4551b;
    }

    public /* synthetic */ z6(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
