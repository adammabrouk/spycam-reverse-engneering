package a.h.c;

import a.h.b.d.c;
import a.h.g.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
public class e extends j {

    /* renamed from: b, reason: collision with root package name */
    public static Class<?> f986b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Constructor<?> f987c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f988d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Method f989e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f990f = false;

    public static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f990f) {
            return;
        }
        f990f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f987c = constructor;
        f986b = cls;
        f988d = method2;
        f989e = method;
    }

    public static Object b() {
        a();
        try {
            return f987c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    public static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f986b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f989e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(Object obj, String str, int i2, boolean z) {
        a();
        try {
            return ((Boolean) f988d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // a.h.c.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        if (bVarArr.length < 1) {
            return null;
        }
        f.b a2 = a(bVarArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File a3 = a(openFileDescriptor);
                if (a3 != null && a3.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(a3);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface a4 = super.a(context, fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return a4;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // a.h.c.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        for (c.C0017c c0017c : bVar.a()) {
            File a2 = k.a(context);
            if (a2 == null) {
                return null;
            }
            try {
                if (!k.a(a2, resources, c0017c.b())) {
                    return null;
                }
                if (!a(b2, a2.getPath(), c0017c.e(), c0017c.f())) {
                    return null;
                }
                a2.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a2.delete();
            }
        }
        return a(b2);
    }
}
