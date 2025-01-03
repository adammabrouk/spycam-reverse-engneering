package c.c.a.b.f.e;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class p7 extends AbstractList<String> implements k5, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final k5 f4360a;

    public p7(k5 k5Var) {
        this.f4360a = k5Var;
    }

    @Override // c.c.a.b.f.e.k5
    public final k5 a() {
        return this;
    }

    @Override // c.c.a.b.f.e.k5
    public final void a(k3 k3Var) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.f4360a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new r7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new o7(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4360a.size();
    }

    @Override // c.c.a.b.f.e.k5
    public final Object zzb(int i2) {
        return this.f4360a.zzb(i2);
    }

    @Override // c.c.a.b.f.e.k5
    public final List<?> zzb() {
        return this.f4360a.zzb();
    }
}
