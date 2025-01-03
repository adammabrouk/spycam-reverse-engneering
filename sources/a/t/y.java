package a.t;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static w f1911a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<a.e.a<ViewGroup, ArrayList<w>>>> f1912b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f1913c = new ArrayList<>();

    /* compiled from: TransitionManager.java */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public w f1914a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f1915b;

        /* compiled from: TransitionManager.java */
        /* renamed from: a.t.y$a$a, reason: collision with other inner class name */
        public class C0055a extends x {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a.e.a f1916a;

            public C0055a(a.e.a aVar) {
                this.f1916a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // a.t.w.f
            public void e(w wVar) {
                ((ArrayList) this.f1916a.get(a.this.f1915b)).remove(wVar);
                wVar.b(this);
            }
        }

        public a(w wVar, ViewGroup viewGroup) {
            this.f1914a = wVar;
            this.f1915b = viewGroup;
        }

        public final void a() {
            this.f1915b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1915b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!y.f1913c.remove(this.f1915b)) {
                return true;
            }
            a.e.a<ViewGroup, ArrayList<w>> a2 = y.a();
            ArrayList<w> arrayList = a2.get(this.f1915b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                a2.put(this.f1915b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1914a);
            this.f1914a.a(new C0055a(a2));
            this.f1914a.a(this.f1915b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).e(this.f1915b);
                }
            }
            this.f1914a.a(this.f1915b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            y.f1913c.remove(this.f1915b);
            ArrayList<w> arrayList = y.a().get(this.f1915b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<w> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f1915b);
                }
            }
            this.f1914a.a(true);
        }
    }

    public static a.e.a<ViewGroup, ArrayList<w>> a() {
        a.e.a<ViewGroup, ArrayList<w>> aVar;
        WeakReference<a.e.a<ViewGroup, ArrayList<w>>> weakReference = f1912b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        a.e.a<ViewGroup, ArrayList<w>> aVar2 = new a.e.a<>();
        f1912b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void b(ViewGroup viewGroup, w wVar) {
        if (wVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(wVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void c(ViewGroup viewGroup, w wVar) {
        ArrayList<w> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<w> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (wVar != null) {
            wVar.a(viewGroup, true);
        }
        v a2 = v.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, w wVar) {
        if (f1913c.contains(viewGroup) || !a.h.j.y.J(viewGroup)) {
            return;
        }
        f1913c.add(viewGroup);
        if (wVar == null) {
            wVar = f1911a;
        }
        w mo3clone = wVar.mo3clone();
        c(viewGroup, mo3clone);
        v.a(viewGroup, null);
        b(viewGroup, mo3clone);
    }
}
