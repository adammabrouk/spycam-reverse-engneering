package c.k.d.p9;

import android.util.Base64;
import c.k.d.g3;
import c.k.d.m;
import c.k.d.p9.h0;
import c.k.d.q9;
import java.util.List;

/* loaded from: classes.dex */
public class i0 extends m.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7604a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f7605b;

    public i0(h0 h0Var) {
        this.f7605b = h0Var;
    }

    @Override // c.k.d.m.b
    public void b() {
        try {
            g3 a2 = g3.a(Base64.decode(c.k.d.y1.a(q9.m432a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<c.k.d.d0>) null), 10));
            if (a2 != null) {
                this.f7605b.f7598b = a2;
                this.f7604a = true;
                this.f7605b.e();
            }
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("fetch config failure: " + e2.getMessage());
        }
    }

    @Override // c.k.d.m.b
    public void c() {
        List list;
        List list2;
        h0.a[] aVarArr;
        g3 g3Var;
        this.f7605b.f7599c = null;
        if (this.f7604a) {
            synchronized (this.f7605b) {
                list = this.f7605b.f7597a;
                list2 = this.f7605b.f7597a;
                aVarArr = (h0.a[]) list.toArray(new h0.a[list2.size()]);
            }
            for (h0.a aVar : aVarArr) {
                g3Var = this.f7605b.f7598b;
                aVar.a(g3Var);
            }
        }
    }
}
