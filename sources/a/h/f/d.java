package a.h.f;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* compiled from: UserManagerCompat.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }
}
