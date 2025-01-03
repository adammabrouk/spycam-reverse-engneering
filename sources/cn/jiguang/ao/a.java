package cn.jiguang.ao;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8242a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f8243b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f8244c;

    /* renamed from: d, reason: collision with root package name */
    public static Pair<String, Long> f8245d;

    /* renamed from: e, reason: collision with root package name */
    public static final ArrayList<String> f8246e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static final ArrayList<String> f8247f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayList<String> f8248g;

    static {
        f8246e.add("android.permission.INTERNET");
        f8246e.add("android.permission.ACCESS_NETWORK_STATE");
        f8248g = new ArrayList<>();
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : b(packageInfo);
    }

    public static String a(Context context) {
        try {
            if (f8244c == null && !TextUtils.isEmpty(JConstants.APP_KEY)) {
                return JConstants.APP_KEY;
            }
        } catch (Throwable unused) {
            f8244c = false;
        }
        b(context);
        return f8242a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static void a(Context context, String str) {
        f8243b = str;
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.n().a((cn.jiguang.f.a<String>) str)});
        c(context);
    }

    public static long b(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    public static String b(Context context) {
        String str;
        if (!TextUtils.isEmpty(f8242a)) {
            return f8242a;
        }
        if (TextUtils.isEmpty(f8242a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE);
                    if (applicationInfo == null || applicationInfo.metaData == null) {
                        str = "";
                    } else {
                        str = a(applicationInfo.metaData, "JPUSH_APPKEY");
                        if (!TextUtils.isEmpty(str)) {
                            str = str.toLowerCase(Locale.getDefault());
                        }
                    }
                    if (!TextUtils.isEmpty("") && !TextUtils.isEmpty(str)) {
                        String lowerCase = "".toLowerCase(Locale.getDefault());
                        if (!lowerCase.contains(str)) {
                            cn.jiguang.as.d.d("CheckManifestHelper", "appkey " + str + " not in limitAppkeys:" + lowerCase);
                        }
                    }
                    f8242a = str;
                } else {
                    cn.jiguang.as.d.c("CheckManifestHelper", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f8242a;
    }

    public static String c(Context context) {
        StringBuilder sb;
        if (f8243b == null && context != null) {
            try {
                String c2 = cn.jiguang.d.a.c(context);
                f8243b = c2;
                if (c2 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(f8243b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE);
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        String a2 = a(applicationInfo.metaData, "JPUSH_CHANNEL");
                        f8243b = a2;
                        if (!TextUtils.isEmpty(a2)) {
                            f8243b = cn.jiguang.e.f.b(f8243b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(f8243b);
                }
                cn.jiguang.as.d.d("CheckManifestHelper", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f8243b;
    }

    public static Pair<String, Long> d(Context context) {
        if (f8245d == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                byte[] bytes = str.getBytes("UTF-8");
                if (bytes.length > 30) {
                    str = new String(bytes, 0, 30);
                }
                f8245d = new Pair<>(str, Long.valueOf(a(packageInfo)));
            } catch (Throwable unused) {
                cn.jiguang.as.d.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return f8245d;
    }

    public static boolean e(Context context) {
        String str;
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            cn.jiguang.as.d.j("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            str = " 未在manifest中配置AppKey";
        } else {
            if (a2.length() == 24) {
                return true;
            }
            cn.jiguang.as.d.j("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + a2 + ", Please get your Appkey from JIGUANG web console!");
            str = " AppKey:" + a2 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致";
        }
        cn.jiguang.e.a.a(context, str, -1);
        return false;
    }

    public static boolean f(Context context) {
        StringBuilder sb;
        c(context);
        if (c.a().c() || c.a().b()) {
            String str = context.getPackageName() + cn.jiguang.a.a.f8097a;
            if (!cn.jiguang.e.a.i(context, str)) {
                sb = new StringBuilder();
                sb.append("The permission should be defined - ");
                sb.append(str);
                cn.jiguang.as.d.j("CheckManifestHelper", sb.toString());
                return false;
            }
            f8246e.add(str);
        }
        Iterator<String> it = f8246e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!cn.jiguang.e.a.c(context, next)) {
                sb = new StringBuilder();
                sb.append("The permissoin is required - ");
                sb.append(next);
                cn.jiguang.as.d.j("CheckManifestHelper", sb.toString());
                return false;
            }
        }
        Iterator<String> it2 = f8247f.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!cn.jiguang.e.a.i(context, next2)) {
                cn.jiguang.as.d.g("CheckManifestHelper", "We recommend you add the permission - " + next2);
            }
        }
        Iterator<String> it3 = f8248g.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            if (!cn.jiguang.e.a.i(context, next3)) {
                cn.jiguang.as.d.g("CheckManifestHelper", "We recommend you add the permission - " + next3 + ", otherwise you can not locate the devices.");
            }
        }
        return true;
    }
}
