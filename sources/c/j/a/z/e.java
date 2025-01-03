package c.j.a.z;

import android.content.Context;

/* compiled from: NotifyUtil.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static a f6688a = null;

    /* renamed from: b, reason: collision with root package name */
    public static b f6689b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f6690c = "com.vivo.push.util.NotifyDataAdapter";

    /* renamed from: d, reason: collision with root package name */
    public static String f6691d = "com.vivo.push.util.NotifyLayoutAdapter";

    public static Object a(String str, Object obj) {
        Class<?> cls;
        Object obj2 = null;
        try {
            cls = Class.forName(str);
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (Exception unused2) {
            }
        }
        return obj2 == null ? obj : obj2;
    }

    public static b b(Context context) {
        c(context);
        return f6689b;
    }

    public static synchronized void c(Context context) {
        synchronized (e.class) {
            if (f6688a == null) {
                a aVar = (a) a(f6690c, new n());
                f6688a = aVar;
                aVar.a(context);
            }
            if (f6689b == null) {
                b bVar = (b) a(f6691d, new o());
                f6689b = bVar;
                bVar.a(context);
            }
        }
    }

    public static a a(Context context) {
        c(context);
        return f6688a;
    }
}
