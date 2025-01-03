package c.c.a.b.c.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f4018a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f4019b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f4020c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f4021d;

    static {
        Process.myUid();
        f4018a = e();
        f4019b = f();
        f4020c = g();
        a();
        f4021d = b();
        c();
        d();
    }

    public static WorkSource a(int i2, String str) {
        WorkSource workSource = new WorkSource();
        a(workSource, i2, str);
        return workSource;
    }

    public static int b(WorkSource workSource) {
        Method method = f4020c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    public static final Method c() {
        if (n.j()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    public static final Method d() {
        if (n.j()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }

    public static Method e() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Method f() {
        if (n.d()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Method g() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static WorkSource a(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo a2 = c.c.a.b.c.t.c.b(context).a(str, 0);
                if (a2 == null) {
                    String valueOf = String.valueOf(str);
                    Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                return a(a2.uid, str);
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    public static Method b() {
        if (n.d()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void a(WorkSource workSource, int i2, String str) {
        if (f4019b != null) {
            if (str == null) {
                str = "";
            }
            try {
                f4019b.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method = f4018a;
        if (method != null) {
            try {
                method.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    public static String a(WorkSource workSource, int i2) {
        Method method = f4021d;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    public static List<String> a(WorkSource workSource) {
        int b2 = workSource == null ? 0 : b(workSource);
        if (b2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < b2; i2++) {
            String a2 = a(workSource, i2);
            if (!p.a(a2)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        return (context == null || context.getPackageManager() == null || c.c.a.b.c.t.c.b(context).a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    public static Method a() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }
}
