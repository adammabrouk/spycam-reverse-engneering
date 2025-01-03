package c.g.a.f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: RequestNormalPermissions.kt */
/* loaded from: classes.dex */
public final class u extends k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(p pVar) {
        super(pVar);
        f.j.b.f.c(pVar, "permissionBuilder");
    }

    @Override // c.g.a.f.l
    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6381a.f6402g) {
            if (c.g.a.b.a(this.f6381a.a(), str)) {
                this.f6381a.l.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            c();
            return;
        }
        p pVar = this.f6381a;
        if (!pVar.f6404i || (pVar.r == null && pVar.s == null)) {
            p pVar2 = this.f6381a;
            pVar2.a(pVar2.f6402g, this);
            return;
        }
        p pVar3 = this.f6381a;
        pVar3.f6404i = false;
        pVar3.m.addAll(arrayList);
        p pVar4 = this.f6381a;
        c.g.a.c.b bVar = pVar4.s;
        if (bVar != null) {
            f.j.b.f.a(bVar);
            bVar.a(b(), arrayList, true);
        } else {
            c.g.a.c.a aVar = pVar4.r;
            f.j.b.f.a(aVar);
            aVar.onExplainReason(b(), arrayList);
        }
    }

    @Override // c.g.a.f.l
    public void a(List<String> list) {
        f.j.b.f.c(list, "permissions");
        HashSet hashSet = new HashSet(this.f6381a.l);
        hashSet.addAll(list);
        if (!hashSet.isEmpty()) {
            this.f6381a.a(hashSet, this);
        } else {
            c();
        }
    }
}
