package f;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class d<A, B> implements Serializable {
    public final A first;
    public final B second;

    public d(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d copy$default(d dVar, Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = dVar.first;
        }
        if ((i2 & 2) != 0) {
            obj2 = dVar.second;
        }
        return dVar.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final d<A, B> copy(A a2, B b2) {
        return new d<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return f.j.b.f.a(this.first, dVar.first) && f.j.b.f.a(this.second, dVar.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
