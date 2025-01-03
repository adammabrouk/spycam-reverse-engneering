package c.c.b.g;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<? super T>> f5835a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<n> f5836b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5837c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5838d;

    /* renamed from: e, reason: collision with root package name */
    public final g<T> f5839e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f5840f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Class<? super T>> f5841a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<n> f5842b;

        /* renamed from: c, reason: collision with root package name */
        public int f5843c;

        /* renamed from: d, reason: collision with root package name */
        public int f5844d;

        /* renamed from: e, reason: collision with root package name */
        public g<T> f5845e;

        /* renamed from: f, reason: collision with root package name */
        public Set<Class<?>> f5846f;

        public static /* synthetic */ b a(b bVar) {
            bVar.d();
            return bVar;
        }

        public d<T> b() {
            u.b(this.f5845e != null, "Missing required property: factory.");
            return new d<>(new HashSet(this.f5841a), new HashSet(this.f5842b), this.f5843c, this.f5844d, this.f5845e, this.f5846f);
        }

        public b<T> c() {
            a(2);
            return this;
        }

        public final b<T> d() {
            this.f5844d = 1;
            return this;
        }

        @SafeVarargs
        public b(Class<T> cls, Class<? super T>... clsArr) {
            this.f5841a = new HashSet();
            this.f5842b = new HashSet();
            this.f5843c = 0;
            this.f5844d = 0;
            this.f5846f = new HashSet();
            u.a(cls, "Null interface");
            this.f5841a.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                u.a(cls2, "Null interface");
            }
            Collections.addAll(this.f5841a, clsArr);
        }

        public b<T> a(n nVar) {
            u.a(nVar, "Null dependency");
            a(nVar.a());
            this.f5842b.add(nVar);
            return this;
        }

        public b<T> a() {
            a(1);
            return this;
        }

        public final b<T> a(int i2) {
            u.b(this.f5843c == 0, "Instantiation type has already been set.");
            this.f5843c = i2;
            return this;
        }

        public final void a(Class<?> cls) {
            u.a(!this.f5841a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> a(g<T> gVar) {
            u.a(gVar, "Null factory");
            this.f5845e = gVar;
            return this;
        }
    }

    public static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }

    public Set<n> a() {
        return this.f5836b;
    }

    public g<T> b() {
        return this.f5839e;
    }

    public Set<Class<? super T>> c() {
        return this.f5835a;
    }

    public Set<Class<?>> d() {
        return this.f5840f;
    }

    public boolean e() {
        return this.f5837c == 1;
    }

    public boolean f() {
        return this.f5837c == 2;
    }

    public boolean g() {
        return this.f5838d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f5835a.toArray()) + ">{" + this.f5837c + ", type=" + this.f5838d + ", deps=" + Arrays.toString(this.f5836b.toArray()) + "}";
    }

    public d(Set<Class<? super T>> set, Set<n> set2, int i2, int i3, g<T> gVar, Set<Class<?>> set3) {
        this.f5835a = Collections.unmodifiableSet(set);
        this.f5836b = Collections.unmodifiableSet(set2);
        this.f5837c = i2;
        this.f5838d = i3;
        this.f5839e = gVar;
        this.f5840f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    public static <T> b<T> b(Class<T> cls) {
        b<T> a2 = a(cls);
        b.a(a2);
        return a2;
    }

    @SafeVarargs
    public static <T> b<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    @SafeVarargs
    public static <T> d<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        b a2 = a(cls, clsArr);
        a2.a(c.c.b.g.b.a(t));
        return a2.b();
    }

    public static <T> d<T> a(T t, Class<T> cls) {
        b b2 = b(cls);
        b2.a(c.a(t));
        return b2.b();
    }
}
