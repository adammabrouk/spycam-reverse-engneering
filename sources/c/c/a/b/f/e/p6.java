package c.c.a.b.f.e;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class p6 {

    /* renamed from: c, reason: collision with root package name */
    public static final p6 f4357c = new p6();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, t6<?>> f4359b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final v6 f4358a = new q5();

    public static p6 a() {
        return f4357c;
    }

    public final <T> t6<T> a(Class<T> cls) {
        u4.a(cls, "messageType");
        t6<T> t6Var = (t6) this.f4359b.get(cls);
        if (t6Var != null) {
            return t6Var;
        }
        t6<T> a2 = this.f4358a.a(cls);
        u4.a(cls, "messageType");
        u4.a(a2, "schema");
        t6<T> t6Var2 = (t6) this.f4359b.putIfAbsent(cls, a2);
        return t6Var2 != null ? t6Var2 : a2;
    }

    public final <T> t6<T> a(T t) {
        return a((Class) t.getClass());
    }
}
