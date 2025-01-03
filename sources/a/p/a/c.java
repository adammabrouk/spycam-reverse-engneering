package a.p.a;

import a.h.j.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class c extends o {
    public static TimeInterpolator s;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<RecyclerView.c0> f1595h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<RecyclerView.c0> f1596i = new ArrayList<>();
    public ArrayList<j> j = new ArrayList<>();
    public ArrayList<i> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.c0>> l = new ArrayList<>();
    public ArrayList<ArrayList<j>> m = new ArrayList<>();
    public ArrayList<ArrayList<i>> n = new ArrayList<>();
    public ArrayList<RecyclerView.c0> o = new ArrayList<>();
    public ArrayList<RecyclerView.c0> p = new ArrayList<>();
    public ArrayList<RecyclerView.c0> q = new ArrayList<>();
    public ArrayList<RecyclerView.c0> r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1597a;

        public a(ArrayList arrayList) {
            this.f1597a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1597a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.b(jVar.f1631a, jVar.f1632b, jVar.f1633c, jVar.f1634d, jVar.f1635e);
            }
            this.f1597a.clear();
            c.this.m.remove(this.f1597a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1599a;

        public b(ArrayList arrayList) {
            this.f1599a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1599a.iterator();
            while (it.hasNext()) {
                c.this.a((i) it.next());
            }
            this.f1599a.clear();
            c.this.n.remove(this.f1599a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.p.a.c$c, reason: collision with other inner class name */
    public class RunnableC0049c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1601a;

        public RunnableC0049c(ArrayList arrayList) {
            this.f1601a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1601a.iterator();
            while (it.hasNext()) {
                c.this.t((RecyclerView.c0) it.next());
            }
            this.f1601a.clear();
            c.this.l.remove(this.f1601a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1603a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1604b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1605c;

        public d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1603a = c0Var;
            this.f1604b = viewPropertyAnimator;
            this.f1605c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1604b.setListener(null);
            this.f1605c.setAlpha(1.0f);
            c.this.l(this.f1603a);
            c.this.q.remove(this.f1603a);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.m(this.f1603a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1607a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1608b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1609c;

        public e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1607a = c0Var;
            this.f1608b = view;
            this.f1609c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1608b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1609c.setListener(null);
            c.this.h(this.f1607a);
            c.this.o.remove(this.f1607a);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.i(this.f1607a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1611a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1612b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1613c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1614d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1615e;

        public f(RecyclerView.c0 c0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1611a = c0Var;
            this.f1612b = i2;
            this.f1613c = view;
            this.f1614d = i3;
            this.f1615e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1612b != 0) {
                this.f1613c.setTranslationX(0.0f);
            }
            if (this.f1614d != 0) {
                this.f1613c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1615e.setListener(null);
            c.this.j(this.f1611a);
            c.this.p.remove(this.f1611a);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.k(this.f1611a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1617a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1618b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1619c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1617a = iVar;
            this.f1618b = viewPropertyAnimator;
            this.f1619c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1618b.setListener(null);
            this.f1619c.setAlpha(1.0f);
            this.f1619c.setTranslationX(0.0f);
            this.f1619c.setTranslationY(0.0f);
            c.this.a(this.f1617a.f1625a, true);
            c.this.r.remove(this.f1617a.f1625a);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(this.f1617a.f1625a, true);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1621a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1622b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1623c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1621a = iVar;
            this.f1622b = viewPropertyAnimator;
            this.f1623c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1622b.setListener(null);
            this.f1623c.setAlpha(1.0f);
            this.f1623c.setTranslationX(0.0f);
            this.f1623c.setTranslationY(0.0f);
            c.this.a(this.f1621a.f1626b, false);
            c.this.r.remove(this.f1621a.f1626b);
            c.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.b(this.f1621a.f1626b, false);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f1631a;

        /* renamed from: b, reason: collision with root package name */
        public int f1632b;

        /* renamed from: c, reason: collision with root package name */
        public int f1633c;

        /* renamed from: d, reason: collision with root package name */
        public int f1634d;

        /* renamed from: e, reason: collision with root package name */
        public int f1635e;

        public j(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
            this.f1631a = c0Var;
            this.f1632b = i2;
            this.f1633c = i3;
            this.f1634d = i4;
            this.f1635e = i5;
        }
    }

    @Override // a.p.a.o
    public boolean a(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
        View view = c0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) c0Var.itemView.getTranslationY());
        v(c0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(c0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(c0Var, translationX, translationY, i4, i5));
        return true;
    }

    public void b(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
        View view = c0Var.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(c0Var);
        animate.setDuration(e()).setListener(new f(c0Var, i6, view, i7, animate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void c(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.j.get(size).f1631a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(c0Var);
                this.j.remove(size);
            }
        }
        a(this.k, c0Var);
        if (this.f1595h.remove(c0Var)) {
            view.setAlpha(1.0f);
            l(c0Var);
        }
        if (this.f1596i.remove(c0Var)) {
            view.setAlpha(1.0f);
            h(c0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.n.get(size2);
            a(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f1631a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.c0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                h(c0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(c0Var);
        this.o.remove(c0Var);
        this.r.remove(c0Var);
        this.p.remove(c0Var);
        j();
    }

    @Override // a.p.a.o
    public boolean f(RecyclerView.c0 c0Var) {
        v(c0Var);
        c0Var.itemView.setAlpha(0.0f);
        this.f1596i.add(c0Var);
        return true;
    }

    @Override // a.p.a.o
    public boolean g(RecyclerView.c0 c0Var) {
        v(c0Var);
        this.f1595h.add(c0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void i() {
        boolean z = !this.f1595h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.f1596i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.c0> it = this.f1595h.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.f1595h.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    y.a(arrayList.get(0).f1631a.itemView, aVar, f());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    y.a(arrayList2.get(0).f1625a.itemView, bVar, f());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.c0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1596i);
                this.l.add(arrayList3);
                this.f1596i.clear();
                RunnableC0049c runnableC0049c = new RunnableC0049c(arrayList3);
                if (z || z2 || z3) {
                    y.a(arrayList3.get(0).itemView, runnableC0049c, (z ? f() : 0L) + Math.max(z2 ? e() : 0L, z3 ? d() : 0L));
                } else {
                    runnableC0049c.run();
                }
            }
        }
    }

    public void j() {
        if (g()) {
            return;
        }
        a();
    }

    public void t(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(c0Var);
        animate.alpha(1.0f).setDuration(c()).setListener(new e(c0Var, view, animate)).start();
    }

    public final void u(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.q.add(c0Var);
        animate.setDuration(f()).alpha(0.0f).setListener(new d(c0Var, animate, view)).start();
    }

    public final void v(RecyclerView.c0 c0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        c0Var.itemView.animate().setInterpolator(s);
        c(c0Var);
    }

    /* compiled from: DefaultItemAnimator.java */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f1625a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.c0 f1626b;

        /* renamed from: c, reason: collision with root package name */
        public int f1627c;

        /* renamed from: d, reason: collision with root package name */
        public int f1628d;

        /* renamed from: e, reason: collision with root package name */
        public int f1629e;

        /* renamed from: f, reason: collision with root package name */
        public int f1630f;

        public i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            this.f1625a = c0Var;
            this.f1626b = c0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1625a + ", newHolder=" + this.f1626b + ", fromX=" + this.f1627c + ", fromY=" + this.f1628d + ", toX=" + this.f1629e + ", toY=" + this.f1630f + '}';
        }

        public i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i2, int i3, int i4, int i5) {
            this(c0Var, c0Var2);
            this.f1627c = i2;
            this.f1628d = i3;
            this.f1629e = i4;
            this.f1630f = i5;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g() {
        return (this.f1596i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.f1595h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public final void b(i iVar) {
        RecyclerView.c0 c0Var = iVar.f1625a;
        if (c0Var != null) {
            a(iVar, c0Var);
        }
        RecyclerView.c0 c0Var2 = iVar.f1626b;
        if (c0Var2 != null) {
            a(iVar, c0Var2);
        }
    }

    @Override // a.p.a.o
    public boolean a(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i2, int i3, int i4, int i5) {
        if (c0Var == c0Var2) {
            return a(c0Var, i2, i3, i4, i5);
        }
        float translationX = c0Var.itemView.getTranslationX();
        float translationY = c0Var.itemView.getTranslationY();
        float alpha = c0Var.itemView.getAlpha();
        v(c0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        c0Var.itemView.setTranslationX(translationX);
        c0Var.itemView.setTranslationY(translationY);
        c0Var.itemView.setAlpha(alpha);
        if (c0Var2 != null) {
            v(c0Var2);
            c0Var2.itemView.setTranslationX(-i6);
            c0Var2.itemView.setTranslationY(-i7);
            c0Var2.itemView.setAlpha(0.0f);
        }
        this.k.add(new i(c0Var, c0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void b() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.j.get(size);
            View view = jVar.f1631a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(jVar.f1631a);
            this.j.remove(size);
        }
        for (int size2 = this.f1595h.size() - 1; size2 >= 0; size2--) {
            l(this.f1595h.get(size2));
            this.f1595h.remove(size2);
        }
        int size3 = this.f1596i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.c0 c0Var = this.f1596i.get(size3);
            c0Var.itemView.setAlpha(1.0f);
            h(c0Var);
            this.f1596i.remove(size3);
        }
        for (int size4 = this.k.size() - 1; size4 >= 0; size4--) {
            b(this.k.get(size4));
        }
        this.k.clear();
        if (g()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f1631a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(jVar2.f1631a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.c0> arrayList2 = this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.c0 c0Var2 = arrayList2.get(size8);
                    c0Var2.itemView.setAlpha(1.0f);
                    h(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            a(this.q);
            a(this.p);
            a(this.o);
            a(this.r);
            a();
        }
    }

    public void a(i iVar) {
        RecyclerView.c0 c0Var = iVar.f1625a;
        View view = c0Var == null ? null : c0Var.itemView;
        RecyclerView.c0 c0Var2 = iVar.f1626b;
        View view2 = c0Var2 != null ? c0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(d());
            this.r.add(iVar.f1625a);
            duration.translationX(iVar.f1629e - iVar.f1627c);
            duration.translationY(iVar.f1630f - iVar.f1628d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.r.add(iVar.f1626b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(d()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    public final void a(List<i> list, RecyclerView.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (a(iVar, c0Var) && iVar.f1625a == null && iVar.f1626b == null) {
                list.remove(iVar);
            }
        }
    }

    public final boolean a(i iVar, RecyclerView.c0 c0Var) {
        boolean z = false;
        if (iVar.f1626b == c0Var) {
            iVar.f1626b = null;
        } else {
            if (iVar.f1625a != c0Var) {
                return false;
            }
            iVar.f1625a = null;
            z = true;
        }
        c0Var.itemView.setAlpha(1.0f);
        c0Var.itemView.setTranslationX(0.0f);
        c0Var.itemView.setTranslationY(0.0f);
        a(c0Var, z);
        return true;
    }

    public void a(List<RecyclerView.c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.c0 c0Var, List<Object> list) {
        return !list.isEmpty() || super.a(c0Var, list);
    }
}
