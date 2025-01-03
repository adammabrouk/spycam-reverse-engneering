package c.c.a.b.f.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static UserManager f4316a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f4317b = !a();

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @TargetApi(24)
    public static boolean b(Context context) {
        boolean z;
        boolean z2 = true;
        int i2 = 1;
        while (true) {
            z = false;
            if (i2 > 2) {
                break;
            }
            if (f4316a == null) {
                f4316a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f4316a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
            } catch (NullPointerException e2) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e2);
                f4316a = null;
                i2++;
            }
        }
        z = z2;
        if (z) {
            f4316a = null;
        }
        return z;
    }

    @TargetApi(24)
    public static boolean c(Context context) {
        if (f4317b) {
            return true;
        }
        synchronized (n1.class) {
            if (f4317b) {
                return true;
            }
            boolean b2 = b(context);
            if (b2) {
                f4317b = b2;
            }
            return b2;
        }
    }

    public static boolean a(Context context) {
        return !a() || c(context);
    }
}
