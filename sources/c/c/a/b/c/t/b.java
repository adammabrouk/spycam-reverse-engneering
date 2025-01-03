package c.c.a.b.c.t;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import c.c.a.b.c.s.n;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4031a;

    public b(Context context) {
        this.f4031a = context;
    }

    public ApplicationInfo a(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f4031a.getPackageManager().getApplicationInfo(str, i2);
    }

    public PackageInfo b(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f4031a.getPackageManager().getPackageInfo(str, i2);
    }

    public final PackageInfo a(String str, int i2, int i3) throws PackageManager.NameNotFoundException {
        return this.f4031a.getPackageManager().getPackageInfo(str, 64);
    }

    public CharSequence b(String str) throws PackageManager.NameNotFoundException {
        return this.f4031a.getPackageManager().getApplicationLabel(this.f4031a.getPackageManager().getApplicationInfo(str, 0));
    }

    public final String[] a(int i2) {
        return this.f4031a.getPackageManager().getPackagesForUid(i2);
    }

    @TargetApi(19)
    public final boolean a(int i2, String str) {
        if (n.e()) {
            try {
                ((AppOpsManager) this.f4031a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f4031a.getPackageManager().getPackagesForUid(i2);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int a(String str) {
        return this.f4031a.checkCallingOrSelfPermission(str);
    }

    public int a(String str, String str2) {
        return this.f4031a.getPackageManager().checkPermission(str, str2);
    }

    public boolean a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f4031a);
        }
        if (!n.i() || (nameForUid = this.f4031a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f4031a.getPackageManager().isInstantApp(nameForUid);
    }
}
