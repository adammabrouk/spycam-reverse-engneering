package c.k.d.p9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.a5;
import c.k.d.f7;
import c.k.d.j9;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;

/* loaded from: classes.dex */
public class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static i1 f7626a;

    /* renamed from: b, reason: collision with root package name */
    public static a f7627b;

    public interface a {
        void a();
    }

    public static synchronized i1 a(Context context) {
        synchronized (j1.class) {
            if (f7626a != null) {
                return f7626a;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString(JThirdPlatFormInterface.KEY_TOKEN, null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i2 = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && f7.m154a(string7)) {
                string7 = f7.k(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String k = f7.k(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                c.k.a.a.a.c.m6a("read_phone_state permission changes.");
            }
            i1 i1Var = new i1(string, string2, string3, string4, string5, string6, i2);
            f7626a = i1Var;
            return i1Var;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:3|4|(2:8|(28:10|11|(1:13)|14|(1:16)|17|(1:19)|20|(1:22)|23|(1:25)|26|27|28|29|(1:31)(1:68)|32|(6:34|(1:36)|37|(1:41)|42|(1:44))|45|(1:47)|48|(1:50)|51|(1:53)|54|(2:56|(5:58|(1:60)|61|62|63)(1:65))|66|67))|72|11|(0)|14|(0)|17|(0)|20|(0)|23|(0)|26|27|28|29|(0)(0)|32|(0)|45|(0)|48|(0)|51|(0)|54|(0)|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c1, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c2, code lost:
    
        c.k.a.a.a.c.a(r10);
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016b A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017e A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c6 A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d0 A[Catch: all -> 0x0253, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0044, B:8:0x004e, B:10:0x0064, B:11:0x0070, B:13:0x007d, B:14:0x0082, B:16:0x008c, B:17:0x0091, B:20:0x0099, B:23:0x00a2, B:26:0x00ab, B:28:0x00b6, B:31:0x00ca, B:32:0x00d3, B:34:0x00fa, B:36:0x0106, B:37:0x0119, B:39:0x0123, B:41:0x0129, B:42:0x013d, B:44:0x0143, B:45:0x0148, B:47:0x016b, B:48:0x0174, B:50:0x017e, B:51:0x0187, B:53:0x01c6, B:54:0x01ca, B:56:0x01d0, B:58:0x01dd, B:60:0x01fb, B:61:0x0211, B:65:0x023f, B:71:0x00c2), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized c.k.d.p9.i1 a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.p9.j1.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):c.k.d.p9.i1");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m389a(Context context) {
        StringBuilder sb;
        String str;
        String a2 = c.k.d.p9.a.a(context).a();
        if (c.k.d.c.b()) {
            sb = new StringBuilder();
            sb.append(JPushConstants.HTTP_PRE);
            sb.append(a5.f6951e);
            str = ":9085";
        } else if (j9.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (j9.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (j9.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (j9.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (j9.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append(JPushConstants.HTTPS_PRE);
            str = c.k.d.c.m97a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append("/pass/v2/register");
        return sb.toString();
    }

    public static void a() {
        a aVar = f7627b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m390a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f7626a = null;
        a();
    }

    public static void a(Context context, i1 i1Var) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", i1Var.f7606a);
        edit.putString("security", i1Var.f7608c);
        edit.putString(JThirdPlatFormInterface.KEY_TOKEN, i1Var.f7607b);
        edit.putString("app_id", i1Var.f7609d);
        edit.putString("package_name", i1Var.f7611f);
        edit.putString("app_token", i1Var.f7610e);
        edit.putString("device_id", f7.k(context));
        edit.putInt("env_type", i1Var.f7612g);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f7627b = aVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m391a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
