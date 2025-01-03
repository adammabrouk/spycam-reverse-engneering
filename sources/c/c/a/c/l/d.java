package c.c.a.c.l;

import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: DateStrings.java */
/* loaded from: classes.dex */
public class d {
    public static String a(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? p.a(locale).format(new Date(j)) : p.e(locale).format(new Date(j));
    }

    public static String b(long j) {
        return a(j, Locale.getDefault());
    }

    public static String c(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? p.f(locale).format(new Date(j)) : p.d(locale).format(new Date(j));
    }

    public static String d(long j) {
        return c(j, Locale.getDefault());
    }

    public static String e(long j) {
        return d(j, Locale.getDefault());
    }

    public static String b(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? p.b(locale).format(new Date(j)) : p.c(locale).format(new Date(j));
    }

    public static String d(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? p.g(locale).format(new Date(j)) : p.c(locale).format(new Date(j));
    }

    public static String a(long j) {
        return a(j, (SimpleDateFormat) null);
    }

    public static String c(long j) {
        return b(j, Locale.getDefault());
    }

    public static String a(long j, SimpleDateFormat simpleDateFormat) {
        Calendar d2 = p.d();
        Calendar f2 = p.f();
        f2.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (d2.get(1) == f2.get(1)) {
            return b(j);
        }
        return d(j);
    }

    public static a.h.i.d<String, String> a(Long l, Long l2) {
        return a(l, l2, null);
    }

    public static a.h.i.d<String, String> a(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return a.h.i.d.a(null, null);
        }
        if (l == null) {
            return a.h.i.d.a(null, a(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return a.h.i.d.a(a(l.longValue(), simpleDateFormat), null);
        }
        Calendar d2 = p.d();
        Calendar f2 = p.f();
        f2.setTimeInMillis(l.longValue());
        Calendar f3 = p.f();
        f3.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return a.h.i.d.a(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        if (f2.get(1) == f3.get(1)) {
            if (f2.get(1) == d2.get(1)) {
                return a.h.i.d.a(a(l.longValue(), Locale.getDefault()), a(l2.longValue(), Locale.getDefault()));
            }
            return a.h.i.d.a(a(l.longValue(), Locale.getDefault()), c(l2.longValue(), Locale.getDefault()));
        }
        return a.h.i.d.a(c(l.longValue(), Locale.getDefault()), c(l2.longValue(), Locale.getDefault()));
    }
}
