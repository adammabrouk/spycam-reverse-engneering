package c.c.a.b.f.e;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class y6 extends e7 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x6 f4539b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y6(x6 x6Var) {
        super(x6Var, null);
        this.f4539b = x6Var;
    }

    @Override // c.c.a.b.f.e.e7, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new z6(this.f4539b, null);
    }

    public /* synthetic */ y6(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
