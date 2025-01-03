package c.c.b.g;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class v extends c.c.b.g.a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<?>> f5875a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f5876b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Class<?>> f5877c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f5878d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f5879e;

    /* renamed from: f, reason: collision with root package name */
    public final e f5880f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class a implements c.c.b.j.c {
        public a(Set<Class<?>> set, c.c.b.j.c cVar) {
        }
    }

    public v(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n nVar : dVar.a()) {
            if (nVar.b()) {
                if (nVar.d()) {
                    hashSet3.add(nVar.a());
                } else {
                    hashSet.add(nVar.a());
                }
            } else if (nVar.d()) {
                hashSet4.add(nVar.a());
            } else {
                hashSet2.add(nVar.a());
            }
        }
        if (!dVar.d().isEmpty()) {
            hashSet.add(c.c.b.j.c.class);
        }
        this.f5875a = Collections.unmodifiableSet(hashSet);
        this.f5876b = Collections.unmodifiableSet(hashSet2);
        this.f5877c = Collections.unmodifiableSet(hashSet3);
        this.f5878d = Collections.unmodifiableSet(hashSet4);
        this.f5879e = dVar.d();
        this.f5880f = eVar;
    }

    @Override // c.c.b.g.a, c.c.b.g.e
    public <T> T a(Class<T> cls) {
        if (!this.f5875a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f5880f.a(cls);
        return !cls.equals(c.c.b.j.c.class) ? t : (T) new a(this.f5879e, (c.c.b.j.c) t);
    }

    @Override // c.c.b.g.a, c.c.b.g.e
    public <T> Set<T> b(Class<T> cls) {
        if (this.f5877c.contains(cls)) {
            return this.f5880f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // c.c.b.g.e
    public <T> c.c.b.m.a<T> c(Class<T> cls) {
        if (this.f5876b.contains(cls)) {
            return this.f5880f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // c.c.b.g.e
    public <T> c.c.b.m.a<Set<T>> d(Class<T> cls) {
        if (this.f5878d.contains(cls)) {
            return this.f5880f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
