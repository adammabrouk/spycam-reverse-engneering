package c.c.b.p;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements c.c.b.g.g {

    /* renamed from: a, reason: collision with root package name */
    public static final c.c.b.g.g f6161a = new q();

    @Override // c.c.b.g.g
    public final Object a(c.c.b.g.e eVar) {
        c.c.b.c cVar = (c.c.b.c) eVar.a(c.c.b.c.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class);
        c.c.b.q.h hVar = (c.c.b.q.h) eVar.a(c.c.b.q.h.class);
        c.c.b.k.c cVar2 = (c.c.b.k.c) eVar.a(c.c.b.k.c.class);
        c.c.b.n.h hVar2 = (c.c.b.n.h) eVar.a(c.c.b.n.h.class);
        c.c.a.a.g gVar = (c.c.a.a.g) eVar.a(c.c.a.a.g.class);
        if (gVar == null || !c.c.a.a.i.a.f3474g.a().contains(c.c.a.a.b.a("json"))) {
            gVar = new FirebaseMessagingRegistrar.b();
        }
        return new FirebaseMessaging(cVar, firebaseInstanceId, hVar, cVar2, hVar2, gVar);
    }
}
