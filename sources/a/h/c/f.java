package a.h.c;

import a.h.b.d.c;
import a.h.g.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
public class f extends j {

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?> f991b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f992c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f993d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f994e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f992c = constructor;
        f991b = cls;
        f993d = method2;
        f994e = method;
    }

    public static boolean a() {
        if (f993d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f993d != null;
    }

    public static Object b() {
        try {
            return f992c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f993d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f991b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f994e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // a.h.c.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        a.e.g gVar = new a.e.g();
        for (f.b bVar : bVarArr) {
            Uri c2 = bVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, c2);
                gVar.put(c2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, bVar.b(), bVar.d(), bVar.e())) {
                return null;
            }
        }
        Typeface a2 = a(b2);
        if (a2 == null) {
            return null;
        }
        return Typeface.create(a2, i2);
    }

    @Override // a.h.c.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0017c c0017c : bVar.a()) {
            ByteBuffer a2 = k.a(context, resources, c0017c.b());
            if (a2 == null || !a(b2, a2, c0017c.c(), c0017c.e(), c0017c.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
