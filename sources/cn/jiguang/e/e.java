package cn.jiguang.e;

import android.app.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e {
    public static Application a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(b(), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Object[] objArr, Class[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }

    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        a(obj);
        a(clsArr, objArr);
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    public static void a(Class<?>[] clsArr, Object[] objArr) {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }

    public static Object b() {
        Object d2 = d();
        return d2 != null ? d2 : e();
    }

    public static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReflectUtils", "getCurrentProcessNameByActivityThread: " + th.getMessage());
            return null;
        }
    }

    public static Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReflectUtils", "getActivityThreadInActivityThreadStaticField: " + th.getMessage());
            return null;
        }
    }

    public static Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReflectUtils", "getActivityThreadInActivityThreadStaticMethod: " + th.getMessage());
            return null;
        }
    }
}
