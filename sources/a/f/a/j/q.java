package a.f.a.j;

import java.util.ArrayList;

/* compiled from: WidgetContainer.java */
/* loaded from: classes.dex */
public class q extends f {
    public ArrayList<f> k0 = new ArrayList<>();

    @Override // a.f.a.j.f
    public void E() {
        this.k0.clear();
        super.E();
    }

    @Override // a.f.a.j.f
    public void I() {
        super.I();
        ArrayList<f> arrayList = this.k0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.k0.get(i2);
            fVar.b(h(), i());
            if (!(fVar instanceof g)) {
                fVar.I();
            }
        }
    }

    public g K() {
        f l = l();
        g gVar = this instanceof g ? (g) this : null;
        while (l != null) {
            f l2 = l.l();
            if (l instanceof g) {
                gVar = (g) l;
            }
            l = l2;
        }
        return gVar;
    }

    public void L() {
        I();
        ArrayList<f> arrayList = this.k0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.k0.get(i2);
            if (fVar instanceof q) {
                ((q) fVar).L();
            }
        }
    }

    public void M() {
        this.k0.clear();
    }

    @Override // a.f.a.j.f
    public void a(a.f.a.c cVar) {
        super.a(cVar);
        int size = this.k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k0.get(i2).a(cVar);
        }
    }

    public void b(f fVar) {
        this.k0.add(fVar);
        if (fVar.l() != null) {
            ((q) fVar.l()).c(fVar);
        }
        fVar.a((f) this);
    }

    public void c(f fVar) {
        this.k0.remove(fVar);
        fVar.a((f) null);
    }

    @Override // a.f.a.j.f
    public void b(int i2, int i3) {
        super.b(i2, i3);
        int size = this.k0.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.k0.get(i4).b(p(), q());
        }
    }
}
