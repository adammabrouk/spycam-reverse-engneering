package c.c.a.b.c.t;

import android.content.Context;
import c.c.a.b.c.s.n;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f4029a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f4030b;

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            if (f4029a != null && f4030b != null && f4029a == applicationContext) {
                return f4030b.booleanValue();
            }
            f4030b = null;
            if (n.i()) {
                f4030b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f4030b = true;
                } catch (ClassNotFoundException unused) {
                    f4030b = false;
                }
            }
            f4029a = applicationContext;
            return f4030b.booleanValue();
        }
    }
}
