package c.a.a.o;

import c.a.a.r.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DataLoadProviderRegistry.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final g f3396b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final Map<g, b<?, ?>> f3397a = new HashMap();

    public <T, Z> void a(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.f3397a.put(new g(cls, cls2), bVar);
    }

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        synchronized (f3396b) {
            f3396b.a(cls, cls2);
            bVar = (b) this.f3397a.get(f3396b);
        }
        return bVar == null ? d.g() : bVar;
    }
}
