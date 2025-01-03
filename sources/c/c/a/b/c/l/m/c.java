package c.c.a.b.c.l.m;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import c.c.a.b.c.o.s0;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.api.Status;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f3867d = new Object();

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("sLock")
    public static c f3868e;

    /* renamed from: a, reason: collision with root package name */
    public final String f3869a;

    /* renamed from: b, reason: collision with root package name */
    public final Status f3870b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3871c;

    public c(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            this.f3871c = !(resources.getInteger(identifier) != 0);
        } else {
            this.f3871c = false;
        }
        String a2 = s0.a(context);
        a2 = a2 == null ? new c.c.a.b.c.o.u(context).a("google_app_id") : a2;
        if (TextUtils.isEmpty(a2)) {
            this.f3870b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f3869a = null;
        } else {
            this.f3869a = a2;
            this.f3870b = Status.f10032e;
        }
    }

    public static Status a(Context context) {
        Status status;
        c.c.a.b.c.o.r.a(context, "Context must not be null.");
        synchronized (f3867d) {
            if (f3868e == null) {
                f3868e = new c(context);
            }
            status = f3868e.f3870b;
        }
        return status;
    }

    public static boolean b() {
        return a("isMeasurementExplicitlyDisabled").f3871c;
    }

    public static String a() {
        return a("getGoogleAppId").f3869a;
    }

    public static c a(String str) {
        c cVar;
        synchronized (f3867d) {
            if (f3868e != null) {
                cVar = f3868e;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return cVar;
    }
}
