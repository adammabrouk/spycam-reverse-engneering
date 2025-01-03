package a.b.a;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static Field f167a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f168b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f169c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f170d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f171e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f172f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f173g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f174h;

    public static void a(Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else if (i2 >= 21) {
            b(resources);
        }
    }

    public static void b(Resources resources) {
        if (!f168b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f167a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f168b = true;
        }
        Field field = f167a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void c(Resources resources) {
        if (!f168b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f167a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f168b = true;
        }
        Object obj = null;
        Field field = f167a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        a(obj);
    }

    public static void d(Resources resources) {
        Object obj;
        if (!f174h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f173g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f174h = true;
        }
        Field field = f173g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f168b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f167a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f168b = true;
        }
        Field field2 = f167a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            a(obj2);
        }
    }

    public static void a(Object obj) {
        if (!f170d) {
            try {
                f169c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f170d = true;
        }
        Class<?> cls = f169c;
        if (cls == null) {
            return;
        }
        if (!f172f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f171e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f172f = true;
        }
        Field field = f171e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
