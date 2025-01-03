package c.k.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import c.k.d.n9;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f6931a = new HashMap<>();

    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (w0.class) {
            str2 = f6931a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(s0 s0Var) {
        int i2 = y0.f6937a[s0Var.ordinal()];
        if (i2 == 1) {
            return "hms_push_token";
        }
        if (i2 == 2) {
            return "fcm_push_token";
        }
        if (i2 == 3) {
            return "cos_push_token";
        }
        if (i2 != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    public static HashMap<String, String> a(Context context, s0 s0Var) {
        StringBuilder sb;
        a0 a0Var;
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = a(s0Var);
        if (TextUtils.isEmpty(a2)) {
            return hashMap;
        }
        int i2 = y0.f6937a[s0Var.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i2 != 1) {
            if (i2 == 2) {
                sb = new StringBuilder();
                sb.append("brand:");
                a0Var = a0.FCM;
            } else if (i2 == 3) {
                sb = new StringBuilder();
                sb.append("brand:");
                a0Var = a0.OPPO;
            } else if (i2 == 4) {
                sb = new StringBuilder();
                sb.append("brand:");
                a0Var = a0.VIVO;
            }
            sb.append(a0Var.name());
            sb.append("~");
            sb.append(JThirdPlatFormInterface.KEY_TOKEN);
            sb.append(":");
            sb.append(a(context, a2));
            sb.append("~");
            sb.append("package_name");
            sb.append(":");
            sb.append(context.getPackageName());
            str = sb.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE);
            } catch (Exception e2) {
                c.k.a.a.a.c.d(e2.toString());
            }
            str = "brand:" + b1.a(context).name() + "~" + JThirdPlatFormInterface.KEY_TOKEN + ":" + a(context, a2) + "~package_name:" + context.getPackageName() + "~app_id:" + (applicationInfo != null ? applicationInfo.metaData.getInt("com.huawei.hms.client.appid") : -1);
        }
        hashMap.put("RegInfo", str);
        return hashMap;
    }

    public static void a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(s0.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(s0.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            i0.a(context).a(2, a2);
        }
    }

    public static void a(Context context, s0 s0Var, String str) {
        c.k.d.j.a(context).a(new x0(str, context, s0Var));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m61a(Context context, s0 s0Var) {
        if (z0.m65a(s0Var) != null) {
            return c.k.d.p9.m.a(context).a(z0.m65a(s0Var).a(), true);
        }
        return false;
    }

    public static void b(Context context) {
        t0.a(context).b();
    }

    public static void c(Context context) {
        t0.a(context).a();
    }

    public static synchronized void c(Context context, s0 s0Var, String str) {
        synchronized (w0.class) {
            String a2 = a(s0Var);
            if (TextUtils.isEmpty(a2)) {
                c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            n9.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
            c.k.a.a.a.c.m6a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
