package c.k.d;

import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public final class n9 {
    public static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
