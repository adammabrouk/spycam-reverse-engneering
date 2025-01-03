package c.c.a.b.c.s;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public final class g {
    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    public static boolean a(Context context, Throwable th, int i2) {
        try {
            c.c.a.b.c.o.r.a(context);
            c.c.a.b.c.o.r.a(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
