package c.c.a.a.i.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class q implements c.c.b.i.d<g> {
    @Override // c.c.b.i.b
    public void a(Object obj, c.c.b.i.e eVar) throws c.c.b.i.c, IOException {
        g gVar = (g) obj;
        c.c.b.i.e eVar2 = eVar;
        eVar2.a("eventTimeMs", gVar.a()).a("eventUptimeMs", gVar.b()).a("timezoneOffsetSeconds", gVar.c());
        if (gVar.f() != null) {
            eVar2.a("sourceExtension", gVar.f());
        }
        if (gVar.g() != null) {
            eVar2.a("sourceExtensionJsonProto3", gVar.g());
        }
        if (gVar.d() != Integer.MIN_VALUE) {
            eVar2.a("eventCode", gVar.d());
        }
        if (gVar.e() != null) {
            eVar2.a("networkConnectionInfo", gVar.e());
        }
    }
}
