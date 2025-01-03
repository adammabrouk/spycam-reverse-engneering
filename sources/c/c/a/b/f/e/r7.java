package c.c.a.b.f.e;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class r7 implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator<String> f4403a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p7 f4404b;

    public r7(p7 p7Var) {
        k5 k5Var;
        this.f4404b = p7Var;
        k5Var = this.f4404b.f4360a;
        this.f4403a = k5Var.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4403a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4403a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
