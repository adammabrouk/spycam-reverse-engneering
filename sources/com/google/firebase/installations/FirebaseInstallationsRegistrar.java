package com.google.firebase.installations;

import androidx.annotation.Keep;
import c.c.b.c;
import c.c.b.g.d;
import c.c.b.g.e;
import c.c.b.g.h;
import c.c.b.g.n;
import c.c.b.n.g;
import c.c.b.n.j;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements h {
    public static /* synthetic */ c.c.b.n.h lambda$getComponents$0(e eVar) {
        return new g((c) eVar.a(c.class), (c.c.b.q.h) eVar.a(c.c.b.q.h.class), (c.c.b.k.c) eVar.a(c.c.b.k.c.class));
    }

    @Override // c.c.b.g.h
    public List<d<?>> getComponents() {
        d.b a2 = d.a(c.c.b.n.h.class);
        a2.a(n.b(c.class));
        a2.a(n.b(c.c.b.k.c.class));
        a2.a(n.b(c.c.b.q.h.class));
        a2.a(j.a());
        return Arrays.asList(a2.b(), c.c.b.q.g.a("fire-installations", "16.3.0"));
    }
}
