package a.h.c;

import a.h.b.d.c;
import a.h.g.f;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: g, reason: collision with root package name */
    public final Class<?> f995g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor<?> f996h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f997i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> d2 = d();
            constructor = e(d2);
            method2 = b(d2);
            method3 = c(d2);
            method4 = f(d2);
            method5 = a(d2);
            method = d(d2);
            cls = d2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f995g = cls;
        this.f996h = constructor;
        this.f997i = method2;
        this.j = method3;
        this.k = method4;
        this.l = method5;
        this.m = method;
    }

    private Object b() {
        try {
            return this.f996h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f997i.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean c() {
        if (this.f997i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f997i != null;
    }

    public Class<?> d() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> e(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    public Method f(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    public final void b(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public Method d(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Method b(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean c(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method c(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f995g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // a.h.c.e, a.h.c.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        if (!c()) {
            return super.a(context, bVar, resources, i2);
        }
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0017c c0017c : bVar.a()) {
            if (!a(context, b2, c0017c.a(), c0017c.c(), c0017c.e(), c0017c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0017c.d()))) {
                b(b2);
                return null;
            }
        }
        if (c(b2)) {
            return a(b2);
        }
        return null;
    }

    @Override // a.h.c.e, a.h.c.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        Typeface a2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!c()) {
            f.b a3 = a(bVarArr, i2);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a3.c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a3.d()).setItalic(a3.e()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a4 = k.a(context, bVarArr, cancellationSignal);
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        boolean z = false;
        for (f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = a4.get(bVar.c());
            if (byteBuffer != null) {
                if (!a(b2, byteBuffer, bVar.b(), bVar.d(), bVar.e() ? 1 : 0)) {
                    b(b2);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            b(b2);
            return null;
        }
        if (c(b2) && (a2 = a(b2)) != null) {
            return Typeface.create(a2, i2);
        }
        return null;
    }

    @Override // a.h.c.j
    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!c()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (!a(context, b2, str, 0, -1, -1, null)) {
            b(b2);
            return null;
        }
        if (c(b2)) {
            return a(b2);
        }
        return null;
    }

    public Method a(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
