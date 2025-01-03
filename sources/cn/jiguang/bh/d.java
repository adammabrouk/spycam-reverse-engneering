package cn.jiguang.bh;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f8789a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public final Context f8790b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f8791c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f8792d;

    /* renamed from: e, reason: collision with root package name */
    public final Runtime f8793e;

    public d(Context context) {
        this(context, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    public d(Context context, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f8790b = context;
        this.f8791c = strArr;
        this.f8792d = strArr2;
        this.f8793e = runtime;
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean c() {
        for (String str : this.f8791c) {
            try {
            } catch (RuntimeException unused) {
                cn.jiguang.as.d.g("RootChecker", String.format("Error when trying to check if root file %s exists.", str));
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        if (0 == 0) goto L30;
     */
    @android.annotation.TargetApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d() {
        /*
            r7 = this;
            java.lang.String r0 = "RootChecker"
            java.lang.String r1 = "/system/xbin/which"
            java.lang.String r2 = "su"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            r2 = 0
            r3 = 0
            java.lang.Runtime r4 = r7.f8793e     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.lang.Process r3 = r4.exec(r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.io.InputStream r5 = r3.getInputStream()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.nio.charset.Charset r6 = cn.jiguang.bh.d.f8789a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L2a
            r4 = 1
            goto L2b
        L2a:
            r4 = 0
        L2b:
            r1.close()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
            if (r3 == 0) goto L33
            r3.destroy()
        L33:
            return r4
        L34:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L36
        L36:
            r5 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L3b
            goto L3f
        L3b:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
        L3f:
            throw r5     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42 java.io.IOException -> L5e
        L40:
            r0 = move-exception
            goto L7d
        L42:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r4.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "Error when trying to check if SU exists."
            r4.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L40
            r4.append(r1)     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L40
            cn.jiguang.as.d.g(r0, r1)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto L7c
            goto L79
        L5e:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r4.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "SU isn't found on this Device."
            r4.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L40
            r4.append(r1)     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L40
            cn.jiguang.as.d.g(r0, r1)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto L7c
        L79:
            r3.destroy()
        L7c:
            return r2
        L7d:
            if (r3 == 0) goto L82
            r3.destroy()
        L82:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bh.d.d():boolean");
    }

    private boolean e() {
        PackageManager packageManager = this.f8790b.getPackageManager();
        if (packageManager != null) {
            for (String str : this.f8792d) {
                try {
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return false;
    }

    public boolean a() {
        return b() || c() || d() || e();
    }
}
