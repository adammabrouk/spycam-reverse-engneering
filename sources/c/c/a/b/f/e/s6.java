package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class s6<E> extends e3<E> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final s6<Object> f4429d;

    /* renamed from: b, reason: collision with root package name */
    public E[] f4430b;

    /* renamed from: c, reason: collision with root package name */
    public int f4431c;

    static {
        s6<Object> s6Var = new s6<>(new Object[0], 0);
        f4429d = s6Var;
        s6Var.c();
    }

    public s6(E[] eArr, int i2) {
        this.f4430b = eArr;
        this.f4431c = i2;
    }

    public static <E> s6<E> d() {
        return (s6<E>) f4429d;
    }

    @Override // c.c.a.b.f.e.e3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        b();
        int i2 = this.f4431c;
        E[] eArr = this.f4430b;
        if (i2 == eArr.length) {
            this.f4430b = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f4430b;
        int i3 = this.f4431c;
        this.f4431c = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        zzb(i2);
        return this.f4430b[i2];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        b();
        zzb(i2);
        E[] eArr = this.f4430b;
        E e2 = eArr[i2];
        if (i2 < this.f4431c - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (r2 - i2) - 1);
        }
        this.f4431c--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        b();
        zzb(i2);
        E[] eArr = this.f4430b;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4431c;
    }

    @Override // c.c.a.b.f.e.z4
    public final /* synthetic */ z4 zza(int i2) {
        if (i2 >= this.f4431c) {
            return new s6(Arrays.copyOf(this.f4430b, i2), this.f4431c);
        }
        throw new IllegalArgumentException();
    }

    public final void zzb(int i2) {
        if (i2 < 0 || i2 >= this.f4431c) {
            throw new IndexOutOfBoundsException(zzc(i2));
        }
    }

    public final String zzc(int i2) {
        int i3 = this.f4431c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        b();
        if (i2 >= 0 && i2 <= (i3 = this.f4431c)) {
            E[] eArr = this.f4430b;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.f4430b, i2, eArr2, i2 + 1, this.f4431c - i2);
                this.f4430b = eArr2;
            }
            this.f4430b[i2] = e2;
            this.f4431c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzc(i2));
    }
}
