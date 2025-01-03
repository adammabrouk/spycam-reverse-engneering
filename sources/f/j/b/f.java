package f.j.b;

import java.util.Arrays;

/* compiled from: Intrinsics.java */
/* loaded from: classes.dex */
public class f {
    public static String a(String str, Object obj) {
        return str + obj;
    }

    public static void b() {
        f.a aVar = new f.a();
        a(aVar);
        throw aVar;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        c(str);
        throw null;
    }

    public static void d(String str) {
        f.g gVar = new f.g(str);
        a(gVar);
        throw gVar;
    }

    public static void e(String str) {
        d("lateinit property " + str + " has not been initialized");
        throw null;
    }

    public static void a(Object obj) {
        if (obj != null) {
            return;
        }
        a();
        throw null;
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
        a(nullPointerException);
        throw nullPointerException;
    }

    public static void c(String str) {
        NullPointerException nullPointerException = new NullPointerException(a(str));
        a(nullPointerException);
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        b(str);
        throw null;
    }

    public static void a() {
        NullPointerException nullPointerException = new NullPointerException();
        a(nullPointerException);
        throw nullPointerException;
    }

    public static void b(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(a(str));
        a(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        a(illegalStateException);
        throw illegalStateException;
    }

    public static String a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static <T extends Throwable> T a(T t) {
        a((Throwable) t, f.class.getName());
        return t;
    }

    public static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }
}
