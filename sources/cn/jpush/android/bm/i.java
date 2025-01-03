package cn.jpush.android.bm;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2;
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new IllegalArgumentException("argClasses' size is not equal to args' size");
        }
        Method method = obj.getClass().getMethod(str, clsArr);
        boolean isAccessible = method.isAccessible();
        if (!isAccessible) {
            method.setAccessible(true);
        }
        Exception exc = null;
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (Exception e2) {
            exc = e2;
            obj2 = null;
        }
        if (!isAccessible) {
            method.setAccessible(false);
        }
        if (exc == null) {
            return obj2;
        }
        throw exc;
    }
}
