package c.k.c.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/* loaded from: classes.dex */
public final class n1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6877a;

    public n1(Context context) {
        this.f6877a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f6877a.getPackageManager().getPackageInfo(this.f6877a.getPackageName(), 4612);
            m1.c(this.f6877a);
            m1.d(this.f6877a, packageInfo);
            m1.c(this.f6877a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
