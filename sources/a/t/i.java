package a.t;

import a.t.w;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class i extends a.k.a.u {

    /* compiled from: FragmentTransitionSupport.java */
    public class a extends w.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f1813a;

        public a(i iVar, Rect rect) {
            this.f1813a = rect;
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class b implements w.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1814a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1815b;

        public b(i iVar, View view, ArrayList arrayList) {
            this.f1814a = view;
            this.f1815b = arrayList;
        }

        @Override // a.t.w.f
        public void a(w wVar) {
        }

        @Override // a.t.w.f
        public void b(w wVar) {
        }

        @Override // a.t.w.f
        public void c(w wVar) {
        }

        @Override // a.t.w.f
        public void d(w wVar) {
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            wVar.b(this);
            this.f1814a.setVisibility(8);
            int size = this.f1815b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f1815b.get(i2)).setVisibility(0);
            }
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class c extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1816a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1817b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1818c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1819d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f1820e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1821f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1816a = obj;
            this.f1817b = arrayList;
            this.f1818c = obj2;
            this.f1819d = arrayList2;
            this.f1820e = obj3;
            this.f1821f = arrayList3;
        }

        @Override // a.t.x, a.t.w.f
        public void a(w wVar) {
            Object obj = this.f1816a;
            if (obj != null) {
                i.this.a(obj, this.f1817b, (ArrayList<View>) null);
            }
            Object obj2 = this.f1818c;
            if (obj2 != null) {
                i.this.a(obj2, this.f1819d, (ArrayList<View>) null);
            }
            Object obj3 = this.f1820e;
            if (obj3 != null) {
                i.this.a(obj3, this.f1821f, (ArrayList<View>) null);
            }
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            wVar.b(this);
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class d extends w.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f1823a;

        public d(i iVar, Rect rect) {
            this.f1823a = rect;
        }
    }

    @Override // a.k.a.u
    public boolean a(Object obj) {
        return obj instanceof w;
    }

    @Override // a.k.a.u
    public Object b(Object obj) {
        if (obj != null) {
            return ((w) obj).mo3clone();
        }
        return null;
    }

    @Override // a.k.a.u
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        a0 a0Var = new a0();
        a0Var.a((w) obj);
        return a0Var;
    }

    @Override // a.k.a.u
    public void a(Object obj, ArrayList<View> arrayList) {
        w wVar = (w) obj;
        if (wVar == null) {
            return;
        }
        int i2 = 0;
        if (wVar instanceof a0) {
            a0 a0Var = (a0) wVar;
            int q = a0Var.q();
            while (i2 < q) {
                a(a0Var.a(i2), arrayList);
                i2++;
            }
            return;
        }
        if (a(wVar) || !a.k.a.u.a((List) wVar.l())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            wVar.a(arrayList.get(i2));
            i2++;
        }
    }

    @Override // a.k.a.u
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        a0 a0Var = (a0) obj;
        List<View> l = a0Var.l();
        l.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.k.a.u.a(l, arrayList.get(i2));
        }
        l.add(view);
        arrayList.add(view);
        a(a0Var, arrayList);
    }

    @Override // a.k.a.u
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((w) obj).a(new a(this, rect));
        }
    }

    @Override // a.k.a.u
    public Object b(Object obj, Object obj2, Object obj3) {
        a0 a0Var = new a0();
        if (obj != null) {
            a0Var.a((w) obj);
        }
        if (obj2 != null) {
            a0Var.a((w) obj2);
        }
        if (obj3 != null) {
            a0Var.a((w) obj3);
        }
        return a0Var;
    }

    public static boolean a(w wVar) {
        return (a.k.a.u.a((List) wVar.i()) && a.k.a.u.a((List) wVar.j()) && a.k.a.u.a((List) wVar.k())) ? false : true;
    }

    @Override // a.k.a.u
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        a0 a0Var = (a0) obj;
        if (a0Var != null) {
            a0Var.l().clear();
            a0Var.l().addAll(arrayList2);
            a((Object) a0Var, arrayList, arrayList2);
        }
    }

    @Override // a.k.a.u
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((w) obj).a(new b(this, view, arrayList));
    }

    @Override // a.k.a.u
    public Object a(Object obj, Object obj2, Object obj3) {
        w wVar = (w) obj;
        w wVar2 = (w) obj2;
        w wVar3 = (w) obj3;
        if (wVar != null && wVar2 != null) {
            a0 a0Var = new a0();
            a0Var.a(wVar);
            a0Var.a(wVar2);
            a0Var.b(1);
            wVar = a0Var;
        } else if (wVar == null) {
            wVar = wVar2 != null ? wVar2 : null;
        }
        if (wVar3 == null) {
            return wVar;
        }
        a0 a0Var2 = new a0();
        if (wVar != null) {
            a0Var2.a(wVar);
        }
        a0Var2.a(wVar3);
        return a0Var2;
    }

    @Override // a.k.a.u
    public void b(Object obj, View view) {
        if (obj != null) {
            ((w) obj).d(view);
        }
    }

    @Override // a.k.a.u
    public void a(ViewGroup viewGroup, Object obj) {
        y.a(viewGroup, (w) obj);
    }

    @Override // a.k.a.u
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((w) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // a.k.a.u
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        w wVar = (w) obj;
        int i2 = 0;
        if (wVar instanceof a0) {
            a0 a0Var = (a0) wVar;
            int q = a0Var.q();
            while (i2 < q) {
                a((Object) a0Var.a(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (a(wVar)) {
            return;
        }
        List<View> l = wVar.l();
        if (l.size() == arrayList.size() && l.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i2 < size) {
                wVar.a(arrayList2.get(i2));
                i2++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                wVar.d(arrayList.get(size2));
            }
        }
    }

    @Override // a.k.a.u
    public void a(Object obj, View view) {
        if (obj != null) {
            ((w) obj).a(view);
        }
    }

    @Override // a.k.a.u
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((w) obj).a(new d(this, rect));
        }
    }
}
