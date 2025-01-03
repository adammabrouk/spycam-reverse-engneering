package c.a.a.l.j;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: GenericLoaderFactory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static final l f3183d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class, Map<Class, m>> f3184a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class, Map<Class, l>> f3185b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Context f3186c;

    /* compiled from: GenericLoaderFactory.java */
    public static class a implements l {
        @Override // c.a.a.l.j.l
        public c.a.a.l.h.c a(Object obj, int i2, int i3) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public c(Context context) {
        this.f3186c = context.getApplicationContext();
    }

    public synchronized <T, Y> m<T, Y> a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> put;
        this.f3185b.clear();
        Map<Class, m> map = this.f3184a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f3184a.put(cls, map);
        }
        put = map.put(cls2, mVar);
        if (put != null) {
            Iterator<Map<Class, m>> it = this.f3184a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().containsValue(put)) {
                    put = null;
                    break;
                }
            }
        }
        return put;
    }

    public final <T, Y> void b(Class<T> cls, Class<Y> cls2) {
        a(cls, cls2, f3183d);
    }

    public final <T, Y> l<T, Y> c(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.f3185b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    public final <T, Y> m<T, Y> d(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        Map<Class, m> map2 = this.f3184a.get(cls);
        m mVar = map2 != null ? map2.get(cls2) : null;
        if (mVar == null) {
            for (Class cls3 : this.f3184a.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.f3184a.get(cls3)) != null && (mVar = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return mVar;
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> c2 = c(cls, cls2);
        if (c2 != null) {
            if (f3183d.equals(c2)) {
                return null;
            }
            return c2;
        }
        m<T, Y> d2 = d(cls, cls2);
        if (d2 != null) {
            c2 = d2.a(this.f3186c, this);
            a(cls, cls2, c2);
        } else {
            b(cls, cls2);
        }
        return c2;
    }

    public final <T, Y> void a(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.f3185b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f3185b.put(cls, map);
        }
        map.put(cls2, lVar);
    }
}
