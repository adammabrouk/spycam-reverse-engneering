package c.a.a;

import android.content.Context;
import c.a.a.h;
import c.a.a.l.j.l;
import c.a.a.m.m;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* compiled from: GenericTranscodeRequest.java */
/* loaded from: classes.dex */
public class d<ModelType, DataType, ResourceType> extends c<ModelType, DataType, ResourceType, ResourceType> {
    public d(Context context, e eVar, Class<ModelType> cls, l<ModelType, DataType> lVar, Class<DataType> cls2, Class<ResourceType> cls3, m mVar, c.a.a.m.g gVar, h.d dVar) {
        super(context, cls, a(eVar, lVar, cls2, cls3, c.a.a.l.k.j.e.a()), cls3, eVar, mVar, gVar);
    }

    public static <A, T, Z, R> c.a.a.o.f<A, T, Z, R> a(e eVar, l<A, T> lVar, Class<T> cls, Class<Z> cls2, c.a.a.l.k.j.c<Z, R> cVar) {
        return new c.a.a.o.e(lVar, cVar, eVar.a(cls, cls2));
    }
}
