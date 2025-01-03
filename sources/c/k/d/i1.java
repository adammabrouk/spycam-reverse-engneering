package c.k.d;

import c.k.d.h1;
import c.k.d.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i1 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h1 f7236a;

    public i1(h1 h1Var) {
        this.f7236a = h1Var;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 100957;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<h1.a> arrayList6;
        arrayList = this.f7236a.f7196e;
        synchronized (arrayList) {
            arrayList2 = this.f7236a.f7196e;
            if (arrayList2.size() > 0) {
                arrayList3 = this.f7236a.f7196e;
                if (arrayList3.size() > 1) {
                    h1 h1Var = this.f7236a;
                    arrayList6 = this.f7236a.f7196e;
                    h1Var.a(arrayList6);
                } else {
                    h1 h1Var2 = this.f7236a;
                    arrayList4 = this.f7236a.f7196e;
                    h1Var2.b((h1.a) arrayList4.get(0));
                }
                arrayList5 = this.f7236a.f7196e;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
