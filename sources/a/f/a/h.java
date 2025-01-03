package a.f.a;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class h<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f755a;

    /* renamed from: b, reason: collision with root package name */
    public int f756b;

    public h(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f755a = new Object[i2];
    }

    @Override // a.f.a.g
    public T a() {
        int i2 = this.f756b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f755a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f756b = i2 - 1;
        return t;
    }

    @Override // a.f.a.g
    public boolean a(T t) {
        int i2 = this.f756b;
        Object[] objArr = this.f755a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f756b = i2 + 1;
        return true;
    }

    @Override // a.f.a.g
    public void a(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t = tArr[i3];
            int i4 = this.f756b;
            Object[] objArr = this.f755a;
            if (i4 < objArr.length) {
                objArr[i4] = t;
                this.f756b = i4 + 1;
            }
        }
    }
}
