package c.k.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class b1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f6809a = -1;

    public static a0 a(Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), RecyclerView.c0.FLAG_IGNORE) == null || !a()) ? a0.OTHER : a0.HUAWEI;
        } catch (Exception unused) {
            return a0.OTHER;
        }
    }

    public static boolean a() {
        try {
            String str = (String) c.k.d.f0.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m18a(Context context) {
        Object a2 = c.k.d.f0.a(c.k.d.f0.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a3 = c.k.d.f0.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (a3 == null || !(a3 instanceof Integer)) {
            c.k.a.a.a.c.c("google service is not avaliable");
            f6809a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(a3)).intValue();
        if (a2 != null) {
            if (a2 instanceof Integer) {
                f6809a = ((Integer) Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
            } else {
                f6809a = 0;
                c.k.a.a.a.c.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(f6809a > 0);
        c.k.a.a.a.c.c(sb.toString());
        return f6809a > 0;
    }

    public static boolean b(Context context) {
        boolean z = false;
        Object a2 = c.k.d.f0.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        c.k.a.a.a.c.c("color os push  is avaliable ? :" + z);
        return z;
    }

    public static boolean c(Context context) {
        boolean z = false;
        Object a2 = c.k.d.f0.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        c.k.a.a.a.c.c("fun touch os push  is avaliable ? :" + z);
        return z;
    }
}
