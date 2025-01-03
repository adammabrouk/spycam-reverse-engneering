package a.m;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Class<?>, Integer> f1525a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<Class<?>, List<Constructor<? extends d>>> f1526b = new HashMap();

    public static g a(Object obj) {
        boolean z = obj instanceof g;
        boolean z2 = obj instanceof c;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((c) obj, (g) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((c) obj, null);
        }
        if (z) {
            return (g) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends d>> list = f1526b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        d[] dVarArr = new d[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            dVarArr[i2] = a(list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(dVarArr);
    }

    public static int b(Class<?> cls) {
        Integer num = f1525a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int d2 = d(cls);
        f1525a.put(cls, Integer.valueOf(d2));
        return d2;
    }

    public static boolean c(Class<?> cls) {
        return cls != null && h.class.isAssignableFrom(cls);
    }

    public static int d(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends d> a2 = a(cls);
        if (a2 != null) {
            f1526b.put(cls, Collections.singletonList(a2));
            return 2;
        }
        if (b.f1505c.c(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (c(superclass)) {
            if (b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f1526b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (c(cls2)) {
                if (b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f1526b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f1526b.put(cls, arrayList);
        return 2;
    }

    public static d a(Constructor<? extends d> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Constructor<? extends d> a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor declaredConstructor = Class.forName(a2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
