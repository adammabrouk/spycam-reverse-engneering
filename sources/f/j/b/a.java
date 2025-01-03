package f.j.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* compiled from: ArrayIterator.kt */
/* loaded from: classes.dex */
public final class a<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public int f11323a;

    /* renamed from: b, reason: collision with root package name */
    public final T[] f11324b;

    public a(T[] tArr) {
        f.c(tArr, "array");
        this.f11324b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11323a < this.f11324b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f11324b;
            int i2 = this.f11323a;
            this.f11323a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f11323a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
