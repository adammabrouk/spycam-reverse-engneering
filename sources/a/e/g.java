package a.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: d, reason: collision with root package name */
    public static Object[] f708d;

    /* renamed from: e, reason: collision with root package name */
    public static int f709e;

    /* renamed from: f, reason: collision with root package name */
    public static Object[] f710f;

    /* renamed from: g, reason: collision with root package name */
    public static int f711g;

    /* renamed from: a, reason: collision with root package name */
    public int[] f712a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f713b;

    /* renamed from: c, reason: collision with root package name */
    public int f714c;

    public g() {
        this.f712a = c.f677a;
        this.f713b = c.f679c;
        this.f714c = 0;
    }

    public static int a(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void b(int i2) {
        int i3 = this.f714c;
        int[] iArr = this.f712a;
        if (iArr.length < i2) {
            Object[] objArr = this.f713b;
            a(i2);
            if (this.f714c > 0) {
                System.arraycopy(iArr, 0, this.f712a, 0, i3);
                System.arraycopy(objArr, 0, this.f713b, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f714c != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public K c(int i2) {
        return (K) this.f713b[i2 << 1];
    }

    public void clear() {
        int i2 = this.f714c;
        if (i2 > 0) {
            int[] iArr = this.f712a;
            Object[] objArr = this.f713b;
            this.f712a = c.f677a;
            this.f713b = c.f679c;
            this.f714c = 0;
            a(iArr, objArr, i2);
        }
        if (this.f714c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        Object[] objArr = this.f713b;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f714c;
        int i5 = 0;
        if (i4 <= 1) {
            a(this.f712a, objArr, i4);
            this.f712a = c.f677a;
            this.f713b = c.f679c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f712a;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int[] iArr2 = this.f712a;
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr2, i7, iArr2, i2, i8);
                    Object[] objArr2 = this.f713b;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f713b;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                int i10 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr3 = this.f712a;
                Object[] objArr4 = this.f713b;
                a(i10);
                if (i4 != this.f714c) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f712a, 0, i2);
                    System.arraycopy(objArr4, 0, this.f713b, 0, i3);
                }
                if (i2 < i6) {
                    int i11 = i2 + 1;
                    int i12 = i6 - i2;
                    System.arraycopy(iArr3, i11, this.f712a, i2, i12);
                    System.arraycopy(objArr4, i11 << 1, this.f713b, i3, i12 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.f714c) {
            throw new ConcurrentModificationException();
        }
        this.f714c = i5;
        return v;
    }

    public V e(int i2) {
        return (V) this.f713b[(i2 << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f714c; i2++) {
                try {
                    K c2 = c(i2);
                    V e2 = e(i2);
                    Object obj2 = gVar.get(c2);
                    if (e2 == null) {
                        if (obj2 != null || !gVar.containsKey(c2)) {
                            return false;
                        }
                    } else if (!e2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f714c; i3++) {
                try {
                    K c3 = c(i3);
                    V e3 = e(i3);
                    Object obj3 = map.get(c3);
                    if (e3 == null) {
                        if (obj3 != null || !map.containsKey(c3)) {
                            return false;
                        }
                    } else if (!e3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? (V) this.f713b[(a2 << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f712a;
        Object[] objArr = this.f713b;
        int i2 = this.f714c;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public boolean isEmpty() {
        return this.f714c <= 0;
    }

    public V put(K k, V v) {
        int i2;
        int a2;
        int i3 = this.f714c;
        if (k == null) {
            a2 = a();
            i2 = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = hashCode;
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i4 = (a2 << 1) + 1;
            Object[] objArr = this.f713b;
            V v2 = (V) objArr[i4];
            objArr[i4] = v;
            return v2;
        }
        int i5 = a2 ^ (-1);
        if (i3 >= this.f712a.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f712a;
            Object[] objArr2 = this.f713b;
            a(i6);
            if (i3 != this.f714c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f712a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f713b, 0, objArr2.length);
            }
            a(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f712a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f713b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.f714c - i5) << 1);
        }
        int i8 = this.f714c;
        if (i3 == i8) {
            int[] iArr4 = this.f712a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f713b;
                int i9 = i5 << 1;
                objArr4[i9] = k;
                objArr4[i9 + 1] = v;
                this.f714c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public V replace(K k, V v) {
        int a2 = a(k);
        if (a2 >= 0) {
            return a(a2, (int) v);
        }
        return null;
    }

    public int size() {
        return this.f714c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f714c * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f714c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V e2 = e(i2);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int a(Object obj, int i2) {
        int i3 = this.f714c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f712a, i3, i2);
        if (a2 < 0 || obj.equals(this.f713b[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f712a[i4] == i2) {
            if (obj.equals(this.f713b[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f712a[i5] == i2; i5--) {
            if (obj.equals(this.f713b[i5 << 1])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        V e2 = e(a2);
        if (obj2 != e2 && (obj2 == null || !obj2.equals(e2))) {
            return false;
        }
        d(a2);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a(k);
        if (a2 < 0) {
            return false;
        }
        V e2 = e(a2);
        if (e2 != v && (v == null || !v.equals(e2))) {
            return false;
        }
        a(a2, (int) v2);
        return true;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f712a = c.f677a;
            this.f713b = c.f679c;
        } else {
            a(i2);
        }
        this.f714c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            a((g) gVar);
        }
    }

    public int a() {
        int i2 = this.f714c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f712a, i2, 0);
        if (a2 < 0 || this.f713b[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f712a[i3] == 0) {
            if (this.f713b[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f712a[i4] == 0; i4--) {
            if (this.f713b[i4 << 1] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public int b(Object obj) {
        int i2 = this.f714c * 2;
        Object[] objArr = this.f713b;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                if (f710f != null) {
                    Object[] objArr = f710f;
                    this.f713b = objArr;
                    f710f = (Object[]) objArr[0];
                    this.f712a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f711g--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                if (f708d != null) {
                    Object[] objArr2 = f708d;
                    this.f713b = objArr2;
                    f708d = (Object[]) objArr2[0];
                    this.f712a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f709e--;
                    return;
                }
            }
        }
        this.f712a = new int[i2];
        this.f713b = new Object[i2 << 1];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f711g < 10) {
                    objArr[0] = f710f;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f710f = objArr;
                    f711g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f709e < 10) {
                    objArr[0] = f708d;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f708d = objArr;
                    f709e++;
                }
            }
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f713b;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public void a(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.f714c;
        b(this.f714c + i2);
        if (this.f714c != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.c(i3), gVar.e(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f712a, 0, this.f712a, 0, i2);
            System.arraycopy(gVar.f713b, 0, this.f713b, 0, i2 << 1);
            this.f714c = i2;
        }
    }
}
