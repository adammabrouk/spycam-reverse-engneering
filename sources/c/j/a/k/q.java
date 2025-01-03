package c.j.a.k;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* loaded from: classes.dex */
public final class q extends i0 {
    public q(c.j.a.v vVar) {
        super(vVar);
    }

    @Override // c.j.a.r
    public final void a(c.j.a.v vVar) {
        c.j.a.f.s sVar = (c.j.a.f.s) vVar;
        ArrayList<String> f2 = sVar.f();
        List<String> g2 = sVar.g();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int e2 = sVar.e();
        String d2 = sVar.d();
        if (f2 != null) {
            for (String str : f2) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (g2 != null) {
            for (String str2 : g2) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                c.j.a.m.m().b(arrayList);
            }
            c.j.a.m.m().a(sVar.d(), arrayList3.size() > 0 ? 10000 : e2);
            c.j.a.s.b(new r(this, e2, arrayList, arrayList3, d2));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                c.j.a.m.m().c(arrayList2);
            }
            c.j.a.m.m().a(sVar.d(), e2);
            c.j.a.s.b(new s(this, e2, arrayList2, arrayList4, d2));
        }
    }
}
