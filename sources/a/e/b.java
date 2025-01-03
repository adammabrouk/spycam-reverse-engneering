package a.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f667e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public static final Object[] f668f = new Object[0];

    /* renamed from: g, reason: collision with root package name */
    public static Object[] f669g;

    /* renamed from: h, reason: collision with root package name */
    public static int f670h;

    /* renamed from: i, reason: collision with root package name */
    public static Object[] f671i;
    public static int j;

    /* renamed from: a, reason: collision with root package name */
    public int[] f672a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f673b;

    /* renamed from: c, reason: collision with root package name */
    public int f674c;

    /* renamed from: d, reason: collision with root package name */
    public f<E, E> f675d;

    /* compiled from: ArraySet.java */
    public class a extends f<E, E> {
        public a() {
        }

        @Override // a.e.f
        public Object a(int i2, int i3) {
            return b.this.f673b[i2];
        }

        @Override // a.e.f
        public int b(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.e.f
        public int c() {
            return b.this.f674c;
        }

        @Override // a.e.f
        public int a(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.e.f
        public Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.e.f
        public void a(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // a.e.f
        public E a(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.e.f
        public void a(int i2) {
            b.this.c(i2);
        }

        @Override // a.e.f
        public void a() {
            b.this.clear();
        }
    }

    public b() {
        this(0);
    }

    public final int a(Object obj, int i2) {
        int i3 = this.f674c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f672a, i3, i2);
        if (a2 < 0 || obj.equals(this.f673b[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f672a[i4] == i2) {
            if (obj.equals(this.f673b[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f672a[i5] == i2; i5--) {
            if (obj.equals(this.f673b[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int a2;
        if (e2 == null) {
            a2 = d();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            a2 = a(e2, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i3 = a2 ^ (-1);
        int i4 = this.f674c;
        if (i4 >= this.f672a.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f672a;
            Object[] objArr = this.f673b;
            a(i5);
            int[] iArr2 = this.f672a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f673b, 0, objArr.length);
            }
            a(iArr, objArr, this.f674c);
        }
        int i6 = this.f674c;
        if (i3 < i6) {
            int[] iArr3 = this.f672a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f673b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f674c - i3);
        }
        this.f672a[i3] = i2;
        this.f673b[i3] = e2;
        this.f674c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f674c + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.f672a;
        if (iArr.length < i2) {
            Object[] objArr = this.f673b;
            a(i2);
            int i3 = this.f674c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f672a, 0, i3);
                System.arraycopy(objArr, 0, this.f673b, 0, this.f674c);
            }
            a(iArr, objArr, this.f674c);
        }
    }

    public E c(int i2) {
        Object[] objArr = this.f673b;
        E e2 = (E) objArr[i2];
        int i3 = this.f674c;
        if (i3 <= 1) {
            a(this.f672a, objArr, i3);
            this.f672a = f667e;
            this.f673b = f668f;
            this.f674c = 0;
        } else {
            int[] iArr = this.f672a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = this.f674c - 1;
                this.f674c = i4;
                if (i2 < i4) {
                    int[] iArr2 = this.f672a;
                    int i5 = i2 + 1;
                    System.arraycopy(iArr2, i5, iArr2, i2, i4 - i2);
                    Object[] objArr2 = this.f673b;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f674c - i2);
                }
                this.f673b[this.f674c] = null;
            } else {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr3 = this.f672a;
                Object[] objArr3 = this.f673b;
                a(i6);
                this.f674c--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f672a, 0, i2);
                    System.arraycopy(objArr3, 0, this.f673b, 0, i2);
                }
                int i7 = this.f674c;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f672a, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.f673b, i2, this.f674c - i2);
                }
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f674c;
        if (i2 != 0) {
            a(this.f672a, this.f673b, i2);
            this.f672a = f667e;
            this.f673b = f668f;
            this.f674c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i2 = this.f674c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f672a, i2, 0);
        if (a2 < 0 || this.f673b[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f672a[i3] == 0) {
            if (this.f673b[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f672a[i4] == 0; i4--) {
            if (this.f673b[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f674c; i2++) {
                try {
                    if (!set.contains(d(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f672a;
        int i2 = this.f674c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? d() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f674c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        c(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f674c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f673b[i2])) {
                c(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f674c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f674c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f673b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f674c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f674c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E d2 = d(i2);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f672a = f667e;
            this.f673b = f668f;
        } else {
            a(i2);
        }
        this.f674c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f674c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f674c));
        }
        System.arraycopy(this.f673b, 0, tArr, 0, this.f674c);
        int length = tArr.length;
        int i2 = this.f674c;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (f671i != null) {
                    Object[] objArr = f671i;
                    this.f673b = objArr;
                    f671i = (Object[]) objArr[0];
                    this.f672a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (f669g != null) {
                    Object[] objArr2 = f669g;
                    this.f673b = objArr2;
                    f669g = (Object[]) objArr2[0];
                    this.f672a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f670h--;
                    return;
                }
            }
        }
        this.f672a = new int[i2];
        this.f673b = new Object[i2];
    }

    public final f<E, E> b() {
        if (this.f675d == null) {
            this.f675d = new a();
        }
        return this.f675d;
    }

    public E d(int i2) {
        return (E) this.f673b[i2];
    }

    public static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (j < 10) {
                    objArr[0] = f671i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f671i = objArr;
                    j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f670h < 10) {
                    objArr[0] = f669g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f669g = objArr;
                    f670h++;
                }
            }
        }
    }
}
