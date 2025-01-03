package c.g.a;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: PermissionX.java */
/* loaded from: classes.dex */
public class b {
    public static a a(FragmentActivity fragmentActivity) {
        return new a(fragmentActivity);
    }

    public static a a(Fragment fragment) {
        return new a(fragment);
    }

    public static boolean a(Context context, String str) {
        return a.h.b.a.a(context, str) == 0;
    }
}
