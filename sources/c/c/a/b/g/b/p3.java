package c.c.a.b.g.b;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class p3<V> {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f4988h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f4989a;

    /* renamed from: b, reason: collision with root package name */
    public final n3<V> f4990b;

    /* renamed from: c, reason: collision with root package name */
    public final V f4991c;

    /* renamed from: d, reason: collision with root package name */
    public final V f4992d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4993e;

    /* renamed from: f, reason: collision with root package name */
    public volatile V f4994f;

    /* renamed from: g, reason: collision with root package name */
    public volatile V f4995g;

    public p3(String str, V v, V v2, n3<V> n3Var) {
        this.f4993e = new Object();
        this.f4994f = null;
        this.f4995g = null;
        this.f4989a = str;
        this.f4991c = v;
        this.f4992d = v2;
        this.f4990b = n3Var;
    }

    public final String a() {
        return this.f4989a;
    }

    public final V a(V v) {
        List<p3> list;
        synchronized (this.f4993e) {
        }
        if (v != null) {
            return v;
        }
        if (m3.f4926a == null) {
            return this.f4991c;
        }
        synchronized (f4988h) {
            if (fa.a()) {
                return this.f4995g == null ? this.f4991c : this.f4995g;
            }
            try {
                list = r.f5026a;
                for (p3 p3Var : list) {
                    if (fa.a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        if (p3Var.f4990b != null) {
                            v2 = p3Var.f4990b.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f4988h) {
                        p3Var.f4995g = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            n3<V> n3Var = this.f4990b;
            if (n3Var == null) {
                return this.f4991c;
            }
            try {
                return n3Var.zza();
            } catch (IllegalStateException unused3) {
                return this.f4991c;
            } catch (SecurityException unused4) {
                return this.f4991c;
            }
        }
    }
}
