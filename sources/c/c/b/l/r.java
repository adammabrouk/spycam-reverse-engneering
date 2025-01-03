package c.c.b.l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5990a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public String f5991b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    public String f5992c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    public int f5993d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    public int f5994e = 0;

    public r(Context context) {
        this.f5990a = context;
    }

    public final boolean a() {
        return b() != 0;
    }

    public final synchronized int b() {
        if (this.f5994e != 0) {
            return this.f5994e;
        }
        PackageManager packageManager = this.f5990a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!c.c.a.b.c.s.n.i()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f5994e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f5994e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (c.c.a.b.c.s.n.i()) {
            this.f5994e = 2;
        } else {
            this.f5994e = 1;
        }
        return this.f5994e;
    }

    public final synchronized String c() {
        if (this.f5991b == null) {
            f();
        }
        return this.f5991b;
    }

    public final synchronized String d() {
        if (this.f5992c == null) {
            f();
        }
        return this.f5992c;
    }

    public final synchronized int e() {
        PackageInfo a2;
        if (this.f5993d == 0 && (a2 = a("com.google.android.gms")) != null) {
            this.f5993d = a2.versionCode;
        }
        return this.f5993d;
    }

    public final synchronized void f() {
        PackageInfo a2 = a(this.f5990a.getPackageName());
        if (a2 != null) {
            this.f5991b = Integer.toString(a2.versionCode);
            this.f5992c = a2.versionName;
        }
    }

    public static String a(c.c.b.c cVar) {
        String c2 = cVar.d().c();
        if (c2 != null) {
            return c2;
        }
        String b2 = cVar.d().b();
        if (!b2.startsWith("1:")) {
            return b2;
        }
        String[] split = b2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public final PackageInfo a(String str) {
        try {
            return this.f5990a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
