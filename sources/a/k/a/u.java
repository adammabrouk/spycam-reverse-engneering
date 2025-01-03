package a.k.a;

import a.h.j.a0;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class u {

    /* compiled from: FragmentTransitionImpl.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1464a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1465b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1466c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1467d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1468e;

        public a(u uVar, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1464a = i2;
            this.f1465b = arrayList;
            this.f1466c = arrayList2;
            this.f1467d = arrayList3;
            this.f1468e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f1464a; i2++) {
                a.h.j.y.a((View) this.f1465b.get(i2), (String) this.f1466c.get(i2));
                a.h.j.y.a((View) this.f1467d.get(i2), (String) this.f1468e.get(i2));
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1469a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f1470b;

        public b(u uVar, ArrayList arrayList, Map map) {
            this.f1469a = arrayList;
            this.f1470b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1469a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f1469a.get(i2);
                String A = a.h.j.y.A(view);
                if (A != null) {
                    a.h.j.y.a(view, u.a((Map<String, String>) this.f1470b, A));
                }
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1471a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f1472b;

        public c(u uVar, ArrayList arrayList, Map map) {
            this.f1471a = arrayList;
            this.f1472b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1471a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f1471a.get(i2);
                a.h.j.y.a(view, (String) this.f1472b.get(a.h.j.y.A(view)));
            }
        }
    }

    public abstract Object a(Object obj, Object obj2, Object obj3);

    public void a(View view, Rect rect) {
        if (a.h.j.y.I(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object c(Object obj);

    public abstract void c(Object obj, View view);

    public ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(a.h.j.y.A(view));
            a.h.j.y.a(view, (String) null);
        }
        return arrayList2;
    }

    public void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String A = a.h.j.y.A(view2);
            arrayList4.add(A);
            if (A != null) {
                a.h.j.y.a(view2, (String) null);
                String str = map.get(A);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i3))) {
                        a.h.j.y.a(arrayList2.get(i3), A);
                        break;
                    }
                    i3++;
                }
            }
        }
        a.h.j.v.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (a0.a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String A = a.h.j.y.A(view);
            if (A != null) {
                map.put(A, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public void a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        a.h.j.v.a(view, new b(this, arrayList, map));
    }

    public void a(Fragment fragment, Object obj, a.h.f.b bVar, Runnable runnable) {
        runnable.run();
    }

    public void a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        a.h.j.v.a(viewGroup, new c(this, arrayList, map));
    }

    public static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        if (a.h.j.y.A(view) != null) {
            list.add(view);
        }
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!a(list, childAt, size) && a.h.j.y.A(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean a(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
