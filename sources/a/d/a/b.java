package a.d.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
public class b implements e {
    @Override // a.d.a.e
    public void a() {
    }

    @Override // a.d.a.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        dVar.a(new f(colorStateList, f2));
        View a2 = dVar.a();
        a2.setClipToOutline(true);
        a2.setElevation(f3);
        c(dVar, f4);
    }

    @Override // a.d.a.e
    public void b(d dVar, float f2) {
        dVar.a().setElevation(f2);
    }

    @Override // a.d.a.e
    public void c(d dVar, float f2) {
        j(dVar).a(f2, dVar.c(), dVar.b());
        d(dVar);
    }

    @Override // a.d.a.e
    public void d(d dVar) {
        if (!dVar.c()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float a2 = a(dVar);
        float e2 = e(dVar);
        int ceil = (int) Math.ceil(g.a(a2, e2, dVar.b()));
        int ceil2 = (int) Math.ceil(g.b(a2, e2, dVar.b()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // a.d.a.e
    public float e(d dVar) {
        return j(dVar).c();
    }

    @Override // a.d.a.e
    public float f(d dVar) {
        return e(dVar) * 2.0f;
    }

    @Override // a.d.a.e
    public float g(d dVar) {
        return e(dVar) * 2.0f;
    }

    @Override // a.d.a.e
    public void h(d dVar) {
        c(dVar, a(dVar));
    }

    @Override // a.d.a.e
    public void i(d dVar) {
        c(dVar, a(dVar));
    }

    public final f j(d dVar) {
        return (f) dVar.d();
    }

    @Override // a.d.a.e
    public ColorStateList b(d dVar) {
        return j(dVar).a();
    }

    @Override // a.d.a.e
    public float c(d dVar) {
        return dVar.a().getElevation();
    }

    @Override // a.d.a.e
    public void a(d dVar, float f2) {
        j(dVar).a(f2);
    }

    @Override // a.d.a.e
    public float a(d dVar) {
        return j(dVar).b();
    }

    @Override // a.d.a.e
    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).b(colorStateList);
    }
}
