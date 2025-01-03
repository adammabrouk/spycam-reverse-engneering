package a.h.i;

import com.shix.shixipc.utilcode.LogUtils;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f1104a;

    /* renamed from: b, reason: collision with root package name */
    public final S f1105b;

    public d(F f2, S s) {
        this.f1104a = f2;
        this.f1105b = s;
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f1104a, this.f1104a) && c.a(dVar.f1105b, this.f1105b);
    }

    public int hashCode() {
        F f2 = this.f1104a;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f1105b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f1104a + LogUtils.PLACEHOLDER + this.f1105b + "}";
    }
}
