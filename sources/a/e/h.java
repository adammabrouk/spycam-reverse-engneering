package a.e;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f715e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f716a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f717b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f718c;

    /* renamed from: d, reason: collision with root package name */
    public int f719d;

    public h() {
        this(10);
    }

    public E a(int i2) {
        return b(i2, null);
    }

    public E b(int i2, E e2) {
        int a2 = c.a(this.f717b, this.f719d, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f718c;
            if (objArr[a2] != f715e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void c(int i2, E e2) {
        int a2 = c.a(this.f717b, this.f719d, i2);
        if (a2 >= 0) {
            this.f718c[a2] = e2;
            return;
        }
        int i3 = a2 ^ (-1);
        if (i3 < this.f719d) {
            Object[] objArr = this.f718c;
            if (objArr[i3] == f715e) {
                this.f717b[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f716a && this.f719d >= this.f717b.length) {
            b();
            i3 = c.a(this.f717b, this.f719d, i2) ^ (-1);
        }
        int i4 = this.f719d;
        if (i4 >= this.f717b.length) {
            int b2 = c.b(i4 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f717b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f718c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f717b = iArr;
            this.f718c = objArr2;
        }
        int i5 = this.f719d;
        if (i5 - i3 != 0) {
            int[] iArr3 = this.f717b;
            int i6 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
            Object[] objArr4 = this.f718c;
            System.arraycopy(objArr4, i3, objArr4, i6, this.f719d - i3);
        }
        this.f717b[i3] = i2;
        this.f718c[i3] = e2;
        this.f719d++;
    }

    public String toString() {
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f719d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f719d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(b(i2));
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

    public h(int i2) {
        this.f716a = false;
        if (i2 == 0) {
            this.f717b = c.f677a;
            this.f718c = c.f679c;
        } else {
            int b2 = c.b(i2);
            this.f717b = new int[b2];
            this.f718c = new Object[b2];
        }
    }

    public int a(E e2) {
        if (this.f716a) {
            b();
        }
        for (int i2 = 0; i2 < this.f719d; i2++) {
            if (this.f718c[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<E> m1clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f717b = (int[]) this.f717b.clone();
            hVar.f718c = (Object[]) this.f718c.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void b() {
        int i2 = this.f719d;
        int[] iArr = this.f717b;
        Object[] objArr = this.f718c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f715e) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f716a = false;
        this.f719d = i3;
    }

    public void a() {
        int i2 = this.f719d;
        Object[] objArr = this.f718c;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f719d = 0;
        this.f716a = false;
    }

    public void a(int i2, E e2) {
        int i3 = this.f719d;
        if (i3 != 0 && i2 <= this.f717b[i3 - 1]) {
            c(i2, e2);
            return;
        }
        if (this.f716a && this.f719d >= this.f717b.length) {
            b();
        }
        int i4 = this.f719d;
        if (i4 >= this.f717b.length) {
            int b2 = c.b(i4 + 1);
            int[] iArr = new int[b2];
            Object[] objArr = new Object[b2];
            int[] iArr2 = this.f717b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f718c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f717b = iArr;
            this.f718c = objArr;
        }
        this.f717b[i4] = i2;
        this.f718c[i4] = e2;
        this.f719d = i4 + 1;
    }

    public int b(int i2) {
        if (this.f716a) {
            b();
        }
        return this.f717b[i2];
    }

    public int c() {
        if (this.f716a) {
            b();
        }
        return this.f719d;
    }

    public E c(int i2) {
        if (this.f716a) {
            b();
        }
        return (E) this.f718c[i2];
    }
}
