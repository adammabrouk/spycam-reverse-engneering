package c.c.a.a.i.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class n implements c.c.b.i.d<f> {
    @Override // c.c.b.i.b
    public void a(Object obj, c.c.b.i.e eVar) throws c.c.b.i.c, IOException {
        f fVar = (f) obj;
        c.c.b.i.e eVar2 = eVar;
        if (fVar.c() != null) {
            eVar2.a("clientType", fVar.c().name());
        }
        if (fVar.b() != null) {
            eVar2.a("androidClientInfo", fVar.b());
        }
    }
}
