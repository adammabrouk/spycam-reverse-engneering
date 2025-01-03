package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import c.c.a.a.g;
import c.c.a.b.c.s.s.a;
import c.c.a.b.j.h;
import c.c.b.c;
import c.c.b.l.r;
import c.c.b.p.e;
import c.c.b.p.n;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: d, reason: collision with root package name */
    @SuppressLint({"FirebaseUnknownNullness"})
    public static g f10725d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10726a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseInstanceId f10727b;

    /* renamed from: c, reason: collision with root package name */
    public final h<e> f10728c;

    public FirebaseMessaging(c cVar, FirebaseInstanceId firebaseInstanceId, c.c.b.q.h hVar, c.c.b.k.c cVar2, c.c.b.n.h hVar2, g gVar) {
        f10725d = gVar;
        this.f10727b = firebaseInstanceId;
        Context b2 = cVar.b();
        this.f10726a = b2;
        h<e> a2 = e.a(cVar, firebaseInstanceId, new r(b2), hVar, cVar2, hVar2, this.f10726a, n.a(), new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Topics-Io")));
        this.f10728c = a2;
        a2.a(n.b(), new c.c.a.b.j.e(this) { // from class: c.c.b.p.p

            /* renamed from: a, reason: collision with root package name */
            public final FirebaseMessaging f6160a;

            {
                this.f6160a = this;
            }

            @Override // c.c.a.b.j.e
            public final void a(Object obj) {
                e eVar = (e) obj;
                if (this.f6160a.a()) {
                    eVar.a();
                }
            }
        });
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(c cVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) cVar.a(FirebaseMessaging.class);
        }
        return firebaseMessaging;
    }

    public boolean a() {
        return this.f10727b.i();
    }
}
