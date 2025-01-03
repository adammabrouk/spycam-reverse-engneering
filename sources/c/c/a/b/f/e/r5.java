package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class r5 extends e3<Long> implements a5, q6, RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final r5 f4396d;

    /* renamed from: b, reason: collision with root package name */
    public long[] f4397b;

    /* renamed from: c, reason: collision with root package name */
    public int f4398c;

    static {
        r5 r5Var = new r5(new long[0], 0);
        f4396d = r5Var;
        r5Var.c();
    }

    public r5() {
        this(new long[10], 0);
    }

    public static r5 d() {
        return f4396d;
    }

    public final void a(long j) {
        b();
        int i2 = this.f4398c;
        long[] jArr = this.f4397b;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f4397b = jArr2;
        }
        long[] jArr3 = this.f4397b;
        int i3 = this.f4398c;
        this.f4398c = i3 + 1;
        jArr3[i3] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4398c)) {
            throw new IndexOutOfBoundsException(b(i2));
        }
        long[] jArr = this.f4397b;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f4397b, i2, jArr2, i2 + 1, this.f4398c - i2);
            this.f4397b = jArr2;
        }
        this.f4397b[i2] = longValue;
        this.f4398c++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        u4.a(collection);
        if (!(collection instanceof r5)) {
            return super.addAll(collection);
        }
        r5 r5Var = (r5) collection;
        int i2 = r5Var.f4398c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4398c;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        long[] jArr = this.f4397b;
        if (i4 > jArr.length) {
            this.f4397b = Arrays.copyOf(jArr, i4);
        }
        System.arraycopy(r5Var.f4397b, 0, this.f4397b, this.f4398c, r5Var.f4398c);
        this.f4398c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final String b(int i2) {
        int i3 = this.f4398c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r5)) {
            return super.equals(obj);
        }
        r5 r5Var = (r5) obj;
        if (this.f4398c != r5Var.f4398c) {
            return false;
        }
        long[] jArr = r5Var.f4397b;
        for (int i2 = 0; i2 < this.f4398c; i2++) {
            if (this.f4397b[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(zzb(i2));
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4398c; i3++) {
            i2 = (i2 * 31) + u4.a(this.f4397b[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4397b[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.f4398c; i2++) {
            if (obj.equals(Long.valueOf(this.f4397b[i2]))) {
                long[] jArr = this.f4397b;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f4398c - i2) - 1);
                this.f4398c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f4397b;
        System.arraycopy(jArr, i3, jArr, i2, this.f4398c - i3);
        this.f4398c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        a(i2);
        long[] jArr = this.f4397b;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4398c;
    }

    @Override // c.c.a.b.f.e.a5
    public final long zzb(int i2) {
        a(i2);
        return this.f4397b[i2];
    }

    @Override // c.c.a.b.f.e.z4
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final a5 zza(int i2) {
        if (i2 >= this.f4398c) {
            return new r5(Arrays.copyOf(this.f4397b, i2), this.f4398c);
        }
        throw new IllegalArgumentException();
    }

    public r5(long[] jArr, int i2) {
        this.f4397b = jArr;
        this.f4398c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        a(i2);
        long[] jArr = this.f4397b;
        long j = jArr[i2];
        if (i2 < this.f4398c - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (r3 - i2) - 1);
        }
        this.f4398c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    public final void a(int i2) {
        if (i2 < 0 || i2 >= this.f4398c) {
            throw new IndexOutOfBoundsException(b(i2));
        }
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }
}
