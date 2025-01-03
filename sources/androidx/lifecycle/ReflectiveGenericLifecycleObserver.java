package androidx.lifecycle;

import a.m.b;
import a.m.f;
import a.m.g;
import a.m.i;

/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2664a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f2665b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2664a = obj;
        this.f2665b = b.f1505c.b(obj.getClass());
    }

    @Override // a.m.g
    public void a(i iVar, f.b bVar) {
        this.f2665b.a(iVar, bVar, this.f2664a);
    }
}
