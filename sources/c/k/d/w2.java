package c.k.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class w2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    public String f7977c;

    public w2(Context context, int i2, String str) {
        super(context, i2);
        this.f7977c = str;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 24;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public x6 mo92a() {
        return x6.AppIsInstalled;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        String str;
        String[] m515a = m515a();
        if (m515a == null || m515a.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f6950b.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str2 : m515a) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    try {
                        str = packageManager.getInstallerPackageName(str2);
                    } catch (IllegalArgumentException unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = LogUtils.NULL;
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    sb.append(",");
                    sb.append(packageInfo.packageName);
                    sb.append(",");
                    sb.append(packageInfo.versionName);
                    sb.append(",");
                    sb.append(packageInfo.versionCode);
                    sb.append(",");
                    sb.append(packageInfo.firstInstallTime);
                    sb.append(",");
                    sb.append(packageInfo.lastUpdateTime);
                    sb.append(",");
                    sb.append(str);
                }
            } catch (Exception unused2) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final String[] m515a() {
        if (TextUtils.isEmpty(this.f7977c)) {
            return null;
        }
        String b2 = h0.b(this.f7977c);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2.contains(",") ? b2.split(",") : new String[]{b2};
    }
}
