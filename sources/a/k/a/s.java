package a.k.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1412a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    public static final u f1413b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f1414c;

    /* compiled from: FragmentTransition.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f1415a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f1416b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.h.f.b f1417c;

        public a(g gVar, Fragment fragment, a.h.f.b bVar) {
            this.f1415a = gVar;
            this.f1416b = fragment;
            this.f1417c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1415a.a(this.f1416b, this.f1417c);
        }
    }

    /* compiled from: FragmentTransition.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1418a;

        public b(ArrayList arrayList) {
            this.f1418a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.a((ArrayList<View>) this.f1418a, 4);
        }
    }

    /* compiled from: FragmentTransition.java */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f1419a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f1420b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.h.f.b f1421c;

        public c(g gVar, Fragment fragment, a.h.f.b bVar) {
            this.f1419a = gVar;
            this.f1420b = fragment;
            this.f1421c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1419a.a(this.f1420b, this.f1421c);
        }
    }

    /* compiled from: FragmentTransition.java */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1422a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f1423b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1424c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Fragment f1425d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1426e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1427f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1428g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Object f1429h;

        public d(Object obj, u uVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1422a = obj;
            this.f1423b = uVar;
            this.f1424c = view;
            this.f1425d = fragment;
            this.f1426e = arrayList;
            this.f1427f = arrayList2;
            this.f1428g = arrayList3;
            this.f1429h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1422a;
            if (obj != null) {
                this.f1423b.b(obj, this.f1424c);
                this.f1427f.addAll(s.a(this.f1423b, this.f1422a, this.f1425d, (ArrayList<View>) this.f1426e, this.f1424c));
            }
            if (this.f1428g != null) {
                if (this.f1429h != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1424c);
                    this.f1423b.a(this.f1429h, this.f1428g, arrayList);
                }
                this.f1428g.clear();
                this.f1428g.add(this.f1424c);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1430a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f1431b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f1432c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a.e.a f1433d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f1434e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ u f1435f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Rect f1436g;

        public e(Fragment fragment, Fragment fragment2, boolean z, a.e.a aVar, View view, u uVar, Rect rect) {
            this.f1430a = fragment;
            this.f1431b = fragment2;
            this.f1432c = z;
            this.f1433d = aVar;
            this.f1434e = view;
            this.f1435f = uVar;
            this.f1436g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.a(this.f1430a, this.f1431b, this.f1432c, (a.e.a<String, View>) this.f1433d, false);
            View view = this.f1434e;
            if (view != null) {
                this.f1435f.a(view, this.f1436g);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f1437a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.e.a f1438b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1439c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f1440d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1441e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f1442f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Fragment f1443g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Fragment f1444h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f1445i;
        public final /* synthetic */ ArrayList j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Rect l;

        public f(u uVar, a.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1437a = uVar;
            this.f1438b = aVar;
            this.f1439c = obj;
            this.f1440d = hVar;
            this.f1441e = arrayList;
            this.f1442f = view;
            this.f1443g = fragment;
            this.f1444h = fragment2;
            this.f1445i = z;
            this.j = arrayList2;
            this.k = obj2;
            this.l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e.a<String, View> a2 = s.a(this.f1437a, (a.e.a<String, String>) this.f1438b, this.f1439c, this.f1440d);
            if (a2 != null) {
                this.f1441e.addAll(a2.values());
                this.f1441e.add(this.f1442f);
            }
            s.a(this.f1443g, this.f1444h, this.f1445i, a2, false);
            Object obj = this.f1439c;
            if (obj != null) {
                this.f1437a.b(obj, this.j, this.f1441e);
                View a3 = s.a(a2, this.f1440d, this.k, this.f1445i);
                if (a3 != null) {
                    this.f1437a.a(a3, this.l);
                }
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    public interface g {
        void a(Fragment fragment, a.h.f.b bVar);

        void b(Fragment fragment, a.h.f.b bVar);
    }

    /* compiled from: FragmentTransition.java */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f1446a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1447b;

        /* renamed from: c, reason: collision with root package name */
        public a.k.a.a f1448c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f1449d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1450e;

        /* renamed from: f, reason: collision with root package name */
        public a.k.a.a f1451f;
    }

    static {
        f1413b = Build.VERSION.SDK_INT >= 21 ? new t() : null;
        f1414c = a();
    }

    public static u a() {
        try {
            return (u) Class.forName("a.t.i").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b(ViewGroup viewGroup, h hVar, View view, a.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f1446a;
        Fragment fragment2 = hVar.f1449d;
        u a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = hVar.f1447b;
        boolean z2 = hVar.f1450e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object b3 = b(a2, viewGroup, view, aVar, hVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> a5 = a(a2, a3, fragment, arrayList, view);
        a(a5, 4);
        Object a6 = a(a2, a3, obj, b3, fragment, z);
        if (fragment2 != null && a4 != null && (a4.size() > 0 || arrayList2.size() > 0)) {
            a.h.f.b bVar = new a.h.f.b();
            gVar.b(fragment2, bVar);
            a2.a(fragment2, a6, bVar, new a(gVar, fragment2, bVar));
        }
        if (a6 != null) {
            a(a2, obj, fragment2, a4);
            ArrayList<String> a7 = a2.a(arrayList);
            a2.a(a6, a3, a5, obj, a4, b3, arrayList);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, arrayList, a7, aVar);
            a(a5, 0);
            a2.b(b3, arrayList2, arrayList);
        }
    }

    public static void a(Context context, a.k.a.e eVar, ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            a.k.a.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                b(aVar, (SparseArray<h>) sparseArray, z);
            } else {
                a(aVar, (SparseArray<h>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                a.e.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i2, i3);
                h hVar = (h) sparseArray.valueAt(i5);
                if (eVar.a() && (viewGroup = (ViewGroup) eVar.a(keyAt)) != null) {
                    if (z) {
                        b(viewGroup, hVar, view, a2, gVar);
                    } else {
                        a(viewGroup, hVar, view, a2, gVar);
                    }
                }
            }
        }
    }

    public static a.e.a<String, String> a(int i2, ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.e.a<String, String> aVar = new a.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a.k.a.a aVar2 = arrayList.get(i5);
            if (aVar2.b(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.m;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.m;
                        arrayList4 = aVar2.n;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.m;
                        arrayList3 = aVar2.n;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static Object b(u uVar, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return uVar.b(exitTransition);
    }

    public static Object b(u uVar, ViewGroup viewGroup, View view, a.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f1446a;
        Fragment fragment2 = hVar.f1449d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1447b;
        Object a2 = aVar.isEmpty() ? null : a(uVar, fragment, fragment2, z);
        a.e.a<String, View> b2 = b(uVar, aVar, a2, hVar);
        a.e.a<String, View> a3 = a(uVar, aVar, a2, hVar);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            uVar.b(obj3, view, arrayList);
            a(uVar, obj3, obj2, b2, hVar.f1450e, hVar.f1451f);
            Rect rect2 = new Rect();
            View a4 = a(a3, hVar, obj, z);
            if (a4 != null) {
                uVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        a.h.j.v.a(viewGroup, new e(fragment, fragment2, z, a3, view2, uVar, rect));
        return obj3;
    }

    public static void a(u uVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            uVar.a(obj, fragment.getView(), arrayList);
            a.h.j.v.a(fragment.mContainer, new b(arrayList));
        }
    }

    public static void a(ViewGroup viewGroup, h hVar, View view, a.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f1446a;
        Fragment fragment2 = hVar.f1449d;
        u a2 = a(fragment2, fragment);
        if (a2 == null) {
            return;
        }
        boolean z = hVar.f1447b;
        boolean z2 = hVar.f1450e;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a4 = a(a2, viewGroup, view, aVar, hVar, (ArrayList<View>) arrayList, arrayList2, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, fragment2, (ArrayList<View>) arrayList, view);
        if (a5 == null || a5.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        a2.a(a3, view);
        Object a6 = a(a2, a3, obj2, a4, fragment, hVar.f1447b);
        if (fragment2 != null && a5 != null && (a5.size() > 0 || arrayList.size() > 0)) {
            a.h.f.b bVar = new a.h.f.b();
            gVar.b(fragment2, bVar);
            a2.a(fragment2, a6, bVar, new c(gVar, fragment2, bVar));
        }
        if (a6 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a6, a3, arrayList3, obj2, a5, a4, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, a5);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar);
        }
    }

    public static a.e.a<String, View> b(u uVar, a.e.a<String, String> aVar, Object obj, h hVar) {
        a.h.a.m exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!aVar.isEmpty() && obj != null) {
            Fragment fragment = hVar.f1449d;
            a.e.a<String, View> aVar2 = new a.e.a<>();
            uVar.a((Map<String, View>) aVar2, fragment.requireView());
            a.k.a.a aVar3 = hVar.f1451f;
            if (hVar.f1450e) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.n;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.m;
            }
            if (arrayList != null) {
                aVar2.a((Collection<?>) arrayList);
            }
            if (exitTransitionCallback != null) {
                exitTransitionCallback.a(arrayList, aVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = aVar2.get(str);
                    if (view == null) {
                        aVar.remove(str);
                    } else if (!str.equals(a.h.j.y.A(view))) {
                        aVar.put(a.h.j.y.A(view), aVar.remove(str));
                    }
                }
            } else {
                aVar.a((Collection<?>) aVar2.keySet());
            }
            return aVar2;
        }
        aVar.clear();
        return null;
    }

    public static void a(u uVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        a.h.j.v.a(viewGroup, new d(obj, uVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    public static u a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        u uVar = f1413b;
        if (uVar != null && a(uVar, arrayList)) {
            return f1413b;
        }
        u uVar2 = f1414c;
        if (uVar2 != null && a(uVar2, arrayList)) {
            return f1414c;
        }
        if (f1413b == null && f1414c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(a.k.a.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.q.x().a()) {
            for (int size = aVar.f1395a.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f1395a.get(size), sparseArray, true, z);
            }
        }
    }

    public static boolean a(u uVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!uVar.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static Object a(u uVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return uVar.c(uVar.b(sharedElementEnterTransition));
    }

    public static Object a(u uVar, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return uVar.b(enterTransition);
    }

    public static void a(ArrayList<View> arrayList, a.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View e2 = aVar.e(size);
            if (collection.contains(a.h.j.y.A(e2))) {
                arrayList.add(e2);
            }
        }
    }

    public static Object a(u uVar, ViewGroup viewGroup, View view, a.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object a2;
        a.e.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f1446a;
        Fragment fragment2 = hVar.f1449d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1447b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            a2 = null;
        } else {
            a2 = a(uVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        a.e.a<String, View> b2 = b(uVar, aVar2, a2, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            uVar.b(obj3, view, arrayList);
            a(uVar, obj3, obj2, b2, hVar.f1450e, hVar.f1451f);
            if (obj != null) {
                uVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        a.h.j.v.a(viewGroup, new f(uVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    public static a.e.a<String, View> a(u uVar, a.e.a<String, String> aVar, Object obj, h hVar) {
        a.h.a.m enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = hVar.f1446a;
        View view = fragment.getView();
        if (!aVar.isEmpty() && obj != null && view != null) {
            a.e.a<String, View> aVar2 = new a.e.a<>();
            uVar.a((Map<String, View>) aVar2, view);
            a.k.a.a aVar3 = hVar.f1448c;
            if (hVar.f1447b) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = aVar3.m;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = aVar3.n;
            }
            if (arrayList != null) {
                aVar2.a((Collection<?>) arrayList);
                aVar2.a((Collection<?>) aVar.values());
            }
            if (enterTransitionCallback != null) {
                enterTransitionCallback.a(arrayList, aVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view2 = aVar2.get(str);
                    if (view2 == null) {
                        String a3 = a(aVar, str);
                        if (a3 != null) {
                            aVar.remove(a3);
                        }
                    } else if (!str.equals(a.h.j.y.A(view2)) && (a2 = a(aVar, str)) != null) {
                        aVar.put(a2, a.h.j.y.A(view2));
                    }
                }
            } else {
                a(aVar, aVar2);
            }
            return aVar2;
        }
        aVar.clear();
        return null;
    }

    public static String a(a.e.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.e(i2))) {
                return aVar.c(i2);
            }
        }
        return null;
    }

    public static View a(a.e.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        a.k.a.a aVar2 = hVar.f1448c;
        if (obj == null || aVar == null || (arrayList = aVar2.m) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.m.get(0);
        } else {
            str = aVar2.n.get(0);
        }
        return aVar.get(str);
    }

    public static void a(u uVar, Object obj, Object obj2, a.e.a<String, View> aVar, boolean z, a.k.a.a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.m;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.n.get(0);
        } else {
            str = aVar2.m.get(0);
        }
        View view = aVar.get(str);
        uVar.c(obj, view);
        if (obj2 != null) {
            uVar.c(obj2, view);
        }
    }

    public static void a(a.e.a<String, String> aVar, a.e.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.e(size))) {
                aVar.d(size);
            }
        }
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, a.e.a<String, View> aVar, boolean z2) {
        a.h.a.m enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.c(i2));
                arrayList.add(aVar.e(i2));
            }
            if (z2) {
                enterTransitionCallback.b(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.a(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    public static ArrayList<View> a(u uVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            uVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        uVar.a(obj, arrayList2);
        return arrayList2;
    }

    public static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    public static Object a(u uVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return uVar.b(obj2, obj, obj3);
        }
        return uVar.a(obj2, obj, obj3);
    }

    public static void a(a.k.a.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f1395a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(aVar, aVar.f1395a.get(i2), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if (r0.mAdded != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006e, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008a, code lost:
    
        if (r0.mHidden == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(a.k.a.a r8, a.k.a.r.a r9, android.util.SparseArray<a.k.a.s.h> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.a.s.a(a.k.a.a, a.k.a.r$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static h a(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i2, hVar2);
        return hVar2;
    }
}
