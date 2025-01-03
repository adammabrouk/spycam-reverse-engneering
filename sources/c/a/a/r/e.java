package c.a.a.r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<T, Y> {

    /* renamed from: b, reason: collision with root package name */
    public int f3457b;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<T, Y> f3456a = new LinkedHashMap<>(100, 0.75f, true);

    /* renamed from: c, reason: collision with root package name */
    public int f3458c = 0;

    public e(int i2) {
        this.f3457b = i2;
    }

    public Y a(T t) {
        return this.f3456a.get(t);
    }

    public void a(T t, Y y) {
    }

    public int b(Y y) {
        return 1;
    }

    public Y b(T t, Y y) {
        if (b((e<T, Y>) y) >= this.f3457b) {
            a(t, y);
            return null;
        }
        Y put = this.f3456a.put(t, y);
        if (y != null) {
            this.f3458c += b((e<T, Y>) y);
        }
        if (put != null) {
            this.f3458c -= b((e<T, Y>) put);
        }
        b();
        return put;
    }

    public int c() {
        return this.f3458c;
    }

    public void a() {
        b(0);
    }

    public Y c(T t) {
        Y remove = this.f3456a.remove(t);
        if (remove != null) {
            this.f3458c -= b((e<T, Y>) remove);
        }
        return remove;
    }

    public void b(int i2) {
        while (this.f3458c > i2) {
            Map.Entry<T, Y> next = this.f3456a.entrySet().iterator().next();
            Y value = next.getValue();
            this.f3458c -= b((e<T, Y>) value);
            T key = next.getKey();
            this.f3456a.remove(key);
            a(key, value);
        }
    }

    public final void b() {
        b(this.f3457b);
    }
}
