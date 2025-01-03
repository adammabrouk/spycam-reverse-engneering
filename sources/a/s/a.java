package a.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f1739a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f1740b;

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean b() {
        try {
            if (f1740b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return c();
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f1740b == null) {
                    f1739a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    f1740b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f1740b.invoke(null, Long.valueOf(f1739a))).booleanValue();
            } catch (Exception e2) {
                a("isTagEnabled", e2);
            }
        }
        return false;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a();
        }
    }

    public static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
