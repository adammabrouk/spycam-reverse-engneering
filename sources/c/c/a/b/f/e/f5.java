package c.c.a.b.f.e;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class f5<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Map.Entry<K, d5> f4164a;

    public f5(Map.Entry<K, d5> entry) {
        this.f4164a = entry;
    }

    public final d5 a() {
        return this.f4164a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f4164a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f4164a.getValue() == null) {
            return null;
        }
        d5.c();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof d6) {
            return this.f4164a.getValue().a((d6) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
