package a.h.i;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1106a;

    /* renamed from: b, reason: collision with root package name */
    public int f1107b;

    public f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1106a = new Object[i2];
    }

    @Override // a.h.i.e
    public T a() {
        int i2 = this.f1107b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f1106a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f1107b = i2 - 1;
        return t;
    }

    public final boolean b(T t) {
        for (int i2 = 0; i2 < this.f1107b; i2++) {
            if (this.f1106a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // a.h.i.e
    public boolean a(T t) {
        if (!b(t)) {
            int i2 = this.f1107b;
            Object[] objArr = this.f1106a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f1107b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
