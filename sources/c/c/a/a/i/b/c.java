package c.c.a.a.i.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class c implements c.c.b.i.d<d> {
    @Override // c.c.b.i.b
    public void a(Object obj, c.c.b.i.e eVar) throws c.c.b.i.c, IOException {
        d dVar = (d) obj;
        c.c.b.i.e eVar2 = eVar;
        if (dVar.i() != Integer.MIN_VALUE) {
            eVar2.a("sdkVersion", dVar.i());
        }
        if (dVar.f() != null) {
            eVar2.a("model", dVar.f());
        }
        if (dVar.d() != null) {
            eVar2.a("hardware", dVar.d());
        }
        if (dVar.b() != null) {
            eVar2.a("device", dVar.b());
        }
        if (dVar.h() != null) {
            eVar2.a("product", dVar.h());
        }
        if (dVar.g() != null) {
            eVar2.a("osBuild", dVar.g());
        }
        if (dVar.e() != null) {
            eVar2.a("manufacturer", dVar.e());
        }
        if (dVar.c() != null) {
            eVar2.a("fingerprint", dVar.c());
        }
    }
}
