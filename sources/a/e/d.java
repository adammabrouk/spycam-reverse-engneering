package a.e;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f680e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f681a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f682b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f683c;

    /* renamed from: d, reason: collision with root package name */
    public int f684d;

    public d() {
        this(10);
    }

    public E a(long j) {
        return b(j, null);
    }

    public E b(long j, E e2) {
        int a2 = c.a(this.f682b, this.f684d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f683c;
            if (objArr[a2] != f680e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void c(long j) {
        int a2 = c.a(this.f682b, this.f684d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f683c;
            Object obj = objArr[a2];
            Object obj2 = f680e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f681a = true;
            }
        }
    }

    public String toString() {
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f684d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f684d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(a(i2));
            sb.append('=');
            E c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f681a = false;
        if (i2 == 0) {
            this.f682b = c.f678b;
            this.f683c = c.f679c;
        } else {
            int c2 = c.c(i2);
            this.f682b = new long[c2];
            this.f683c = new Object[c2];
        }
    }

    public long a(int i2) {
        if (this.f681a) {
            b();
        }
        return this.f682b[i2];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public d<E> m0clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f682b = (long[]) this.f682b.clone();
            dVar.f683c = (Object[]) this.f683c.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public void b(int i2) {
        Object[] objArr = this.f683c;
        Object obj = objArr[i2];
        Object obj2 = f680e;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f681a = true;
        }
    }

    public void a() {
        int i2 = this.f684d;
        Object[] objArr = this.f683c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f684d = 0;
        this.f681a = false;
    }

    public void c(long j, E e2) {
        int a2 = c.a(this.f682b, this.f684d, j);
        if (a2 >= 0) {
            this.f683c[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f684d) {
            Object[] objArr = this.f683c;
            if (objArr[i2] == f680e) {
                this.f682b[i2] = j;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f681a && this.f684d >= this.f682b.length) {
            b();
            i2 = c.a(this.f682b, this.f684d, j) ^ (-1);
        }
        int i3 = this.f684d;
        if (i3 >= this.f682b.length) {
            int c2 = c.c(i3 + 1);
            long[] jArr = new long[c2];
            Object[] objArr2 = new Object[c2];
            long[] jArr2 = this.f682b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f683c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f682b = jArr;
            this.f683c = objArr2;
        }
        int i4 = this.f684d;
        if (i4 - i2 != 0) {
            long[] jArr3 = this.f682b;
            int i5 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
            Object[] objArr4 = this.f683c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f684d - i2);
        }
        this.f682b[i2] = j;
        this.f683c[i2] = e2;
        this.f684d++;
    }

    public final void b() {
        int i2 = this.f684d;
        long[] jArr = this.f682b;
        Object[] objArr = this.f683c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f680e) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f681a = false;
        this.f684d = i3;
    }

    public void a(long j, E e2) {
        int i2 = this.f684d;
        if (i2 != 0 && j <= this.f682b[i2 - 1]) {
            c(j, e2);
            return;
        }
        if (this.f681a && this.f684d >= this.f682b.length) {
            b();
        }
        int i3 = this.f684d;
        if (i3 >= this.f682b.length) {
            int c2 = c.c(i3 + 1);
            long[] jArr = new long[c2];
            Object[] objArr = new Object[c2];
            long[] jArr2 = this.f682b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f683c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f682b = jArr;
            this.f683c = objArr;
        }
        this.f682b[i3] = j;
        this.f683c[i3] = e2;
        this.f684d = i3 + 1;
    }

    public int b(long j) {
        if (this.f681a) {
            b();
        }
        return c.a(this.f682b, this.f684d, j);
    }

    public int c() {
        if (this.f681a) {
            b();
        }
        return this.f684d;
    }

    public E c(int i2) {
        if (this.f681a) {
            b();
        }
        return (E) this.f683c[i2];
    }
}
