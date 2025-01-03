package a.k.a;

import a.k.a.x;
import a.m.f;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import com.shix.shixipc.utilcode.LogUtils;

/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final j f1385a;

    /* renamed from: b, reason: collision with root package name */
    public final q f1386b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f1387c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1388d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f1389e = -1;

    /* compiled from: FragmentStateManager.java */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1390a;

        public a(p pVar, View view) {
            this.f1390a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f1390a.removeOnAttachStateChangeListener(this);
            a.h.j.y.O(this.f1390a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: FragmentStateManager.java */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1391a;

        static {
            int[] iArr = new int[f.c.values().length];
            f1391a = iArr;
            try {
                iArr[f.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1391a[f.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1391a[f.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1391a[f.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public p(j jVar, q qVar, Fragment fragment) {
        this.f1385a = jVar;
        this.f1386b = qVar;
        this.f1387c = fragment;
    }

    public void a(int i2) {
        this.f1389e = i2;
    }

    public void b() {
        int b2 = this.f1386b.b(this.f1387c);
        Fragment fragment = this.f1387c;
        fragment.mContainer.addView(fragment.mView, b2);
    }

    public void c() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        Fragment fragment2 = fragment.mTarget;
        p pVar = null;
        if (fragment2 != null) {
            p e2 = this.f1386b.e(fragment2.mWho);
            if (e2 == null) {
                throw new IllegalStateException("Fragment " + this.f1387c + " declared target fragment " + this.f1387c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f1387c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            pVar = e2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (pVar = this.f1386b.e(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f1387c + " declared target fragment " + this.f1387c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (pVar != null && (FragmentManager.P || pVar.k().mState < 1)) {
            pVar.l();
        }
        Fragment fragment4 = this.f1387c;
        fragment4.mHost = fragment4.mFragmentManager.B();
        Fragment fragment5 = this.f1387c;
        fragment5.mParentFragment = fragment5.mFragmentManager.E();
        this.f1385a.e(this.f1387c, false);
        this.f1387c.performAttach();
        this.f1385a.a(this.f1387c, false);
    }

    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f1387c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i2 = this.f1389e;
        int i3 = b.f1391a[fragment2.mMaxState.ordinal()];
        if (i3 != 1) {
            i2 = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(i2, -1) : Math.min(i2, 0) : Math.min(i2, 1) : Math.min(i2, 5);
        }
        Fragment fragment3 = this.f1387c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i2 = Math.max(this.f1389e, 2);
                View view = this.f1387c.mView;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f1389e < 4 ? Math.min(i2, fragment3.mState) : Math.min(i2, 1);
            }
        }
        if (!this.f1387c.mAdded) {
            i2 = Math.min(i2, 1);
        }
        x.e.b bVar = null;
        if (FragmentManager.P && (viewGroup = (fragment = this.f1387c).mContainer) != null) {
            bVar = x.a(viewGroup, fragment.getParentFragmentManager()).d(this);
        }
        if (bVar == x.e.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (bVar == x.e.b.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            Fragment fragment4 = this.f1387c;
            if (fragment4.mRemoving) {
                i2 = fragment4.isInBackStack() ? Math.min(i2, 1) : Math.min(i2, -1);
            }
        }
        Fragment fragment5 = this.f1387c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i2 = Math.min(i2, 4);
        }
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i2 + " for " + this.f1387c);
        }
        return i2;
    }

    public void e() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f1387c.mState = 1;
            return;
        }
        this.f1385a.c(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f1387c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        j jVar = this.f1385a;
        Fragment fragment3 = this.f1387c;
        jVar.b(fragment3, fragment3.mSavedFragmentState, false);
    }

    public void f() {
        String str;
        if (this.f1387c.mFromLayout) {
            return;
        }
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f1387c;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.mContainerId;
            if (i2 != 0) {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1387c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.x().a(this.f1387c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f1387c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.f1387c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1387c.mContainerId) + " (" + str + ") for fragment " + this.f1387c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f1387c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f1387c.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f1387c;
            fragment5.mView.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f1387c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (a.h.j.y.I(this.f1387c.mView)) {
                a.h.j.y.O(this.f1387c.mView);
            } else {
                View view2 = this.f1387c.mView;
                view2.addOnAttachStateChangeListener(new a(this, view2));
            }
            this.f1387c.performViewCreated();
            j jVar = this.f1385a;
            Fragment fragment7 = this.f1387c;
            jVar.a(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f1387c.mView.getVisibility();
            float alpha = this.f1387c.mView.getAlpha();
            if (FragmentManager.P) {
                this.f1387c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f1387c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f1387c.setFocusedView(findFocus);
                        if (FragmentManager.d(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f1387c);
                        }
                    }
                    this.f1387c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f1387c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z = true;
                }
                fragment9.mIsNewlyAdded = z;
            }
        }
        this.f1387c.mState = 2;
    }

    public void g() {
        Fragment b2;
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z2 || this.f1386b.e().f(this.f1387c))) {
            String str = this.f1387c.mTargetWho;
            if (str != null && (b2 = this.f1386b.b(str)) != null && b2.mRetainInstance) {
                this.f1387c.mTarget = b2;
            }
            this.f1387c.mState = 0;
            return;
        }
        h<?> hVar = this.f1387c.mHost;
        if (hVar instanceof a.m.w) {
            z = this.f1386b.e().d();
        } else if (hVar.c() instanceof Activity) {
            z = true ^ ((Activity) hVar.c()).isChangingConfigurations();
        }
        if (z2 || z) {
            this.f1386b.e().b(this.f1387c);
        }
        this.f1387c.performDestroy();
        this.f1385a.b(this.f1387c, false);
        for (p pVar : this.f1386b.b()) {
            if (pVar != null) {
                Fragment k = pVar.k();
                if (this.f1387c.mWho.equals(k.mTargetWho)) {
                    k.mTarget = this.f1387c;
                    k.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f1387c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f1386b.b(str2);
        }
        this.f1386b.b(this);
    }

    public void h() {
        View view;
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f1387c.performDestroyView();
        this.f1385a.i(this.f1387c, false);
        Fragment fragment2 = this.f1387c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.a((a.m.n<a.m.i>) null);
        this.f1387c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1387c);
        }
        this.f1387c.performDetach();
        boolean z = false;
        this.f1385a.c(this.f1387c, false);
        Fragment fragment = this.f1387c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.f1386b.e().f(this.f1387c)) {
            if (FragmentManager.d(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1387c);
            }
            this.f1387c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f1387c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.d(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1387c);
            }
            Fragment fragment2 = this.f1387c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f1387c.mSavedFragmentState);
            View view = this.f1387c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1387c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f1387c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f1387c.performViewCreated();
                j jVar = this.f1385a;
                Fragment fragment5 = this.f1387c;
                jVar.a(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f1387c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f1387c;
    }

    public void l() {
        if (this.f1388d) {
            if (FragmentManager.d(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f1388d = true;
            while (true) {
                int d2 = d();
                if (d2 == this.f1387c.mState) {
                    if (FragmentManager.P && this.f1387c.mHiddenChanged) {
                        if (this.f1387c.mView != null && this.f1387c.mContainer != null) {
                            x a2 = x.a(this.f1387c.mContainer, this.f1387c.getParentFragmentManager());
                            if (this.f1387c.mHidden) {
                                a2.a(this);
                            } else {
                                a2.c(this);
                            }
                        }
                        if (this.f1387c.mFragmentManager != null) {
                            this.f1387c.mFragmentManager.o(this.f1387c);
                        }
                        this.f1387c.mHiddenChanged = false;
                        this.f1387c.onHiddenChanged(this.f1387c.mHidden);
                    }
                    return;
                }
                if (d2 <= this.f1387c.mState) {
                    switch (this.f1387c.mState - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f1387c.mState = 1;
                            break;
                        case 2:
                            this.f1387c.mInLayout = false;
                            this.f1387c.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.d(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1387c);
                            }
                            if (this.f1387c.mView != null && this.f1387c.mSavedViewState == null) {
                                q();
                            }
                            if (this.f1387c.mView != null && this.f1387c.mContainer != null) {
                                x.a(this.f1387c.mContainer, this.f1387c.getParentFragmentManager()).b(this);
                            }
                            this.f1387c.mState = 3;
                            break;
                        case 4:
                            s();
                            break;
                        case 5:
                            this.f1387c.mState = 5;
                            break;
                        case 6:
                            m();
                            break;
                    }
                } else {
                    switch (this.f1387c.mState + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (this.f1387c.mView != null && this.f1387c.mContainer != null) {
                                x.a(this.f1387c.mContainer, this.f1387c.getParentFragmentManager()).a(x.e.c.from(this.f1387c.mView.getVisibility()), this);
                            }
                            this.f1387c.mState = 4;
                            break;
                        case 5:
                            r();
                            break;
                        case 6:
                            this.f1387c.mState = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
            }
        } finally {
            this.f1388d = false;
        }
    }

    public void m() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1387c);
        }
        this.f1387c.performPause();
        this.f1385a.d(this.f1387c, false);
    }

    public void n() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1387c);
        }
        View focusedView = this.f1387c.getFocusedView();
        if (focusedView != null && a(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.d(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(LogUtils.PLACEHOLDER);
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f1387c);
                sb.append(" resulting in focused view ");
                sb.append(this.f1387c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f1387c.setFocusedView(null);
        this.f1387c.performResume();
        this.f1385a.f(this.f1387c, false);
        Fragment fragment = this.f1387c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle o() {
        Bundle bundle = new Bundle();
        this.f1387c.performSaveInstanceState(bundle);
        this.f1385a.d(this.f1387c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1387c.mView != null) {
            q();
        }
        if (this.f1387c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1387c.mSavedViewState);
        }
        if (this.f1387c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f1387c.mSavedViewRegistryState);
        }
        if (!this.f1387c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1387c.mUserVisibleHint);
        }
        return bundle;
    }

    public FragmentState p() {
        FragmentState fragmentState = new FragmentState(this.f1387c);
        if (this.f1387c.mState <= -1 || fragmentState.m != null) {
            fragmentState.m = this.f1387c.mSavedFragmentState;
        } else {
            Bundle o = o();
            fragmentState.m = o;
            if (this.f1387c.mTargetWho != null) {
                if (o == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.f1387c.mTargetWho);
                int i2 = this.f1387c.mTargetRequestCode;
                if (i2 != 0) {
                    fragmentState.m.putInt("android:target_req_state", i2);
                }
            }
        }
        return fragmentState;
    }

    public void q() {
        if (this.f1387c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1387c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1387c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f1387c.mViewLifecycleOwner.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f1387c.mSavedViewRegistryState = bundle;
    }

    public void r() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1387c);
        }
        this.f1387c.performStart();
        this.f1385a.g(this.f1387c, false);
    }

    public void s() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1387c);
        }
        this.f1387c.performStop();
        this.f1385a.h(this.f1387c, false);
    }

    public void a(ClassLoader classLoader) {
        Bundle bundle = this.f1387c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1387c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1387c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f1387c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f1387c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f1387c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f1387c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f1387c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    public p(j jVar, q qVar, ClassLoader classLoader, g gVar, FragmentState fragmentState) {
        this.f1385a = jVar;
        this.f1386b = qVar;
        this.f1387c = gVar.a(classLoader, fragmentState.f2620a);
        Bundle bundle = fragmentState.j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.f1387c.setArguments(fragmentState.j);
        Fragment fragment = this.f1387c;
        fragment.mWho = fragmentState.f2621b;
        fragment.mFromLayout = fragmentState.f2622c;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.f2623d;
        fragment.mContainerId = fragmentState.f2624e;
        fragment.mTag = fragmentState.f2625f;
        fragment.mRetainInstance = fragmentState.f2626g;
        fragment.mRemoving = fragmentState.f2627h;
        fragment.mDetached = fragmentState.f2628i;
        fragment.mHidden = fragmentState.k;
        fragment.mMaxState = f.c.values()[fragmentState.l];
        Bundle bundle2 = fragmentState.m;
        if (bundle2 != null) {
            this.f1387c.mSavedFragmentState = bundle2;
        } else {
            this.f1387c.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.d(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f1387c);
        }
    }

    public void a() {
        if (FragmentManager.d(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1387c);
        }
        Fragment fragment = this.f1387c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        j jVar = this.f1385a;
        Fragment fragment2 = this.f1387c;
        jVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public final boolean a(View view) {
        if (view == this.f1387c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f1387c.mView) {
                return true;
            }
        }
        return false;
    }

    public p(j jVar, q qVar, Fragment fragment, FragmentState fragmentState) {
        this.f1385a = jVar;
        this.f1386b = qVar;
        this.f1387c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.f1387c;
        fragment3.mTarget = null;
        Bundle bundle = fragmentState.m;
        if (bundle != null) {
            fragment3.mSavedFragmentState = bundle;
        } else {
            fragment3.mSavedFragmentState = new Bundle();
        }
    }
}
