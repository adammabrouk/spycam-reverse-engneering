package a.h.h;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static Method f1080a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f1081b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    f1081b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1080a = cls.getMethod("getScript", String.class);
                f1081b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            f1080a = null;
            f1081b = null;
            Log.w("ICUCompat", e3);
        }
    }

    public static String a(String str) {
        try {
            if (f1080a != null) {
                return (String) f1080a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    public static String b(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 < 21) {
            String a2 = a(locale);
            if (a2 != null) {
                return a(a2);
            }
            return null;
        }
        try {
            return ((Locale) f1081b.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
            return locale.getScript();
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
            return locale.getScript();
        }
    }

    public static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1081b != null) {
                return (String) f1081b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }
}
