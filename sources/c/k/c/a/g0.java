package c.k.c.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class g0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f6830a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6831b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f0 f6832c;

    public g0(f0 f0Var, String[] strArr, Context context) {
        this.f6832c = f0Var;
        this.f6830a = strArr;
        this.f6831b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i2 = 0; i2 < this.f6830a.length; i2++) {
            try {
                if (!TextUtils.isEmpty(this.f6830a[i2])) {
                    if (i2 > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f6831b.getPackageManager().getPackageInfo(this.f6830a[i2], 4);
                    if (packageInfo != null) {
                        this.f6832c.a(this.f6831b, packageInfo);
                    }
                }
            } catch (Throwable th) {
                c.k.a.a.a.c.a(th);
                return;
            }
        }
    }
}
