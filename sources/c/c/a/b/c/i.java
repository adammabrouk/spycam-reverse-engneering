package c.c.a.b.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import c.c.a.b.c.o.r;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static i f3826b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3827a;

    public i(Context context) {
        this.f3827a = context.getApplicationContext();
    }

    public static i a(Context context) {
        r.a(context);
        synchronized (i.class) {
            if (f3826b == null) {
                w.a(context);
                f3826b = new i(context);
            }
        }
        return f3826b;
    }

    public boolean a(int i2) {
        f0 a2;
        String[] a3 = c.c.a.b.c.t.c.b(this.f3827a).a(i2);
        if (a3 == null || a3.length == 0) {
            a2 = f0.a("no pkgs");
        } else {
            a2 = null;
            for (String str : a3) {
                a2 = a(str, i2);
                if (a2.f3817a) {
                    break;
                }
            }
        }
        a2.b();
        return a2.f3817a;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? a(packageInfo, b0.f3808a) : a(packageInfo, b0.f3808a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (a(packageInfo, false)) {
            return true;
        }
        if (a(packageInfo, true)) {
            if (h.d(this.f3827a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public final f0 a(String str, int i2) {
        try {
            PackageInfo a2 = c.c.a.b.c.t.c.b(this.f3827a).a(str, 64, i2);
            boolean d2 = h.d(this.f3827a);
            if (a2 == null) {
                return f0.a("null pkg");
            }
            if (a2.signatures.length != 1) {
                return f0.a("single cert required");
            }
            z zVar = new z(a2.signatures[0].toByteArray());
            String str2 = a2.packageName;
            f0 a3 = w.a(str2, zVar, d2, false);
            return (!a3.f3817a || a2.applicationInfo == null || (a2.applicationInfo.flags & 2) == 0 || !w.a(str2, zVar, false, true).f3817a) ? a3 : f0.a("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return f0.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static y a(PackageInfo packageInfo, y... yVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        z zVar = new z(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < yVarArr.length; i2++) {
            if (yVarArr[i2].equals(zVar)) {
                return yVarArr[i2];
            }
        }
        return null;
    }
}
