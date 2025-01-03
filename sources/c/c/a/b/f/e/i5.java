package c.c.a.b.f.e;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class i5<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator<Map.Entry<K, Object>> f4224a;

    public i5(Iterator<Map.Entry<K, Object>> it) {
        this.f4224a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4224a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f4224a.next();
        return next.getValue() instanceof d5 ? new f5(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4224a.remove();
    }
}
