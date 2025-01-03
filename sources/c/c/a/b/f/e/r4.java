package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class r4 extends e3<Float> implements z4<Float>, q6, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public float[] f4394b;

    /* renamed from: c, reason: collision with root package name */
    public int f4395c;

    static {
        new r4(new float[0], 0).c();
    }

    public r4() {
        this(new float[10], 0);
    }

    public final void a(float f2) {
        b();
        int i2 = this.f4395c;
        float[] fArr = this.f4394b;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f4394b = fArr2;
        }
        float[] fArr3 = this.f4394b;
        int i3 = this.f4395c;
        this.f4395c = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        b();
        if (i2 < 0 || i2 > (i3 = this.f4395c)) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
        float[] fArr = this.f4394b;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f4394b, i2, fArr2, i2 + 1, this.f4395c - i2);
            this.f4394b = fArr2;
        }
        this.f4394b[i2] = floatValue;
        this.f4395c++;
        ((AbstractList) this).modCount++;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        u4.a(collection);
        if (!(collection instanceof r4)) {
            return super.addAll(collection);
        }
        r4 r4Var = (r4) collection;
        int i2 = r4Var.f4395c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4395c;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f4394b;
        if (i4 > fArr.length) {
            this.f4394b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(r4Var.f4394b, 0, this.f4394b, this.f4395c, r4Var.f4395c);
        this.f4395c = i4;
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
        if (!(obj instanceof r4)) {
            return super.equals(obj);
        }
        r4 r4Var = (r4) obj;
        if (this.f4395c != r4Var.f4395c) {
            return false;
        }
        float[] fArr = r4Var.f4394b;
        for (int i2 = 0; i2 < this.f4395c; i2++) {
            if (Float.floatToIntBits(this.f4394b[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzb(i2);
        return Float.valueOf(this.f4394b[i2]);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4395c; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f4394b[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f4394b[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.f4395c; i2++) {
            if (obj.equals(Float.valueOf(this.f4394b[i2]))) {
                float[] fArr = this.f4394b;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f4395c - i2) - 1);
                this.f4395c--;
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
        float[] fArr = this.f4394b;
        System.arraycopy(fArr, i3, fArr, i2, this.f4395c - i3);
        this.f4395c -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        zzb(i2);
        float[] fArr = this.f4394b;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4395c;
    }

    @Override // c.c.a.b.f.e.z4
    public final /* synthetic */ z4<Float> zza(int i2) {
        if (i2 >= this.f4395c) {
            return new r4(Arrays.copyOf(this.f4394b, i2), this.f4395c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzb(int i2) {
        if (i2 < 0 || i2 >= this.f4395c) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
    }

    public final String zzc(int i2) {
        int i3 = this.f4395c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public r4(float[] fArr, int i2) {
        this.f4394b = fArr;
        this.f4395c = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        b();
        zzb(i2);
        float[] fArr = this.f4394b;
        float f2 = fArr[i2];
        if (i2 < this.f4395c - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (r2 - i2) - 1);
        }
        this.f4395c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }
}
