package c.c.a.a.i.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class v implements c.c.b.i.d<j> {
    @Override // c.c.b.i.b
    public void a(Object obj, c.c.b.i.e eVar) throws c.c.b.i.c, IOException {
        j jVar = (j) obj;
        c.c.b.i.e eVar2 = eVar;
        if (jVar.b() != null) {
            eVar2.a("mobileSubtype", jVar.b().name());
        }
        if (jVar.c() != null) {
            eVar2.a("networkType", jVar.c().name());
        }
    }
}
