package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class c4 extends e3<Double> implements z4<Double>, q6, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public double[] f4118b;

    /* renamed from: c, reason: collision with root package name */
    public int f4119c;

    static {
        new c4(new double[0], 0).c();
    }

    public c4() {
        this(new double[10], 0);
    }

    public final void a(double d2) {
        b();
        int i2 = this.f4119c;
        double[] dArr = this.f4118b;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f4118b = dArr2;
        }
        double[] dArr3 = this.f4118b;
        int i3 = this.f4119c;
        this.f4119c = i3 + 1;
        dArr3[i3] = d2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4119c)) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
        double[] dArr = this.f4118b;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f4118b, i2, dArr2, i2 + 1, this.f4119c - i2);
            this.f4118b = dArr2;
        }
        this.f4118b[i2] = doubleValue;
        this.f4119c++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        u4.a(collection);
        if (!(collection instanceof c4)) {
            return super.addAll(collection);
        }
        c4 c4Var = (c4) collection;
        int i2 = c4Var.f4119c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4119c;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        double[] dArr = this.f4118b;
        if (i4 > dArr.length) {
            this.f4118b = Arrays.copyOf(dArr, i4);
        }
        System.arraycopy(c4Var.f4118b, 0, this.f4118b, this.f4119c, c4Var.f4119c);
        this.f4119c = i4;
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
        if (!(obj instanceof c4)) {
            return super.equals(obj);
        }
        c4 c4Var = (c4) obj;
        if (this.f4119c != c4Var.f4119c) {
            return false;
        }
        double[] dArr = c4Var.f4118b;
        for (int i2 = 0; i2 < this.f4119c; i2++) {
            if (Double.doubleToLongBits(this.f4118b[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzb(i2);
        return Double.valueOf(this.f4118b[i2]);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4119c; i3++) {
            i2 = (i2 * 31) + u4.a(Double.doubleToLongBits(this.f4118b[i3]));
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4118b[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.f4119c; i2++) {
            if (obj.equals(Double.valueOf(this.f4118b[i2]))) {
                double[] dArr = this.f4118b;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f4119c - i2) - 1);
                this.f4119c--;
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
        double[] dArr = this.f4118b;
        System.arraycopy(dArr, i3, dArr, i2, this.f4119c - i3);
        this.f4119c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        zzb(i2);
        double[] dArr = this.f4118b;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4119c;
    }

    @Override // c.c.a.b.f.e.z4
    public final /* synthetic */ z4<Double> zza(int i2) {
        if (i2 >= this.f4119c) {
            return new c4(Arrays.copyOf(this.f4118b, i2), this.f4119c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzb(int i2) {
        if (i2 < 0 || i2 >= this.f4119c) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
    }

    public final String zzc(int i2) {
        int i3 = this.f4119c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public c4(double[] dArr, int i2) {
        this.f4118b = dArr;
        this.f4119c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        zzb(i2);
        double[] dArr = this.f4118b;
        double d2 = dArr[i2];
        if (i2 < this.f4119c - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (r3 - i2) - 1);
        }
        this.f4119c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }
}
