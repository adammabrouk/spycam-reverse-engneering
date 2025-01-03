package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import c.c.a.b.c.o.r;
import c.c.a.b.f.e.c;
import c.c.a.b.g.b.a5;
import c.c.a.b.g.b.c7;
import c.c.a.b.g.b.fa;
import c.c.b.f.b;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: d, reason: collision with root package name */
    public static volatile FirebaseAnalytics f10703d;

    /* renamed from: a, reason: collision with root package name */
    public final a5 f10704a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10705b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10706c;

    public FirebaseAnalytics(a5 a5Var) {
        r.a(a5Var);
        this.f10704a = a5Var;
        this.f10705b = null;
        this.f10706c = false;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f10703d == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f10703d == null) {
                    if (c.b(context)) {
                        f10703d = new FirebaseAnalytics(c.a(context));
                    } else {
                        f10703d = new FirebaseAnalytics(a5.a(context, null, null));
                    }
                }
            }
        }
        return f10703d;
    }

    @Keep
    public static c7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        c a2;
        if (c.b(context) && (a2 = c.a(context, (String) null, (String) null, (String) null, bundle)) != null) {
            return new b(a2);
        }
        return null;
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.o().a();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f10706c) {
            this.f10705b.a(activity, str, str2);
        } else if (fa.a()) {
            this.f10704a.D().a(activity, str, str2);
        } else {
            this.f10704a.c().w().a("setCurrentScreen must be called from the main thread");
        }
    }

    public FirebaseAnalytics(c cVar) {
        r.a(cVar);
        this.f10704a = null;
        this.f10705b = cVar;
        this.f10706c = true;
    }
}
