package c.c.a.a.i.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class s implements c.c.b.i.d<h> {
    @Override // c.c.b.i.b
    public void a(Object obj, c.c.b.i.e eVar) throws c.c.b.i.c, IOException {
        h hVar = (h) obj;
        c.c.b.i.e eVar2 = eVar;
        eVar2.a("requestTimeMs", hVar.f()).a("requestUptimeMs", hVar.g());
        if (hVar.b() != null) {
            eVar2.a("clientInfo", hVar.b());
        }
        if (hVar.e() != null) {
            eVar2.a("logSourceName", hVar.e());
        } else {
            if (hVar.d() == Integer.MIN_VALUE) {
                throw new c.c.b.i.c("Log request must have either LogSourceName or LogSource");
            }
            eVar2.a("logSource", hVar.d());
        }
        if (hVar.c().isEmpty()) {
            return;
        }
        eVar2.a("logEvent", hVar.c());
    }
}
