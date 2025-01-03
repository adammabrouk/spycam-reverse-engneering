package cn.jiguang.ar;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f8340a = "cn.jiguang.joperate.jcore_report";

    public static String a(Context context) {
        return a(context, "report_cache.l", null);
    }

    public static synchronized String a(Context context, String str, String str2) {
        String d2;
        boolean isEmpty;
        synchronized (d.class) {
            d2 = cn.jiguang.e.c.d(g(context, str));
            isEmpty = TextUtils.isEmpty(d2);
        }
        return isEmpty ? str2 : d2;
    }

    public static void a(Context context, String str) {
        b(context, "report_cache.l", str);
    }

    public static String b(Context context) {
        return a(context, "old_report_cache.l", null);
    }

    public static void b(Context context, String str) {
        c(context, "report_cache.l", str);
    }

    public static synchronized void b(Context context, String str, String str2) {
        synchronized (d.class) {
            File g2 = g(context, str);
            if (str2 == null) {
                str2 = "";
            }
            cn.jiguang.e.c.c(g2, str2);
        }
    }

    public static String c(Context context) {
        return a(context, "reserved_events_cache.l", null);
    }

    public static void c(Context context, String str) {
        b(context, "old_report_cache.l", str);
    }

    public static synchronized void c(Context context, String str, String str2) {
        synchronized (d.class) {
            File g2 = g(context, str);
            if (str2 == null) {
                return;
            }
            cn.jiguang.e.c.b(g2, str2);
        }
    }

    public static String d(Context context) {
        return a(context, "user_properties_cache.l", null);
    }

    public static void d(Context context, String str) {
        c(context, "old_report_cache.l", str);
    }

    public static void e(Context context, String str) {
        b(context, "reserved_events_cache.l", str);
    }

    public static void f(Context context, String str) {
        b(context, "user_properties_cache.l", str);
    }

    public static File g(Context context, String str) {
        File file = new File(context.getFilesDir().getPath() + "/" + f8340a, str);
        if (file.getParentFile().exists()) {
            if (file.getParentFile().isFile()) {
                file.getParentFile().delete();
            } else if (file.isDirectory()) {
                file.delete();
            }
        }
        return file;
    }
}
