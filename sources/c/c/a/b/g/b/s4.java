package c.c.a.b.g.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s4 {

    /* renamed from: a, reason: collision with root package name */
    public final a5 f5060a;

    public s4(a5 a5Var) {
        this.f5060a = a5Var;
    }

    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f5060a.c().x().a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f5060a.a().g();
        if (!a()) {
            this.f5060a.c().z().a("Install Referrer Reporter is not available");
            return;
        }
        r4 r4Var = new r4(this, str);
        this.f5060a.a().g();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f5060a.d().getPackageManager();
        if (packageManager == null) {
            this.f5060a.c().x().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f5060a.c().z().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !a()) {
                this.f5060a.c().w().a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f5060a.c().B().a("Install Referrer Service is", c.c.a.b.c.r.a.a().a(this.f5060a.d(), new Intent(intent), r4Var, 1) ? "available" : "not available");
            } catch (Exception e2) {
                this.f5060a.c().t().a("Exception occurred while binding to Install Referrer Service", e2.getMessage());
            }
        }
    }

    public final boolean a() {
        try {
            c.c.a.b.c.t.b b2 = c.c.a.b.c.t.c.b(this.f5060a.d());
            if (b2 != null) {
                return b2.b("com.android.vending", RecyclerView.c0.FLAG_IGNORE).versionCode >= 80837300;
            }
            this.f5060a.c().B().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            this.f5060a.c().B().a("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }

    public final Bundle a(String str, c.c.a.b.f.e.k2 k2Var) {
        this.f5060a.a().g();
        if (k2Var == null) {
            this.f5060a.c().w().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle a2 = k2Var.a(bundle);
            if (a2 != null) {
                return a2;
            }
            this.f5060a.c().t().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.f5060a.c().t().a("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }
}
