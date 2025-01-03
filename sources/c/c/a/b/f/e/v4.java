package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class v4 extends e3<Integer> implements x4, q6, RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final v4 f4489d;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4490b;

    /* renamed from: c, reason: collision with root package name */
    public int f4491c;

    static {
        v4 v4Var = new v4(new int[0], 0);
        f4489d = v4Var;
        v4Var.c();
    }

    public v4() {
        this(new int[10], 0);
    }

    public static v4 d() {
        return f4489d;
    }

    public final void a(int i2) {
        b();
        int i3 = this.f4491c;
        int[] iArr = this.f4490b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f4490b = iArr2;
        }
        int[] iArr3 = this.f4490b;
        int i4 = this.f4491c;
        this.f4491c = i4 + 1;
        iArr3[i4] = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4491c)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        int[] iArr = this.f4490b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f4490b, i2, iArr2, i2 + 1, this.f4491c - i2);
            this.f4490b = iArr2;
        }
        this.f4490b[i2] = intValue;
        this.f4491c++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        u4.a(collection);
        if (!(collection instanceof v4)) {
            return super.addAll(collection);
        }
        v4 v4Var = (v4) collection;
        int i2 = v4Var.f4491c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4491c;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        int[] iArr = this.f4490b;
        if (i4 > iArr.length) {
            this.f4490b = Arrays.copyOf(iArr, i4);
        }
        System.arraycopy(v4Var.f4490b, 0, this.f4490b, this.f4491c, v4Var.f4491c);
        this.f4491c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i2) {
        if (i2 < 0 || i2 >= this.f4491c) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    public final String c(int i2) {
        int i3 = this.f4491c;
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
        if (!(obj instanceof v4)) {
            return super.equals(obj);
        }
        v4 v4Var = (v4) obj;
        if (this.f4491c != v4Var.f4491c) {
            return false;
        }
        int[] iArr = v4Var.f4490b;
        for (int i2 = 0; i2 < this.f4491c; i2++) {
            if (this.f4490b[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(zzc(i2));
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4491c; i3++) {
            i2 = (i2 * 31) + this.f4490b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4490b[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.f4491c; i2++) {
            if (obj.equals(Integer.valueOf(this.f4490b[i2]))) {
                int[] iArr = this.f4490b;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f4491c - i2) - 1);
                this.f4491c--;
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
        int[] iArr = this.f4490b;
        System.arraycopy(iArr, i3, iArr, i2, this.f4491c - i3);
        this.f4491c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        b(i2);
        int[] iArr = this.f4490b;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4491c;
    }

    @Override // c.c.a.b.f.e.z4
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final x4 zza(int i2) {
        if (i2 >= this.f4491c) {
            return new v4(Arrays.copyOf(this.f4490b, i2), this.f4491c);
        }
        throw new IllegalArgumentException();
    }

    public final int zzc(int i2) {
        b(i2);
        return this.f4490b[i2];
    }

    public v4(int[] iArr, int i2) {
        this.f4490b = iArr;
        this.f4491c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        b(i2);
        int[] iArr = this.f4490b;
        int i3 = iArr[i2];
        if (i2 < this.f4491c - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f4491c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Integer) obj).intValue());
        return true;
    }
}
