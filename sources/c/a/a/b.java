package c.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import c.a.a.h;
import c.a.a.l.j.l;
import c.a.a.m.m;
import java.io.InputStream;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* compiled from: DrawableTypeRequest.java */
/* loaded from: classes.dex */
public class b<ModelType> extends a<ModelType> {
    public b(Class<ModelType> cls, l<ModelType, InputStream> lVar, l<ModelType, ParcelFileDescriptor> lVar2, Context context, e eVar, m mVar, c.a.a.m.g gVar, h.d dVar) {
        super(context, cls, a(eVar, lVar, lVar2, c.a.a.l.k.i.a.class, c.a.a.l.k.f.b.class, null), eVar, mVar, gVar);
    }

    public static <A, Z, R> c.a.a.o.e<A, c.a.a.l.j.g, Z, R> a(e eVar, l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2, Class<Z> cls, Class<R> cls2, c.a.a.l.k.j.c<Z, R> cVar) {
        if (lVar == null && lVar2 == null) {
            return null;
        }
        if (cVar == null) {
            cVar = eVar.b(cls, cls2);
        }
        return new c.a.a.o.e<>(new c.a.a.l.j.f(lVar, lVar2), cVar, eVar.a(c.a.a.l.j.g.class, cls));
    }
}
