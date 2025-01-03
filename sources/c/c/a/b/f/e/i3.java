package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class i3 extends e3<Boolean> implements z4<Boolean>, q6, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f4222b;

    /* renamed from: c, reason: collision with root package name */
    public int f4223c;

    static {
        new i3(new boolean[0], 0).c();
    }

    public i3() {
        this(new boolean[10], 0);
    }

    public final void a(boolean z) {
        b();
        int i2 = this.f4223c;
        boolean[] zArr = this.f4222b;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f4222b = zArr2;
        }
        boolean[] zArr3 = this.f4222b;
        int i3 = this.f4223c;
        this.f4223c = i3 + 1;
        zArr3[i3] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4223c)) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
        boolean[] zArr = this.f4222b;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f4222b, i2, zArr2, i2 + 1, this.f4223c - i2);
            this.f4222b = zArr2;
        }
        this.f4222b[i2] = booleanValue;
        this.f4223c++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        u4.a(collection);
        if (!(collection instanceof i3)) {
            return super.addAll(collection);
        }
        i3 i3Var = (i3) collection;
        int i2 = i3Var.f4223c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4223c;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        boolean[] zArr = this.f4222b;
        if (i4 > zArr.length) {
            this.f4222b = Arrays.copyOf(zArr, i4);
        }
        System.arraycopy(i3Var.f4222b, 0, this.f4222b, this.f4223c, i3Var.f4223c);
        this.f4223c = i4;
        ((AbstractList) this).modCount++;
        return true;
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
        if (!(obj instanceof i3)) {
            return super.equals(obj);
        }
        i3 i3Var = (i3) obj;
        if (this.f4223c != i3Var.f4223c) {
            return false;
        }
        boolean[] zArr = i3Var.f4222b;
        for (int i2 = 0; i2 < this.f4223c; i2++) {
            if (this.f4222b[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzb(i2);
        return Boolean.valueOf(this.f4222b[i2]);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4223c; i3++) {
            i2 = (i2 * 31) + u4.a(this.f4222b[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4222b[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.f4223c; i2++) {
            if (obj.equals(Boolean.valueOf(this.f4222b[i2]))) {
                boolean[] zArr = this.f4222b;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f4223c - i2) - 1);
                this.f4223c--;
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
        boolean[] zArr = this.f4222b;
        System.arraycopy(zArr, i3, zArr, i2, this.f4223c - i3);
        this.f4223c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        zzb(i2);
        boolean[] zArr = this.f4222b;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4223c;
    }

    @Override // c.c.a.b.f.e.z4
    public final /* synthetic */ z4<Boolean> zza(int i2) {
        if (i2 >= this.f4223c) {
            return new i3(Arrays.copyOf(this.f4222b, i2), this.f4223c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzb(int i2) {
        if (i2 < 0 || i2 >= this.f4223c) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
    }

    public final String zzc(int i2) {
        int i3 = this.f4223c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public i3(boolean[] zArr, int i2) {
        this.f4222b = zArr;
        this.f4223c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        zzb(i2);
        boolean[] zArr = this.f4222b;
        boolean z = zArr[i2];
        if (i2 < this.f4223c - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (r2 - i2) - 1);
        }
        this.f4223c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }
}
