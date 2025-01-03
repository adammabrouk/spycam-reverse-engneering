package c.k.d.p9;

import c.k.d.a5;
import c.k.d.e5;
import c.k.d.i3;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* loaded from: classes.dex */
public class t0 extends a5 {
    public t0(XMPushService xMPushService, Map map, int i2, String str, e5 e5Var) {
        super(map, i2, str, e5Var);
    }

    @Override // c.k.d.a5
    /* renamed from: a */
    public byte[] mo73a() {
        try {
            i3 i3Var = new i3();
            i3Var.a(h0.a().m384a());
            return i3Var.m460a();
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("getOBBString err: " + e2.toString());
            return null;
        }
    }
}
