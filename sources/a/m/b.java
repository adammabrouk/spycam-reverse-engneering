package a.m;

import a.m.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f1505c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a> f1506a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Boolean> f1507b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: a.m.b$b, reason: collision with other inner class name */
    public static final class C0041b {

        /* renamed from: a, reason: collision with root package name */
        public final int f1510a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f1511b;

        public C0041b(int i2, Method method) {
            this.f1510a = i2;
            this.f1511b = method;
            method.setAccessible(true);
        }

        public void a(i iVar, f.b bVar, Object obj) {
            try {
                int i2 = this.f1510a;
                if (i2 == 0) {
                    this.f1511b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1511b.invoke(obj, iVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f1511b.invoke(obj, iVar, bVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0041b)) {
                return false;
            }
            C0041b c0041b = (C0041b) obj;
            return this.f1510a == c0041b.f1510a && this.f1511b.getName().equals(c0041b.f1511b.getName());
        }

        public int hashCode() {
            return (this.f1510a * 31) + this.f1511b.getName().hashCode();
        }
    }

    public final Method[] a(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    public a b(Class<?> cls) {
        a aVar = this.f1506a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean c(Class<?> cls) {
        Boolean bool = this.f1507b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] a2 = a(cls);
        for (Method method : a2) {
            if (((p) method.getAnnotation(p.class)) != null) {
                a(cls, a2);
                return true;
            }
        }
        this.f1507b.put(cls, false);
        return false;
    }

    /* compiled from: ClassesInfoCache.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<f.b, List<C0041b>> f1508a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<C0041b, f.b> f1509b;

        public a(Map<C0041b, f.b> map) {
            this.f1509b = map;
            for (Map.Entry<C0041b, f.b> entry : map.entrySet()) {
                f.b value = entry.getValue();
                List<C0041b> list = this.f1508a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f1508a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public void a(i iVar, f.b bVar, Object obj) {
            a(this.f1508a.get(bVar), iVar, bVar, obj);
            a(this.f1508a.get(f.b.ON_ANY), iVar, bVar, obj);
        }

        public static void a(List<C0041b> list, i iVar, f.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(iVar, bVar, obj);
                }
            }
        }
    }

    public final void a(Map<C0041b, f.b> map, C0041b c0041b, f.b bVar, Class<?> cls) {
        f.b bVar2 = map.get(c0041b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0041b, bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0041b.f1511b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar2 + ", new value " + bVar);
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a b2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.f1509b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0041b, f.b> entry : b(cls2).f1509b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = a(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(i.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                f.b value = pVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(f.b.class)) {
                        if (value != f.b.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new C0041b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f1506a.put(cls, aVar);
        this.f1507b.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
