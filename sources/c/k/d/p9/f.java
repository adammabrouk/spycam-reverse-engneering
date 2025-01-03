package c.k.d.p9;

import c.k.d.p6;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f7586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7587b;

    public f(List list, boolean z) {
        this.f7586a = list;
        this.f7587b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        boolean b3;
        b2 = e.b("www.baidu.com:80");
        Iterator it = this.f7586a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!b2) {
                b3 = e.b(str);
                if (!b3) {
                    b2 = false;
                    if (!b2 && !this.f7587b) {
                        break;
                    }
                }
            }
            b2 = true;
            if (!b2) {
            }
        }
        p6.a(b2 ? 1 : 2);
    }
}
