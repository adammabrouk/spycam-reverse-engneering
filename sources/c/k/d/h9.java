package c.k.d;

import android.content.Context;

/* loaded from: classes.dex */
public class h9 {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
