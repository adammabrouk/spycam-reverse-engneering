package com.google.firebase.iid;

import androidx.annotation.Keep;
import c.c.b.c;
import c.c.b.g.d;
import c.c.b.g.h;
import c.c.b.g.n;
import c.c.b.l.t;
import c.c.b.l.u;
import c.c.b.q.g;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
@Keep
/* loaded from: classes.dex */
public final class Registrar implements h {

    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    public static class a implements c.c.b.l.b.a {
        public a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    @Override // c.c.b.g.h
    @Keep
    public final List<d<?>> getComponents() {
        d.b a2 = d.a(FirebaseInstanceId.class);
        a2.a(n.b(c.class));
        a2.a(n.b(c.c.b.j.d.class));
        a2.a(n.b(c.c.b.q.h.class));
        a2.a(n.b(c.c.b.k.c.class));
        a2.a(n.b(c.c.b.n.h.class));
        a2.a(t.f5997a);
        a2.a();
        d b2 = a2.b();
        d.b a3 = d.a(c.c.b.l.b.a.class);
        a3.a(n.b(FirebaseInstanceId.class));
        a3.a(u.f5999a);
        return Arrays.asList(b2, a3.b(), g.a("fire-iid", "20.1.7"));
    }
}
