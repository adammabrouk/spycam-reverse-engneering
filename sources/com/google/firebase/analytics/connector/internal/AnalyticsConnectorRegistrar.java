package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import c.c.b.c;
import c.c.b.f.a.a;
import c.c.b.g.d;
import c.c.b.g.h;
import c.c.b.g.n;
import c.c.b.q.g;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements h {
    @Override // c.c.b.g.h
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<d<?>> getComponents() {
        d.b a2 = d.a(a.class);
        a2.a(n.b(c.class));
        a2.a(n.b(Context.class));
        a2.a(n.b(c.c.b.j.d.class));
        a2.a(c.c.b.f.a.c.a.f5824a);
        a2.c();
        return Arrays.asList(a2.b(), g.a("fire-analytics", "17.4.1"));
    }
}
