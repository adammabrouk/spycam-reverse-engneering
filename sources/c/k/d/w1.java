package c.k.d;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class w1 extends p1 {
    public p1 n;
    public final /* synthetic */ p1 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w1(u1 u1Var, String str, p1 p1Var) {
        super(str);
        this.o = p1Var;
        p1 p1Var2 = this.o;
        this.n = p1Var2;
        this.f7481d = this.f7481d;
        if (p1Var2 != null) {
            this.f7485h = p1Var2.f7485h;
        }
    }

    @Override // c.k.d.p1
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.n != null) {
            arrayList.addAll(this.n.a(true));
        }
        synchronized (u1.f7912g) {
            p1 p1Var = u1.f7912g.get(this.f7481d);
            if (p1Var != null) {
                Iterator<String> it = p1Var.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f7481d);
                arrayList.add(this.f7481d);
            }
        }
        return arrayList;
    }

    @Override // c.k.d.p1
    public synchronized void a(String str, o1 o1Var) {
        if (this.n != null) {
            this.n.a(str, o1Var);
        }
    }

    @Override // c.k.d.p1
    public boolean b() {
        return false;
    }
}
