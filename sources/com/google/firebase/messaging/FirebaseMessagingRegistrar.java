package com.google.firebase.messaging;

import androidx.annotation.Keep;
import c.c.a.a.c;
import c.c.a.a.e;
import c.c.a.a.f;
import c.c.a.a.g;
import c.c.b.g.d;
import c.c.b.g.h;
import c.c.b.g.n;
import c.c.b.p.q;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
@Keep
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements h {

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static class a<T> implements f<T> {
        public a() {
        }

        @Override // c.c.a.a.f
        public final void a(c<T> cVar) {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static class b implements g {
        @Override // c.c.a.a.g
        public final <T> f<T> a(String str, Class<T> cls, c.c.a.a.b bVar, e<T, byte[]> eVar) {
            return new a();
        }
    }

    @Override // c.c.b.g.h
    @Keep
    public List<d<?>> getComponents() {
        d.b a2 = d.a(FirebaseMessaging.class);
        a2.a(n.b(c.c.b.c.class));
        a2.a(n.b(FirebaseInstanceId.class));
        a2.a(n.b(c.c.b.q.h.class));
        a2.a(n.b(c.c.b.k.c.class));
        a2.a(n.a(g.class));
        a2.a(n.b(c.c.b.n.h.class));
        a2.a(q.f6161a);
        a2.a();
        return Arrays.asList(a2.b(), c.c.b.q.g.a("fire-fcm", "20.1.7"));
    }
}
