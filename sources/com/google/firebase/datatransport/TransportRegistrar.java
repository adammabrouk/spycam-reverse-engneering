package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import c.c.a.a.g;
import c.c.a.a.i.a;
import c.c.a.a.j.q;
import c.c.b.g.d;
import c.c.b.g.e;
import c.c.b.g.h;
import c.c.b.g.n;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements h {
    public static /* synthetic */ g lambda$getComponents$0(e eVar) {
        q.a((Context) eVar.a(Context.class));
        return q.b().a(a.f3474g);
    }

    @Override // c.c.b.g.h
    public List<d<?>> getComponents() {
        d.b a2 = d.a(g.class);
        a2.a(n.b(Context.class));
        a2.a(c.c.b.h.a.a());
        return Collections.singletonList(a2.b());
    }
}
