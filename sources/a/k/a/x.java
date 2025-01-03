package a.k.a;

import a.h.f.b;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: SpecialEffectsController.java */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f1478a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<e> f1479b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<e> f1480c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f1481d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1482e = false;

    /* compiled from: SpecialEffectsController.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1483a;

        public a(d dVar) {
            this.f1483a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.f1479b.contains(this.f1483a)) {
                this.f1483a.c().applyState(this.f1483a.d().mView);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1485a;

        public b(d dVar) {
            this.f1485a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.f1479b.remove(this.f1485a);
            x.this.f1480c.remove(this.f1485a);
        }
    }

    /* compiled from: SpecialEffectsController.java */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1487a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1488b;

        static {
            int[] iArr = new int[e.b.values().length];
            f1488b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1488b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1488b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f1487a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1487a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1487a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1487a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    public static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        public final p f1489h;

        public d(e.c cVar, e.b bVar, p pVar, a.h.f.b bVar2) {
            super(cVar, bVar, pVar.k(), bVar2);
            this.f1489h = pVar;
        }

        @Override // a.k.a.x.e
        public void b() {
            super.b();
            this.f1489h.l();
        }

        @Override // a.k.a.x.e
        public void h() {
            if (e() == e.b.ADDING) {
                Fragment k = this.f1489h.k();
                View findFocus = k.mView.findFocus();
                if (findFocus != null) {
                    k.setFocusedView(findFocus);
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k);
                    }
                }
                View requireView = d().requireView();
                if (requireView.getParent() == null) {
                    this.f1489h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k.getPostOnViewCreatedAlpha());
            }
        }
    }

    public x(ViewGroup viewGroup) {
        this.f1478a = viewGroup;
    }

    public static x a(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return a(viewGroup, fragmentManager.G());
    }

    public abstract void a(List<e> list, boolean z);

    public final e b(Fragment fragment) {
        Iterator<e> it = this.f1480c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.d().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    public void c(p pVar) {
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + pVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, pVar);
    }

    public ViewGroup d() {
        return this.f1478a;
    }

    public void e() {
        synchronized (this.f1479b) {
            f();
            this.f1482e = false;
            int size = this.f1479b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f1479b.get(size);
                e.c from = e.c.from(eVar.d().mView);
                if (eVar.c() == e.c.VISIBLE && from != e.c.VISIBLE) {
                    this.f1482e = eVar.d().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void f() {
        Iterator<e> it = this.f1479b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.e() == e.b.ADDING) {
                next.a(e.c.from(next.d().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public c f1490a;

        /* renamed from: b, reason: collision with root package name */
        public b f1491b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f1492c;

        /* renamed from: d, reason: collision with root package name */
        public final List<Runnable> f1493d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final HashSet<a.h.f.b> f1494e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        public boolean f1495f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f1496g = false;

        /* compiled from: SpecialEffectsController.java */
        public class a implements b.a {
            public a() {
            }

            @Override // a.h.f.b.a
            public void a() {
                e.this.a();
            }
        }

        /* compiled from: SpecialEffectsController.java */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public e(c cVar, b bVar, Fragment fragment, a.h.f.b bVar2) {
            this.f1490a = cVar;
            this.f1491b = bVar;
            this.f1492c = fragment;
            bVar2.setOnCancelListener(new a());
        }

        public final void a() {
            if (f()) {
                return;
            }
            this.f1495f = true;
            if (this.f1494e.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(this.f1494e).iterator();
            while (it.hasNext()) {
                ((a.h.f.b) it.next()).a();
            }
        }

        public final void b(a.h.f.b bVar) {
            h();
            this.f1494e.add(bVar);
        }

        public c c() {
            return this.f1490a;
        }

        public final Fragment d() {
            return this.f1492c;
        }

        public b e() {
            return this.f1491b;
        }

        public final boolean f() {
            return this.f1495f;
        }

        public final boolean g() {
            return this.f1496g;
        }

        public void h() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1490a + "} {mLifecycleImpact = " + this.f1491b + "} {mFragment = " + this.f1492c + "}";
        }

        /* compiled from: SpecialEffectsController.java */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c from(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            public void applyState(View view) {
                int i2 = c.f1487a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.d(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i2 != 4) {
                    return;
                }
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }

            public static c from(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }
        }

        public void b() {
            if (this.f1496g) {
                return;
            }
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1496g = true;
            Iterator<Runnable> it = this.f1493d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void a(c cVar, b bVar) {
            int i2 = c.f1488b[bVar.ordinal()];
            if (i2 == 1) {
                if (this.f1490a == c.REMOVED) {
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1492c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1491b + " to ADDING.");
                    }
                    this.f1490a = c.VISIBLE;
                    this.f1491b = b.ADDING;
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3 && this.f1490a != c.REMOVED) {
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1492c + " mFinalState = " + this.f1490a + " -> " + cVar + ". ");
                    }
                    this.f1490a = cVar;
                    return;
                }
                return;
            }
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1492c + " mFinalState = " + this.f1490a + " -> REMOVED. mLifecycleImpact  = " + this.f1491b + " to REMOVING.");
            }
            this.f1490a = c.REMOVED;
            this.f1491b = b.REMOVING;
        }

        public final void a(Runnable runnable) {
            this.f1493d.add(runnable);
        }

        public final void a(a.h.f.b bVar) {
            if (this.f1494e.remove(bVar) && this.f1494e.isEmpty()) {
                b();
            }
        }
    }

    public e.b d(p pVar) {
        e a2 = a(pVar.k());
        e.b e2 = a2 != null ? a2.e() : null;
        e b2 = b(pVar.k());
        return (b2 == null || !(e2 == null || e2 == e.b.NONE)) ? e2 : b2.e();
    }

    public static x a(ViewGroup viewGroup, y yVar) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof x) {
            return (x) tag;
        }
        x a2 = yVar.a(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, a2);
        return a2;
    }

    public void b(p pVar) {
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + pVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, pVar);
    }

    public void c() {
        if (this.f1482e) {
            this.f1482e = false;
            a();
        }
    }

    public final e a(Fragment fragment) {
        Iterator<e> it = this.f1479b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.d().equals(fragment) && !next.f()) {
                return next;
            }
        }
        return null;
    }

    public void b() {
        String str;
        String str2;
        boolean I = a.h.j.y.I(this.f1478a);
        synchronized (this.f1479b) {
            f();
            Iterator<e> it = this.f1479b.iterator();
            while (it.hasNext()) {
                it.next().h();
            }
            Iterator it2 = new ArrayList(this.f1480c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (FragmentManager.d(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (I) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f1478a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.a();
            }
            Iterator it3 = new ArrayList(this.f1479b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (FragmentManager.d(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (I) {
                        str = "";
                    } else {
                        str = "Container " + this.f1478a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.a();
            }
        }
    }

    public void a(e.c cVar, p pVar) {
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + pVar.k());
        }
        a(cVar, e.b.ADDING, pVar);
    }

    public void a(p pVar) {
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + pVar.k());
        }
        a(e.c.GONE, e.b.NONE, pVar);
    }

    public final void a(e.c cVar, e.b bVar, p pVar) {
        synchronized (this.f1479b) {
            a.h.f.b bVar2 = new a.h.f.b();
            e a2 = a(pVar.k());
            if (a2 != null) {
                a2.a(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, pVar, bVar2);
            this.f1479b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    public void a(boolean z) {
        this.f1481d = z;
    }

    public void a() {
        if (this.f1482e) {
            return;
        }
        if (!a.h.j.y.I(this.f1478a)) {
            b();
            this.f1481d = false;
            return;
        }
        synchronized (this.f1479b) {
            if (!this.f1479b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f1480c);
                this.f1480c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (FragmentManager.d(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                    }
                    eVar.a();
                    if (!eVar.g()) {
                        this.f1480c.add(eVar);
                    }
                }
                f();
                ArrayList arrayList2 = new ArrayList(this.f1479b);
                this.f1479b.clear();
                this.f1480c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).h();
                }
                a(arrayList2, this.f1481d);
                this.f1481d = false;
            }
        }
    }
}
