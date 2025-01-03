package a.h.i;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a(Object obj, Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.equals(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
