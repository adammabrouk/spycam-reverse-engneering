package cn.jpush.android.at;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.aw.d;
import cn.jpush.android.bm.j;
import cn.jpush.android.bm.k;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import java.io.File;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public String f9323e = "";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9321c = cn.jpush.android.bm.d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 97, 69, 83, 113, 123, 98, 104, 92, 69, 55, 98, 102, 100, 67, 72, 55, 107, 120});

    /* renamed from: a, reason: collision with root package name */
    public static String f9319a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f9320b = "";

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f9322d = null;

    /* renamed from: cn.jpush.android.at.a$a, reason: collision with other inner class name */
    public static class C0146a extends cn.jpush.android.bm.e {

        /* renamed from: a, reason: collision with root package name */
        public volatile Context f9324a;

        public C0146a(Context context) {
            this.f9324a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String a(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = android.os.Build.MANUFACTURER
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                java.lang.String r2 = ""
                if (r1 != 0) goto L13
                java.lang.String r0 = r0.trim()
                java.lang.String r0 = r0.toLowerCase()
                goto L14
            L13:
                r0 = r2
            L14:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                java.lang.String r3 = "a"
                if (r1 != 0) goto L45
                if (r5 == 0) goto L45
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r1 = b()
                r5.append(r1)
                java.lang.String r1 = java.io.File.separator
                r5.append(r1)
                r5.append(r3)
                java.lang.String r1 = java.io.File.separator
                r5.append(r1)
                r5.append(r0)
                java.lang.String r1 = java.io.File.separator
                r5.append(r1)
                r5.append(r0)
                java.lang.String r0 = ".json"
                goto L6c
            L45:
                if (r5 != 0) goto L74
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = b()
                r5.append(r0)
                java.lang.String r0 = java.io.File.separator
                r5.append(r0)
                r5.append(r3)
                java.lang.String r0 = java.io.File.separator
                r5.append(r0)
                java.lang.String r0 = "all"
                r5.append(r0)
                java.lang.String r0 = java.io.File.separator
                r5.append(r0)
                java.lang.String r0 = "all.json"
            L6c:
                r5.append(r0)
                java.lang.String r5 = r5.toString()
                goto L75
            L74:
                r5 = r2
            L75:
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 == 0) goto L7c
                goto L8f
            L7c:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r4.c()
                r0.append(r1)
                r0.append(r5)
                java.lang.String r2 = r0.toString()
            L8f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.at.a.C0146a.a(boolean):java.lang.String");
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(Context context, String str) {
            try {
                Sp.set(context, Key.LocalAniConfigSign().set(Sp.get(context, Key.SvrAniConfigSign())));
                Sp.set(context, Key.LastAniConfigReqTime().set(Long.valueOf(System.currentTimeMillis())));
                d.a a2 = cn.jpush.android.au.b.a(str);
                if (a2 == null) {
                    cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "dealResponseConfigData getInMatches is null");
                    return;
                }
                cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "getInMatches: " + a2.toString());
                String f2 = a2.f();
                int a3 = a2.a();
                cn.jpush.android.r.b.a("InAppAniConfigDownloadHelper", "response config data, aniConfigPath: " + f2 + ", aniFileVersion: " + a3);
                if (TextUtils.isEmpty(f2) || !a(context, a3, f2)) {
                    return;
                }
                String str2 = c() + f2;
                String a4 = cn.jpush.android.bf.a.a(this.f9324a, str2, "", 2);
                if (TextUtils.isEmpty(a4)) {
                    cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "download ani config file failed");
                    return;
                }
                Sp.set(context, Key.LocalAniConfigVersion().set(Integer.valueOf(a3)));
                Sp.set(context, Key.LastAniConfigPath().set(f2));
                cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "inapp ani-config file response: " + a4 + ", request url: " + str2);
                String a5 = j.a(a4, k.f9681a);
                if (!context.getPackageName().equals(cn.jpush.android.bm.a.d(context))) {
                    a.a().a(context, a5);
                    return;
                }
                cn.jpush.android.r.b.d("InAppAniConfigDownloadHelper", "sync animator rule config to main process");
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                dVar.bv = a5;
                cn.jpush.android.an.a.a(context, "cn.jpush.android.intent.SYNC_ANI_CONFIG", dVar, true);
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "update ani config data parse json failed, e: " + th.getMessage());
            }
        }

        private boolean a(Context context) {
            String str;
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                str = "sdk is banned not request config";
            } else {
                String str2 = (String) Sp.get(context, Key.SvrAniConfigSign());
                String str3 = (String) Sp.get(context, Key.LocalAniConfigSign());
                if (!TextUtils.isEmpty(str2)) {
                    cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "current local file md5 equals the server latest");
                    return !str2.equals(str3);
                }
                if (System.currentTimeMillis() - ((Long) Sp.get(context, Key.LastAniConfigReqTime())).longValue() >= 259200000) {
                    return true;
                }
                str = "not config request internal time";
            }
            cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", str);
            return false;
        }

        private boolean a(Context context, int i2, String str) {
            return i2 > ((Integer) Sp.get(context, Key.LocalAniConfigVersion())).intValue() || !(TextUtils.isEmpty(str) || str.equals(Sp.get(context, Key.LastAniConfigPath())));
        }

        public static String b() {
            TextUtils.isEmpty(a.f9320b);
            return "V100";
        }

        private String c() {
            String str = a.f9321c;
            TextUtils.isEmpty(a.f9319a);
            return str + File.separator;
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            try {
                if (a(this.f9324a)) {
                    String a2 = a(true);
                    if (TextUtils.isEmpty(a2)) {
                        cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "inapp manu ani config url is null");
                        return;
                    }
                    String a3 = cn.jpush.android.bf.a.a(this.f9324a, a2, "", 2);
                    if (TextUtils.isEmpty(a3)) {
                        cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "request manufacture ani config failed, manufacture: " + Build.MANUFACTURER + ", try common config.");
                        a2 = a(false);
                        if (TextUtils.isEmpty(a2)) {
                            cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "inapp common ani config url is null");
                            return;
                        }
                        a3 = cn.jpush.android.bf.a.a(this.f9324a, a2, "", 2);
                        if (TextUtils.isEmpty(a3)) {
                            cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "request common ani config failed");
                            return;
                        }
                    }
                    cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "ani config response: " + a3 + ", reqUrl: " + a2);
                    a(this.f9324a, a3);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static a a() {
        if (f9322d == null) {
            synchronized (a.class) {
                if (f9322d == null) {
                    f9322d = new a();
                }
            }
        }
        return f9322d;
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.f9323e)) {
            return this.f9323e;
        }
        synchronized ("ani_config.cache") {
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "ani_config.cache";
            File file = new File(str);
            if (file.exists()) {
                try {
                    String str2 = (String) cn.jpush.android.bm.c.a(file);
                    if (!TextUtils.isEmpty(str2)) {
                        String b2 = j.b(str2, k.f9681a);
                        cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "use config from cache file, path: " + str);
                        this.f9323e = b2;
                        return b2;
                    }
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("InAppAniConfigDownloadHelper", "read ani config config error, " + th.getMessage());
                }
            }
            this.f9323e = cn.jpush.android.aw.a.f9384a;
            cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "use local mem cache config");
            return this.f9323e;
        }
    }

    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized ("ani_config.cache") {
            cn.jpush.android.bm.c.a(new File(context.getFilesDir(), "ani_config.cache"), str);
            cn.jpush.android.r.b.b("InAppAniConfigDownloadHelper", "cache animator config data");
        }
    }

    public void b(Context context) {
        JCoreHelper.futureExecutor(context, new C0146a(context));
    }
}
