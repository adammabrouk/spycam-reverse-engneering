package c.a.a.l.k.j;

import c.a.a.r.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final g f3359b = new g();

    /* renamed from: a, reason: collision with root package name */
    public final Map<g, c<?, ?>> f3360a = new HashMap();

    public <Z, R> void a(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
        this.f3360a.put(new g(cls, cls2), cVar);
    }

    public <Z, R> c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        c<Z, R> cVar;
        if (cls.equals(cls2)) {
            return e.a();
        }
        synchronized (f3359b) {
            f3359b.a(cls, cls2);
            cVar = (c) this.f3360a.get(f3359b);
        }
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }
}
