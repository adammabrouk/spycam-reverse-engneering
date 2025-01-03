package c.j.a.k;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: OnUndoMsgReceiveTask.java */
/* loaded from: classes.dex */
public final class g extends i0 {
    public g(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.t tVar = (c.j.a.f.t) vVar;
        if (c.j.a.m.m().f() && !a(c.j.a.z.f0.d(this.f6635a), tVar.i(), tVar.g())) {
            c.j.a.z.v.d("OnUndoMsgTask", " vertify msg is error ");
            c.j.a.f.w wVar = new c.j.a.f.w(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(tVar.f()));
            Context context = this.f6635a;
            String b2 = c.j.a.z.f0.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            wVar.a(hashMap);
            c.j.a.m.m().a(wVar);
            return;
        }
        boolean a2 = c.j.a.z.d.a(this.f6635a, tVar.h());
        c.j.a.z.v.d("OnUndoMsgTask", "undo message " + tVar.h() + ", " + a2);
        if (a2) {
            c.j.a.z.v.b(this.f6635a, "回收client通知成功, 上报埋点 1031, messageId = " + tVar.h());
            c.j.a.z.k.a(this.f6635a, tVar.h(), 1031L);
            return;
        }
        c.j.a.z.v.d("OnUndoMsgTask", "undo message fail，messageId = " + tVar.h());
        c.j.a.z.v.c(this.f6635a, "回收client通知失败，messageId = " + tVar.h());
    }
}
