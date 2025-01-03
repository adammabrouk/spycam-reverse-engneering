package c.c.b.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class l extends a {

    /* renamed from: e, reason: collision with root package name */
    public static final c.c.b.m.a<Set<Object>> f5854e = k.a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<d<?>, s<?>> f5855a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, s<?>> f5856b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, s<Set<?>>> f5857c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final r f5858d;

    public l(Executor executor, Iterable<h> iterable, d<?>... dVarArr) {
        this.f5858d = new r(executor);
        ArrayList<d<?>> arrayList = new ArrayList();
        arrayList.add(d.a(this.f5858d, r.class, c.c.b.j.d.class, c.c.b.j.c.class));
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        m.a(arrayList);
        for (d<?> dVar2 : arrayList) {
            this.f5855a.put(dVar2, new s<>(i.a(this, dVar2)));
        }
        a();
        b();
    }

    public final void b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<d<?>, s<?>> entry : this.f5855a.entrySet()) {
            d<?> key = entry.getKey();
            if (!key.g()) {
                s<?> value = entry.getValue();
                for (Class<? super Object> cls : key.c()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f5857c.put((Class) entry2.getKey(), new s<>(j.a((Set) entry2.getValue())));
        }
    }

    @Override // c.c.b.g.e
    public <T> c.c.b.m.a<T> c(Class<T> cls) {
        u.a(cls, "Null interface requested.");
        return this.f5856b.get(cls);
    }

    @Override // c.c.b.g.e
    public <T> c.c.b.m.a<Set<T>> d(Class<T> cls) {
        s<Set<?>> sVar = this.f5857c.get(cls);
        return sVar != null ? sVar : (c.c.b.m.a<Set<T>>) f5854e;
    }

    public final void a() {
        for (Map.Entry<d<?>, s<?>> entry : this.f5855a.entrySet()) {
            d<?> key = entry.getKey();
            if (key.g()) {
                s<?> value = entry.getValue();
                Iterator<Class<? super Object>> it = key.c().iterator();
                while (it.hasNext()) {
                    this.f5856b.put(it.next(), value);
                }
            }
        }
        c();
    }

    public final void c() {
        for (d<?> dVar : this.f5855a.keySet()) {
            for (n nVar : dVar.a()) {
                if (nVar.c() && !this.f5856b.containsKey(nVar.a())) {
                    throw new t(String.format("Unsatisfied dependency for component %s: %s", dVar, nVar.a()));
                }
            }
        }
    }

    public static /* synthetic */ Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((s) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void a(boolean z) {
        for (Map.Entry<d<?>, s<?>> entry : this.f5855a.entrySet()) {
            d<?> key = entry.getKey();
            s<?> value = entry.getValue();
            if (key.e() || (key.f() && z)) {
                value.get();
            }
        }
        this.f5858d.a();
    }
}
