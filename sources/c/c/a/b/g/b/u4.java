package c.c.a.b.g.b;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.c.a.b.f.e.k2 f5116a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f5117b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r4 f5118c;

    public u4(r4 r4Var, c.c.a.b.f.e.k2 k2Var, ServiceConnection serviceConnection) {
        this.f5118c = r4Var;
        this.f5116a = k2Var;
        this.f5117b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        r4 r4Var = this.f5118c;
        s4 s4Var = r4Var.f5039b;
        str = r4Var.f5038a;
        c.c.a.b.f.e.k2 k2Var = this.f5116a;
        ServiceConnection serviceConnection = this.f5117b;
        Bundle a2 = s4Var.a(str, k2Var);
        s4Var.f5060a.a().g();
        if (a2 != null) {
            long j = a2.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                s4Var.f5060a.c().t().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    s4Var.f5060a.c().t().a("No referrer defined in Install Referrer response");
                } else {
                    s4Var.f5060a.c().B().a("InstallReferrer API result", string);
                    s9 v = s4Var.f5060a.v();
                    String valueOf = String.valueOf(string);
                    Bundle a3 = v.a(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (a3 == null) {
                        s4Var.f5060a.c().t().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = a3.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = a2.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                s4Var.f5060a.c().t().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                a3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == s4Var.f5060a.p().k.a()) {
                            s4Var.f5060a.F();
                            s4Var.f5060a.c().B().a("Install Referrer campaign has already been logged");
                        } else if (!c.c.a.b.f.e.v9.a() || !s4Var.f5060a.o().a(r.C0) || s4Var.f5060a.g()) {
                            s4Var.f5060a.p().k.a(j);
                            s4Var.f5060a.F();
                            s4Var.f5060a.c().B().a("Logging Install Referrer campaign from sdk with ", "referrer API");
                            a3.putString("_cis", "referrer API");
                            s4Var.f5060a.u().a("auto", "_cmp", a3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            c.c.a.b.c.r.a.a().a(s4Var.f5060a.d(), serviceConnection);
        }
    }
}
