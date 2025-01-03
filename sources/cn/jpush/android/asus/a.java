package cn.jpush.android.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.e.c;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9315c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9316d;

    /* renamed from: a, reason: collision with root package name */
    public static final String f9313a = "asus".toLowerCase();

    /* renamed from: b, reason: collision with root package name */
    public static String f9314b = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f9317e = null;

    public static ActivityInfo a(Context context, String str, Class<? extends BroadcastReceiver> cls) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AsusPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 2);
        } catch (Throwable th) {
            Logger.ww("AsusPushHelper", "getReceiver error:" + th);
        }
        if (packageInfo.receivers != null && packageInfo.receivers.length != 0) {
            for (ActivityInfo activityInfo : packageInfo.receivers) {
                try {
                    if (cls.isAssignableFrom(Class.forName(activityInfo.name, false, cls.getClassLoader())) && activityInfo.enabled) {
                        return activityInfo;
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        Logger.d("AsusPushHelper", "pkgInfo info is null");
        return null;
    }

    public static boolean a() {
        boolean equalsIgnoreCase = "asus".equalsIgnoreCase(Build.BRAND);
        return !equalsIgnoreCase ? "asus".equalsIgnoreCase(Build.MANUFACTURER) : equalsIgnoreCase;
    }

    public static boolean a(Context context) {
        b(context);
        return f9315c;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f9316d) {
                return;
            }
            if (context == null) {
                Logger.ww("AsusPushHelper", "context is null");
                return;
            }
            if (i(context) && (cn.jpush.android.c.b.a(context) || a())) {
                f9315c = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f9315c ? "support " : "not support ");
            sb.append(f9313a);
            Logger.d("AsusPushHelper", sb.toString());
            f9316d = true;
        }
    }

    public static void c(final Context context) {
        try {
            b(context);
            if (f9315c) {
                cn.jpush.android.c.b.a(context, e(context), new c() { // from class: cn.jpush.android.asus.a.1
                    @Override // cn.jpush.android.e.a
                    public void a(cn.jpush.android.e.b bVar) {
                        try {
                            Logger.dd("AsusPushHelper", "tokenResult:" + bVar);
                            cn.jpush.android.bl.c.a().a(context, (byte) 6, bVar.a());
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("AsusPushHelper", "register error:" + th.getMessage());
        }
    }

    public static byte d(Context context) {
        return (byte) 6;
    }

    public static String e(Context context) {
        return !TextUtils.isEmpty(f9314b) ? f9314b : JCoreHelper.getAppKey(context);
    }

    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        return cn.jpush.android.c.b.d(context);
    }

    public static boolean h(Context context) {
        String str;
        String e2 = e(context);
        if (TextUtils.isEmpty(e2)) {
            str = f9313a + " appkey or appid is empty,need not clear plugin rid";
        } else {
            String appKey = JCoreHelper.getAppKey(context);
            if (!TextUtils.isEmpty(appKey)) {
                String str2 = (String) Sp.get(context, Key.ThirdPush_ClearFlag());
                String md5 = JThirdPlatFormInterface.toMD5(e2 + appKey + JCoreHelper.getJCoreSDKVersionInt() + JCoreHelper.getJPushSDKVersionInt());
                if (TextUtils.isEmpty(str2)) {
                    Sp.set(context, Key.ThirdPush_ClearFlag().set(md5));
                    return true;
                }
                if (TextUtils.isEmpty(md5)) {
                    return true;
                }
                if (TextUtils.equals(str2, md5)) {
                    return false;
                }
                Logger.d("AsusPushHelper", "local set changed,re bind token");
                Sp.set(context, Key.ThirdPush_ClearFlag().set(md5));
                return true;
            }
            str = "jpush appkey is empty,need not clear plugin rid";
        }
        Logger.ii("AsusPushHelper", str);
        return false;
    }

    public static boolean i(Context context) {
        ActivityInfo a2 = a(context, context.getPackageName(), AsusPushMessageReceiver.class);
        if (a2 == null) {
            Logger.ww("AsusPushHelper", "AndroidManifest.xml missing receiver extends asus's AsusPushMessageReceiver");
            return false;
        }
        Logger.d("AsusPushHelper", "found receiver:" + a2.name);
        return true;
    }
}
