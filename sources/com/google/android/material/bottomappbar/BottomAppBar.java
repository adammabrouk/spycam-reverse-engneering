package com.google.android.material.bottomappbar;

import a.h.j.g0;
import a.h.j.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.a.k;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final int m0 = R$style.Widget_MaterialComponents_BottomAppBar;
    public final int Q;
    public final c.c.a.c.w.h R;
    public Animator S;
    public Animator T;
    public int U;
    public int V;
    public boolean W;
    public final boolean a0;
    public final boolean b0;
    public final boolean c0;
    public int d0;
    public ArrayList<i> e0;
    public boolean f0;
    public Behavior g0;
    public int h0;
    public int i0;
    public int j0;
    public AnimatorListenerAdapter k0;
    public k<FloatingActionButton> l0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public int f10329c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10330d;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10329c);
            parcel.writeInt(this.f10330d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10329c = parcel.readInt();
            this.f10330d = parcel.readInt() != 0;
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.a(bottomAppBar.U, BottomAppBar.this.f0);
        }
    }

    public class b implements k<FloatingActionButton> {
        public b() {
        }

        @Override // c.c.a.c.a.k
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.this.R.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // c.c.a.c.a.k
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().f() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().e(translationX);
                BottomAppBar.this.R.invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().b() != max) {
                BottomAppBar.this.getTopEdgeTreatment().a(max);
                BottomAppBar.this.R.invalidateSelf();
            }
            BottomAppBar.this.R.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    public class c implements r.e {
        public c() {
        }

        @Override // c.c.a.c.r.r.e
        public g0 a(View view, g0 g0Var, r.f fVar) {
            boolean z;
            if (BottomAppBar.this.a0) {
                BottomAppBar.this.h0 = g0Var.e();
            }
            boolean z2 = false;
            if (BottomAppBar.this.b0) {
                z = BottomAppBar.this.j0 != g0Var.f();
                BottomAppBar.this.j0 = g0Var.f();
            } else {
                z = false;
            }
            if (BottomAppBar.this.c0) {
                boolean z3 = BottomAppBar.this.i0 != g0Var.g();
                BottomAppBar.this.i0 = g0Var.g();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.s();
                BottomAppBar.this.z();
                BottomAppBar.this.y();
            }
            return g0Var;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.t();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.u();
        }
    }

    public class e extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f10335a;

        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.t();
            }
        }

        public e(int i2) {
            this.f10335a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.d(this.f10335a));
            floatingActionButton.show(new a());
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.t();
            BottomAppBar.this.T = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.u();
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10339a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f10340b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f10341c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f10342d;

        public g(ActionMenuView actionMenuView, int i2, boolean z) {
            this.f10340b = actionMenuView;
            this.f10341c = i2;
            this.f10342d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10339a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f10339a) {
                return;
            }
            BottomAppBar.this.b(this.f10340b, this.f10341c, this.f10342d);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.k0.onAnimationStart(animator);
            FloatingActionButton v = BottomAppBar.this.v();
            if (v != null) {
                v.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public interface i {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.h0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return d(this.U);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.i0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.c.a.c.d.a getTopEdgeTreatment() {
        return (c.c.a.c.d.a) this.R.n().h();
    }

    public ColorStateList getBackgroundTint() {
        return this.R.p();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().b();
    }

    public int getFabAlignmentMode() {
        return this.U;
    }

    public int getFabAnimationMode() {
        return this.V;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().c();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().d();
    }

    public boolean getHideOnScroll() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.c.a.c.w.i.a(this, this.R);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            s();
            z();
        }
        y();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.U = savedState.f10329c;
        this.f0 = savedState.f10330d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10329c = this.U;
        savedState.f10330d = this.f0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        a.h.c.l.a.a(this.R, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().a(f2);
            this.R.invalidateSelf();
            z();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.R.b(f2);
        getBehavior().a((Behavior) this, this.R.m() - this.R.l());
    }

    public void setFabAlignmentMode(int i2) {
        e(i2);
        a(i2, this.f0);
        this.U = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.V = i2;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().b(f2);
            this.R.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().c(f2);
            this.R.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.W = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final FloatingActionButton v() {
        View w = w();
        if (w instanceof FloatingActionButton) {
            return (FloatingActionButton) w;
        }
        return null;
    }

    public final View w() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).c(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public final boolean x() {
        FloatingActionButton v = v();
        return v != null && v.d();
    }

    public final void y() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (x()) {
                b(actionMenuView, this.U, this.f0);
            } else {
                b(actionMenuView, 0, false);
            }
        }
    }

    public final void z() {
        getTopEdgeTreatment().e(getFabTranslationX());
        View w = w();
        this.R.c((this.f0 && x()) ? 1.0f : 0.0f);
        if (w != null) {
            w.setTranslationY(getFabTranslationY());
            w.setTranslationX(getFabTranslationX());
        }
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: e, reason: collision with root package name */
        public final Rect f10324e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<BottomAppBar> f10325f;

        /* renamed from: g, reason: collision with root package name */
        public int f10326g;

        /* renamed from: h, reason: collision with root package name */
        public final View.OnLayoutChangeListener f10327h;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f10325f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.b(Behavior.this.f10324e);
                int height = Behavior.this.f10324e.height();
                bottomAppBar.f(height);
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f10326g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (r.e(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.Q;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.Q;
                    }
                }
            }
        }

        public Behavior() {
            this.f10327h = new a();
            this.f10324e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            this.f10325f = new WeakReference<>(bottomAppBar);
            View w = bottomAppBar.w();
            if (w != null && !y.J(w)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) w.getLayoutParams();
                fVar.f2446d = 49;
                this.f10326g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (w instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) w;
                    floatingActionButton.addOnLayoutChangeListener(this.f10327h);
                    bottomAppBar.a(floatingActionButton);
                }
                bottomAppBar.z();
            }
            coordinatorLayout.d(bottomAppBar, i2);
            return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10327h = new a();
            this.f10324e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    public final void e(int i2) {
        if (this.U == i2 || !y.J(this)) {
            return;
        }
        Animator animator = this.S;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.V == 1) {
            b(i2, arrayList);
        } else {
            a(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.S = animatorSet;
        animatorSet.addListener(new d());
        this.S.start();
    }

    public boolean f(int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().e()) {
            return false;
        }
        getTopEdgeTreatment().d(f2);
        this.R.invalidateSelf();
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.g0 == null) {
            this.g0 = new Behavior();
        }
        return this.g0;
    }

    public final void s() {
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.S;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    public final void t() {
        ArrayList<i> arrayList;
        int i2 = this.d0 - 1;
        this.d0 = i2;
        if (i2 != 0 || (arrayList = this.e0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void u() {
        ArrayList<i> arrayList;
        int i2 = this.d0;
        this.d0 = i2 + 1;
        if (i2 != 0 || (arrayList = this.e0) == null) {
            return;
        }
        Iterator<i> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, m0), attributeSet, i2);
        this.R = new c.c.a.c.w.h();
        this.d0 = 0;
        this.f0 = true;
        this.k0 = new a();
        this.l0 = new b();
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.BottomAppBar, i2, m0, new int[0]);
        ColorStateList a2 = c.c.a.c.t.c.a(context2, c2, R$styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = c2.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = c2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = c2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = c2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.U = c2.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.V = c2.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.W = c2.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.a0 = c2.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.b0 = c2.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.c0 = c2.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        c2.recycle();
        this.Q = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        c.c.a.c.d.a aVar = new c.c.a.c.d.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        m.b n = m.n();
        n.b(aVar);
        this.R.setShapeAppearanceModel(n.a());
        this.R.d(2);
        this.R.a(Paint.Style.FILL);
        this.R.a(context2);
        setElevation(dimensionPixelSize);
        a.h.c.l.a.a(this.R, a2);
        y.a(this, this.R);
        r.a(this, attributeSet, i2, m0, new c());
    }

    public final void b(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v(), "translationX", d(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    public final float d(int i2) {
        boolean e2 = r.e(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.Q + (e2 ? this.j0 : this.i0))) * (e2 ? -1 : 1);
        }
        return 0.0f;
    }

    public final void b(ActionMenuView actionMenuView, int i2, boolean z) {
        actionMenuView.setTranslationX(a(actionMenuView, i2, z));
    }

    public void a(int i2, List<Animator> list) {
        FloatingActionButton v = v();
        if (v == null || v.c()) {
            return;
        }
        u();
        v.hide(new e(i2));
    }

    public final void a(int i2, boolean z) {
        if (y.J(this)) {
            Animator animator = this.T;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!x()) {
                i2 = 0;
                z = false;
            }
            a(i2, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.T = animatorSet;
            animatorSet.addListener(new f());
            this.T.start();
        }
    }

    public final void a(int i2, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - a(actionMenuView, i2, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new g(actionMenuView, i2, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    public int a(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean e2 = r.e(this);
        int measuredWidth = e2 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f147a & 8388615) == 8388611) {
                if (e2) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((e2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (e2 ? this.i0 : -this.j0));
    }

    public final void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.a(this.k0);
        floatingActionButton.b(new h());
        floatingActionButton.a(this.l0);
    }
}
