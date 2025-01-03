package c.j.a.k;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: OnMessageReceiveTask.java */
/* loaded from: classes.dex */
public final class y extends i0 {
    public y(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.n nVar = (c.j.a.f.n) vVar;
        c.j.a.m.m().a(new c.j.a.f.g(String.valueOf(nVar.f())));
        if (!c.j.a.j.a.a(this.f6635a).d()) {
            c.j.a.z.v.d("OnMessageTask", "command  " + vVar + " is ignore by disable push ");
            c.j.a.f.w wVar = new c.j.a.f.w(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(nVar.f()));
            Context context = this.f6635a;
            String b2 = c.j.a.z.f0.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            wVar.a(hashMap);
            c.j.a.m.m().a(wVar);
            return;
        }
        if (c.j.a.m.m().f() && !a(c.j.a.z.f0.d(this.f6635a), nVar.h(), nVar.g())) {
            c.j.a.f.w wVar2 = new c.j.a.f.w(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(nVar.f()));
            Context context2 = this.f6635a;
            String b3 = c.j.a.z.f0.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            wVar2.a(hashMap2);
            c.j.a.m.m().a(wVar2);
            return;
        }
        c.j.a.t.c i2 = nVar.i();
        if (i2 == null) {
            c.j.a.z.v.a("OnMessageTask", " message is null");
            return;
        }
        c.j.a.z.v.d("OnMessageTask", "tragetType is " + i2.a() + " ; target is " + i2.b());
        c.j.a.s.b(new z(this, i2));
    }
}
