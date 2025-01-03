package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import c.k.b.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class i4 {

    /* renamed from: a, reason: collision with root package name */
    public static a f7247a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, g7> f7248b;

    public interface a {
        void a(Context context, z6 z6Var);
    }

    public static int a(int i2) {
        if (i2 > 0) {
            return i2 + 1000;
        }
        return -1;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof v6) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof g7) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof n4) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static c.k.b.a.a a(Context context) {
        boolean a2 = c.k.d.p9.m.a(context).a(a7.PerfUploadSwitch.a(), false);
        boolean a3 = c.k.d.p9.m.a(context).a(a7.EventUploadNewSwitch.a(), false);
        int a4 = c.k.d.p9.m.a(context).a(a7.PerfUploadFrequency.a(), 86400);
        int a5 = c.k.d.p9.m.a(context).a(a7.EventUploadFrequency.a(), 86400);
        a.C0127a g2 = c.k.b.a.a.g();
        g2.b(a3);
        g2.a(a5);
        g2.c(a2);
        g2.c(a4);
        return g2.a(context);
    }

    public static c.k.b.a.b a(Context context, String str, String str2, int i2, long j, String str3) {
        c.k.b.a.b a2 = a(str);
        a2.f6765h = str2;
        a2.f6766i = i2;
        a2.j = j;
        a2.k = str3;
        return a2;
    }

    public static c.k.b.a.b a(String str) {
        c.k.b.a.b bVar = new c.k.b.a.b();
        bVar.f6769a = 1000;
        bVar.f6771c = 1001;
        bVar.f6770b = str;
        return bVar;
    }

    public static c.k.b.a.c a() {
        c.k.b.a.c cVar = new c.k.b.a.c();
        cVar.f6769a = 1000;
        cVar.f6771c = 1000;
        cVar.f6770b = "P100000";
        return cVar;
    }

    public static c.k.b.a.c a(Context context, int i2, long j, long j2) {
        c.k.b.a.c a2 = a();
        a2.f6767h = i2;
        a2.f6768i = j;
        a2.j = j2;
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static g7 m220a(String str) {
        if (f7248b == null) {
            synchronized (g7.class) {
                if (f7248b == null) {
                    f7248b = new HashMap();
                    for (g7 g7Var : g7.values()) {
                        f7248b.put(g7Var.f30a.toLowerCase(), g7Var);
                    }
                }
            }
        }
        g7 g7Var2 = f7248b.get(str.toLowerCase());
        return g7Var2 != null ? g7Var2 : g7.Invalid;
    }

    public static z6 a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        z6 z6Var = new z6();
        z6Var.d("category_client_report_data");
        z6Var.a("push_sdk_channel");
        z6Var.a(1L);
        z6Var.b(str);
        z6Var.a(true);
        z6Var.b(System.currentTimeMillis());
        z6Var.g(context.getPackageName());
        z6Var.e("com.xiaomi.xmsf");
        z6Var.f(c.k.d.p9.l0.a());
        z6Var.c("quality_support");
        return z6Var;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m221a(int i2) {
        return i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m222a(Context context) {
        c.k.b.b.a.a(context, a(context));
    }

    public static void a(Context context, c.k.b.a.a aVar) {
        c.k.b.b.a.a(context, aVar, new g4(context), new h4(context));
    }

    public static void a(Context context, z6 z6Var) {
        if (m223a(context.getApplicationContext())) {
            c.k.d.p9.m0.a(context.getApplicationContext(), z6Var);
            return;
        }
        a aVar = f7247a;
        if (aVar != null) {
            aVar.a(context, z6Var);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                z6 a2 = a(context, it.next());
                if (!c.k.d.p9.l0.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            c.k.a.a.a.c.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        f7247a = aVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m223a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
