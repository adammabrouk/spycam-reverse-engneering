package c.j.a;

import android.content.Intent;
import c.j.a.f.j;
import c.j.a.f.k;
import c.j.a.f.t;
import c.j.a.k.h;
import c.j.a.k.i0;

/* compiled from: PushClientFactory.java */
/* loaded from: classes.dex */
public final class l implements b {
    public l() {
        new h();
    }

    @Override // c.j.a.b
    public final v a(Intent intent) {
        v tVar;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            tVar = new t();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    tVar = new c.j.a.f.s(intExtra);
                    break;
                case 3:
                    tVar = new c.j.a.f.n();
                    break;
                case 4:
                    tVar = new c.j.a.f.p();
                    break;
                case 5:
                    tVar = new c.j.a.f.o();
                    break;
                case 6:
                    tVar = new c.j.a.f.q();
                    break;
                case 7:
                    tVar = new c.j.a.f.m();
                    break;
                case 8:
                    tVar = new c.j.a.f.l();
                    break;
                case 9:
                    tVar = new j();
                    break;
                case 10:
                case 11:
                    tVar = new c.j.a.f.h(intExtra);
                    break;
                case 12:
                    tVar = new c.j.a.f.i();
                    break;
                default:
                    tVar = null;
                    break;
            }
        } else {
            tVar = new k();
        }
        if (tVar != null) {
            e a2 = e.a(intent);
            if (a2 == null) {
                c.j.a.z.v.b("PushCommand", "bundleWapper is null");
            } else {
                tVar.b(a2);
            }
        }
        return tVar;
    }

    @Override // c.j.a.b
    public final r b(v vVar) {
        return h.a(vVar);
    }

    @Override // c.j.a.b
    public final i0 a(v vVar) {
        return h.b(vVar);
    }
}
