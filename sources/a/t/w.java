package a.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class w implements Cloneable {
    public static final int[] H = {2, 1, 3, 4};
    public static final r I = new a();
    public static ThreadLocal<a.e.a<Animator, d>> J = new ThreadLocal<>();
    public z D;
    public e E;
    public a.e.a<String, String> F;
    public ArrayList<c0> u;
    public ArrayList<c0> v;

    /* renamed from: a, reason: collision with root package name */
    public String f1894a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f1895b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f1896c = -1;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f1897d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Integer> f1898e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<View> f1899f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<String> f1900g = null;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<Class<?>> f1901h = null;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<Integer> f1902i = null;
    public ArrayList<View> j = null;
    public ArrayList<Class<?>> k = null;
    public ArrayList<String> l = null;
    public ArrayList<Integer> m = null;
    public ArrayList<View> n = null;
    public ArrayList<Class<?>> o = null;
    public d0 p = new d0();
    public d0 q = new d0();
    public a0 r = null;
    public int[] t = H;
    public boolean w = false;
    public ArrayList<Animator> x = new ArrayList<>();
    public int y = 0;
    public boolean z = false;
    public boolean A = false;
    public ArrayList<f> B = null;
    public ArrayList<Animator> C = new ArrayList<>();
    public r G = I;

    /* compiled from: Transition.java */
    public static class a extends r {
        @Override // a.t.r
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* compiled from: Transition.java */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.e.a f1903a;

        public b(a.e.a aVar) {
            this.f1903a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1903a.remove(animator);
            w.this.x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.x.add(animator);
        }
    }

    /* compiled from: Transition.java */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.a();
            animator.removeListener(this);
        }
    }

    /* compiled from: Transition.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public View f1906a;

        /* renamed from: b, reason: collision with root package name */
        public String f1907b;

        /* renamed from: c, reason: collision with root package name */
        public c0 f1908c;

        /* renamed from: d, reason: collision with root package name */
        public w0 f1909d;

        /* renamed from: e, reason: collision with root package name */
        public w f1910e;

        public d(View view, String str, w wVar, w0 w0Var, c0 c0Var) {
            this.f1906a = view;
            this.f1907b = str;
            this.f1908c = c0Var;
            this.f1909d = w0Var;
            this.f1910e = wVar;
        }
    }

    /* compiled from: Transition.java */
    public static abstract class e {
    }

    /* compiled from: Transition.java */
    public interface f {
        void a(w wVar);

        void b(w wVar);

        void c(w wVar);

        void d(w wVar);

        void e(w wVar);
    }

    public static a.e.a<Animator, d> p() {
        a.e.a<Animator, d> aVar = J.get();
        if (aVar != null) {
            return aVar;
        }
        a.e.a<Animator, d> aVar2 = new a.e.a<>();
        J.set(aVar2);
        return aVar2;
    }

    public w a(long j) {
        this.f1896c = j;
        return this;
    }

    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        return null;
    }

    public abstract void a(c0 c0Var);

    public long b() {
        return this.f1896c;
    }

    public c0 c(View view, boolean z) {
        a0 a0Var = this.r;
        if (a0Var != null) {
            return a0Var.c(view, z);
        }
        return (z ? this.p : this.q).f1777a.get(view);
    }

    public abstract void c(c0 c0Var);

    public void cancel() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.B.clone();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((f) arrayList2.get(i2)).b(this);
        }
    }

    public TimeInterpolator d() {
        return this.f1897d;
    }

    public void e(View view) {
        if (this.z) {
            if (!this.A) {
                a.e.a<Animator, d> p = p();
                int size = p.size();
                w0 d2 = m0.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d e2 = p.e(i2);
                    if (e2.f1906a != null && d2.equals(e2.f1909d)) {
                        a.t.a.b(p.c(i2));
                    }
                }
                ArrayList<f> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((f) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public r f() {
        return this.G;
    }

    public z g() {
        return this.D;
    }

    public long h() {
        return this.f1895b;
    }

    public List<Integer> i() {
        return this.f1898e;
    }

    public List<String> j() {
        return this.f1900g;
    }

    public List<Class<?>> k() {
        return this.f1901h;
    }

    public List<View> l() {
        return this.f1899f;
    }

    public String[] m() {
        return null;
    }

    public void n() {
        o();
        a.e.a<Animator, d> p = p();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (p.containsKey(next)) {
                o();
                a(next, p);
            }
        }
        this.C.clear();
        a();
    }

    public void o() {
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).a(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public String toString() {
        return a("");
    }

    public w a(TimeInterpolator timeInterpolator) {
        this.f1897d = timeInterpolator;
        return this;
    }

    public w b(long j) {
        this.f1895b = j;
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public w mo3clone() {
        try {
            w wVar = (w) super.clone();
            wVar.C = new ArrayList<>();
            wVar.p = new d0();
            wVar.q = new d0();
            wVar.u = null;
            wVar.v = null;
            return wVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public w d(View view) {
        this.f1899f.remove(view);
        return this;
    }

    public final void a(a.e.a<View, c0> aVar, a.e.a<View, c0> aVar2, a.e.d<View> dVar, a.e.d<View> dVar2) {
        View a2;
        int c2 = dVar.c();
        for (int i2 = 0; i2 < c2; i2++) {
            View c3 = dVar.c(i2);
            if (c3 != null && b(c3) && (a2 = dVar2.a(dVar.a(i2))) != null && b(a2)) {
                c0 c0Var = aVar.get(c3);
                c0 c0Var2 = aVar2.get(a2);
                if (c0Var != null && c0Var2 != null) {
                    this.u.add(c0Var);
                    this.v.add(c0Var2);
                    aVar.remove(c3);
                    aVar2.remove(a2);
                }
            }
        }
    }

    public final void b(a.e.a<View, c0> aVar, a.e.a<View, c0> aVar2) {
        c0 remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (c2 != null && b(c2) && (remove = aVar2.remove(c2)) != null && b(remove.f1753b)) {
                this.u.add(aVar.d(size));
                this.v.add(remove);
            }
        }
    }

    public void c(View view) {
        if (this.A) {
            return;
        }
        a.e.a<Animator, d> p = p();
        int size = p.size();
        w0 d2 = m0.d(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d e2 = p.e(i2);
            if (e2.f1906a != null && d2.equals(e2.f1909d)) {
                a.t.a.a(p.c(i2));
            }
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((f) arrayList2.get(i3)).c(this);
            }
        }
        this.z = true;
    }

    public boolean b(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f1902i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.k.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.l != null && a.h.j.y.A(view) != null && this.l.contains(a.h.j.y.A(view))) {
            return false;
        }
        if ((this.f1898e.size() == 0 && this.f1899f.size() == 0 && (((arrayList = this.f1901h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f1900g) == null || arrayList2.isEmpty()))) || this.f1898e.contains(Integer.valueOf(id)) || this.f1899f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f1900g;
        if (arrayList6 != null && arrayList6.contains(a.h.j.y.A(view))) {
            return true;
        }
        if (this.f1901h != null) {
            for (int i3 = 0; i3 < this.f1901h.size(); i3++) {
                if (this.f1901h.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(a.e.a<View, c0> aVar, a.e.a<View, c0> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                c0 c0Var = aVar.get(valueAt);
                c0 c0Var2 = aVar2.get(view);
                if (c0Var != null && c0Var2 != null) {
                    this.u.add(c0Var);
                    this.v.add(c0Var2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public String e() {
        return this.f1894a;
    }

    public e c() {
        return this.E;
    }

    public final void a(a.e.a<View, c0> aVar, a.e.a<View, c0> aVar2, a.e.a<String, View> aVar3, a.e.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View e2 = aVar3.e(i2);
            if (e2 != null && b(e2) && (view = aVar4.get(aVar3.c(i2))) != null && b(view)) {
                c0 c0Var = aVar.get(e2);
                c0 c0Var2 = aVar2.get(view);
                if (c0Var != null && c0Var2 != null) {
                    this.u.add(c0Var);
                    this.v.add(c0Var2);
                    aVar.remove(e2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public c0 b(View view, boolean z) {
        a0 a0Var = this.r;
        if (a0Var != null) {
            return a0Var.b(view, z);
        }
        ArrayList<c0> arrayList = z ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            c0 c0Var = arrayList.get(i3);
            if (c0Var == null) {
                return null;
            }
            if (c0Var.f1753b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.v : this.u).get(i2);
        }
        return null;
    }

    public final void a(a.e.a<View, c0> aVar, a.e.a<View, c0> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            c0 e2 = aVar.e(i2);
            if (b(e2.f1753b)) {
                this.u.add(e2);
                this.v.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            c0 e3 = aVar2.e(i3);
            if (b(e3.f1753b)) {
                this.v.add(e3);
                this.u.add(null);
            }
        }
    }

    public w b(f fVar) {
        ArrayList<f> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public void b(c0 c0Var) {
        String[] a2;
        if (this.D == null || c0Var.f1752a.isEmpty() || (a2 = this.D.a()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= a2.length) {
                z = true;
                break;
            } else if (!c0Var.f1752a.containsKey(a2[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.D.a(c0Var);
    }

    public final void a(d0 d0Var, d0 d0Var2) {
        a.e.a<View, c0> aVar = new a.e.a<>(d0Var.f1777a);
        a.e.a<View, c0> aVar2 = new a.e.a<>(d0Var2.f1777a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.t;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    b(aVar, aVar2);
                } else if (i3 == 2) {
                    a(aVar, aVar2, d0Var.f1780d, d0Var2.f1780d);
                } else if (i3 == 3) {
                    a(aVar, aVar2, d0Var.f1778b, d0Var2.f1778b);
                } else if (i3 == 4) {
                    a(aVar, aVar2, d0Var.f1779c, d0Var2.f1779c);
                }
                i2++;
            } else {
                a(aVar, aVar2);
                return;
            }
        }
    }

    public void a(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList<c0> arrayList, ArrayList<c0> arrayList2) {
        Animator a2;
        int i2;
        int i3;
        View view;
        Animator animator;
        c0 c0Var;
        Animator animator2;
        c0 c0Var2;
        a.e.a<Animator, d> p = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = RecyclerView.FOREVER_NS;
        int i4 = 0;
        while (i4 < size) {
            c0 c0Var3 = arrayList.get(i4);
            c0 c0Var4 = arrayList2.get(i4);
            if (c0Var3 != null && !c0Var3.f1754c.contains(this)) {
                c0Var3 = null;
            }
            if (c0Var4 != null && !c0Var4.f1754c.contains(this)) {
                c0Var4 = null;
            }
            if (c0Var3 != null || c0Var4 != null) {
                if ((c0Var3 == null || c0Var4 == null || a(c0Var3, c0Var4)) && (a2 = a(viewGroup, c0Var3, c0Var4)) != null) {
                    if (c0Var4 != null) {
                        view = c0Var4.f1753b;
                        String[] m = m();
                        if (m != null && m.length > 0) {
                            c0Var2 = new c0(view);
                            i2 = size;
                            c0 c0Var5 = d0Var2.f1777a.get(view);
                            if (c0Var5 != null) {
                                int i5 = 0;
                                while (i5 < m.length) {
                                    c0Var2.f1752a.put(m[i5], c0Var5.f1752a.get(m[i5]));
                                    i5++;
                                    i4 = i4;
                                    c0Var5 = c0Var5;
                                }
                            }
                            i3 = i4;
                            int size2 = p.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                d dVar = p.get(p.c(i6));
                                if (dVar.f1908c != null && dVar.f1906a == view && dVar.f1907b.equals(e()) && dVar.f1908c.equals(c0Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i2 = size;
                            i3 = i4;
                            animator2 = a2;
                            c0Var2 = null;
                        }
                        animator = animator2;
                        c0Var = c0Var2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = c0Var3.f1753b;
                        animator = a2;
                        c0Var = null;
                    }
                    if (animator != null) {
                        z zVar = this.D;
                        if (zVar != null) {
                            long a3 = zVar.a(viewGroup, this, c0Var3, c0Var4);
                            sparseIntArray.put(this.C.size(), (int) a3);
                            j = Math.min(a3, j);
                        }
                        p.put(animator, new d(view, e(), this, m0.d(viewGroup), c0Var));
                        this.C.add(animator);
                        j = j;
                    }
                    i4 = i3 + 1;
                    size = i2;
                }
            }
            i2 = size;
            i3 = i4;
            i4 = i3 + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j) + animator3.getStartDelay());
            }
        }
    }

    public final void a(Animator animator, a.e.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            a(animator);
        }
    }

    public w a(View view) {
        this.f1899f.add(view);
        return this;
    }

    public void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        a.e.a<String, String> aVar;
        a(z);
        if ((this.f1898e.size() <= 0 && this.f1899f.size() <= 0) || (((arrayList = this.f1900g) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f1901h) != null && !arrayList2.isEmpty()))) {
            a((View) viewGroup, z);
        } else {
            for (int i2 = 0; i2 < this.f1898e.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f1898e.get(i2).intValue());
                if (findViewById != null) {
                    c0 c0Var = new c0(findViewById);
                    if (z) {
                        c(c0Var);
                    } else {
                        a(c0Var);
                    }
                    c0Var.f1754c.add(this);
                    b(c0Var);
                    if (z) {
                        a(this.p, findViewById, c0Var);
                    } else {
                        a(this.q, findViewById, c0Var);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f1899f.size(); i3++) {
                View view = this.f1899f.get(i3);
                c0 c0Var2 = new c0(view);
                if (z) {
                    c(c0Var2);
                } else {
                    a(c0Var2);
                }
                c0Var2.f1754c.add(this);
                b(c0Var2);
                if (z) {
                    a(this.p, view, c0Var2);
                } else {
                    a(this.q, view, c0Var2);
                }
            }
        }
        if (z || (aVar = this.F) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.p.f1780d.remove(this.F.c(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.p.f1780d.put(this.F.e(i5), view2);
            }
        }
    }

    public static void a(d0 d0Var, View view, c0 c0Var) {
        d0Var.f1777a.put(view, c0Var);
        int id = view.getId();
        if (id >= 0) {
            if (d0Var.f1778b.indexOfKey(id) >= 0) {
                d0Var.f1778b.put(id, null);
            } else {
                d0Var.f1778b.put(id, view);
            }
        }
        String A = a.h.j.y.A(view);
        if (A != null) {
            if (d0Var.f1780d.containsKey(A)) {
                d0Var.f1780d.put(A, null);
            } else {
                d0Var.f1780d.put(A, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (d0Var.f1779c.b(itemIdAtPosition) >= 0) {
                    View a2 = d0Var.f1779c.a(itemIdAtPosition);
                    if (a2 != null) {
                        a.h.j.y.c(a2, false);
                        d0Var.f1779c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                a.h.j.y.c(view, true);
                d0Var.f1779c.c(itemIdAtPosition, view);
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            this.p.f1777a.clear();
            this.p.f1778b.clear();
            this.p.f1779c.a();
        } else {
            this.q.f1777a.clear();
            this.q.f1778b.clear();
            this.q.f1779c.a();
        }
    }

    public final void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f1902i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.k.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    c0 c0Var = new c0(view);
                    if (z) {
                        c(c0Var);
                    } else {
                        a(c0Var);
                    }
                    c0Var.f1754c.add(this);
                    b(c0Var);
                    if (z) {
                        a(this.p, view, c0Var);
                    } else {
                        a(this.q, view, c0Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.o.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                a(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        a(this.p, this.q);
        a.e.a<Animator, d> p = p();
        int size = p.size();
        w0 d2 = m0.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator c2 = p.c(i2);
            if (c2 != null && (dVar = p.get(c2)) != null && dVar.f1906a != null && d2.equals(dVar.f1909d)) {
                c0 c0Var = dVar.f1908c;
                View view = dVar.f1906a;
                c0 c3 = c(view, true);
                c0 b2 = b(view, true);
                if (c3 == null && b2 == null) {
                    b2 = this.q.f1777a.get(view);
                }
                if (!(c3 == null && b2 == null) && dVar.f1910e.a(c0Var, b2)) {
                    if (!c2.isRunning() && !c2.isStarted()) {
                        p.remove(c2);
                    } else {
                        c2.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.p, this.q, this.u, this.v);
        n();
    }

    public boolean a(c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null) {
            return false;
        }
        String[] m = m();
        if (m != null) {
            for (String str : m) {
                if (!a(c0Var, c0Var2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = c0Var.f1752a.keySet().iterator();
        while (it.hasNext()) {
            if (a(c0Var, c0Var2, it.next())) {
            }
        }
        return false;
        return true;
    }

    public static boolean a(c0 c0Var, c0 c0Var2, String str) {
        Object obj = c0Var.f1752a.get(str);
        Object obj2 = c0Var2.f1752a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (h() >= 0) {
            animator.setStartDelay(h() + animator.getStartDelay());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void a() {
        int i2 = this.y - 1;
        this.y = i2;
        if (i2 == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((f) arrayList2.get(i3)).e(this);
                }
            }
            for (int i4 = 0; i4 < this.p.f1779c.c(); i4++) {
                View c2 = this.p.f1779c.c(i4);
                if (c2 != null) {
                    a.h.j.y.c(c2, false);
                }
            }
            for (int i5 = 0; i5 < this.q.f1779c.c(); i5++) {
                View c3 = this.q.f1779c.c(i5);
                if (c3 != null) {
                    a.h.j.y.c(c3, false);
                }
            }
            this.A = true;
        }
    }

    public w a(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(fVar);
        return this;
    }

    public void a(r rVar) {
        if (rVar == null) {
            this.G = I;
        } else {
            this.G = rVar;
        }
    }

    public void a(e eVar) {
        this.E = eVar;
    }

    public void a(z zVar) {
        this.D = zVar;
    }

    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f1896c != -1) {
            str2 = str2 + "dur(" + this.f1896c + ") ";
        }
        if (this.f1895b != -1) {
            str2 = str2 + "dly(" + this.f1895b + ") ";
        }
        if (this.f1897d != null) {
            str2 = str2 + "interp(" + this.f1897d + ") ";
        }
        if (this.f1898e.size() <= 0 && this.f1899f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f1898e.size() > 0) {
            for (int i2 = 0; i2 < this.f1898e.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f1898e.get(i2);
            }
        }
        if (this.f1899f.size() > 0) {
            for (int i3 = 0; i3 < this.f1899f.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f1899f.get(i3);
            }
        }
        return str3 + ")";
    }
}
