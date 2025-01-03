package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import c.c.a.b.c.o.r;
import c.c.a.b.g.b.a5;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public class Analytics {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Analytics f10236a;

    public Analytics(a5 a5Var) {
        r.a(a5Var);
    }

    @Keep
    public static Analytics getInstance(Context context) {
        if (f10236a == null) {
            synchronized (Analytics.class) {
                if (f10236a == null) {
                    f10236a = new Analytics(a5.a(context, null, null));
                }
            }
        }
        return f10236a;
    }
}
