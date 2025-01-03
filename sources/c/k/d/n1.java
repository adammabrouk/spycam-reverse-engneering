package c.k.d;

import android.os.Build;
import android.system.Os;
import java.io.File;

/* loaded from: classes.dex */
public class n1 {
    public static long a(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0L;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return 0L;
        }
    }
}
