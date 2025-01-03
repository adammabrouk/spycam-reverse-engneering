package androidx.fragment.app;

import a.k.a.d;
import a.k.a.q;
import a.k.a.r;
import a.k.a.s;
import a.k.a.w;
import a.k.a.x;
import a.k.a.y;
import a.m.f;
import a.m.v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {
    public static boolean O = false;
    public static boolean P = true;
    public a.a.e.b<IntentSenderRequest> A;
    public a.a.e.b<String[]> B;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList<a.k.a.a> I;
    public ArrayList<Boolean> J;
    public ArrayList<Fragment> K;
    public ArrayList<p> L;
    public a.k.a.l M;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2580b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a.k.a.a> f2582d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f2583e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f2585g;
    public ArrayList<m> l;
    public a.k.a.h<?> r;
    public a.k.a.e s;
    public Fragment t;
    public Fragment u;
    public a.a.e.b<Intent> z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<n> f2579a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final q f2581c = new q();

    /* renamed from: f, reason: collision with root package name */
    public final a.k.a.i f2584f = new a.k.a.i(this);

    /* renamed from: h, reason: collision with root package name */
    public final a.a.b f2586h = new c(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2587i = new AtomicInteger();
    public final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
    public final Map<String, Object> k = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<a.h.f.b>> m = Collections.synchronizedMap(new HashMap());
    public final s.g n = new d();
    public final a.k.a.j o = new a.k.a.j(this);
    public final CopyOnWriteArrayList<a.k.a.m> p = new CopyOnWriteArrayList<>();
    public int q = -1;
    public a.k.a.g v = null;
    public a.k.a.g w = new e();
    public y x = null;
    public y y = new f(this);
    public ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque<>();
    public Runnable N = new g();

    /* renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    public class AnonymousClass6 implements a.m.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2588a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.k.a.o f2589b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a.m.f f2590c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f2591d;

        @Override // a.m.g
        public void a(a.m.i iVar, f.b bVar) {
            Bundle bundle;
            if (bVar == f.b.ON_START && (bundle = (Bundle) this.f2591d.j.get(this.f2588a)) != null) {
                this.f2589b.a(this.f2588a, bundle);
                this.f2591d.a(this.f2588a);
            }
            if (bVar == f.b.ON_DESTROY) {
                this.f2590c.b(this);
                this.f2591d.k.remove(this.f2588a);
            }
        }
    }

    public class a implements a.a.e.a<ActivityResult> {
        public a() {
        }

        @Override // a.a.e.a
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f2592a;
            int i2 = pollFirst.f2593b;
            Fragment d2 = FragmentManager.this.f2581c.d(str);
            if (d2 != null) {
                d2.onActivityResult(i2, activityResult.c(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public class b implements a.a.e.a<Map<String, Boolean>> {
        public b() {
        }

        @Override // a.a.e.a
        @SuppressLint({"SyntheticAccessor"})
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.f2592a;
            int i3 = pollFirst.f2593b;
            Fragment d2 = FragmentManager.this.f2581c.d(str);
            if (d2 != null) {
                d2.onRequestPermissionsResult(i3, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    public class c extends a.a.b {
        public c(boolean z) {
            super(z);
        }

        @Override // a.a.b
        public void a() {
            FragmentManager.this.H();
        }
    }

    public class d implements s.g {
        public d() {
        }

        @Override // a.k.a.s.g
        public void a(Fragment fragment, a.h.f.b bVar) {
            if (bVar.b()) {
                return;
            }
            FragmentManager.this.b(fragment, bVar);
        }

        @Override // a.k.a.s.g
        public void b(Fragment fragment, a.h.f.b bVar) {
            FragmentManager.this.a(fragment, bVar);
        }
    }

    public class e extends a.k.a.g {
        public e() {
        }

        @Override // a.k.a.g
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.B().a(FragmentManager.this.B().c(), str, (Bundle) null);
        }
    }

    public class f implements y {
        public f(FragmentManager fragmentManager) {
        }

        @Override // a.k.a.y
        public x a(ViewGroup viewGroup) {
            return new a.k.a.b(viewGroup);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.d(true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2600a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2601b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f2602c;

        public h(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2600a = viewGroup;
            this.f2601b = view;
            this.f2602c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2600a.endViewTransition(this.f2601b);
            animator.removeListener(this);
            Fragment fragment = this.f2602c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public class i implements a.k.a.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f2603a;

        public i(FragmentManager fragmentManager, Fragment fragment) {
            this.f2603a = fragment;
        }

        @Override // a.k.a.m
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f2603a.onAttachFragment(fragment);
        }
    }

    public class j implements a.a.e.a<ActivityResult> {
        public j() {
        }

        @Override // a.a.e.a
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f2592a;
            int i2 = pollFirst.f2593b;
            Fragment d2 = FragmentManager.this.f2581c.d(str);
            if (d2 != null) {
                d2.onActivityResult(i2, activityResult.c(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public static abstract class l {
        public abstract void a(FragmentManager fragmentManager, Fragment fragment);

        public abstract void a(FragmentManager fragmentManager, Fragment fragment, Context context);

        @Deprecated
        public abstract void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle);

        public abstract void a(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle);

        public abstract void b(FragmentManager fragmentManager, Fragment fragment);

        public abstract void b(FragmentManager fragmentManager, Fragment fragment, Context context);

        public abstract void b(FragmentManager fragmentManager, Fragment fragment, Bundle bundle);

        public abstract void c(FragmentManager fragmentManager, Fragment fragment);

        public abstract void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle);

        public abstract void d(FragmentManager fragmentManager, Fragment fragment);

        public abstract void d(FragmentManager fragmentManager, Fragment fragment, Bundle bundle);

        public abstract void e(FragmentManager fragmentManager, Fragment fragment);

        public abstract void f(FragmentManager fragmentManager, Fragment fragment);

        public abstract void g(FragmentManager fragmentManager, Fragment fragment);
    }

    public interface m {
        void a();
    }

    public interface n {
        boolean a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class o implements n {

        /* renamed from: a, reason: collision with root package name */
        public final String f2605a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2606b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2607c;

        public o(String str, int i2, int i3) {
            this.f2605a = str;
            this.f2606b = i2;
            this.f2607c = i3;
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.u;
            if (fragment == null || this.f2606b >= 0 || this.f2605a != null || !fragment.getChildFragmentManager().L()) {
                return FragmentManager.this.a(arrayList, arrayList2, this.f2605a, this.f2606b, this.f2607c);
            }
            return false;
        }
    }

    public static class p implements Fragment.l {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2609a;

        /* renamed from: b, reason: collision with root package name */
        public final a.k.a.a f2610b;

        /* renamed from: c, reason: collision with root package name */
        public int f2611c;

        public p(a.k.a.a aVar, boolean z) {
            this.f2609a = z;
            this.f2610b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            int i2 = this.f2611c - 1;
            this.f2611c = i2;
            if (i2 != 0) {
                return;
            }
            this.f2610b.q.O();
        }

        @Override // androidx.fragment.app.Fragment.l
        public void b() {
            this.f2611c++;
        }

        public void c() {
            a.k.a.a aVar = this.f2610b;
            aVar.q.a(aVar, this.f2609a, false, false);
        }

        public void d() {
            boolean z = this.f2611c > 0;
            for (Fragment fragment : this.f2610b.q.A()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            a.k.a.a aVar = this.f2610b;
            aVar.q.a(aVar, this.f2609a, !z, true);
        }

        public boolean e() {
            return this.f2611c == 0;
        }
    }

    public static boolean d(int i2) {
        return O || Log.isLoggable("FragmentManager", i2);
    }

    public static int e(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public List<Fragment> A() {
        return this.f2581c.d();
    }

    public a.k.a.h<?> B() {
        return this.r;
    }

    public LayoutInflater.Factory2 C() {
        return this.f2584f;
    }

    public a.k.a.j D() {
        return this.o;
    }

    public Fragment E() {
        return this.t;
    }

    public Fragment F() {
        return this.u;
    }

    public y G() {
        y yVar = this.x;
        if (yVar != null) {
            return yVar;
        }
        Fragment fragment = this.t;
        return fragment != null ? fragment.mFragmentManager.G() : this.y;
    }

    public void H() {
        d(true);
        if (this.f2586h.b()) {
            L();
        } else {
            this.f2585g.a();
        }
    }

    public boolean I() {
        return this.G;
    }

    public boolean J() {
        return this.E || this.F;
    }

    public void K() {
        if (this.r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.a(false);
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public boolean L() {
        return a((String) null, -1, 0);
    }

    public final void M() {
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.l.get(i2).a();
            }
        }
    }

    public Parcelable N() {
        int size;
        v();
        t();
        d(true);
        this.E = true;
        this.M.a(true);
        ArrayList<FragmentState> h2 = this.f2581c.h();
        BackStackState[] backStackStateArr = null;
        if (h2.isEmpty()) {
            if (d(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> i2 = this.f2581c.i();
        ArrayList<a.k.a.a> arrayList = this.f2582d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.f2582d.get(i3));
                if (d(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f2582d.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2612a = h2;
        fragmentManagerState.f2613b = i2;
        fragmentManagerState.f2614c = backStackStateArr;
        fragmentManagerState.f2615d = this.f2587i.get();
        Fragment fragment = this.u;
        if (fragment != null) {
            fragmentManagerState.f2616e = fragment.mWho;
        }
        fragmentManagerState.f2617f.addAll(this.j.keySet());
        fragmentManagerState.f2618g.addAll(this.j.values());
        fragmentManagerState.f2619h = new ArrayList<>(this.C);
        return fragmentManagerState;
    }

    public void O() {
        synchronized (this.f2579a) {
            boolean z = (this.L == null || this.L.isEmpty()) ? false : true;
            boolean z2 = this.f2579a.size() == 1;
            if (z || z2) {
                this.r.d().removeCallbacks(this.N);
                this.r.d().post(this.N);
                Q();
            }
        }
    }

    public final void P() {
        Iterator<a.k.a.p> it = this.f2581c.b().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final void Q() {
        synchronized (this.f2579a) {
            if (this.f2579a.isEmpty()) {
                this.f2586h.a(w() > 0 && r(this.t));
            } else {
                this.f2586h.a(true);
            }
        }
    }

    public void addFragmentOnAttachListener(a.k.a.m mVar) {
        this.p.add(mVar);
    }

    public void addOnBackStackChangedListener(m mVar) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(mVar);
    }

    public final void e(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            d.C0040d a2 = a.k.a.d.a(this.r.c(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (a2 == null || (animator = a2.f1359b) == null) {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.f1358a);
                    a2.f1358a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a2.f1359b.addListener(new h(this, viewGroup, view, fragment));
                }
                a2.f1359b.start();
            }
        }
        o(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public a.k.a.p f(Fragment fragment) {
        a.k.a.p e2 = this.f2581c.e(fragment.mWho);
        if (e2 != null) {
            return e2;
        }
        a.k.a.p pVar = new a.k.a.p(this.o, this.f2581c, fragment);
        pVar.a(this.r.c().getClassLoader());
        pVar.a(this.q);
        return pVar;
    }

    public final void g(Fragment fragment) {
        fragment.performDestroyView();
        this.o.i(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.a((a.m.n<a.m.i>) null);
        fragment.mInLayout = false;
    }

    public void h(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (d(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f2581c.c(fragment);
            if (p(fragment)) {
                this.D = true;
            }
            x(fragment);
        }
    }

    public void i() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(1);
    }

    public void j() {
        this.G = true;
        d(true);
        t();
        a(-1);
        this.r = null;
        this.s = null;
        this.t = null;
        if (this.f2585g != null) {
            this.f2586h.c();
            this.f2585g = null;
        }
        a.a.e.b<Intent> bVar = this.z;
        if (bVar != null) {
            bVar.a();
            this.A.a();
            this.B.a();
        }
    }

    public final a.k.a.l k(Fragment fragment) {
        return this.M.c(fragment);
    }

    public final ViewGroup l(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.s.a()) {
            View a2 = this.s.a(fragment.mContainerId);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    public v m(Fragment fragment) {
        return this.M.d(fragment);
    }

    public void n(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        x(fragment);
    }

    public void o() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(7);
    }

    public void p() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(5);
    }

    public boolean q(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean r(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.F()) && r(fragmentManager.t);
    }

    public void removeFragmentOnAttachListener(a.k.a.m mVar) {
        this.p.remove(mVar);
    }

    public void removeOnBackStackChangedListener(m mVar) {
        ArrayList<m> arrayList = this.l;
        if (arrayList != null) {
            arrayList.remove(mVar);
        }
    }

    public void s(Fragment fragment) {
        if (!this.f2581c.a(fragment.mWho)) {
            if (d(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.q + "since it is not added to " + this);
                return;
            }
            return;
        }
        t(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f2 = fragment.mPostponedAlpha;
            if (f2 > 0.0f) {
                view.setAlpha(f2);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            d.C0040d a2 = a.k.a.d.a(this.r.c(), fragment, true, fragment.getPopDirection());
            if (a2 != null) {
                Animation animation = a2.f1358a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    a2.f1359b.setTarget(fragment.mView);
                    a2.f1359b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            e(fragment);
        }
    }

    public void t(Fragment fragment) {
        a(fragment, this.q);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(RecyclerView.c0.FLAG_IGNORE);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.t)));
            sb.append("}");
        } else {
            a.k.a.h<?> hVar = this.r;
            if (hVar != null) {
                sb.append(hVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.r)));
                sb.append("}");
            } else {
                sb.append(LogUtils.NULL);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public boolean u() {
        boolean d2 = d(true);
        v();
        return d2;
    }

    public void v(Fragment fragment) {
        this.M.e(fragment);
    }

    public int w() {
        ArrayList<a.k.a.a> arrayList = this.f2582d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void x(Fragment fragment) {
        ViewGroup l2 = l(fragment);
        if (l2 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (l2.getTag(R$id.visible_removing_fragment_view_tag) == null) {
            l2.setTag(R$id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) l2.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    public void y(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public q z() {
        return this.f2581c;
    }

    public static class k extends a.a.e.d.a<IntentSenderRequest, ActivityResult> {
        @Override // a.a.e.d.a
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a2 = intentSenderRequest.a();
            if (a2 != null && (bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSenderRequest.b bVar = new IntentSenderRequest.b(intentSenderRequest.e());
                    bVar.a(null);
                    bVar.a(intentSenderRequest.d(), intentSenderRequest.c());
                    intentSenderRequest = bVar.a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // a.a.e.d.a
        public ActivityResult a(int i2, Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((n) new o(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public r b() {
        return new a.k.a.a(this);
    }

    public boolean c(int i2) {
        return this.q >= i2;
    }

    public final void d(Fragment fragment) {
        HashSet<a.h.f.b> hashSet = this.m.get(fragment);
        if (hashSet != null) {
            Iterator<a.h.f.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            g(fragment);
            this.m.remove(fragment);
        }
    }

    public void k() {
        a(1);
    }

    public void m() {
        a(5);
    }

    public void q() {
        this.F = true;
        this.M.a(true);
        a(4);
    }

    public final void t() {
        if (P) {
            Iterator<x> it = f().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.m.keySet()) {
                d(fragment);
                t(fragment);
            }
        }
    }

    public final void v() {
        if (P) {
            Iterator<x> it = f().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    public void w(Fragment fragment) {
        if (fragment == null || (fragment.equals(b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.u;
            this.u = fragment;
            j(fragment2);
            j(this.u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f2592a;

        /* renamed from: b, reason: collision with root package name */
        public int f2593b;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        }

        public LaunchedFragmentInfo(String str, int i2) {
            this.f2592a = str;
            this.f2593b = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f2592a);
            parcel.writeInt(this.f2593b);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f2592a = parcel.readString();
            this.f2593b = parcel.readInt();
        }
    }

    public void b(Fragment fragment, a.h.f.b bVar) {
        HashSet<a.h.f.b> hashSet = this.m.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.m.remove(fragment);
            if (fragment.mState < 5) {
                g(fragment);
                t(fragment);
            }
        }
    }

    public void c(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f2581c.a(fragment);
            if (d(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (p(fragment)) {
                this.D = true;
            }
        }
    }

    public void u(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.f2581c.c(fragment);
            if (p(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            x(fragment);
        }
    }

    public final boolean a(String str, int i2, int i3) {
        d(false);
        c(true);
        Fragment fragment = this.u;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().L()) {
            return true;
        }
        boolean a2 = a(this.I, this.J, str, i2, i3);
        if (a2) {
            this.f2580b = true;
            try {
                c(this.I, this.J);
            } finally {
                e();
            }
        }
        Q();
        s();
        this.f2581c.a();
        return a2;
    }

    public final Set<x> f() {
        HashSet hashSet = new HashSet();
        Iterator<a.k.a.p> it = this.f2581c.b().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(x.a(viewGroup, G()));
            }
        }
        return hashSet;
    }

    public void i(Fragment fragment) {
        Iterator<a.k.a.m> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    public void o(Fragment fragment) {
        if (fragment.mAdded && p(fragment)) {
            this.D = true;
        }
    }

    public final boolean p(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.c();
    }

    public void r() {
        a(2);
    }

    public a.k.a.g y() {
        a.k.a.g gVar = this.v;
        if (gVar != null) {
            return gVar;
        }
        Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.mFragmentManager.y();
        }
        return this.w;
    }

    public void n() {
        Q();
        j(this.u);
    }

    public void l() {
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public a.k.a.e x() {
        return this.s;
    }

    public Fragment d(String str) {
        return this.f2581c.d(str);
    }

    public void g() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(4);
    }

    public void b(Fragment fragment) {
        this.M.a(fragment);
    }

    public final void d() {
        if (J()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public Fragment b(int i2) {
        return this.f2581c.b(i2);
    }

    public void h() {
        this.E = false;
        this.F = false;
        this.M.a(false);
        a(0);
    }

    public Fragment b(String str) {
        return this.f2581c.b(str);
    }

    public Fragment c(String str) {
        return this.f2581c.c(str);
    }

    public boolean d(boolean z) {
        c(z);
        boolean z2 = false;
        while (b(this.I, this.J)) {
            this.f2580b = true;
            try {
                c(this.I, this.J);
                e();
                z2 = true;
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
        Q();
        s();
        this.f2581c.a();
        return z2;
    }

    public void b(n nVar, boolean z) {
        if (z && (this.r == null || this.G)) {
            return;
        }
        c(z);
        if (nVar.a(this.I, this.J)) {
            this.f2580b = true;
            try {
                c(this.I, this.J);
            } finally {
                e();
            }
        }
        Q();
        s();
        this.f2581c.a();
    }

    public final void c(boolean z) {
        if (!this.f2580b) {
            if (this.r == null) {
                if (this.G) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.r.d().getLooper()) {
                if (!z) {
                    d();
                }
                if (this.I == null) {
                    this.I = new ArrayList<>();
                    this.J = new ArrayList<>();
                }
                this.f2580b = true;
                try {
                    a((ArrayList<a.k.a.a>) null, (ArrayList<Boolean>) null);
                    return;
                } finally {
                    this.f2580b = false;
                }
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final void j(Fragment fragment) {
        if (fragment == null || !fragment.equals(b(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public void a(Fragment fragment, a.h.f.b bVar) {
        if (this.m.get(fragment) == null) {
            this.m.put(fragment, new HashSet<>());
        }
        this.m.get(fragment).add(bVar);
    }

    public final void a(String str) {
        this.j.remove(str);
    }

    public final void s() {
        if (this.H) {
            this.H = false;
            P();
        }
    }

    public static Fragment a(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public final void b(a.e.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment d2 = bVar.d(i2);
            if (!d2.mAdded) {
                View requireView = d2.requireView();
                d2.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    public void a(FragmentContainerView fragmentContainerView) {
        View view;
        for (a.k.a.p pVar : this.f2581c.b()) {
            Fragment k2 = pVar.k();
            if (k2.mContainerId == fragmentContainerView.getId() && (view = k2.mView) != null && view.getParent() == null) {
                k2.mContainer = fragmentContainerView;
                pVar.b();
            }
        }
    }

    public final void e() {
        this.f2580b = false;
        this.J.clear();
        this.I.clear();
    }

    public static void b(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a.k.a.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                aVar.c(i2 == i3 + (-1));
            } else {
                aVar.a(1);
                aVar.f();
            }
            i2++;
        }
    }

    public final void c(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).o) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).o) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2581c.a(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f2583e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.f2583e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<a.k.a.a> arrayList2 = this.f2582d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a.k.a.a aVar = this.f2582d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2587i.get());
        synchronized (this.f2579a) {
            int size3 = this.f2579a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    n nVar = this.f2579a.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(nVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.s);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final boolean b(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f2579a) {
            if (this.f2579a.isEmpty()) {
                return false;
            }
            int size = this.f2579a.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= this.f2579a.get(i2).a(arrayList, arrayList2);
            }
            this.f2579a.clear();
            this.r.d().removeCallbacks(this.N);
            return z;
        }
    }

    public boolean c() {
        boolean z = false;
        for (Fragment fragment : this.f2581c.c()) {
            if (fragment != null) {
                z = p(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void b(boolean z) {
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean b(Menu menu) {
        boolean z = false;
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null && q(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(a.k.a.p pVar) {
        Fragment k2 = pVar.k();
        if (k2.mDeferStart) {
            if (this.f2580b) {
                this.H = true;
                return;
            }
            k2.mDeferStart = false;
            if (P) {
                pVar.l();
            } else {
                t(k2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r2 != 5) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(androidx.fragment.app.Fragment, int):void");
    }

    public void a(Fragment fragment, boolean z) {
        ViewGroup l2 = l(fragment);
        if (l2 == null || !(l2 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) l2).setDrawDisappearingViewsLast(!z);
    }

    public void a(int i2, boolean z) {
        a.k.a.h<?> hVar;
        if (this.r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.q) {
            this.q = i2;
            if (P) {
                this.f2581c.f();
            } else {
                Iterator<Fragment> it = this.f2581c.d().iterator();
                while (it.hasNext()) {
                    s(it.next());
                }
                for (a.k.a.p pVar : this.f2581c.b()) {
                    Fragment k2 = pVar.k();
                    if (!k2.mIsNewlyAdded) {
                        s(k2);
                    }
                    if (k2.mRemoving && !k2.isInBackStack()) {
                        this.f2581c.b(pVar);
                    }
                }
            }
            P();
            if (this.D && (hVar = this.r) != null && this.q == 7) {
                hVar.g();
                this.D = false;
            }
        }
    }

    public a.k.a.p a(Fragment fragment) {
        if (d(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        a.k.a.p f2 = f(fragment);
        fragment.mFragmentManager = this;
        this.f2581c.a(f2);
        if (!fragment.mDetached) {
            this.f2581c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (p(fragment)) {
                this.D = true;
            }
        }
        return f2;
    }

    public void a(n nVar, boolean z) {
        if (!z) {
            if (this.r == null) {
                if (this.G) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            d();
        }
        synchronized (this.f2579a) {
            if (this.r == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f2579a.add(nVar);
                O();
            }
        }
    }

    public int a() {
        return this.f2587i.getAndIncrement();
    }

    public final void a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<p> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            p pVar = this.L.get(i2);
            if (arrayList != null && !pVar.f2609a && (indexOf2 = arrayList.indexOf(pVar.f2610b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.L.remove(i2);
                i2--;
                size--;
                pVar.c();
            } else if (pVar.e() || (arrayList != null && pVar.f2610b.a(arrayList, 0, arrayList.size()))) {
                this.L.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !pVar.f2609a && (indexOf = arrayList.indexOf(pVar.f2610b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                    pVar.c();
                } else {
                    pVar.d();
                }
            }
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0143  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.ArrayList<a.k.a.a> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final Set<x> a(ArrayList<a.k.a.a> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<r.a> it = arrayList.get(i2).f1395a.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f1405b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(x.a(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public final int a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.e.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a.k.a.a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.h() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                p pVar = new p(aVar, booleanValue);
                this.L.add(pVar);
                aVar.setOnStartPostponedListener(pVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.c(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    public void a(a.k.a.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.c(z3);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.q >= 1) {
            s.a(this.r.c(), this.s, arrayList, arrayList2, 0, 1, true, this.n);
        }
        if (z3) {
            a(this.q, true);
        }
        for (Fragment fragment : this.f2581c.c()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.b(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public final void a(a.e.b<Fragment> bVar) {
        int i2 = this.q;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 5);
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment.mState < min) {
                a(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    public void a(a.k.a.a aVar) {
        if (this.f2582d == null) {
            this.f2582d = new ArrayList<>();
        }
        this.f2582d.add(aVar);
    }

    public boolean a(ArrayList<a.k.a.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a.k.a.a> arrayList3 = this.f2582d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2582d.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = this.f2582d.size() - 1;
                while (size2 >= 0) {
                    a.k.a.a aVar = this.f2582d.get(size2);
                    if ((str != null && str.equals(aVar.g())) || (i2 >= 0 && i2 == aVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a.k.a.a aVar2 = this.f2582d.get(size2);
                        if (str == null || !str.equals(aVar2.g())) {
                            if (i2 < 0 || i2 != aVar2.s) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f2582d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2582d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f2582d.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public void a(Parcelable parcelable) {
        a.k.a.p pVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f2612a == null) {
            return;
        }
        this.f2581c.g();
        Iterator<FragmentState> it = fragmentManagerState.f2612a.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment b2 = this.M.b(next.f2621b);
                if (b2 != null) {
                    if (d(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + b2);
                    }
                    pVar = new a.k.a.p(this.o, this.f2581c, b2, next);
                } else {
                    pVar = new a.k.a.p(this.o, this.f2581c, this.r.c().getClassLoader(), y(), next);
                }
                Fragment k2 = pVar.k();
                k2.mFragmentManager = this;
                if (d(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k2.mWho + "): " + k2);
                }
                pVar.a(this.r.c().getClassLoader());
                this.f2581c.a(pVar);
                pVar.a(this.q);
            }
        }
        for (Fragment fragment : this.M.c()) {
            if (!this.f2581c.a(fragment.mWho)) {
                if (d(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f2612a);
                }
                this.M.e(fragment);
                fragment.mFragmentManager = this;
                a.k.a.p pVar2 = new a.k.a.p(this.o, this.f2581c, fragment);
                pVar2.a(1);
                pVar2.l();
                fragment.mRemoving = true;
                pVar2.l();
            }
        }
        this.f2581c.a(fragmentManagerState.f2613b);
        if (fragmentManagerState.f2614c != null) {
            this.f2582d = new ArrayList<>(fragmentManagerState.f2614c.length);
            int i2 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f2614c;
                if (i2 >= backStackStateArr.length) {
                    break;
                }
                a.k.a.a a2 = backStackStateArr[i2].a(this);
                if (d(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.s + "): " + a2);
                    PrintWriter printWriter = new PrintWriter(new w("FragmentManager"));
                    a2.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2582d.add(a2);
                i2++;
            }
        } else {
            this.f2582d = null;
        }
        this.f2587i.set(fragmentManagerState.f2615d);
        String str = fragmentManagerState.f2616e;
        if (str != null) {
            Fragment b3 = b(str);
            this.u = b3;
            j(b3);
        }
        ArrayList<String> arrayList = fragmentManagerState.f2617f;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundle = fragmentManagerState.f2618g.get(i3);
                bundle.setClassLoader(this.r.c().getClassLoader());
                this.j.put(arrayList.get(i3), bundle);
            }
        }
        this.C = new ArrayDeque<>(fragmentManagerState.f2619h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void a(a.k.a.h<?> hVar, a.k.a.e eVar, Fragment fragment) {
        String str;
        if (this.r == null) {
            this.r = hVar;
            this.s = eVar;
            this.t = fragment;
            if (fragment != null) {
                addFragmentOnAttachListener(new i(this, fragment));
            } else if (hVar instanceof a.k.a.m) {
                addFragmentOnAttachListener((a.k.a.m) hVar);
            }
            if (this.t != null) {
                Q();
            }
            if (hVar instanceof a.a.c) {
                a.a.c cVar = (a.a.c) hVar;
                this.f2585g = cVar.getOnBackPressedDispatcher();
                Fragment fragment2 = cVar;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                this.f2585g.a(fragment2, this.f2586h);
            }
            if (fragment != null) {
                this.M = fragment.mFragmentManager.k(fragment);
            } else if (hVar instanceof a.m.w) {
                this.M = a.k.a.l.a(((a.m.w) hVar).getViewModelStore());
            } else {
                this.M = new a.k.a.l(false);
            }
            this.M.a(J());
            this.f2581c.a(this.M);
            Object obj = this.r;
            if (obj instanceof a.a.e.c) {
                ActivityResultRegistry activityResultRegistry = ((a.a.e.c) obj).getActivityResultRegistry();
                if (fragment != null) {
                    str = fragment.mWho + ":";
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.z = activityResultRegistry.a(str2 + "StartActivityForResult", new a.a.e.d.d(), new j());
                this.A = activityResultRegistry.a(str2 + "StartIntentSenderForResult", new k(), new a());
                this.B = activityResultRegistry.a(str2 + "RequestPermissions", new a.a.e.d.b(), new b());
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.z != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.z.a(intent);
            return;
        }
        this.r.a(fragment, intent, i2, bundle);
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.A != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (d(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            } else {
                intent2 = intent;
            }
            IntentSenderRequest.b bVar = new IntentSenderRequest.b(intentSender);
            bVar.a(intent2);
            bVar.a(i4, i3);
            IntentSenderRequest a2 = bVar.a();
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            if (d(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.A.a(a2);
            return;
        }
        this.r.a(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void a(Fragment fragment, String[] strArr, int i2) {
        if (this.B != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            this.B.a(strArr);
            return;
        }
        this.r.a(fragment, strArr, i2);
    }

    public final void a(int i2) {
        try {
            this.f2580b = true;
            this.f2581c.a(i2);
            a(i2, false);
            if (P) {
                Iterator<x> it = f().iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            }
            this.f2580b = false;
            d(true);
        } catch (Throwable th) {
            this.f2580b = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null && q(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f2583e != null) {
            for (int i2 = 0; i2 < this.f2583e.size(); i2++) {
                Fragment fragment2 = this.f2583e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2583e = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.q < 1) {
            return;
        }
        for (Fragment fragment : this.f2581c.d()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void a(Fragment fragment, f.c cVar) {
        if (fragment.equals(b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }
}
