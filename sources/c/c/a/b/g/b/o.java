package c.c.a.b.g.b;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzal;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o implements Iterator<String> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator<String> f4961a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzal f4962b;

    public o(zzal zzalVar) {
        Bundle bundle;
        this.f4962b = zzalVar;
        bundle = this.f4962b.f10206a;
        this.f4961a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4961a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f4961a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
