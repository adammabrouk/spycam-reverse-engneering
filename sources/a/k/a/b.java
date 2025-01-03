package a.k.a;

import a.h.f.b;
import a.h.j.a0;
import a.k.a.d;
import a.k.a.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public class b extends x {

    /* compiled from: DefaultSpecialEffectsController.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1298a;

        static {
            int[] iArr = new int[x.e.c.values().length];
            f1298a = iArr;
            try {
                iArr[x.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1298a[x.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1298a[x.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1298a[x.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: a.k.a.b$b, reason: collision with other inner class name */
    public class RunnableC0038b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f1299a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x.e f1300b;

        public RunnableC0038b(List list, x.e eVar) {
            this.f1299a = list;
            this.f1300b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1299a.contains(this.f1300b)) {
                this.f1299a.remove(this.f1300b);
                b.this.a(this.f1300b);
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1302a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1303b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f1304c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x.e f1305d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f1306e;

        public c(b bVar, ViewGroup viewGroup, View view, boolean z, x.e eVar, k kVar) {
            this.f1302a = viewGroup;
            this.f1303b = view;
            this.f1304c = z;
            this.f1305d = eVar;
            this.f1306e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1302a.endViewTransition(this.f1303b);
            if (this.f1304c) {
                this.f1305d.c().applyState(this.f1303b);
            }
            this.f1306e.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f1307a;

        public d(b bVar, Animator animator) {
            this.f1307a = animator;
        }

        @Override // a.h.f.b.a
        public void a() {
            this.f1307a.end();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1308a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1309b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f1310c;

        /* compiled from: DefaultSpecialEffectsController.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f1308a.endViewTransition(eVar.f1309b);
                e.this.f1310c.a();
            }
        }

        public e(b bVar, ViewGroup viewGroup, View view, k kVar) {
            this.f1308a = viewGroup;
            this.f1309b = view;
            this.f1310c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1308a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class f implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1312a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1313b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f1314c;

        public f(b bVar, View view, ViewGroup viewGroup, k kVar) {
            this.f1312a = view;
            this.f1313b = viewGroup;
            this.f1314c = kVar;
        }

        @Override // a.h.f.b.a
        public void a() {
            this.f1312a.clearAnimation();
            this.f1313b.endViewTransition(this.f1312a);
            this.f1314c.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x.e f1315a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x.e f1316b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f1317c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a.e.a f1318d;

        public g(b bVar, x.e eVar, x.e eVar2, boolean z, a.e.a aVar) {
            this.f1315a = eVar;
            this.f1316b = eVar2;
            this.f1317c = z;
            this.f1318d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.a(this.f1315a.d(), this.f1316b.d(), this.f1317c, (a.e.a<String, View>) this.f1318d, false);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f1319a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1320b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f1321c;

        public h(b bVar, u uVar, View view, Rect rect) {
            this.f1319a = uVar;
            this.f1320b = view;
            this.f1321c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1319a.a(this.f1320b, this.f1321c);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1322a;

        public i(b bVar, ArrayList arrayList) {
            this.f1322a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.a((ArrayList<View>) this.f1322a, 4);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f1323a;

        public j(b bVar, m mVar) {
            this.f1323a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1323a.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        public boolean f1324c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1325d;

        /* renamed from: e, reason: collision with root package name */
        public d.C0040d f1326e;

        public k(x.e eVar, a.h.f.b bVar, boolean z) {
            super(eVar, bVar);
            this.f1325d = false;
            this.f1324c = z;
        }

        public d.C0040d a(Context context) {
            if (this.f1325d) {
                return this.f1326e;
            }
            d.C0040d a2 = a.k.a.d.a(context, b().d(), b().c() == x.e.c.VISIBLE, this.f1324c);
            this.f1326e = a2;
            this.f1325d = true;
            return a2;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final x.e f1327a;

        /* renamed from: b, reason: collision with root package name */
        public final a.h.f.b f1328b;

        public l(x.e eVar, a.h.f.b bVar) {
            this.f1327a = eVar;
            this.f1328b = bVar;
        }

        public void a() {
            this.f1327a.a(this.f1328b);
        }

        public x.e b() {
            return this.f1327a;
        }

        public a.h.f.b c() {
            return this.f1328b;
        }

        public boolean d() {
            x.e.c cVar;
            x.e.c from = x.e.c.from(this.f1327a.d().mView);
            x.e.c c2 = this.f1327a.c();
            return from == c2 || !(from == (cVar = x.e.c.VISIBLE) || c2 == cVar);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        public final Object f1329c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1330d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f1331e;

        public m(x.e eVar, a.h.f.b bVar, boolean z, boolean z2) {
            super(eVar, bVar);
            if (eVar.c() == x.e.c.VISIBLE) {
                this.f1329c = z ? eVar.d().getReenterTransition() : eVar.d().getEnterTransition();
                this.f1330d = z ? eVar.d().getAllowReturnTransitionOverlap() : eVar.d().getAllowEnterTransitionOverlap();
            } else {
                this.f1329c = z ? eVar.d().getReturnTransition() : eVar.d().getExitTransition();
                this.f1330d = true;
            }
            if (!z2) {
                this.f1331e = null;
            } else if (z) {
                this.f1331e = eVar.d().getSharedElementReturnTransition();
            } else {
                this.f1331e = eVar.d().getSharedElementEnterTransition();
            }
        }

        public final u a(Object obj) {
            if (obj == null) {
                return null;
            }
            u uVar = s.f1413b;
            if (uVar != null && uVar.a(obj)) {
                return s.f1413b;
            }
            u uVar2 = s.f1414c;
            if (uVar2 != null && uVar2.a(obj)) {
                return s.f1414c;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().d() + " is not a valid framework Transition or AndroidX Transition");
        }

        public u e() {
            u a2 = a(this.f1329c);
            u a3 = a(this.f1331e);
            if (a2 == null || a3 == null || a2 == a3) {
                return a2 != null ? a2 : a3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().d() + " returned Transition " + this.f1329c + " which uses a different Transition  type than its shared element transition " + this.f1331e);
        }

        public Object f() {
            return this.f1331e;
        }

        public Object g() {
            return this.f1329c;
        }

        public boolean h() {
            return this.f1331e != null;
        }

        public boolean i() {
            return this.f1330d;
        }
    }

    public b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // a.k.a.x
    public void a(List<x.e> list, boolean z) {
        x.e eVar = null;
        x.e eVar2 = null;
        for (x.e eVar3 : list) {
            x.e.c from = x.e.c.from(eVar3.d().mView);
            int i2 = a.f1298a[eVar3.c().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (from == x.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i2 == 4 && from != x.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (x.e eVar4 : list) {
            a.h.f.b bVar = new a.h.f.b();
            eVar4.b(bVar);
            arrayList.add(new k(eVar4, bVar, z));
            a.h.f.b bVar2 = new a.h.f.b();
            eVar4.b(bVar2);
            boolean z2 = false;
            if (z) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, bVar2, z, z2));
                    eVar4.a(new RunnableC0038b(arrayList3, eVar4));
                }
                z2 = true;
                arrayList2.add(new m(eVar4, bVar2, z, z2));
                eVar4.a(new RunnableC0038b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, bVar2, z, z2));
                    eVar4.a(new RunnableC0038b(arrayList3, eVar4));
                }
                z2 = true;
                arrayList2.add(new m(eVar4, bVar2, z, z2));
                eVar4.a(new RunnableC0038b(arrayList3, eVar4));
            }
        }
        Map<x.e, Boolean> a2 = a(arrayList2, arrayList3, z, eVar, eVar2);
        a(arrayList, arrayList3, a2.containsValue(true), a2);
        Iterator<x.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        arrayList3.clear();
    }

    public final void a(List<k> list, List<x.e> list2, boolean z, Map<x.e, Boolean> map) {
        ViewGroup d2 = d();
        Context context = d2.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (k kVar : list) {
            if (kVar.d()) {
                kVar.a();
            } else {
                d.C0040d a2 = kVar.a(context);
                if (a2 == null) {
                    kVar.a();
                } else {
                    Animator animator = a2.f1359b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        x.e b2 = kVar.b();
                        Fragment d3 = b2.d();
                        if (Boolean.TRUE.equals(map.get(b2))) {
                            if (FragmentManager.d(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + d3 + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z3 = b2.c() == x.e.c.GONE;
                            if (z3) {
                                list2.remove(b2);
                            }
                            View view = d3.mView;
                            d2.startViewTransition(view);
                            animator.addListener(new c(this, d2, view, z3, b2, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().setOnCancelListener(new d(this, animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar2 = (k) it.next();
            x.e b3 = kVar2.b();
            Fragment d4 = b3.d();
            if (z) {
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + d4 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z2) {
                if (FragmentManager.d(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + d4 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = d4.mView;
                d.C0040d a3 = kVar2.a(context);
                a.h.i.h.a(a3);
                Animation animation = a3.f1358a;
                a.h.i.h.a(animation);
                Animation animation2 = animation;
                if (b3.c() != x.e.c.REMOVED) {
                    view2.startAnimation(animation2);
                    kVar2.a();
                } else {
                    d2.startViewTransition(view2);
                    d.e eVar = new d.e(animation2, d2, view2);
                    eVar.setAnimationListener(new e(this, d2, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().setOnCancelListener(new f(this, view2, d2, kVar2));
            }
        }
    }

    public final Map<x.e, Boolean> a(List<m> list, List<x.e> list2, boolean z, x.e eVar, x.e eVar2) {
        Iterator<m> it;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap hashMap;
        x.e eVar3;
        View view2;
        Object b2;
        a.e.a aVar;
        x.e eVar4;
        u uVar;
        ArrayList<View> arrayList3;
        HashMap hashMap2;
        Rect rect;
        x.e eVar5;
        View view3;
        ArrayList<View> arrayList4;
        b bVar;
        a.h.a.m enterTransitionCallback;
        a.h.a.m exitTransitionCallback;
        ArrayList<String> arrayList5;
        int i2;
        View view4;
        View view5;
        String a2;
        ArrayList<String> arrayList6;
        b bVar2 = this;
        boolean z2 = z;
        x.e eVar6 = eVar;
        x.e eVar7 = eVar2;
        HashMap hashMap3 = new HashMap();
        u uVar2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                u e2 = mVar.e();
                if (uVar2 == null) {
                    uVar2 = e2;
                } else if (e2 != null && uVar2 != e2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().d() + " returned Transition " + mVar.g() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (uVar2 == null) {
            for (m mVar2 : list) {
                hashMap3.put(mVar2.b(), false);
                mVar2.a();
            }
            return hashMap3;
        }
        View view6 = new View(d().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        a.e.a aVar2 = new a.e.a();
        Object obj3 = null;
        View view7 = null;
        boolean z3 = false;
        for (m mVar3 : list) {
            if (!mVar3.h() || eVar6 == null || eVar7 == null) {
                aVar = aVar2;
                eVar4 = eVar7;
                uVar = uVar2;
                arrayList3 = arrayList8;
                hashMap2 = hashMap3;
                rect = rect2;
                eVar5 = eVar6;
                view3 = view6;
                b bVar3 = bVar2;
                arrayList4 = arrayList7;
                bVar = bVar3;
                view7 = view7;
            } else {
                Object c2 = uVar2.c(uVar2.b(mVar3.f()));
                ArrayList<String> sharedElementSourceNames = eVar2.d().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.d().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.d().getSharedElementTargetNames();
                View view8 = view7;
                int i3 = 0;
                while (i3 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.d().getSharedElementTargetNames();
                if (!z2) {
                    enterTransitionCallback = eVar.d().getExitTransitionCallback();
                    exitTransitionCallback = eVar2.d().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = eVar.d().getEnterTransitionCallback();
                    exitTransitionCallback = eVar2.d().getExitTransitionCallback();
                }
                int i4 = 0;
                for (int size = sharedElementSourceNames.size(); i4 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                    i4++;
                }
                a.e.a<String, View> aVar3 = new a.e.a<>();
                bVar2.a(aVar3, eVar.d().mView);
                aVar3.a((Collection<?>) sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.a(sharedElementSourceNames, aVar3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = aVar3.get(str);
                        if (view9 == null) {
                            aVar2.remove(str);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str.equals(a.h.j.y.A(view9))) {
                                aVar2.put(a.h.j.y.A(view9), (String) aVar2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    aVar2.a((Collection<?>) aVar3.keySet());
                }
                a.e.a<String, View> aVar4 = new a.e.a<>();
                bVar2.a(aVar4, eVar2.d().mView);
                aVar4.a((Collection<?>) sharedElementTargetNames2);
                aVar4.a(aVar2.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.a(sharedElementTargetNames2, aVar4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = aVar4.get(str2);
                        if (view10 == null) {
                            String a3 = s.a((a.e.a<String, String>) aVar2, str2);
                            if (a3 != null) {
                                aVar2.remove(a3);
                            }
                        } else if (!str2.equals(a.h.j.y.A(view10)) && (a2 = s.a((a.e.a<String, String>) aVar2, str2)) != null) {
                            aVar2.put(a2, a.h.j.y.A(view10));
                        }
                    }
                } else {
                    s.a((a.e.a<String, String>) aVar2, aVar4);
                }
                bVar2.a(aVar3, aVar2.keySet());
                bVar2.a(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList8;
                    rect = rect2;
                    view3 = view6;
                    uVar = uVar2;
                    view7 = view8;
                    obj3 = null;
                    eVar4 = eVar2;
                    hashMap2 = hashMap3;
                    eVar5 = eVar;
                    b bVar4 = bVar2;
                    arrayList4 = arrayList7;
                    bVar = bVar4;
                } else {
                    s.a(eVar2.d(), eVar.d(), z2, aVar3, true);
                    HashMap hashMap4 = hashMap3;
                    aVar = aVar2;
                    View view11 = view6;
                    ArrayList<View> arrayList10 = arrayList8;
                    arrayList4 = arrayList7;
                    a.h.j.v.a(d(), new g(this, eVar2, eVar, z, aVar4));
                    arrayList4.addAll(aVar3.values());
                    if (arrayList5.isEmpty()) {
                        i2 = 0;
                        view7 = view8;
                    } else {
                        i2 = 0;
                        View view12 = aVar3.get(arrayList5.get(0));
                        uVar2.c(c2, view12);
                        view7 = view12;
                    }
                    arrayList10.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = aVar4.get(sharedElementTargetNames2.get(i2))) == null) {
                        bVar = this;
                        view4 = view11;
                    } else {
                        bVar = this;
                        a.h.j.v.a(d(), new h(bVar, uVar2, view5, rect2));
                        view4 = view11;
                        z3 = true;
                    }
                    uVar2.b(c2, view4, arrayList4);
                    rect = rect2;
                    view3 = view4;
                    arrayList3 = arrayList10;
                    uVar = uVar2;
                    uVar2.a(c2, null, null, null, null, c2, arrayList3);
                    eVar5 = eVar;
                    hashMap2 = hashMap4;
                    hashMap2.put(eVar5, true);
                    eVar4 = eVar2;
                    hashMap2.put(eVar4, true);
                    obj3 = c2;
                }
            }
            z2 = z;
            rect2 = rect;
            view6 = view3;
            arrayList8 = arrayList3;
            eVar6 = eVar5;
            hashMap3 = hashMap2;
            eVar7 = eVar4;
            uVar2 = uVar;
            aVar2 = aVar;
            ArrayList<View> arrayList11 = arrayList4;
            bVar2 = bVar;
            arrayList7 = arrayList11;
        }
        View view13 = view7;
        a.e.a aVar5 = aVar2;
        x.e eVar8 = eVar7;
        u uVar3 = uVar2;
        boolean z4 = false;
        ArrayList<View> arrayList12 = arrayList8;
        HashMap hashMap5 = hashMap3;
        Rect rect3 = rect2;
        x.e eVar9 = eVar6;
        View view14 = view6;
        b bVar5 = bVar2;
        ArrayList<View> arrayList13 = arrayList7;
        ArrayList arrayList14 = new ArrayList();
        Iterator<m> it2 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it2.hasNext()) {
            m next = it2.next();
            if (next.d()) {
                it = it2;
                hashMap5.put(next.b(), Boolean.valueOf(z4));
                next.a();
            } else {
                it = it2;
                Object b3 = uVar3.b(next.g());
                x.e b4 = next.b();
                boolean z5 = obj3 != null && (b4 == eVar9 || b4 == eVar8);
                if (b3 == null) {
                    if (!z5) {
                        hashMap5.put(b4, Boolean.valueOf(z4));
                        next.a();
                    }
                    arrayList = arrayList13;
                    view = view14;
                    arrayList2 = arrayList12;
                    b2 = obj4;
                    obj2 = obj5;
                    hashMap = hashMap5;
                    view2 = view13;
                } else {
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj6 = obj4;
                    bVar5.a(arrayList15, b4.d().mView);
                    if (z5) {
                        if (b4 == eVar9) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        uVar3.a(b3, view14);
                        arrayList = arrayList13;
                        view = view14;
                        arrayList2 = arrayList12;
                        eVar3 = b4;
                        obj2 = obj5;
                        hashMap = hashMap5;
                        obj = obj6;
                    } else {
                        uVar3.a(b3, arrayList15);
                        view = view14;
                        obj = obj6;
                        arrayList = arrayList13;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        hashMap = hashMap5;
                        uVar3.a(b3, b3, arrayList15, null, null, null, null);
                        if (b4.c() == x.e.c.GONE) {
                            eVar3 = b4;
                            list2.remove(eVar3);
                            ArrayList<View> arrayList16 = new ArrayList<>(arrayList15);
                            arrayList16.remove(eVar3.d().mView);
                            uVar3.a(b3, eVar3.d().mView, arrayList16);
                            a.h.j.v.a(d(), new i(bVar5, arrayList15));
                        } else {
                            eVar3 = b4;
                        }
                    }
                    if (eVar3.c() == x.e.c.VISIBLE) {
                        arrayList14.addAll(arrayList15);
                        if (z3) {
                            uVar3.a(b3, rect3);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        uVar3.c(b3, view2);
                    }
                    hashMap.put(eVar3, true);
                    if (next.i()) {
                        obj2 = uVar3.b(obj2, b3, (Object) null);
                        b2 = obj;
                    } else {
                        b2 = uVar3.b(obj, b3, (Object) null);
                    }
                }
                view13 = view2;
                obj5 = obj2;
                obj4 = b2;
                hashMap5 = hashMap;
                view14 = view;
                arrayList13 = arrayList;
                arrayList12 = arrayList2;
                z4 = false;
            }
            it2 = it;
        }
        ArrayList<View> arrayList17 = arrayList13;
        ArrayList<View> arrayList18 = arrayList12;
        HashMap hashMap6 = hashMap5;
        Object a4 = uVar3.a(obj5, obj4, obj3);
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object g2 = mVar4.g();
                x.e b5 = mVar4.b();
                boolean z6 = obj3 != null && (b5 == eVar9 || b5 == eVar8);
                if (g2 != null || z6) {
                    if (!a.h.j.y.J(d())) {
                        if (FragmentManager.d(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + d() + " has not been laid out. Completing operation " + b5);
                        }
                        mVar4.a();
                    } else {
                        uVar3.a(mVar4.b().d(), a4, mVar4.c(), new j(bVar5, mVar4));
                    }
                }
            }
        }
        if (!a.h.j.y.J(d())) {
            return hashMap6;
        }
        s.a((ArrayList<View>) arrayList14, 4);
        ArrayList<String> a5 = uVar3.a(arrayList18);
        uVar3.a(d(), a4);
        uVar3.a(d(), arrayList17, arrayList18, a5, aVar5);
        s.a((ArrayList<View>) arrayList14, 0);
        uVar3.b(obj3, arrayList17, arrayList18);
        return hashMap6;
    }

    public void a(a.e.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(a.h.j.y.A(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (a0.a(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    a(arrayList, childAt);
                }
            }
            return;
        }
        if (arrayList.contains(view)) {
            return;
        }
        arrayList.add(view);
    }

    public void a(Map<String, View> map, View view) {
        String A = a.h.j.y.A(view);
        if (A != null) {
            map.put(A, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    a(map, childAt);
                }
            }
        }
    }

    public void a(x.e eVar) {
        eVar.c().applyState(eVar.d().mView);
    }
}
