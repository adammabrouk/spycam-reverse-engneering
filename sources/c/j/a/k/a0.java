package c.j.a.k;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes.dex */
public final class a0 extends i0 {

    /* compiled from: OnNotificationArrivedReceiveTask.java */
    public interface a {
        void a();

        void b();
    }

    public a0(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        if (vVar == null) {
            c.j.a.z.v.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean d2 = c.j.a.j.a.a(this.f6635a).d();
        c.j.a.f.p pVar = (c.j.a.f.p) vVar;
        Context context = this.f6635a;
        if (!c.j.a.z.z.d(context, context.getPackageName())) {
            c.j.a.f.w wVar = new c.j.a.f.w(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(pVar.f()));
            Context context2 = this.f6635a;
            String b2 = c.j.a.z.f0.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            wVar.a(hashMap);
            c.j.a.m.m().a(wVar);
            return;
        }
        c.j.a.m.m().a(new c.j.a.f.g(String.valueOf(pVar.f())));
        c.j.a.z.v.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f6635a.getPackageName() + " isEnablePush :" + d2);
        if (!d2) {
            c.j.a.f.w wVar2 = new c.j.a.f.w(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(pVar.f()));
            Context context3 = this.f6635a;
            String b3 = c.j.a.z.f0.b(context3, context3.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            wVar2.a(hashMap2);
            c.j.a.m.m().a(wVar2);
            return;
        }
        if (c.j.a.m.m().f() && !a(c.j.a.z.f0.d(this.f6635a), pVar.i(), pVar.g())) {
            c.j.a.f.w wVar3 = new c.j.a.f.w(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(pVar.f()));
            Context context4 = this.f6635a;
            String b4 = c.j.a.z.f0.b(context4, context4.getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap3.put("remoteAppId", b4);
            }
            wVar3.a(hashMap3);
            c.j.a.m.m().a(wVar3);
            return;
        }
        c.j.a.t.a h2 = pVar.h();
        if (h2 == null) {
            c.j.a.z.v.a("OnNotificationArrivedTask", "notify is null");
            c.j.a.z.v.c(this.f6635a, "通知内容为空，" + pVar.f());
            c.j.a.z.k.a(this.f6635a, pVar.f(), 1027L);
            return;
        }
        c.j.a.z.v.d("OnNotificationArrivedTask", "tragetType is " + h2.o() + " ; target is " + h2.q());
        c.j.a.s.c(new b0(this, h2, pVar));
    }
}
