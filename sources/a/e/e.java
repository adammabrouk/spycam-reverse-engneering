package a.e;

import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f685a;

    /* renamed from: b, reason: collision with root package name */
    public int f686b;

    /* renamed from: c, reason: collision with root package name */
    public int f687c;

    /* renamed from: d, reason: collision with root package name */
    public int f688d;

    /* renamed from: e, reason: collision with root package name */
    public int f689e;

    /* renamed from: f, reason: collision with root package name */
    public int f690f;

    /* renamed from: g, reason: collision with root package name */
    public int f691g;

    /* renamed from: h, reason: collision with root package name */
    public int f692h;

    public e(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f687c = i2;
        this.f685a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public V a(K k) {
        return null;
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f688d++;
            this.f686b += b(k, v);
            put = this.f685a.put(k, v);
            if (put != null) {
                this.f686b -= b(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.f687c);
        return put;
    }

    public void a(boolean z, K k, V v, V v2) {
    }

    public final V b(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.f685a.get(k);
            if (v2 != null) {
                this.f691g++;
                return v2;
            }
            this.f692h++;
            V a2 = a((e<K, V>) k);
            if (a2 == null) {
                return null;
            }
            synchronized (this) {
                this.f689e++;
                v = (V) this.f685a.put(k, a2);
                if (v != null) {
                    this.f685a.put(k, v);
                } else {
                    this.f686b += b(k, a2);
                }
            }
            if (v != null) {
                a(false, k, a2, v);
                return v;
            }
            a(this.f687c);
            return a2;
        }
    }

    public int c(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i2;
        i2 = this.f691g + this.f692h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f687c), Integer.valueOf(this.f691g), Integer.valueOf(this.f692h), Integer.valueOf(i2 != 0 ? (this.f691g * 100) / i2 : 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f686b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f685a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f686b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f686b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f685a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f685a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f685a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f686b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.b(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f686b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f690f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f690f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.a(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r5
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.e.a(int):void");
    }

    public final int b(K k, V v) {
        int c2 = c(k, v);
        if (c2 >= 0) {
            return c2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void a() {
        a(-1);
    }
}
