package c.c.b.p;

import android.content.Intent;
import cn.jpush.android.api.InAppSlotParams;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6106a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f6107b;

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    /* renamed from: c.c.b.p.a$a, reason: collision with other inner class name */
    public static final class C0117a {

        /* renamed from: a, reason: collision with root package name */
        public final a f6108a;

        public C0117a(a aVar) {
            c.c.a.b.c.o.r.a(aVar);
            this.f6108a = aVar;
        }

        public final a a() {
            return this.f6108a;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static class b implements c.c.b.i.d<a> {
        @Override // c.c.b.i.b
        public final /* synthetic */ void a(Object obj, c.c.b.i.e eVar) throws IOException {
            a aVar = (a) obj;
            c.c.b.i.e eVar2 = eVar;
            Intent a2 = aVar.a();
            eVar2.a("ttl", u.f(a2));
            eVar2.a(InAppSlotParams.SLOT_KEY.EVENT, aVar.b());
            eVar2.a("instanceId", u.c());
            eVar2.a("priority", u.m(a2));
            eVar2.a("packageName", u.b());
            eVar2.a("sdkPlatform", "ANDROID");
            eVar2.a("messageType", u.k(a2));
            String j = u.j(a2);
            if (j != null) {
                eVar2.a("messageId", j);
            }
            String l = u.l(a2);
            if (l != null) {
                eVar2.a("topic", l);
            }
            String g2 = u.g(a2);
            if (g2 != null) {
                eVar2.a("collapseKey", g2);
            }
            if (u.i(a2) != null) {
                eVar2.a("analyticsLabel", u.i(a2));
            }
            if (u.h(a2) != null) {
                eVar2.a("composerLabel", u.h(a2));
            }
            String d2 = u.d();
            if (d2 != null) {
                eVar2.a("projectNumber", d2);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static final class c implements c.c.b.i.d<C0117a> {
        @Override // c.c.b.i.b
        public final /* synthetic */ void a(Object obj, c.c.b.i.e eVar) throws IOException {
            eVar.a("messaging_client_event", ((C0117a) obj).a());
        }
    }

    public a(String str, Intent intent) {
        c.c.a.b.c.o.r.a(str, (Object) "evenType must be non-null");
        this.f6106a = str;
        c.c.a.b.c.o.r.a(intent, "intent must be non-null");
        this.f6107b = intent;
    }

    public final Intent a() {
        return this.f6107b;
    }

    public final String b() {
        return this.f6106a;
    }
}
