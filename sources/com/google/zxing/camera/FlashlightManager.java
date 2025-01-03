package com.google.zxing.camera;

import android.os.IBinder;
import com.shix.shixipc.utils.MyLogUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class FlashlightManager {
    public static final String TAG = "FlashlightManager";
    public static final Object iHardwareService;
    public static final Method setFlashEnabledMethod;

    static {
        Object hardwareService = getHardwareService();
        iHardwareService = hardwareService;
        setFlashEnabledMethod = getSetFlashEnabledMethod(hardwareService);
        if (iHardwareService == null) {
            MyLogUtils.v(TAG, "This device does supports control of a flashlight");
        } else {
            MyLogUtils.v(TAG, "This device does not support control of a flashlight");
        }
    }

    public static void disableFlashlight() {
        setFlashlight(false);
    }

    public static void enableFlashlight() {
        setFlashlight(false);
    }

    public static Object getHardwareService() {
        Method maybeGetMethod;
        Object invoke;
        Class<?> maybeForName;
        Method maybeGetMethod2;
        Class<?> maybeForName2 = maybeForName("android.os.ServiceManager");
        if (maybeForName2 == null || (maybeGetMethod = maybeGetMethod(maybeForName2, "getService", String.class)) == null || (invoke = invoke(maybeGetMethod, null, "hardware")) == null || (maybeForName = maybeForName("android.os.IHardwareService$Stub")) == null || (maybeGetMethod2 = maybeGetMethod(maybeForName, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return invoke(maybeGetMethod2, null, invoke);
    }

    public static Method getSetFlashEnabledMethod(Object obj) {
        if (obj == null) {
            return null;
        }
        return maybeGetMethod(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    public static Object invoke(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            MyLogUtils.w(TAG, "Unexpected error while invoking " + method);
            return null;
        } catch (RuntimeException unused2) {
            MyLogUtils.w(TAG, "Unexpected error while invoking " + method);
            return null;
        } catch (InvocationTargetException unused3) {
            MyLogUtils.w(TAG, "Unexpected error while invoking " + method);
            return null;
        }
    }

    public static Class<?> maybeForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            MyLogUtils.w(TAG, "Unexpected error while finding class " + str);
            return null;
        }
    }

    public static Method maybeGetMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException unused2) {
            MyLogUtils.w(TAG, "Unexpected error while finding method " + str);
            return null;
        }
    }

    public static void setFlashlight(boolean z) {
        Object obj = iHardwareService;
        if (obj != null) {
            invoke(setFlashEnabledMethod, obj, Boolean.valueOf(z));
        }
    }
}
