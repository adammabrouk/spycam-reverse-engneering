package c.c.a.b.f.e;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class o7 implements ListIterator<String> {

    /* renamed from: a, reason: collision with root package name */
    public ListIterator<String> f4344a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4345b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p7 f4346c;

    public o7(p7 p7Var, int i2) {
        k5 k5Var;
        this.f4346c = p7Var;
        this.f4345b = i2;
        k5Var = this.f4346c.f4360a;
        this.f4344a = k5Var.listIterator(this.f4345b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f4344a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4344a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f4344a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4344a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f4344a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4344a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
