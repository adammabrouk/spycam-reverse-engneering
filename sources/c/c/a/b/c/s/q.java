package c.c.a.b.c.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* loaded from: classes.dex */
public final class q {
    public static boolean a(Context context, int i2) {
        if (!a(context, i2, "com.google.android.gms")) {
            return false;
        }
        try {
            return c.c.a.b.c.i.a(context).a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i2, String str) {
        return c.c.a.b.c.t.c.b(context).a(i2, str);
    }
}
